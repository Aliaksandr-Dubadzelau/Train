import entity.carriage.impl.PassengerCarriage;
import entity.human.Human;
import entity.human.Role;
import entity.human.impl.Passenger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PassengerCarriageTest {

    private PassengerCarriage carriage;
    private Passenger firstPassenger;
    private Passenger secondPassenger;
    private List<Human> illegalPassengers;
    private List<Human> passengers;

    @Before
    public void initialize() {
        carriage = PassengerCarriage.ofPassengerCarriage(1, "A", 1);
        firstPassenger = Passenger.ofPassenger("l", "l", 1, Role.PASSENGER, 1);
        secondPassenger = Passenger.ofPassenger("m", "m", 2, Role.PASSENGER, 2);
        illegalPassengers = List.of(firstPassenger, secondPassenger);
        passengers = List.of(firstPassenger);

    }

    @Test
    public void setPassengers_addPassengers_true() {
        boolean expected = true;
        boolean result = carriage.setPassengers(passengers);

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPassengers_addIllegalPassengers_exception() {
        carriage.setPassengers(illegalPassengers);
    }
}
