package com.Jkong.File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class NumInitializer {
    public static void main(String[] args) {
        int amount = 0;
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.println("请输入数据个数");
        amount = sc.nextInt();

        try {
            for (int i = 0; i < amount; i++) {
                writenum(rd.nextInt(5000));
            }
        } catch(IOException e) {
            System.err.println("出错了！");
            return;
        }
    }

    public static void writenum(int num) throws IOException{
        /*FileWriter我一开始只写了文件名，没有写true，然后发现每次文件里
        都只有一个数字。遂了解到，它每次都会从文件开头开始写入，覆盖了上一次写入的数字。
        由于这些Writer的构造都可能会抛出IOException，所以我想到的解决方案：

        1. 查文档发现，可以使用FileWriter的另一种构造方法，让它从文件末尾开始写入
        2. 把循环也放到writenum方法里（或者全塞到main方法的try-catch里），一直用同一个BufferedWriter

        这里方法1更直接一些，故采用（如果每次打开程序都想重新写入，那么似乎要用方法二）
         */

        /**写完再记：实际上可以写成和NumReader一样，也就是一个main方法解决，使用try-with-
         * resources，这样还省得对象的反复创建。其实能够感觉到这个类执行起来有点慢
         */
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt",true));
        String towrite = Integer.toString(num);
        writer.write(towrite);
        writer.newLine();
        writer.flush();
    }
}