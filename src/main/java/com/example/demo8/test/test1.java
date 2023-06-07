package com.example.demo8.test;
import java.util.*;
/**
 * @Auther: TianWei_18811580953
 * @Date: 2023/6/6 - 06 - 06 - 22:46
 * @Description: com.example.demo8.test
 * @version: 1.0
 */
public class test1 {
    //这是一个main方法，是程序的入口:
    public static void main(String[] args) {
        //将List集合转换为Java对象
        List<Object> list = new ArrayList<>();
        List<MyObject> myObjects = new ArrayList<>();
        for (Object obj : list) {
            Map<String, Object> map = (Map<String, Object>) obj;
            MyObject myObject = new MyObject();
            myObject.setName((String) map.get("name"));
            myObject.setAge((int) map.get("age"));
            myObjects.add(myObject);
        }
    }
}
