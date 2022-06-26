package com.sst;

import com.sst.model.Human;

public class App {
    public static void main(String[] args) {
        Human obj1= new Human();
        obj1.setName("SiThu");

        Human obj2 =new Human();
        obj2.setName("SiThu");

        System.out.println(obj1.equals(obj2));

    }
}
