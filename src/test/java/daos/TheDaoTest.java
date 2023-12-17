package daos;
import models.Car;
import org.junit.Test;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

public class TheDaoTest {
    TheDao theDao = new TheDao();

    @Test
    public void getCarByIDTest(){
        Car car = new Car(0, "Honda", "Civic", 2008, "Black", "1HGCR2F91GA010045");
        Car actual = theDao.getCar(0);
        System.out.println(actual.toString());
        Assert.assertEquals(car.getVin(), actual.getVin());
    }

    @Test
    public void getAllCarsTest(){
        Set<Car> cars = theDao.getAllCars();
        System.out.println(cars.toString());
        Assert.assertNotNull(cars);
    }
    @Test
    public void createCarTest(){
        Car car = new Car(5, "Mitsubishi", "Evoloution", 2006, "Red", "JA3AJ26E05U604551");
        Car expected = theDao.createCar(car);
        Car actual = theDao.getCar(5);
        System.out.println("expected: "+expected.toString());
        System.out.println("actual: "+actual.toString());
        Assert.assertEquals(expected.getVin(), actual.getVin());
    }

    @Test
    public void updateCarTest(){
        Car car = new Car(5, "Mazda", "Miata", 1992, "Blue", "JM3WH813540100599");
        Car expected = theDao.updateCar(car);
        Car actual = theDao.getCar(5);
        System.out.println("expected: "+expected.toString());
        System.out.println("actual: "+actual.toString());
        Assert.assertEquals(expected.getVin(), actual.getVin());
    }

    @Test
    public void deleteCarTest(){
        theDao.deleteCar(5);
        Car actual = theDao.getCar(5);
        Assert.assertNull(actual);
    }
}
