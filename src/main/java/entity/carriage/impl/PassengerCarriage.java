package entity.carriage.impl;

import com.google.common.base.Preconditions;
import entity.carriage.Carriage;
import entity.human.Human;

import java.util.List;

public class PassengerCarriage extends Carriage {
    private List<Human> passengers;
    private final int maxAmountOfPassengers;

    private PassengerCarriage(double maxSpeed, String carriageCode, int maxAmountOfPassengers) {
        super(maxSpeed, carriageCode);
        this.maxAmountOfPassengers = maxAmountOfPassengers;
    }

    public static PassengerCarriage ofPassengerCarriage(double maxSpeed, String carriageCode, int maxAmountOfPassengers) {
        return new PassengerCarriage(maxSpeed, carriageCode, maxAmountOfPassengers);
    }

    public void setPassengers(List<Human> passengers) {
        long amountOfPassengers = passengers.size();
        Preconditions.checkArgument(amountOfPassengers <= maxAmountOfPassengers, "It`s more than max passengers");

        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Carriage(code): " + super.getCarriageCode() +
                " Head carriage(code): " + (super.getHead() != null ? super.getHead().getCarriageCode() : null) +
                " Tail carriage(code): " + (super.getTail() != null ? super.getTail().getCarriageCode() : null) +
                " Max speed: " + super.getMaxSpeed() +
                " Max amount of passengers: " + maxAmountOfPassengers +
                " Passengers: " + passengers;
    }
}
