import connections.ConnectionFactory;
import daos.TheDao;
import models.Car;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Connection connection = ConnectionFactory.getConnection();
        TheDao theDao = new TheDao();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("What do you wanna do? \n 1=Find car by ID? \t 2=Find all? \t 3=Update Car? \t 4=Create Car? \t 5=Delete Car?");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    System.out.println("Enter ID");
                    int temp = scanner.nextInt();
                    System.out.println(theDao.getCar(temp));
                    break;
                case 2:
                    System.out.println(theDao.getAllCars().toString());
                    break;
                case 3:
                    Car car = creation();
                    theDao.updateCar(car);
                    System.out.println(car);
                    break;
                case 4:
                    Car car2 = creation();
                    theDao.createCar(car2);
                    System.out.println(car2);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Enter id of Car you want to delete:");
                    int delete = scanner.nextInt();
                    theDao.deleteCar(delete);
                    break;
            }
        }while (!scanner.nextLine().equals("quit"));
    }
    public static Car creation(){
        // creates car object based on user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter iD");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Make");
        String make = scanner.nextLine();
        System.out.println("Enter Model");
        String model = scanner.nextLine();
        System.out.println("Enter Year");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Color");
        String color = scanner.nextLine();
        System.out.println("Enter Vin");
        String vin = scanner.nextLine();
        return new Car(id, make, model, year, color, vin);
    }
}
