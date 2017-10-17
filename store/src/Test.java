import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user";

        List<User> list=qr.query(sql, new BeanListHandler<>(User.class));
        for (int i = 0; i < list.size(); i++) {
            User user =  list.get(i);
            System.out.println(user.getName());
        }
    }
}
