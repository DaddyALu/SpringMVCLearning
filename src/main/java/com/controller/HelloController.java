package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller /*要到springmvc配置文件中开启注解扫描，才能在工厂中创建这个对象*/
@RequestMapping("hello") /*加不加"/"都行*/
public class HelloController {

    //开发第一个方法
    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello springmvc");
        return "index";//页面逻辑名
    }
}
