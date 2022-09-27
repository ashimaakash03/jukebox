package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SongConnection {

    public static Connection getSongConnection() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:306/Jukebox", "root", "password");
        return connection;
    }
}