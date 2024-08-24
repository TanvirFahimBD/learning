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
import java.sql.SQLException;
import java.util.UUID;

public class LoginForm extends JFrame {

    private JLabel userLabel, passLabel;
    private JTextField txtField;
    private JPasswordField psField;
    private JButton lgButton, rsButton, regWindowButton;
    private Container container;
    private Font fnt;
    private Cursor cursor;

    public LoginForm(){
        StaticContext.lgForm = this;
        initialize();
    }

    private void initialize(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(620, 200, 500, 600);
        this.setTitle("Login");

        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.ORANGE);

        fnt = new Font("Comic Sans MS",Font.BOLD |Font.ITALIC, 18);
        cursor = new Cursor(Cursor.HAND_CURSOR);

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
        passLabel.setBounds(50,200,150,50);
        passLabel.setForeground(Color.DARK_GRAY);
        passLabel.setFont(fnt);
        container.add(passLabel);

        psField = new JPasswordField();
        psField.setBounds(170,210,200,30);
        container.add(psField);

        lgButton = new JButton("Login");
        lgButton.setBounds(170,280,200,40);
        lgButton.setFont(fnt);
        lgButton.setCursor(cursor);
        lgButton.setForeground(Color.DARK_GRAY);
        container.add(lgButton);

        rsButton = new JButton("Reset");
        rsButton.setBounds(170,350,200,40);
        rsButton.setFont(fnt);
        rsButton.setCursor(cursor);
        rsButton.setForeground(Color.DARK_GRAY);
        container.add(rsButton);


        regWindowButton = new JButton("Registration");
        regWindowButton.setBounds(240,460,200,40);
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
                    new FrameDbDesign();
                    StaticContext.lgForm.dispose();

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
        System.out.println("Logged in");
        String dbManager = "postgresql";
        String host = "localhost";
        String port = "5432";
        String db = "payment_gateway";
        String username = "postgres";
        String password = "1234";
        Class.forName("org.postgresql.Driver");
        try (Connection con = DriverManager.getConnection(
                "jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {

            var query = "INSERT INTO public.log_user(id, username, password) VALUES (?, ?, ?);";
            var pstmt = con.prepareStatement(query);
            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, txtField.getText());
            pstmt.setString(3, new String(psField.getPassword()));
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, txtField.getText()+" logged in successfully");



        } catch (SQLException | RuntimeException ex) {
            ex.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//            new LoginForm();
//    }

}
