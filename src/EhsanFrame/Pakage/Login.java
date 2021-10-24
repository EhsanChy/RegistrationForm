package EhsanFrame.Pakage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public Login(){
        setSize(400,350);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(63, 13, 51));

        JPanel Tpanel = new JPanel();
        Tpanel.setBackground(new Color(255, 104, 7));
        Tpanel.setBounds(0,0,400,50);
        add(Tpanel);

        JLabel tlebel = new JLabel("Login Form");
        Tpanel.add(tlebel);
        tlebel.setForeground(new Color(245, 245, 246));
        tlebel.setFont(new Font("Engravers MT",Font.BOLD,25));

        JLabel user = new JLabel("Username :");
        add(user);
        user.setBounds(20,70,100,25);
        user.setForeground(Color.cyan);

        JTextField f1 = new JTextField();
        add(f1);
        f1.setBounds(100,70,200,25);
        f1.setBackground(new Color(64, 71, 54));
        f1.setForeground(Color.cyan);

        JLabel pass =new JLabel("Password :");
        pass.setBounds(21,120,100,25);
        add(pass);
        pass.setForeground(Color.cyan);

        JTextField f2 = new JTextField();
        add(f2);
        f2.setBounds(100,120,200,25);
        f2.setBackground(new Color(64, 71, 54));
        f2.setForeground(Color.cyan);

        Cursor cr = new Cursor(Cursor.HAND_CURSOR);

        JButton LoginBtn = new JButton("Login");
        setVisible(true);
        LoginBtn.setCursor(cr);
        LoginBtn.setBounds(200,165,100,30);
        LoginBtn.setForeground(new Color(8, 79, 128));
        LoginBtn.setBackground(new Color(160, 222, 5));
        add(LoginBtn);


        JButton registerBtn = new JButton("Register");
        setVisible(true);
        registerBtn.setCursor(cr);
        registerBtn.setBounds(200,210,100,30);
        registerBtn.setForeground(new Color(25, 43, 72));
        registerBtn.setBackground(new Color(80, 255, 161));
        add(registerBtn);

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Form();
            }
        });

        LoginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String UserName = f1.getText();
                String pass = f2.getText();

                String loginQuery = "SELECT * FROM `registration`";
                DbConnect db = new DbConnect();
                db.Login(loginQuery, UserName, pass);
            }

        });

    }

    public static void main(String[] args) {

        Login log = new Login();
    }

}
