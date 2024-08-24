/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.JDBC.JDBCManager;
import java.awt.BorderLayout;
import java.awt.Component;
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
import static view.PlayerRegistrationForm.designers;

/**
 *
 * @author FURIOUS
 */
public class EditPlayerProfile extends AbstractFrame{

    static Integer[] designers = null;
    static Integer[] catagories = null;
    static Integer[] games = null;
    static JCheckBox[] chkbox = null;
    static ArrayList<String> tempSelectedDesigners = new ArrayList<>();
    static ArrayList<String> tempSelectedCatagory = new ArrayList<>();
    static ArrayList<String> tempSelectedGames = new ArrayList<>();

    private String playerName = null;
    private String playerEmail = null;
    private String playerLocation = null;
    private String fromTime = null;
    private String toTime = null;
    private String optimalNumbers = null;
    private String password = null;

    /**
     * Creates new form PlayerRegistrationForm
     */
    public EditPlayerProfile() {
        initComponents();
    }

    public EditPlayerProfile(String playerName, String playerEmail, String playerLocation, String fromTime, String toTime, String optimalNumbers, String password) {
        initComponents();
        String sql = "SELECT gc.catagoryName \n"
                + "FROM PlayerPrefferedCatagory ppc, GameCatagory gc \n"
                + "WHERE ppc.catagoryId = gc.catagoryId and ppc.playerId = ?;";
        JDBCManager manager = new JDBCManager();
        manager.initSqliteConnection("bg.db");
        ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, PlayerLoginForm.getCurrentPlayer());
        for (int x = 0; x < al.size(); x++) {
            tempSelectedCatagory.add(al.get(x).get("catagoryName"));
        }

        sql = "SELECT gd.designerName \n"
                + "FROM PlayerPrefferedDesigner ppd, GameDesigner gd \n"
                + "WHERE ppd.designerId = gd.designerId \n"
                + "AND ppd.playerId = ?;";
        al = manager.getQueryData(sql, PlayerLoginForm.getCurrentPlayer());
        for (int x = 0; x < al.size(); x++) {
            tempSelectedDesigners.add(al.get(x).get("designerName"));
        }

        sql = "SELECT g.gameName\n"
                + "FROM PlayerPrefferedGame ppg, Game g\n"
                + "WHERE ppg.gameId = g.gameId\n"
                + "AND ppg.playerId = ?;";
        al = manager.getQueryData(sql, PlayerLoginForm.getCurrentPlayer());
        for (int x = 0; x < al.size(); x++) {
            tempSelectedGames.add(al.get(x).get("gameName"));
        }

        this.playerEmail = playerEmail;
        this.playerLocation = playerLocation;
        this.playerName = playerName;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.optimalNumbers = optimalNumbers;
        this.password = password;
        int size = view.Hours.getHourList().length;
        for (int x = 0; x < size; x++) {
            cmbFromTime.addItem(view.Hours.getHourList()[x]);
            cmbToTime.addItem(view.Hours.getHourList()[x]);
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
                            }
                        }
                        for (int x = 0; x < tempSelectedDesigners.size(); x++) {
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
                        for (int x = 0; x < tempSelectedCatagory.size(); x++) {
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

                        for (int x = 0; x < tempSelectedGames.size(); x++) {
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

        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblcatagory = new javax.swing.JLabel();
        lblGames = new javax.swing.JLabel();
        lblDesigner = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName.setText("Name");

        lblEmail.setText("Email address");

        lblLocation.setText("Location");

        lblcatagory.setText("Preffered Catagory");

        lblGames.setText("Preffered games");

        lblDesigner.setText("Preffered designer");

        jLabel7.setText("Available timeslot");

        jLabel8.setText("Optimal numbers");

        cmbOptimalPlayer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "True", "False" }));

        btnSave.setBackground(new java.awt.Color(51, 102, 255));
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

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEmail)
                                    .addComponent(lblName)
                                    .addComponent(lblLocation)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel7))
                            .addComponent(lblGames)
                            .addComponent(lblcatagory)
                            .addComponent(lblDesigner))
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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlayerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocation)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcatagory)
                    .addComponent(lblEditCatagory))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGames)
                    .addComponent(lblEditGame))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesigner)
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
                .addContainerGap(39, Short.MAX_VALUE))
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
            manager.deleteData(sql, new String[]{Integer.toString(PlayerLoginForm.getCurrentPlayer())});

            sql = "DELETE FROM PlayerPrefferedDesigner\n"
                    + "WHERE playerId = ?;";
            manager.deleteData(sql, new String[]{Integer.toString(PlayerLoginForm.getCurrentPlayer())});

            sql = "DELETE FROM PlayerPrefferedGame\n"
                    + "WHERE playerId = ?;";
            manager.deleteData(sql, new String[]{Integer.toString(PlayerLoginForm.getCurrentPlayer())});

            sql = "UPDATE Player\n"
                    + "SET email = ?, \n"
                    + "fromTime = ?, \n"
                    + "location = ?, \n"
                    + "optimalNumber = ?, \n"
                    + "password = ?, \n"
                    + "playerName = ?, \n"
                    + "toTime = ?\n"
                    + "WHERE playerId = ?;";
            manager.updateData(sql, playerEmail, fromTime, playerLocation, optimalNumbers, password, playerName, toTime, PlayerLoginForm.getCurrentPlayer());

