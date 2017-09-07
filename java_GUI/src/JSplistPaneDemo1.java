

import javax.swing.*;

/**
 * Created by Snoopy on 2017/3/22.
 */
public class JSplistPaneDemo1 {
    JSplitPane leftJSplistPaneDemo, rightJSplistPaneDemo, mainJSplistPane;
    JFrame jFrame;
    JLabel jLabel1, jLabel2, jLabel3, jLabel4;

    public JSplistPaneDemo1() {
        jFrame = new JFrame("示例");
        jLabel1 = new JLabel("左上");
        jLabel2 = new JLabel("左下");
        jLabel3 = new JLabel("右上");
        jLabel4 = new JLabel("右下");
        leftJSplistPaneDemo = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jLabel1, jLabel2);
        rightJSplistPaneDemo = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jLabel3, jLabel4);
        mainJSplistPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, leftJSplistPaneDemo, rightJSplistPaneDemo);
        jFrame.add(mainJSplistPane);
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JSplistPaneDemo1();
    }
}
