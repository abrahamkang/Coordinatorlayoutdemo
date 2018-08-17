package com.example.administrator.coordinatorlayoutdemo.bean;

/**
 * Created by Administrator on 2018/8/17 0017.
 */

public class Tab1Bean extends BaseBean {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Tab1Bean(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
