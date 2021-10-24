package EhsanFrame.Pakage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

import javax.swing.*;

public class Form extends JFrame{
    public Form() {

        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        getContentPane().setBackground(new Color(51, 12, 63));
        setLayout(null);
        setResizable(false);
        setTitle("Registration Form");
        JPanel p1 = new JPanel();
        add(p1);
        p1.setBounds(0,0,500,50);
        p1.setBackground(new Color(241, 78, 6));

        JLabel lvl = new JLabel("Registration Form");
        lvl.setFont(new Font("Engravers MT",Font.BOLD,25));
        lvl.setForeground(new Color(255, 255, 255));
        lvl.setBounds(100,10,350,50);
        add(lvl);
        p1.add(lvl);

        JLabel inputname = new JLabel("Name:");
        inputname.setBounds(100,57,90,25);
        inputname.setForeground(Color.cyan);
        add(inputname);

        JTextField nameTxt = new JTextField("");
        nameTxt.setBounds(150,57,200,25);
        nameTxt.setForeground(Color.cyan);
        nameTxt.setBackground(new Color(64, 71, 54));
        add(nameTxt);


        JLabel inputmail = new JLabel("E-Mail:");
        inputmail.setForeground(Color.cyan);
        inputmail.setBounds(100,105,90,25);
        add(inputmail);

        JTextField emailTxt = new JTextField("");
        emailTxt.setBounds(150,105,200,25);
        emailTxt.setForeground(Color.cyan);
        emailTxt.setBackground(new Color(64, 71, 54));
        add(emailTxt);


        JTextField passTxt = new JTextField("");
        JLabel pass = new JLabel("Password:");
        pass.setForeground(Color.cyan);
        pass.setBounds(78,150,90,25);
        add(pass);

        passTxt.setBounds(150,150,200,25);
        passTxt.setBackground(new Color(64, 71, 54));
        passTxt.setForeground(Color.cyan);
        add(passTxt);


        JTextField conPassTxt = new JTextField("");
        JLabel cpass = new JLabel("Retype Passsword:");
        cpass.setBounds(32,200,150,25);
        cpass.setForeground(Color.cyan);
        add(cpass);

        conPassTxt.setBounds(150,200,200,25);
        add(conPassTxt);
        conPassTxt.setForeground(Color.cyan);
        conPassTxt.setBackground(new Color(64, 71, 54));


        JTextField mobileTxt = new JTextField("");
        JLabel mbl = new JLabel("Mobile:");
        mbl.setBounds(98,250,90,27);
        mbl.setForeground(Color.cyan);
        add(mbl);

        mobileTxt.setBounds(150,250,200,25);
        add(mobileTxt);
        mobileTxt.setForeground(Color.cyan);
        mobileTxt.setBackground(new Color(64, 71, 54));

        JTextField addr = new JTextField();
        add(addr);
        addr.setBackground(new Color(64, 71, 54));
        addr.setForeground(Color.cyan);
        addr.setBounds(150,300,200,25);

        JLabel add = new JLabel("Address:");
        add(add);
        add.setForeground(Color.cyan);
        add.setBounds(90,300,200,25);

        JButton LoginBtn = new JButton("Login");
        setVisible(true);
        LoginBtn.setBounds(148,350,100,30);
        LoginBtn.setForeground(new Color(243, 243, 243));
        LoginBtn.setBackground(new Color(222, 0, 101));
        add(LoginBtn);


        Cursor cr =new Cursor(Cursor.HAND_CURSOR);

        JButton registerBtn = new JButton("Register");
        registerBtn.setCursor(cr);
        registerBtn.setBounds(252,350,100,30);
        registerBtn.setForeground(new Color(25, 43, 72));
        registerBtn.setBackground(new Color(80, 255, 161));
        add(registerBtn);
        setVisible(true);

        registerBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String UserName = nameTxt.getText();
                String email = emailTxt.getText();
                String pass = passTxt.getText();
                String conPass = conPassTxt.getText();
                String mobile = mobileTxt.getText();
                String Address = addr.getText();

                String nameRegex="^[a-zA-Z ]+$";
                Pattern.matches(nameRegex,UserName);
                if (!Pattern.matches(nameRegex,UserName)){
                    JOptionPane.showMessageDialog(null,"Invalid Name");
                }
                String emailRegex="[a-z0-9]+@[a-z]+.[a-z]+$";
                Pattern.matches(emailRegex,email);
                if (!Pattern.matches(emailRegex,email)){
                    JOptionPane.showMessageDialog(null,"Invalid E-mail");
                }

                String passregex ="^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+=])"
                        + "(?=\\S+$).{8,20}$";
                Pattern.matches(passregex,pass);
                if(!Pattern.matches(passregex,pass)){
                    JOptionPane.showMessageDialog(null,"InValid Password");
                }

                String mobileRegex="(\\+88)?01[3-9]\\d{8}";
                Pattern.matches(mobileRegex,mobile);
                if (!Pattern.matches(mobileRegex,mobile)){
                    JOptionPane.showMessageDialog(null,"Invalid Phone Number");
                }

                try {
                    DbConnect db = new DbConnect();
                    String queryInsert= "INSERT INTO `registration`(`Name`, `E-Mail`, `Password`, `Mobile`, `Address`) VALUES ('" +UserName + "','" + email + "','" + pass + "','" + mobile + "','" + Address + "')";
                    db.RegisterInsert(queryInsert);
                }
                catch (Exception e2){
                }
            }

        });
        LoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });
    }
}