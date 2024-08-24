/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.JDBC.JDBCManager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import static view.RegisterPlayer.designers;

/**
 *
 * @author FURIOUS
 */
public class EditPlayer extends Frame {

    static Integer[] designers = null;
    static Integer[] catagories = null;
    static Integer[] games = null;
    static JCheckBox[] chkbox = null;
    static ArrayList<String> tempDesigners = new ArrayList<>();
    static ArrayList<String> tempCatagory = new ArrayList<>();
    static ArrayList<String> tempGames = new ArrayList<>();

    private String playerName = null;
    private String playerEmail = null;
    private String playerLocation = null;
    private String fromTime = null;
    private String toTime = null;
    private String optimalNumbers = null;
    private String password = null;

    /**
     * Creates new form RegisterPlayer
     */
    public EditPlayer() {
        initComponents();
    }

    public EditPlayer(String playerName, String playerEmail, String playerLocation, String fromTime, String toTime, String optimalNumbers, String password) {
        initComponents();
        String sql = "SELECT gc.catagoryName \n"
                + "FROM PlayerPrefferedCatagory ppc, GameCatagory gc \n"
                + "WHERE ppc.catagoryId = gc.catagoryId and ppc.playerId = ?;";
        JDBCManager manager = new JDBCManager();
        manager.initSqliteConnection("bg.db");
        ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
        for (int x = 0; x < al.size(); x++) {
            tempCatagory.add(al.get(x).get("catagoryName"));
        }

        sql = "SELECT gd.designerName \n"
                + "FROM PlayerPrefferedDesigner ppd, GameDesigner gd \n"
                + "WHERE ppd.designerId = gd.designerId \n"
                + "AND ppd.playerId = ?;";
        al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
        for (int x = 0; x < al.size(); x++) {
            tempDesigners.add(al.get(x).get("designerName"));
        }

        sql = "SELECT g.gameName\n"
                + "FROM PlayerPrefferedGame ppg, Game g\n"
                + "WHERE ppg.gameId = g.gameId\n"
                + "AND ppg.playerId = ?;";
        al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
        for (int x = 0; x < al.size(); x++) {
            tempGames.add(al.get(x).get("gameName"));
        }

        this.playerEmail = playerEmail;
        this.playerLocation = playerLocation;
        this.playerName = playerName;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.optimalNumbers = optimalNumbers;
        this.password = password;
        int size = model.HourList.getHourList().length;
        for (int x = 0; x < size; x++) {
            cmbFromTime.addItem(model.HourList.getHourList()[x]);
            cmbToTime.addItem(model.HourList.getHourList()[x]);
        }
        txtLocation.setText(playerLocation);
        txtPlayerEmail.setText(playerEmail);
        txtPlayerName.setText(playerName);
        cmbFromTime.setSelectedItem(fromTime);
        cmbToTime.setSelectedItem(toTime);
        psw.setText(password);
        cmbOptimalPlayer.setSelectedItem(optimalNumbers);

        lblEditDesigner.addMouseListener(new MouseInputListener() {
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
                    for (int j = 0; j < tempDesigners.size(); j++) {
                        if (chkbox[i].getText().equals(tempDesigners.get(j))) {
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
                        tempDesigners.clear();
                        int size = chkbox.length;
                        for (int i = 0, j = 0; i < size; i++) {
                            if (chkbox[i].isSelected() == true) {
                                tempDesigners.add(chkbox[i].getText());
                            }
                        }
                        for (int x = 0; x < tempDesigners.size(); x++) {
//                            System.out.println(tempSelectedDesigners.get(x));
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

        lblEditCatagory.addMouseListener(new MouseListener() {
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
                    for (int j = 0; j < tempCatagory.size(); j++) {
                        if (chkbox[i].getText().equals(tempCatagory.get(j))) {
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
                        tempCatagory.clear();
                        int size = chkbox.length;
                        for (int i = 0, j = 0; i < size; i++) {
                            if (chkbox[i].isSelected() == true) {
                                tempCatagory.add(chkbox[i].getText());
                                catagories[j++] = new Integer(al.get(i).get("catagoryId"));
                            }
                        }
                        for (int x = 0; x < tempCatagory.size(); x++) {
//                            System.out.println(tempSelectedCatagory.get(x));
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

        lblEditGame.addMouseListener(new MouseListener() {
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
                    for (int j = 0; j < tempGames.size(); j++) {
                        if (chkbox[i].getText().equals(tempGames.get(j))) {
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
                        tempGames.clear();
                        int size = chkbox.length;
                        for (int i = 0, j = 0; i < size; i++) {
                            if (chkbox[i].isSelected() == true) {
                                tempGames.add(chkbox[i].getText());
                                games[j++] = new Integer(al.get(i).get("gameId"));
                            }
                        }

                        for (int x = 0; x < tempGames.size(); x++) {
//                            System.out.println(tempSelectedGames.get(x));
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
        cmbOptimalPlayer = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        psw = new javax.swing.JPasswordField();
        lblEditCatagory = new javax.swing.JLabel();
        lblEditGame = new javax.swing.JLabel();
        lblEditDesigner = new javax.swing.JLabel();
        cmbFromTime = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbToTime = new javax.swing.JComboBox<>();
        txtLocation = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

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

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel9.setText("Password");

        lblEditCatagory.setForeground(new java.awt.Color(51, 51, 255));
        lblEditCatagory.setText("Click to edit...");

        lblEditGame.setForeground(new java.awt.Color(51, 51, 255));
        lblEditGame.setText("Click to edit...");

        lblEditDesigner.setForeground(new java.awt.Color(51, 51, 255));
        lblEditDesigner.setText("Click to edit...");

        jLabel10.setText("to");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Edit Player Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEditDesigner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(psw)
                            .addComponent(cmbOptimalPlayer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPlayerEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPlayerName)
                            .addComponent(lblEditCatagory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmbFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbToTime, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblEditGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLocation))))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(lblEditCatagory))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblEditGame))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblEditDesigner))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cmbToTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOptimalPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(psw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        this.playerEmail = this.txtPlayerEmail.getText();
        this.playerLocation = this.txtLocation.getText();
        this.playerName = this.txtPlayerName.getText();
        this.fromTime = this.cmbFromTime.getSelectedItem().toString();
        this.toTime = this.cmbToTime.getSelectedItem().toString();
        this.optimalNumbers = this.cmbOptimalPlayer.getSelectedItem().toString();
        this.password = this.psw.getText();
        try {
            JDBCManager manager = new JDBCManager();
            manager.initSqliteConnection("bg.db");
            String sql = "DELETE FROM PlayerPrefferedCatagory\n"
                    + "WHERE playerId = ?;";
            manager.deleteData(sql, new String[]{Integer.toString(LoginPlayer.getCurrentPlayer())});

            sql = "DELETE FROM PlayerPrefferedDesigner\n"
                    + "WHERE playerId = ?;";
            manager.deleteData(sql, new String[]{Integer.toString(LoginPlayer.getCurrentPlayer())});

            sql = "DELETE FROM PlayerPrefferedGame\n"
                    + "WHERE playerId = ?;";
            manager.deleteData(sql, new String[]{Integer.toString(LoginPlayer.getCurrentPlayer())});

            sql = "UPDATE Player\n"
                    + "SET email = ?, \n"
                    + "fromTime = ?, \n"
                    + "location = ?, \n"
                    + "optimalNumber = ?, \n"
                    + "password = ?, \n"
                    + "playerName = ?, \n"
                    + "toTime = ?\n"
                    + "WHERE playerId = ?;";
            manager.updateData(sql, playerEmail, fromTime, playerLocation, optimalNumbers, password, playerName, toTime, LoginPlayer.getCurrentPlayer());

//Update player preffered catagory
            sql = "SELECT catagoryId FROM GameCatagory WHERE catagoryName = ?;";
            catagories = new Integer[tempCatagory.size()];
            designers = new Integer[tempDesigners.size()];
            games = new Integer[tempGames.size()];

            for (int x = 0; x < tempCatagory.size(); x++) {
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, tempCatagory.get(x));
                catagories[x] = Integer.parseInt(al.get(0).get("catagoryId"));
            }
            sql = "INSERT INTO PlayerPrefferedCatagory(playerId, catagoryId) \n"
                    + "VALUES (?, ?);";
            try {
                for (int x = 0; x < catagories.length; x++) {
                    manager.insertData(sql, LoginPlayer.getCurrentPlayer(), catagories[x]);
                }
            } catch (Exception e) {

            }

//Update player preffered Designer
            sql = "SELECT designerId FROM GameDesigner WHERE designerName = ?;";
            for (int x = 0; x < tempDesigners.size(); x++) {
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, tempDesigners.get(x));
//            System.out.println("@Line 529 "+Integer.parseInt(al.get(0).get("designerId")));
                designers[x] = Integer.parseInt(al.get(0).get("designerId"));
            }

            sql = "INSERT INTO PlayerPrefferedDesigner(playerId, designerId) \n"
                    + "VALUES (?, ?);";
            try {
                for (int x = 0; x < designers.length; x++) {
                    manager.insertData(sql, LoginPlayer.getCurrentPlayer(), designers[x]);
                }
            } catch (Exception e) {
            }

//Update player preffered game
            boolean b = false;
            sql = "SELECT gameId FROM Game WHERE gameName = ?;";
            for (int x = 0; x < tempGames.size(); x++) {
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, tempGames.get(x));
//            System.out.println("@Line 540 "+Integer.parseInt(al.get(0).get("gameId")));
                games[x] = Integer.parseInt(al.get(0).get("gameId"));
            }
            sql = "INSERT INTO PlayerPrefferedGame(playerId, gameId) \n"
                    + "VALUES (?, ?);";
            try {
                for (int x = 0; x < games.length; x++) {
                    b = manager.insertData(sql, LoginPlayer.getCurrentPlayer(), games[x]);
                }
            } catch (Exception e) {
            }

            if (b == true) {
                JOptionPane.showMessageDialog(this, "All data updated successfully.");
                this.setVisible(false);
                PlayerHome.framePlayerHome = new PlayerHome();
                PlayerHome.framePlayerHome.setVisible(true);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Invalid data");
        } catch (Exception se) {

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PlayerHome ph = new PlayerHome();
        ph.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbFromTime;
    private javax.swing.JComboBox<String> cmbOptimalPlayer;
    private javax.swing.JComboBox<String> cmbToTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblEditCatagory;
    private javax.swing.JLabel lblEditDesigner;
    private javax.swing.JLabel lblEditGame;
    private javax.swing.JPasswordField psw;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtPlayerEmail;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the playerEmail
     */
    public String getPlayerEmail() {
        return playerEmail;
    }

    /**
     * @param playerEmail the playerEmail to set
     */
    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    /**
     * @return the playerLocation
     */
    public String getPlayerLocation() {
        return playerLocation;
    }

    /**
     * @param playerLocation the playerLocation to set
     */
    public void setPlayerLocation(String playerLocation) {
        this.playerLocation = playerLocation;
    }

    /**
     * @return the fromTime
     */
    public String getFromTime() {
        return fromTime;
    }

    /**
     * @param fromTime the fromTime to set
     */
    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * @return the toTime
     */
    public String getToTime() {
        return toTime;
    }

    /**
     * @param toTime the toTime to set
     */
    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    /**
     * @return the optimalNumbers
     */
    public String getOptimalNumbers() {
        return optimalNumbers;
    }

    /**
     * @param optimalNumbers the optimalNumbers to set
     */
    public void setOptimalNumbers(String optimalNumbers) {
        this.optimalNumbers = optimalNumbers;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
