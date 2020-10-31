package entity.carriage.impl;

import entity.carriage.Carriage;
import entity.carriage.FuelType;
import entity.human.Human;

public class Locomotive extends Carriage {
    private Human driver;
    private FuelType fuelType;

    private Locomotive(double maxSpeed, String carriageCode) {
        super(maxSpeed, carriageCode);
    }

    private Locomotive(double maxSpeed, String carriageCode, Human driver, FuelType fuelType) {
        super(maxSpeed, carriageCode);
        this.driver = driver;
        this.fuelType = fuelType;
    }

    public static Locomotive ofLocomotive(double maxSpeed, String carriageCode) {
        return new Locomotive(maxSpeed, carriageCode);
    }

    public static Locomotive ofLocomotive(double maxSpeed, String carriageCode, Human driver, FuelType fuelType) {
        return new Locomotive(maxSpeed, carriageCode, driver, fuelType);
    }

    @Override
    public String toString() {
        return "Carriage(code): " + super.getCarriageCode() +
                " Head carriage(code): " + (super.getHead() != null ? super.getHead().getCarriageCode() : null) +
                " Tail carriage(code): " + (super.getTail() != null ? super.getTail().getCarriageCode() : null) +
                " Max speed: " + super.getMaxSpeed() +
                " Fuel type: " + fuelType +
                " Driver(" + driver.toString() + ")";
    }
}
