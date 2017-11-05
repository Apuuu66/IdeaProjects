package servlet;

import entity.Category;
import entity.Product;
import impl.ProductServiceImpl;
import service.ProductService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends BaseServlet {
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductService ps = new ProductServiceImpl();
        List<Product> newList=ps.findNew();
        List<Product> hotList = ps.findHot();
        request.setAttribute("nList",newList);
        request.setAttribute("hList",hotList);
        return "/jsp/index.jsp";
    }
}
