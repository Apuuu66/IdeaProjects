package impl;

import dao.UserDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    @Override
    public void add(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert user values(?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(), user.getEmail(),user.getTelephone(),
                user.getBirthday(),user.getSex(),user.getState(),user.getCode());
    }
}
