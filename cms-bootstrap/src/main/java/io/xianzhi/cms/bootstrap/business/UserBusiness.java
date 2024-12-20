package io.xianzhi.cms.bootstrap.business;

import io.xianzhi.cms.bootstrap.model.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserBusiness {

    /**
     * 获取展示用户信息，比如在列表展示用户名
     *
     * @param userIds 用户ID列表
     * @return 用户信息
     */
    public List<UserVO> getViewUserByIds(List<String> userIds) {
        return List.of();
    }


}
