package org.example.Dao;

import org.example.reposity.Repository;
import org.example.domain.Phone;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PhoneDao implements Repository<Phone, Integer>{


    private Session session;

    @Override
    public boolean add(Phone iem) {
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
    public Phone get(Integer id) {
        return session.get(Phone.class, id);
    }

    @Override
    public List<Phone> readAll() {
        return session.createQuery("FROM Phone", Phone.class).getResultList();
    }

    @Override
    public boolean update(Integer id, Phone item) {
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
    public boolean remove(Integer id) {
        Transaction tx = null;
        boolean removed = false;
        try {
            tx = session.beginTransaction();
            Phone phone = this.get(id);
            if (phone != null) {
                session.delete(phone);
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

    public List<Phone> highestPrice(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM Phone WHERE " +
                "price = (SELECT MAX(price) FROM MobilePhone)",Phone.class);
        return query.getResultList();
    }
    public List<Phone> sorted(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM Phone " +
                "ORDER BY country ASC, price DESC",Phone.class);
        return query.getResultList();
    }
    public List<Phone> greater50M(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM Phone " +
                "where price >50000000",Phone.class);
        return query.getResultList();
    }
    public List<Phone> pinkColorAndGt15M(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM Phone " +
                "where price >1500000 and color = 'pink'",Phone.class);
        if (query.getResultList().size()==0) return null;
        return query.getResultList();
    }


}
