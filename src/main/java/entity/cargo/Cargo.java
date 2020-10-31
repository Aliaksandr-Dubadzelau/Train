package entity.cargo;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class Cargo {

    @NonNull
    private final String name;
    @NonNull
    private final int batchNumber;
    @NonNull
    private final double weight;

    @Override
    public String toString() {
        return " Name: " + name +
                " Batch number: " + batchNumber +
                " Weight: " + weight;
    }
}
