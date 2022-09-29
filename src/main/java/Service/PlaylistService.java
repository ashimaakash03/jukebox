package Service;

import DAO.PlaylistDAO;

import java.sql.SQLException;
import java.util.HashMap;

public class PlaylistService {
    PlaylistDAO playlistdao = new PlaylistDAO();
    public boolean addPlaylist(String playlistname, HashMap<String, Integer> playlist)
            throws SQLException, JukeboxException {
        boolean flag= false;
        boolean result= true;
        if(playlistname.isEmpty()){
            throw new JukeboxException("Playlist is Empty");
        } else {
            flag= playlist.containsKey(playlistname);
            if(!flag){
                result=  playlistdao.createPlaylist(playlistname);
            }
        }
        return result;
    }

    public HashMap<String, Integer> getAllPlaylist() throws SQLException {
        return  playlistdao.viewAllPlaylist();
    }
}
