

import javax.swing.*;
import java.awt.*;
import java.nio.ByteOrder;

/**
 * Created by Snoopy on 2017/3/22.
 */
public class DemoJToolBar {
    JFrame jFrame;
    JToolBar jToolBar;
    JButton jButton1,jButton2;
    Container con;
    public DemoJToolBar(){
        jFrame=new JFrame("JToolBar使用示例");
        con=jFrame.getContentPane();
        jToolBar=new JToolBar();
        jButton1=new JButton(new ImageIcon("right.gif"));
        jButton2=new JButton(new ImageIcon("false.gif"));
        jButton1.setToolTipText("打开");
        jButton2.setToolTipText("关闭");
        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        con.add(jToolBar, BorderLayout.NORTH);
        jFrame.setSize(500,500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DemoJToolBar();
    }
}
