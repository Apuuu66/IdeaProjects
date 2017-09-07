
import javax.swing.*;
import java.awt.*;

/**
 * Created by Snoopy on 2017/3/17.
 */
public class Painting {
    Mycanvas palette;
    JFrame jFrame;

    public class Mycanvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.red);
            g.drawArc(10, 10, 100, 100, 0, 360);
            g.drawRect(50, 50, 100, 100);
            g.drawString("测试", 30, 30);

        }
    }

    public Painting() {
        jFrame = new JFrame("用JPanel画图示例");
        palette = new Mycanvas();
        jFrame.add(palette);
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Painting();
    }
}
