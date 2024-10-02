package com.Jkong.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test_one {
    public static void main(String[] args) {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
        Stream<String> stream = strings.stream();
        //调用流API的方法，例如我们希望最多有4个元素
        Stream<String> limit = stream.limit(4);
        //最后我们打印结果
        System.out.println("limit = " + limit);
        //将流转成List再打印
        System.out.println(limit.collect(Collectors.toList()));
        /*
        这行代码是一样的效果
        System.out.println(limit.toList());
         */
    }
}
