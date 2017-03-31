package factory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by java on 21.03.2017.
 */
@Entity
@Table(name = "employees", indexes = {
        @Index(columnList = "name_first",
                name = "name_last")})
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name_first")
    private String fName;
    @Column(name = "name_last")
    private String LName;
    @Column
    private double salary;

    @Column
    private int department_id;

    @Column
    private int post_id;

    @CreationTimestamp
    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;

    public Employee(String fName, String LName, double salary, String email, int department_id, int post_id) {
        this.fName = fName;
        this.LName = LName;
        this.salary = salary;
        this.department_id = department_id;
        this.post_id = post_id;
    }
}
