package com.paymentGatewayDesktop.dashBoard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.paymentGatewayDesktop.StaticContext;
import com.toedter.calendar.JDateChooser;

public class PaymentMethodAdd extends JFrame {

	private JPanel contentPane;
	private JPanel pnlBkash;
	private JPanel pnlCard;
	private JLayeredPane layeredPane;
	private JLabel lblSelect;
	private JLabel lblPin;
	private JLabel lblIssueDate;
	private JTextField txtFMobileNum;
	private JPasswordField psfPin;
	private JTextField txtFlCardNum;
	private JPasswordField psfPassword;
	private JPasswordField psfCvv;
	private JDateChooser dcIssueDateBkash, dcIssueDateCard, dcExpDate;

	public PaymentMethodAdd(){
		StaticContext.pmAdd = this;
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 250, 450, 300);
		setTitle("Add New Payment Method");
		contentPane = new JPanel();
		contentPane.setBackground(Color.orange);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 70, 434, 191);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		pnlBkash = new JPanel();
		pnlBkash.setBackground(Color.orange);
		layeredPane.add(pnlBkash, "name_1355023041000");
		pnlBkash.setLayout(null);

		JLabel lblMobileNum = new JLabel("Mobile Number: ");
		lblMobileNum.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblMobileNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNum.setBounds(10, 11, 113, 26);
		pnlBkash.add(lblMobileNum);

		lblPin = new JLabel("Password: ");
		lblPin.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblPin.setHorizontalAlignment(SwingConstants.LEFT);
		lblPin.setBounds(10, 48, 93, 26);
		pnlBkash.add(lblPin);

		lblIssueDate = new JLabel("Issue Date: ");
		lblIssueDate.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIssueDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblIssueDate.setBounds(10, 85, 93, 26);
		pnlBkash.add(lblIssueDate);

		txtFMobileNum = new JTextField();
		txtFMobileNum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		txtFMobileNum.setBounds(133, 15, 119, 20);
		pnlBkash.add(txtFMobileNum);
		txtFMobileNum.setColumns(10);

		psfPin = new JPasswordField();
		psfPin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		psfPin.setBounds(133, 52, 119, 20);
		pnlBkash.add(psfPin);

		dcIssueDateBkash = new JDateChooser();
		dcIssueDateBkash.getCalendarButton().setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		dcIssueDateBkash.setBounds(133, 85, 119, 20);
		pnlBkash.add(dcIssueDateBkash);

		JButton btnAddBkash = new JButton("Add Payment bKash");
		btnAddBkash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PaymentMethodAdd.this.doBkashAdd();

				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				}
			}
		});
		btnAddBkash.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAddBkash.setBounds(252, 157, 172, 23);
		pnlBkash.add(btnAddBkash);

		pnlCard = new JPanel();
		pnlCard.setBackground(Color.orange);
		layeredPane.add(pnlCard, "name_1360528599200");
		pnlCard.setLayout(null);

		JLabel lblCardNum = new JLabel("Card Number:");
		lblCardNum.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblCardNum.setBounds(10, 11, 96, 14);
		pnlCard.add(lblCardNum);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblPassword.setBounds(10, 36, 96, 14);
		pnlCard.add(lblPassword);

		JLabel lblExpDate = new JLabel("Expire Date:");
		lblExpDate.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblExpDate.setBounds(10, 61, 96, 14);
		pnlCard.add(lblExpDate);

		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblCvv.setBounds(10, 89, 96, 14);
		pnlCard.add(lblCvv);

		JLabel lblIsuDate = new JLabel("Issue Date:");
		lblIsuDate.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblIsuDate.setBounds(10, 114, 96, 14);
		pnlCard.add(lblIsuDate);

		txtFlCardNum = new JTextField();
		txtFlCardNum.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		txtFlCardNum.setBounds(135, 9, 115, 20);
		pnlCard.add(txtFlCardNum);
		txtFlCardNum.setColumns(10);

		psfPassword = new JPasswordField();
		psfPassword.setBounds(135, 34, 115, 20);
		pnlCard.add(psfPassword);

		psfCvv = new JPasswordField();
		psfCvv.setBounds(135, 87, 115, 20);
		pnlCard.add(psfCvv);

		dcIssueDateCard = new JDateChooser();
		dcIssueDateCard.setBounds(135, 61, 115, 20);
		pnlCard.add(dcIssueDateCard);

		dcExpDate = new JDateChooser();
		dcExpDate.setBounds(135, 114, 117, 20);
		pnlCard.add(dcExpDate);

		JButton btnAddCard = new JButton("Add Payment Card");
		btnAddCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PaymentMethodAdd.this.doCardAdd();


				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				}
			}
		});
		btnAddCard.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnAddCard.setBounds(252, 157, 172, 23);
		pnlCard.add(btnAddCard);

		layeredPane.removeAll();

		lblSelect = new JLabel("Select & Add New Payment Method");
		lblSelect.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblSelect.setBounds(77, 10, 278, 14);
		contentPane.add(lblSelect);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		comboBox.addItem("bKash");
		comboBox.addItem("Visa");
		comboBox.addItem("MasterCard");
		comboBox.addItem("Amex");
		comboBox.addItem("Paypal");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(132, 35, 116, 24);
		contentPane.add(comboBox);

		this.setVisible(true);

		comboBox.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String value = (String)comboBox.getSelectedItem();
				switch(value) {
					case "bKash":
						switchPanels(pnlBkash);
						break;
					default:
						switchPanels(pnlCard);
				}
			}

		});
	}

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	private void doBkashAdd() throws ClassNotFoundException {
		String dbManager = "postgresql";
		String host = "localhost";
		String port = "5432";
		String db = "payment_method_add";
		String username = "postgres";
		String password = "1234";
		Class.forName("org.postgresql.Driver");
		try (Connection con = DriverManager.getConnection(
				"jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {

				var query =
						"INSERT INTO public.add_paymethod_account_user(id, mobile_number, pin_number, issue_date)" +
						" VALUES (?, ?, ?, ?);";
				var pstmt = con.prepareStatement(query);
				pstmt.setString(1, UUID.randomUUID().toString());
				pstmt.setString(2, txtFMobileNum.getText());
				pstmt.setString(3, new String(psfPin.getPassword()));

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dateIs = sdf.format(dcIssueDateBkash.getDate());
				pstmt.setString(4, dateIs);

				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, txtFMobileNum.getText() + " inserted successfully");

				System.out.println("Inserted Successfully");

				StaticContext.pmAdd.dispose();

		} catch (SQLException | RuntimeException ex) {
			ex.printStackTrace();
		}
	}

	private void doCardAdd() throws ClassNotFoundException {
		String dbManager = "postgresql";
		String host = "localhost";
		String port = "5432";
		String db = "payment_method_add";
		String username = "postgres";
		String password = "1234";
		Class.forName("org.postgresql.Driver");
		try (Connection con = DriverManager.getConnection(
				"jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {

				var query = "INSERT INTO public.add_paymethod_account_user(id, issue_date, card_number, password, " +
						"expire_date, cvv)" +
						" VALUES (?, ?, ?, ?, ?, ?);";
				var pstmt = con.prepareStatement(query);
				pstmt.setString(1, UUID.randomUUID().toString());

				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				String date1 = sdf1.format(dcIssueDateCard.getDate());
				pstmt.setString(2, date1);

				pstmt.setString(3, txtFlCardNum.getText());
				pstmt.setString(4, new String(psfPassword.getPassword()));


				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				String date2 = sdf2.format(dcExpDate.getDate());
				pstmt.setString(5, date2);

				pstmt.setString(6, new String(psfCvv.getPassword()));

				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, txtFlCardNum.getText() + " inserted successfully");

				System.out.println("Inserted Successfully");

//				StaticContext.frDb.showData();
				StaticContext.pmAdd.dispose();

		} catch (SQLException | RuntimeException ex) {
			ex.printStackTrace();
		}
	}

}
