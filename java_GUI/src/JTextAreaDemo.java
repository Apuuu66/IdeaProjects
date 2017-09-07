import javax.swing.*;

/**
 * Created by Snoopy on 2017/3/30.
 */
public class JTextAreaDemo {
    JFrame jFrame;
    JScrollPane jScrollPane;
    JTextArea jTextArea;
    public JTextAreaDemo(){
        jFrame=new JFrame("JTextArea示例");
        jTextArea =new JTextArea();
        jScrollPane=new JScrollPane(jTextArea);
        jFrame.add(jScrollPane);
        jFrame.setSize(300,300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JTextAreaDemo();
    }
}
