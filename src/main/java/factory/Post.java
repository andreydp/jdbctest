package factory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    @Column(name = "date_create")
    private Date creationDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post_id")
    private List<Employee> employees;

    public Post(String title, Date creationDate) {
        this.title = title;
        this.creationDate = creationDate;
    }
}