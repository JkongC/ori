package com.Jkong.application;

import java.util.List;

class Main {
    public static void main(String[] args) {
        //获取初始歌曲列表
        List<Song> originList = Songs.getSongs();

        //获取Rock歌曲列表
        List<Song> rockList = originList.stream()
                .filter((Song a) -> a.getGenre().equals("Rock"))
                .toList();

        //将列表中的歌曲都替换成它们的genre，然后去除重复元素
        List<String> genreList = originList.stream()
                .map(Song::getGenre)//这里是方法引用，它表示调用传入的Song对象的getGenre方法
                .distinct()
                .toList();

        System.out.println("原歌曲列表：");
        for (int i = 0; i < originList.size(); i++) {
            System.out.println(originList.get(i));
        }

        System.out.println("\n摇滚歌曲列表：");
        for (int i = 0; i < rockList.size(); i++) {
            System.out.println(rockList.get(i));
        }

        System.out.println("\n歌曲体裁列表：");
        for (int i = 0; i < genreList.size(); i++) {
            System.out.println(genreList.get(i));
        }
    }
}