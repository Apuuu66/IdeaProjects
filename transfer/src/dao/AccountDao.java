package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    public void accountOut(String fromuser, String money) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        Connection conn=null;
        PreparedStatement st =null;
        ResultSet rs =null;
        try {
            conn= (Connection) JdbcUtils.getConnection();
            String sql = "update account set money = money - ? where name = ?";
            st=conn.prepareStatement(sql);
            st.setString(1,money);
            st.setString(2,fromuser);
            int i = st.executeUpdate();
            System.out.println("状态："+i);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtils.closeResource(conn,st,rs);
        }
    }

    public void accountIn(String touser, String money) throws SQLException {
        Connection conn=null;
        PreparedStatement st =null;
        ResultSet rs =null;
        try {
            conn= (Connection) JdbcUtils.getConnection();
            String sql = "update  account set money = money + ? where name = ?";
            st=conn.prepareStatement(sql);
            st.setString(1,money);
            st.setString(2,touser);
            int i = st.executeUpdate();
            System.out.println("状态："+i);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }finally {
            JdbcUtils.closeResource(conn,st,rs);
        }
        System.out.println("ok？");
    }
}
