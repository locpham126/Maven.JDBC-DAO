package models;
import org.junit.Test;
import org.junit.Assert;

public class CarDTOTest {
    @Test
    public void carConstructorTest(){
        Car car = new Car(0, "Honda", "Civic", 2008, "Black", "1HGCR2F91GA010045");
        String actual = car.getVin();
        Assert.assertEquals("1HGCR2F91GA010045", actual);
    }
    @Test
    public void testSetModel() {
        Car car = new Car();
        car.setModel("Civic");
        String expected = "Civic";
        Assert.assertEquals(expected, car.getModel());
    }
    @Test
    public void testSetVin() {
        Car car = new Car();
        car.setVin("1HGCR2F91GA010045");
        String expected = "1HGCR2F91GA010045";
        Assert.assertEquals(expected, car.getVin());
    }
    @Test
    public void testSetId() {
        Car car = new Car();
        car.setId(0);
        int expected = 0;
        Assert.assertEquals(expected, car.getId());
    }
    @Test
    public void testSetYear() {
        Car car = new Car();
        car.setYear(2008);
        int expected = 2008;
        Assert.assertEquals(expected, car.getYear());
    }
    @Test
    public void testSetMake() {
        Car car = new Car();
        car.setMake("Honda");
        String expected = "Honda";
        Assert.assertEquals(expected, car.getMake());
    }
    @Test
    public void testGetMake() {
        Car car = new Car(0, "Honda", "Civic", 2008, "Black", "1HGCR2F91GA010045");
        String expected = "Honda";
        Assert.assertEquals(expected, car.getMake());
    }
    @Test
    public void testGetModel() {
        Car car = new Car(0, "Honda", "Civic", 2008, "Black", "1HGCR2F91GA010045");
        String expected = "Civic";
        Assert.assertEquals(expected, car.getModel());
    }
    @Test
    public void testGetVin() {
        Car car = new Car(0, "Honda", "Civic", 2008, "Black", "1HGCR2F91GA010045");
        String expected = "1HGCR2F91GA010045";
        Assert.assertEquals(expected, car.getVin());
    }
    @Test
    public void testGetId() {
        Car car = new Car(0, "Honda", "Civic", 2008, "Black", "1HGCR2F91GA010045");
        int expected = 0;
        Assert.assertEquals(expected, car.getId());
    }
    @Test
    public void testGetYear() {
        Car car = new Car(0, "Honda", "Civic", 2008, "Black", "1HGCR2F91GA010045");
        int expected = 2008;
        Assert.assertEquals(expected, car.getYear());
    }
}
