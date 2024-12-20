package io.xianzhi.cms.bootstrap.business;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xianzhi.cms.bootstrap.dao.dataobj.ArticleDO;
import io.xianzhi.cms.bootstrap.dao.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 文章业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ArticleBusiness extends ServiceImpl<ArticleMapper, ArticleDO> {
}
