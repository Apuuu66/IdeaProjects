package May30;

import java.util.TreeMap;

/**
 * Created by Snoopy on 2017/5/30.
 */
public class TreeMapd {
    public static void main(String[] args) {
        TreeMap<Emp,Integer> treeMap=new TreeMap<Emp,Integer>();
        treeMap.put(new Emp("齐齐",10000),111);
        treeMap.put(new Emp("媳妇",1000),222);
        System.out.println(treeMap);

    }
}
