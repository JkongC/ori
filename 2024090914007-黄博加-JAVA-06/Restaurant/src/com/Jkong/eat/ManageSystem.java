package com.Jkong.eat;

import com.Jkong.customer.TableCustomer;
import com.Jkong.customer.WechatCustomer;

import java.util.List;

public class ManageSystem {
    public int OrderNum = 1;

    public <T> void manageOrder(List<Order> dishes,T customer){
        WechatCustomer Wc;
        TableCustomer Tc;

        System.out.println("\n-----厨师界面-----");
        System.out.println("");

        for (int i = 0; i < dishes.size(); i++) {
            if (!dishes.get(i).check()) {
                System.out.println("原料不足，取消订单！");
                this.OrderNum++;
                return;
            }
        }

        for (int i = 0; i < dishes.size(); i++) {
            dishes.get(i).cook();
        }

        System.out.println("订单编号为"+this.OrderNum);

        if (customer instanceof WechatCustomer){
            Wc = (WechatCustomer) customer;
            Wc.beDelivered();
        } else {
            Tc = (TableCustomer) customer;
            Tc.beDelivered();
        }
    }
}
