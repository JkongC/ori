package com.Jkong.songsort.objectsort;

import com.Jkong.songsort.sort.SongSort;
import com.Jkong.songsort.sort.StringSort;

import java.util.List;

public class ViewSong {
    public static void view() {

        List<Song> SongList = MockSongs.getSongObjects();

        System.out.println("原列表：");
        for (int i = 0; i < SongList.size(); i++) {
            System.out.println(SongList.get(i));
        }

        System.out.println();

        SongList.sort(new SongSort());

        System.out.println("分类后列表：");
        for (int i = 0; i < SongList.size(); i++) {
            System.out.println(SongList.get(i));
        }
    }
}
