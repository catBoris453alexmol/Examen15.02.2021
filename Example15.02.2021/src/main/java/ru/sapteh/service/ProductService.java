package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Manufacture;
import ru.sapteh.model.Product;

import java.security.Key;
import java.util.List;

public class ProductService implements Dao<Product,Integer> {
    private final SessionFactory factory;

    public ProductService(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public Product read(Key key) {
        try(Session session = factory.openSession()) {
            return session.get(Product.class, key);
        }
    }





    @Override
    public List<Product> readByAll() {
        try(Session session = factory.openSession()) {
            String hql = "FROM Product";
            Query<Product> query = session.createQuery(hql);
            List<Product> products = query.list();
            return products;
        }
    }

    @Override
    public void update(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }
}
