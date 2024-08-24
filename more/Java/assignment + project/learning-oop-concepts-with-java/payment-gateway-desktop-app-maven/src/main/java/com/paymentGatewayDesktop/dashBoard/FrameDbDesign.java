package com.paymentGatewayDesktop.dashBoard;

import com.paymentGatewayDesktop.StaticContext;
import com.paymentGatewayDesktop.dashBoard.addPaymentMethod.PaymentMethodAdd;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrameDbDesign extends JFrame {

    private JPanel contentPane;
    private JTextField srcField;
    private JTable tblPayment;
    private JTable tblAccount;
    private ButtonGroup grp;


    /**
     * Create the frame.
     */
    public FrameDbDesign() {

        StaticContext.frDb = this;
        this.setTitle("Payment Dashboard Layout");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("My Payment Methods");
        lblNewLabel.setBounds(10, 67, 143, 14);
        contentPane.add(lblNewLabel);

        JLabel lblMyBeneficiaries = new JLabel("My beneficiaries");
        lblMyBeneficiaries.setBounds(10, 171, 109, 14);
        contentPane.add(lblMyBeneficiaries);

        JButton payMdAddBtn = new JButton("Add");
        payMdAddBtn.setBounds(335, 63, 89, 23);
        payMdAddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PaymentMethodAdd();
            }
        });
        contentPane.add(payMdAddBtn);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(335, 11, 89, 23);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        contentPane.add(btnSearch);

        grp = new ButtonGroup();

        JRadioButton rdbtnMobile = new JRadioButton("Mobile");
        rdbtnMobile.setBounds(6, 40, 109, 23);
        contentPane.add(rdbtnMobile);

        JRadioButton rdbtnNumber = new JRadioButton("Account");
        rdbtnNumber.setBounds(181, 40, 109, 23);
        contentPane.add(rdbtnNumber);

        grp.add(rdbtnMobile);
        grp.add(rdbtnNumber);

        srcField = new JTextField();
        srcField.setBounds(10, 11, 280, 20);
        srcField.setText("Search Account");
        srcField.setToolTipText("");
        contentPane.add(srcField);
        srcField.setColumns(10);

        JButton btnAddAccount = new JButton("Add");
        btnAddAccount.setBounds(335, 167, 89, 23);
        contentPane.add(btnAddAccount);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 90, 414, 70);
        contentPane.add(scrollPane);

        tblPayment = new JTable();
        tblPayment.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null},
                        {null, null},
                },
                new String[] {
                        "Method List", "Accounts"
                }
        ));
        scrollPane.setViewportView(tblPayment);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 196, 414, 54);
        contentPane.add(scrollPane_1);

        tblAccount = new JTable();
        tblAccount.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "Account ID", "Name", "Payment System"
                }
        ));
        scrollPane_1.setViewportView(tblAccount);

        this.setVisible(true);

    }

//    public static void main(String[] args) {
//        new FrameDbDesign();
//    }

}
