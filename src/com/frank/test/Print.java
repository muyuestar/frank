//package com.frank.test;
//
//import java.awt.Color;
//import java.awt.EventQueue;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//
//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.UIManager;
//
//import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
//import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
//
//import com.wjbank.date.CalendarPanel;
//import com.wjbank.document.AmountDocument;
//import com.wjbank.document.LengthDocument;
//import com.wjbank.document.PaymentCodeDocument;
//import com.wjbank.pages.CashRemittanceNoteApplication;
//import com.wjbank.pages.ChequeForTransferApplication;
//import com.wjbank.pages.CollectionCertificateApplication;
//import com.wjbank.pages.IncomeReceiptsApplication;
//import com.wjbank.pages.MoneyCashApplication;
//import com.wjbank.pages.PersonAttorneyApplication;
//import com.wjbank.pages.PublicAttorneyApplication;
//import com.wjbank.util.Constants;
//import com.wjbank.util.MoneyUtil;
//import com.wjbank.util.Tools;
//
//public class Print {
//
//	private JFrame frame;
//	private JTextField noteDateJT;
//	private JTextField payActJT;
//	private JTextField payNameJT;
//	private JTextField payActProvinceJT;
//	private JTextField payActCityJT;
//	private JTextField payActBankJT;
//	private JTextField recActJT;
//	private JTextField revNameJT;
//	private JTextField revActProvinceJT;
//	private JTextField revActCityJT;
//	private JTextField revActBankJT;
//	private JTextField amountJT;
//	private JTextField bigAmountJT;
//	private JTextField paymentCodeJT;
//	private JTextField usageJT;
//	private JTextField tspjNameJT;
//	private JButton printButton;
//
//	/**
//	 * Launch the application.o
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Print window = new Print();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 * 
//	 * @throws Exception
//	 */
//	public Print() throws Exception {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 * 
//	 * @throws Exception
//	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	private void initialize() throws Exception {
//		frame = new JFrame();
//		int width = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth());
//		int height = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight());
//		frame.setBounds(0, 0, width, height);
//		// frame.setBounds(100, 100, 910, 670);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null); // ���ھ���
//		frame.setResizable(true); // �򿪷Ŵ�ť
//		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
//		frame.setUndecorated(false); // �ſ�������
//		frame.setBackground(Color.lightGray); // ���ñ�����ɫ
//		// frame.getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
//		// ���ô�����ʽ
//		// AWTUtilities.setWindowOpacity(frame, 0.98f); // ���ô���͸����
//		// ���ý�����ʽ
//		BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//		UIManager.put("RootPane.setupButtonVisible", false);
//		BeautyEyeLNFHelper.debug = true;
//		BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
//		BeautyEyeLNFHelper.launchBeautyEyeLNF();
//
//		JPanel panel = new JPanel();
//		frame.getContentPane().add(panel);
//		panel.setLayout(null);
//		panel.setBounds(0, 0, width, height);
//
//		// ����Ӧx,y����
//		// ����x,y
//		int tx = width / 2 - 100;
//		int ty = 20;
//		// Label������x,y
//		int lx = width / 2 - 282;
//		int ly = 67;
//		// �ı�������x,y
//		int jx = width / 2 - 180;
//		int jy = 67;
//		// ��ť����x,y
//		int px = width / 2 - 60;
//		int py = 645;
//		// ��Ȩ��������x,y
//		int cx = width / 2 - 160;
//		int cy = 680;
//		// ��ӡ��������x,y
//		int dyx = width / 2 + 260;
//		int dyy = 210;
//
//		// ����
//		JLabel titleJL = new JLabel("�ͻ�ƾ֤��ӡ");
//		titleJL.setFont(new Font("����", Font.BOLD, 28));
//		titleJL.setBounds(tx, ty, 180, 30);
//		panel.add(titleJL);
//
//		// ƾ֤����
//		JLabel credentialTypeJL = new JLabel("ƾ֤���ͣ�");
//		credentialTypeJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		credentialTypeJL.setFont(new Font("����", Font.BOLD, 17));
//		credentialTypeJL.setBounds(lx, ly, 104, 30);
//		panel.add(credentialTypeJL);
//
//		JComboBox credentialTypeCB = new JComboBox();
//		credentialTypeCB.setBackground(Color.WHITE);
//		credentialTypeCB.setForeground(Color.BLACK);
//		credentialTypeCB.setModel(new DefaultComboBoxModel(
//				new String[] { "1-�ֽ�֧Ʊ", "2-ת��֧Ʊ+���˵�", "3-��λҵ��ί����", "4-����ҵ��ί����", "5-���˵�", "6-�ֽ��", "7-����ƾ֤" }));
//		credentialTypeCB.setToolTipText("");
//		credentialTypeCB.setFont(new Font("����", Font.BOLD, 17));
//		credentialTypeCB.setBounds(jx, jy, 250, 30);
//		panel.add(credentialTypeCB);
//		credentialTypeCB.setSelectedIndex(-1); // Ĭ�ϲ�ѡ���κ���
//
//		credentialTypeCB.addItemListener(new ItemListener() {
//			public void itemStateChanged(final ItemEvent e) {
//				if (e.getStateChange() == ItemEvent.SELECTED) {
//					// �������ֵ
//					clearData();
//					int index = credentialTypeCB.getSelectedIndex();
//					switch (index) {
//					case 0: // 1-�ֽ�֧Ʊ
//						Tools.updateJTextAttr(noteDateJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payNameJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActBankJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(recActJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActBankJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(amountJT, true, Color.yellow);
//						Tools.updateJTextAttr(bigAmountJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(paymentCodeJT, true, Color.white);
//						Tools.updateJTextAttr(usageJT, true, Color.yellow);
//						Tools.updateJTextAttr(tspjNameJT, false, Color.LIGHT_GRAY);
//						break;
//					case 1: // 2-ת��֧Ʊ+���˵�
//						Tools.updateJTextAttr(noteDateJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActJT, true, Color.yellow);
//						Tools.updateJTextAttr(payNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(recActJT, true, Color.yellow);
//						Tools.updateJTextAttr(revNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(amountJT, true, Color.yellow);
//						Tools.updateJTextAttr(bigAmountJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(paymentCodeJT, true, Color.white);
//						Tools.updateJTextAttr(usageJT, true, Color.yellow);
//						Tools.updateJTextAttr(tspjNameJT, false, Color.LIGHT_GRAY);
//						break;
//					case 2: // 3-��λҵ��ί����
//						Tools.updateJTextAttr(noteDateJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActJT, true, Color.yellow);
//						Tools.updateJTextAttr(payNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(recActJT, true, Color.white);
//						Tools.updateJTextAttr(revNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActBankJT, true, Color.white);
//						Tools.updateJTextAttr(amountJT, true, Color.yellow);
//						Tools.updateJTextAttr(bigAmountJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(paymentCodeJT, true, Color.white);
//						Tools.updateJTextAttr(usageJT, true, Color.yellow);
//						Tools.updateJTextAttr(tspjNameJT, false, Color.LIGHT_GRAY);
//						break;
//					case 3: // 4-����ҵ��ί����
//						Tools.updateJTextAttr(noteDateJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActJT, true, Color.yellow);
//						Tools.updateJTextAttr(payNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(recActJT, true, Color.white);
//						Tools.updateJTextAttr(revNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActBankJT, true, Color.white);
//						Tools.updateJTextAttr(amountJT, true, Color.yellow);
//						Tools.updateJTextAttr(bigAmountJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(paymentCodeJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(usageJT, true, Color.yellow);
//						Tools.updateJTextAttr(tspjNameJT, false, Color.LIGHT_GRAY);
//						break;
//					case 4: // 5-���˵�
//						Tools.updateJTextAttr(noteDateJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActJT, true, Color.yellow);
//						Tools.updateJTextAttr(payNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(recActJT, true, Color.yellow);
//						Tools.updateJTextAttr(revNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(amountJT, true, Color.yellow);
//						Tools.updateJTextAttr(bigAmountJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(paymentCodeJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(usageJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(tspjNameJT, false, Color.LIGHT_GRAY);
//						break;
//					case 5: // 6-�ֽ��
//						Tools.updateJTextAttr(noteDateJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payNameJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payActBankJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(recActJT, true, Color.yellow);
//						Tools.updateJTextAttr(revNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActProvinceJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActCityJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(revActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(amountJT, true, Color.yellow);
//						Tools.updateJTextAttr(bigAmountJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(paymentCodeJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(usageJT, true, Color.yellow);
//						Tools.updateJTextAttr(tspjNameJT, false, Color.LIGHT_GRAY);
//						break;
//					case 6: // 7-����ƾ֤
//						Tools.updateJTextAttr(noteDateJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(payNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActProvinceJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActCityJT, true, Color.yellow);
//						Tools.updateJTextAttr(payActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(recActJT, true, Color.yellow);
//						Tools.updateJTextAttr(revNameJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActProvinceJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActCityJT, true, Color.yellow);
//						Tools.updateJTextAttr(revActBankJT, true, Color.yellow);
//						Tools.updateJTextAttr(amountJT, true, Color.yellow);
//						Tools.updateJTextAttr(bigAmountJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(paymentCodeJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(usageJT, false, Color.LIGHT_GRAY);
//						Tools.updateJTextAttr(tspjNameJT, true, Color.yellow);
//						break;
//					default:
//						break;
//					}
//				}
//			}
//		});
//		// Enter�س��¼�����
//		credentialTypeCB.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					noteDateJT.requestFocus();
//				}
//			}
//		});
//		// Ʊ������
//		JLabel noteDateJL = new JLabel("Ʊ�����ڣ�");
//		noteDateJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		noteDateJL.setFont(new Font("����", Font.BOLD, 17));
//		noteDateJL.setBounds(lx + 15, ly + Constants.Y, 90, 30);
//		panel.add(noteDateJL);
//
//		noteDateJT = new JTextField();
//		noteDateJT.setFont(new Font("����", Font.BOLD, 17));
//		noteDateJT.setBounds(jx, jy + Constants.Y, 250, 30);
//		panel.add(noteDateJT);
//		noteDateJT.setColumns(10);
//		noteDateJT.setDocument(new LengthDocument(10));
//		// ���������ؼ������
//		CalendarPanel calendarP = new CalendarPanel(noteDateJT, "yyyy-MM-dd");
//		calendarP.initCalendarPanel();
//		JLabel calendarJL = new JLabel("�������");
//		calendarP.add(calendarJL);
//		panel.add(calendarP);
//		// Enter�س��¼�����
//		noteDateJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-�ֽ�֧Ʊ
//						revNameJT.requestFocus();
//					} else if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						payActJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						payActJT.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						payActJT.requestFocus();
//					} else if (index == 4) { // 5-���˵�
//						payActJT.requestFocus();
//					} else if (index == 5) { // 6-�ֽ��
//						recActJT.requestFocus();
//					} else if (index == 6) { // 7-����ƾ֤
//						payNameJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		noteDateJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//		// �������˺�/����
//		JLabel payActJL = new JLabel("�������˺�/���ţ�");
//		payActJL.setFont(new Font("����", Font.BOLD, 17));
//		payActJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActJL.setBounds(lx - 56, ly + 2 * Constants.Y, 162, 30);
//		panel.add(payActJL);
//
//		payActJT = new JTextField();
//		payActJT.setFont(new Font("����", Font.BOLD, 17));
//		payActJT.setBounds(jx, jy + 2 * Constants.Y, 405, 30);
//		panel.add(payActJT);
//		payActJT.setColumns(10);
//		payActJT.setDocument(new LengthDocument(22));
//		// Enter�س��¼�����
//		payActJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						payNameJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						payNameJT.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						payNameJT.requestFocus();
//					} else if (index == 4) { // 5-���˵�
//						payNameJT.requestFocus();
//					}
//				}
//			}
//		});
//		// ʧȥ�����¼�
//		payActJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				String payAct = payActJT.getText().trim();
//				int index = credentialTypeCB.getSelectedIndex();
//				if (Tools.isNotEmpty(payAct)) {
//					if (payAct.length() == 22 && index != 6) { // �˺�,ȥ��7-����ƾ֤
//						payActBankJT.setText(Tools.accountOnBlur(payAct));
//					}
//				}
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//		// ����������
//		JLabel payNameJL = new JLabel("���������ƣ�");
//		payNameJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		payNameJL.setFont(new Font("����", Font.BOLD, 17));
//		payNameJL.setBounds(lx - 3, ly + 3 * Constants.Y, 109, 30);
//		panel.add(payNameJL);
//
//		payNameJT = new JTextField();
//		payNameJT.setFont(new Font("����", Font.BOLD, 17));
//		payNameJT.setBounds(jx, jy + 3 * Constants.Y, 405, 30);
//		panel.add(payNameJT);
//		payNameJT.setColumns(10);
//		// Enter�س��¼�����
//		payNameJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						payActBankJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						payActBankJT.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						payActBankJT.requestFocus();
//					} else if (index == 4) { // 5-���˵�
//						payActBankJT.requestFocus();
//					} else if (index == 6) { // 7-����ƾ֤
//						payActProvinceJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		payNameJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//		// �����˵�ַ
//		JLabel payActAddressJL = new JLabel("�����˵�ַ��");
//		payActAddressJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActAddressJL.setFont(new Font("����", Font.BOLD, 17));
//		payActAddressJL.setBounds(lx - 3, ly + 4 * Constants.Y, 109, 30);
//		panel.add(payActAddressJL);
//
//		// ������ʡ
//		payActProvinceJT = new JTextField();
//		payActProvinceJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActProvinceJT.setFont(new Font("����", Font.BOLD, 17));
//		payActProvinceJT.setBounds(jx, jy + 4 * Constants.Y, 165, 30);
//		panel.add(payActProvinceJT);
//		payActProvinceJT.setColumns(10);
//
//		// Enter�س��¼�����
//		payActProvinceJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-����ƾ֤
//						payActCityJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		payActProvinceJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		JLabel payActProvinceJL = new JLabel("ʡ");
//		payActProvinceJL.setHorizontalAlignment(SwingConstants.CENTER);
//		payActProvinceJL.setFont(new Font("����", Font.BOLD, 17));
//		payActProvinceJL.setBounds(lx + 266, ly + 4 * Constants.Y, 30, 30);
//		panel.add(payActProvinceJL);
//
//		// ����������
//		payActCityJT = new JTextField();
//		payActCityJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActCityJT.setFont(new Font("����", Font.BOLD, 17));
//		payActCityJT.setBounds(jx + 195, jy + 4 * Constants.Y, 165, 30);
//		panel.add(payActCityJT);
//		payActCityJT.setColumns(10);
//
//		// Enter�س��¼�����
//		payActCityJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-����ƾ֤
//						payActBankJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		payActCityJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		JLabel payActCityJL = new JLabel("����");
//		payActCityJL.setHorizontalAlignment(SwingConstants.CENTER);
//		payActCityJL.setFont(new Font("����", Font.BOLD, 17));
//		payActCityJL.setBounds(lx + 468, ly + 4 * Constants.Y, 38, 30);
//		panel.add(payActCityJL);
//
//		// �����˿�����
//		JLabel payActBankJL = new JLabel("�����˿����У�");
//		payActBankJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActBankJL.setFont(new Font("����", Font.BOLD, 17));
//		// payActBankJL.setBounds(113, 214, 135, 30);
//		payActBankJL.setBounds(lx - 28, ly + 5 * Constants.Y, 135, 30);
//		panel.add(payActBankJL);
//
//		payActBankJT = new JTextField();
//		payActBankJT.setFont(new Font("����", Font.BOLD, 17));
//		// payActBankJT.setBounds(247, 214, 405, 30);
//		payActBankJT.setBounds(jx, jy + 5 * Constants.Y, 405, 30);
//		panel.add(payActBankJT);
//		payActBankJT.setColumns(10);
//		// Enter�س��¼�����
//		payActBankJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						recActJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						recActJT.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						recActJT.requestFocus();
//					} else if (index == 4) { // 5-���˵�
//						recActJT.requestFocus();
//					} else if (index == 6) { // 7-����ƾ֤
//						recActJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		payActBankJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// �տ����˺�/����
//		JLabel recActJL = new JLabel("�տ����˺�/���ţ�");
//		recActJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		recActJL.setFont(new Font("����", Font.BOLD, 17));
//		recActJL.setBounds(lx - 56, ly + 6 * Constants.Y, 162, 30);
//		panel.add(recActJL);
//
//		recActJT = new JTextField();
//		recActJT.setFont(new Font("����", Font.BOLD, 17));
//		recActJT.setBounds(jx, jy + 6 * Constants.Y, 405, 30);
//		panel.add(recActJT);
//		recActJT.setColumns(10);
//		// Enter�س��¼�����
//		recActJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						revNameJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						revNameJT.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						revNameJT.requestFocus();
//					} else if (index == 4) { // 5-���˵�
//						revNameJT.requestFocus();
//					} else if (index == 5) { // 6-�ֽ��
//						revNameJT.requestFocus();
//					} else if (index == 6) { // 7-����ƾ֤
//						revNameJT.requestFocus();
//					}
//				}
//			}
//		});
//		// ʧȥ�����¼�
//		recActJT.addFocusListener(new FocusListener() {
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				String recAct = recActJT.getText().trim();
//				int index = credentialTypeCB.getSelectedIndex();
//				if (Tools.isNotEmpty(recAct)) {
//					if (recAct.length() == 22 && index != 6) { // ����ƾ֤������
//						revActBankJT.setText(Tools.accountOnBlur(recAct));
//					}
//				}
//			}
//		});
//
//		// �տ�������
//		JLabel revNameJL = new JLabel("�տ������ƣ�");
//		revNameJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		revNameJL.setFont(new Font("����", Font.BOLD, 17));
//		revNameJL.setBounds(lx - 3, ly + 7 * Constants.Y, 110, 30);
//		panel.add(revNameJL);
//
//		revNameJT = new JTextField();
//		revNameJT.setFont(new Font("����", Font.BOLD, 17));
//		revNameJT.setBounds(jx, jy + 7 * Constants.Y, 405, 30);
//		panel.add(revNameJT);
//		revNameJT.setColumns(10);
//		// Enter�س��¼�����
//		revNameJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-�ֽ�֧Ʊ
//						amountJT.requestFocus();
//					} else if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						revActBankJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						revActBankJT.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						revActBankJT.requestFocus();
//					} else if (index == 4) { // 5-���˵�
//						revActBankJT.requestFocus();
//					} else if (index == 5) { // 6-�ֽ��
//						revActBankJT.requestFocus();
//					} else if (index == 6) { // 7-����ƾ֤
//						revActProvinceJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		revNameJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// �տ��˵�ַ
//		JLabel revActAddressJL = new JLabel("�տ��˵�ַ��");
//		revActAddressJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		revActAddressJL.setFont(new Font("����", Font.BOLD, 17));
//		revActAddressJL.setBounds(lx - 3, ly + 8 * Constants.Y, 109, 30);
//		panel.add(revActAddressJL);
//
//		// �տ���ʡ
//		revActProvinceJT = new JTextField();
//		revActProvinceJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		revActProvinceJT.setFont(new Font("����", Font.BOLD, 17));
//		revActProvinceJT.setBounds(jx, jy + 8 * Constants.Y, 165, 30);
//		panel.add(revActProvinceJT);
//		revActProvinceJT.setColumns(10);
//
//		// Enter�س��¼�����
//		revActProvinceJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-����ƾ֤
//						revActCityJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		revActProvinceJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		JLabel revActProvinceJL = new JLabel("ʡ");
//		revActProvinceJL.setHorizontalAlignment(SwingConstants.CENTER);
//		revActProvinceJL.setFont(new Font("����", Font.BOLD, 17));
//		revActProvinceJL.setBounds(lx + 266, ly + 8 * Constants.Y, 30, 30);
//		panel.add(revActProvinceJL);
//
//		// �տ�������
//		revActCityJT = new JTextField();
//		revActCityJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		revActCityJT.setFont(new Font("����", Font.BOLD, 17));
//		revActCityJT.setBounds(jx + 195, jy + 8 * Constants.Y, 165, 30);
//		panel.add(revActCityJT);
//		revActCityJT.setColumns(10);
//
//		// Enter�س��¼�����
//		revActCityJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-����ƾ֤
//						revActBankJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		revActCityJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		JLabel revActCityJL = new JLabel("����");
//		revActCityJL.setHorizontalAlignment(SwingConstants.CENTER);
//		revActCityJL.setFont(new Font("����", Font.BOLD, 17));
//		revActCityJL.setBounds(lx + 468, ly + 8 * Constants.Y, 38, 30);
//		panel.add(revActCityJL);
//
//		// �տ��˿�����
//		JLabel revActBankJL = new JLabel("�տ��˿����У�");
//		revActBankJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		revActBankJL.setFont(new Font("����", Font.BOLD, 17));
//		revActBankJL.setBounds(lx - 28, ly + 9 * Constants.Y, 135, 30);
//		panel.add(revActBankJL);
//
//		revActBankJT = new JTextField();
//		revActBankJT.setHorizontalAlignment(SwingConstants.LEFT);
//		revActBankJT.setFont(new Font("����", Font.BOLD, 17));
//		revActBankJT.setBounds(jx, jy + 9 * Constants.Y, 405, 30);
//		panel.add(revActBankJT);
//		revActBankJT.setColumns(10);
//		// Enter�س��¼�����
//		revActBankJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						amountJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						amountJT.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						amountJT.requestFocus();
//					} else if (index == 4) { // 5-���˵�
//						amountJT.requestFocus();
//					} else if (index == 5) { // 6-�ֽ��
//						amountJT.requestFocus();
//					} else if (index == 6) { // 7-����ƾ֤
//						amountJT.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		revActBankJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// ���׽��
//		JLabel amountJL = new JLabel("���׽�");
//		amountJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		amountJL.setFont(new Font("����", Font.BOLD, 17));
//		amountJL.setBounds(lx + 15, ly + 10 * Constants.Y, 90, 30);
//		panel.add(amountJL);
//
//		amountJT = new JTextField();
//		amountJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		amountJT.setFont(new Font("����", Font.BOLD, 17));
//		amountJT.setBounds(jx, jy + 10 * Constants.Y, 405, 30);
//		panel.add(amountJT);
//		amountJT.setColumns(10);
//		amountJT.setDocument(new AmountDocument(12));
//
//		// �����ͷ��¼�
//		amountJT.addKeyListener(new KeyAdapter() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-�ֽ�֧Ʊ
//						paymentCodeJT.requestFocus();
//					} else if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						paymentCodeJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						paymentCodeJT.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						usageJT.requestFocus();
//					} else if (index == 4) { // 5-���˵�
//						printButton.requestFocus();
//					} else if (index == 5) { // 6-�ֽ��
//						usageJT.requestFocus();
//					} else if (index == 6) { // 7-����ƾ֤
//						tspjNameJT.requestFocus();
//					}
//				}
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//
//			}
//		});
//		// ʧȥ�����¼�
//		amountJT.addFocusListener(new FocusListener() {
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				String amount = amountJT.getText().trim();
//				String bigAmount = "";
//				if (Tools.isNotEmpty(amount)) {
//					if (amount.contains(".")) { // ����С�����
//						if (amount.split("\\.")[0].length() > 9) { // ֻ���䵽9��
//							JOptionPane.showMessageDialog(null, "���������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//							amountJT.requestFocus();
//							return;
//						}
//						if (amount.split("\\.")[1].length() > 2) {
//							JOptionPane.showMessageDialog(null, "�������ʽ����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//							amountJT.requestFocus();
//							return;
//						}
//					} else { // ���봿�������
//						if (amount.length() > 9) { // ֻ���䵽9��
//							JOptionPane.showMessageDialog(null, "���������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//							amountJT.requestFocus();
//							return;
//						}
//					}
//					bigAmount = MoneyUtil.amountToChinese(amount);
//				}
//				// ���Դ�д���
//				bigAmountJT.setText(bigAmount);
//				// ƾ֤����
//				int index = credentialTypeCB.getSelectedIndex();
//				// 1-�ֽ�֧Ʊ��2-ת��֧Ʊ+���˵�,3-��λҵ��ί����
//				if (index == 0 || index == 1 || index == 2) {
//					paymentCodeJT.requestFocus();
//				} else if (index == 3 || index == 5) { // 4-����ҵ��ί���顢6-�ֽ��
//					usageJT.requestFocus();
//				} else if (index == 4) { // 5-���˵�
//					printButton.requestFocus();
//				} else if (index == 6) { // 7-����ƾ֤
//					tspjNameJT.requestFocus();
//				}
//			}
//		});
//
//		// ��д���
//		JLabel bigAmountJL = new JLabel("��д��");
//		bigAmountJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		bigAmountJL.setFont(new Font("����", Font.BOLD, 17));
//		bigAmountJL.setBounds(lx + 15, ly + 11 * Constants.Y, 90, 30);
//		panel.add(bigAmountJL);
//
//		bigAmountJT = new JTextField();
//		bigAmountJT.setFont(new Font("����", Font.BOLD, 17));
//		bigAmountJT.setBounds(jx, jy + 11 * Constants.Y, 405, 30);
//		panel.add(bigAmountJT);
//		bigAmountJT.setColumns(10);
//		// �����¼�
//		bigAmountJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// ֧������
//		JLabel paymentCodeJL = new JLabel("֧�����룺");
//		paymentCodeJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		paymentCodeJL.setFont(new Font("����", Font.BOLD, 17));
//		paymentCodeJL.setBounds(lx + 15, ly + 12 * Constants.Y, 90, 30);
//		panel.add(paymentCodeJL);
//
//		paymentCodeJT = new JTextField();
//		paymentCodeJT.setFont(new Font("����", Font.BOLD, 17));
//		paymentCodeJT.setBounds(jx, jy + 12 * Constants.Y, 405, 30);
//		panel.add(paymentCodeJT);
//		paymentCodeJT.setColumns(10);
//		paymentCodeJT.setDocument(new PaymentCodeDocument(16));
//
//		// ��4λ�Զ���-
//		paymentCodeJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				// enter�س�������
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-�ֽ�֧Ʊ
//						usageJT.requestFocus();
//					} else if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						usageJT.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						usageJT.requestFocus();
//					}
//				}
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//
//			}
//		});
//		// �����¼�
//		paymentCodeJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				String paymentCode = paymentCodeJT.getText().trim();
//				paymentCodeJT.setDocument(new PaymentCodeDocument(19));
//				// ��-
//				StringBuffer sb = new StringBuffer();
//				char[] chs = paymentCode.toCharArray();
//				for (int i = 0; i < chs.length; i++) {
//					if (i == 4) {
//						sb.append(Constants.UNDERLINE);
//					} else if (i == 8) {
//						sb.append(Constants.UNDERLINE);
//					} else if (i == 12) {
//						sb.append(Constants.UNDERLINE);
//					}
//					sb.append(String.valueOf(chs[i]));
//				}
//				paymentCodeJT.setText(sb.toString());
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//				String paymentCode = paymentCodeJT.getText().trim();
//				paymentCodeJT.setDocument(new PaymentCodeDocument(16));
//				paymentCodeJT.setText(paymentCode.replace("-", ""));
//			}
//		});
//
//		// ��;
//		JLabel usageJL = new JLabel("��   ;��");
//		usageJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		usageJL.setFont(new Font("����", Font.BOLD, 17));
//		usageJL.setBounds(lx + 15, ly + 13 * Constants.Y, 93, 30);
//		panel.add(usageJL);
//
//		usageJT = new JTextField();
//		usageJT.setFont(new Font("����", Font.BOLD, 17));
//		usageJT.setBounds(jx, jy + 13 * Constants.Y, 405, 30);
//		panel.add(usageJT);
//		usageJT.setColumns(10);
//		// Enter�س��¼�����
//		usageJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-�ֽ�֧Ʊ
//						printButton.requestFocus();
//					} else if (index == 1) { // 2-ת��֧Ʊ+���˵�
//						printButton.requestFocus();
//					} else if (index == 2) { // 3-��λҵ��ί����
//						printButton.requestFocus();
//					} else if (index == 3) { // 4-����ҵ��ί����
//						printButton.requestFocus();
//					} else if (index == 5) { // 6-�ֽ��
//						printButton.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		usageJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// ����ƾ������
//		JLabel tspjNameJL = new JLabel("����ƾ�����ƣ�");
//		tspjNameJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		tspjNameJL.setFont(new Font("����", Font.BOLD, 17));
//		tspjNameJL.setBounds(lx - 28, ly + 14 * Constants.Y, 135, 30);
//		panel.add(tspjNameJL);
//
//		tspjNameJT = new JTextField();
//		tspjNameJT.setFont(new Font("����", Font.BOLD, 17));
//		tspjNameJT.setBounds(jx, jy + 14 * Constants.Y, 405, 30);
//		panel.add(tspjNameJT);
//		tspjNameJT.setColumns(10);
//		// Enter�س��¼�����
//		tspjNameJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-����ƾ֤
//						printButton.requestFocus();
//					}
//				}
//			}
//		});
//		// �����¼�
//		tspjNameJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// ��ӡ
//		printButton = new JButton("��  ӡ");
//		printButton.setFont(new Font("����", Font.BOLD, 17));
//		printButton.setBounds(px - 90, py, 93, 30);
//		panel.add(printButton);
//		printButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
//		// ��ӡ�¼�
//		printButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int ind = 0; // 0-��
//				// ƾ֤����
//				int index = credentialTypeCB.getSelectedIndex();
//				// Ʊ������
//				String noteDate = noteDateJT.getText().trim();
//				// �������˺Ż򿨺�
//				String payAct = payActJT.getText().trim();
//				// ����������
//				String payName = payNameJT.getText().trim();
//				// ������ʡ
//				String payActProvince = payActProvinceJT.getText().trim();
//				// ����������
//				String payActCity = payActCityJT.getText().trim();
//				// �����˿�����
//				String payActBank = payActBankJT.getText().trim();
//				// �տ����˺Ż򿨺�
//				String recAct = recActJT.getText().trim();
//				// �տ�������
//				String revName = revNameJT.getText().trim();
//				// �տ���ʡ
//				String revActProvince = revActProvinceJT.getText().trim();
//				// �տ�������
//				String revActCity = revActCityJT.getText().trim();
//				// �տ��˿�����
//				String revActBank = revActBankJT.getText().trim();
//				// ���׽��
//				String amount = amountJT.getText().trim();
//				// ��д���
//				String bigAmount = bigAmountJT.getText().trim();
//				// ֧������
//				String paymentCode = paymentCodeJT.getText().trim();
//				// ��;
//				String usage = usageJT.getText().trim();
//				// ����ƾ������
//				String tspjName = tspjNameJT.getText().trim();
//				// ��ӡǰ�жϱ���ֵ�Ƿ����
//				// �ж�ƾ֤�����Ƿ�����
//				if (index == -1) {
//					JOptionPane.showMessageDialog(null, "ƾ֤���Ͳ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//					credentialTypeCB.requestFocus();
//					return;
//				}
//				// �ж�Ʊ�������Ƿ�����
//				if (Tools.isEmpty(noteDate)) {
//					if (noteDateJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "Ʊ�����ڲ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						noteDateJT.requestFocus();
//						return;
//					}
//				}
//				// �жϸ������˺�/�����Ƿ�����
//				if (Tools.isEmpty(payAct)) {
//					if (payActJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "�������˺�/���Ų���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActJT.requestFocus();
//						return;
//					}
//				}
//				// �жϸ����������Ƿ�����
//				if (Tools.isEmpty(payName)) {
//					if (payNameJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "���������Ʋ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//				}
//				// �жϸ�����ʡ�Ƿ�����
//				if (Tools.isEmpty(payActProvince)) {
//					if (payActProvinceJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "������ʡ����Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActProvinceJT.requestFocus();
//						return;
//					}
//				}
//				// �жϸ����������Ƿ�����
//				if (Tools.isEmpty(payActCity)) {
//					if (payActCityJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "���������ز���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActCityJT.requestFocus();
//						return;
//					}
//				}
//				// �жϸ����˿������Ƿ�����
//				if (Tools.isEmpty(payActBank)) {
//					if (payActBankJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "�����˿����в���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//				}
//				// �ж��տ����˺Ż򿨺��Ƿ�����
//				if (Tools.isEmpty(recAct)) {
//					if (recActJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "�տ����˺�/���Ų���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//				}
//				// �ж��տ��������Ƿ�����
//				if (Tools.isEmpty(revName)) {
//					if (revNameJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "�տ������Ʋ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//				}
//				// �ж��տ���ʡ�Ƿ�����
//				if (Tools.isEmpty(revActProvince)) {
//					if (revActProvinceJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "�տ���ʡ����Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActProvinceJT.requestFocus();
//						return;
//					}
//				}
//				// �ж��տ��������Ƿ�����
//				if (Tools.isEmpty(revActCity)) {
//					if (revActCityJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "�տ������ز���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActCityJT.requestFocus();
//						return;
//					}
//				}
//				// �ж��տ��˿������Ƿ�����
//				if (Tools.isEmpty(revActBank)) {
//					if (revActBankJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "�տ��˿����в���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//				}
//				// �жϽ��׽���Ƿ�����
//				if (Tools.isEmpty(amount)) {
//					if (amountJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "���׽���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						amountJT.requestFocus();
//						return;
//					}
//				}
//				// �ж���;�Ƿ�����
//				if (Tools.isEmpty(usage)) {
//					if (usageJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "��;����Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//				}
//				// �ж�����ƾ�������Ƿ�����
//				if (Tools.isEmpty(tspjName)) {
//					if (tspjNameJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "����ƾ�����Ʋ���Ϊ�գ�", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						tspjNameJT.requestFocus();
//						return;
//					}
//				}
//				if (index == 0) { // 1-�ֽ�֧Ʊ
//					// �տ����������46��
//					if (revName.length() > 46) {
//						JOptionPane.showMessageDialog(null, "�տ������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					// ��;���20��
//					if (usage.length() > 20) {
//						JOptionPane.showMessageDialog(null, "��;������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.XJZPTIP, "��ʾ", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-��
//						return;
//					}
//					// ���ô�ӡ����
//					MoneyCashApplication mca = new MoneyCashApplication();
//					// ��
//					mca.year = Tools.converToCapitalDate(noteDate)[0];
//					// ��
//					mca.month = Tools.converToCapitalDate(noteDate)[1];
//					// ��
//					mca.day = Tools.converToCapitalDate(noteDate)[2];
//					// �տ�������
//					mca.revName = revName;
//					// ��д���
//					mca.bigAmount = bigAmount;
//					// ֧������
//					mca.paymentCode = paymentCode;
//					// ��;
//					mca.usage = usage;
//					Tools.printVC(mca);
//				} else if (index == 1) { // 2-ת��֧Ʊ+���˵�
//					if (payName.length() > 32) { // ����������32
//						JOptionPane.showMessageDialog(null, "���������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 32) { // �����˿�����32
//						JOptionPane.showMessageDialog(null, "�����˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // �տ����˺�28
//						JOptionPane.showMessageDialog(null, "�տ����˺ų�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 32) { // �տ�������32
//						JOptionPane.showMessageDialog(null, "�տ������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 32) { // �տ��˿�����32
//						JOptionPane.showMessageDialog(null, "�տ��˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					// ��;���20��
//					if (usage.length() > 20) {
//						JOptionPane.showMessageDialog(null, "��;������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.ZZZPTIP, "��ʾ", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-��
//						return;
//					}
//					// ת��֧Ʊ���ô�ӡ����
//					ChequeForTransferApplication cft = new ChequeForTransferApplication();
//					// ��
//					cft.year = Tools.converToCapitalDate(noteDate)[0];
//					// ��
//					cft.month = Tools.converToCapitalDate(noteDate)[1];
//					// ��
//					cft.day = Tools.converToCapitalDate(noteDate)[2];
//					// �տ�������
//					cft.revName = revName;
//					// ��д���
//					cft.bigAmount = bigAmount;
//					// ֧������
//					cft.paymentCode = paymentCode;
//					// ��;
//					cft.usage = usage;
//					Tools.printVC(cft);
//					ind = JOptionPane.showConfirmDialog(null, Constants.JZDTIP, "��ʾ", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-��
//						return;
//					}
//					// ���˵����ô�ӡ����
//					IncomeReceiptsApplication ira = new IncomeReceiptsApplication();
//					// Ʊ������
//					ira.noteDate = noteDate.replace("-", "    ");
//					// �������˺Ż򿨺�
//					ira.payAct = payAct;
//					// ����������
//					ira.payName = payName;
//					// �����˿�����
//					ira.payActBank = payActBank;
//					// �տ����˺Ż򿨺�
//					ira.recAct = recAct;
//					// �տ�������
//					ira.revName = revName;
//					// �տ��˿�����
//					ira.revActBank = revActBank;
//					// ��д���
//					ira.bigAmount = bigAmount;
//					Tools.printVC(ira);
//				} else if (index == 2) { // 3-��λҵ��ί����
//					if (payName.length() > 38) { // ����������38
//						JOptionPane.showMessageDialog(null, "���������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 38) { // �����˿�����38
//						JOptionPane.showMessageDialog(null, "�����˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // �տ����˺�28
//						JOptionPane.showMessageDialog(null, "�տ����˺ų�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 38) { // �տ�������38
//						JOptionPane.showMessageDialog(null, "�տ������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 38) { // �տ��˿�����38
//						JOptionPane.showMessageDialog(null, "�տ��˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					if (usage.length() > 46) { // ��;46
//						JOptionPane.showMessageDialog(null, "��;������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.DWYWWTSTIP, "��ʾ", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-��
//						return;
//					}
//					// ���ô�ӡ����
//					PublicAttorneyApplication paa = new PublicAttorneyApplication();
//					// Ʊ������
//					paa.noteDate = noteDate.replace("-", "   ");
//					// �������˺Ż򿨺�
//					paa.payAct = payAct;
//					// ����������
//					paa.payName = payName;
//					// �����˿�����
//					paa.payActBank = payActBank;
//					// �տ����˺Ż򿨺�
//					paa.recAct = recAct;
//					// �տ�������
//					paa.revName = revName;
//					// �տ��˿�����
//					paa.revActBank = revActBank;
//					// ��д���
//					paa.bigAmount = bigAmount;
//					// ֧������
//					paa.paymentCode = paymentCode;
//					// ��;
//					paa.usage = usage;
//					Tools.printVC(paa);
//				} else if (index == 3) { // 4-����ҵ��ί����
//					if (payName.length() > 16) { // ����������16
//						JOptionPane.showMessageDialog(null, "���������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 44) { // �����˿�����44
//						JOptionPane.showMessageDialog(null, "�����˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // �տ����˺�28
//						JOptionPane.showMessageDialog(null, "�տ����˺ų�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 44) { // �տ�������44
//						JOptionPane.showMessageDialog(null, "�տ������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 44) { // �տ��˿�����44
//						JOptionPane.showMessageDialog(null, "�տ��˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					if (usage.length() > 26) { // ��;26
//						JOptionPane.showMessageDialog(null, "��;������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.GRYWWTSTIP, "��ʾ", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-��
//						return;
//					}
//					// ���ô�ӡ����
//					PersonAttorneyApplication paa = new PersonAttorneyApplication();
//					// Ʊ������
//					paa.noteDate = noteDate.replace("-", "  ");
//					// �������˺Ż򿨺�
//					paa.payAct = payAct;
//					// ����������
//					paa.payName = payName;
//					// �����˿�����
//					paa.payActBank = payActBank;
//					// �տ����˺Ż򿨺�
//					paa.recAct = recAct;
//					// �տ�������
//					paa.revName = revName;
//					// �տ��˿�����
//					paa.revActBank = revActBank;
//					// ��д���
//					paa.bigAmount = bigAmount;
//					// ��;
//					paa.usage = usage;
//					Tools.printVC(paa);
//				} else if (index == 4) { // 5-���˵�
//					if (payName.length() > 32) { // ����������32
//						JOptionPane.showMessageDialog(null, "���������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 32) { // �����˿�����32
//						JOptionPane.showMessageDialog(null, "�����˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // �տ����˺�28
//						JOptionPane.showMessageDialog(null, "�տ����˺ų�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 32) { // �տ�������32
//						JOptionPane.showMessageDialog(null, "�տ������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 32) { // �տ��˿�����32
//						JOptionPane.showMessageDialog(null, "�տ��˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.JZDTIP, "��ʾ", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-��
//						return;
//					}
//					// ���ô�ӡ����
//					IncomeReceiptsApplication ira = new IncomeReceiptsApplication();
//					// Ʊ������
//					ira.noteDate = noteDate.replace("-", "    ");
//					// �������˺Ż򿨺�
//					ira.payAct = payAct;
//					// ����������
//					ira.payName = payName;
//					// �����˿�����
//					ira.payActBank = payActBank;
//					// �տ����˺Ż򿨺�
//					ira.recAct = recAct;
//					// �տ�������
//					ira.revName = revName;
//					// �տ��˿�����
//					ira.revActBank = revActBank;
//					// ��д���
//					ira.bigAmount = bigAmount;
//					Tools.printVC(ira);
//				} else if (index == 5) { // 6-�ֽ��
//					if (recAct.length() > 28) { // �տ����˺�28
//						JOptionPane.showMessageDialog(null, "�տ����˺ų�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 36) { // �տ�������36
//						JOptionPane.showMessageDialog(null, "�տ������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 36) { // �տ��˿�����36
//						JOptionPane.showMessageDialog(null, "�տ��˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					if (usage.length() > 34) { // ��;34
//						JOptionPane.showMessageDialog(null, "��;������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.XJCPTIP, "��ʾ", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-��
//						return;
//					}
//					// ���ô�ӡ����
//					CashRemittanceNoteApplication cna = new CashRemittanceNoteApplication();
//					// Ʊ������
//					cna.noteDate = noteDate.replace("-", "    ");
//					// �տ����˺Ż򿨺�
//					cna.recAct = recAct;
//					// �տ�������
//					cna.revName = revName;
//					// �տ��˿�����
//					cna.revActBank = revActBank;
//					// ��д���
//					cna.bigAmount = bigAmount;
//					// ��;
//					cna.usage = usage;
//					Tools.printVC(cna);
//				} else if (index == 6) { // 7-����ƾ֤
//					if (payName.length() > 32) { // ����������32
//						JOptionPane.showMessageDialog(null, "���������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActProvince.length() > 3) { // ������ʡ3
//						JOptionPane.showMessageDialog(null, "������ʡ������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActProvinceJT.requestFocus();
//						return;
//					}
//					if (payActCity.length() > 4) { // ����������4
//						JOptionPane.showMessageDialog(null, "���������س�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActCityJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 8) { // �����˿�����8
//						JOptionPane.showMessageDialog(null, "�����˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // �տ����˺�28
//						JOptionPane.showMessageDialog(null, "�տ����˺ų�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 32) { // �տ�������32
//						JOptionPane.showMessageDialog(null, "�տ������Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActProvince.length() > 3) { // �տ���ʡ3
//						JOptionPane.showMessageDialog(null, "�տ���ʡ������", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActProvinceJT.requestFocus();
//						return;
//					}
//					if (revActCity.length() > 4) { // �տ�������4
//						JOptionPane.showMessageDialog(null, "�տ������س�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActCityJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 8) { // �տ��˿�����8
//						JOptionPane.showMessageDialog(null, "�տ��˿����г�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					if (tspjName.length() > 13) { // ����ƾ������13
//						JOptionPane.showMessageDialog(null, "����ƾ�����Ƴ�����", "��ʾ", JOptionPane.DEFAULT_OPTION);
//						tspjNameJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.TSPZTIP, "��ʾ", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-��
//						return;
//					}
//					// ���ô�ӡ����
//					CollectionCertificateApplication cca = new CollectionCertificateApplication();
//					// Ʊ������
//					cca.noteDate = noteDate.replace("-", "   ");
//					// �������˺Ż򿨺�
//					cca.payAct = payAct;
//					// ����������
//					cca.payName = payName;
//					// ������ʡ
//					cca.payActProvince = payActProvince;
//					// ����������
//					cca.payActCity = payActCity;
//					// �����˿�����
//					cca.payActBank = payActBank;
//					// �տ����˺Ż򿨺�
//					cca.recAct = recAct;
//					// �տ�������
//					cca.revName = revName;
//					// �տ���ʡ
//					cca.revActProvince = revActProvince;
//					// �տ�������
//					cca.revActCity = revActCity;
//					// �տ��˿�����
//					cca.revActBank = revActBank;
//					// ��д���
//					cca.bigAmount = bigAmount;
//					// ����ƾ������
//					cca.tspjName = tspjName;
//					Tools.printVC(cca);
//				}
//			}
//		});
//		// ȡ��
//		JButton cancelButton = new JButton("ȡ  ��");
//		cancelButton.setFont(new Font("����", Font.BOLD, 17));
//		cancelButton.setBounds(px + 90, py, 93, 30);
//		panel.add(cancelButton);
//		cancelButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
//
//		cancelButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.exit(0);
//			}
//		});
//		// ��Ȩ
//		JLabel copyJL = new JLabel("? 2017-2097 �⽭ũ����ҵ���� ��Ȩ����");
//		copyJL.setFont(new Font("����", Font.BOLD, 13));
//		copyJL.setBounds(cx, cy, 272, 22);
//		panel.add(copyJL);
//
//		// ��ӡ��֪
//		JLabel dyxzJL = new JLabel("��ӡ��֪��");
//		dyxzJL.setForeground(Color.RED);
//		dyxzJL.setBackground(Color.BLACK);
//		dyxzJL.setFont(new Font("����", Font.BOLD, 15));
//		dyxzJL.setBounds(dyx, dyy, 80, 22);
//		panel.add(dyxzJL);
//
//		JLabel firstJL = new JLabel("1����ӡ�ֽ�֧Ʊ��ת��֧Ʊ��˺ȥ������ٴ�ӡ��");
//		firstJL.setFont(new Font("����", Font.PLAIN, 13));
//		firstJL.setBounds(dyx, dyy + Constants.DYXZY, 380, 22);
//		panel.add(firstJL);
//
//		JLabel secondJL = new JLabel("2���ͻ�ƾ֤��ӡ���ͣ��ֽ�֧Ʊ��ת��֧Ʊ+���˵�����λҵ��");
//		secondJL.setFont(new Font("����", Font.PLAIN, 13));
//		secondJL.setBounds(dyx, dyy + 2 * Constants.DYXZY + 5, 380, 22);
//		panel.add(secondJL);
//
//		JLabel second_twoJL = new JLabel("ί���顢����ҵ��ί���顢���˵����ֽ��������ƾ֤��");
//		second_twoJL.setFont(new Font("����", Font.PLAIN, 13));
//		second_twoJL.setBounds(dyx + 20, dyy + 3 * Constants.DYXZY, 380, 22);
//		panel.add(second_twoJL);
//
//		JLabel thirdJL = new JLabel("3����λҵ��ί����Ϊ�°�ҵ��ί���飬��֧�־ɰ�ҵ��ί���飻");
//		thirdJL.setFont(new Font("����", Font.PLAIN, 13));
//		thirdJL.setBounds(dyx, dyy + 4 * Constants.DYXZY + 3, 380, 22);
//		panel.add(thirdJL);
//
//		JLabel fourthJL = new JLabel("4���ַ����Ŀ��ƣ���ƾ֤ʵ�ʿɴ�ӡ������ַ���������Ӧ��");
//		fourthJL.setFont(new Font("����", Font.PLAIN, 13));
//		fourthJL.setBounds(dyx, dyy + 5 * Constants.DYXZY + 5, 380, 22);
//		panel.add(fourthJL);
//
//		JLabel fourth_twoJL = new JLabel("�ƣ���������³������ʾ��");
//		fourth_twoJL.setFont(new Font("����", Font.PLAIN, 13));
//		fourth_twoJL.setBounds(dyx + 20, dyy + 6 * Constants.DYXZY, 200, 22);
//		panel.add(fourth_twoJL);
//	}
//
//	/**
//	 * �������ֵ
//	 */
//	protected void clearData() {
//		noteDateJT.setText("");
//		payActJT.setText("");
//		payNameJT.setText("");
//		payActProvinceJT.setText("");
//		payActCityJT.setText("");
//		payActBankJT.setText("");
//		recActJT.setText("");
//		revNameJT.setText("");
//		revActProvinceJT.setText("");
//		revActCityJT.setText("");
//		revActBankJT.setText("");
//		amountJT.setText("");
//		bigAmountJT.setText("");
//		paymentCodeJT.setText("");
//		usageJT.setText("");
//		tspjNameJT.setText("");
//	}
//}
