package servlet;

import domain.User;
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
        request.setCharacterEncoding("utf-8");
        String rCode = request.getParameter("checkCode");
        Object sCode = request.getSession().getAttribute("sCode");
        //一次性验证码
        request.getSession().removeAttribute("sCode");

        //判断验证码是否相同
        if (rCode == null || sCode == null || rCode.trim().length() == 0) {
            //验证码有问题
            //页面跳转
            request.setAttribute("msg", "请重新输入验证码");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        if (!rCode.equalsIgnoreCase((String) sCode)) {
            //验证码输入不一致
            request.setAttribute("msg", "请重新输入验证码");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user= null;
        try {
            user = new UserService().getUserByNameAndPwd(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user==null){
            request.setAttribute("msg","用户名密码不匹配");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }else {
            if ("ok".equals(request.getParameter("savename"))){
                Cookie c = new Cookie("saveName", username);
                c.setPath(request.getContextPath()+"/");
                c.setMaxAge(3600);
                response.addCookie(c);
            }
            request.getSession().setAttribute("user",user);
        }
        //页面重定向
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
