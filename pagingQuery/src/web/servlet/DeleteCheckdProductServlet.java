package web.servlet;

import web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteCheckdProductServlet",urlPatterns = "/deleteCheckdProduct")
public class DeleteCheckdProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] pids = request.getParameterValues("pid");
        try {
            new ProductService().deleteManyProduct(pids);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","商品删除失败");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/findAll");

    }
}
