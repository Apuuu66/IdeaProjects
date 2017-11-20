package servlet;

import entity.*;
import service.OrderService;
import utils.BeanFactory;
import utils.UUIDUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/13
 * Time: 21:12
 */
@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    /**
      *description: 生成订单  
      *return: 转发页面
      */      
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg","请先登录");
            return "/jsp/msg.jsp";
        }

        //封装Order全部数据
        Order order = new Order();

        //1.1订单id
        order.setOid(UUIDUtils.getId());

        //1.2订单时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOrdertime(sdf.format(date));

        //1.3总金额  获取session中的cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        order.setTotal(cart.getTotal());
        //1.4设置订单的所有订单项
        Collection<CartItem> items = cart.getItems();
        for (CartItem cartItem:items) {
            OrderItem oi=new OrderItem();
            oi.setItemid(UUIDUtils.getId());
            oi.setCount(cartItem.getCount());
            oi.setSubtatal(cartItem.getSubtotal());
            oi.setProduct(cartItem.getProduct());
            oi.setOrder(order);
            order.getItems().add(oi);
        }
        //1.5设置用户
        order.setUser(user);
        //2.调用service添加订单
        OrderService os= (OrderService) BeanFactory.getBean("OrderService");
        os.add(order);
        //3.将订单放入request中
        request.setAttribute("bean",order);
        request.getSession().removeAttribute("cart");
        return "/jsp/order_info.jsp";
    }
/**
  *description: 分页查询我的订单
  *return:
  */
    public String findAllByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer currPage = Integer.parseInt(request.getParameter("currPage"));
        if (currPage==null){
            currPage=1;
        }
        int pageSize=3;
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg","您还没有登录，请先登录");
            return "/jsp/msg.jsp";
        }
        OrderService os= (OrderService) BeanFactory.getBean("OrderService");
        PageBean<Order> bean=os.findAllByPage(currPage,pageSize,user);
        request.setAttribute("pb",bean);
        return "/jsp/order_list.jsp";
    }
}
