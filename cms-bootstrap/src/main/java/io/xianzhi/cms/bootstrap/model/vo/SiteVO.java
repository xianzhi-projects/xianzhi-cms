package io.xianzhi.cms.bootstrap.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 站点出参
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class SiteVO implements Serializable {

    /**
     * 站点ID
     */
    private String id;
    /**
     * 站点名称
     */
    private String siteName;
    /**
     * 站点描述
     */
    private String siteDesc;
    /**
     * 站点图标
     */
    private String siteFavicon;
    /**
     * 站点logo
     */
    private String siteLogo;
    /**
     * 站点域名
     */
    private String siteDomain;
    /**
     * 站点负责人
     */
    private UserVO siteOwner;
    /**
     * 站点备案号
     */
    private String siteRecordNo;
    /**
     * 站点状态
     */
    private String siteStatus;
    /**
     * 站点SEO关键字
     */
    private String siteSeoKeywords;
    /**
     * 站点SEO描述
     */
    private String siteSeoDesc;
    /**
     * 站点SEO标题
     */
    private String siteSeoTitle;

    /**
     * 默认标识
     */
    private Boolean defaultFlag;

    /**
     * 站点排序
     */
    private Integer siteSort;
}
