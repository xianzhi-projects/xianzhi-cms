package io.xianzhi.cms.bootstrap.controller;

import io.xianzhi.cms.bootstrap.service.ColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 栏目接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/column")
public class ColumnController {
    /**
     * 栏目服务
     */
    private final ColumnService columnService;
}
