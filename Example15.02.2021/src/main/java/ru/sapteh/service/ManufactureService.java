package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Manufacture;

import java.security.Key;
import java.util.List;

public class ManufactureService implements Dao<Manufacture, Integer> {

    private final SessionFactory factory;

    public ManufactureService(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Manufacture manufacture) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(manufacture);
            session.getTransaction().commit();
        }
    }

    @Override
    public Manufacture read(Key key) {
        try(Session session = factory.openSession()) {
        return session.get(Manufacture.class, key);
    }
    }





    @Override
    public List<Manufacture> readByAll() {
        try(Session session = factory.openSession()) {
            String hql = "FROM Manufacture";
            Query<Manufacture> query = session.createQuery(hql);
            List<Manufacture> manufactures = query.list();
            return manufactures;
        }
    }

    @Override
    public void update(Manufacture manufacture) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(manufacture);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Manufacture manufacture) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(manufacture);
            session.getTransaction().commit();
        }
    }
}
