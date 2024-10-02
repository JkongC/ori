package com.Jkong.test;

import java.util.Random;

public class test_four {
    public static void main(String[] args) {
        Random rand = new Random();
        rand.ints(100,1000).limit(10).sorted().forEach(System.out::println);
    }
}
