package servlet;

import entity.PageBean;
import entity.Product;
import impl.ProductServiceImpl;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends BaseServlet {
    public String XXX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }

    public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pid = request.getParameter("pid");
        ProductService ps = new ProductServiceImpl();
        Product p = ps.getByPid(pid);
        request.setAttribute("bean", p);
        return "/jsp/product_info.jsp";
    }

    public String findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String cid = request.getParameter("cid");
        int currPage = Integer.parseInt(request.getParameter("currPage"));
        int pageSize = 12;
        ProductService ps = new ProductServiceImpl();
        PageBean<Product> bean = ps.findByPage(currPage, pageSize, cid);
        request.setAttribute("pb", bean);
        return "/jsp/product_list.jsp";
    }
}
