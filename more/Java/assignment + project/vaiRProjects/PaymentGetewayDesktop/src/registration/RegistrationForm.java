package registration;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.*;

public class RegistrationForm extends JFrame {

	private JTextField txtFName;
	private JTextField txtEmail;
	private JPasswordField psPassword;
	private JPasswordField psPasswordC;
	private JButton bSubmit;
	private JButton bClear;
	private JLabel lblName;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblPasswordC;

	private JPanel pnlWrapper;
	private JPanel pnlName;
	private JPanel pnlEmail;
	private JPanel pnlPassword;
	private JPanel pnlPasswordC;
	private JPanel pnlButton;


	public RegistrationForm() {
		initialize();
	}

	private void initialize() {
		txtFName = new JTextField();
		txtEmail = new JTextField();
		psPassword = new JPasswordField();
		psPasswordC = new JPasswordField();
		bSubmit = new JButton("Submit");
		bClear = new JButton("Clear");
		lblName = new JLabel("NAME");
		lblEmail = new JLabel("Email");
		lblPassword = new JLabel("Password");
		lblPasswordC = new JLabel("Retype Password");

		pnlWrapper = new JPanel(new GridLayout(20, 1));

		GridLayout row1Col2 = new GridLayout();

		pnlName = new JPanel(row1Col2);
		pnlName.add(lblName);
		pnlName.add(txtFName);
		pnlWrapper.add(pnlName);

		pnlEmail = new JPanel(row1Col2);
		pnlEmail.add(lblEmail);
		pnlEmail.add(txtEmail);
		pnlWrapper.add(pnlEmail);

		pnlPassword = new JPanel(row1Col2);
		pnlPassword.add(lblPassword);
		pnlPassword.add(psPassword);
		pnlWrapper.add(pnlPassword);

		pnlPasswordC = new JPanel(row1Col2);
		pnlPasswordC.add(lblPasswordC);
		pnlPasswordC.add(psPasswordC);
		pnlWrapper.add(pnlPasswordC);


		bClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearData();
			}
		});


//		bSubmit.addActionListener(e -> doRegister());
//		bSubmit.addActionListener(e -> {
//			doRegister();
//			System.out.println("test lamda 1");
//			System.out.println(e.getSource());
//		});
		bSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					RegistrationForm.this.doRegister();
				} catch (ClassNotFoundException classNotFoundException) {
					classNotFoundException.printStackTrace();
				}
			}
		});

		pnlButton = new JPanel(row1Col2);
		pnlButton.add(bClear);
		pnlButton.add(bSubmit);
		pnlWrapper.add(pnlButton);

		this.setLayout(new BorderLayout());
		this.setSize(400, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.add(pnlWrapper, BorderLayout.CENTER);
	}

	private void doRegister() throws ClassNotFoundException {
		System.out.println("Register");
//        Connection pgCon;
		String dbManager = "postgresql";
		String host = "localhost";
		String port = "5432";
		String db = "payment_gateway";
		String username = "postgres";
		String password = "1234";
		Class.forName("org.postgresql.Driver");
		try (Connection pgCon = DriverManager.getConnection(
				"jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {

			var confirmPassword = new String(psPasswordC.getPassword());
			if (!password.equals(confirmPassword)) {
				throw new RuntimeException("Password mismatch");
			}
			var query = "INSERT INTO public.reg_user(id, full_name, password, email) VALUES (?, ?, ?, ?);";
			var pstmt = pgCon.prepareStatement(query);
			pstmt.setString(1, UUID.randomUUID().toString());
			pstmt.setString(2, txtFName.getText());
			pstmt.setString(3, new String(psPassword.getPassword()));
			pstmt.setString(4, txtEmail.getText());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(this, txtFName.getText()+" saved successfully");
		} catch (SQLException | RuntimeException ex) {
			ex.printStackTrace();
		}
	}

	private void clearData() {
		txtFName.setText("");
		txtEmail.setText("");
		psPassword.setText("");
		psPasswordC.setText("");
	}
}


