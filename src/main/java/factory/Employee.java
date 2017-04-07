package factory;

import lombok.*;
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

@SecondaryTable(name = "EMPLOYEE_DETAILS",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "ID_EMPLOYEE"))
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name_first")
    private String fName;
    @Column(name = "name_last")
    private String LName;
    @Column
    private double salary;
    @Column(table = "EMPLOYEE_DETAILS")
    private String city;
    @Column(table = "EMPLOYEE_DETAILS")
    private String streetName;

    @Column(table = "EMPLOYEE_DETAILS")
    private String zipCode;

    @Column(table = "EMPLOYEE_DETAILS")
    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.UNKNOWN;

    @Embedded
    private Car car;

    @CreationTimestamp
    @Type(type = "timestamp")
    @Column(name = "date_create")
    private Date dateCreate;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "employee")
    private PhoneNumber phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Employee(String fName, String LName, double salary, Post post_id, Department department, Date dateCreate) {
        this.fName = fName;
        this.LName = LName;
        this.salary = salary;
        this.post_id = post_id;
        this.department = department;
        this.dateCreate = dateCreate;
    }
}
