package web.servlet;

import web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteProductByIdServlet",urlPatterns = "/deleteProductById")
public class DeleteProductByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取商品id
        String pid = request.getParameter("pid");
        try {
            new ProductService().deleteProductById(pid);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","商品删除失败");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
            return;
        }
        //重定向
        response.sendRedirect(request.getContextPath()+"/findAll");

    }
}
