package io.xianzhi.cms.bootstrap.business;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xianzhi.cms.bootstrap.dao.dataobj.FileDO;
import io.xianzhi.cms.bootstrap.dao.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 文件业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class FileBusiness extends ServiceImpl<FileMapper, FileDO> {
}
