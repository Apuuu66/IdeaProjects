package servlet;

import service.AccountService;
import service.AccountService4DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AccountServlet",urlPatterns = "/account")
public class AccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter w = response.getWriter();
        String fromuser = request.getParameter("fromuser");
        String touser = request.getParameter("touser");
        String money = request.getParameter("money");
        //            new AccountService().account(fromuser, touser, money);
        try {
            new AccountService4DB().account(fromuser, touser, money);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        w.print("转账成功");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
