package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDao<T> {
    public void saveEntity(T e) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(e);
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
    public List <T> getEntity(Class<T> c) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", c).list();
        }
    }
}