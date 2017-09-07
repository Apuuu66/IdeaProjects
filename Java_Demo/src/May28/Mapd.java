package May28;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Snoopy on 2017/5/28.
 */
public class Mapd {
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "2");
        map.put("3", "2");
        map.put("4", "2");
        map.put("2", "2");
        System.out.println(map);
//        map.clear();
//        Set<String> set = map.keySet();
//        Iterator<String> it = set.iterator();
//        while (it.hasNext()) {
//            String key = it.next();
//            System.out.println(key + ":" + map.get(key));
//        }
        Set<Map.Entry<String, String>> entry = map.entrySet();
        Iterator <Map.Entry<String,String>>iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String ,String > entry1=  iterator.next();
            System.out.println(entry1);
        }
    }
}
