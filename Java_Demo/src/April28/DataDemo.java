package April11.April28;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by wYiGui on 2017/4/28.
 */
public class DataDemo {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
        Calendar calendar= Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.SECOND));
    }
}
