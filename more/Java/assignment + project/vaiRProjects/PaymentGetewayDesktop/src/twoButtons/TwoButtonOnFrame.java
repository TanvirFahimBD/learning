package twoButtons;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TwoButtonOnFrame extends JFrame implements ActionListener{
	public static void main(String[] args)
	{
	new TwoButtonOnFrame();
	}

private JButton btn1;
private JButton btn2;

public TwoButtonOnFrame() {
	this.setSize(500,600);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Buttons");
	this.setLayout(null);
	Font f = new Font("JSL Ancient", Font.ITALIC, 12);
	btn1 = new JButton("ONE");
	btn1.setBounds(100,100,200,50);
	btn1.setFont(f);
	this.add(btn1);
	btn1.addActionListener(this);
	btn2 = new JButton("TWO");
	btn2.addActionListener(this);
	btn2.setBounds(100,200,200,50);
	btn2.setFont(f);
	this.add(btn2);
	this.setVisible(true);
}
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == btn1) {
		btn1.setText("The ONE");
	}else {btn2.setText("The TWO");}
}
}
