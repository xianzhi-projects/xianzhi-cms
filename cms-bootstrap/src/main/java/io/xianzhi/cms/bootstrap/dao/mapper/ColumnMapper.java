package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.cms.bootstrap.dao.dataobj.ColumnDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 栏目持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface ColumnMapper extends BaseMapper<ColumnDO> {
}
