package web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import web.domian.Product;
import web.service.ProductService;
import web.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AddProductServlet", urlPatterns = "/addProduct")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String r_code = request.getParameter("r_code");
        Object s_code = request.getSession().getAttribute("s_code");
        request.getSession().removeAttribute("s_code");
        if(s_code==null || !s_code.equals(r_code))
        {
            request.setAttribute("msg","商品已保存");
            request.getRequestDispatcher("/msg.jsp").forward(request,response);
            return;
        }


        Product p = new Product();
        try {
            BeanUtils.populate(p, request.getParameterMap());
            p.setPid(UUIDUtils.getId());
            p.setPdate(new Date());
            new ProductService().addProduct(p);
            request.getRequestDispatcher("/findAll").forward(request, response);
//            response.sendRedirect(request.getContextPath()+"/findAll");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "添加商品失败");
            request.getRequestDispatcher("/msg.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);


    }
}
