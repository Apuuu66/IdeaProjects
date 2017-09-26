package service;

import dao.UserDao;
import domain.User;

import java.sql.SQLException;

public class UserService {
    public User checkUsername4Ajax(String username) throws SQLException {
        return new UserDao().checkUsername4Ajax(username);
    }
}
