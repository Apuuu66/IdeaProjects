
import javax.swing.*;

/**
 * Created by Snoopy on 2017/3/20.
 */
public class JSplistPaneDemo {
    JSplitPane jSplitPane;
    JFrame jFrame;
    JLabel jLabel1, jLabel2;

    public JSplistPaneDemo() {
        jFrame = new JFrame("JSplistPane示例");
        jLabel1 = new JLabel("这是左边的窗口");
        jLabel2 = new JLabel("这是右边的窗口");
        jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, jLabel1, jLabel2);
        jFrame.add(jSplitPane);
        jFrame.setSize(300, 300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JSplistPaneDemo();
    }
}
