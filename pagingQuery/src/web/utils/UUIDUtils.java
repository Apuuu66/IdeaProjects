package web.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
    }
}
