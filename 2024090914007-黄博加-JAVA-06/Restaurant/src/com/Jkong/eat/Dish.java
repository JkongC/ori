package com.Jkong.eat;
public abstract class Dish implements Order{
    private String name;
    private double price;
    private String cookmethod;

    public Dish(String name,double price,String cookmethod){
        this.name = name;
        this.price = price;
        this.cookmethod = cookmethod;
    }

    public abstract void viewProfile();

    public void cook(){
        System.out.println(this.cookmethod);
    };

    @Override
    public String getName(){
        return this.name;
    }

    public String getCookmethod(){
        return this.cookmethod;
    }
}