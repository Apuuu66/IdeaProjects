import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Snoopy on 2017/3/23.
 */
public class DemoJText {
    JLabel jLabel1, jLabel2;
    JFrame jFrame;
    Container con;
    JButton loginBtn, cancelBtn;
    JTextField userText;
    JPasswordField jPasswordField;
    HandleAction handleAction;

    public class HandleAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String msg;
            if (e.getSource()==loginBtn){
                msg="Your user name is:"+userText.getText()+
                        "\nI want to tell you:"+new String(jPasswordField.getPassword());
                JOptionPane.showMessageDialog(jFrame,msg);
            }else if (e.getSource()== cancelBtn){
                jPasswordField.setText("");
                userText.setText("");
            }
        }
    }
    public DemoJText(){
        handleAction =new HandleAction();
        jLabel1=new JLabel("用户");
        jLabel2=new JLabel("密码");
        jFrame=new JFrame("密码框使用示例");
        con=jFrame.getContentPane();
        loginBtn=new JButton("Login");
        loginBtn.addActionListener(handleAction);
        cancelBtn=new JButton("Cancel");
        cancelBtn.addActionListener(handleAction);
        userText=new JTextField();
        userText.setColumns(20);
        jPasswordField=new JPasswordField();
        jPasswordField.setColumns(20);
        con.setLayout(new FlowLayout());
        con.add(jLabel1);
        con.add(userText);
        con.add(jLabel2);
        con.add(jPasswordField);
        con.add(loginBtn);
        con.add(cancelBtn);
        jFrame.setSize(300,300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new DemoJText();
    }
}
