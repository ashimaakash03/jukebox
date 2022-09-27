package DAO;

import Model.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SongDAO {

    public ArrayList<Song> selectAllSongs() throws SQLException {
        ArrayList<Song> songlist= null;
        Statement statement= SongConnection.getSongConnection().createStatement();
        ResultSet resultSet= statement.executeQuery("select * from Songs");
        if(resultSet.isBeforeFirst()){
            songlist= new ArrayList<>();
            while (resultSet.next()){
               songlist.add(new Song(resultSet.getInt(1), resultSet.getString(2),
                       resultSet.getString(3), resultSet.getString(4),
                       resultSet.getString(5), resultSet.getString(6)));
            }
        }
        return songlist;
    }

    public int insertSong(Song song) throws SQLException {
        int id=0;
        PreparedStatement insertStatement= SongConnection.getSongConnection().
                prepareStatement("insert into Songs(song_name, song_duration) values (?,?);",
                        Statement.RETURN_GENERATED_KEYS);
        insertStatement.setString(1, song.getSongname());
        insertStatement.setString(2, song.getDuration());
        int result= insertStatement.executeUpdate();
        ResultSet getGeneratedPK= insertStatement.getGeneratedKeys();
        if(getGeneratedPK.next())
            id= getGeneratedPK.getInt(1);
        return id;
    }
}
