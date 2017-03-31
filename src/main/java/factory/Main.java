package factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

        Employee emp = new Employee("First", "LastName", 10000d, "", 1, 1);
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Query<Employee> query = session.createQuery
                ("from Employee", Employee.class);
        List<Employee> list = query.list();
        for (Employee e : list)
        {
            System.out.println(e);
        }
        session.beginTransaction();

        session.save(emp);
        session.getTransaction().commit();
    }
}
