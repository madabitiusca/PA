package com.company;

import java.sql.*;

public class AlbumController {
    public void create(String name, int artistID, int releaseYear) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = Database.getConnection();
            String count = "select count(*) from albums";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(count);
            String sql = "insert into albums values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultCount.next();
            preparedStatement.setObject(1, resultCount.getInt(1) + 1);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3,artistID);
            preparedStatement.setObject(4,releaseYear);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }


    public String findByArtistID(Integer artist_id) {
        try {
            Connection connection = Database.getConnection();
            String sql = "select artist_id from albums where artist_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, artist_id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return (String) result.getObject("name");
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}