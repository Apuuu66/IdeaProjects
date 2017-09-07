package May30;

/**
 * Created by Snoopy on 2017/5/30.
 */
public class Emp implements Comparable<Emp>{
    String name;
    int salary;

    @Override
    public int compareTo(Emp o) {
        return this.salary-o.salary;
    }

    public Emp(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "["+this.name+" "+this.salary+"]";
    }
}
