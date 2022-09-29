package Service;

import DAO.PlaylistContentDAO;
import Model.Song;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import static java.util.ArrayList.*;

public class PlaylistContentService<HashTable> {

    PlaylistContentDAO pcdao;
    Song song;
    public boolean addSongToPlaylist(ArrayList<Song> songlist, Hashtable<String,Integer> playlist,
                                     String songName, String playlistname) throws JukeboxException, SQLException {
        boolean result= true;
        if((!songName.isEmpty()) && (!playlistname.isEmpty())){
            int playlistid= playlist.get(playlistname);
            int songid=0;
            for(Song list: songlist){
                if (song.getSongname().equals(songName)) {
                    songid = song.getSongid();
                    break;
                }
                else if (song.getSongid()==0){
                    throw new JukeboxException ("Empty Song Album");
                } else if (playlistid==0) {
                    throw new JukeboxException("Playlist is empty");
                }
                else {
                  result= pcdao.addSongsToPlaylist(playlistid, songid);
                }

            }
        }
        return result;
    }

    boolean addAlbumToPlaylist(ArrayList<Song> songlist,Hashtable<String,Integer> playlist, String albumName, String playlistname) throws JukeboxException, SQLException {
        boolean result= true;
        if((!albumName.isEmpty()) && (!playlistname.isEmpty())){
            int playlistid=playlist.get(playlistname);
            ArrayList<Integer> songidlist=new ArrayList();
            for(Song list: songlist){
               if(song.getAlbumname().equals(albumName)){
                   songidlist.add(song.getSongid());
                   break;
               } else if (song.getSongid()==0) {
                   throw new JukeboxException("Empty Song Album");
               } else if (playlistid==0) {
                   throw new JukeboxException("Playlist is Empty");
               } else
                   result= pcdao.addSongsToPlaylist(playlistid, song.getSongid());
            }
        }
        return result;
    }

    public ArrayList<Song> playlistContent(String playlistname,Hashtable<String, Integer> playlist,ArrayList<Song> songlist)
            throws JukeboxException, SQLException {
        ArrayList<Song> songarraylist= new ArrayList<>();
        if(!playlistname.isEmpty()){
            int playlistid=playlist.get(playlistname);
            if(playlistid==0){
                throw new JukeboxException("Playlist is Empty");
            }
            else {
                ArrayList<Integer> songidlist= pcdao.viewSongsInPlaylist(playlistid);
                for(int id:songidlist){
                   if(song.getSongid()==id){
                       songarraylist.add(song);
                   }
                }
            }
        }
        return songarraylist;
    }
}
