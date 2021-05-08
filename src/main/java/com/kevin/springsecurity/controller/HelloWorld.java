package com.kevin.springsecurity.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    //方法调用前检查 ROLE_是固定参数
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or has")
    //方法调用后检查
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    //对集合对应的参数或返回值进行过滤
    @PreFilter("")
    @PostFilter("")
    @RequestMapping(value = "role")
    public String role(){
        return "role auth";
    }

    /**
     * id 小于10
     * username 必须与当前登录用户相同
     * @param id
     * @return
     */
    @PreAuthorize("#id<10 and principal.username.equals( #username) and #user.username.equals('abc')")
    @PostAuthorize("returnObject%2==0")  //看返回的值是否是偶数
    public Integer test(Integer id, String username, User user){
        //.....
        return id;
    }

    //传入的参数是整数
    @PreFilter("filterObject%2==0")
    //传入的参数必须被4整除
    @PostFilter("filterObject%4==0")
    public List<Integer> test1(List<Integer> list, String username, User user){
        //.....
        return list;
    }
}
