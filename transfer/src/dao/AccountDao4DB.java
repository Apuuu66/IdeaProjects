package dao;

import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class AccountDao4DB {

    public void accountOut(String fromuser, String money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql= "update account set money = money - ? where name = ?";
        qr.update(DataSourceUtils.getConnection(),sql,money,fromuser);

    }

    public void accountIn(String touser, String money) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql= "update account set money = money + ? where name = ?";
        qr.update(DataSourceUtils.getConnection(), sql, money, touser);
    }
}
