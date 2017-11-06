package impl;

import dao.ProductDao;
import entity.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
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

    @Override
    public Product getByPid(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid = ? limit 1";
        return qr.query(sql,new BeanHandler<>(Product.class),pid);
    }

    @Override
    public List findByPage(int currPage, int pageSize, String cid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where cid = ? limit ? ,?";
        return qr.query(sql,new BeanListHandler<>(Product.class),cid,(currPage-1)*pageSize,pageSize);
    }

    @Override
    public int getTotalCount(String cid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from product where cid = ?";
        int count =((Long)qr.query(sql,new ScalarHandler(),cid)).intValue();
        return count;
    }
}
