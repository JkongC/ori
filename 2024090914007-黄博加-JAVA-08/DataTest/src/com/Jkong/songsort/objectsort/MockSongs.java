package com.Jkong.songsort.objectsort;

import java.util.ArrayList;
import java.util.List;

public class MockSongs {
    public static List<Song> getSongObjects(){
        List<Song> songs = new ArrayList<>();
        //模拟将要处理的列表
        songs.add(new Song("sunrise","haha",80));
        songs.add(new Song("noprice","awdfw",160));
        songs.add(new Song("thanks","AA",75));
        songs.add(new Song("$100","blu",120));
        songs.add(new Song("havana","AG",65));
        songs.add(new Song("114514","yihao",114));
        return songs;
    }
}
