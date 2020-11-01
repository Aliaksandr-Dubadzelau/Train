import entity.cargo.Cargo;
import entity.carriage.impl.FreightCarriage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FreightCarriageTest {

    private FreightCarriage carriage;
    private Cargo firstCargo;
    private Cargo secondCargo;

    @Before
    public void initialize() {
        carriage = FreightCarriage.of(1, "A", 1);
        firstCargo = Cargo.builder().name("illegalCargo").batchNumber(3).weight(10f).build();
        secondCargo = Cargo.builder().name("cargo").batchNumber(2).weight(0.3f).build();
    }

    @Test
    public void addCargo_addCargo_true() {
        boolean expected = true;
        boolean result = carriage.addCargo(secondCargo);

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addCargo_addIllegalCargo_exception() {
        carriage.addCargo(firstCargo);
    }

}
