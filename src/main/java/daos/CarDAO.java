package daos;

import models.Car;

import java.util.Set;

public interface CarDAO {
    public Car getCar(int id);
    public Set<Car> getAllCars();
//    boolean insertCar();
    public Car updateCar(Car car);
    public Car createCar(Car car);
    public void deleteCar(int id);
}
