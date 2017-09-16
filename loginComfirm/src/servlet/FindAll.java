package servlet;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FindAll", urlPatterns = "/findAll")
public class FindAll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> pList = null;
        try {
            pList = new ProductService().findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list",pList);
        request.getRequestDispatcher("/product_list1.jsp").forward(request,response);

    }
}
