package member.util;

import member.profile.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

/**
 * Created by saikatgupta on 5/28/17.
 */
public class HibernateUtil {
    private final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session;
    private Transaction transaction;

    public HibernateUtil() {
    }

    public Session createSession() {
        try {
            session = sessionFactory.openSession();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
        return session;
    }

    public Transaction beginTransaction(Session session) {
        try {
            transaction = session.beginTransaction();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
        return transaction;
    }

    public void commitTransaction(Transaction transaction) {
        try {
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new ExceptionInInitializerError(ex);
        }
    }

    public User getUserByColumn(String columnName) {
        User dupUserByEmail = null;
        try {
            Query query = session.createQuery("from  User_Registration where emailId = :columnName");
            query.setParameter("columnName", columnName);

            dupUserByEmail = (User) query.getSingleResult();
        } catch (Exception ex) {

        }
        return dupUserByEmail;
    }

    public void closeSession(Session session) {
        session.close();
        sessionFactory.close();
        System.out.println("Session factory closed");
    }
}
