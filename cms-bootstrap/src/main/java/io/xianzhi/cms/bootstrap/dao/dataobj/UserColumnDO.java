package io.xianzhi.cms.bootstrap.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import io.xianzhi.boot.mybatis.plus.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户栏目关联
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName("xz_user_column")
@EqualsAndHashCode(callSuper = true)
public class UserColumnDO extends BaseDO {
}
