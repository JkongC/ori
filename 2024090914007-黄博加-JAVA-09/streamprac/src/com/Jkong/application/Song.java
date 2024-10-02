package com.Jkong.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Song{
    private String title;
    private String artist;
    private String genre;
    private int year;
    private int timesPlayed;
    //	利用注解或者自己创建构造器和get方法


    @Override
    public String toString() {
        return "歌曲名：" + title + "，作者：" + artist + "，体裁：" + genre + "，年份：" + year + "，播放次数：" + timesPlayed;
    }
}
