/*
 * Copyright 2024 XianZhi Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import type {RouteRecordRaw} from 'vue-router';
import {createRouter, createWebHistory} from 'vue-router';
import Layout from '@/layout/Index.vue';
import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import {message} from "ant-design-vue";

// 定义基础路由配置
const baseRoutes: RouteRecordRaw[] = [
  {
    path: "/",
    redirect: "/admin/dashboard",
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/authentication/Login.vue'),
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/admin',
    name: 'admin',
    component: Layout,
    children: [],
  },
  {
    path: '/:pathMatch(.*)*',
    component: () => import('@/views/error/404.vue')
  }
];

// 创建Vue Router实例
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: baseRoutes,
  // 使用浏览器的回退或者前进时，重新返回时保留页面滚动位置，跳转页面的话，不触发。
  scrollBehavior(to, from, savePosition) {
    if (savePosition) {
      return savePosition;
    } else {
      return { top: 0 };
    }
  }
});

// 获取所有的模块路由（以懒加载的方式），用于后续根据资源动态匹配组件
const modulesRoutes = import.meta.glob("/src/views/**/*.vue");
const modulesRoutesKeys = Object.keys(modulesRoutes);

// 路由前置守卫，用于处理路由跳转前的各种逻辑，如权限验证、动态路由加载等
router.beforeEach(async (to, from, next) => {
  NProgress.start();
  const userStore = useUserStore();
  const routerStore = useRouterStore();

  // 判断用户是否登录
  if (userStore.isLogin) {
    if (to.path === '/login') {
      // 已登录状态下访问登录页，直接放行，可考虑跳转到默认页面（如首页）
      next();
      return;
    }

    // 检查动态路由是否已经加载，如果未加载则进行加载操作
    if (!routerStore.routerList || routerStore.routerList.length === 0) {
      try {
        // 获取用户资源数据，这里应确保接口调用的正确性和错误处理
        const { data } = await getCurrentUserResource();
        if (!data) {
          message.error('获取用户信息失败');
          // 可以增加更友好的错误提示及处理，比如延迟重定向或者提供重试机制等
          setTimeout(() => {
            next({ path: '/login' });
          }, 3000);
          return;
        }

        // 根据获取到的资源数据生成动态路由配置
        const asyncRouter = generateRoutes(data);
        routerStore.setRouterList(asyncRouter.children);

        // 动态添加路由到路由实例中，添加时进行必要的错误处理
        addRoutesSafely(asyncRouter);

        // 打印调试信息，方便排查问题，可在生产环境移除或优化
        console.log(router.getRoutes());

        // 重新导航到当前路由，确保新添加的路由能正确匹配和显示
        next({...to, replace: true });
      } catch (error) {
        console.error('动态路由加载出错:', error);
        message.error('动态路由加载出现问题，请联系管理员');
        // 出现异常时重定向到登录页，也可考虑更合理的错误处理方式
        next({ path: '/login' });
      }
    } else {
      next();
    }
  } else {
    // 用户未登录时，访问非登录页则重定向到登录页，并传递当前访问的路径作为查询参数，方便登录后跳转回原页面
    if (to.path === '/login') {
      next();
    } else {
      next({ path: '/login', query: { redirect: to.path } });
      message.error('请先登录');
    }
  }
});

// 路由后置守卫，用于在路由跳转完成后执行一些操作，比如结束进度条
router.afterEach(() => {
  NProgress.done();
});

// 根据用户资源数据生成动态路由配置，返回包含动态子路由的/admin路由配置对象
function generateRoutes(items: Array<ResourceVO>): RouteRecordRaw {
  // 查找/admin基础路由配置，后续基于它来构建动态子路由
  const adminRoute = baseRoutes.find(route => route.path === '/admin');
  if (!adminRoute) {
    throw new Error('Admin route not found');
  }

  // 创建一个新的admin路由副本，以保持路由配置的不可变性，同时添加动态子路由
  return {
    ...adminRoute,
    children: items.map(item => convertChildren(item))
  };
}

// 将单个资源项转换为对应的路由配置，处理菜单、目录等不同类型资源对应的路由结构和组件加载
function convertChildren(item: ResourceVO): RouteRecordRaw {
  const route: RouteRecordRaw = {
    path: item.resourceKey,
    name: item.resourceName,
    meta: {
      icon: item.menuIcon,
      showFlag: item.showFlag,
      resourceType: item.resourceType
    },
    component: undefined,
    children: [],
  };
  if (item.resourceType === ResourceType.MENU) {
    const index = item?.menuComponent
      ? modulesRoutesKeys.findIndex(ev => ev.includes(item.menuComponent))
      : modulesRoutesKeys.findIndex(ev => ev.includes(item.resourceKey));
    if (index!== -1) {
      route.component = modulesRoutes[modulesRoutesKeys[index]];
    } else {
      console.error(`Component not found for key: ${item.resourceKey}`);
    }
    return route;
  }

  if (item.resourceType === ResourceType.DIRECTORY && item.children && item.children.length > 0) {
    route.children = item.children.map(child => convertChildren(child));
  }
  return route;
}

// 安全地添加路由到路由实例中，捕获并处理可能出现的添加路由异常
function addRoutesSafely(routes: RouteRecordRaw | RouteRecordRaw[]) {
  const routesArray = Array.isArray(routes)? routes : [routes];
  routesArray.forEach(route => {
    try {
      router.addRoute(route);
    } catch (error) {
      console.error('添加路由时出错:', error);
    }
  });
}

export default router;
