import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Snoopy on 2017/3/30.
 */
public class DemoJCheckbox implements ActionListener {
    JFrame jFrame;
    Container con;
    JButton OKBtn;
    JCheckBox jCheckBox[];
    JLabel jLabel;
    static final String ProvinceName[] = {"北京", "上海", "天津", "辽宁", "吉林", "四川", "湖南", "湖北", "广东"};

    public DemoJCheckbox() {
        jFrame = new JFrame("JCheckboox示例");
        con = jFrame.getContentPane();
        con.setLayout(new FlowLayout());
        jLabel = new JLabel("请选择至少一个省份");
        con.add(jLabel);
        jCheckBox = new JCheckBox[ProvinceName.length];
        for (int i = 0; i < ProvinceName.length; i++) {
            jCheckBox[i] = new JCheckBox(ProvinceName[i], false);
            con.add(jCheckBox[i]);
        }
        OKBtn = new JButton("确定");
        OKBtn.addActionListener(this);
        con.add(OKBtn);
        jFrame.setSize(100, 300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tmpmsg = "";
        int count = 0;
        for (int i = 0; i < jCheckBox.length; i++) {
            if (jCheckBox[i].isSelected()) {
                count++;
                tmpmsg = tmpmsg + jCheckBox[i].getText() + " ";
            }
        }
        JOptionPane.showMessageDialog(jFrame, "你选择了" + count + "个省份，分别是:\n" + tmpmsg);
    }

    public static void main(String[] args) {
        new DemoJCheckbox();
    }
}
