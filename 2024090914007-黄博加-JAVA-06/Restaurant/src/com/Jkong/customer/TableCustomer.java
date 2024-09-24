package com.Jkong.customer;

public class TableCustomer{
    public int tableID;

    public TableCustomer(int tableID){
        this.tableID = tableID;
    }

    public void beDelivered() {
        System.out.println("\n-----顾客-----");
        System.out.println("您的菜品已送至"+tableID+"号桌！");
    }
}