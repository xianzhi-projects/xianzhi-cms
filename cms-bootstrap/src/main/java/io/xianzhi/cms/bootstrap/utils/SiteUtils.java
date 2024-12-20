package io.xianzhi.cms.bootstrap.utils;

/**
 * 站点工具类
 *
 * @author Max
 * @since 1.0.0
 */
public class SiteUtils {


    private final static ThreadLocal<String> SITE_ID = new ThreadLocal<>();

    /**
     * 私有化构造器
     */
    private SiteUtils() {
    }

    /**
     * 站点ID
     */
    public static final String REQUEST_HEADER_SITE_ID = "X-Site-Id";

    /**
     * 获取当前站点ID
     *
     * @return 站点ID
     */
    public static String getCurrentSiteId() {
        return SITE_ID.get();
    }

    /**
     * 设置站点ID
     *
     * @param siteId 站点ID
     */
    public static void set(String siteId) {
        SITE_ID.set(siteId);
    }

    /**
     * 移除站点ID
     */
    public static void remove() {
        SITE_ID.remove();
    }

}
