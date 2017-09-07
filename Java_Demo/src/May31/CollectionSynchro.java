package May31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Snoopy on 2017/5/31.
 */
//把集合变成同步线程安全的
public class CollectionSynchro {
    public static void main(String[] args) {
//        ArrayList<Integer> list =new ArrayList<Integer>();
//        list=(ArrayList<Integer>)Collections.synchronizedList(list);
        ArrayList<Integer> list=(ArrayList<Integer>) Collections.synchronizedList(new ArrayList<Integer>());
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(123);
        System.out.println(list);
    }
}
