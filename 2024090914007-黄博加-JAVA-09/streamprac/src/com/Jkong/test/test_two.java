package com.Jkong.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test_two {
    public static void main(String[] args) {
        List<Integer> numlist = Arrays.asList(5,9,4,5,4,1,8,5,2,5,7,5,7,8,8,1);
        Stream<Integer> stream = numlist.stream();
        List<Integer> newlist = stream.filter(n -> n != 5).map(n -> n * n).distinct().sorted().toList();
        System.out.println(newlist);



    }
}