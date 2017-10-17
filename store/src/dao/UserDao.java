package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDao {

    void add(User user) throws Exception;
}
