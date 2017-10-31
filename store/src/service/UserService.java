package service;

import entity.User;

import java.sql.SQLException;

public interface UserService {

    void regist(User user) throws Exception;

    User active(String code) throws SQLException;

    User login(String username, String password) throws Exception;
}
