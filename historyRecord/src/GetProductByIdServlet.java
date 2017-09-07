import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "GetProductByIdServlet", urlPatterns = "/getProductById")
public class GetProductByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取指定的id
        String id = request.getParameter("id");
        Cookie c = getCookieByName("ids", request.getCookies());
        String ids = "";
        if (c == null) {
            //若cookie为空 需要将id放入到ids
            ids = id;
        } else {
            ids = c.getValue();
            String[] arr = ids.split("-");
            List<String> list = Arrays.asList(arr);//list长度不可变
            LinkedList<String> linkedList = new LinkedList<String>(list);
            if (linkedList.contains(id)) {
                linkedList.remove(id);
                linkedList.addFirst(id);
            } else {
                if (linkedList.size() > 2) {
                    linkedList.removeLast();
                    linkedList.add(id);
                } else {
                    linkedList.addFirst(id);
                }
            }
            ids = "";
            for (String s : linkedList) {
                ids += s + "-";
            }
            ids = ids.substring(0, ids.length() - 1);
        }

        c = new Cookie("ids", ids);
        c.setPath(request.getContextPath() + "/");
        c.setMaxAge(3600);
        response.addCookie(c);
        //跳转到指定页面上
        response.sendRedirect(request.getContextPath() + "/product_info" + id + ".html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
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
