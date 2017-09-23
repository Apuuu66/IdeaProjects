package web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import web.domian.Product;
import web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProductServlet",urlPatterns = "/editProduct")
public class EditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Product p = new Product();
        try {
            BeanUtils.populate(p,request.getParameterMap());
            new ProductService().modifyProduct(p);
            response.sendRedirect(request.getContextPath()+"/findAll");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","修改商品出错了" );
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }
    }
}
