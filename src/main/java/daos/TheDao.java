package daos;

import connections.ConnectionFactory;
import models.Car;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class TheDao implements CarDAO{
    public TheDao(){}
    @Override
    public Car getCar(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cars WHERE id=" + id);

//          creates instance of Car DTO based on found id
            if(rs.next())
            {
                Car car = new Car();

                car.setId( rs.getInt("id") );
                car.setMake( rs.getString("Make") );
                car.setModel( rs.getString("Model") );
                car.setYear( rs.getInt("Year") );
                car.setColor(rs.getString("Color"));
                car.setVin(rs.getString("Vin"));

                return car;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    private Car extractCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();

        car.setId( rs.getInt("id") );
        car.setMake( rs.getString("Make") );
        car.setModel( rs.getString("Model") );
        car.setYear( rs.getInt("Year") );
        car.setColor(rs.getString("Color"));
        car.setVin(rs.getString("Vin"));

        return car;
    }

    @Override
    public Set<Car> getAllCars() {
//        ConnectionFactory connector = new ConnectionFactory();
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cars");

            Set<Car> cars = new HashSet<>();

            while(rs.next())
            {
                Car car = extractCarFromResultSet(rs);
                cars.add(car);
            }

            return cars;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

//    @Override
//    public boolean insertCar() {
//        return false;
//    }

    @Override
    public Car createCar(Car car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Cars VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, car.getId());
            ps.setString(2, car.getMake());
            ps.setString(3, car.getModel());
            ps.setInt(4, car.getYear());
            ps.setString(5, car.getColor());
            ps.setString(6, car.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return car;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Car updateCar(Car car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Cars SET Make=?, Model=?, Year=?, Color=?, Vin=? WHERE id=?");
//            ps.setInt(1, car.getId());
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getVin());
            ps.setInt(6, car.getId());
            int i = ps.executeUpdate();

            if(i == 1) {
                return car;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteCar(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM Cars WHERE id=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
