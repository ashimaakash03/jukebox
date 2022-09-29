package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistContentDAO {

    public boolean addSongsToPlaylist(int playlistid, int songid) throws SQLException {
        boolean flag= false;
        PreparedStatement insertStatement= SongConnection.getSongConnection().
                prepareStatement("insert into PlaylistContent values (?,?)");
        insertStatement.setInt(1, playlistid);
        insertStatement.setInt(2, songid);
       int result= insertStatement.executeUpdate();
       if (result==1)
           flag= true;
       else
           flag= false;
       return false;
    }

    public ArrayList<Integer> viewSongsInPlaylist(int playlistid) throws SQLException {
        ArrayList<Integer> playlist= new ArrayList<>();
        PreparedStatement selectStatement= SongConnection.getSongConnection().
                prepareStatement("select * from PlaylistContent where playlistid= ?");
        selectStatement.setInt(1, playlistid);
        ResultSet resultSet= selectStatement.executeQuery();
        while (resultSet.next()){
            playlist.add(playlistid);
        }
        return playlist;
    }
}
