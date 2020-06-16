package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//用来测试forward和redirect跳转
@Controller
@RequestMapping("/forwardAndRedirect")
public class ForwardAndRedirectController {

    //Controller跳转Controller
    /**
     * 使用redirect跳转到相同Controller中不同方法
     * 注意: 使用springmvc提供关键字    redirect:
     * 语法: return "redirect:/跳转类上@requestMapping/跳转类中方法@RequestMapping路径"
     */
    @RequestMapping("test3")
    public String test3(){
        System.out.println("redirect same com.controller");
        return "redirect:/hello/hello";//重定向跳转相同controller中不同方法
    }

    /**
     * 使用forward跳转到相同controller中不同方法
     *   注意:使用springmvc提供关键字   forward:
     *   语法: return "forward:/跳转类上@requestMapping的路径/跳转类中方法上@requestMapping的路径"
     */
    @RequestMapping("test2")
    public String test2(){
        System.out.println("forward same com.controller");
        return "forward:/forwardAndRedirect/test";//跳转控制器路径
    }

    //Controller跳转页面
    /**
     * 使用redirect跳转到页面
     *   注意: 如果想要使用重定向方式跳转页面,必须的使用springmvc提供关键字 redirect: （使用重定向跳转不会经过视图解析器）
     *   语法: return "redirect:视图全路径"   ====> return "redirect:/index.jsp"
     *
     */
    @RequestMapping("test1")
    public String test1(){
        System.out.println("redirect page");
        return "redirect:/index.jsp";//重定向跳转
    }

    /**
     * 用来测试controller到页面之间forward跳转
     *
     *  默认就是forward跳转
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("forward page");
        return "index";//使用forward
    }

}
