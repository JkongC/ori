package com.Jkong.NormalTest;
public class Behaviour {
    public static void main(String[] args) {
        //利用构造方法给name，age，sex赋了值
        Person xiaoming = new Person("小明",18,1);
        xiaoming.name = "xm";
        xiaoming.eat();
        xiaoming.age = 1;
    }
}