import entity.carriage.impl.PassengerCarriage;
import entity.human.Role;
import entity.human.impl.Passenger;
import org.junit.Test;

import java.util.List;

public class PassengerCarriageTest {

    @Test
    public void setPassengers_addPassengers_carriageWithPassangers(){

        PassengerCarriage carriage = PassengerCarriage.ofPassengerCarriage(1,"A", 1);
        carriage.setPassengers(List.of(Passenger.ofPassenger("l", "l", 1, Role.PASSENGER, 1)));


    }

    @Test
    public void setPassengers_addPassengers_exception(){

        PassengerCarriage carriage = PassengerCarriage.ofPassengerCarriage(1,"A", 1);
        carriage.setPassengers(List.of(
                Passenger.ofPassenger("l", "l", 1, Role.PASSENGER, 1),
                Passenger.ofPassenger("l", "l", 1, Role.PASSENGER, 1)));


    }
}
