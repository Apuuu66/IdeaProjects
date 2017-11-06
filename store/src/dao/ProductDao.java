package dao;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> findNew() throws SQLException;

    List<Product> findHot() throws SQLException;

    Product getByPid(String pid) throws SQLException;

    List findByPage(int currPage, int pageSize, String cid) throws SQLException;

    int getTotalCount(String cid) throws SQLException;

}
