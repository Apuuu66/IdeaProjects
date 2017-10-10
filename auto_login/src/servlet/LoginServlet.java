package servlet;

import entry.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = new UserService().login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        Cookie cookie1 = new Cookie("name", "jack");
//        Cookie cookie2 = new Cookie("name", "tom");
//        Cookie cookie3 = new Cookie("name", "tony");
//        response.addCookie(cookie1);
//        response.addCookie(cookie2);
//        response.addCookie(cookie3);

        if (user == null) {
            request.setAttribute("msg", "用户名密码不匹配");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", user);

            if ("ok".equals(request.getParameter("autoLogin"))) {
                Cookie c = new Cookie("autoLogin", URLEncoder.encode(username, "utf-8") + "-" + password);
                c.setMaxAge(3600);
                c.setPath(request.getContextPath() + "/");
                response.addCookie(c);
            }
            if ("ok".equals(request.getParameter("saveName"))) {
                Cookie c = new Cookie("saveName", URLEncoder.encode(username, "utf-8"));
                c.setMaxAge(3600);
                c.setPath(request.getContextPath() + "/");
                response.addCookie(c);
            }
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        }
    }
}
