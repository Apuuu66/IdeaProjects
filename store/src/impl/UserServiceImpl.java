package impl;

import dao.UserDao;
import entity.User;
import service.UserService;
import utils.MailUtils;

public class UserServiceImpl implements UserService {
    @Override
    public void regist(User user) throws Exception {
        UserDao dao = new UserDaoImpl();
        dao.add(user);
        String emailMsg = "注册成功";
//                "<a href='http://localhost:8080/user?method=active&code=\"+user.getCode()+\"'>点此激活</a>";
        MailUtils.sendMail(user.getEmail(), emailMsg);
    }
}