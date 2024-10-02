package com.Jkong.file_io;

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

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("num.txt"))) {
            for (int i = 0; i < amount; i++) {
                bw.write(Integer.toString(rd.nextInt(5000)));
                bw.newLine();
                bw.flush();
            }
        } catch(IOException e) {
            System.err.println("出错了！");
        }
    }
}