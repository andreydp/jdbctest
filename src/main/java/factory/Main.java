package factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by java on 31.03.2017.
 */
public class Main {

    private static SessionFactory sessionFactory = null;

    static {
        try {
            sessionFactory = new
                    Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void main(String[] args) {

        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();

        Query<Department> departmentQuery =
                session.createQuery("from Department where id = :id", Department.class);
        departmentQuery.setParameter("id", 1L);

        Department department = departmentQuery.uniqueResult();

        Query<Post> postQuery =
                session.createQuery("from Post where id = :id", Post.class);
        postQuery.setParameter("id", 1L);

//        Post post = postQuery.uniqueResult();
//        Car car = new Car("BMW", Color.BLACK, 270d);
//        Employee emp = new Employee("Test", "test2", 50000, post, department, new Date());
//        emp.setCity("Dnepr");
//        emp.setStreetName("Krasnaya");
//        emp.setZipCode("49000");
//        emp.setZipCode("49000");
//        emp.setSex(Sex.MALE);
//        emp.setCar(car);

//        PhoneNumber phoneNumber = new PhoneNumber("380964720450", emp);

        Yacht yacht = new Yacht("2247", 5, 10, 15);
        Transaction transaction = session.getTransaction();
        transaction.begin();
//        session.save(emp);
//        session.save(phoneNumber);
//        emp.setPhoneNumber(phoneNumber);
//        transaction.commit();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Yacht> criteria = criteriaBuilder.createQuery(Yacht.class);
        Root<Yacht> yachtRoot = criteria.from(Yacht.class);
        Predicate predicate = criteriaBuilder.equal(yachtRoot.get("model"), "2247");

        CriteriaQuery<Yacht> where = criteria.where(predicate);
    }
}
