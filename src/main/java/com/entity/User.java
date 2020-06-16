package com.entity;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private String id;
    private String name;
    private Integer age;
    private Date bir;

//    //接收参数放入集合中
//    private ArrayList<String> list;
//    public ArrayList<String> getList() {
//        return list;
//    }
//    public void setList(ArrayList<String> list) {
//        this.list = list;
//    }

    //对象中还有别的对象
    private Order order;
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    //自己类中的toString只包含自己类中的属性就行了，不要吧order也包含在里面（避免出现两个类相互循环打印的情况）
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bir=" + bir +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    //提供无参、有参构造方法
    public User() {
    }

    public User(String id, String name, Integer age, Date bir) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bir = bir;
    }
}
