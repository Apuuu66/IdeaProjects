package myAnno;

@SuppressWarnings("all")
public class MyTestTest {
    @MyTest
    public void f1() {
        System.out.println("f1执行了");
    }

    @MyTest
    public void f2() {
        System.out.println("f2执行了");
    }

    @MyTest
    public void f3() {
        System.out.println("f3执行了");
    }

    @MyTest
    public void f4() {
        System.out.println("f4执行了");
    }

}
