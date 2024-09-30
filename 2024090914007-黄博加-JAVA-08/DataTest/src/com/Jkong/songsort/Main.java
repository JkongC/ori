package com.Jkong.songsort;

import com.Jkong.songsort.objectsort.ViewSong;
import com.Jkong.songsort.stringsort.ViewSongString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("演示String版还是Song版？输入String或者Song");
        String type = sc.nextLine().toLowerCase();

        if (type.equals("string")){
            ViewSongString.view();
        } else if (type.equals("song")){
            ViewSong.view();
        }
    }
}
