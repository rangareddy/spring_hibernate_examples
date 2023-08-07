package com.ranga;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ranga.util.HibernateUtil;

public class App1 {
	public static void main(String[] args) {
		
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			transaction = session.beginTransaction();
			// do Some work
			
			// session.flush(); // no need
			transaction.commit();			
		} catch(Exception ex) {			
			if(transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if(session != null) {
				// session.close(); // no need	
			}			
		}


        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            // do Some work

            session.flush(); // no need
            transaction.commit();
        } catch(Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if(session != null) {
                session.close(); // no need
            }
        }

	}
}
