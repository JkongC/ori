package com.Jkong.customer;

public class WechatCustomer{
    public String address;
    public boolean takeout;

    public WechatCustomer(String address,boolean takeout){
        this.address = address;
        this.takeout = takeout;
    }

    public void beDelivered(){
        System.out.println("\n-----顾客-----");
        if (takeout) {
            System.out.printf("您的菜品将会尽快送至%s！",address);
        } else {
            System.out.println("您的菜品已经送到您手上！");
        }
    }
}