package webapp.test.dao;

import webapp.test.models.Calculation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import webapp.test.utils.HibernateSessionFactoryUtil;
import java.util.ArrayList;

public class CalculationDao {

    public Calculation findById(int id) {
        return (Calculation) HibernateSessionFactoryUtil.buildSessionFactory().openSession().get(Calculation.class, id);
    }

    public void save(Calculation calculation) {
        Session session = HibernateSessionFactoryUtil.buildSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(calculation);
        tx1.commit();
        session.close();
    }

    public void update(Calculation calculation) {
        Session session = HibernateSessionFactoryUtil.buildSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(calculation);
        tx1.commit();
        session.close();
    }

    public void delete(Calculation calculation) {
        Session session = HibernateSessionFactoryUtil.buildSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(calculation);
        tx1.commit();
        session.close();
    }

    public void deleteAll(){
        Session session = HibernateSessionFactoryUtil.buildSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.createNativeQuery("truncate table calculations").executeUpdate();
        tx1.commit();
        session.close();
    }



    public ArrayList<Calculation> findAll() {
        ArrayList<Calculation> calculations = (ArrayList<Calculation>)  HibernateSessionFactoryUtil.buildSessionFactory().openSession().createQuery("From Calculation").list();
        return calculations;
    }
}
