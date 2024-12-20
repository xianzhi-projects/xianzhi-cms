package io.xianzhi.cms.bootstrap.controller;

import io.xianzhi.cms.bootstrap.service.PluginsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 插件接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/plugins")
public class PluginsController {
    /**
     * 插件服务
     */
    private final PluginsService pluginsService;
}
