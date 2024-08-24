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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.MouseInputListener;
import model.HourList;

/**
 *
 * @author FURIOUS
 */
public class PlayerHome extends Frame {

    static JFrame framePlayerHome = null;

    /**
     * @return the tpPlayerProfile
     */
    public static javax.swing.JTabbedPane getTabbedPane() {
        return tpPlayerProfile;
    }

    /**
     * Creates new form EditProfile
     */
    public PlayerHome() {
        initComponents();
        framePlayerHome = this;
        this.setTitle("Player Home");
        final JDBCManager manager = new JDBCManager();
        manager.initSqliteConnection("bg.db");
        String sql = "SELECT p.email, p.fromTime, p.location, p.optimalNumber, p.password, p.playerName, p.toTime\n"
                + "FROM Player p\n"
                + "WHERE p.playerId = ?;";

        ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
        lblEmail.setText(al.get(0).get("email"));
        lblLocation.setText(al.get(0).get("location"));
        lblName.setText(al.get(0).get("playerName"));
        lblOptimalNumbers.setText(al.get(0).get("optimalNumber"));
        lblPassword.setText(al.get(0).get("password"));
        lblFromTime.setText(al.get(0).get("fromTime"));
        lblToTime.setText(al.get(0).get("toTime"));

        lblPrefferedCatagory.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayerHome.framePlayerHome.dispose();
                final JFrame frame = new JFrame();
                final JList list = new JList();
                DefaultListModel dlm = new DefaultListModel();
                list.setModel(dlm);
                manager.initSqliteConnection("bg.db");
                String sql = "SELECT gc.catagoryName, gc.catagoryId\n"
                        + "FROM GameCatagory gc, PlayerPrefferedCatagory ppc\n"
                        + "WHERE gc.catagoryId = ppc.catagoryId\n"
                        + "AND ppc.playerId = ?;";
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
                int size = al.size();
                for (int x = 0; x < size; x++) {
                    dlm.addElement(al.get(x).get("catagoryName"));
                }
                JScrollPane scpn = new JScrollPane(list);
                JPanel pnlBottom = new JPanel(new GridLayout(0, 2, 10, 0));
                JButton btnShowPlayerList = new JButton("Show players");
                JButton btnClose = new JButton("Close");
                frame.setLayout(new BorderLayout());
                frame.add(scpn, BorderLayout.CENTER);
                pnlBottom.add(btnClose);
                pnlBottom.add(btnShowPlayerList);
                frame.add(pnlBottom, BorderLayout.SOUTH);
                frame.setSize(300, 450);
                frame.setVisible(true);
                frame.repaint();
                btnClose.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        PlayerHome.framePlayerHome.setVisible(true);
                    }
                });

                btnShowPlayerList.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        manager.initSqliteConnection("bg.db");
                        String sql = "SELECT p.fromTime, p.toTime FROM Player p WHERE p.playerId = ?;";
                        ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
                        final String fromTime = al.get(0).get("fromTime");
                        final String toTime = al.get(0).get("toTime");

                        int currentPlayerStartTimeIndex = 0;
                        int currentPlayerEndTimeIndex = 0;
                        for (int x = 0; x < HourList.getHourList().length; x++) {
                            if (HourList.getHourList()[x].equals(fromTime)) {
                                currentPlayerStartTimeIndex = x;
                                break;
                            }
                        }

                        for (int x = 0; x < HourList.getHourList().length; x++) {
                            if (HourList.getHourList()[x].equals(toTime)) {
                                currentPlayerEndTimeIndex = x;
                                break;
                            }
                        }
                        final String[] startTimeList = new String[(currentPlayerEndTimeIndex - currentPlayerStartTimeIndex)];
                        for (int x = currentPlayerStartTimeIndex; x < currentPlayerEndTimeIndex; x++) {
                            startTimeList[x - currentPlayerStartTimeIndex] = HourList.getHourList()[x];
                        }
                        sql = "SELECT p.playerName FROM Player p, PlayerPrefferedCatagory ppc, GameCatagory gc\n"
                                + "WHERE p.fromTime = ?\n"
                                + "AND p.location = ?\n"
                                + "AND p.playerId = ppc.playerId\n"
                                + "AND ppc.catagoryId = gc.catagoryId\n"
                                + "AND gc.catagoryName = ?;";
                        al.clear();
