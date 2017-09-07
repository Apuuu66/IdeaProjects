import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "ClearHistoryServlet", urlPatterns = "/clearHistory")
public class ClearHistoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("ids", "");
        cookie.setPath(request.getContextPath()+"/" );
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath()+"/product_list.jsp");

        //在<a>标签中添加url
        PrintWriter w=response.getWriter();
        w.print("已经将XX商品添加到购物车中了");
        w.print("已经将XX商品添加到购物车中了");
        w.print("<a href='"+request.getContextPath()+"/*.jsp'>继续购物</a>");
    }
}
