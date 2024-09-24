package com.Jkong.eat;
public class Dish_1 extends Dish{
    public Dish_1(){
        super("糖醋排骨",15.80,"糖醋排骨煮法：慢炖出细活，煮至收汁！");
    }

    @Override
    public void viewProfile(){
        System.out.println("酸酸甜甜，美味又补蛋白质！");
    }
}