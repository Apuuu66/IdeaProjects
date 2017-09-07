package June7_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Snoopy on 2017/6/7.
 * TCP通讯协议特点：
 * 1. tcp是基于IO流进行数据 的传输 的，面向连接。
 * 2. tcp进行数据传输的时候是没有大小限制的。
 * 3. tcp是面向连接，通过三次握手的机制保证数据的完整性。 可靠协议。
 * 4. tcp是面向连接的，所以速度慢。
 * 5. tcp是区分客户端与服务端 的。
 * <p>
 * 比如： 打电话、 QQ\feiQ的文件传输、 迅雷下载....
 * <p>
 * tcp协议下的Socket：
 * Socket(客户端) , tcp的客户端一旦启动马上要与服务端进行连接。
 * ServerSocket(服务端类)
 * <p>
 * tcp的客户端使用步骤：
 * 1. 建立tcp的客户端服务。
 * 2. 获取到对应的流对象。
 * 3.写出或读取数据
 * 4. 关闭资源。
 */
public class Clinet {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9090);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务端你好".getBytes());
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        System.out.println("客户端接收到的数据：" + new String(buf, 0, length));
        socket.close();
    }
}
/*
        //建立tcp的服务
        Socket socket = new Socket(InetAddress.getLocalHost(), 9090);
        //获取到Socket的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //利用输出流对象把数据写出即可。
        outputStream.write("服务端你好".getBytes());
        //获取到输入流对象，读取服务端回送的数据。
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        System.out.println("客户端接收到的数据：" + new String(buf, 0, length));
        //关闭资源
        socket.close();
*/
