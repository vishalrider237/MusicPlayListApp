package com.MusicPlayListProject;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song>songs;
    //Constructor of Album Class


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){
        //Empty Constructor
    }
    public Song findSong(String title){
        for (Song checkedSong:songs){
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }
    public boolean addSong(String title,double duration){
        if (findSong(title)==null){
            songs.add(new Song(title,duration));
  //          System.out.println(title + " Successfully added to the list");
            return true;
        }
        else{
   //         System.out.println("Song with name" +title+ " is already exist in the list");
            return false;
        }
    }
    // this method take trackNumber as input
    public boolean addSongToPlayList(int TrackNumber, LinkedList<Song>PlayList){
        int index=TrackNumber-1;
        if (index>0 && index<this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
    //    System.out.println("this song does not have trackNumber " + TrackNumber);
        return false;
    }
    // this method take title as input
    public boolean addSongToPlayList(String title,LinkedList<Song>PlayList){
        // checking song is already is present in our album or not
        for (Song checkedSong:this.songs){
            if (checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
   //     System.out.println(title + " there is no such song in album");
        return false;
    }
}
