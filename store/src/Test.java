import org.apache.commons.dbutils.QueryRunner;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws SQLException {
        QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from date";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String s = sdf.format(date);
//        System.out.println(s);
        Timestamp s = new Timestamp(new Date().getTime());
        System.out.println(s.toString());
//        qr.update("insert date values(?)",s);
//
//        List<User> list=qr.query(sql, new BeanListHandler<>(User.class));
//        for (int i = 0; i < list.size(); i++) {
//            User user =  list.get(i);
//            System.out.println(user.getName());
//        }
//        InputStream is = CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml");
//        System.out.println(is);
//        Date date = new Date();
//        System.out.println(date.getTime());
//        java.sql.Date date1 = new java.sql.Date(date.getTime());
//        Timestamp timestamp = new Timestamp(date.getTime());
//        System.out.println(date1);
//        System.out.println(timestamp);

        // util.date转换成sql.date
//        java.util.Date utilDate = new java.util.Date();    //获取当前时间
//        System.out.println(utilDate);
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//        System.out.println(sqlDate);
//
//// sql.date转换成util.date
//        java.sql.Date sqlDate1 = new java.sql.Date(new java.util.Date().getTime());
//        System.out.println(sqlDate1);
//        java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
//        System.out.println(utilDate1);


    }
}
