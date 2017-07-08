package member.util;

import member.profile.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by saikatgupta on 5/28/17.
 */
public final class UserUtil {
    public static User createNewUser(User user) {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml")) {
            user = (User) applicationContext.getBean("user");
            if (user != null) {
                System.out.println("New user creation successful.");
            } else {
                System.out.println("User creation problem.");
            }
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
        return user;
    }

    public static HibernateUtil createHibernateUtil() {
        HibernateUtil hibernateUtil = null;
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml")) {
            hibernateUtil = (HibernateUtil) applicationContext.getBean("hibernateUtil");
            if (hibernateUtil != null) {
                System.out.println("New HibernateUtil creation successful.");
            } else {
                System.out.println("HibernateUtil creation problem.");
            }
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
        return hibernateUtil;
    }

    public static int registerUser(User user) {
        int userRegStatus = 0;

        Session session = null;
        Transaction transaction = null;
        HibernateUtil hibernateUtil = null;
        try {
            if (user != null) {
                hibernateUtil = createHibernateUtil();

                session = hibernateUtil.createSession();

                User userDuplicate = hibernateUtil.getUserByEmailId(user.getEmailId());

                if (userDuplicate == null) {
                    userDuplicate = hibernateUtil.getUserByMobile(user.getMobileNumber());
                    if (userDuplicate == null) {
                        userDuplicate = hibernateUtil.getUserByPAN(user.getPanCardNo());
                        if (userDuplicate != null) {
                            System.out.println("Duplicate PAN found for this user.");
                        }
                    } else {
                        System.out.println("Duplicate mobile found for this user.");
                    }
                } else {
                    System.out.println("Duplicate email found for this user.");
                }

                transaction = hibernateUtil.beginTransaction(session);

                if (userDuplicate != null && user.getEmailId().equals(userDuplicate.getEmailId())) {
                    userRegStatus = 0;
                    userDuplicate = null;
                } else if (userDuplicate != null && user.getMobileNumber().equals(userDuplicate.getMobileNumber())) {
                    userRegStatus = -1;
                    userDuplicate = null;
                } else if (userDuplicate != null && user.getPanCardNo().equals(userDuplicate.getPanCardNo())) {
                    userRegStatus = -2;
                    userDuplicate = null;
                } else {
                    session.save(user);
                    hibernateUtil.commitTransaction(transaction);
                    userRegStatus = 1;
                }
            }
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            userRegStatus = -3;
            throw new ExceptionInInitializerError(ex);
        } finally {
            if (session != null)
                hibernateUtil.closeSession(session);
        }
        if (userRegStatus == 1) {
            System.out.println("User registered");
        }
        return userRegStatus;
    }
    /*public static void main(String[] args) {
        User user = null;

        user = createNewUser(user);

        user.setBloodGroup("B-");
        user.setCompanyName("ABCD");
        user.setDeclarationMsg("");
        user.setEmailId("saikat.gupta1975@gmail.com");
        user.setLandLine("01141057594");
        user.setMobileNumber("8826286200");
        user.setPanCardNo("AUPPG0298P");
        user.setPayAmount(1000);
        user.setPaymentAmountInWords("One Thousand only");
        user.setPaymentMode("VISA");
        user.setPinNumber(110019);
        user.setResidentialAddress("J 1886 CR Park");
        user.setUserName("Saikat Gupta");
        user.setWebSiteAdress("www.abcd.com");
        Session session = new HibernateUtil().createSession();
        try {
            registerUser(user);
        }
        catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }*/
}

