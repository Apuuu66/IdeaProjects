package dao;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> findNew() throws SQLException;

    List<Product> findHot() throws SQLException;
}
