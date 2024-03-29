package com.evildoer.exam.common.utils;

import com.evildoer.exam.common.domain.HaloConstant;
import com.evildoer.exam.common.function.CacheSelector;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

/**
 * FEBS工具类
 */
@Slf4j
public class HaloUtils {

    /**
     * 缓存查询模板
     *
     * @param cacheSelector    查询缓存的方法
     * @param databaseSelector 数据库查询方法
     * @return T
     */
    public static <T> T selectCacheByTemplate(CacheSelector<T> cacheSelector, Supplier<T> databaseSelector) {
        try {
            log.debug("query data from redis ······");
            // 先查 Redis缓存
            T t = cacheSelector.select();
            if (t == null) {
                // 没有记录再查询数据库
                return databaseSelector.get();
            } else {
                return t;
            }
        } catch (Exception e) {
            // 缓存查询出错，则去数据库查询
            log.error("redis error：", e);
            log.debug("query data from database ······");
            return databaseSelector.get();
        }
    }

    /**
     * 获取当前操作用户
     *
     * @return 用户信息
     */
//    public static User getCurrentUser() {
//        String token = (String) SecurityUtils.getSubject().getPrincipal();
//        String username = JWTUtil.getUsername(token);
//        UserService userService = SpringContextUtil.getBean(UserService.class);
//        CacheService cacheService = SpringContextUtil.getBean(CacheService.class);
//
//        return selectCacheByTemplate(() -> cacheService.getUser(username), () -> userService.findByName(username));
//    }

    /**
     * token 加密
     *
     * @param token token
     * @return 加密后的 token
     */
    public static String encryptToken(String token) {
        try {
            EncryptUtils encryptUtils = new EncryptUtils(HaloConstant.TOKEN_CACHE_PREFIX);
            return encryptUtils.encrypt(token);
        } catch (Exception e) {
            log.info("token加密失败：", e);
            return null;
        }
    }

    /**
     * token 解密
     *
     * @param encryptToken 加密后的 token
     * @return 解密后的 token
     */
    public static String decryptToken(String encryptToken) {
        try {
            EncryptUtils encryptUtils = new EncryptUtils(HaloConstant.TOKEN_CACHE_PREFIX);
            return encryptUtils.decrypt(encryptToken);
        } catch (Exception e) {
            log.info("token解密失败：", e);
            return null;
        }
    }

}
