

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Snoopy on 2017/3/17.
 */
public class Paint2 {
    JPanel jPanel;
    JFrame jFrame;
    JButton jButton;
    Container con;
    DealPushBtn handelBtn;

    public class DealPushBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Graphics g;
            final int x = 100, y = 100, radio = 50;
            final double scope = 30.0 / 180.0 * Math.PI;
            double angle = 0.0;
            int ox = x + radio, oy = y;
            g = jPanel.getGraphics();
            g.setColor(Color.GREEN);
            for (int i = 0; i < 12; i++) {
                g.drawArc(ox, oy, radio * 2, radio * 2, 0, 360);
                angle += scope;
                ox = (int) (radio * Math.cos(angle) + x);
                ox = (int) (radio * Math.sin(angle) + y);
            }
        }
    }

    public Paint2() {
        jFrame = new JFrame("画图示例");
        jButton = new JButton("画图");
        handelBtn = new DealPushBtn();
        jButton.addActionListener(handelBtn);
        jPanel = new JPanel();
        jPanel.add(jButton);
        jFrame.add(jPanel);
        jFrame.setSize(400, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Paint2();
    }
}
