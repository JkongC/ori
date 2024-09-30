package com.Jkong.songsort.sort;

import com.Jkong.songsort.objectsort.Song;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public <T> void sort(List<T> SongList){
        T type = SongList.get(0);

        if (type instanceof String){
            SongList.sort((Comparator<? super T>) new StringSort());//需要强转的原因：T类型不确定，而sort方法形参类型为Comparator<? super T>
        } else if (type instanceof Song){
            SongList.sort((Comparator<? super T>) new SongSort());
        }
    }

    public class StringSort implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1.charAt(0) < s2.charAt(0)){
                return -1;
            } else {
                return s1.charAt(0) == s2.charAt(0) ? 0 : 1;
            }
        }

    }

    public class SongSort implements Comparator<Song> {

        @Override
        public int compare(Song o1, Song o2) {
            if (o1.getTitle().charAt(0) < o2.getTitle().charAt(0)){
                return -1;
            } else {
                return o1.getTitle().charAt(0) == o2.getTitle().charAt(0) ? 0 : 1;
            }
        }
    }
}
