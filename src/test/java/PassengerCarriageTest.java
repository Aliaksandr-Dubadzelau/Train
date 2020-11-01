import entity.carriage.impl.PassengerCarriage;
import entity.human.impl.Passenger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PassengerCarriageTest {

    private PassengerCarriage carriage;
    private Passenger firstPassenger;
    private Passenger secondPassenger;

    @Before
    public void initialize() {
        carriage = PassengerCarriage.of(1, "A", 1);
        firstPassenger = Passenger.of("l", "l", 1, 1);
        secondPassenger = Passenger.of("m", "m", 2, 2);

    }

    @Test
    public void addPassengers_addPassengers_true() {
        boolean expected = true;
        boolean result = carriage.addPassenger(firstPassenger);

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPassenger_addPassengerWithWrongTicket_exception() {
        carriage.addPassenger(secondPassenger);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPassenger_addMorePassengersThanPossible_exception() {
        carriage.addPassenger(firstPassenger);
        carriage.addPassenger(secondPassenger);
    }
}
