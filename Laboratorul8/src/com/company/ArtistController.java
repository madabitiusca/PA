package com.company;
import java.sql.*;

public class ArtistController
{
    public void create(String name, String country)
    {
        try
        {
            Connection connection=Database.getConnection();
            String count = "select count(*) from artists";
            Statement statement = connection.createStatement();
            ResultSet resultCount = statement.executeQuery(count);
            String sql="insert into artists values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultCount.next();
            preparedStatement.setObject(1, resultCount.getInt(1)+1);
            preparedStatement.setObject(2, name);
            preparedStatement.setObject(3,country);
            preparedStatement.executeUpdate();
        } catch(Exception e)
        {
            e.getMessage();
        }
    }

    public Integer findByName(String name)
    {
        try
        {
            Connection connection = Database.getConnection();
            String sql = "select id from artists where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, name);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch(Exception e)
        {
            e.getMessage();
        }
        return null;
    }

}