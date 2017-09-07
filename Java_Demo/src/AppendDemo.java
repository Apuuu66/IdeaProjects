import java.io.IOException;
import java.util.Properties;

/**
 * Created by Snoopy on 2017/4/11.
 */
public class AppendDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        StringBuffer sb = new StringBuffer();
        sb.ensureCapacity(2);
        sb.append(2.2f);
        sb.append(123);
        sb.append(true);
        sb.insert(2,123);
        sb.delete(1,4);
        System.out.println(sb);
        System.out.println(sb.capacity());
        System.out.println(System.currentTimeMillis());


        System.out.println(System.getenv("path"));
        Properties properties=System.getProperties();
        properties.list(System.out);

    }
}
