/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.JDBC.JDBCManager;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static view.PlayerRegistrationForm.catagories;
import static view.PlayerRegistrationForm.chkbox;
import static view.PlayerRegistrationForm.games;
import static view.PlayerRegistrationForm.designers;
import static view.PlayerRegistrationForm.tempSelectedGames;

/**
 *
 * @author FURIOUS
 */
public class SelectGamePlayerRegistrationForm extends AbstractFrame {

    JPanel pnlCheckbox = new JPanel();

    /**
     * Creates new form SelectGamePlayerRegistrationForm
     */
    public SelectGamePlayerRegistrationForm() {
        initComponents();
        final JFrame frame = this;
        JDBCManager manager = new JDBCManager();
        manager.initSqliteConnection("bg.db");
        String sql = "SELECT g.gameId, g.gameName FROM game g;";
        ArrayList<HashMap<String, String>> al = manager.getQueryData(sql);
        int size = al.size();
        games = new Integer[size];
        pnlCheckbox.setLayout(new GridLayout(size, 1, 0, 2));
        JButton btnAdd = this.btnNext;
        chkbox = new JCheckBox[size];
        for (int i = 0; i < size; i++) {
            chkbox[i] = new JCheckBox();
            chkbox[i].setText(al.get(i).get("gameName"));
            pnlCheckbox.add(chkbox[i]);
            for (int j = 0; j < tempSelectedGames.size(); j++) {
                if (chkbox[i].getText().equals(tempSelectedGames.get(j))) {
                    chkbox[i].setSelected(true);
                    break;
                }
            }
        }

        frame.setDefaultCloseOperation(2);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempSelectedGames.clear();
                int size = chkbox.length;
                for (int i = 0, j = 0; i < size; i++) {
                    if (chkbox[i].isSelected() == true) {
                        tempSelectedGames.add(chkbox[i].getText());
                        games[j++] = new Integer(al.get(i).get("gameId"));
                    }
                }

                try {
                    String playerName = PlayerRegistrationForm.txtPlayerName.getText();
                    String playerEmail = PlayerRegistrationForm.txtPlayerEmail.getText();
                    String location = PlayerRegistrationForm.txtLocation.getText();
                    String fromTime = PlayerRegistrationForm.cmbFromTime.getSelectedItem().toString();
                    String toTime = PlayerRegistrationForm.cmbToTime.getSelectedItem().toString();
                    String optimalPlayer = PlayerRegistrationForm.cmbOptimalPlayer.getSelectedItem().toString();
                    String password = PlayerRegistrationForm.psw.getText();
                    if (playerEmail.isEmpty() || playerName.isEmpty() || location.isEmpty() || fromTime.isEmpty() || toTime.isEmpty() || optimalPlayer.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Some fields are missing.");
                    } else {
                        JDBCManager manager = new JDBCManager();
                        manager.initSqliteConnection("bg.db");
                        String sql = "SELECT p.email FROM Player p WHERE p.email = ?;";
                        if (manager.contains(sql, playerEmail)) {
                            JOptionPane.showMessageDialog(frame, "This email is already registered.");
                        } else if (!manager.contains(sql, playerEmail)) {
                            sql = "INSERT INTO Player(email, fromTime, location, optimalNumber, playerName, toTime, password) VALUES(?,?,?,?,?,?,?);";
                            manager.insertData(sql, playerEmail, fromTime, location, optimalPlayer, playerName, toTime, password);
                            sql = "SELECT p.playerId FROM Player p WHERE p.email = ?;";
                            ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, playerEmail);
                            Integer playerId = Integer.parseInt(al.get(0).get("playerId"));

                            sql = "INSERT INTO PlayerPrefferedCatagory(catagoryId, playerId) VALUES (?,?);";
                            for (int i = 0; i < catagories.length; i++) {
                                if (catagories[i] != null) {
                                    manager.insertData(sql, catagories[i], playerId);
                                }
                            }

                            sql = "INSERT INTO PlayerPrefferedDesigner(designerId, playerId) VALUES (?,?);";
                            System.out.println(designers.length);
                            for (int i = 0; i < designers.length; i++) {
                                if (designers[i] != null) {
                                    System.err.println(designers[i]);
                                    manager.insertData(sql, designers[i], playerId);
                                }
                            }

                            sql = "INSERT INTO PlayerPrefferedGame(gameId, playerId) VALUES (?,?);";
                            for (int i = 0; i < games.length; i++) {
                                if (games[i] != null) {
//                    System.err.println(games[i]);
                                    manager.insertData(sql, games[i], playerId);
                                }
                            }

                            JOptionPane.showMessageDialog(frame, "Registration Successful");
                            new PlayerPanel().setVisible(true);
                            frame.dispose();
                        }
                    }
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(frame, "Invalid data.");
                }

                //Codes to show finalized status
//                JOptionPane.showMessageDialog(frame, "Registration successful.");
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new SelectDesignerPlayerRegistrationForm().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpn = new javax.swing.JScrollPane(pnlCheckbox);
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        btnNext.setBackground(new java.awt.Color(51, 102, 255));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(51, 102, 255));
        btnBack.setText("Back");

        jLabel1.setText("Please select at least one game");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpn)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 168, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SelectGamePlayerRegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SelectGamePlayerRegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SelectGamePlayerRegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SelectGamePlayerRegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SelectGamePlayerRegistrationForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scpn;
    // End of variables declaration//GEN-END:variables
}
