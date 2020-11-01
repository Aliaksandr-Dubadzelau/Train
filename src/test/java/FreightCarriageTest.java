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
    private List<Cargo> illegalCargoList;
    private List<Cargo> cargoList;

    @Before
    public void initialize() {
        carriage = FreightCarriage.ofFreightCarriage(1, "A", 1);
        firstCargo = Cargo.builder().name("illegalCargo").batchNumber(3).weight(10f).build();
        secondCargo = Cargo.builder().name("cargo").batchNumber(2).weight(0.3f).build();
        illegalCargoList = List.of(firstCargo);
        cargoList = List.of(secondCargo);
    }

    @Test
    public void setCargo_addCargo_true() {
        boolean expected = true;
        boolean result = carriage.setCargo(cargoList);

        Assert.assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCargo_addIllegalCargo_exception() {
        carriage.setCargo(illegalCargoList);
    }

}