//                        System.err.println("@Line 131 currentPlayerStartTimeIndex = " + currentPlayerStartTimeIndex);
//                        System.err.println("@Line 132 currentPlayerEndTimeIndex = " + currentPlayerEndTimeIndex);
                        final String catagoryName = list.getSelectedValue().toString();
                        for (int x = 0; x < (currentPlayerEndTimeIndex - currentPlayerStartTimeIndex); x++) {
                            al.addAll(manager.getQueryData(sql, startTimeList[x], lblLocation.getText(), catagoryName));
                        }

                        final JFrame frameCompetiblePlayers = new JFrame();
                        frameCompetiblePlayers.setLayout(new BorderLayout());
                        JPanel pnlTop = new JPanel(new GridLayout());
                        JLabel topLbl = new JLabel("<html><b>Showing all players from " + lblLocation.getText() + " who are available from " + fromTime + " to " + toTime + "</b></html>");
                        pnlTop.setSize(500, 40);
                        pnlTop.add(topLbl);
                        JPanel pnlBottom = new JPanel(new GridLayout(0, 2, 10, 0));
                        JButton btnBack = new JButton("Back");
                        JButton btnBookmark = new JButton("Bookmark this search");
                        pnlBottom.add(btnBack);
                        pnlBottom.add(btnBookmark);
                        frameCompetiblePlayers.add(pnlTop, BorderLayout.NORTH);
                        frameCompetiblePlayers.add(pnlBottom, BorderLayout.SOUTH);
                        JList lstCompetiblePlayers = new JList();
                        DefaultListModel dlm1 = new DefaultListModel();
                        lstCompetiblePlayers.setModel(dlm1);
                        for (int i = 0; i < al.size(); i++) {
                            dlm1.addElement(al.get(i).get("playerName"));
                        }
                        JScrollPane jscpn1 = new JScrollPane(lstCompetiblePlayers);
                        frameCompetiblePlayers.add(jscpn1, BorderLayout.CENTER);
                        frameCompetiblePlayers.setSize(500, 650);
                        frameCompetiblePlayers.setDefaultCloseOperation(2);
                        frameCompetiblePlayers.setVisible(true);
                        frame.dispose();
                        frameCompetiblePlayers.repaint();
                        btnBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame.setVisible(true);
                                frameCompetiblePlayers.dispose();
                            }
                        });

                        btnBookmark.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String bookmarkTitle = JOptionPane.showInputDialog("Please enter bookmark title");
                                String sql = "INSERT INTO bookmark(bookmarkTitle, bookmarkSql, playerId) VALUES(?,?,?);";
                                boolean isBlank = false;
                                for (int i = 0; i < startTimeList.length; i++) {
                                    String bookmarkQueryString = "SELECT p.playerName FROM Player p, PlayerPrefferedCatagory ppc, GameCatagory gc\n"
                                            + "WHERE p.fromTime = '" + startTimeList[i] + "'\n"
                                            + " AND p.location = '" + lblLocation.getText() + "'\n"
                                            + " AND p.playerId = ppc.playerId\n"
                                            + " AND ppc.catagoryId = gc.catagoryId\n"
                                            + " AND gc.catagoryName = '" + catagoryName + "'"
                                            + ";";
//                                    System.out.println(bookmarkTitle);
                                    if (bookmarkTitle == null || bookmarkTitle.isEmpty()) {
                                        isBlank = true;
                                    } else {
                                        manager.insertData(sql, bookmarkTitle, bookmarkQueryString, LoginPlayer.getCurrentPlayer());
                                        isBlank = false;
                                    }
                                }
                                if (isBlank == true) {
                                    JOptionPane.showMessageDialog(null, "Please insert a bookmark title.");
                                } else {
                                    JOptionPane.showMessageDialog(frameCompetiblePlayers, "<html>Bookmark has been saved.<br>To open a saved bookmark, go to \"Bookmarks\" tab.</html>");
                                    frame.setVisible(true);
                                    frameCompetiblePlayers.dispose();
                                }
                            }
                        });
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

        lblPrefferedDesigner.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayerHome.framePlayerHome.dispose();
                final JFrame frame = new JFrame();
                final JList list = new JList();
                DefaultListModel dlm = new DefaultListModel();
                list.setModel(dlm);
                manager.initSqliteConnection("bg.db");
                String sql = "SELECT gd.designerName, gd.designerId\n"
                        + "FROM GameDesigner gd, PlayerPrefferedDesigner ppd\n"
                        + "WHERE gd.designerId = ppd.designerId\n"
                        + "AND ppd.playerId = ?;";
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
                int size = al.size();
                for (int x = 0; x < size; x++) {
                    dlm.addElement(al.get(x).get("designerName"));
                }
                JScrollPane scpn = new JScrollPane(list);
                JPanel pnlBottom = new JPanel(new GridLayout(0, 2, 10, 0));
                JButton btnShowPlayerList = new JButton("Show players");
                JButton btnClose = new JButton("Close");
                frame.setLayout(new BorderLayout());
                frame.add(scpn, BorderLayout.CENTER);
                pnlBottom.add(btnClose);
                pnlBottom.add(btnShowPlayerList);
                frame.add(pnlBottom, BorderLayout.SOUTH);
                frame.setSize(300, 450);
                frame.setVisible(true);
                frame.repaint();
                btnClose.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        PlayerHome.framePlayerHome.setVisible(true);
                    }
                });

                btnShowPlayerList.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manager.initSqliteConnection("bg.db");
                        String sql = "SELECT p.fromTime, p.toTime FROM Player p WHERE p.playerId = ?;";
                        ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
                        final String fromTime = al.get(0).get("fromTime");
                        final String toTime = al.get(0).get("toTime");

                        int currentPlayerStartTimeIndex = 0;
                        int currentPlayerEndTimeIndex = 0;
                        for (int x = 0; x < HourList.getHourList().length; x++) {
                            if (HourList.getHourList()[x].equals(fromTime)) {
                                currentPlayerStartTimeIndex = x;
                                break;
                            }
                        }

                        for (int x = 0; x < HourList.getHourList().length; x++) {
                            if (HourList.getHourList()[x].equals(toTime)) {
                                currentPlayerEndTimeIndex = x;
                                break;
                            }
                        }
                        final String[] startTimeList = new String[(currentPlayerEndTimeIndex - currentPlayerStartTimeIndex)];
                        for (int x = currentPlayerStartTimeIndex; x < currentPlayerEndTimeIndex; x++) {
                            startTimeList[x - currentPlayerStartTimeIndex] = HourList.getHourList()[x];
                        }
                        sql = "SELECT p.playerName FROM Player p, PlayerPrefferedDesigner ppd, GameDesigner gd\n"
                                + "WHERE p.fromTime = ?\n"
                                + "AND p.location = ?\n"
                                + "AND p.playerId = ppd.playerId\n"
                                + "AND ppd.designerId = gd.designerId\n"
                                + "AND gd.designerName = ?;";
                        al.clear();
