package member.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

    public void closeSession(Session session) {
        session.close();
        sessionFactory.close();
        System.out.println("Session factory closed");
    }
}
