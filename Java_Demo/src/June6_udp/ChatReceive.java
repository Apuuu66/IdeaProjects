package June6_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Snoopy on 2017/6/6.
 */
public class ChatReceive extends Thread {
    @Override
    public void run() {

        try {
            DatagramSocket socket =new DatagramSocket(9090);
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            boolean flag=true;
            while (flag) {
                socket.receive(packet);
                System.out.println(packet.getAddress().getHostAddress() + "说：" + new String(buf, 0, packet.getLength()));
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
