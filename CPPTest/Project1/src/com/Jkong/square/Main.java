package com.Jkong.square;

public class Main {
    static {
        System.loadLibrary("PrintSquare");
    }

    public static void main(String[] args) {
        PrintSquare.printsqr();
    }
}