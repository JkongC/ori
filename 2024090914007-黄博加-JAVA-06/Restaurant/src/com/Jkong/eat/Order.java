package com.Jkong.eat;
import java.util.Random;
public abstract interface Order{
    public default boolean check(){
        Random rd = new Random();
        switch (rd.nextInt(2)){
            case 0 -> {
                return false;
            }
            case 1 -> {
                return true;
            }
            default -> {
                return true;
            }
        }
    }

    public abstract String getName();

    public abstract void cook();

    public abstract void viewProfile();
}