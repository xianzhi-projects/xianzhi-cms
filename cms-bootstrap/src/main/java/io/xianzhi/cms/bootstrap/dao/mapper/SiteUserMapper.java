package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 站点用户持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface SiteUserMapper extends BaseMapper<SiteUserDO> {
}
