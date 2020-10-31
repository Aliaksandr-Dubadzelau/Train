package entity.carriage.impl;

import com.google.common.base.Preconditions;
import entity.cargo.Cargo;
import entity.carriage.Carriage;
import lombok.Getter;

import java.util.List;

@Getter
public class FreightCarriage extends Carriage {
    private List<Cargo> cargo;
    private final double maxWeight;

    private FreightCarriage(double maxSpeed, String carriageCode, double maxWeight) {
        super(maxSpeed, carriageCode);
        this.maxWeight = maxWeight;
    }

    public static FreightCarriage ofFreightCarriage(double maxSpeed, String carriageCode, double maxWeight) {
        return new FreightCarriage(maxSpeed, carriageCode, maxWeight);
    }

    public void setCargo(List<Cargo> cargo) {
        double weight = cargo.stream().mapToDouble(Cargo::getWeight).sum();
        Preconditions.checkArgument(weight <= maxWeight, "It`s more than max weight");

        this.cargo = cargo;
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
