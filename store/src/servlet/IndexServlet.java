package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends BaseServlet {
    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "/jsp/index.jsp";
    }
}
