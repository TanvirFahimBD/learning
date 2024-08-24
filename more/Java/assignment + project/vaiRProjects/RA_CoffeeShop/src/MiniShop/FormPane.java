package MiniShop;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import pos_ra_coffeeshop.*;

public class FormPane extends JPanel {
		
		FrameStructure fs;
		
				
		private JLabel lblName;
		private JLabel lblPass;
		private JTextField txtName;
		private JPasswordField txtPass;
		private JButton btnLogin;
		
		private static String sql;
		
		


	public FormPane(){
		setLayout(new GridBagLayout());
		lblName=new JLabel("User Name:");
		lblPass=new JLabel("Password:");
		txtName=new JTextField(12);
		txtPass =new JPasswordField(12);
		btnLogin=new JButton("LogIn");
		
		Font font = new Font("Arial", Font.ITALIC, 16);
		lblName.setFont(font);
		lblPass.setFont(font);
		txtName.setFont(font);
		txtPass.setFont(font);
		btnLogin.setFont(font);
		txtPass.setEchoChar('*');

		
		
		final Database db=new Database();
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(10,10,10,10);
		add(lblName,gc);
		
		gc.gridx=1;
		gc.gridy=0;
		add(txtName,gc);
		
		
		/********Second row******/
		
		
		gc.gridx=0;
		gc.gridy=2;
		add(lblPass,gc);
		
		gc.gridx=1;
		gc.gridy=2;
		add(txtPass,gc);
		
		/*******Third row**********/
		
		
		gc.gridx=1;
		gc.gridy=5;
		gc.anchor=GridBagConstraints.LINE_START;
		add(btnLogin,gc);
		
		
		btnLogin.addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String username=txtName.getText();
				String password=txtPass.getText();
				sql="SELECT uname,password,fullName FROM Seller WHERE uname='"+username+"' AND password='"+password+"'";
				//System.out.println(sql);
				try {
					db.connect();
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Database not found");
				} catch (SQLException e1) {
                     JOptionPane.showMessageDialog(null, "Database not found");
                            }
				
				try {
					
					if(db.query(new FormPane())==true){
						
						Application.mf.dispose();
						txtName.setText("");
						txtPass.setText("");
						FrameStructure fs=new FrameStructure();
                        fs.frameStructure().setVisible(true);
						

					}
					else
					{
					JOptionPane.showMessageDialog(null, "Username or Password mismatched");	
						
					}
					
					db.disconnect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Query not complete");
				}		
				
			}
		});
		
	
	}

	public String getSql() {
		return sql;
	}

}
