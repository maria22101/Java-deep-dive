package design_patterns.creational_patterns;

/**
 * Builder design pattern basic implementation
 * Created by Bilous M. 21.01.2020
 */
public class BuilderBasic {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Mercedes")
                .buildTransmission(Transmission.AUTO)
                .buildMaxSpeed(250)
                .build();
        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {this.make = make;}
    public void setTransmission(Transmission transmission) {this.transmission = transmission;}
    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class CarBuilder {
    String m = "default";
    Transmission t = Transmission.MANUAL;
    int s = 120;

    CarBuilder buildMake(String m) {
        this.m = m;
        return this;
    }
    CarBuilder buildTransmission(Transmission t) {
        this.t = t;
        return this;
    }
    CarBuilder buildMaxSpeed(int s) {
        this.s = s;
        return this;
    }
    Car build() {
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);
        return car;
    }
}
