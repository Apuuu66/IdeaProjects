package service;

import dao.AccountDao4DB;
import utils.DataSourceUtils;

import java.sql.SQLException;

public class AccountService4DB {

    public void account(String fromuser, String touser, String money) throws SQLException {
        AccountDao4DB dao = new AccountDao4DB();
        try {
            //0.开启事务
            DataSourceUtils.startTransaction();

            //1.转出
            dao.accountOut(fromuser,money);

//            int i=1/0;

            //2.转入
            dao.accountIn(touser,money);

            //3.事务提交
            DataSourceUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            DataSourceUtils.rollbackAndClose();
            throw e;
        }
    }
}
