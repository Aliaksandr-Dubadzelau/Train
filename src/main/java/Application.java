import entity.cargo.Cargo;
import entity.carriage.Carriage;
import entity.carriage.FuelType;
import entity.carriage.impl.FreightCarriage;
import entity.carriage.impl.PassengerCarriage;
import entity.human.Human;
import entity.human.impl.Driver;
import entity.human.impl.Passenger;
import entity.train.Train;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String[] args) {

        Cargo firstCargo = Cargo.builder().name("firstCargo").batchNumber(1).weight(20f).build();
        log.info("Creation cargo: {}", firstCargo);
        Cargo secondCargo = Cargo.builder().name("secondCargo").batchNumber(2).weight(21f).build();
        log.info("Creation cargo: {}", secondCargo);
        Cargo thirdCargo = Cargo.builder().name("thirdCargo").batchNumber(3).weight(10f).build();
        log.info("Creation cargo: {}", thirdCargo);

        Human driver = Driver.of("Ali", "Mahmud", 56, 60000);
        log.info("Creation driver: {}", driver);

        Passenger firstPassenger = Passenger.of("Sergey", "Dumno", 23, 1);
        log.info("Creation passenger: {}", firstPassenger);
        Passenger secondPassenger = Passenger.of("Vitaliy", "Pershikov", 75, 2);
        log.info("Creation passenger: {}", secondPassenger);
        Passenger thirdPassenger = Passenger.of("Avdotiy", "Urkevich", 11, 3);
        log.info("Creation passenger: {}", thirdPassenger);

        Carriage firstEmptyFreightCarriage = FreightCarriage.of(75, "111FE", 600);
        Carriage secondEmptyFreightCarriage = FreightCarriage.of(80, "113FE", 600);
        FreightCarriage freightCarriage = FreightCarriage.of(80, "112F", 500);
        freightCarriage.addCargo(firstCargo);
        freightCarriage.addCargo(secondCargo);
        freightCarriage.addCargo(thirdCargo);
        PassengerCarriage passengerCarriage = PassengerCarriage.of(85, "112P", 20);
        passengerCarriage.addPassenger(firstPassenger);
        passengerCarriage.addPassenger(secondPassenger);
        passengerCarriage.addPassenger(thirdPassenger);

        Train train = new Train(95, "100L", driver, FuelType.DIESEL);
        log.info("createTrain {}", train);
        train.addCarriage(freightCarriage);
        log.info("addCarriage {}", freightCarriage);
        train.addCarriage(firstEmptyFreightCarriage);
        log.info("addCarriage {}", firstEmptyFreightCarriage);
        train.addCarriage(passengerCarriage);
        log.info("addCarriage {}", passengerCarriage);
        train.addCarriage(secondEmptyFreightCarriage);
        log.info("addCarrigae {}", secondEmptyFreightCarriage);

        for (int i = 0; i < train.size(); i++) {
            log.info("{}", train.getCarriage(i));
        }

        Carriage testCarriage1 = train.getCarriage(1);
        log.info("getCarriage index 1 {}", testCarriage1);
        Carriage testCarriage2 = train.getFirstCarriage();
        log.info("getFirstCarriage {}", testCarriage2);
        Carriage testCarriage3 = train.getLastCarriage();
        log.info("getLastCarriage {}", testCarriage3);
    }
}
