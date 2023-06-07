package com.example.demo8.test;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2023/6/6 - 06 - 06 - 22:49
 * @Description: com.example.demo8.test
 * @version: 1.0
 */
public class MyObject {
    private  String id;
    private String name;
    private int age;
    public String getId() {
        return id;
    }

    public MyObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyObject(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MyObject(String id) {
        this.id = id;
    }
}
