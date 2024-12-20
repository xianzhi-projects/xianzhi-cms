<template>
  <a-layout>
    <Sider/>
    <a-layout>
      <Header/>
      <Content/>
      <Footer/>
    </a-layout>
  </a-layout>
</template>
<script lang="ts" setup>


import Sider from "@/layout/components/Sider.vue";
import Header from "@/layout/components/Header.vue";
import Content from "@/layout/components/Content.vue";
import Footer from "@/layout/components/Footer.vue";
</script>
<style scoped>
#components-layout-demo-responsive .logo {
  height: 32px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px;
}

</style>
