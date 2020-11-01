import entity.carriage.Carriage;
import entity.carriage.FuelType;
import entity.carriage.impl.Locomotive;
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
    private Carriage locomotive;
    private Train anotherTrain;
    private Carriage carriage;

    @Before
    public void initialize() {
        driver = Driver.ofDriver("1", "1", 1, Role.DRIVER, 1);
        train = new Train(1, "1", driver, FuelType.COAL);
        locomotive = Locomotive.ofLocomotive(1, "1", driver, FuelType.COAL);
        anotherTrain = new Train(2, "2", driver, FuelType.DIESEL);
        carriage = PassengerCarriage.ofPassengerCarriage(1, "2", 2);
    }

    @Test
    public void addCarriage_add_true() {
        boolean expected = true;
        boolean result = train.addCarriage(carriage);

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCarriage_addCarriageFromAnotherTrain_exception() {
        train.addCarriage(carriage);
        anotherTrain.addCarriage(carriage);
    }

    @Test
    public void getFirst_getLocomotive_locomotive() {
        Carriage expected = train.getFirstCarriage();
        Carriage result = locomotive;

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getLast_getLastCarriage_carriage() {
        train.addCarriage(carriage);
        Carriage expected = carriage;
        Carriage result = train.getLastCarriage();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getCarriage_1_carriage() {
        train.addCarriage(carriage);
        Carriage result = train.getCarriage(1);
        System.out.println(result);
        Carriage expected = carriage;

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getCarriage_2_exception() {
        train.getCarriage(2);
    }
}
