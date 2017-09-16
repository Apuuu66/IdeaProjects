package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public User getUserByNameAndPwd(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql = "select * from user where username = ? and password = ?";

        return qr.query(sql,new BeanHandler<User>(User.class),username,password);
    }
}
