package entity.train;

import com.google.common.base.Preconditions;
import entity.carriage.Carriage;
import entity.carriage.FuelType;
import entity.carriage.impl.Locomotive;
import entity.human.Human;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Train {

    private final Carriage locomotive;
    private Carriage lastCarriage;

    public Train(double maxSpeed, String carriageCode, Human driver, FuelType fuelType) {
        this.locomotive = Locomotive.ofLocomotive(maxSpeed, carriageCode, driver, fuelType);
    }

    public boolean addCarriage(Carriage carriage) {

        boolean result = false;
        Preconditions.checkArgument(carriage.getTail() != null || carriage.getHead() != null,
                "Carriage must be alone");

        if (locomotive.getTail() == null) {
            locomotive.setTail(carriage);
            carriage.setHead(locomotive);
            result = true;
        } else {
            lastCarriage.setTail(carriage);
            carriage.setHead(lastCarriage);
            result = true;
        }

        lastCarriage = carriage;
        return result;
    }

    public void showTrain() {
        Carriage currentCarriage = locomotive;

        while (currentCarriage != null) {
            log.info("{}", currentCarriage);
            currentCarriage = currentCarriage.getTail();
        }
    }
}
