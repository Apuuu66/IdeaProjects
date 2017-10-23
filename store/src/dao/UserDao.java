package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDao {

    void add(User user) throws Exception;

    User getUserByCode(String code) throws SQLException;

    void update(User user) throws SQLException;
}
