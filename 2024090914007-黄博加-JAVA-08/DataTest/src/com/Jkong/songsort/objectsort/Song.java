package com.Jkong.songsort.objectsort;

public class Song {
    private String title;
    private String artist;
    private int bpm;

    public Song(String title,String artist,int bpm){
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public void listen(){
        System.out.println("啦啦啦");
    }

    @Override
    public String toString() {
        return "歌曲名：" + title + ", 作者：" + artist + ", bpm=" + bpm;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getArtist(){
        return this.artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public int getBpm(){
        return this.bpm;
    }

    public void setBpm(int bpm){
        this.bpm = bpm;
    }
}
