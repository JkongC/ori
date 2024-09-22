package com.Jkong.NormalTest;
public class Person {
    private String name;
    protected int age;
    int sex;

    public Person(String name,int age,int sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private void eat() {
        System.out.println(name+"正在吃东西");
    }

    private void sleep() {

    }

    private void dadoudou() {

    }

    void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}