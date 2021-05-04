package database;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnection {
    private static Connection _connection;

    private final String _url;
    private final String _user;
    private final String _password;


    public DbConnection() throws Exception {
        Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);

        _url = "jdbc:mysql://localhost:3306/java_users?useUnicode=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        _user = "root";
        _password = "17052002Yura";
    }

    public Connection getConnection() throws SQLException {
        if(_connection == null) {
            createConnection();
        }
        return _connection;
    }
    public void createConnection() throws SQLException {
        Properties properties = new Properties();
        properties.put("user", _user);
        properties.put("password", _password);
        _connection = DriverManager.getConnection(_url, properties);
    }
}