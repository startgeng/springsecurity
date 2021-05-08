package com.kevin.springsecurity.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-05-08 18:06
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
    }
}
