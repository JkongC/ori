package com.Jkong.songsort.sort;

import com.Jkong.songsort.objectsort.Song;

import java.util.Comparator;

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
