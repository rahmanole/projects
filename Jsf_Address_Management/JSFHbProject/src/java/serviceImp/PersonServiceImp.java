package serviceImp;

import entities.Person;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

public class PersonServiceImp {

    public void save(Person person) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tnx = session.beginTransaction();
        session.save(person);
        tnx.commit();
    }

    public List<Person> getPersonList() {
        List<Person> stList = new ArrayList<>();
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr=session.beginTransaction();
        stList = session.createCriteria(Person.class).list();
        tr.commit();
        return stList;
    }
    
     public Person getPersonById(int id) {
        Person person = new Person();
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr=session.beginTransaction();
        person = (Person) session.get(Person.class, id);
        tr.commit();
        return person;
    }
     
    public void deletePerswon(Person person) {
        person = new Person();
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr=session.beginTransaction();
        session.delete(person);
        tr.commit();
    }
}
