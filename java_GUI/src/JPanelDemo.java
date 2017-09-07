

import javax.swing.*;
import java.awt.*;

/**
 * Created by Snoopy on 2017/3/17.
 */
public class JPanelDemo {
    JPanel jPanel;
    JFrame jFrame;
    JLabel jLabel;

    public JPanelDemo() {
        jFrame = new JFrame("示例");
        jFrame.setSize(300, 300);
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jLabel = new JLabel("JPanel");
        jPanel.add(jLabel);
        jFrame.add(jPanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
