package com.Jkong.songsort.sort;

import java.util.Comparator;
import java.util.List;

public class StringSort implements Comparator<String>{

    @Override
    public int compare(String s1, String s2) {
        if (s1.charAt(0) < s2.charAt(0)){
            return -1;
        } else {
            return s1.charAt(0) == s2.charAt(0) ? 0 : 1;
        }
    }

}
