package May20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Snoopy on 2017/5/20.
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add("急啊");
        coll.add(new A(1,1));
        System.out.println(coll.size());
        Iterator it=coll.iterator();

    }
}
class A{
    int i;
    int j;
    public A(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return this.i+" "+this.j;
    }
}