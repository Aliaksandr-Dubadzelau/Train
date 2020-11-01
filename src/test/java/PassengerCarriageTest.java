import entity.carriage.impl.PassengerCarriage;
import entity.human.Human;
import entity.human.Role;
import entity.human.impl.Passenger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PassengerCarriageTest {

    private PassengerCarriage carriage;
    private Passenger firstPassenger;
    private Passenger secondPassenger;
    private List<Human> passengers;

    @Before
    public void initialize() {
        carriage = PassengerCarriage.ofPassengerCarriage(1, "A", 1);
        firstPassenger = Passenger.ofPassenger("l", "l", 1, Role.PASSENGER, 1);
        secondPassenger = Passenger.ofPassenger("m", "m", 2, Role.PASSENGER, 2);
        passengers = List.of(firstPassenger, secondPassenger);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPassengers_addPassengers_exception() {
        carriage.setPassengers(passengers);
    }
}
