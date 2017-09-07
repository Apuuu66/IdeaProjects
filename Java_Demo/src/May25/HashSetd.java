package May25;

import java.util.HashSet;

/**
 * Created by Snoopy on 2017/5/25.
 */
public class HashSetd implements Comparable {
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) {
        HashSet set =new HashSet();
        set.add(1);  System.out.println(set.hashCode());
        set.add(2);  System.out.println(set.hashCode());
        set.add(3);  System.out.println(set.hashCode());
        set.add(4);  System.out.println(set.hashCode());
        set.add(5);  System.out.println(set.hashCode());
        System.out.println(set);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
