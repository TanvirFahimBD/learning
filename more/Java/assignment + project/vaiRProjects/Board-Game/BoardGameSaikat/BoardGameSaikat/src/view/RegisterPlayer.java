/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.JDBC.JDBCManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author FURIOUS
 */
public class RegisterPlayer extends Frame {

    private static JFrame frame = null;
    static Integer[] designers = null;
    static Integer[] catagories = null;
    static Integer[] games = null;
    static JCheckBox[] chkbox = null;
    static ArrayList<String> tempSelectedDesigners = new ArrayList<>();
    static ArrayList<String> tempSelectedCatagory = new ArrayList<>();
    static ArrayList<String> tempSelectedGames = new ArrayList<>();

    /**
     * Creates new form RegisterPlayer
     */
    public RegisterPlayer() {
        initComponents();
        frame = this;
        final int size = model.HourList.getHourList().length;

        lblSelectDesigner.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();
                JDBCManager manager = new JDBCManager();
                manager.initSqliteConnection("bg.db");
                String sql = "SELECT gd.designerId, gd.designerName FROM GameDesigner gd;";
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql);
                int size = al.size();
                designers = new Integer[size];
                JPanel pnlCheckbox = new JPanel(new GridLayout(size, 1, 0, 2));
                JPanel pnlBottom = new JPanel(new GridLayout(0, 2));
                JButton btnAdd = new JButton("Add");
                pnlBottom.add(btnAdd);
                chkbox = new JCheckBox[size];
                for (int i = 0; i < size; i++) {
                    chkbox[i] = new JCheckBox();
                    chkbox[i].setText(al.get(i).get("designerName"));
                    pnlCheckbox.add(chkbox[i]);
                    for (int j = 0; j < tempSelectedDesigners.size(); j++) {
                        if (chkbox[i].getText().equals(tempSelectedDesigners.get(j))) {
                            chkbox[i].setSelected(true);
                            break;
                        }
                    }
                }
                JScrollPane jscpn = new JScrollPane(pnlCheckbox);
                frame.setLayout(new BorderLayout());
                frame.add(jscpn, BorderLayout.CENTER);
                frame.add(pnlBottom, BorderLayout.SOUTH);
                frame.setSize(300, 450);
                frame.setDefaultCloseOperation(2);
                frame.setVisible(true);
                frame.repaint();
                btnAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tempSelectedDesigners.clear();
                        int size = chkbox.length;
                        for (int i = 0, j = 0; i < size; i++) {
                            if (chkbox[i].isSelected() == true) {
                                tempSelectedDesigners.add(chkbox[i].getText());
                                designers[j++] = new Integer(al.get(i).get("designerId"));
                            }
                        }
                        frame.dispose();
                    }
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        lblSelectCatagory.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();
                JDBCManager manager = new JDBCManager();
                manager.initSqliteConnection("bg.db");
                String sql = "SELECT gc.catagoryId, gc.catagoryName FROM GameCatagory gc;";
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql);
                int size = al.size();
                catagories = new Integer[size];
                JPanel pnlCheckbox = new JPanel(new GridLayout(size, 1, 0, 2));
                JPanel pnlBottom = new JPanel(new GridLayout(0, 2));
                JButton btnAdd = new JButton("Add");
                pnlBottom.add(btnAdd);
                chkbox = new JCheckBox[size];
                for (int i = 0; i < size; i++) {
                    chkbox[i] = new JCheckBox();
                    chkbox[i].setText(al.get(i).get("catagoryName"));
                    pnlCheckbox.add(chkbox[i]);
                    for (int j = 0; j < tempSelectedCatagory.size(); j++) {
                        if (chkbox[i].getText().equals(tempSelectedCatagory.get(j))) {
                            chkbox[i].setSelected(true);
                            break;
                        }
                    }
                }
                JScrollPane jscpn = new JScrollPane(pnlCheckbox);
                frame.setLayout(new BorderLayout());
                frame.add(jscpn, BorderLayout.CENTER);
                frame.add(pnlBottom, BorderLayout.SOUTH);
                frame.setSize(300, 450);
                frame.setDefaultCloseOperation(2);
                frame.setVisible(true);
                btnAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tempSelectedCatagory.clear();
                        int size = chkbox.length;
                        for (int i = 0, j = 0; i < size; i++) {
                            if (chkbox[i].isSelected() == true) {
                                tempSelectedCatagory.add(chkbox[i].getText());
                                catagories[j++] = new Integer(al.get(i).get("catagoryId"));
                            }
                        }
                        frame.dispose();
                    }
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        lblSelectGame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame();
                JDBCManager manager = new JDBCManager();
                manager.initSqliteConnection("bg.db");
                String sql = "SELECT g.gameId, g.gameName FROM game g;";
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql);
                int size = al.size();
                games = new Integer[size];
                JPanel pnlCheckbox = new JPanel(new GridLayout(size, 1, 0, 2));
                JPanel pnlBottom = new JPanel(new GridLayout(0, 2));
                JButton btnAdd = new JButton("Add");
                pnlBottom.add(btnAdd);
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
                JScrollPane jscpn = new JScrollPane(pnlCheckbox);
                frame.setLayout(new BorderLayout());
                frame.add(jscpn, BorderLayout.CENTER);
                frame.add(pnlBottom, BorderLayout.SOUTH);
                frame.setSize(300, 450);
                frame.setDefaultCloseOperation(2);
                frame.setVisible(true);
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
                        frame.dispose();
                    }
                });
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        for (int x = 0; x < size; x++) {
            cmbFromTime.addItem(model.HourList.getHourList()[x]);
            cmbToTime.addItem(model.HourList.getHourList()[x]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPlayerName = new javax.swing.JTextField();
        txtPlayerEmail = new javax.swing.JTextField();
        cmbFromTime = new javax.swing.JComboBox<>();
        cmbOptimalPlayer = new javax.swing.JComboBox<>();
        btnAddPlayer = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        cmbToTime = new javax.swing.JComboBox<>();
        lblSelectCatagory = new javax.swing.JLabel();
        lblSelectGame = new javax.swing.JLabel();
        lblSelectDesigner = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Email address");

        jLabel3.setText("Location");

        jLabel4.setText("Preffered Catagory");

        jLabel5.setText("Preffered games");

        jLabel6.setText("Preffered designer");

        jLabel7.setText("Available timeslot");

        jLabel8.setText("Optimal numbers");

        cmbOptimalPlayer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True", "False" }));

        btnAddPlayer.setText("Sign up");
        btnAddPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlayerActionPerformed(evt);
            }
        });

        jLabel9.setText("Password");

        jLabel10.setText("to");

        lblSelectCatagory.setText("Please select catagory");

        lblSelectGame.setText("Please select game");

        lblSelectDesigner.setText("Please select designer");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel7))
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbToTime, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPlayerName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPlayerEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbOptimalPlayer, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSelectCatagory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSelectGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSelectDesigner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLocation)
                    .addComponent(btnAddPlayer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlayerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblSelectCatagory))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblSelectGame))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblSelectDesigner))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(cmbToTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOptimalPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPlayer)
                    .addComponent(jButton1))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayerActionPerformed
        try {
            String playerName = txtPlayerName.getText();
            String playerEmail = txtPlayerEmail.getText();
            String location = txtLocation.getText();
            String fromTime = cmbFromTime.getSelectedItem().toString();
            String toTime = cmbToTime.getSelectedItem().toString();
            String optimalPlayer = cmbOptimalPlayer.getSelectedItem().toString();
            String password = this.password.getText();
            if (playerEmail.isEmpty() || playerName.isEmpty() || location.isEmpty() || fromTime.isEmpty() || toTime.isEmpty() || optimalPlayer.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Some fields are missing.");
            } else {
                JDBCManager manager = new JDBCManager();
                manager.initSqliteConnection("bg.db");
                String sql = "SELECT p.email FROM Player p WHERE p.email = ?;";
                if (manager.contains(sql, playerEmail)) {
                    JOptionPane.showMessageDialog(this, "This email is already registered.");
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
                    for (int i = 0; i < designers.length; i++) {
                        if (designers[i] != null) {
//                    System.err.println(designers[i]);
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

                    JOptionPane.showMessageDialog(this, "Registration Successful");
                }
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Invalid data.");
        }

    }//GEN-LAST:event_btnAddPlayerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PlayerSite ps = new PlayerSite();
        ps.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPlayer;
    private javax.swing.JComboBox<String> cmbFromTime;
    private javax.swing.JComboBox<String> cmbOptimalPlayer;
    private javax.swing.JComboBox<String> cmbToTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblSelectCatagory;
    private javax.swing.JLabel lblSelectDesigner;
    private javax.swing.JLabel lblSelectGame;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtPlayerEmail;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables
}
