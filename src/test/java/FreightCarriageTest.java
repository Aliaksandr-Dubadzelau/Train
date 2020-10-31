import entity.cargo.Cargo;
import entity.carriage.impl.FreightCarriage;
import org.junit.Test;

import java.util.List;

public class FreightCarriageTest {

    @Test
    public void setCargo_addCargo_carriageWithCargo(){

        FreightCarriage carriage = FreightCarriage.ofFreightCarriage(1,"A", 15);
        carriage.setCargo(List.of(Cargo.builder().name("thirdCargo").batchNumber(3).weight(10f).build()));



    }

    @Test
    public void setCargo_addCargo_exception(){

        FreightCarriage carriage = FreightCarriage.ofFreightCarriage(1,"A", 1);
        carriage.setCargo(List.of(Cargo.builder().name("thirdCargo").batchNumber(3).weight(10f).build()));



    }

}
