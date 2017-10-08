package service;

import dao.UserDao;
import entry.User;

import java.sql.SQLException;

public class UserService {
    public User login(String username, String password) throws SQLException {
        return new UserDao().getUserByUsernameAndPwd(username,password);
    }
}
