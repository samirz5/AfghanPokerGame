package DOA.connection;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MySqlConnection {

    private static String url;
    private static String userName;
    private static String password;


    public static Connection getConnection() throws SQLException {
        FileInputStream input = null;
        try {
            input = new FileInputStream("db.prop");
            // load a properties file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            assert input != null;
            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }

        password = prop.getProperty("jdbc.password");
        userName = prop.getProperty("jdbc.username");
        url = prop.getProperty("jdbc.url");
        Connection connection;

        connection = DriverManager.getConnection(url, userName, password);

        return connection;
    }

    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement){
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}