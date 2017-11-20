package dao;

import entity.Order;
import entity.OrderItem;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/13
 * Time: 21:36
 */
public interface OrderDao {
    void add(Order order) throws Exception;

    void addItem(OrderItem oi) throws Exception;

    int getTotalCount(String uid) throws Exception;

    List<Order> findAllByPage(Integer currPage, int pageSize, String uid) throws Exception;
}
