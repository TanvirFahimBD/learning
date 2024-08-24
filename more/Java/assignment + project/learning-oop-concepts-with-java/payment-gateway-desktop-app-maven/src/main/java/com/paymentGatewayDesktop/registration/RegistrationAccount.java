package com.paymentGatewayDesktop.registration;

import com.paymentGatewayDesktop.StaticContext;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public class RegistrationAccount extends JFrame {

	private JPanel contentPane;
	private JTextField flNameTxtFld;
	private JTextField usrNameTxtFld;
	private JTextField emailTxtFld;
	private JPasswordField passwordField;
	private JPasswordField cPasswordField;
	private JButton rgButton, rsButton;
	private Cursor cursor;

	public RegistrationAccount()
	{
		StaticContext.rgAc = this;
		initialize();
	}
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel regLabel = new JLabel("Registration Form");
		regLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		regLabel.setBounds(148, 11, 146, 31);
		contentPane.add(regLabel);
		
		JLabel flNameLbl = new JLabel("Full Name : ");
		flNameLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		flNameLbl.setBounds(58, 66, 103, 14);
		contentPane.add(flNameLbl);
		
		JLabel usrNameLbl = new JLabel("Username : ");
		usrNameLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		usrNameLbl.setBounds(58, 91, 103, 14);
		contentPane.add(usrNameLbl);
		
		JLabel emailLbl = new JLabel("Email : ");
		emailLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		emailLbl.setBounds(58, 117, 103, 14);
		contentPane.add(emailLbl);
		
		JLabel psLbl = new JLabel("Password : ");
		psLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		psLbl.setBounds(58, 142, 103, 14);
		contentPane.add(psLbl);
		
		JLabel cPsLbl = new JLabel("Retype Password : ");
		cPsLbl.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		cPsLbl.setBounds(58, 167, 103, 14);
		contentPane.add(cPsLbl);

		flNameTxtFld = new JTextField();
		flNameTxtFld.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		flNameTxtFld.setBounds(171, 64, 175, 20);
		contentPane.add(flNameTxtFld);
		flNameTxtFld.setColumns(10);

		usrNameTxtFld = new JTextField();
		usrNameTxtFld.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		usrNameTxtFld.setColumns(10);
		usrNameTxtFld.setBounds(171, 89, 175, 20);
		contentPane.add(usrNameTxtFld);

		emailTxtFld = new JTextField();
		emailTxtFld.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		emailTxtFld.setColumns(10);
		emailTxtFld.setBounds(171, 115, 175, 20);
		contentPane.add(emailTxtFld);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		passwordField.setBounds(171, 140, 175, 20);
		contentPane.add(passwordField);

		cPasswordField = new JPasswordField();
		cPasswordField.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		cPasswordField.setBounds(171, 165, 175, 20);
		contentPane.add(cPasswordField);

		rsButton = new JButton("Reset");
		rsButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		rsButton.setBounds(103, 213, 89, 23);
		rsButton.setCursor(cursor);
		contentPane.add(rsButton);

		rgButton = new JButton("Register");
		rgButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		rgButton.setBounds(230, 213, 89, 23);
		contentPane.add(rgButton);

		this.setVisible(true);

		rgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RegistrationAccount.this.doRegister();
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				}
			}
		});


		rsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flNameTxtFld.setText("");
				usrNameTxtFld.setText("");
				emailTxtFld.setText("");
				passwordField.setText("");
				cPasswordField.setText("");
			}
		});

	}


	private void doRegister() throws ClassNotFoundException {
		System.out.println("Registered");
		String dbManager = "postgresql";
		String host = "localhost";
		String port = "5432";
		String db = "registration_user_payment_gateway";
		String username = "postgres";
		String password = "1234";
		Class.forName("org.postgresql.Driver");
		try (Connection con = DriverManager.getConnection(
				"jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {

			var query = "INSERT INTO public.reg_user(id, full_name, user_name, email,  password) VALUES (?, ?, ?, ?, ?);";
			var pstmt = con.prepareStatement(query);
			pstmt.setString(1, UUID.randomUUID().toString());
			pstmt.setString(2, flNameTxtFld.getText());
			pstmt.setString(3, usrNameTxtFld.getText());
			pstmt.setString(4, emailTxtFld.getText());
			pstmt.setString(5, new String(passwordField.getPassword()));
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(this, usrNameTxtFld.getText()+" account saved successfully");

		} catch (SQLException | RuntimeException ex) {
			ex.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		new RegistrationAccount();
//	}

}
