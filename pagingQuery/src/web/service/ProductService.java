package web.service;

import web.dao.ProductDao;
import web.domian.PageBean;
import web.domian.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    public List<Product> findAll() throws SQLException {
        return new ProductDao().findAll();
    }

    public void addProduct(Product p) throws SQLException {
        new ProductDao().addProduct(p);
    }

    public Product getProductById(String pid) throws SQLException {
        return new ProductDao().getProductById(pid);
    }

    public void modifyProduct(Product p) throws SQLException {
        new ProductDao().modifyProduct(p);
    }

    public void deleteProductById(String pid) throws SQLException {
        new ProductDao().deleteProductById(pid);
    }

    public void deleteManyProduct(String[] pids) throws SQLException {
        ProductDao pdao = new ProductDao();
        for (String pid : pids) {
            pdao.deleteProductById(pid);

        }
    }

    public List<Product> findProductByCondition(String name, String kw) throws SQLException {
        return new ProductDao().findProductByCondition(name, kw);
    }


//    currPage  当前页码
//    pageSize  每页记录条数
    public PageBean<Product> showProductsByPage(int currPage, int pageSize) throws SQLException {
        //查询当前页数据 limit
        ProductDao dao = new ProductDao();
        List<Product> list = dao.findProductByPage(currPage, pageSize);
        //查询总条数
        int totalCount=dao.getCount();
        return new PageBean<>(list, currPage, pageSize, totalCount);
    }
}
