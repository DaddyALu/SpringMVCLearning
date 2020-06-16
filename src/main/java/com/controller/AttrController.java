package com.controller;

import com.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("attr")
public class AttrController {

    /*
    * 使用redirect跳转页面传递数据
    *
    *   1、参数较少时优先考虑使用url后跟问号的方式传参
    *   2、较多时使用session传递值
    * */
    @RequestMapping("test1")
    public String test1( HttpServletRequest req) throws UnsupportedEncodingException {
        System.out.println("redirect transfer data");
        String id = "123中国";
        String name = "lisi";
        req.getSession().setAttribute("id",id);
        //参数较少时，使用问号传递参数
        return "redirect:/attr.jsp?id="+ URLEncoder.encode(id,"UTF-8")+"&name="+name; //中文需要转码
    }


    /*
    * 使用forward跳转，使用request传递数据
    *   1、获取request对象：httpServletRequest，直接在当前的控制器方法中声明该对象
    *   2、获取response对象：httpServletResponse，同上
    *
    * springmvc对request对象进行了进一步的封装，封装成model对象，封装了request作用域（在forward跳转时才用得到）
    *   目前体验不到效果，model更好的集成了模版视图（freemark，thymeleaf）
    * */
    @RequestMapping("test")
    public String test(HttpServletRequest req, Model model){ //获取request作用域
        //1、收集数据
        //2、调用业务方法
        System.out.println("service");
        String name = "xiaoming";
        User user = new User("10010","zhangsan",23,new Date());
        User user1 = new User("10010","zhangsan",23,new Date());
        List<User> list = Arrays.asList(user, user1); //快速地把不定长的参数转换成一个List集合（这样就不需要用"list.add"去一个一个的添加元素）
        //获取request作用域传递数据
        req.setAttribute("name",name);
        req.setAttribute("user",user);
        req.setAttribute("list",list);
//        model.addAttribute("name",name);

        //3、跳转页面
        return "attr";
    }


}
