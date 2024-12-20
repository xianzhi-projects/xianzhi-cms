package io.xianzhi.cms.bootstrap.controller;

import io.xianzhi.cms.bootstrap.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    /**
     * 文章服务
     */
    private final ArticleService articleService;
}
