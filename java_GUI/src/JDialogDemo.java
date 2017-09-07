

import javax.swing.*;
import java.awt.*;

/**
 * Created by Snoopy on 2017/3/17.
 */
public class JDialogDemo {
    JFrame jFrame;
    JLabel jLabel;
    JDialog jDialog;

    public JDialogDemo() {
        jFrame = new JFrame("带对话框的JFrame演示窗口");
        jLabel = new JLabel("你好");
        jDialog = new JDialog(jFrame, "对话框", true);
        jDialog.getContentPane().setLayout(new FlowLayout());
        jDialog.getContentPane().add(jLabel);
        jFrame.setSize(500, 500);
//        jFrame.setLocation(450,450);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jDialog.setSize(300, 300);
        jDialog.setLocationRelativeTo(null);
        jDialog.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JDialogDemo();
    }
}
