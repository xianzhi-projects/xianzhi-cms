package io.xianzhi.cms.bootstrap.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import io.xianzhi.boot.mybatis.plus.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 栏目实体
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName("xz_column")
@EqualsAndHashCode(callSuper = true)
public class ColumnDO extends BaseDO {
}
