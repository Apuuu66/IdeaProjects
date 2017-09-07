
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Snoopy on 2017/3/9.
 */
public class ReMulEvent extends WindowAdapter implements ActionListener {
    JFrame frame;
    JLabel label;
    JTextField textField;
    JButton button;

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() < '0' && e.getKeyChar() > '9') {
                label.setText("你输入了非数字键");
            } else
                label.setText("你输入了数字键");
        }
    }

    public ReMulEvent() {
        MyKeyAdapter myKeyAdapter = new MyKeyAdapter();
        frame = new JFrame("AWT窗口演示");
        label = new JLabel("世界你好");
        button = new JButton("清空内容");
        textField = new JTextField(null, 10);
        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.setSize(800, 400);
//        frame.setLocation(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addWindowListener(this);
        button.addActionListener(this);
        textField.addKeyListener(myKeyAdapter);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            textField.setText(null);
        }
    }

    public static void main(String[] args) {
        new ReMulEvent();
    }
}
