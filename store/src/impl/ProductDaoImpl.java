package impl;

import dao.ProductDao;
import entity.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> findNew() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product order by pdate limit 9";
        return qr.query(sql,new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> findHot() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where is_hot = 1 order by pdate limit 9";
        return qr.query(sql,new BeanListHandler<>(Product.class));
    }
}
