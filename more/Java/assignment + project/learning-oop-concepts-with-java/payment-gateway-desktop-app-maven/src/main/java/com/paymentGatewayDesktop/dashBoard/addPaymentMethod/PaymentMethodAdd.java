package com.paymentGatewayDesktop.dashBoard.addPaymentMethod;

import com.paymentGatewayDesktop.StaticContext;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class PaymentMethodAdd extends JFrame {

	private JPanel contentPane;
	private JTextField mobile_number;
	private JTextField pin_number;
	private JDateChooser dateChooser;


	public PaymentMethodAdd(){
//		StaticContext.pmAdd = this;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	private void initialize() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(620, 200, 500, 350);
		this.setTitle("Payment Methods");

		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPayType = new JLabel("Choose Payment Method Type");
		lblPayType.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPayType.setBounds(118, 39, 203, 26);
		contentPane.add(lblPayType);

		JLabel lblPayMethodType = new JLabel("Add New Payment Method");
		lblPayMethodType.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPayMethodType.setBounds(108, 11, 213, 29);
		contentPane.add(lblPayMethodType);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"bKash", "Nagad", "Bank", "MasterCard", "Visa", "Amex", "Paypal"}));
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		comboBox.setBounds(155, 76, 100, 24);
		contentPane.add(comboBox);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblMobileNumber.setBounds(28, 123, 82, 14);
		contentPane.add(lblMobileNumber);

		JLabel lblPin = new JLabel("PIN Number");
		lblPin.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblPin.setBounds(28, 154, 82, 14);
		contentPane.add(lblPin);

		JLabel lblIssueDate = new JLabel("Issue Date");
		lblIssueDate.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblIssueDate.setBounds(28, 183, 82, 14);
		contentPane.add(lblIssueDate);

		JButton addPaymentBtn = new JButton("Add Payment Method");
		addPaymentBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		addPaymentBtn.setBounds(256, 227, 168, 23);
		contentPane.add(addPaymentBtn);

		mobile_number = new JTextField();
		mobile_number.setBounds(118, 121, 137, 20);
		mobile_number.setFont(new Font("Comic Sans MS", Font.BOLD| Font.ITALIC,12));
		contentPane.add(mobile_number);
		mobile_number.setColumns(10);

		pin_number = new JPasswordField();
		pin_number.setBounds(118, 152, 139, 20);
		pin_number.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
		contentPane.add(pin_number);
		pin_number.setColumns(10);


		dateChooser = new JDateChooser();
		dateChooser.setBounds(118, 183, 139, 20);
		contentPane.add(dateChooser);

		this.setVisible(true);

		addPaymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PaymentMethodAdd.this.addPaymentMethod();
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				}
			}
		});

		}

	private void addPaymentMethod() throws ClassNotFoundException {
		System.out.println("Payment Method Added");
		String dbManager = "postgresql";
		String host = "localhost";
		String port = "5432";
		String db = "payment_method_add";
		String username = "postgres";
		String password = "1234";
		Class.forName("org.postgresql.Driver");
		try (Connection con = DriverManager.getConnection(
				"jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {

			var query = "INSERT INTO public.payment_method_user(id, mobile_number, pin_number, issue_date) VALUES (?," +
					" ?, ?, ?);";
			var pstmt = con.prepareStatement(query);
			pstmt.setString(1, UUID.randomUUID().toString());
			pstmt.setString(2, mobile_number.getText());
			pstmt.setString(3, pin_number.getText());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			pstmt.setString(4, sdf.format(dateChooser.getDate()));
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(this, mobile_number.getText()+" payment method added successfully");

		} catch (SQLException | RuntimeException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new PaymentMethodAdd();
	}


}
