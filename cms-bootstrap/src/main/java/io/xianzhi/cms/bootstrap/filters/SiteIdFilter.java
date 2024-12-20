package io.xianzhi.cms.bootstrap.filters;

import io.xianzhi.cms.bootstrap.utils.SiteUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 站点ID过滤器
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
public class SiteIdFilter extends OncePerRequestFilter {
    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request     请求
     * @param response    响应
     * @param filterChain 过滤器链
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取站点ID
        String siteId = request.getHeader(SiteUtils.REQUEST_HEADER_SITE_ID);
        SiteUtils.set(siteId);
        try {
            filterChain.doFilter(request, response);
        } finally {
            // 移除站点ID
            SiteUtils.remove();
        }
    }
}
