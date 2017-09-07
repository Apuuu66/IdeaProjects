package May31;

import java.util.Arrays;

/**
 * Created by Snoopy on 2017/5/31.
 */
public class Dregex {
    public static void main(String[] args) {
//        String string="1    2  3 4 4444   555";
//        String []strin=string.split(" +");
//        System.out.println(Arrays.toString(strin));
        String str = "我喔要要要要学学学学学学刚好嘻嘻嘻嘻嘻嘻";
        String[] date = str.split("(.)\\1+");
        System.out.println(Arrays.toString(date));
//        for (int i = 0; i <date.length ; i++) {
//            System.out.println(date[i]);
//        }
        str = str.replaceAll("(.)\\1+", "$1");
        System.out.println(str);
//        str=str.replaceAll("学","23");
//        System.out.println(str);
    }
}
