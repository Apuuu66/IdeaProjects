package web.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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

    public Product getProductById(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from product where pid=?";
        return qr.query(sql,new BeanHandler<>(Product.class),pid);
    }

    public void modifyProduct(Product p) throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "update product set pname = ?,market_price = ?," +
                "shop_price = ?,pdesc = ? where pid = ?";
        qr.update(sql,p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdesc(),p.getPid());
    }
}
