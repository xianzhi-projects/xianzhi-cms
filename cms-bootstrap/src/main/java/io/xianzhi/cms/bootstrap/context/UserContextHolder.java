package io.xianzhi.cms.bootstrap.context;

import io.xianzhi.core.content.ContextHolder;

/**
 * 用户信息上下文
 *
 * @author Max
 * @since 1.0.0
 */
public class UserContextHolder extends ContextHolder {

    /**
     * 获取当前用户ID
     *
     * @return 当前用户ID
     */
    public static String getCurrentUserId() {
        return getContextOrThrow().getUniqueKey();
    }
}
