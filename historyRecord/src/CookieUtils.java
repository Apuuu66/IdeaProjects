import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie getCookieByName(String name, Cookie[] cookies) {

        if (name != null) {
            for (Cookie c : cookies) {
                    if (name.equals(c.getName()))
                        return c;
            }
        }
        return null;
    }
}
