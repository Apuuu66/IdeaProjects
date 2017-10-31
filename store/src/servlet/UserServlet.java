package servlet;

import entity.User;
import impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import service.UserService;
import utils.MD5Utils;
import utils.MyConventer;
import utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    public String add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add方法执行了");
        return null;
    }

    public String registUI(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "/jsp/register.jsp";
    }

    public String regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();

        ConvertUtils.register(new MyConventer(), Date.class);

        BeanUtils.populate(user, request.getParameterMap());
        user.setUid(UUIDUtils.getId());
        user.setCode(UUIDUtils.getCode());
        user.setPassword(MD5Utils.md5(user.getPassword()));
        UserService s = new UserServiceImpl();
        s.regist(user);
        request.setAttribute("msg", "用户注册成功，请去邮箱激活~~~");
        return "/jsp/msg.jsp";
    }

    public String active(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = request.getParameter("code");
        UserService s = new UserServiceImpl();
        User user = s.active(code);
        if (user == null) {
            request.setAttribute("msg", "请重新激活");
        } else {
            request.setAttribute("msg", "激活成功");
        }

        return "jsp/msg.jsp";
    }

    public String loginUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/jsp/login.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = MD5Utils.md5(password);
        UserService s = new UserServiceImpl();
        User user = s.login(username, password);
        if (user == null) {
            request.setAttribute("msg", "用户名密码不匹配");
            return "/jsp/login.jsp";
        } else {
            if (1 != user.getState()) {
                request.setAttribute("msg", "用户未激活");
                return "jsp/login.jsp";
            }

        }
        request.getSession().setAttribute("user", user);
        response.sendRedirect(request.getContextPath() + "/");
        return null;
    }


    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        System.out.println(request.getContextPath());
        response.sendRedirect(request.getContextPath() + "/");
        return null;
    }
}
