package filter;

import entry.User;
import service.UserService;
import utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "AutoLoginFilter", urlPatterns = "/*")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            String path = request.getRequestURI();
            System.out.println(path);
            if (!path.contains("/login")) {
                Cookie c = CookieUtils.getCookieByName("autologin", request.getCookies());
                if (c != null) {
                    String username = c.getValue().split("-")[0];
                    String password = c.getValue().split("-")[1];
                    try {
                         user = new UserService().login(username, password);
                        if (user != null) {
                           request.getSession().setAttribute("user", user);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
