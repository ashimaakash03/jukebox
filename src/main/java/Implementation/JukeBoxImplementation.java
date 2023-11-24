package Implementation;

import Model.Song;
import Service.PlaylistContentService;
import Service.PlaylistService;
import Service.SongService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class
JukeboxImplementation {
    static Song song;

    public static void main(String[] args) {
        SongService songservice= new SongService();
        PlaylistService playlistservice= new PlaylistService();
        PlaylistContentService playlistcontent= new PlaylistContentService();

        try {
            ArrayList<Song> songlist= songservice.songdao.selectAllSongs();
            HashMap<String, Integer> playlist= playlistservice.getAllPlaylist();
            System.out.println("Welcome To My Jukebox");
            System.out.println("-----------------------------------------------------------------------------");
            Scanner input= new Scanner(System.in);
            int choice= input.nextInt();

            do{
                System.out.println("Select 1 for Songs: ");
                System.out.println("Select 2 for Playlist: ");
                System.out.println("Select 3 for Player: ");
                System.out.println("Select 4 to Exit Jukebox: ");

                switch (choice){
                    case 1:                                                          //to use Songs Menu
                        int option= input.nextInt();
                        switch(option){
                            case 1:
                                System.out.println("Input Song Details: ");          // to add a song
                                System.out.println("Enter Name of the Song");
                                String SongName= input.nextLine();
                                System.out.println("Name of Song: "+SongName);
                                System.out.println("Enter Name of the Singer");
                                String ArtistName= input.nextLine();
                                System.out.println("Name of Singer: "+ArtistName);
                                System.out.println("Enter Name of the Album");
                                String AlbumName= input.nextLine();
                                System.out.println("Name of Album: "+AlbumName);
                                System.out.println("Enter Song Genre");
                                String SongGenre= input.nextLine();
                                System.out.println("The Song Genre is: "+SongGenre);
                                System.out.println("Enter Duration of Song");
                                String SongDuration= input.nextLine();
                                System.out.println("Song Duration is: "+SongDuration);

                                int SongId = 0;
                                Song songobj= new Song(song.getSongid(), SongName, ArtistName, AlbumName, SongGenre, SongDuration);
                                boolean result= songservice.addSong(songlist, songobj);
                                if (result==true){
                                    System.out.println("Song Added Successfully");
                                    playlistservice.getAllPlaylist();
                                }

                        }
                        break;
                    case 2:                                                        // to use Playlist Menu
                        break;
                    case 3:                                                        // to use Player Menu
                        break;
                    case  4: System.exit(0);                                 // to exit the jukebox
                        break;
                }
            }while (choice!=4);
        } catch (Exception e) {
           e.getMessage();
        }

    }
}
