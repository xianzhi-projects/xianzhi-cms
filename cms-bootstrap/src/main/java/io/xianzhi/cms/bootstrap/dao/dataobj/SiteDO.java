package io.xianzhi.cms.bootstrap.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import io.xianzhi.boot.mybatis.plus.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 站点实体
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName(value = "xz_site")
@EqualsAndHashCode(callSuper = true)
public class SiteDO extends BaseDO {

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
    private String siteOwner;
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
     * 站点排序
     */
    private Integer siteSort;


}
