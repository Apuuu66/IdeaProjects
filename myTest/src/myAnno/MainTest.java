package myAnno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainTest {
    //        public static void main(String[] args) {
//        Class clazz = MyTestTest.class;
//
//        Method[] m = clazz.getMethods();
//        for (Method u : m) {
//            System.out.println(u.getName());
//        }
//    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = MyTestTest.class;
        Method[] m = clazz.getMethods();
        for (Method u : m) {
            boolean flag = u.isAnnotationPresent(MyTest.class);
            if (flag) {
//                System.out.println(u.getName());
                u.invoke(clazz.newInstance());
            }
        }
    }
}
