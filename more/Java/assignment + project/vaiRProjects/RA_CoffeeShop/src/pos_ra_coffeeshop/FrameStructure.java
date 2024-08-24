/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_ra_coffeeshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import MiniShop.Database;

/**
 * 
 * @author Mainul35
 */
public class FrameStructure implements ActionListener {

	/**
	 * 
	 * 
	 * 
	 * All class variable declaration is defined here.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */

	public static FrameStructure fs;
	private JScrollPane scroller;
	private JLabel lblCompanyName = new JLabel("RA Coffee Shop");
	private JLabel lblDisplay = new JLabel(), lblSubTotal = new JLabel(
			"Sub Total"), lblVat = new JLabel("Vat (%)"),
			lblDueAmount = new JLabel("Due Amount"),
			lblTenderedAmount = new JLabel("Tendered amount"),
			lblChange = new JLabel("Change"), lblSellerName = new JLabel(
					"Currently serving : "), lblDisplayName = new JLabel();

	private JTable table;
	private String[][] data = new String[18][4];

	private String[] column = { "Item Name", "Quantity", "Unit Price(Taka)",
			"Total(Taka)" };

	protected String sellerName = "";
	private JButton btnNumberZero = new JButton("0"),
			btnNumberOne = new JButton("1"), btnNumberTwo = new JButton("2"),
			btnNumberThree = new JButton("3"),
			btnNumberFour = new JButton("4"), btnNumberFive = new JButton("5"),
			btnNumberSix = new JButton("6"), btnNumberSeven = new JButton("7"),
			btnNumberEight = new JButton("8"),
			btnNumberNine = new JButton("9"),
			btnNumberPoint = new JButton("."),
			btnBackSpace = new JButton("<-"), btnTakaFive = new JButton(
					"5 taka"), btnTakaTen = new JButton("10 taka"),
			btnTakaTwenty = new JButton("20 taka"), btnTakaFifty = new JButton(
					"50 taka"), btnTakaHundred = new JButton("100 taka"),
			btnTakaFiveHundred = new JButton("500 taka"),
			btnCash = new JButton("Cash"), btnCard = new JButton("Card"),
			btnTender = new JButton("Tender"), btnClear = new JButton("C");

	private JButton btnTea = new JButton("Tea"), btnGreenTea = new JButton(
			"Green Tea"), btnHerbalTea = new JButton("Herbal Tea"),
			btnEspresso = new JButton("Espresso"), btnCappuccino = new JButton(
					"Cappuccino"), btnLatte = new JButton("Latte"),
			btnAmericano = new JButton("Americano"),
			btnMochachino = new JButton("Mochachino"), btnCookie = new JButton(
					"Cookie"), btnCokaCola = new JButton("Coka Cola"),
			btnPepsi = new JButton("Pepsi"),
			btnMirinda = new JButton("Mirinda"),
			btnApple = new JButton("Apple"), btnOrange = new JButton("Orange"),
			btnBanana = new JButton("Banana"), btnCroissant = new JButton(
					"Croissant"), btnPastry = new JButton("Pastry"),
			btnCake = new JButton("Cake"), btnPrint = new JButton("Print"),
			btnDelete = new JButton("Delete Item"), btnNoSell = new JButton(
					"No Sell"), btnLogut = new JButton("Log Out");

	JPanel subPanel = new JPanel(), pnlBillingPannel = new JPanel(),
			pnlCalculator = new JPanel(),
			pnlOrderButtonContainer = new JPanel(),
			pnlOtherButtons = new JPanel();

	JTextField txtSubTotal = new JTextField(), txtVat = new JTextField(),
			txtDueAmount = new JTextField(),
			txtTenderedAmount = new JTextField(), txtChange = new JTextField();

	static DigitalClock clock = new DigitalClock();

	JFrame frame = new JFrame("RA Coffee Shop (POS)");

	private int evtTeaClicked = 0, evtHerbalTeaClicked = 0,
			evtGreenTeaClicked = 0, evtCappuccinoClicked = 0,
			evtAmericanoClicked = 0, evtLatteClicked = 0, evtEspressoClicked,
			evtMochachinoClicked = 0, evtCookieClicked = 0,
			evtCokaColaClicked = 0, evtPepsiClicked = 0, evtMirindaClicked = 0,
			evtAppleClicked = 0, evtOrangeClicked = 0, evtBananaClicked = 0,
			evtCroissantClicked = 0, evtPastryClicked = 0, evtCakeClicked = 0,
			row;
	private String strNumber;
	private double subTotal = 0, total = 0;
	private double GreenTeaWithVat = 0;
	private double HerbalTeaWithVat = 0;
	private double TeaWithVat = 0;
	private double subTotalTea;
	private double subTotalHerbalTea;
	private double subTotalGreenTea;
	private double EspressoWithVat, subTotalEspresso;
	private double CappuccinoWithVat = 0, subTotalCappuccino = 0;
	private double LatteWithVat = 0, subTotalLatte = 0;
	private double MochachinoWithVat = 0, subTotalMochachino;
	private double CookieWithVat = 0, subTotalCookie;
	private double CokaColaWithVat, subTotalCokaCola;
	private double PepsiWithVat, subTotalPepsi;
	private double MirindaWithVat, subTotalMirinda;
	private double AppleWithVat, subTotalApple;
	private double OrangeWithVat, subTotalOrange;
	private double BananaWithVat, subTotalBanana;
	private double CroissantWithVat, subTotalCroissant;
	private double PastryWithVat, subTotalPastry;
	private double CakeWithVat, subTotalCake;
	private double subTotalAmericano, AmericanoWithVat;
	private String dueAmount = "";

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * The POS Frame Structure declaration Starts from here.
	 * 
	 * We have total 5 panels.
	 * 
	 * 1. The main panel that contains all the other sub panels is named as
	 * "subPanel"
	 * 
	 * 2. "pnlBillingPannel" holds all the billing text fields.
	 * 
	 * 3. "pnlCalculator" holds the calculator stuffs.
	 * 
	 * 4. "pnlOrderButtonContainer" holds the ordering system buttons.
	 * 
	 * 5. "pnlOtherButtons" holds delete, no sell and printing buttons
	 * 
	 * 
	 * 
	 * */

