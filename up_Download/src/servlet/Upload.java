package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "Upload", urlPatterns = "/upload")
@MultipartConfig
public class Upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        String f = request.getParameter("f");
        System.out.println(f);
        //获取上传文件
        Part part = request.getPart("f");
        String name = part.getName();
        System.out.println(name);

        //获取文件名
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String filename = header.substring(header.indexOf("filename=") + 10,header.length()-1);
        System.out.println(filename);


        InputStream is = part.getInputStream();
        FileOutputStream os = new FileOutputStream("d:/"+filename);
        IOUtils.copy(is,os);
        os.close();
        is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