//                        System.err.println("@Line 131 currentPlayerStartTimeIndex = " + currentPlayerStartTimeIndex);
//                        System.err.println("@Line 132 currentPlayerEndTimeIndex = " + currentPlayerEndTimeIndex);
                        final String designerName = list.getSelectedValue().toString();
                        for (int x = 0; x < (currentPlayerEndTimeIndex - currentPlayerStartTimeIndex); x++) {
                            al.addAll(manager.getQueryData(sql, startTimeList[x], lblLocation.getText(), designerName));
                        }

                        final JFrame frameCompetiblePlayers = new JFrame();
                        frameCompetiblePlayers.setLayout(new BorderLayout());
                        JPanel pnlTop = new JPanel(new GridLayout());
                        JLabel topLbl = new JLabel("<html><b>Showing all players from " + lblLocation.getText() + " who are available from " + fromTime + " to " + toTime + "</b></html>");
                        pnlTop.setSize(500, 40);
                        pnlTop.add(topLbl);
                        JPanel pnlBottom = new JPanel(new GridLayout(0, 2, 10, 0));
                        JButton btnBack = new JButton("Back");
                        JButton btnBookmark = new JButton("Bookmark this search");
                        pnlBottom.add(btnBack);
                        pnlBottom.add(btnBookmark);
                        frameCompetiblePlayers.add(pnlTop, BorderLayout.NORTH);
                        frameCompetiblePlayers.add(pnlBottom, BorderLayout.SOUTH);
                        JList lstCompetiblePlayers = new JList();
                        DefaultListModel dlm1 = new DefaultListModel();
                        lstCompetiblePlayers.setModel(dlm1);
                        for (int i = 0; i < al.size(); i++) {
                            dlm1.addElement(al.get(i).get("playerName"));
                        }
                        JScrollPane jscpn1 = new JScrollPane(lstCompetiblePlayers);
                        frameCompetiblePlayers.add(jscpn1, BorderLayout.CENTER);
                        frameCompetiblePlayers.setSize(500, 650);
                        frameCompetiblePlayers.setDefaultCloseOperation(2);
                        frameCompetiblePlayers.setVisible(true);
                        frameCompetiblePlayers.repaint();
                        frame.dispose();

                        btnBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame.setVisible(true);
                                frameCompetiblePlayers.dispose();
                            }
                        });

                        btnBookmark.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String bookmarkTitle = JOptionPane.showInputDialog("Please enter bookmark title");
                                String sql = "INSERT INTO bookmark(bookmarkTitle, bookmarkSql, playerId) VALUES(?,?,?);";
                                boolean isBlank = false;
                                for (int i = 0; i < startTimeList.length; i++) {
                                    String bookmarkQueryString = "SELECT p.playerName FROM Player p, PlayerPrefferedDesigner ppd, GameDesigner gd\n"
                                            + "WHERE p.fromTime = '" + startTimeList[i] + "'\n"
                                            + " AND p.location = '" + lblLocation.getText() + "'\n"
                                            + " AND p.playerId = ppd.playerId\n"
                                            + " AND ppd.designerId = gd.designerId\n"
                                            + " AND gd.designerName = '" + designerName + "'"
                                            + ";";
//                                    System.out.println(bookmarkQueryString);
                                    if (bookmarkTitle == null || bookmarkTitle.isEmpty()) {
                                        isBlank = true;
                                    } else {
                                        manager.insertData(sql, bookmarkTitle, bookmarkQueryString, LoginPlayer.getCurrentPlayer());
                                        isBlank = false;
                                    }
                                }
                                if (isBlank == true) {
                                    JOptionPane.showMessageDialog(null, "Please insert a bookmark title.");
                                } else {
                                    JOptionPane.showMessageDialog(frameCompetiblePlayers, "<html>Bookmark has been saved.<br>To open a saved bookmark, go to \"Bookmarks\" tab.</html>");
                                    frame.setVisible(true);
                                    frameCompetiblePlayers.dispose();
                                }
                            }
                        });
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

        lblPrefferedGames.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayerHome.framePlayerHome.dispose();
                final JFrame frame = new JFrame();
                final JList list = new JList();
                DefaultListModel dlm = new DefaultListModel();
                list.setModel(dlm);
                manager.initSqliteConnection("bg.db");
                String sql = "SELECT g.gameName, g.gameId\n"
                        + "FROM Game g, PlayerPrefferedGame ppg\n"
                        + "WHERE g.gameId = ppg.gameId\n"
                        + "AND ppg.playerId = ?";
                ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
                int size = al.size();
                for (int x = 0; x < size; x++) {
                    dlm.addElement(al.get(x).get("gameName"));
                }
                JScrollPane scpn = new JScrollPane(list);
                JPanel pnlBottom = new JPanel(new GridLayout(0, 2, 10, 0));
                JButton btnShowPlayerList = new JButton("Show players");
                JButton btnClose = new JButton("Close");
                frame.setLayout(new BorderLayout());
                frame.add(scpn, BorderLayout.CENTER);
                pnlBottom.add(btnClose);
                pnlBottom.add(btnShowPlayerList);
                frame.add(pnlBottom, BorderLayout.SOUTH);
                frame.setSize(300, 450);
                frame.setVisible(true);
                frame.repaint();
                btnClose.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        PlayerHome.framePlayerHome.setVisible(true);
                    }
                });

                btnShowPlayerList.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manager.initSqliteConnection("bg.db");
                        String sql = "SELECT p.fromTime, p.toTime FROM Player p WHERE p.playerId = ?;";
                        ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
                        final String fromTime = al.get(0).get("fromTime");
                        final String toTime = al.get(0).get("toTime");

                        int currentPlayerStartTimeIndex = 0;
                        int currentPlayerEndTimeIndex = 0;
                        for (int x = 0; x < HourList.getHourList().length; x++) {
                            if (HourList.getHourList()[x].equals(fromTime)) {
                                currentPlayerStartTimeIndex = x;
                                break;
                            }
                        }

                        for (int x = 0; x < HourList.getHourList().length; x++) {
                            if (HourList.getHourList()[x].equals(toTime)) {
                                currentPlayerEndTimeIndex = x;
                                break;
                            }
                        }
                        final String[] startTimeList = new String[(currentPlayerEndTimeIndex - currentPlayerStartTimeIndex)];
                        for (int x = currentPlayerStartTimeIndex; x < currentPlayerEndTimeIndex; x++) {
                            startTimeList[x - currentPlayerStartTimeIndex] = HourList.getHourList()[x];
                        }
                        sql = "SELECT p.playerName\n"
                                + "FROM Player p, PlayerPrefferedGame ppg, Game g\n"
                                + "WHERE p.fromTime = ?\n"
                                + "AND p.location = ?\n"
                                + "AND p.playerId = ppg.playerId\n"
                                + "AND ppg.gameId = g.gameId\n"
                                + "AND g.gameName = ?;";
                        al.clear();
