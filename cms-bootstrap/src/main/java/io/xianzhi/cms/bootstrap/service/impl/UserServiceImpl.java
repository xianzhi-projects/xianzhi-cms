package io.xianzhi.cms.bootstrap.service.impl;

import io.xianzhi.cms.bootstrap.business.UserBusiness;
import io.xianzhi.cms.bootstrap.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    /**
     * 用户业务类
     */
    private final UserBusiness userBusiness;
}
