package factory;

import lombok.*;

import javax.persistence.*;
/**
 * Created by java on 07.04.2017.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Car {

    @Column
    private String model;
    @Enumerated(EnumType.STRING)
    @Column
    private Color color = Color.BLACK;
    @Column
    private double maxSpeed;
}
