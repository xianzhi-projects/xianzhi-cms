package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.cms.bootstrap.dao.dataobj.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
