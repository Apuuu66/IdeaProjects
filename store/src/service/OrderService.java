package service;

import entity.Order;
import entity.PageBean;
import entity.User;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/13
 * Time: 21:35
 */
public interface OrderService {
    void add(Order order) throws Exception;

    PageBean<Order> findAllByPage(Integer currPage, int pageSize, User user) throws Exception;
}
