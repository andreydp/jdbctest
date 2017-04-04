package factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

        Post post = postQuery.uniqueResult();

        Employee emp = new Employee("Test", "test2", 50000, post, department, new Date());
//        Query<Employee> query = session.createQuery
//                ("from Employee", Employee.class);
//        List<Employee> list = query.list();
//        for (Employee e : list)
//        {
//            System.out.println(e);
//        }

        PhoneNumber phoneNumber = new PhoneNumber("380964720450", emp);
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(emp);
        session.save(phoneNumber);
        emp.setPhoneNumber(phoneNumber);
        transaction.commit();
    }
}
