package impl;

import dao.UserDao;
import entity.User;
import service.UserService;
import utils.MailUtils;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public void regist(User user) throws Exception {
        UserDao dao = new UserDaoImpl();
        dao.add(user);
//        String emailMsg = "注册成功，"+"<a href='http://localhost:8080/user?method=active&code=\"+user.getCode()+\"'>点此激活</a>";
//        String emailMsg = "注册成功，点此激活"+"http://localhost:8080/user?method=active&code="+user.getCode();
        String emailMsg = "注册成功，点此激活" + "http://www.fionar.xyz";
        MailUtils.sendMail(user.getEmail(), emailMsg);
    }

    @Override
    public User active(String code) throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = dao.getUserByCode(code);
        if (user == null) {
            System.out.println("null");
            return null;
        }
        user.setState(1);
        dao.update(user);
        return user;
    }

    @Override
    public User login(String username, String password) throws Exception {
        UserDao dao=new UserDaoImpl();
        return dao.getByUsernameAndPwd(username,password);
    }
}