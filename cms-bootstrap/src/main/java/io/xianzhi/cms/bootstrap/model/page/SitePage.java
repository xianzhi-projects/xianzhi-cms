package io.xianzhi.cms.bootstrap.model.page;

import io.xianzhi.core.base.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 站点查询条件
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SitePage extends Page implements Serializable {

    /**
     * 站点名称
     */
    private String siteName;
    /**
     * 站点域名
     */
    private String siteDomain;
    /**
     * 站点描述
     */
    private String siteDesc;
    /**
     * 站点状态
     */
    private String siteStatus;
    /**
     * 站点负责人
     */
    private String siteOwner;
}
