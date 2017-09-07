package June6_udp;

/**
 * Created by Snoopy on 2017/6/6.
 */
public class ChatMain {
    public static void main(String[] args) {
        ChatReceive chatReceive=new ChatReceive();
        chatReceive.start();
        ChatSender chatSender=new ChatSender();
        chatSender.start();
    }
}
