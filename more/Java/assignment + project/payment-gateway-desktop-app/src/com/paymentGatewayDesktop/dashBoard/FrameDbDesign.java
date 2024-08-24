package com.paymentGatewayDesktop.dashBoard;

import com.paymentGatewayDesktop.StaticContext;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class FrameDbDesign extends JFrame {

    private JPanel contentPane;
    private JTextField srcField;
    private JTable table, tblPayment;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private JTable tblAccount;
    private ButtonGroup grp;

    private String[] columns = {"ID","Mobile Num.", "Issue Date", "Card Num.", "Exp. Date"};
    private String[] rows = new String[5];

    public FrameDbDesign(){
        StaticContext.frDb = this;
        initialize();
    }


    private void initialize() {
        this.setTitle("Payment Dashboard");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(650, 200, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(null);

        JLabel lblPayDashboard = new JLabel("Payment Dashboard");
        lblPayDashboard.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        lblPayDashboard.setBounds(77, 14, 278, 30);
        contentPane.add(lblPayDashboard);

        srcField = new JTextField();
        srcField.setBounds(10,62 , 280, 20);
        srcField.setText("Search Account");
        srcField.setToolTipText("");
        contentPane.add(srcField);
        srcField.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(335, 62, 82, 23);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        contentPane.add(btnSearch);

        JRadioButton rdbtnMobile = new JRadioButton("Mobile");
        rdbtnMobile.setBounds(9, 97, 109, 23);
        contentPane.add(rdbtnMobile);

        JRadioButton rdbtnNumber = new JRadioButton("Card");
        rdbtnNumber.setBounds(181, 97, 109, 23);
        contentPane.add(rdbtnNumber);

        grp = new ButtonGroup();
        grp.add(rdbtnMobile);
        grp.add(rdbtnNumber);

        JLabel lblPayMethods = new JLabel("My Payment Methods");
        lblPayMethods.setBounds(10, 131, 143, 14);
        contentPane.add(lblPayMethods);

        JButton payMdAddBtn = new JButton("Add");
        payMdAddBtn.setBounds(335, 129, 82, 23);
        contentPane.add(payMdAddBtn);
        payMdAddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PaymentMethodAdd();
                try {
                    FrameDbDesign.this.showData();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton delBtn = new JButton("Delete");
        delBtn.setBounds(220, 129, 70, 23);
        contentPane.add(delBtn);
        delBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numberOfRow = table.getSelectedRow();
                if(numberOfRow>=0){
                    model.removeRow(numberOfRow);
                }else{
                    JOptionPane.showMessageDialog(null,"Select a row");
                }
            }
        });

        JButton updBtn = new JButton("Update");
        updBtn.setBounds(137, 129, 78, 23);
        contentPane.add(updBtn);
        updBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                try {
//                        FrameDbDesign.this.updateData();
//                } catch (ClassNotFoundException ex) {
//                        ex.printStackTrace();
//                }
            }
        });

        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setSelectionBackground(Color.orange);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10, 155, 410, 135);
        contentPane.add(scroll);

        JLabel lblMyBeneficiaries = new JLabel("My beneficiaries :-");
        lblMyBeneficiaries.setBounds(10, 288, 109, 30);
        contentPane.add(lblMyBeneficiaries);

        JButton btnAddFvAccount = new JButton("Add");
        btnAddFvAccount.setBounds(335, 294, 82, 23);
        contentPane.add(btnAddFvAccount);

        JScrollPane scrollFvAccount = new JScrollPane();
        scrollFvAccount.setBounds(10, 320, 414, 115);
        contentPane.add(scrollFvAccount);

        tblAccount = new JTable();
        tblAccount.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "Account ID", "Name", "Payment System"
                }
        ));
        scrollFvAccount.setViewportView(tblAccount);

        this.setVisible(true);

    }

    private void showData() throws ClassNotFoundException {

        String dbManager = "postgresql";
        String host = "localhost";
        String port = "5432";
        String db = "payment_method_add";
        String username = "postgres";
        String password = "1234";
        Class.forName("org.postgresql.Driver");

        try(Connection pgCon = DriverManager.getConnection(
                "jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {

            var query = "select id, mobile_number, issue_date, card_number, expire_date from public.add_paymethod_account_user; ";
            var pstmt = pgCon.prepareStatement(query);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()){
                this.repaint();
                this.rows[0] = resultSet.getString("id");
                this.rows[1] = resultSet.getString("mobile_number");
                this.rows[2] = resultSet.getString("issue_date");
                this.rows[3] = resultSet.getString("card_number");
                this.rows[4] = resultSet.getString("expire_date");
                this.model.addRow(this.rows);
            }

        }catch (SQLException | RuntimeException ex){
            ex.printStackTrace();
        }
    }

//    private void updateData() throws ClassNotFoundException {
//        String dbManager = "postgresql";
//        String host = "localhost";
//        String port = "5432";
//        String db = "payment_method_add";
//        String username = "postgres";
//        String password = "1234";
//        Class.forName("org.postgresql.Driver");
//        try(Connection pgCon = DriverManager.getConnection(
//                "jdbc:" + dbManager + "://" + host + ":" + port + "/" + db, username, password)) {
//            int numberOfRow = table.getSelectedRow();
//            String value = (table.getModel().getValueAt(numberOfRow, 0).toString());
//
//            var query = "UPDATE INTO public.log_user(id, mobile_number, issue_date, card_number, expire_date) VALUES " +
//                    "(?, ?, ?, ?, ?) where sno="+value ;
//            var pstmt = pgCon.prepareStatement(query);
//
//            String id = model.getValueAt(numberOfRow, 0).toString();
//            String mobile_number = model.getValueAt(numberOfRow, 1).toString();
//            String issue_date = model.getValueAt(numberOfRow, 2).toString();
//            String card_number = model.getValueAt(numberOfRow, 3).toString();
//            String expire_date = model.getValueAt(numberOfRow, 4).toString();
//
//            pstmt.setString(1, id);
//            pstmt.setString(2, mobile_number);
//            pstmt.setString(3, issue_date);
//            pstmt.setString(4, card_number);
//            pstmt.setString(5, expire_date);
//
//            pstmt.executeUpdate();
//
//        }catch (SQLException | RuntimeException ex){
//            ex.printStackTrace();
//        }
//    }

}
