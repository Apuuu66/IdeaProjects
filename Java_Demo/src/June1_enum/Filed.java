package June1_enum;

import java.io.File;

/**
 * Created by Snoopy on 2017/6/1.
 */
public class Filed {
    public static void main(String[] args) {
//        File file=new File("C:\\Users\\Snoopy\\Desktop\\新建文本文档.txt");//两种路径引用都可以
        File file=new File("C:/Users/Snoopy/Desktop/新建文本文档.txt");
        System.out.println(file.exists());
        System.out.println(File.separator);
        File file1=new File(".");
        System.out.println(file1.getAbsolutePath());
    }
}
