package com.kevin.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevin
 * @version 1.0
 * @date 2021-05-08 16:23
 */
@RestController
//启用了权限的注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HelloWorld {

    @RequestMapping(value = "/")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/hello")
    public String helloworld(){
        return "helloworld";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "role")
    public String role(){
        return "role auth";
    }
}
