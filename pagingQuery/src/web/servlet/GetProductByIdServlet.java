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

@WebServlet(name = "GetProductByIdServlet",urlPatterns = "/getProductById")
public class GetProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        Product p= null;
        try {
            p = new ProductService().getProductById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","该商品不存在");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }
        if (p==null){
            request.setAttribute("msg","该商品不存在");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
        }
        request.setAttribute("bean",p);
        request.getRequestDispatcher("/edit.jsp").forward(request,response);

    }
}