//Update player preffered catagory
            sql = "SELECT catagoryId FROM GameCatagory WHERE catagoryName = ?;";
            catagories = new Integer[tempSelectedCatagory.size()];
            designers = new Integer[tempSelectedDesigners.size()];
            games = new Integer[tempSelectedGames.size()];

            for (int x = 0; x < tempSelectedCatagory.size(); x++) {
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, tempSelectedCatagory.get(x));
                catagories[x] = Integer.parseInt(al.get(0).get("catagoryId"));
            }
            sql = "INSERT INTO PlayerPrefferedCatagory(playerId, catagoryId) \n"
                    + "VALUES (?, ?);";
            try {
                for (int x = 0; x < catagories.length; x++) {
                    manager.insertData(sql, PlayerLoginForm.getCurrentPlayer(), catagories[x]);
                }
            } catch (Exception e) {

            }

//Update player preffered Designer
            sql = "SELECT designerId FROM GameDesigner WHERE designerName = ?;";
            for (int x = 0; x < tempSelectedDesigners.size(); x++) {
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, tempSelectedDesigners.get(x));
//            System.out.println("@Line 529 "+Integer.parseInt(al.get(0).get("designerId")));
                designers[x] = Integer.parseInt(al.get(0).get("designerId"));
            }

            sql = "INSERT INTO PlayerPrefferedDesigner(playerId, designerId) \n"
                    + "VALUES (?, ?);";
            try {
                for (int x = 0; x < designers.length; x++) {
                    manager.insertData(sql, PlayerLoginForm.getCurrentPlayer(), designers[x]);
                }
            } catch (Exception e) {
            }

//Update player preffered game
            boolean b = false;
            sql = "SELECT gameId FROM Game WHERE gameName = ?;";
            for (int x = 0; x < tempSelectedGames.size(); x++) {
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, tempSelectedGames.get(x));
//            System.out.println("@Line 540 "+Integer.parseInt(al.get(0).get("gameId")));
                games[x] = Integer.parseInt(al.get(0).get("gameId"));
            }
            sql = "INSERT INTO PlayerPrefferedGame(playerId, gameId) \n"
                    + "VALUES (?, ?);";
            try {
                for (int x = 0; x < games.length; x++) {
                    b = manager.insertData(sql, PlayerLoginForm.getCurrentPlayer(), games[x]);
                }
            } catch (Exception e) {
            }

            if (b == true) {
                JOptionPane.showMessageDialog(this, "All data updated successfully.");
                this.setVisible(false);
                PlayerHomeWindow.frame = new PlayerHomeWindow();
                PlayerHomeWindow.frame.setVisible(true);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Invalid data");
        } catch (Exception se) {

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PlayerHomeWindow ph = new PlayerHomeWindow();
        ph.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbFromTime;
    private javax.swing.JComboBox<String> cmbOptimalPlayer;
    private javax.swing.JComboBox<String> cmbToTime;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblDesigner;
    private javax.swing.JLabel lblEditCatagory;
    private javax.swing.JLabel lblEditDesigner;
    private javax.swing.JLabel lblEditGame;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGames;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblcatagory;
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
