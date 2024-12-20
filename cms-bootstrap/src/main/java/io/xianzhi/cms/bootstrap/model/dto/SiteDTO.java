package io.xianzhi.cms.bootstrap.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 站点入参
 *
 * @author Max
 * @since 1.0.0
 */
@Data
public class SiteDTO implements Serializable {

    /**
     * 站点排序
     */
    private Integer siteSort;
}
