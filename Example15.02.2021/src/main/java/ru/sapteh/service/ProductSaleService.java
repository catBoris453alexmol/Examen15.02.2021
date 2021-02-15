package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Manufacture;
import ru.sapteh.model.ProductSale;

import java.security.Key;
import java.util.List;

public class ProductSaleService implements Dao<ProductSale, Integer> {
    private final SessionFactory factory;

    public ProductSaleService(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(productSale);
            session.getTransaction().commit();
        }
    }

    @Override
    public ProductSale read(Key key) {
        try(Session session = factory.openSession()) {
            return session.get(ProductSale.class, key);
        }
    }





    @Override
    public List<ProductSale> readByAll() {
        try(Session session = factory.openSession()) {
            String hql = "FROM ProductSale";
            Query<ProductSale> query = session.createQuery(hql);
            List<ProductSale> productSales = query.list();
            return productSales;
        }
    }

    @Override
    public void update(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(productSale);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(productSale);
            session.getTransaction().commit();
        }
    }
}
