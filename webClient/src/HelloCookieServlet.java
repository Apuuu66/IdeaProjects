import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloCookieServlet",urlPatterns = "/hello")
public class HelloCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter w = response.getWriter();
        //创建一个cookie
        Cookie cookie1 = new Cookie("akey", "avalue");
        Cookie cookie2 = new Cookie("bkey", "bvalue");
        Cookie cookie3 = new Cookie("ckey", "cvalue");
        //写回浏览器
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        //提示信息
        w.print("cookie,已写回");
    }
}
