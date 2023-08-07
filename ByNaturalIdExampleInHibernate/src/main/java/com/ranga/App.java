package com.ranga;

import com.ranga.pojo.Login;
import com.ranga.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by ranga on 12/27/13.
 */

public class App {
    public static void main(String[] args) {
        Login login = new Login();
        login.setUsername("ranga1");
        login.setPassword("ranga");

        long loginId = 0l;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            loginId = (Long) session.save(login);
            session.flush(); // we need take care
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
                transaction = null;
            }
        } finally {
           if(session != null) {
              session.close(); // we need take care
           }
        }

        session = HibernateUtil.getSessionFactory().openSession();
        System.out.println(loginId);

        // byId()
        login = (Login) session.byId(Login.class).getReference(loginId);
        System.out.println(login);

        // byNaturalId()
        login = (Login) session.byNaturalId(Login.class).using("username","ranga1").load();
        System.out.println(login);

        login = (Login) session.bySimpleNaturalId(Login.class).load("ranga");
        System.out.println(login);

    }
}
