package web.servlet;

import web.domian.PageBean;
import web.domian.Product;
import web.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ShowProductsByPageServlet", urlPatterns = "/showProductsByPage")
public class ShowProductsByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取第几页
        int currPage = Integer.parseInt(request.getParameter("currPage"));
        int pageSize = 3;

        //调用service完成分页查询 返回值pagebean
        PageBean<Product> bean = null;
        try {
            bean = new ProductService().showProductsByPage(currPage, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //将pagebean放入request域中，请求转发product_page.jsp
        request.setAttribute("pb",bean);
        request.getRequestDispatcher("/product_page.jsp").forward(request,response);

    }
}
