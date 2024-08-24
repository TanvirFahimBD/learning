package com.paymentGatewayDesktop.LoginForm;

import com.paymentGatewayDesktop.StaticContext;
import com.paymentGatewayDesktop.dashBoard.FrameDbDesign;
import com.paymentGatewayDesktop.registration.RegistrationAccount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class LoginForm extends JFrame {

    private JLabel lblForm, userLabel, passLabel;
    private JTextField txtField;
    private JPasswordField psField;
    private JButton lgButton, rsButton, regWindowButton;
    private Container container;
    private Font fnt, fnt2;
    private Cursor cursor;

    public LoginForm(){
        StaticContext.lgForm = this;
        initialize();
    }

    private void initialize(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(650, 200, 500, 370);
        this.setTitle("Login Form");

        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.ORANGE);

        fnt = new Font("Comic Sans MS",Font.BOLD |Font.ITALIC, 18);
        fnt2 = new Font("Comic Sans MS",Font.BOLD |Font.ITALIC, 26);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        lblForm = new JLabel("Login Form");
        lblForm.setBounds(170,30,240,70);
        lblForm.setForeground(Color.DARK_GRAY);
        lblForm.setFont(fnt2);
        container.add(lblForm);

        userLabel = new JLabel("Username : ");
        userLabel.setBounds(50,100,150,50);
        userLabel.setForeground(Color.DARK_GRAY);
        userLabel.setFont(fnt);
        container.add(userLabel);

        txtField = new JTextField();
        txtField.setFont(fnt);
        txtField.setBounds(170,110,200,30);
        container.add(txtField);

        passLabel = new JLabel("Password : ");
        passLabel.setBounds(50,150,150,50);
        passLabel.setForeground(Color.DARK_GRAY);
        passLabel.setFont(fnt);
        container.add(passLabel);

        psField = new JPasswordField();
        psField.setBounds(170,150,200,30);
        container.add(psField);

        rsButton = new JButton("Reset");
        rsButton.setBounds(70,200,120,40);
        rsButton.setFont(fnt);
        rsButton.setCursor(cursor);
        rsButton.setForeground(Color.DARK_GRAY);
        container.add(rsButton);

        lgButton = new JButton("Login");
        lgButton.setBounds(240,200,120,40);
        lgButton.setFont(fnt);
        lgButton.setCursor(cursor);
        lgButton.setForeground(Color.DARK_GRAY);
        container.add(lgButton);

        regWindowButton = new JButton("Registration");
        regWindowButton.setBounds(260,270,170,40);
        regWindowButton.setFont(fnt);
        regWindowButton.setCursor(cursor);
        regWindowButton.setForeground(Color.DARK_GRAY);
        container.add(regWindowButton);

        this.setVisible(true);

        rsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtField.setText("");
                psField.setText("");
            }
        });

        lgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginForm.this.doLogin();


                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        });


        regWindowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationAccount();
                StaticContext.lgForm.dispose();
            }
        });

    }

    private void doLogin() throws ClassNotFoundException {
        String dbManager = "postgresql";
        String host = "localhost";
        String port = "5432";
        String db = "payment_gateway";
        String username = "postgres";
        String password = "1234";
        Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {

//            var queryUser = "select username from public.log_user where username =?";
//            var pstmtU = con.prepareStatement(queryUser);
//            pstmtU.setString(1, txtField.getText());
//            ResultSet resultSet = pstmtU.executeQuery();
//            if (resultSet.next()){
//                throw new RuntimeException("This user already exists");
//            }else {

                var query = "INSERT INTO public.log_user(id, username, password) VALUES (?, ?, ?);";
                var pstmt = con.prepareStatement(query);
                pstmt.setString(1, UUID.randomUUID().toString());
                pstmt.setString(2, txtField.getText());
                pstmt.setString(3, new String(psField.getPassword()));
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, txtField.getText() + " logged in successfully");

                System.out.println("Logged in");

                new FrameDbDesign();
                StaticContext.lgForm.dispose();
//            }

        } catch (SQLException | RuntimeException ex) {
            ex.printStackTrace();
        }
    }


}
