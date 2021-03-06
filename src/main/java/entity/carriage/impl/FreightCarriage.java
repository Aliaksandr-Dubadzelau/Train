package entity.carriage.impl;

import com.google.common.base.Preconditions;
import entity.cargo.Cargo;
import entity.carriage.Carriage;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
public class FreightCarriage extends Carriage {
    private List<Cargo> cargo;
    private final double maxWeight;

    private FreightCarriage(double maxSpeed, String carriageCode, double maxWeight) {
        super(maxSpeed, carriageCode);
        this.maxWeight = maxWeight;
        this.cargo = new ArrayList<>();
    }

    public static FreightCarriage of(double maxSpeed, String carriageCode, double maxWeight) {
        return new FreightCarriage(maxSpeed, carriageCode, maxWeight);
    }

    public boolean addCargo(Cargo currentCargo){
        double weight = cargo.stream().mapToDouble(Cargo::getWeight).sum();
        double newWeight = weight + currentCargo.getWeight();

        Preconditions.checkArgument(newWeight <= maxWeight, "It`s more than max weight");
        this.cargo.add(currentCargo);

        return true;
    }

    @Override
    public String toString() {
        return "Carriage(code): " + super.getCarriageCode() +
                " Head carriage(code): " + (super.getHead() != null ? super.getHead().getCarriageCode() : null) +
                " Tail carriage(code): " + (super.getTail() != null ? super.getTail().getCarriageCode() : null) +
                " Max speed: " + super.getMaxSpeed() +
                " Max weight: " + maxWeight +
                " Cargo: " + cargo;
    }
}
