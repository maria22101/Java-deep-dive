package design_patterns.creational_patterns;

/**
 * Builder design pattern implementation
 * Created by Bilous M. 21.01.2020
 */
public class Builder {
    public static void main(String[] args) {
        Director director = new Director();

        director.setBuilder(new VWBuilder());
        Auto a1 = director.buildAuto();
        System.out.println(a1);

        director.setBuilder(new FordMondeoBuilder());
        Auto a2 = director.buildAuto();
        System.out.println(a2);
    }
}
class Director {
    AutoBuilderGeneral builder;
    void setBuilder(AutoBuilderGeneral b) {builder = b;}

    Auto buildAuto() {
        builder.createAuto();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Auto auto = builder.getAuto();
        return auto;
    }
}
class Auto {
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {this.make = make;}
    public void setTransmission(Transmission transmission) {this.transmission = transmission;}
    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}

    @Override
    public String toString() {
        return "Auto{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
abstract class AutoBuilderGeneral {
    Auto auto;
    void createAuto() {auto = new Auto();}

    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Auto getAuto() {return auto;}
}
class FordMondeoBuilder extends AutoBuilderGeneral {
    void buildMake() {auto.setMake("Ford Mondeo"); }
    void buildTransmission() {auto.setTransmission(Transmission.AUTO); }
    void buildMaxSpeed() {auto.setMaxSpeed(220);}
}
class VWBuilder extends AutoBuilderGeneral {
    void buildMake() {auto.setMake("VW Golf"); }
    void buildTransmission() {auto.setTransmission(Transmission.MANUAL); }
    void buildMaxSpeed() {auto.setMaxSpeed(180);}
}
