package io.xianzhi.cms.bootstrap.controller;

import io.xianzhi.cms.bootstrap.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资源接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/resource")
public class ResourceController {


    private final ResourceService resourceService;
}
