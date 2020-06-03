package DOA.context;

import DOA.connection.MySqlConnection;
import DOA.entity.UserEntity;
import DOA.interfaces.CRUD;
import org.apache.catalina.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserContext implements CRUD<UserEntity> {
    @Override
    public void createTable() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = MySqlConnection.getConnection();
            statement = connection.createStatement();
            statement.execute(("CREATE TABLE IF NOT EXISTS users (id int primary key unique auto_increment," +
                    " username varchar (55), password varchar (255), balance double, email varchar (100))"));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySqlConnection.closeStatement(statement);
            MySqlConnection.closeConnection(connection);
        }
    }

    @Override
    public void add(UserEntity entity) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlConnection.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, balance, email)" +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, entity.getUserName());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setDouble(3, entity.getBalance());
            preparedStatement.setString(4, entity.getEmail());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySqlConnection.closeConnection(connection);
            MySqlConnection.closePreparedStatement(preparedStatement);
        }
    }

    public UserEntity getUserPasswordByUsername(String userName){
        UserEntity userEntity = new UserEntity();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySqlConnection.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                userEntity.setUserName(resultSet.getString("username"));
                userEntity.setPassword(resultSet.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySqlConnection.closeConnection(connection);
            MySqlConnection.closePreparedStatement(preparedStatement);
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userEntity;
    }

    @Override
    public UserEntity selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(UserEntity entity, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<UserEntity> getAll() throws SQLException {
        return null;
    }

    public List<UserEntity> getAllUserNames(){
    List<UserEntity> userNames = new ArrayList<>();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

        try {
        connection = MySqlConnection.getConnection();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()){
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(resultSet.getString("username"));
            userNames.add(userEntity);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        MySqlConnection.closeConnection(connection);
        MySqlConnection.closeStatement(statement);
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        return userNames;
    }
}
