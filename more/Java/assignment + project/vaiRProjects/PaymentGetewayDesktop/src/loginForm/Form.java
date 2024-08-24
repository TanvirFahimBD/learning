package loginForm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Form extends JFrame implements ActionListener{
JLabel l1, l2, l3;
 JTextField tf1;
 JButton btn1;
 JPasswordField p1;
 
Form(){
	l1 = new JLabel("Login From");
	l1.setForeground(Color.BLUE);
	l1.setFont(new Font("Serief", Font.BOLD, 20));
	
	l2 = new JLabel("Username");
	l3 = new JLabel("Password");
	tf1 = new JTextField();
	p1 = new JPasswordField();
	btn1 = new JButton("Login");
	
	l1.setBounds(100 ,30, 400, 30);
	l2.setBounds(80 ,70, 200, 30);
	l3.setBounds(80 ,110, 200, 30);
	tf1.setBounds(300 ,70, 200, 30);
	p1.setBounds(300 ,110, 200, 30);
	btn1.setBounds(150 ,160, 100, 30);
	
	this.add(l1);
	this.add(l2);
	this.add(tf1);
	this.add(l3);
	this.add(p1);
	this.add(btn1);
	
	this.setSize(400, 400);
	this.setLayout(null);
	this.setVisible(true);

}
public void actionPerformed(ActionEvent e) {
	String uname = l1.getText();
	 String pass = p1.getText();
	 if(uname.equals("Username")&& pass.equals("PassworD")) {
		 Welcome wel = new Welcome();
		 wel.setVisible(true);
		 JLabel label = new JLabel("Welcome:"+uname);
		 wel.getContentPane().add(label);
		 }else{JOptionPane.showMessageDialog(this,"Incorrect login or password",
		      "Error",JOptionPane.ERROR_MESSAGE);  
		 }
	
}
public static void main(String[] args) {
	new Form();
}
 
}
