package factory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by java on 04.04.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "employee")
@Entity
@Table(name = "PHONE_NUMBERS")
public class PhoneNumber {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 15)
    private String number;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private Employee employee;

    public PhoneNumber(String number, Employee employee) {
        this.number = number;
        this.employee = employee;
    }
}
