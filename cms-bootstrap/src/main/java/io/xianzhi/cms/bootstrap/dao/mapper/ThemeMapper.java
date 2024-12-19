package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.xianzhi.cms.bootstrap.dao.dataobj.ThemeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 主题信息持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface ThemeMapper extends BaseMapper<ThemeDO> {
}
