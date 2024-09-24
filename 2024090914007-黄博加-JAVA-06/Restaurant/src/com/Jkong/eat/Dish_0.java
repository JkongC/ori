package com.Jkong.eat;
public class Dish_0 extends Dish{
    public Dish_0(){
        super("番茄炒蛋",7.90,"番茄炒蛋煮法：番茄与蛋混合爆炒！");
    }

    @Override
    public void viewProfile(){
        System.out.println("番茄炒蛋是经典菜肴，十分健康美味。");
    }
}