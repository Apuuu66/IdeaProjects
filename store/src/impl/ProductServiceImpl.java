package impl;

import dao.ProductDao;
import entity.PageBean;
import entity.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Override
    public List<Product> findNew() throws Exception {
        ProductDao pdao=new ProductDaoImpl();
        return  pdao.findNew();
    }

    @Override
    public List<Product> findHot() throws Exception {
        ProductDao pdao=new ProductDaoImpl();
        return pdao.findHot();
    }

    @Override
    public Product getByPid(String pid) throws Exception {
        ProductDao dao =new ProductDaoImpl();
        return dao.getByPid(pid);
    }

    @Override
    public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
        ProductDao dao =new ProductDaoImpl();
        List<Product> list=dao.findByPage(currPage,pageSize,cid);
        int totalCount=dao.getTotalCount(cid);
        return new PageBean<>(list,currPage,pageSize,totalCount);
    }

}
