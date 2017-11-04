package impl;

import dao.CategoryDao;
import entity.Category;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() throws Exception {
        CategoryDao cd = new CategoryDaoImpl();
        return cd.findAll();
    }
}
