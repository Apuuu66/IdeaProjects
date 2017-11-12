package impl;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public void add(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert user values(?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(),
                user.getName(), user.getEmail(), user.getTelephone(),
                user.getBirthday(), user.getSex(), user.getState(), user.getCode());
    }

    @Override
    public User getUserByCode(String code) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where code = ? limit 1";
        return qr.query(sql, new BeanHandler<User>(User.class), code);
    }

    @Override
    public void update(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set username = ?,password = ? ,name = ?,email = ?,birthday = ?,state = ?,code=? where uid =? ";
        qr.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getBirthday(),
                user.getState(), null, user.getUid());
        System.out.println("ok");
    }

    @Override
    public User getByUsernameAndPwd(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username = ? and password = ? limit 1";
        return qr.query(sql, new BeanHandler<>(User.class), username, password);
    }
}
