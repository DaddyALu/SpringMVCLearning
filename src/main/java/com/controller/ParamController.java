package com.controller;

import com.entity.Order;
import com.entity.User;
import com.vo.CollectionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("param")
public class ParamController {

    /*
    * 集合类型的参数接收
    * lambda 表达式  java8新特性 快速遍历 集合     , 泛型推断（定义的地方写泛型，实现的地方不需要写）
    *
    * 前台传递方式：
    *   url?list=zhangsan&list=lisi&list=wangwu （放入对象中作为属性接收集合类型的参数，相当于以对象去接收，直接写对象名(属性名list)就可以）
    *   Map类型传递：url?map['aa']=zhangsan&map['bb']=lisi （'aa'为键，因为是String类型，要加上单引号，等号后面就是对应的值）
    *
    * 注意：
    *   1、springmvc中集合不能直接作为参数接收，但是允许间接接收，将接收的集合类型放入自定义的对象（User、Order、VO）中完成参数接收；
    *   2、springmvc中推荐使用vo进行接收   VO（value object 值对象）  OO（oriented object 面向对象）  DTO（Data transfer object）数据传输对象
    * */
    @RequestMapping("test3")
    public String test3(CollectionVO vo){  //不能用List，因为List是一个接口不能被实例化
        //lambda表达式
        vo.getList().forEach(s -> {
            System.out.println(s);
        });
//        Map<String,String> map = new HashMap<>();  //泛型推断
//        map.forEach((k,v) -> {
//            System.out.println(k);
//            System.out.println(v);
//        });
        return "index";
    }


    /*
    * 数组类型的参数接收
    *
    * 语法：
    *   将要接收的数组作为控制器方法的参数声明即可
    *
    * 前台语法：
    *   要求前台传递的多个参数的参数变量名都要与接收数组变量名一致，springmvc自动将多个变量名放入一个数组中
    *   url?names=zhangsan&names=lisi&names=wangwu
    *
    * */
    @RequestMapping("test2")
    public String test2(String[] names){
        for (String name : names) {
            System.out.println(name);
        }
        return "index";
    }


    /*
    * 对象类型的参数接收
    *
    * 语法：
    *   将要接收的对象，作为控制器方法的形参声明即可
    *
    * 前台传递参数的形式：
    *   只需要保证前台传递的参数名，与接收的对象属性名一致，自动封装传递
    *   url?name=zhangsan&age=23&sex=true&bir=2020/01/01&order.name=lisi&order.add=aabbcc
    *
    * 注意：
    *   1、当接收的零散参数变量与对象中的属性名重名时，会两个都赋值
    *   2、给对象中的对象的属性赋值时，要使用 "对象名.属性名=xxx" 的形式（无论是不是名字重复的属性）
    * */
    @RequestMapping("test1")
    public String test1(User user, String name){
        System.out.println(user);
        System.out.println("姓名："+name);
        //给对象中的对象赋值： "&order.name=lisi"
        System.out.println("order:"+user.getOrder());
        return "index";
    }


    /*
    * 零散类型的参数接收
    *
    * 语法：
    *   将要传的参数的参数名作为方法的形参传递
    *
    * 前台传递形式
    *   url?name=zhangsan&age=23&sex=true&bir=2020/01/01
    *
    * 注意：
    *   1、springmvc默认日期格式：和Spring框架中一样 ---> yyyy/MM/dd/HH:mm:ss
    *   2、通过在方法中代表日期的参数前面，加上"@DateTimeFormat(pattern = 'yyyy-MM-dd')"来限制日期传参时的格式
    *   3、在springmvc中出现400错误，说明传递参数的格式存在问题
    * */
    @RequestMapping("test")
    public String test(String name, Boolean sex, Integer age, Date bir){

        //自定义日期的显示形式
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String bir1 = d.format(bir);
        System.out.println(bir1);

        System.out.println("姓名："+name+"\t性别："+sex+"\t年龄："+age+"\t生日："+bir);
        return "index";
    }

}