//                        System.err.println("@Line 131 currentPlayerStartTimeIndex = " + currentPlayerStartTimeIndex);
//                        System.err.println("@Line 132 currentPlayerEndTimeIndex = " + currentPlayerEndTimeIndex);
                        final String gameName = list.getSelectedValue().toString();
                        for (int x = 0; x < (currentPlayerEndTimeIndex - currentPlayerStartTimeIndex); x++) {
                            al.addAll(manager.getQueryData(sql, startTimeList[x], lblLocation.getText(), gameName));
                        }

                        final JFrame frameCompetiblePlayers = new JFrame();
                        frameCompetiblePlayers.setLayout(new BorderLayout());
                        JPanel pnlTop = new JPanel(new GridLayout());
                        JLabel topLbl = new JLabel("<html><b>Showing all players from " + lblLocation.getText() + " who are available from " + fromTime + " to " + toTime + "</b></html>");
                        pnlTop.setSize(500, 40);
                        pnlTop.add(topLbl);
                        JPanel pnlBottom = new JPanel(new GridLayout(0, 2, 10, 0));
                        JButton btnBack = new JButton("Back");
                        JButton btnBookmark = new JButton("Bookmark this search");
                        pnlBottom.add(btnBack);
                        pnlBottom.add(btnBookmark);
                        frameCompetiblePlayers.add(pnlTop, BorderLayout.NORTH);
                        frameCompetiblePlayers.add(pnlBottom, BorderLayout.SOUTH);
                        JList lstCompetiblePlayers = new JList();
                        DefaultListModel dlm1 = new DefaultListModel();
                        lstCompetiblePlayers.setModel(dlm1);
                        for (int i = 0; i < al.size(); i++) {
                            dlm1.addElement(al.get(i).get("playerName"));
                        }
                        JScrollPane jscpn1 = new JScrollPane(lstCompetiblePlayers);
                        frameCompetiblePlayers.add(jscpn1, BorderLayout.CENTER);
                        frameCompetiblePlayers.setSize(500, 650);
                        frameCompetiblePlayers.setDefaultCloseOperation(2);
                        frameCompetiblePlayers.setVisible(true);
                        frame.dispose();
                        frameCompetiblePlayers.repaint();
                        btnBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame.setVisible(true);
                                frameCompetiblePlayers.dispose();
                            }
                        });

                        btnBookmark.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String bookmarkTitle = JOptionPane.showInputDialog("Please enter bookmark title");
                                boolean isBlank = false;
                                String sql = "INSERT INTO bookmark(bookmarkTitle, bookmarkSql, playerId) VALUES(?,?,?);";
                                for (int i = 0; i < startTimeList.length; i++) {
                                    String bookmarkQueryString = "SELECT p.playerName "
                                            + "FROM Player p, PlayerPrefferedGame ppg, Game g\n"
                                            + "WHERE p.fromTime = '" + startTimeList[i] + "'\n"
                                            + " AND p.location = '" + lblLocation.getText() + "'\n"
                                            + " AND p.playerId = ppg.playerId\n"
                                            + " AND ppg.gameId = g.gameId\n"
                                            + " AND g.gameName = '" + gameName + "'"
                                            + ";";
//                                    System.out.println(bookmarkQueryString);
                                    if (bookmarkTitle == null || bookmarkTitle.isEmpty()) {
                                        isBlank = true;
                                    } else {
                                        manager.insertData(sql, bookmarkTitle, bookmarkQueryString, LoginPlayer.getCurrentPlayer());
                                        isBlank = false;
                                    }
                                }
                                if (isBlank == true) {
                                    JOptionPane.showMessageDialog(null, "Please insert a bookmark title.");
                                } else {
                                    JOptionPane.showMessageDialog(frameCompetiblePlayers, "<html>Bookmark has been saved.<br>To open a saved bookmark, go to \"Bookmarks\" tab.</html>");
                                    frame.setVisible(true);
                                    frameCompetiblePlayers.setVisible(false);
                                }
                            }
                        });
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

        tpPlayerProfile.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (tpPlayerProfile.getSelectedIndex() == 1) {
//                    PlayerHome.frame.dispose();
//                    PlayerHome.frame = new PlayerHome();
//                    PlayerHome.frame.setVisible(true);
//                    tpPlayerProfile.setSelectedIndex(1);
                    String sql = "SELECT b.bookmarkTitle\n"
                            + "FROM bookmark b\n"
                            + "WHERE b.playerId = ?\n"
                            + "GROUP BY b.bookmarkTitle;";
                    ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, LoginPlayer.getCurrentPlayer());
                    final JList list = new JList();
                    DefaultListModel dlm = new DefaultListModel();
                    list.setModel(dlm);
                    int size = al.size();
                    for (int x = 0; x < size; x++) {
                        dlm.addElement(al.get(x).get("bookmarkTitle"));
                    }
                    JScrollPane scpn = new JScrollPane(list);
                    pnlBookmarkList.setLayout(new BorderLayout());
                    pnlBookmarkList.add(scpn, BorderLayout.CENTER);
                    list.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                String sql = "SELECT b.bookmarkSql FROM bookmark b WHERE b.bookmarkTitle = ? AND b.playerId = ?;";
                                String bookmarkTitle = list.getSelectedValue().toString();
                                JFrame frame = new JFrame();
                                JList list = new JList();
                                DefaultListModel dlm = new DefaultListModel();
                                list.setModel(dlm);
                                if (bookmarkTitle.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "Please insert a bookmark title.");
                                } else {
                                    ArrayList<HashMap<String, String>> al = manager.getQueryData(sql, bookmarkTitle, LoginPlayer.getCurrentPlayer());
                                    for (int i = 0; i < al.size(); i++) {
                                        ArrayList<HashMap<String, String>> al2 = manager.getQueryData(al.get(i).get("bookmarkSql"));
                                        for (int j = 0; j < al2.size(); j++) {
                                            try {
                                                dlm.addElement(al2.get(i).get("playerName"));
                                            } catch (IndexOutOfBoundsException ex) {
                                                JOptionPane.showMessageDialog(PlayerHome.framePlayerHome, "Some data are missing.");
                                            }
                                        }
                                    }
                                }

                                JScrollPane jscp = new JScrollPane(list);
                                frame.setSize(500, 650);
                                frame.setLayout(new BorderLayout());
                                frame.add(jscp, BorderLayout.CENTER);
                                frame.setDefaultCloseOperation(2);
                                frame.setVisible(true);

                            } catch (NullPointerException npe) {
                                JOptionPane.showMessageDialog(PlayerHome.framePlayerHome, "Bookmark title is not inserted.");
                            }
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
                    pnlBookmarkList.repaint();
                } else if (tpPlayerProfile.getSelectedIndex() == 0) {
                    jPanel1.repaint();
                }
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpPlayerProfile = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblPrefferedCatagory = new javax.swing.JLabel();
        lblPrefferedGames = new javax.swing.JLabel();
        lblPrefferedDesigner = new javax.swing.JLabel();
        lblFromTime = new javax.swing.JLabel();
        lblOptimalNumbers = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnEditProfile = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblToTime = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlBookmarkList = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Email address");

        jLabel3.setText("Location");

        jLabel4.setText("Preffered Catagory");

        jLabel5.setText("Preffered games");

        jLabel6.setText("Preffered designer");

        jLabel7.setText("Available timeslot");

        jLabel8.setText("Optimal numbers");

        jLabel9.setText("Password");

        lblPrefferedCatagory.setForeground(new java.awt.Color(102, 102, 255));
        lblPrefferedCatagory.setText("Click to view list...");

        lblPrefferedGames.setForeground(new java.awt.Color(102, 102, 255));
        lblPrefferedGames.setText("Click to view list...");

        lblPrefferedDesigner.setForeground(new java.awt.Color(102, 102, 255));
        lblPrefferedDesigner.setText("Click to view list...");

        btnEditProfile.setText("Edit Profile");
        btnEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileActionPerformed(evt);
            }
        });

        jLabel10.setText("to");

        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditProfile)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrefferedCatagory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrefferedGames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPrefferedDesigner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblOptimalNumbers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblToTime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(lblLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(lblPrefferedCatagory, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(lblPrefferedGames, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(lblPrefferedDesigner, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(lblToTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(lblOptimalNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEditProfile)
                .addGap(63, 63, 63))
        );

        jScrollPane1.setViewportView(jPanel1);

        tpPlayerProfile.addTab("Player details", jScrollPane1);

        javax.swing.GroupLayout pnlBookmarkListLayout = new javax.swing.GroupLayout(pnlBookmarkList);
        pnlBookmarkList.setLayout(pnlBookmarkListLayout);
        pnlBookmarkListLayout.setHorizontalGroup(
            pnlBookmarkListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        pnlBookmarkListLayout.setVerticalGroup(
            pnlBookmarkListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        tpPlayerProfile.addTab("Bookmark lists", pnlBookmarkList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpPlayerProfile)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpPlayerProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginPlayer().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileActionPerformed
        // TODO add your handling code here:
        String playerName = lblName.getText();
        String playerEmail = lblEmail.getText();
        String playerLocation = lblLocation.getText();
        String fromTime = lblFromTime.getText();
        String toTime = lblToTime.getText();
        String optimalNumbers = lblOptimalNumbers.getText();
        String password = lblPassword.getText();

        EditPlayer ep = new EditPlayer(playerName, playerEmail, playerLocation, fromTime, toTime, optimalNumbers, password);
        ep.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEditProfileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditProfile;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFromTime;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOptimalNumbers;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPrefferedCatagory;
    private javax.swing.JLabel lblPrefferedDesigner;
    private javax.swing.JLabel lblPrefferedGames;
    private javax.swing.JLabel lblToTime;
    private javax.swing.JPanel pnlBookmarkList;
    private static javax.swing.JTabbedPane tpPlayerProfile;
    // End of variables declaration//GEN-END:variables
}
