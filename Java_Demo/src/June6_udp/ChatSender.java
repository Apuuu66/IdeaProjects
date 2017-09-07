package June6_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Snoopy on 2017/6/6.
 */
public class ChatSender extends Thread {
    @Override
    public void run() {
        try {
            DatagramSocket socket = new DatagramSocket();
            BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            DatagramPacket packet = null;
            while ((line = keyReader.readLine()) != null) {
                packet = new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getLocalHost(), 9090);
                socket.send(packet);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
