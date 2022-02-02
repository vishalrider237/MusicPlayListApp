package com.MusicPlayListProject;

import java.util.*;

public class Main {
    private static ArrayList<Album>albums=new ArrayList<>();
    public static void main(String[] args) throws Exception {
       Album album=new Album("Album1","Otnicka");

        album.addSong("Where are You",4.5);
        album.addSong("Dependence",3.5);
        album.addSong("Stronger",5.0);
        albums.add(album);

         album=new Album("Album2","Imran Khan");

        album.addSong("Satisfya",4.5);
        album.addSong("Amplifier",3.5);
        album.addSong("Imaginary",4.5);
        albums.add(album);

        // MyPlayList of songs
        LinkedList<Song>playList_1=new LinkedList<>();
        // adding my first song of album1 at 0th position
        albums.get(0).addSongToPlayList("Where are You",playList_1);
        albums.get(0).addSongToPlayList("Dependence",playList_1);
        albums.get(0).addSongToPlayList("Stronger",playList_1);
        // album2
        albums.get(1).addSongToPlayList("Satisfya",playList_1);
        albums.get(1).addSongToPlayList("Amplifier",playList_1);
        albums.get(1).addSongToPlayList("Imaginary",playList_1);

        //Playing my playlist of songs
        Play(playList_1);
    }

    private static void Play(LinkedList<Song> playList_1) throws Exception {
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song>iterator=playList_1.listIterator();
        if (playList_1.size()==0){
            throw new Exception("PlayList is Empty!!");
        }
        else{
            System.out.println("Now playing "+iterator.next().toString());
            PrintMenu();
        }
        while (!quit){
            int action= sc.nextInt();
            sc.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist is complete");
                    quit=true;
                    break;
                case 1:
                    if (!forward){
                        if (iterator.hasNext()){  //checking our next song is present in our album or not!!
                            iterator.next();
                        }
                        forward=true;
                    }
                    if (iterator.hasNext()){
                        System.out.println("Now playing "+iterator.next().toString());
                    }
                    else{
                        System.out.println("No song available ,reached end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (iterator.hasPrevious()) {    // checking previous song exist or not
                            iterator.previous();
                        }
                        forward=false;
                    }
                    if (iterator.hasPrevious()){
                        System.out.println("Now playing "+iterator.previous().toString());
                    }else{
                        System.out.println("No previous song,We are at first song");;
                        forward=false;
                    }
                    break;
                case 3:
                    if (forward){
                        if (iterator.hasPrevious()){
                            System.out.println("Now playing "+iterator.previous().toString());
                            forward=false;
                        }else{
                            System.out.println("We are at the start of the list");
                        }
                    }else{
                        if (iterator.hasNext()){
                            System.out.println("Now playing "+iterator.next().toString());
                            forward=true;
                        }else{
                            System.out.println("We have reached end of the list");
                        }
                    }
                    break;
                case 4:
                    PrintList(playList_1);
                    break;
                case 5:
                    PrintMenu();
                    break;
                case 6:
                    if (playList_1.size()>0){
                        iterator.remove();
                        if (iterator.hasNext()){
                            System.out.println("Now playing "+iterator.next().toString());

                        }else{
                            if (iterator.hasPrevious()){
                                System.out.println("Now playing "+iterator.previous().toString());
                            }
                        }
                    }
            }
        }
    }
    private static void PrintMenu(){
        System.out.println("Available options \n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
               "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all the available options\n+"+
                "6 - delete current song");

    }
    private static void PrintList(LinkedList<Song>playlist){
        Iterator<Song>iterator= playlist.iterator();
        System.out.println("---------------------------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------------");
    }
}
