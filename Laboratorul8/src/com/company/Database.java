package com.company;

import java.sql.*;

public class Database
{
    private static Connection connection = null;
    private static ConnectionManager connectionManager = new ConnectionManager();

    public Database() { }

    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        if(connection == null)
            connection = connectionManager.createConnection();
        return connection;
    }

    public static void closeConnection() throws SQLException
    {
        connection.close();
    }

    public static void rollback() throws SQLException, ClassNotFoundException
    {

        String delArtists = "DELETE FROM artists WHERE id >= 1";
        String delAlbums = "DELETE FROM albums WHERE id >= 1";
        Statement statement = getConnection().createStatement();
        statement.executeQuery(delArtists);
        statement.executeQuery(delAlbums);
    }
    public static void commit() throws SQLException {
        connection.commit();
    }
}