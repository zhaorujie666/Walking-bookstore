package com.xzsd.app.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>密码工具类</p>
 * <p>创建日期：2018-01-11</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class PasswordUtils {

    /**
     * 生成加密后的密码
     *
     * @param rawPassword 原密码
     * @return 加密后的密码
     */
    public static String generatePassword(String rawPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    /**
     * 解密（判断密码是否相同）
     *
     * @param rawPassword 未加密的密码
     * @param encodedPassword 已加密的密码
     * @return
     */
    public static boolean equalPassword(String rawPassword, String encodedPassword){
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        return bcryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }
}
