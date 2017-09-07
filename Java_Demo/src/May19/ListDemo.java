package May19;
import java.util.*;

/**
 * Created by Snoopy on 2017/5/19.
 */
public class ListDemo {
    public static void main(String[] args) {
        List c = new ArrayList();
        c.add(1);
        c.add("jiaoqiqi");
        c.add(1.2);
        c.add("qwe");
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
        ListIterator it = c.listIterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//            it.remove();
//        }
        while (it.hasNext())
            System.out.println(it.next());
        Collection coll= new ArrayList();
    }
}
