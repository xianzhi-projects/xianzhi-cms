package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.cms.bootstrap.dao.dataobj.UserColumnDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户栏目
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface UserColumnMapper extends BaseMapper<UserColumnDO> {
}
