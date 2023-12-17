package connections;

import com.mysql.cj.jdbc.Driver;
import daos.TheDao;
import models.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static com.mysql.cj.conf.PropertyKey.PASSWORD;

/**
 * Connect to Database
 * @author hany.said
 */
public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/Cars";
    public static final String USER = System.getenv("USERNAME");
    public static final String PASS = System.getenv("PASSWORD");


    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test Connection
     */
//    public static void main(String[] args) {
//        Connection connection = ConnectionFactory.getConnection();
//    }


}