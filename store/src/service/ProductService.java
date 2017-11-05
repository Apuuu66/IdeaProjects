package service;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findNew() throws Exception;

    List<Product> findHot() throws Exception;
}
