package com.xpf.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: Xia
 * @Date: 2020/1/1 13:15
 * @Email：x2358114512@163.com
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
        // $2a$10$dXjmpr.ZrZidp2Ce4GWNqeGEsEO9V606Z61h8NgXLMbVxPhrUuuou
    }

    public static void main(String[] args) {
        String password = "123";
        String pwd = encodePassword(password);
        System.out.println(pwd);
    }
}
