package May26;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Snoopy on 2017/5/26.
 */
class Person implements Comparable{
    @Override
    public String toString() {
        return "地位："+this.id +"是"+this.name;
    }

    int id;
    String name;
    public Person(int id,String name){
        this.id=id;
        this.name=name;
    }
    @Override
    public int compareTo(Object o) {
        Person p= (Person) o;
        return this.id-p.id;
    }
}
class MyComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Person p1= (Person) o1;
        Person p2 = (Person) o2;
        return p1.id-p2.id;
    }
//    public int compare(Person p1,Person p2){
//        return p1.id-p2.id;
//    }
}
public class TreeSetd {
    public static void main(String[] args) {
        TreeSet treeSet=new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        System.out.println(treeSet);
        TreeSet treeSet1 =new TreeSet(new MyComparator());
        treeSet1.add(new Person(1,"儿子"));
        treeSet1.add(new Person(5,"爸爸"));
        treeSet1.add(new Person(4,"妈妈"));
        treeSet1.add(new Person(2,"儿媳"));
        System.out.println(treeSet1);

    }
}
