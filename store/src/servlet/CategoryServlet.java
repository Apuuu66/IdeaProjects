package servlet;

import entity.Category;
import impl.CategoryServiceImpl;
import net.sf.json.JSONArray;
import service.CategoryService;
import utils.BeanFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet {
//    public String rr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        return null;
//    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
//       CategoryService cs=new CategoryServiceImpl();
        CategoryService cs= (CategoryService) BeanFactory.getBean("CategoryService");
        List<Category> list = cs.findAll();
        String date = JSONArray.fromObject(list).toString();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(date);
        return null;
    }

}
