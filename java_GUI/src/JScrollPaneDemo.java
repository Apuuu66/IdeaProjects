

import javax.swing.*;

/**
 * Created by Snoopy on 2017/3/20.
 */
public class JScrollPaneDemo {
    JScrollPane jScrollPane;
    JLabel jLabel;
    JFrame jFrame;

    public JScrollPaneDemo() {
        jFrame = new JFrame("JScrollPane示例");
        Icon picture = new ImageIcon("test.jpg");
        jLabel = new JLabel(picture);
        jScrollPane = new JScrollPane();
        jScrollPane.setLayout(new ScrollPaneLayout());
        jScrollPane.getViewport().add(jLabel);
        jFrame.add(jScrollPane);
        jFrame.setSize(600, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollPaneDemo();
    }
}

//import java.awt.BorderLayout;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.border.EmptyBorder;
//
//public class JScrollPaneDemo extends JFrame{
//    private JPanel contentPane;
//    private JScrollPane scrollPane;
//    private JTextArea textArea;
//    public JScrollPaneDemo(){
//        contentPane=new JPanel();
//        contentPane.setBorder(new EmptyBorder(5,5,5,5));
//        contentPane.setLayout(new BorderLayout(0,0));
//        this.setContentPane(contentPane);
//        scrollPane=new JScrollPane();
//        contentPane.add(scrollPane,BorderLayout.CENTER);
//        textArea=new JTextArea();
//        //scrollPane.add(textArea);
//        scrollPane.setViewportView(textArea);
//        this.setTitle("滚动面板使用");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setBounds(100, 100, 250, 200);
//        this.setVisible(true);
//    }
//    public static void main(String []args){
//        JScrollPaneDemo example=new JScrollPaneDemo();
//    }
//}
