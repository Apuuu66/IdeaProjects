package web.service;

import web.dao.ProductDao;
import web.domian.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    public List<Product> findAll() throws SQLException {
        return new ProductDao().findAll();
    }
}
