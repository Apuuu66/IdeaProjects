import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Snoopy on 2017/3/23.
 */
public class DemoJButton implements ActionListener {
    JButton shiftJbt;
    JFrame jFrame;
    Container con;
    ImageIcon closeIcon, openIcon;

    public DemoJButton() {
        jFrame = new JFrame("JButton");
        con = jFrame.getContentPane();
        closeIcon = new ImageIcon("false.gif");
        openIcon = new ImageIcon("open.gif");
        shiftJbt = new JButton("打开", openIcon);
        con.add(shiftJbt, BorderLayout.NORTH);
        shiftJbt.addActionListener(this);
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shiftJbt) {
            if (shiftJbt.getText().compareTo("打开") == 0) ;
            shiftJbt.setText("关闭");
            shiftJbt.setIcon(closeIcon);

        } else {
            shiftJbt.setText("打开");
            shiftJbt.setIcon(openIcon);
        }
    }

    public static void main(String[] args) {
        new DemoJButton();
    }
}
