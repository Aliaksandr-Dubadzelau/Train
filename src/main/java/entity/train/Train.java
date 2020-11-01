package entity.train;

import com.google.common.base.Preconditions;
import entity.carriage.Carriage;
import entity.carriage.FuelType;
import entity.carriage.impl.Locomotive;
import entity.human.Human;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
public class Train {

    private final Carriage locomotive;
    private Carriage lastCarriage;

    public Train(double maxSpeed, String carriageCode, Human driver, FuelType fuelType) {
        this.locomotive = Locomotive.of(maxSpeed, carriageCode, driver, fuelType);
    }

    public boolean addCarriage(Carriage carriage) {

        Preconditions.checkArgument(carriage.getTail() == null && carriage.getHead() == null,
                "Carriage must be alone");

        if (locomotive.getTail() == null) {
            locomotive.setTail(carriage);
            carriage.setHead(locomotive);
        } else {
            lastCarriage.setTail(carriage);
            carriage.setHead(lastCarriage);
        }

        lastCarriage = carriage;
        return true;
    }

    public Carriage getFirstCarriage() {
        return locomotive;
    }

    public Carriage getLastCarriage() {
        return lastCarriage;
    }

    public Carriage getCarriage(int index) {
        Carriage currentCarriage = locomotive;
        int currentIndex = 0;

        Preconditions.checkPositionIndex(index, size());

        while (currentCarriage != null && currentIndex != index) {
            currentCarriage = next(currentCarriage);
            currentIndex++;
        }

        return currentCarriage;
    }

    public int size() {
        Carriage currentCarriage = locomotive;
        int size = 0;

        while (currentCarriage != null) {
            currentCarriage = next(currentCarriage);
            size++;
        }

        return size;
    }

    private Carriage next(Carriage carriage) {
        return carriage.getTail();
    }
}
