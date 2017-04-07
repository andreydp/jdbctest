package factory;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by java on 07.04.2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Yacht extends Boat {

    @Column
    private double maxSpeed;
    @Column
    private double length;

    public Yacht(String model, int maxPassengers, double maxSpeed, double length) {
        super(model, maxPassengers);
        this.maxSpeed = maxSpeed;
        this.length = length;
    }
}
