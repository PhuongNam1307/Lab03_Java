package org.example.Dao;

import org.example.domain.Manufacture;
import org.example.domain.Phone;
import org.example.reposity.Repository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

import static org.example.utils.HibernateUtils.*;

public class ManufactureDao implements Repository<Manufacture, String> {


    private Session session;

    @Override
    public boolean add(Manufacture iem) {
        Transaction t = null;
        boolean added = false;

        try{
            t = session.beginTransaction();
            session.save(iem);
            t.commit();
            added = true;
        }catch (Exception e){
            if (t != null){
                t.rollback();
            }
        }
        return added;
    }

    @Override
    public Manufacture get(String id) {
        return session.get(Manufacture.class, id);
    }

    @Override
    public List<Manufacture> readAll() {
        return session.createQuery("FROM Manufacture", Manufacture.class).getResultList();
    }

    @Override
    public boolean update(String id, Manufacture item) {
        Transaction tx = null;
        boolean updated = false;
        try {
            tx = session.beginTransaction();
            session.update(item);
            tx.commit();
            updated = true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return updated;
    }

    @Override
    public boolean remove(String id) {
        Transaction tx = null;
        boolean removed = false;
        try {
            tx = session.beginTransaction();
            Manufacture Manufacture = this.get(id);
            if (Manufacture != null) {
                session.delete(Manufacture);
                tx.commit();
                removed = true;
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
        return removed;
    }


    public List<Manufacture> checkOver100Emp(){
        Query<Manufacture> query = session.createNativeQuery("SELECT * FROM Manufacture " +
                "where employee >100",Manufacture.class);
        if (query.getResultList().size()==0) return null;
        return query.getResultList();
    }
    public Integer sumAllEmployee(){
        SessionFactory getSessionFactory = null;
        Session session = getSessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        int sum = 0;
        try {
            String hql = "SELECT SUM(m.employee) FROM Manufacture m";
            Query query = session.createQuery(hql);
            sum = ((Number)query.uniqueResult()).intValue();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return sum;
    }
    public List<Manufacture> allManuInUS(){
        Query<Manufacture> query = session.createNativeQuery("SELECT * FROM Manufacture " +
                "where location = 'us'",Manufacture.class);
        if (query.getResultList().size()==0) {
            return null;
        }
        return query.getResultList();
    }


}