	public JFrame frameStructure() {

		/***
		 * 
		 * DEfination of all the ordering button starts here.
		 * 
		 * 
		 * */
		btnTea.setOpaque(true);
		btnTea.setBounds(10, 10, 120, 30);
		btnTea.addActionListener(this);

		btnGreenTea.setOpaque(true);
		btnGreenTea.setBounds(140, 10, 120, 30);
		btnGreenTea.addActionListener((ActionListener) this);

		btnHerbalTea.setOpaque(true);
		btnHerbalTea.setBounds(270, 10, 120, 30);
		btnHerbalTea.addActionListener((ActionListener) this);

		btnEspresso.setOpaque(true);
		btnEspresso.setBounds(10, 90 - 40, 120, 30);
		btnEspresso.addActionListener((ActionListener) this);

		btnCappuccino.setOpaque(true);
		btnCappuccino.setBounds(140, 90 - 40, 120, 30);
		btnCappuccino.addActionListener((ActionListener) this);

		btnLatte.setOpaque(true);
		btnLatte.setBounds(270, 90 - 40, 120, 30);
		btnLatte.addActionListener((ActionListener) this);

		btnAmericano.setOpaque(true);
		btnAmericano.setBounds(10, 130 - 40, 120, 30);
		btnAmericano.addActionListener((ActionListener) this);

		btnMochachino.setOpaque(true);
		btnMochachino.setBounds(140, 130 - 40, 120, 30);
		btnMochachino.addActionListener((ActionListener) this);

		btnCookie.setOpaque(true);
		btnCookie.setBounds(270, 130 - 40, 120, 30);
		btnCookie.addActionListener((ActionListener) this);

		btnCokaCola.setOpaque(true);
		btnCokaCola.setBounds(10, 170 - 40, 120, 30);
		btnCokaCola.addActionListener((ActionListener) this);

		btnPepsi.setOpaque(true);
		btnPepsi.setBounds(140, 170 - 40, 120, 30);
		btnPepsi.addActionListener((ActionListener) this);

		btnMirinda.setOpaque(true);
		btnMirinda.setBounds(270, 170 - 40, 120, 30);
		btnMirinda.addActionListener((ActionListener) this);

		btnApple.setOpaque(true);
		btnApple.setBounds(10, 210 - 40, 120, 30);
		btnApple.addActionListener((ActionListener) this);

		btnOrange.setOpaque(true);
		btnOrange.setBounds(140, 210 - 40, 120, 30);
		btnOrange.addActionListener((ActionListener) this);

		btnBanana.setOpaque(true);
		btnBanana.setBounds(270, 210 - 40, 120, 30);
		btnBanana.addActionListener((ActionListener) this);

		btnCroissant.setOpaque(true);
		btnCroissant.setBounds(10, 250 - 40, 120, 30);
		btnCroissant.addActionListener((ActionListener) this);

		btnPastry.setOpaque(true);
		btnPastry.setBounds(140, 250 - 40, 120, 30);
		btnPastry.addActionListener((ActionListener) this);

		btnCake.setOpaque(true);
		btnCake.setBounds(270, 250 - 40, 120, 30);
		btnCake.addActionListener((ActionListener) this);

		/***
		 * 
		 * the defination of all items on the pnlOtherButtons is described here.
		 * 
		 * 
		 * */
		btnPrint.setOpaque(true);
		btnPrint.setBounds(340, 10, 150, 50);
		btnPrint.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == btnPrint) {
					try {
						txtDueAmount.print();
					} catch (PrinterException e) {

					}
				}
			}
		});

		btnDelete.setOpaque(true);
		btnDelete.setBounds(20, 10, 150, 50);

		btnNoSell.setOpaque(true);
		btnNoSell.setBounds(180, 10, 150, 50);
		btnNoSell.addActionListener(this);

		/***
		 * 
		 * 
		 * Defination of JTable component
		 * 
		 * */

		table = new JTable(data, column);
		scroller = new JScrollPane(table);
		scroller.setBounds(60, 100, 520, 200);

		/**
		 * 
		 * Defination of Company name Displaying Label
		 * 
		 * 
		 * */
		lblCompanyName.setBounds(400, 10, 300, 50);
		lblCompanyName.setFont(new Font("Times new roman", Font.ITALIC
				+ Font.BOLD, 24));
		lblCompanyName.setForeground(new Color(25, 170, 215, 245));

		/***
		 * 
		 * the Two labels bellow is responsible for displaying Seller's name.
		 * 
		 * */
		lblSellerName.setBounds(60, 60, 200, 30);
		lblSellerName.setFont(new Font("Times new roman", Font.BOLD, 14));
		lblDisplayName.setText(Database.name);
		lblDisplayName.setBounds(270, 60, 150, 30);
		lblDisplayName.setFont(new Font("Times new roman", Font.BOLD, 14));

		/***
		 * 
		 * 
		 * The code bellow describes all the components of calculator
		 * 
		 * 
		 * */
		btnNumberOne.setBounds(10, 10 + 50, 50, 40);
		btnNumberOne.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberOne.addActionListener(this);
		btnNumberTwo.setBounds(70, 10 + 50, 50, 40);
		btnNumberTwo.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberTwo.addActionListener(this);
		btnNumberThree.setBounds(130, 10 + 50, 50, 40);
		btnNumberThree.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberThree.addActionListener(this);
		btnBackSpace.setBounds(190, 10 + 50, 50, 40);
		btnBackSpace.setFont(new Font("Times new roman", Font.BOLD, 12));
		btnBackSpace.addActionListener(this);
		btnNumberFour.setBounds(10, 60 + 50, 50, 40);
		btnNumberFour.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberFour.addActionListener(this);
		btnNumberFive.setBounds(70, 60 + 50, 50, 40);
		btnNumberFive.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberFive.addActionListener(this);
		btnNumberSix.setBounds(130, 60 + 50, 50, 40);
		btnNumberSix.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberSix.addActionListener(this);
		btnNumberZero.setBounds(190, 60 + 50, 50, 40);
		btnNumberZero.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberZero.addActionListener(this);
		btnNumberSeven.setBounds(10, 110 + 50, 50, 40);
		btnNumberSeven.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberSeven.addActionListener(this);
		btnNumberEight.setBounds(70, 110 + 50, 50, 40);
		btnNumberEight.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberEight.addActionListener(this);
		btnNumberNine.setBounds(130, 110 + 50, 50, 40);
		btnNumberNine.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberNine.addActionListener(this);
		btnNumberPoint.setBounds(190, 110 + 50, 50, 40);
		btnNumberPoint.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnNumberPoint.addActionListener(this);
		btnClear.setBounds(10, 210, 230, 40);
		btnClear.setFont(new Font("Times new roman", Font.BOLD, 18));
		btnClear.addActionListener(this);
		btnCash.setBounds(10, 260, 110, 40);
		btnCash.setFont(new Font("Times new roman", Font.BOLD + Font.ITALIC, 18));
		btnCash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub

			}
		});
		btnCard.setBounds(130, 260, 110, 40);
		btnCard.setFont(new Font("Times new roman", Font.BOLD + Font.ITALIC, 18));
		btnCard.addActionListener(this);
		btnTender.setBounds(10, 310, 230, 40);
		btnTender.setFont(new Font("Times new roman", Font.BOLD + Font.ITALIC,
				18));
		btnTender.addActionListener(this);

		strNumber = "";

		lblDisplay.setBounds(10, 10, 230, 40);
		lblDisplay.setText(strNumber);
		lblDisplay.setOpaque(true);
		lblDisplay.setBackground(Color.WHITE);
		lblDisplay.setFont(new Font("Times new roman", Font.ITALIC, 18));

		/**
		 * 
		 * 
		 * The Code bellow describes the design of Billing panel
		 * 
		 * 
		 * */

		lblSubTotal.setBounds(110, 10, 150, 30);
		lblSubTotal.setFont(new Font("Times new roman", Font.ITALIC, 14));
		lblVat.setBounds(110, 50, 150, 30);
		lblVat.setFont(new Font("Times new roman", Font.ITALIC, 14));
		lblDueAmount.setBounds(110, 90, 150, 30);
		lblDueAmount.setFont(new Font("Times new roman", Font.ITALIC, 14));
		lblTenderedAmount.setBounds(110, 130, 150, 30);
		lblTenderedAmount.setFont(new Font("Times new roman", Font.ITALIC, 14));
		lblChange.setBounds(110, 170, 150, 30);
		lblChange.setFont(new Font("Times new roman", Font.ITALIC, 14));

		txtSubTotal.setBounds(270, 10, 100, 30);
		txtSubTotal.setFont(new Font("Times new roman", Font.BOLD, 12));
		txtVat.setBounds(270, 50, 100, 30);
		txtVat.setText("17.5");
		txtVat.setFont(new Font("Times new roman", Font.BOLD, 12));
		txtDueAmount.setBounds(270, 90, 100, 30);
		txtDueAmount.setFont(new Font("Times new roman", Font.BOLD, 12));
		txtTenderedAmount.setBounds(270, 130, 100, 30);
		txtTenderedAmount.setFont(new Font("Times new roman", Font.BOLD, 12));
		txtChange.setBounds(270, 170, 100, 30);
		txtChange.setFont(new Font("Times new roman", Font.BOLD, 12));

		/***
		 * 
		 * 
		 * Description of all the panel is given here.
		 * 
		 * 1. Billing Panel
		 * 
		 * 
		 * 
		 * */

		pnlBillingPannel.setLayout(null);
		pnlBillingPannel.setBounds(60, 320, 520, 230);
		pnlBillingPannel.setBackground(new Color(179, 185, 195));
		pnlBillingPannel.add(txtChange);
		pnlBillingPannel.add(lblChange);
		pnlBillingPannel.add(txtDueAmount);
		pnlBillingPannel.add(lblDueAmount);
		pnlBillingPannel.add(txtSubTotal);
		pnlBillingPannel.add(lblSubTotal);
		pnlBillingPannel.add(txtTenderedAmount);
		pnlBillingPannel.add(lblTenderedAmount);
		pnlBillingPannel.add(txtVat);
		pnlBillingPannel.add(lblVat);

		/***
		 * 
		 * 
		 * 2. Panel for print, delete, no sell buttons
		 * 
		 * 
		 * */

		pnlOtherButtons.setBounds(60, 550, 550, 70);
		pnlOtherButtons.setLayout(null);
		pnlOtherButtons.add(btnDelete);
		pnlOtherButtons.add(btnNoSell);
		pnlOtherButtons.add(btnPrint);

		/**
		 * 
		 * 3. Panel for ordering system components
		 * 
		 * */
		pnlOrderButtonContainer.setBounds(650, 100, 400, 250);
		pnlOrderButtonContainer.setBackground(new Color(192, 213, 245));
		pnlOrderButtonContainer.setLayout(null);
		pnlOrderButtonContainer.add(btnTea);
		pnlOrderButtonContainer.add(btnGreenTea);
		pnlOrderButtonContainer.add(btnHerbalTea);
		pnlOrderButtonContainer.add(btnEspresso);
		pnlOrderButtonContainer.add(btnCappuccino);
		pnlOrderButtonContainer.add(btnLatte);
		pnlOrderButtonContainer.add(btnAmericano);
		pnlOrderButtonContainer.add(btnMochachino);
		pnlOrderButtonContainer.add(btnCookie);
		pnlOrderButtonContainer.add(btnCokaCola);
		pnlOrderButtonContainer.add(btnPepsi);
		pnlOrderButtonContainer.add(btnMirinda);
		pnlOrderButtonContainer.add(btnApple);
		pnlOrderButtonContainer.add(btnOrange);
		pnlOrderButtonContainer.add(btnBanana);
		pnlOrderButtonContainer.add(btnCroissant);
		pnlOrderButtonContainer.add(btnPastry);
		pnlOrderButtonContainer.add(btnCake);

		/***
		 * 
		 * 
		 * 4. Calculator panel components
		 * 
		 * 
		 * */

		pnlCalculator = new JPanel();
		pnlCalculator.setBounds(800, 360, 250, 360);
		pnlCalculator.setBackground(new Color(70, 80, 90));
		pnlCalculator.setLayout(null);
		pnlCalculator.add(btnNumberOne);
		pnlCalculator.add(btnNumberTwo);
		pnlCalculator.add(btnNumberThree);
		pnlCalculator.add(btnNumberFour);
		pnlCalculator.add(btnNumberFive);
		pnlCalculator.add(btnNumberSix);
		pnlCalculator.add(btnNumberSeven);
		pnlCalculator.add(btnNumberEight);
		pnlCalculator.add(btnNumberNine);
		pnlCalculator.add(btnNumberZero);
		pnlCalculator.add(btnNumberPoint);
		pnlCalculator.add(btnBackSpace);
		pnlCalculator.add(btnCash);
		pnlCalculator.add(btnCard);
		pnlCalculator.add(btnTender);
		pnlCalculator.add(lblDisplay);
		pnlCalculator.add(btnClear);

		/***
		 * 
		 * The clock and log out button have been set on the subPanel (main
		 * panel containing all the other panels).
		 * 
		 * */

		clock.pane.setBounds(450, 60, 250, 30);
		clock.pane.setFont(new Font("Times new roman", Font.BOLD, 16));

		btnLogut.setBounds(720, 60, 250, 30);
		btnLogut.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == btnLogut) {
					frameStructure().dispose();
					MiniShop.Application.mf.setVisible(true);
				}
			}
		});

		/***
		 * 
		 * 
		 * 
		 * 5. subPanel is now described here
		 * 
		 * 
		 * 
		 * */

		subPanel.setBounds(10, 50, 900, 1200);
		subPanel.setLayout(null);
		subPanel.add(lblCompanyName);
		subPanel.add(lblSellerName);
		subPanel.add(btnLogut);
		subPanel.add(lblDisplayName);
		subPanel.add(clock.pane);
		subPanel.add(pnlOrderButtonContainer);
		subPanel.add(pnlOtherButtons);
		subPanel.add(scroller);
		subPanel.add(pnlCalculator);
		subPanel.add(pnlBillingPannel);

		/***
		 * 
		 * 
		 * Here the POS Frame structure is defined.
		 * 
		 * */
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		frame.setSize(width, height);
		frame.setLayout(new GridLayout(0, 1));
		frame.add(subPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		return frame;
	}

	/***
	 * 
	 * 
	 * Functionality for all the ordering buttons
	 * 
	 * 
	 * */

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnTea) {
			evtTeaClicked++;
			subTotalTea = evtTeaClicked * 50;
			TeaWithVat = subTotalTea;

			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Tea";
				data[0][1] = Integer.toString(evtTeaClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(TeaWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Tea".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtTeaClicked);
						data[x][3] = Double.toString(TeaWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Tea")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Tea";
									data[p][1] = Integer
											.toString(evtTeaClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(TeaWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Tea";
							data[x + 1][1] = Integer.toString(evtTeaClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(TeaWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Tea".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Tea";
						data[x][1] = Integer.toString(evtTeaClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(TeaWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal.setText((Double.toString(Double
					.parseDouble(new DecimalFormat("#####.###")
							.format(subTotal)))));
		} else if (e.getSource() == btnHerbalTea) {
			evtHerbalTeaClicked++;
			subTotalHerbalTea = evtHerbalTeaClicked * 50;
			HerbalTeaWithVat = subTotalHerbalTea;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Herbal Tea";
				data[0][1] = Integer.toString(evtHerbalTeaClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(HerbalTeaWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Herbal Tea".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtHerbalTeaClicked);
						data[x][3] = Double.toString(HerbalTeaWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0]
											.equalsIgnoreCase("Herbal Tea")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Herbal Tea";
									data[p][1] = Integer
											.toString(evtHerbalTeaClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(HerbalTeaWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Herbal Tea";
							data[x + 1][1] = Integer
									.toString(evtHerbalTeaClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(HerbalTeaWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Herbal Tea".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Herbal Tea";
						data[x][1] = Integer.toString(evtHerbalTeaClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(HerbalTeaWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnGreenTea) {
			evtGreenTeaClicked++;
			subTotalGreenTea = evtGreenTeaClicked * 50;
			GreenTeaWithVat = subTotalGreenTea;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Green Tea";
				data[0][1] = Integer.toString(evtGreenTeaClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(GreenTeaWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Green Tea".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtGreenTeaClicked);
						data[x][3] = Double.toString(GreenTeaWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Green Tea")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Green Tea";
									data[p][1] = Integer
											.toString(evtGreenTeaClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(GreenTeaWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Green Tea";
							data[x + 1][1] = Integer
									.toString(evtGreenTeaClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(GreenTeaWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Green Tea".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Green Tea";
						data[x][1] = Integer.toString(evtGreenTeaClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(GreenTeaWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnCappuccino) {
			evtCappuccinoClicked++;
			subTotalCappuccino = evtCappuccinoClicked * 50;
			CappuccinoWithVat = subTotalCappuccino;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Cappuccino";
				data[0][1] = Integer.toString(evtCappuccinoClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(CappuccinoWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Cappuccino".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtCappuccinoClicked);
						data[x][3] = Double.toString(CappuccinoWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0]
											.equalsIgnoreCase("Cappuccino")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Cappuccino";
									data[p][1] = Integer
											.toString(evtCappuccinoClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(CappuccinoWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Cappuccino";
							data[x + 1][1] = Integer
									.toString(evtCappuccinoClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(CappuccinoWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Cappuccino".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Cappuccino";
						data[x][1] = Integer.toString(evtCappuccinoClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(CappuccinoWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnLatte) {
			evtLatteClicked++;
			subTotalLatte = evtLatteClicked * 50;
			LatteWithVat = subTotalLatte;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Latte";
				data[0][1] = Integer.toString(evtLatteClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(LatteWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Latte".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtLatteClicked);
						data[x][3] = Double.toString(LatteWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Latte")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Latte";
									data[p][1] = Integer
											.toString(evtLatteClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(LatteWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Latte";
							data[x + 1][1] = Integer.toString(evtLatteClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(LatteWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Latte".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Latte";
						data[x][1] = Integer.toString(evtLatteClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(LatteWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnEspresso) {
			evtEspressoClicked++;
			subTotalEspresso = evtEspressoClicked * 50;
			EspressoWithVat = subTotalEspresso;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Espresso";
				data[0][1] = Integer.toString(evtEspressoClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(EspressoWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Espresso".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtEspressoClicked);
						data[x][3] = Double.toString(EspressoWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Espresso")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Espresso";
									data[p][1] = Integer
											.toString(evtEspressoClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(EspressoWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Espresso";
							data[x + 1][1] = Integer
									.toString(evtEspressoClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(EspressoWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Espresso".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Espresso";
						data[x][1] = Integer.toString(evtEspressoClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(EspressoWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnMochachino) {
			boolean got = false;
			evtMochachinoClicked++;
			subTotalMochachino = evtMochachinoClicked * 50;
			MochachinoWithVat = subTotalMochachino;
			if (data[0][0] == null) {
				data[0][0] = "Mochachino";
				data[0][1] = Integer.toString(evtMochachinoClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(MochachinoWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Mochachino".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtMochachinoClicked);
						data[x][3] = Double.toString(MochachinoWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0]
											.equalsIgnoreCase("Mochachino")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Mochachino";
									data[p][1] = Integer
											.toString(evtMochachinoClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(MochachinoWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Mochachino";
							data[x + 1][1] = Integer
									.toString(evtMochachinoClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(MochachinoWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Mochachino".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Mochachino";
						data[x][1] = Integer.toString(evtMochachinoClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(MochachinoWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnCookie) {
			boolean got = false;
			evtCookieClicked++;
			subTotalCookie = evtCookieClicked * 50;
			CookieWithVat = subTotalCookie;
			if (data[0][0] == null) {
				data[0][0] = "Cookie";
				data[0][1] = Integer.toString(evtCookieClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(CookieWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Cookie".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtCookieClicked);
						data[x][3] = Double.toString(CookieWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Cookie")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Cookie";
									data[p][1] = Integer
											.toString(evtCookieClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(CookieWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Cookie";
							data[x + 1][1] = Integer.toString(evtCookieClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(CookieWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Cookie".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Cookie";
						data[x][1] = Integer.toString(evtCookieClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(CookieWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnCokaCola) {
			boolean got = false;
			evtCokaColaClicked++;
			subTotalCokaCola = evtCokaColaClicked * 50;
			CokaColaWithVat = subTotalCokaCola;
			if (data[0][0] == null) {
				data[0][0] = "CokaCola";
				data[0][1] = Integer.toString(evtCokaColaClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(CokaColaWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("CokaCola".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtCokaColaClicked);
						data[x][3] = Double.toString(CokaColaWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("CokaCola")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "CokaCola";
									data[p][1] = Integer
											.toString(evtCokaColaClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(CokaColaWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "CokaCola";
							data[x + 1][1] = Integer
									.toString(evtCokaColaClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(CokaColaWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("CokaCola".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "CokaCola";
						data[x][1] = Integer.toString(evtCokaColaClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(CokaColaWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnPepsi) {
			evtPepsiClicked++;
			subTotalPepsi = evtPepsiClicked * 50;
			PepsiWithVat = subTotalPepsi;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Pepsi";
				data[0][1] = Integer.toString(evtPepsiClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(PepsiWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Pepsi".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtPepsiClicked);
						data[x][3] = Double.toString(PepsiWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Pepsi")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Pepsi";
									data[p][1] = Integer
											.toString(evtPepsiClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(PepsiWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Pepsi";
							data[x + 1][1] = Integer.toString(evtPepsiClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(PepsiWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Pepsi".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Pepsi";
						data[x][1] = Integer.toString(evtPepsiClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(PepsiWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnMirinda) {
			evtMirindaClicked++;
			subTotalMirinda = evtMirindaClicked * 50;
			MirindaWithVat = subTotalMirinda;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Mirinda";
				data[0][1] = Integer.toString(evtMirindaClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(MirindaWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Mirinda".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtMirindaClicked);
						data[x][3] = Double.toString(MirindaWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Mirinda")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Mirinda";
									data[p][1] = Integer
											.toString(evtMirindaClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(MirindaWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Mirinda";
							data[x + 1][1] = Integer
									.toString(evtMirindaClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(MirindaWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Mirinda".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Mirinda";
						data[x][1] = Integer.toString(evtMirindaClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(MirindaWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnAmericano) {
			boolean got = false;
			evtAmericanoClicked++;
			subTotalAmericano = evtAmericanoClicked * 50;
			AmericanoWithVat = subTotalAmericano;
			if (data[0][0] == null) {
				data[0][0] = "Americano";
				data[0][1] = Integer.toString(evtAmericanoClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(AmericanoWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Americano".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtAmericanoClicked);
						data[x][3] = Double.toString(AmericanoWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Americano")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Americano";
									data[p][1] = Integer
											.toString(evtAmericanoClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(AmericanoWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Americano";
							data[x + 1][1] = Integer
									.toString(evtAmericanoClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(AmericanoWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Americano".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Americano";
						data[x][1] = Integer.toString(evtAmericanoClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(AmericanoWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnApple) {
			evtAppleClicked++;
			subTotalApple = evtAppleClicked * 50;
			AppleWithVat = subTotalApple;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Apple";
				data[0][1] = Integer.toString(evtAppleClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(AppleWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Apple".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtAppleClicked);
						data[x][3] = Double.toString(AppleWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Apple")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Apple";
									data[p][1] = Integer
											.toString(evtAppleClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(AppleWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Apple";
							data[x + 1][1] = Integer.toString(evtAppleClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(AppleWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Apple".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Apple";
						data[x][1] = Integer.toString(evtAppleClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(AppleWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnOrange) {
			boolean got = false;
			evtOrangeClicked++;
			subTotalOrange = evtOrangeClicked * 50;
			OrangeWithVat = subTotalOrange;
			if (data[0][0] == null) {
				data[0][0] = "Orange";
				data[0][1] = Integer.toString(evtOrangeClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(OrangeWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Orange".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtOrangeClicked);
						data[x][3] = Double.toString(OrangeWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Orange")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Orange";
									data[p][1] = Integer
											.toString(evtOrangeClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(OrangeWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Orange";
							data[x + 1][1] = Integer.toString(evtOrangeClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(OrangeWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Orange".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Orange";
						data[x][1] = Integer.toString(evtOrangeClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(OrangeWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnBanana) {
			boolean got = false;
			evtBananaClicked++;
			subTotalBanana = evtBananaClicked * 50;
			BananaWithVat = subTotalBanana;
			if (data[0][0] == null) {
				data[0][0] = "Banana";
				data[0][1] = Integer.toString(evtBananaClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(BananaWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Banana".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtBananaClicked);
						data[x][3] = Double.toString(BananaWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Banana")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Banana";
									data[p][1] = Integer
											.toString(evtBananaClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(BananaWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Banana";
							data[x + 1][1] = Integer.toString(evtBananaClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(BananaWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Banana".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Banana";
						data[x][1] = Integer.toString(evtBananaClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(BananaWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnCroissant) {
			boolean got = false;
			evtCroissantClicked++;
			subTotalCroissant = evtCroissantClicked * 50;
			CroissantWithVat = subTotalCroissant;
			if (data[0][0] == null) {
				data[0][0] = "Croissant";
				data[0][1] = Integer.toString(evtCroissantClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(CroissantWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Croissant".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtCroissantClicked);
						data[x][3] = Double.toString(CroissantWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Croissant")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Croissant";
									data[p][1] = Integer
											.toString(evtCroissantClicked);
									data[p][2] = "50";
									data[p][3] = Double
											.toString(CroissantWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Croissant";
							data[x + 1][1] = Integer
									.toString(evtCroissantClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(CroissantWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Croissant".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Croissant";
						data[x][1] = Integer.toString(evtCroissantClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(CroissantWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnPastry) {
			boolean got = false;
			evtPastryClicked++;
			subTotalPastry = evtPastryClicked * 50;
			PastryWithVat = subTotalPastry;
			if (data[0][0] == null) {
				data[0][0] = "Pastry";
				data[0][1] = Integer.toString(evtPastryClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(PastryWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Pastry".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtPastryClicked);
						data[x][3] = Double.toString(PastryWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Pastry")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Pastry";
									data[p][1] = Integer
											.toString(evtPastryClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(PastryWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Pastry";
							data[x + 1][1] = Integer.toString(evtPastryClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(PastryWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Pastry".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Pastry";
						data[x][1] = Integer.toString(evtPastryClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(PastryWithVat);
						break;
					}
				}
			}
			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
		} else if (e.getSource() == btnCake) {
			evtCakeClicked++;
			subTotalCake = evtCakeClicked * 50;
			CakeWithVat = subTotalCake;
			boolean got = false;
			if (data[0][0] == null) {
				data[0][0] = "Cake";
				data[0][1] = Integer.toString(evtCakeClicked);
				data[0][2] = "50";
				data[0][3] = Double.toString(CakeWithVat);
				got = true;
			} else {
				int x = 0;
				for (x = 0; x < data.length; x++) {
					if ("Cake".equalsIgnoreCase(data[x][0])) {
						data[x][1] = Integer.toString(evtCakeClicked);
						data[x][3] = Double.toString(CakeWithVat);
						got = true;
						break;
					} else if (data[x + 1][0] == null) {
						boolean Null = true;
						int store = 0;
						for (int p = x + 1; p < data.length; p++) {
							if (data[p][0] != null
									&& data[p][0].equalsIgnoreCase("Cake")) {
								Null = false;
								store = p;
								break;
							} else if (data[p][0] == null) {
								Null = true;
							}
						}
						if (Null == false) {
							data[store][0] = null;
							data[store][1] = null;
							data[store][2] = null;
							data[store][3] = null;
							for (int p = 0; p < data.length; p++) {
								if (data[p][0] == null) {
									data[p][0] = "Cake";
									data[p][1] = Integer
											.toString(evtCakeClicked);
									data[p][2] = "50";
									data[p][3] = Double.toString(CakeWithVat);
									got = true;
									break;
								}
							}
						} else if (Null == true) {
							data[x + 1][0] = "Cake";
							data[x + 1][1] = Integer.toString(evtCakeClicked);
							data[x + 1][2] = "50";
							data[x + 1][3] = Double.toString(CakeWithVat);
							got = true;
							break;
						}

					} else if ("".equals(data[x][0])) {
						for (int p = 0; p < data.length; p++) {
							if ("Cake".equalsIgnoreCase(data[p][0])) {
								data[p][0] = null;
								data[p][1] = null;
								data[p][2] = null;
								data[p][3] = null;
								break;
							}
						}
						data[x][0] = "Cake";
						data[x][1] = Integer.toString(evtCakeClicked);
						data[x][2] = "50";
						data[x][3] = Double.toString(CakeWithVat);
						break;
					}
				}
			}

			subTotal += ((double) 50);
			txtSubTotal
					.setText((Double.toString(Double
							.parseDouble(new DecimalFormat("#####.##")
									.format(subTotal)))));
			/***
			 * 
			 * 
			 * 
			 * Functionality for no sell button
			 * 
			 * 
			 * */
		} else if (e.getSource() == btnNoSell) {
			row = table.getSelectedRow();
			try {
				double temp = 0;
				double singleData = Double.parseDouble(data[row][2]);
				if (data[row][0].equalsIgnoreCase("Tea")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtTeaClicked = Integer.parseInt(data[row][1]);

					data[row][3] = Double.toString(evtTeaClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Herbal Tea")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtHerbalTeaClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtHerbalTeaClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Green Tea")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtGreenTeaClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtGreenTeaClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Croissant")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtCroissantClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtCroissantClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Cake")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtCakeClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtCakeClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Cappuccino")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtCappuccinoClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtCappuccinoClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("CokaCola")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtCokaColaClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtCokaColaClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Cookie")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtCookieClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtCookieClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Americano")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtAmericanoClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtAmericanoClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Apple")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtAppleClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtAppleClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Banana")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtBananaClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtBananaClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Espresso")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtEspressoClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtEspressoClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Latte")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtLatteClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtLatteClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Mirinda")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtMirindaClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtMirindaClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Mochachino")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtMochachinoClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtMochachinoClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Orange")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtOrangeClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtOrangeClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Pastry")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtPastryClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtPastryClicked
							* Double.parseDouble(data[row][2]));
				} else if (data[row][0].equalsIgnoreCase("Pepsi")
						&& Integer.parseInt(data[row][1]) > 0) {
					data[row][1] = Integer.toString(Integer
							.parseInt(data[row][1]) - 1);
					evtPepsiClicked = Integer.parseInt(data[row][1]);
					data[row][3] = Double.toString(evtPepsiClicked
							* Double.parseDouble(data[row][2]));
				}
				subTotal = Double.parseDouble(txtSubTotal.getText());
				subTotal -= singleData;
				dueAmount = Double.toString(subTotal
						+ ((subTotal * 17.5) / 100));

				txtSubTotal.setText((Double.toString(Double
						.parseDouble(new DecimalFormat("#####.##")
								.format(subTotal)))));
				txtDueAmount.setText(Double.toString(Double
						.parseDouble(new DecimalFormat("#####.##")
								.format(Double.parseDouble(dueAmount)))));

			} catch (NumberFormatException nfe) {
			}
			table.repaint();
		}
		try {
			txtDueAmount
					.setText(Double.toString(Double.parseDouble(txtSubTotal
							.getText())
							+ ((Double.parseDouble(txtSubTotal.getText()) * 17) / 100)));
			table.repaint();
		} catch (NumberFormatException nfe) {
		}
		/***
		 * 
		 * 
		 * Functionality for delete button.
		 * 
		 * 
		 * 
		 * */
		try {
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent me) {

					row = table.rowAtPoint(me.getPoint());

					btnDelete.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent ae) {
							if (btnDelete == ae.getSource()) {
								try {
									double singleData = Double
											.parseDouble(data[row][3]);
									subTotal = subTotal - singleData;
									dueAmount = Double.toString(Double
											.parseDouble(txtDueAmount.getText())
											- (singleData + (singleData * 17) / 100));

									if (data[row][0].equalsIgnoreCase("Tea")) {
										evtTeaClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Herbal Tea")) {
										evtHerbalTeaClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Green Tea")) {
										evtGreenTeaClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Croissant")) {
										evtCroissantClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Cake")) {
										evtCakeClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Cappuccino")) {
										evtCappuccinoClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("CokaCola")) {
										evtCokaColaClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Cookie")) {
										evtCookieClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Americano")) {
										evtAmericanoClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Apple")) {
										evtAppleClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Banana")) {
										evtBananaClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Espresso")) {
										evtEspressoClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Latte")) {
										evtLatteClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Mirinda")) {
										evtMirindaClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Mochachino")) {
										evtMochachinoClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Orange")) {
										evtOrangeClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Pastry")) {
										evtPastryClicked = 0;
									} else if (data[row][0]
											.equalsIgnoreCase("Pepsi")) {
										evtPepsiClicked = 0;
									}
									data[row][0] = "";
									data[row][1] = "";
									data[row][2] = "";
									data[row][3] = "";
									txtSubTotal.setText((Double.toString(Double
											.parseDouble(new DecimalFormat(
													"#####.##")
													.format(subTotal)))));
									txtDueAmount.setText(Double.toString(Double
											.parseDouble(new DecimalFormat(
													"#####.##").format(Double
													.parseDouble(dueAmount)))));

								} catch (NumberFormatException nfe) {
								}
								table.repaint();
							}
						}
					});
				}

				@Override
				public void mousePressed(MouseEvent me) {
				}

				@Override
				public void mouseReleased(MouseEvent me) {
				}

				@Override
				public void mouseEntered(MouseEvent me) {
				}

				@Override
				public void mouseExited(MouseEvent me) {
				}

			});
			/***
			 * 
			 * 
			 * 
			 * The calculator functionality is written here.
			 * 
			 * 
			 * */
			if (e.getSource() == btnNumberOne) {
				strNumber += "1";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberTwo) {
				strNumber += "2";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberThree) {
				strNumber += "3";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberFour) {
				strNumber += "4";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberFive) {
				strNumber += "5";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberSix) {
				strNumber += "6";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberSeven) {
				strNumber += "7";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberEight) {
				strNumber += "8";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberNine) {
				strNumber += "9";
				lblDisplay.setText(strNumber);
			} else if (e.getSource() == btnNumberZero) {
				if (strNumber.length() != 0) {
					strNumber += "0";
					lblDisplay.setText(strNumber);
				}
			} else if (e.getSource() == btnNumberPoint) {
				if (!strNumber.contains(".")) {
					strNumber += ".";
					lblDisplay.setText(strNumber);
				}
			} else if (e.getSource() == btnBackSpace) {
				if (strNumber.length() != 0) {
					strNumber = strNumber
							.substring(0, (strNumber.length() - 1));
					lblDisplay.setText(strNumber);
				}
			} else if (e.getSource() == btnClear) {
				strNumber = "";
				lblDisplay.setText(strNumber);
			}
		} catch (NumberFormatException nfe) {
		}
		try {
			if (e.getSource() == btnTender) {
				if (!(txtSubTotal.getText()).isEmpty()) {
					if (!lblDisplay.getText().isEmpty()) {
						if (Double.parseDouble(strNumber) >= Double
								.parseDouble(txtDueAmount.getText())) {
							txtTenderedAmount.setText(strNumber);
							txtChange
									.setText(Double.toString(Double.parseDouble(new DecimalFormat(
											"#####.##").format(Double
											.parseDouble(strNumber)
											- Double.parseDouble(txtDueAmount
													.getText())))));
						} else {
							JOptionPane.showMessageDialog(frame,
									"Please, pay the due amount.");
						}
					} else {
						JOptionPane.showMessageDialog(frame,
								"Please, enter the amount of money.");
					}
				} else {
					JOptionPane.showMessageDialog(frame,
							"Please select an item and then enter the amount.");
				}
			}
		} catch (NumberFormatException nfe) {
		}
	}
}
