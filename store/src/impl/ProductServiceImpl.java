package impl;

import dao.ProductDao;
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

}
