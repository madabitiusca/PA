package com.company;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        try {
            Database.rollback();
            AlbumController album = new AlbumController();
            ArtistController artist = new ArtistController();
            album.create("Celebratio",232,1990);
            Database.commit();
            artist.create("Madonna","SUA");
            Database.commit();
            Database.closeConnection();
        }
        catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}