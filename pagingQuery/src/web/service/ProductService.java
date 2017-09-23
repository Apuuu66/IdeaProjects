package web.service;

import web.dao.ProductDao;
import web.domian.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    public List<Product> findAll() throws SQLException {
        return new ProductDao().findAll();
    }

    public void addProduct(Product p) throws SQLException {
         new ProductDao().addProduct(p);
    }

    public Product getProductById(String pid) throws SQLException {
        return new ProductDao().getProductById(pid);
    }

    public void modifyProduct(Product p) throws SQLException {
        new ProductDao().modifyProduct(p);
    }
}
