

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Snoopy on 2017/3/22.
 */
public class DemoJLable {
    JLabel jLabel;
    JFrame jFrame;
    Container con;
    MouseListener listenMouse;
    public class ListenMouse extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            jLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }
    public DemoJLable(){
        listenMouse=new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                jLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
        };
        jFrame=new JFrame("图像标签使用示例");
        con=jFrame.getContentPane();
        jLabel = new JLabel("移动到这里");
        con.add(jLabel,BorderLayout.NORTH);
        jLabel.addMouseListener(listenMouse);
        jFrame.setSize(300,300);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DemoJLable();
    }
}
