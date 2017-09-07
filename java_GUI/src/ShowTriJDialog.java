

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Snoopy on 2017/3/17.
 */
public class ShowTriJDialog implements ActionListener {
    JFrame jFrame;
    JLabel jLabel;
    JDialog jDialog;
    JButton jbtMessage, jbtComfirm, jbtInput;
    Container container;

    public ShowTriJDialog() {
        jFrame = new JFrame("对话框使用范例");
        jbtMessage = new JButton("显示消息对话框");
        jbtComfirm = new JButton("显示确定对话框");
        jbtInput = new JButton("输入对话框");
        container = jFrame.getContentPane();
        container.add(jbtMessage);
        container.add(jbtComfirm);
        container.add(jbtInput);
        container.setLayout(new FlowLayout());
        jbtMessage.addActionListener(this);
        jbtInput.addActionListener(this);
        jbtComfirm.addActionListener(this);
        jFrame.setSize(250, 200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtComfirm) {
            JOptionPane.showConfirmDialog(jFrame, "这是一个三个按钮的对话框/n按任意键返回");
        } else if (e.getSource() == jbtMessage) {
            JOptionPane.showConfirmDialog(jFrame, "这是一个简单的消息框");
        } else
            JOptionPane.showInputDialog(jFrame, "信息输入框");
    }

    public static void main(String[] args) {
        new ShowTriJDialog();
    }
}
