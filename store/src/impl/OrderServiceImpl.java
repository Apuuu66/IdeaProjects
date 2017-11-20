package impl;

import dao.OrderDao;
import entity.Order;
import entity.OrderItem;
import entity.PageBean;
import entity.User;
import service.OrderService;
import utils.BeanFactory;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/13
 * Time: 21:35
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void add(Order order) throws Exception {
        //1.开启事务
        try {
            DataSourceUtils.startTransaction();
            OrderDao od= (OrderDao) BeanFactory.getBean("OrderDao");
            od.add(order);
            for (OrderItem oi :order.getItems()) {
                    od.addItem(oi);
            }
            DataSourceUtils.commitAndClose();
        } catch (SQLException e) {
            e.printStackTrace();
            DataSourceUtils.rollbackAndClose();
            throw e;
        }
        //2.向数据库中添加数据
        //3.向orderItem中添加n条数据
        //4.事务处理
    }
/**
  *description: 分页查询
  *return:
  */

    @Override
    public PageBean<Order> findAllByPage(Integer currPage, int pageSize, User user) throws Exception {
        OrderDao od= (OrderDao) BeanFactory.getBean("OrderDao");
        List<Order> list=od.findAllByPage(currPage,pageSize,user.getUid());
        int totalCount=od.getTotalCount(user.getUid());
        return new PageBean<Order>(list,currPage,pageSize,totalCount);
    }
}
