package servlet;

import entity.Category;
import impl.CategoryServiceImpl;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends BaseServlet {
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/index.jsp";
    }
}
