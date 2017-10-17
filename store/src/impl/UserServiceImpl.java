package impl;

import dao.UserDao;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void regist(User user) throws Exception {
        UserDao dao=new UserDaoImpl();
        dao.add(user);
    }
}
