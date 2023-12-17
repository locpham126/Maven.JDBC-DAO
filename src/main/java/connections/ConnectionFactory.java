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
//        TheDao theDao = new TheDao();
//        Scanner scanner = new Scanner(System.in);
//        do {
//            System.out.println("What do you wanna do? \n 1=Find car by ID? \t 2=Find all? \t 3=Update Car? \t 4=Create Car? \t 5=Delete Car?");
//            int input = scanner.nextInt();
//            switch (input){
//                case 1:
//                    System.out.println("Enter ID");
//                    int temp = scanner.nextInt();
//                    System.out.println(theDao.getCar(temp));
//                    break;
//                case 2:
//                    System.out.println(theDao.getAllCars().toString());
//                    break;
//                case 3:
//                    System.out.println("Enter iD");
//                    int id = scanner.nextInt();
//                    System.out.println("Enter Make");
//                    String make = scanner.nextLine();
//                    System.out.println("Enter Model");
//                    String model = scanner.nextLine();
//                    System.out.println("Enter Year");
//                    int year = scanner.nextInt();
//                    System.out.println("Enter Color");
//                    String color = scanner.nextLine();
//                    System.out.println("Enter Vin");
//                    String vin = scanner.nextLine();
//                    Car car = new Car(id, make, model, year, color, vin);
//                    theDao.updateCar(car);
//                    break;
//            }
//        }while (!scanner.nextLine().equals("quit"));
//    }


}