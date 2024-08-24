/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_ra_coffeeshop;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mainul
 */
public class LogInForm extends JFrame{
    
    
    protected JButton btnLogIn;
    private JLabel lblName;
    private JLabel lblPass;
    protected JTextField txtName;
    protected JPasswordField Password;
    protected JPanel panel=new JPanel();
    
    public LogInForm(){
        this.setTitle("Seller Log In");
        Toolkit tk=Toolkit.getDefaultToolkit();
        setSize(tk.getScreenSize());
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridBagLayout());
        
        
        btnLogIn=new JButton("Log In");
        lblName=new JLabel("User Name :");
        lblPass=new JLabel("Password  :");
        txtName=new JTextField(15);
        Password=new JPasswordField(15);
        GridBagConstraints gb=new GridBagConstraints();

        gb.gridx=1;
        gb.gridy=2;
        panel.add(lblName,gb);


        gb.gridx=2;
        gb.gridy=2;
        panel.add(txtName,gb);

        /**********************/

        gb.gridx=1;
        gb.gridy=3;
        panel.add(lblPass,gb);



        gb.gridx=2;
        gb.gridy=3;
        panel.add(Password,gb);


        /*****************/

        gb.gridx=2;
        gb.gridy=4;
        panel.add(btnLogIn,gb);

        add(panel);
        setVisible(true);
    }
    
}
