package impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import dao.OrderDao;
import entity.Order;
import entity.OrderItem;
import entity.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/13
 * Time: 21:36
 */
public class OrderDaoImpl implements OrderDao{
    @Override
    public void add(Order order) throws Exception {
        QueryRunner qr = new QueryRunner();
        String sql = "insert orders values(?,?,?,?,?,?,?,?)";
        qr.update(DataSourceUtils.getConnection(),sql, order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),
                order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid());
    }


    @Override
    public void addItem(OrderItem oi) throws Exception {
        QueryRunner qr = new QueryRunner();
        String sql = "insert orderitem values(?,?,?,?,?)";
        qr.update(DataSourceUtils.getConnection(),sql, oi.getItemid(),oi.getCount(),oi.getSubtatal(),oi.getProduct().getPid(),oi.getOrder().getOid());
    }

    @Override
    public int getTotalCount(String uid) throws Exception {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "select count(*) from orders where uid = ?";
        int count = ((Long) qr.query(sql, new ScalarHandler(), uid)).intValue();
        return count;
    }

    @Override
    public List<Order> findAllByPage(Integer currPage, int pageSize, String uid) throws Exception {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from orders where uid = ? order by ordertime desc limit ? , ?";
        List<Order> list = qr.query(sql, new BeanListHandler<>(Order.class), uid, (currPage - 1) * pageSize, pageSize);
        sql="select * from orderitem oi,product p where oi.pid = p.pid and oi.oid = ?";
        for (Order order : list) {
            List<Map<String, Object>> mList = qr.query(sql, new MapListHandler(), order.getOid());
            for (Map<String, Object> map: mList){

                Product product = new Product();
                BeanUtils.populate(product,map);

                OrderItem orderItem = new OrderItem();
                BeanUtils.populate(orderItem,map);

                orderItem.setProduct(product);
                order.getItems().add(orderItem);
            }
        }
        return list;
    }
}
