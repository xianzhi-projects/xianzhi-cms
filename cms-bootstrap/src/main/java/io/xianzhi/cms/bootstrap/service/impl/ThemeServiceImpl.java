package io.xianzhi.cms.bootstrap.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xianzhi.cms.bootstrap.dao.dataobj.ThemeDO;
import io.xianzhi.cms.bootstrap.dao.mapper.ThemeMapper;
import io.xianzhi.cms.bootstrap.service.ThemeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 主题接口实现
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ThemeServiceImpl extends ServiceImpl<ThemeMapper, ThemeDO> implements ThemeService {

}
