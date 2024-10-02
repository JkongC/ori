package com.Jkong.application_dev;

import java.io.*;
import java.util.List;
import java.util.Scanner;

class SongIO {
    public static void main(String[] args) {
        List<Song> songlist = Songs.getSongs();
        String toRead = "";
        Song temp;
        int output = 0;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("是否将所有歌曲信息写入到文件？1-是 其他数字-否");

        output = sc1.nextInt();

        if (output == 1) {
            for (int i = 0; i < songlist.size(); i++) {
                SongOutput(songlist.get(i));
            }
            System.out.println("所有歌曲已经写入到文件！");
        }

        while (true) {
            System.out.println("\n接下来你要读取哪一首歌？请输入歌名！或输入-1退出！");
            toRead = sc2.nextLine();
            if (toRead.equals("-1")) {
                break;
            } else {
                try {
                    temp = SongInput(toRead);
                    System.out.println(temp);
                } catch (Exception e) {
                    System.out.println("出错了！请检查你输入的名称！");
                }
            }
        }
    }

    public static void SongOutput(Song toOutput){
        try (FileOutputStream fos = new FileOutputStream(toOutput.getTitle() + ".txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(toOutput);
        } catch (Exception e) {
            System.out.println("出错了！错误信息如下：");
            e.printStackTrace();
        }
    }

    public static Song SongInput(String name) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(name + ".txt");
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            return (Song) ois.readObject();
        }
    }
}
