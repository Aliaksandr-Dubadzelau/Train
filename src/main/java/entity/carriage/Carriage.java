package entity.carriage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public abstract class Carriage {

    private final String carriageCode;
    private final double maxSpeed;
    private Carriage head;
    private Carriage tail;

    protected Carriage(double maxSpeed, String carriageCode) {
        this.maxSpeed = maxSpeed;
        this.carriageCode = carriageCode;
    }
}
