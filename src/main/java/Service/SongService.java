package Service;

import DAO.SongDAO;
import Model.Song;

import java.sql.SQLException;
import java.util.ArrayList;

public class SongService {

    SongDAO songdao;
    Song song;
    ArrayList<Song> songlist= new ArrayList<>();

    public SongService(){
       songdao= new SongDAO();
    }

    ArrayList<Song> getAllDetails() throws SQLException {
        return songdao.selectAllSongs();
    }

    private Song getASongByName(ArrayList<Song> songlist, String songname) throws SQLException {
        Song selectedsong= null;
        for(Song list: songlist){
            if (songlist.contains(song)){
                selectedsong= list;
            }
            else
                selectedsong= null;
        }
        return selectedsong;
    }

    public boolean addSong(ArrayList<Song> songlist, Song song) throws SQLException {
        boolean flag= true;
        for(Song list: songlist){
            if (getASongByName(songlist, song.getSongname())==null)
                flag= songlist.add(song);
        }
        return flag;
    }

    public ArrayList<Song> getASongByAlbum(ArrayList<Song> songlist,String albumname){
        ArrayList<Song> listbyalbumname= null;
        if(!songlist.isEmpty() && albumname!=null) {
            listbyalbumname= new ArrayList<>();
            for (Song list : songlist) {
                if (songlist.equals(albumname))
                    listbyalbumname = songlist;
            }
        }
        return  listbyalbumname;
    }

    public ArrayList<Song> getASongByArtist(ArrayList<Song> songlist,String artistname){
        ArrayList<Song> listbyartistname= null;
        if(!songlist.isEmpty() && artistname!=null) {
            listbyartistname= new ArrayList<>();
            for (Song list : songlist) {
                if (songlist.contains(artistname))
                   listbyartistname = songlist;
            }
        }
        return  listbyartistname;
    }

    public ArrayList<Song> getASongByGenre(ArrayList<Song> songlist,String genre){
        ArrayList<Song> listbygenre= null;
        if(!songlist.isEmpty() && genre!=null){
            listbygenre= new ArrayList<>();
            for(Song list: songlist) {
                if (songlist.equals(genre))
                    listbygenre = songlist;
            }
        }
        return  listbygenre;
    }

    public void displaySongs(){
        for(Song list: songlist){
            System.out.format("%10s\t%20s\t%20s\t%20s\t%10s",
                    "SongId", "SongName", "ArtistName", "AlbumName", "SongGenre", "Duration");
        }
    }
}
