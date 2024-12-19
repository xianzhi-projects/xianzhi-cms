package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 站点持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface SiteMapper extends BaseMapper<SiteDO> {
}
