package com.anish.dao;

import com.anish.pojo.Vykladach;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.anish.config.HibernateSessionFactoryUtil;
import org.hibernate.query.Query;

import java.util.List;

public class VykladachDao {

    public Vykladach findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .get(Vykladach.class, id);
    }

    public void save(Vykladach vykladach) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(vykladach);
        tx.commit();
        session.close();
    }

    public void update(Vykladach vykladach) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(vykladach);
        tx.commit();
        session.close();
    }

    public void delete(Vykladach vykladach) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(vykladach);
        tx.commit();
        session.close();
    }

    public List<Vykladach> findAll() {
        List<Vykladach> list = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()
                .createQuery("from Vykladach", Vykladach.class)
                .list();
        return list;
    }
}