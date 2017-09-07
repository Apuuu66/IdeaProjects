package May25;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Snoopy on 2017/5/25.
 */
public class Linklistd {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.push(6);
        list.push(7);
        System.out.println(list);
        list.pop();
        System.out.println(list);
        list.pop();
        System.out.println(list);
    }
}
