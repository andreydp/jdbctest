package factory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by java on 04.04.2017.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString(exclude = "employees")
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    @Column(name = "date_create")
    private Date creationDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private List<Employee> employees;

    public Department(String title, Date creationDate) {
        this.title = title;
        this.creationDate = creationDate;
    }


}
