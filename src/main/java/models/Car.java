package models;

public class Car {
    private String make, model, vin, color;
    private Integer id, year;

    public Car(int id, String make, String model, int year, String color, String vin) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", Make='" + make + '\'' +
                ", Model='" + model + '\'' +
                ", Year='" + year + '\'' +
                ", Color=" + color +
                ", Vin=" + vin +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Car(){
        this.id = null;
        this.make = null;
        this.model = null;
        this.year = null;
        this.color = null;
        this.vin = null;
    }
    public void setMake(String make){
        this.make = make;
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
