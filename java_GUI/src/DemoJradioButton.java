import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Snoopy on 2017/3/30.
 */
public class DemoJradioButton implements ActionListener {
    JFrame jFrame;
    Container con;
    JButton OKBtn;
    JRadioButton TBtn, FBtn;
    ButtonGroup sexBtnGroup;
    JLabel jLabel;
    String msg;

    public DemoJradioButton() {
        jFrame = new JFrame("JRadioButton示例");
        con = jFrame.getContentPane();
        con.setLayout(new FlowLayout());
        jLabel = new JLabel("请选择性别");
        con.add(jLabel);
        TBtn = new JRadioButton("男", false);
        TBtn.addActionListener(this);
        FBtn = new JRadioButton("女", false);
        FBtn.addActionListener(this);
        sexBtnGroup = new ButtonGroup();
        sexBtnGroup.add(TBtn);
        sexBtnGroup.add(FBtn);
        con.add(TBtn);
        con.add(FBtn);
        OKBtn = new JButton("确定");
        OKBtn.addActionListener(this);
        con.add(OKBtn);
        jFrame.setSize(250, 200);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JRadioButton) {
            msg = e.getActionCommand();
        } else
            JOptionPane.showMessageDialog(jFrame, "你选择了" + msg);
    }

    public static void main(String[] args) {
        new DemoJradioButton();
    }
}
