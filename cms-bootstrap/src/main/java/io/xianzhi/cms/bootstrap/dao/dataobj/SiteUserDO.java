package io.xianzhi.cms.bootstrap.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import io.xianzhi.boot.mybatis.plus.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 站点用户关联实体
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName(value = "xz_site_user")
@EqualsAndHashCode(callSuper = true)
public class SiteUserDO extends BaseDO {

    /**
     * 站点ID
     */
    private String siteId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 默认站点标识
     */
    private Boolean defaultFlag;
}
