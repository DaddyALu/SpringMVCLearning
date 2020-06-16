package com.entity;

public class Order {

    private String id;
    private String name;
    private String add;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", add='" + add + '\'' +
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

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public Order(String id, String name, String add) {
        this.id = id;
        this.name = name;
        this.add = add;
    }

    public Order() {
    }
}
