package filter;

import entry.User;
import service.UserService;
import utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;

//@WebFilter(filterName = "AutoLoginFilter", urlPatterns = "/*")
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
                try {
                    Cookie c = CookieUtils.getCookieByName("autoLogin", request.getCookies());
                    if (c != null) {
                        String enName = c.getValue().split("-")[0];
                        System.out.println(enName);
                        String username= URLDecoder.decode(enName,"utf-8");
                        System.out.println(username);
                        String password = c.getValue().split("-")[1];
                        try {
                            user = new UserService().login(username, password);
                            if (user != null) {
                                request.getSession().setAttribute("user", user);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                } catch (Exception e) {
                }
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
