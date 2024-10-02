package com.Jkong.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class given_test {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        List<Integer> squaresList = numbers.stream()
                .map(i -> i * i)	//你可能会对这种表达式有兴趣
                .sorted((x, y) -> y - x)	//你可能会对这种表达式有兴趣
                .toList();

        System.out.println(squaresList);
    }
}