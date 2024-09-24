package com.Jkong;

import com.Jkong.eat.*;
import com.Jkong.customer.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManageSystem ms = new ManageSystem();
        System.out.println("欢迎使用点菜系统！");
        //开始循环！
        while (true) {
            System.out.println("\n输入1开始点菜，输入2退出！");
            switch (sc.nextInt()) {
                case 2 -> {return;}
                default -> {
                    System.out.println("请输入1或2！");
                }
                case 1 -> {
                    customerInter(ms);
                }
            }
        }
    }

    //顾客的交互
    public static void customerInter(ManageSystem ms){
        int dishID = 0;
        int customerType;
        String address = "";
        boolean takeout = false;
        int tableID = 0;

        ArrayList<Order> dishes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n-----顾客点菜-----");
        System.out.println("您是微信点餐还是现场点餐？微信0，现场其他数字");
        customerType = sc.nextInt();

        //询问顾客信息，预记录顾客类型
        if (customerType == 0){
            System.out.println("您的地址是？");
            address = sc.next();
            System.out.println("您是否外带？外带请输入1，否则输入其他数字");
            switch (sc.nextInt()) {
                case 1 -> {takeout = true;}
                default -> {takeout = false;}
            }
        } else {
            System.out.println("您的桌号是？");
            tableID = sc.nextInt();
        }

        //确认点菜列表
        while (true) {
            System.out.println("");
            System.out.println("您要点什么菜？0代表番茄炒蛋，1代表糖醋排骨。");
            switch (sc.nextInt()) {
                //我想要在这里用的dish类的方法，都必须写在Order接口内，因为这里的dishes数组存的是Order
                case 0 -> {
                    dishes.add(new Dish_0());
                    System.out.println("您点了"+dishes.get(dishID).getName());
                    System.out.print("菜品介绍：");
                    dishes.get(dishID).viewProfile();
                }
                case 1 -> {
                    dishes.add(new Dish_1());
                    System.out.println("您点了"+dishes.get(dishID).getName());
                    System.out.print("菜品介绍：");
                    dishes.get(dishID).viewProfile();
                }
            }
            System.out.println("您点好了吗？输入0以确认，输入其他继续选菜");
            if (sc.hasNextInt()) {
                if (sc.nextInt() == 0) {
                    break;
                }
            }
        }

        System.out.println("您点了"+dishes.size()+"道菜，正在交给厨师......");

        //根据顾客类型创建不同的对象交给manageOrder
        if (customerType == 0){
            WechatCustomer customer = new WechatCustomer(address,takeout);
            ms.manageOrder(dishes,customer);
        } else {
            TableCustomer customer = new TableCustomer(tableID);
            ms.manageOrder(dishes,customer);
        }
    }
}