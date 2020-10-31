import entity.cargo.Cargo;
import entity.carriage.Carriage;
import entity.carriage.FuelType;
import entity.carriage.impl.FreightCarriage;
import entity.carriage.impl.PassengerCarriage;
import entity.human.Human;
import entity.human.Role;
import entity.human.impl.Driver;
import entity.human.impl.Passenger;
import entity.train.Train;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Application {
    public static void main(String[] args) {

        Cargo firstCargo = Cargo.builder().name("firstCargo").batchNumber(1).weight(20f).build();
        log.info("Creation cargo: {}", firstCargo);
        Cargo secondCargo = Cargo.builder().name("secondCargo").batchNumber(2).weight(21f).build();
        log.info("Creation cargo: {}", secondCargo);
        Cargo thirdCargo = Cargo.builder().name("thirdCargo").batchNumber(3).weight(10f).build();
        log.info("Creation cargo: {}", thirdCargo);

        List<Cargo> cargoList = new ArrayList<>(List.of(firstCargo, secondCargo, thirdCargo));
        log.info("Creation cargo list: {}", cargoList);

        Human driver = Driver.ofDriver("Ali", "Mahmud", 56, Role.DRIVER, 60000);
        log.info("Creation driver: {}", driver);

        Human firstPassenger = Passenger.ofPassenger("Sergey", "Dumno", 23, Role.PASSENGER, 1);
        log.info("Creation passenger: {}", firstPassenger);
        Human secondPassenger = Passenger.ofPassenger("Vitaliy", "Pershikov", 75, Role.PASSENGER, 2);
        log.info("Creation passenger: {}", secondPassenger);
        Human thirdPassenger = Passenger.ofPassenger("Avdotiy", "Urkevich", 11, Role.PASSENGER, 3);
        log.info("Creation passenger: {}", thirdPassenger);

        List<Human> humanList = new ArrayList<>(List.of(firstPassenger, secondPassenger, thirdPassenger));
        log.info("Creation passenger list: {}", humanList);

        Carriage firstEmptyFreightCarriage = FreightCarriage.ofFreightCarriage(75, "111FE", 600);
        Carriage secondEmptyFreightCarriage = FreightCarriage.ofFreightCarriage(80, "113FE", 600);
        FreightCarriage freightCarriage = FreightCarriage.ofFreightCarriage(80, "112F", 500);
        freightCarriage.setCargo(cargoList);
        PassengerCarriage passengerCarriage = PassengerCarriage.ofPassengerCarriage(85, "112P", 20);
        passengerCarriage.setPassengers(humanList);

        Train train = new Train(95, "100L", driver, FuelType.DIESEL);
        train.addCarriage(freightCarriage);
        train.addCarriage(firstEmptyFreightCarriage);
        train.addCarriage(passengerCarriage);
        train.addCarriage(secondEmptyFreightCarriage);
        train.showTrain();

    }
}
