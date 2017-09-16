package service;

import dao.ProductDao;
import domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    public List<Product> findAll() throws SQLException {

        return new ProductDao().findAll();
    }
}
