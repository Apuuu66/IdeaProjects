package impl;

import dao.CategoryDao;
import entity.Category;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import service.CategoryService;

import java.io.InputStream;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() throws Exception {
        //获取流
        InputStream is = CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml");

        CacheManager cm = CacheManager.create(is);

        Cache cache = cm.getCache("categoryCache");
        Element element = cache.get("clist");

        List<Category> list = null;

        if (element == null) {
            CategoryDao cd = new CategoryDaoImpl();
            list = cd.findAll();
            cache.put(new Element("clist",list));
        } else {
            list= (List<Category>) element.getObjectValue();
        }
        return list;
    }
}
