import entity.cargo.Cargo;
import entity.carriage.impl.FreightCarriage;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FreightCarriageTest {

    private FreightCarriage carriage;
    private Cargo cargo;
    private List<Cargo> cargoList;

    @Before
    public void initialize() {
        carriage = FreightCarriage.ofFreightCarriage(1, "A", 1);
        cargo = Cargo.builder().name("thirdCargo").batchNumber(3).weight(10f).build();
        cargoList = List.of(cargo);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCargo_addCargo_exception() {
        carriage.setCargo(cargoList);
    }

}
