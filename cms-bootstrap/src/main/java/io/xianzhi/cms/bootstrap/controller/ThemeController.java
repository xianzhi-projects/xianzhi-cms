package io.xianzhi.cms.bootstrap.controller;

import io.xianzhi.cms.bootstrap.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主题接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/theme")
public class ThemeController {

    private final ThemeService themeService;
}
