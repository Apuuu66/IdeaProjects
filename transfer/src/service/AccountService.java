package service;

import dao.AccountDao;

import java.sql.SQLException;

public class AccountService {
    public void account(String fromuser, String touser, String money) throws SQLException {
        AccountDao dao = new AccountDao();
        //装出
        dao.accountOut(fromuser,money);
        //转入
        dao.accountIn(touser,money);
    }
}
