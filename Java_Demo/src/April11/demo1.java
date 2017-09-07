package April11;

import java.io.IOException;

/**
 * Created by Snoopy on 2017/4/11.
 */
public class demo1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String value = System.getProperty("os.name");
        System.out.println(value);
        Runtime runtime = Runtime.getRuntime();
        Process process =runtime.exec("C:\\Windows\\notepad.exe");
        Thread.sleep(1000);
        process.destroy();
    }
}
