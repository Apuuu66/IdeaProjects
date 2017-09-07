package June5_hostip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Snoopy on 2017/6/5.
 */
public class IP {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress=InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }
}
