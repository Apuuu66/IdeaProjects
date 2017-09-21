package web.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import web.domian.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    public List<Product> findAll() throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from product";
        return qr.query(sql, new BeanListHandler<>(Product.class));
    }

    public void addProduct(Product p) throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "insert product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?)";
        qr.update(sql, p.getPid(), p.getPname(),p.getMarket_price(),
                p.getShop_price(), p.getPdate(), p.getPdesc());
    }
}
