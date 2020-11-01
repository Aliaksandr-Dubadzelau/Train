package entity.carriage.impl;

import com.google.common.base.Preconditions;
import entity.carriage.Carriage;
import entity.human.impl.Passenger;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
public class PassengerCarriage extends Carriage {
    private List<Passenger> passengers;
    private Set<Integer> seats;
    private final int maxAmountOfPassengers;

    private PassengerCarriage(double maxSpeed, String carriageCode, int maxAmountOfPassengers) {
        super(maxSpeed, carriageCode);
        this.maxAmountOfPassengers = maxAmountOfPassengers;
        this.passengers = new ArrayList<>();
        this.seats = new HashSet<>();
        fillSeats();
    }

    public static PassengerCarriage of(double maxSpeed, String carriageCode, int maxAmountOfPassengers) {
        return new PassengerCarriage(maxSpeed, carriageCode, maxAmountOfPassengers);
    }

    public boolean addPassenger(Passenger passenger) {

        int ticketNumber = passenger.getTicketNumber();

        Preconditions.checkArgument(seats.contains(ticketNumber), "This seat is already taken or not existed.");
        passengers.add(passenger);
        seats.remove(ticketNumber);

        return true;
    }

    private void fillSeats() {
        for (int i = 0; i < maxAmountOfPassengers; i++) {
            seats.add(i + 1);
        }
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
