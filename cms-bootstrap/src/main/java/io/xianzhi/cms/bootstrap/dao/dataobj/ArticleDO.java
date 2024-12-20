package io.xianzhi.cms.bootstrap.dao.dataobj;

import com.baomidou.mybatisplus.annotation.TableName;
import io.xianzhi.boot.mybatis.plus.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章实体
 *
 * @author Max
 * @since 1.0.0
 */
@Data
@TableName("xz_article")
@EqualsAndHashCode(callSuper = true)
public class ArticleDO extends BaseDO {
}
