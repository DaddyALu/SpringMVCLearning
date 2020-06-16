package com.vo;

import java.util.List;
import java.util.Map;

public class CollectionVO {

    private List<String> list;
    private Map<String,String> map;


    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
