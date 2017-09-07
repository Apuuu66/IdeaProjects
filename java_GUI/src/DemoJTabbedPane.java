

import javax.swing.*;

/**
 * Created by Snoopy on 2017/3/22.
 */
public class DemoJTabbedPane {
    JTabbedPane jTabbedPane;
    JLabel jLabel1, jLabel2;
    JFrame jFrame;

    public DemoJTabbedPane() {
        jFrame = new JFrame("选项卡示例");
        jLabel1 = new JLabel("这是第一个选项卡");
        jLabel2 = new JLabel("这是第二个选项卡");
        jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("标签一", jLabel1);
        jTabbedPane.addTab("标签二", jLabel2);
        jFrame.add(jTabbedPane);
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DemoJTabbedPane();
    }
}
