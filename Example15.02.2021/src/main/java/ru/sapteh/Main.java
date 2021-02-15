package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Manufacture;
import ru.sapteh.model.Product;
import ru.sapteh.model.ProductSale;
import ru.sapteh.service.ManufactureService;
import ru.sapteh.service.ProductSaleService;
import ru.sapteh.service.ProductService;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Product, Integer> productService = new ProductService(factory);
        Dao<ProductSale, Integer> productSaleService= new ProductSaleService(factory);
        Dao<Manufacture, Integer> manufactureService = new ManufactureService(factory);

         factory.close();
    }
}
