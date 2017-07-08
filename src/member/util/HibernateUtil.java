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

    public User getUserByEmailId(String emailId) {
        User dupUserByEmail = null;
        try {
            Query query = session.createQuery("from  User_Registration where emailId = :emailId");
            query.setParameter("emailId", emailId);

            dupUserByEmail = (User) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Email not found in system. User can be registered.");
        }
        return dupUserByEmail;
    }

    public User getUserByPAN(String pan) {
        User dupUserByPAN = null;
        try {
            Query query = session.createQuery("from  User_Registration where panCardNo = :pan");
            query.setParameter("pan", pan);

            dupUserByPAN = (User) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("PAN not found in system. User can be registered.");
        }
        return dupUserByPAN;
    }

    public User getUserByMobile(String mobile) {
        User dupUserByMobile = null;
        try {
            Query query = session.createQuery("from  User_Registration where mobileNumber = :mobile");
            query.setParameter("mobile", mobile);

            dupUserByMobile = (User) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Mobile not found in system. User can be registered.");
        }
        return dupUserByMobile;
    }

    public void closeSession(Session session) {
        session.close();
        sessionFactory.close();
        System.out.println("Session factory closed");
    }
}
