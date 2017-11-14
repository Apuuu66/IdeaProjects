package impl;

import dao.OrderDao;
import entity.Order;
import entity.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

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
}
