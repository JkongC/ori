package com.Jkong.NormalTest;
public class BehaviourTest {
    public static void main(String[] args) {
        //利用构造方法给name，age，sex赋了值
        Person xiaoming = new Person("小明",18,1);
        xiaoming.setName("xm");
        System.out.println(xiaoming.getName());
        xiaoming.age = 5;
        System.out.println(xiaoming.age);
        xiaoming.sex = 2;
    }
}