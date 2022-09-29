package DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class PlaylistDAO {
    public boolean createPlaylist(String playlistname) throws SQLException {
        boolean flag= false;
        PreparedStatement insertStatement= SongConnection.getSongConnection().
                prepareStatement("insert into Playlist values(?)");
        insertStatement.setString(2, playlistname);
        int result= insertStatement.executeUpdate();
        if(result==1)
            flag= true;
        else
            flag= false;
        return flag;
    }

    public HashMap<String, Integer> viewAllPlaylist() throws SQLException {
        HashMap<String, Integer> playlist= new HashMap<>();
        PreparedStatement selectStatement= SongConnection.getSongConnection().
                prepareStatement("select * from Playlist");
        ResultSet resultSet= selectStatement.executeQuery();
        while(resultSet.next()){
            playlist.put(resultSet.getString(1), resultSet.getInt(2));
        }
        return playlist;
    }

}
