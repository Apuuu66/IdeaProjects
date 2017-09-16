package service;

import dao.UserDao;
import domain.User;

import java.sql.SQLException;

public class UserService {
    public User getUserByNameAndPwd(String username, String password) throws SQLException {
        return new UserDao().getUserByNameAndPwd(username,password);
    }
}
