package entry;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class c {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String s = "齐齐";
        String s = "qwe123";

        s = URLEncoder.encode(s, "utf-8");
        System.out.println(s);
        s = URLDecoder.decode(s, "utf-8");
        System.out.println(s);

    }
}
