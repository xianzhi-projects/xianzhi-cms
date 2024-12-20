package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.cms.bootstrap.dao.dataobj.RoleResourceDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色资源关联持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface RoleResourceMapper extends BaseMapper<RoleResourceDO> {
}
