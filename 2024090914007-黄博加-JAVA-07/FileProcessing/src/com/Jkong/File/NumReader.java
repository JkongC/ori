package com.Jkong.File;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class NumReader {
    public static void main(String[] args) {
        double total = 0;
        int amount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            //如果第一次都没办法读，说明文件为空，抛出错误
            if (!reader.ready()) {
                throw new EmptyFileException("文件为空！");
            }

            while (true) {
                //是否已经读完？
                if (reader.ready()) {
                    total += Integer.parseInt(reader.readLine());
                    amount++;
                } else {
                    break;
                }
            }

            System.out.println("这"+amount+"个数据的平均数是："+(total/amount));
        } catch (Exception e){
            if (e instanceof FileNotFoundException) {
                System.out.println("没有找到目标文件！");
            } else if (e instanceof NumberFormatException) {
                System.out.println("数据的格式有误！");
            } else if (e instanceof EmptyFileException) {
                System.out.println(e.getMessage());
            } else {
                System.out.println(e.toString());
            }
        }
    }
}