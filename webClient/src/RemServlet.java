import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "RemServlet", urlPatterns = "/rem")
public class RemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //获取指定cookie
        Cookie c = getCookieByName("lastTime", request.getCookies());
        //按断cookie是否为空
        if (c == null) {
            writer.print("您是第一次登陆.");
        } else {
            Long time = Long.parseLong(c.getValue());
            writer.print("上次登陆的时间是" + new Date(time).toLocaleString());
        }
        //将当前访问时间记录
        c = new Cookie("lastTime", new Date().getTime() + "");
        //持久化cookie
        c.setMaxAge(3600);
        //设置路径
        c.setPath(request.getContextPath()+"/");
        //创建cookie 写回浏览器
        response.addCookie(c);
    }

    private Cookie getCookieByName(String name, Cookie[] cookies) {

        if (name != null) {
            for (Cookie c : cookies) {
                if (name.equals(c.getName()))
                    return c;
            }
        }
        return null;
    }
}
