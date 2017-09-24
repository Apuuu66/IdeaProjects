package web.servlet;

import web.domian.Product;
import web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FindProductByConditionServlet",urlPatterns = "/findProductByCondition")
public class FindProductByConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String kw = request.getParameter("kw");
        List<Product> list= null;
        try {
            list = new ProductService().findProductByCondition(name,kw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        request.getRequestDispatcher("/product_list.jsp").forward(request,response);
    }
}
