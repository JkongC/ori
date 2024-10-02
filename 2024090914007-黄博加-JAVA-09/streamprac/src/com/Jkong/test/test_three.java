package com.Jkong.test;

import java.util.ArrayList;
import java.util.List;

public class test_three {
    public static void main(String[] args) {
        /* 下面这段会报错
        TestClass tc = new TestClass();
        List<Object> list = new ArrayList<>();
        list.add(tc);
        list.get(0).printA();
         */

        /* 这段同样会报错
        TestClass tc = new TestClass();
        ArrayList list = new ArrayList();
        list.add(tc);
        list.get(0).printA;
         */

        List<? super TestClass> list = new ArrayList<>();
        list.add(new TestClass());
        //list.getFirst().printA();   这样写会报错
        //这样写不会报错
        ((TestClass) list.getFirst()).printA();

        List<? super TestClass> list2 = new ArrayList<TestClass>();
        list2.add(new TestClass());
        //list2.getFirst().printA(); 同样报错
    }
}
