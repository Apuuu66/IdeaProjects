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
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = new UserService().login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user==null){
            request.setAttribute("msg","用户名密码不匹配");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("user",user);

            if ("ok".equals(request.getParameter("autoLogin"))) {
                Cookie c=new Cookie("autologin",username+"-"+password);
                c.setMaxAge(3600);
                c.setPath(request.getContextPath()+"/");
                response.addCookie(c);
            }
            response.sendRedirect(request.getContextPath()+"/success.jsp");
        }
    }
}
