import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Snoopy on 2017/3/29.
 */
public class Login {
    JLabel jLabel1,jLabel2;
    JFrame jFrame;
    Container con;
    JButton loginBtn,cancelBtn;
    JTextField userText;
    JPasswordField passwordField;
    HandleAction handleAction;
    public class HandleAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String msg;
            if (e.getSource()==loginBtn){
                msg="你的用户名是:"+userText.getText()+
                        "你的密码是:"+new String(passwordField.getPassword());
                JOptionPane.showMessageDialog(jFrame,msg);
            }else if(e.getSource()==cancelBtn){
                    passwordField.setText("");
                    userText.setText("");
            }else if (e.getSource()==userText){
                passwordField.requestFocus();
            }else if(e.getSource()==passwordField){
                loginBtn.doClick();
            }
        }
    }
    public Login(){
        handleAction =new HandleAction();
        jLabel1=new JLabel("用户名");
        jLabel2=new JLabel("  密码  ");
        jFrame=new JFrame("登陆");
        con=jFrame.getContentPane();
        loginBtn=new JButton("登陆");
        loginBtn.addActionListener(handleAction);
        cancelBtn=new JButton("取消");
        cancelBtn.addActionListener(handleAction);
        userText =new JTextField(20);
        passwordField=new JPasswordField(20);
        userText.addActionListener(handleAction);
        passwordField.addActionListener(handleAction);
        con.setLayout(new FlowLayout());
        con.add(jLabel1);
        con.add(userText);
        con.add(jLabel2);
        con.add(passwordField);
        con.add(loginBtn);
        con.add(cancelBtn);
        jFrame.setSize(300,300);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
        System.out.println();
    }
}
