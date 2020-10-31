import entity.carriage.Carriage;
import entity.carriage.FuelType;
import entity.carriage.impl.PassengerCarriage;
import entity.human.Role;
import entity.human.impl.Driver;
import entity.train.Train;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrainTest {

    private Driver driver;
    private Train train;
    private Train anotherTrain;
    private Carriage carriage;

    @Before
    public void initialize(){
        driver = Driver.ofDriver("1", "1", 1, Role.DRIVER, 1);
        train = new Train(1, "1", driver, FuelType.COAL);
        anotherTrain = new Train(2, "2", driver, FuelType.DIESEL);
        carriage = PassengerCarriage.ofPassengerCarriage(1, "2", 2);
    }

    @Test
    public void addCarriage_add_true(){
        boolean expected = true;
        boolean result = train.addCarriage(carriage);

        Assert.assertEquals(result, expected);

    }

    @Test
    public void addCarriage_addCarriageFromAnotherTrain_exception(){
        train.addCarriage(carriage);
        anotherTrain.addCarriage(carriage);

    }
}
