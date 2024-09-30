package com.Jkong.songsort.stringsort;

import java.util.List;
import com.Jkong.songsort.sort.StringSort;

public class ViewSongString {
    public static void view() {

        List<String> SongList = MockSongs.getSongStrings();

        System.out.println("原列表：");
        for (int i = 0; i < SongList.size(); i++) {
            System.out.println(SongList.get(i));
        }

        System.out.println();

        SongList.sort(new StringSort());

        System.out.println("分类后列表：");
        for (int i = 0; i < SongList.size(); i++) {
            System.out.println(SongList.get(i));
        }
    }
}
