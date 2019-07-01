package serviceImp;

import entities.Student;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

public class StudentServiceImp {

    public void save(Student student) {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tnx = session.beginTransaction();
        session.saveOrUpdate(student);
        tnx.commit();
    }

    public List<Student> getStudentList() {
        List<Student> stList = new ArrayList<>();
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr=session.beginTransaction();
        stList = session.createCriteria(Student.class).list();
        tr.commit();
        return stList;
    }
}
