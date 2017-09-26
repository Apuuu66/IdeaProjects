package servlet;

import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CheckUsername4AjaxServlet",urlPatterns = "/checkUsername4Ajax")
public class CheckUsername4AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        username=new String(username.getBytes("iso8859-1"),"utf-8");
        User user= null;
        try {
            user = new UserService().checkUsername4Ajax(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null)
            response.getWriter().print(1);
        else
            response.getWriter().print(0);

    }
}
