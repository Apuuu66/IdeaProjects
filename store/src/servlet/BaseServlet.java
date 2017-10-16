package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@SuppressWarnings("all")
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //获取子类
            Class clazz = this.getClass();
            System.out.println(this);
            //获取请求方法
            String m = request.getParameter("method");

            if(m==null){
                m="index";
            }
            //获取方法对象
            Method method = clazz.getMethod(m, HttpServletRequest.class, HttpServletResponse.class);
            String s = (String) method.invoke(this, request, response);
            System.out.println(s);
            if (s != null) {
                request.getRequestDispatcher(s).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }

}
