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
//		frame.setLocationRelativeTo(null); // 窗口居中
//		frame.setResizable(true); // 打开放大按钮
//		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
//		frame.setUndecorated(false); // 放开标题栏
//		frame.setBackground(Color.lightGray); // 设置背景颜色
//		// frame.getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
//		// 设置窗体样式
//		// AWTUtilities.setWindowOpacity(frame, 0.98f); // 设置窗体透明度
//		// 设置界面样式
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
//		// 自适应x,y坐标
//		// 标题x,y
//		int tx = width / 2 - 100;
//		int ty = 20;
//		// Label框坐标x,y
//		int lx = width / 2 - 282;
//		int ly = 67;
//		// 文本框坐标x,y
//		int jx = width / 2 - 180;
//		int jy = 67;
//		// 按钮坐标x,y
//		int px = width / 2 - 60;
//		int py = 645;
//		// 版权坐标坐标x,y
//		int cx = width / 2 - 160;
//		int cy = 680;
//		// 打印事项坐标x,y
//		int dyx = width / 2 + 260;
//		int dyy = 210;
//
//		// 标题
//		JLabel titleJL = new JLabel("客户凭证打印");
//		titleJL.setFont(new Font("宋体", Font.BOLD, 28));
//		titleJL.setBounds(tx, ty, 180, 30);
//		panel.add(titleJL);
//
//		// 凭证类型
//		JLabel credentialTypeJL = new JLabel("凭证类型：");
//		credentialTypeJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		credentialTypeJL.setFont(new Font("宋体", Font.BOLD, 17));
//		credentialTypeJL.setBounds(lx, ly, 104, 30);
//		panel.add(credentialTypeJL);
//
//		JComboBox credentialTypeCB = new JComboBox();
//		credentialTypeCB.setBackground(Color.WHITE);
//		credentialTypeCB.setForeground(Color.BLACK);
//		credentialTypeCB.setModel(new DefaultComboBoxModel(
//				new String[] { "1-现金支票", "2-转账支票+进账单", "3-单位业务委托书", "4-个人业务委托书", "5-进账单", "6-现金解款单", "7-托收凭证" }));
//		credentialTypeCB.setToolTipText("");
//		credentialTypeCB.setFont(new Font("宋体", Font.BOLD, 17));
//		credentialTypeCB.setBounds(jx, jy, 250, 30);
//		panel.add(credentialTypeCB);
//		credentialTypeCB.setSelectedIndex(-1); // 默认不选择任何项
//
//		credentialTypeCB.addItemListener(new ItemListener() {
//			public void itemStateChanged(final ItemEvent e) {
//				if (e.getStateChange() == ItemEvent.SELECTED) {
//					// 清空所有值
//					clearData();
//					int index = credentialTypeCB.getSelectedIndex();
//					switch (index) {
//					case 0: // 1-现金支票
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
//					case 1: // 2-转账支票+进账单
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
//					case 2: // 3-单位业务委托书
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
//					case 3: // 4-个人业务委托书
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
//					case 4: // 5-进账单
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
//					case 5: // 6-现金解款单
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
//					case 6: // 7-托收凭证
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
//		// Enter回车事件处理
//		credentialTypeCB.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					noteDateJT.requestFocus();
//				}
//			}
//		});
//		// 票据日期
//		JLabel noteDateJL = new JLabel("票据日期：");
//		noteDateJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		noteDateJL.setFont(new Font("宋体", Font.BOLD, 17));
//		noteDateJL.setBounds(lx + 15, ly + Constants.Y, 90, 30);
//		panel.add(noteDateJL);
//
//		noteDateJT = new JTextField();
//		noteDateJT.setFont(new Font("宋体", Font.BOLD, 17));
//		noteDateJT.setBounds(jx, jy + Constants.Y, 250, 30);
//		panel.add(noteDateJT);
//		noteDateJT.setColumns(10);
//		noteDateJT.setDocument(new LengthDocument(10));
//		// 定义日历控件面板类
//		CalendarPanel calendarP = new CalendarPanel(noteDateJT, "yyyy-MM-dd");
//		calendarP.initCalendarPanel();
//		JLabel calendarJL = new JLabel("日历面板");
//		calendarP.add(calendarJL);
//		panel.add(calendarP);
//		// Enter回车事件处理
//		noteDateJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-现金支票
//						revNameJT.requestFocus();
//					} else if (index == 1) { // 2-转账支票+进账单
//						payActJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						payActJT.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						payActJT.requestFocus();
//					} else if (index == 4) { // 5-进账单
//						payActJT.requestFocus();
//					} else if (index == 5) { // 6-现金解款单
//						recActJT.requestFocus();
//					} else if (index == 6) { // 7-托收凭证
//						payNameJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//		// 付款人账号/卡号
//		JLabel payActJL = new JLabel("付款人账号/卡号：");
//		payActJL.setFont(new Font("宋体", Font.BOLD, 17));
//		payActJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActJL.setBounds(lx - 56, ly + 2 * Constants.Y, 162, 30);
//		panel.add(payActJL);
//
//		payActJT = new JTextField();
//		payActJT.setFont(new Font("宋体", Font.BOLD, 17));
//		payActJT.setBounds(jx, jy + 2 * Constants.Y, 405, 30);
//		panel.add(payActJT);
//		payActJT.setColumns(10);
//		payActJT.setDocument(new LengthDocument(22));
//		// Enter回车事件处理
//		payActJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-转账支票+进账单
//						payNameJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						payNameJT.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						payNameJT.requestFocus();
//					} else if (index == 4) { // 5-进账单
//						payNameJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 失去焦点事件
//		payActJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				String payAct = payActJT.getText().trim();
//				int index = credentialTypeCB.getSelectedIndex();
//				if (Tools.isNotEmpty(payAct)) {
//					if (payAct.length() == 22 && index != 6) { // 账号,去掉7-托收凭证
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//		// 付款人名称
//		JLabel payNameJL = new JLabel("付款人名称：");
//		payNameJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		payNameJL.setFont(new Font("宋体", Font.BOLD, 17));
//		payNameJL.setBounds(lx - 3, ly + 3 * Constants.Y, 109, 30);
//		panel.add(payNameJL);
//
//		payNameJT = new JTextField();
//		payNameJT.setFont(new Font("宋体", Font.BOLD, 17));
//		payNameJT.setBounds(jx, jy + 3 * Constants.Y, 405, 30);
//		panel.add(payNameJT);
//		payNameJT.setColumns(10);
//		// Enter回车事件处理
//		payNameJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-转账支票+进账单
//						payActBankJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						payActBankJT.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						payActBankJT.requestFocus();
//					} else if (index == 4) { // 5-进账单
//						payActBankJT.requestFocus();
//					} else if (index == 6) { // 7-托收凭证
//						payActProvinceJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//		// 付款人地址
//		JLabel payActAddressJL = new JLabel("付款人地址：");
//		payActAddressJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActAddressJL.setFont(new Font("宋体", Font.BOLD, 17));
//		payActAddressJL.setBounds(lx - 3, ly + 4 * Constants.Y, 109, 30);
//		panel.add(payActAddressJL);
//
//		// 付款人省
//		payActProvinceJT = new JTextField();
//		payActProvinceJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActProvinceJT.setFont(new Font("宋体", Font.BOLD, 17));
//		payActProvinceJT.setBounds(jx, jy + 4 * Constants.Y, 165, 30);
//		panel.add(payActProvinceJT);
//		payActProvinceJT.setColumns(10);
//
//		// Enter回车事件处理
//		payActProvinceJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-托收凭证
//						payActCityJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		JLabel payActProvinceJL = new JLabel("省");
//		payActProvinceJL.setHorizontalAlignment(SwingConstants.CENTER);
//		payActProvinceJL.setFont(new Font("宋体", Font.BOLD, 17));
//		payActProvinceJL.setBounds(lx + 266, ly + 4 * Constants.Y, 30, 30);
//		panel.add(payActProvinceJL);
//
//		// 付款人市县
//		payActCityJT = new JTextField();
//		payActCityJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActCityJT.setFont(new Font("宋体", Font.BOLD, 17));
//		payActCityJT.setBounds(jx + 195, jy + 4 * Constants.Y, 165, 30);
//		panel.add(payActCityJT);
//		payActCityJT.setColumns(10);
//
//		// Enter回车事件处理
//		payActCityJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-托收凭证
//						payActBankJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		JLabel payActCityJL = new JLabel("市县");
//		payActCityJL.setHorizontalAlignment(SwingConstants.CENTER);
//		payActCityJL.setFont(new Font("宋体", Font.BOLD, 17));
//		payActCityJL.setBounds(lx + 468, ly + 4 * Constants.Y, 38, 30);
//		panel.add(payActCityJL);
//
//		// 付款人开户行
//		JLabel payActBankJL = new JLabel("付款人开户行：");
//		payActBankJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		payActBankJL.setFont(new Font("宋体", Font.BOLD, 17));
//		// payActBankJL.setBounds(113, 214, 135, 30);
//		payActBankJL.setBounds(lx - 28, ly + 5 * Constants.Y, 135, 30);
//		panel.add(payActBankJL);
//
//		payActBankJT = new JTextField();
//		payActBankJT.setFont(new Font("宋体", Font.BOLD, 17));
//		// payActBankJT.setBounds(247, 214, 405, 30);
//		payActBankJT.setBounds(jx, jy + 5 * Constants.Y, 405, 30);
//		panel.add(payActBankJT);
//		payActBankJT.setColumns(10);
//		// Enter回车事件处理
//		payActBankJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-转账支票+进账单
//						recActJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						recActJT.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						recActJT.requestFocus();
//					} else if (index == 4) { // 5-进账单
//						recActJT.requestFocus();
//					} else if (index == 6) { // 7-托收凭证
//						recActJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// 收款人账号/卡号
//		JLabel recActJL = new JLabel("收款人账号/卡号：");
//		recActJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		recActJL.setFont(new Font("宋体", Font.BOLD, 17));
//		recActJL.setBounds(lx - 56, ly + 6 * Constants.Y, 162, 30);
//		panel.add(recActJL);
//
//		recActJT = new JTextField();
//		recActJT.setFont(new Font("宋体", Font.BOLD, 17));
//		recActJT.setBounds(jx, jy + 6 * Constants.Y, 405, 30);
//		panel.add(recActJT);
//		recActJT.setColumns(10);
//		// Enter回车事件处理
//		recActJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-转账支票+进账单
//						revNameJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						revNameJT.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						revNameJT.requestFocus();
//					} else if (index == 4) { // 5-进账单
//						revNameJT.requestFocus();
//					} else if (index == 5) { // 6-现金解款单
//						revNameJT.requestFocus();
//					} else if (index == 6) { // 7-托收凭证
//						revNameJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 失去焦点事件
//		recActJT.addFocusListener(new FocusListener() {
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				String recAct = recActJT.getText().trim();
//				int index = credentialTypeCB.getSelectedIndex();
//				if (Tools.isNotEmpty(recAct)) {
//					if (recAct.length() == 22 && index != 6) { // 托收凭证不回显
//						revActBankJT.setText(Tools.accountOnBlur(recAct));
//					}
//				}
//			}
//		});
//
//		// 收款人名称
//		JLabel revNameJL = new JLabel("收款人名称：");
//		revNameJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		revNameJL.setFont(new Font("宋体", Font.BOLD, 17));
//		revNameJL.setBounds(lx - 3, ly + 7 * Constants.Y, 110, 30);
//		panel.add(revNameJL);
//
//		revNameJT = new JTextField();
//		revNameJT.setFont(new Font("宋体", Font.BOLD, 17));
//		revNameJT.setBounds(jx, jy + 7 * Constants.Y, 405, 30);
//		panel.add(revNameJT);
//		revNameJT.setColumns(10);
//		// Enter回车事件处理
//		revNameJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-现金支票
//						amountJT.requestFocus();
//					} else if (index == 1) { // 2-转账支票+进账单
//						revActBankJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						revActBankJT.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						revActBankJT.requestFocus();
//					} else if (index == 4) { // 5-进账单
//						revActBankJT.requestFocus();
//					} else if (index == 5) { // 6-现金解款单
//						revActBankJT.requestFocus();
//					} else if (index == 6) { // 7-托收凭证
//						revActProvinceJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// 收款人地址
//		JLabel revActAddressJL = new JLabel("收款人地址：");
//		revActAddressJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		revActAddressJL.setFont(new Font("宋体", Font.BOLD, 17));
//		revActAddressJL.setBounds(lx - 3, ly + 8 * Constants.Y, 109, 30);
//		panel.add(revActAddressJL);
//
//		// 收款人省
//		revActProvinceJT = new JTextField();
//		revActProvinceJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		revActProvinceJT.setFont(new Font("宋体", Font.BOLD, 17));
//		revActProvinceJT.setBounds(jx, jy + 8 * Constants.Y, 165, 30);
//		panel.add(revActProvinceJT);
//		revActProvinceJT.setColumns(10);
//
//		// Enter回车事件处理
//		revActProvinceJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-托收凭证
//						revActCityJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		JLabel revActProvinceJL = new JLabel("省");
//		revActProvinceJL.setHorizontalAlignment(SwingConstants.CENTER);
//		revActProvinceJL.setFont(new Font("宋体", Font.BOLD, 17));
//		revActProvinceJL.setBounds(lx + 266, ly + 8 * Constants.Y, 30, 30);
//		panel.add(revActProvinceJL);
//
//		// 收款人市县
//		revActCityJT = new JTextField();
//		revActCityJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		revActCityJT.setFont(new Font("宋体", Font.BOLD, 17));
//		revActCityJT.setBounds(jx + 195, jy + 8 * Constants.Y, 165, 30);
//		panel.add(revActCityJT);
//		revActCityJT.setColumns(10);
//
//		// Enter回车事件处理
//		revActCityJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-托收凭证
//						revActBankJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		JLabel revActCityJL = new JLabel("市县");
//		revActCityJL.setHorizontalAlignment(SwingConstants.CENTER);
//		revActCityJL.setFont(new Font("宋体", Font.BOLD, 17));
//		revActCityJL.setBounds(lx + 468, ly + 8 * Constants.Y, 38, 30);
//		panel.add(revActCityJL);
//
//		// 收款人开户行
//		JLabel revActBankJL = new JLabel("收款人开户行：");
//		revActBankJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		revActBankJL.setFont(new Font("宋体", Font.BOLD, 17));
//		revActBankJL.setBounds(lx - 28, ly + 9 * Constants.Y, 135, 30);
//		panel.add(revActBankJL);
//
//		revActBankJT = new JTextField();
//		revActBankJT.setHorizontalAlignment(SwingConstants.LEFT);
//		revActBankJT.setFont(new Font("宋体", Font.BOLD, 17));
//		revActBankJT.setBounds(jx, jy + 9 * Constants.Y, 405, 30);
//		panel.add(revActBankJT);
//		revActBankJT.setColumns(10);
//		// Enter回车事件处理
//		revActBankJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 1) { // 2-转账支票+进账单
//						amountJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						amountJT.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						amountJT.requestFocus();
//					} else if (index == 4) { // 5-进账单
//						amountJT.requestFocus();
//					} else if (index == 5) { // 6-现金解款单
//						amountJT.requestFocus();
//					} else if (index == 6) { // 7-托收凭证
//						amountJT.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// 交易金额
//		JLabel amountJL = new JLabel("交易金额：");
//		amountJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		amountJL.setFont(new Font("宋体", Font.BOLD, 17));
//		amountJL.setBounds(lx + 15, ly + 10 * Constants.Y, 90, 30);
//		panel.add(amountJL);
//
//		amountJT = new JTextField();
//		amountJT.setHorizontalAlignment(SwingConstants.RIGHT);
//		amountJT.setFont(new Font("宋体", Font.BOLD, 17));
//		amountJT.setBounds(jx, jy + 10 * Constants.Y, 405, 30);
//		panel.add(amountJT);
//		amountJT.setColumns(10);
//		amountJT.setDocument(new AmountDocument(12));
//
//		// 按键释放事件
//		amountJT.addKeyListener(new KeyAdapter() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-现金支票
//						paymentCodeJT.requestFocus();
//					} else if (index == 1) { // 2-转账支票+进账单
//						paymentCodeJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						paymentCodeJT.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						usageJT.requestFocus();
//					} else if (index == 4) { // 5-进账单
//						printButton.requestFocus();
//					} else if (index == 5) { // 6-现金解款单
//						usageJT.requestFocus();
//					} else if (index == 6) { // 7-托收凭证
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
//		// 失去焦点事件
//		amountJT.addFocusListener(new FocusListener() {
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				int index = credentialTypeCB.getSelectedIndex();
//				if (index == -1) {
//					credentialTypeCB.requestFocus();
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				String amount = amountJT.getText().trim();
//				String bigAmount = "";
//				if (Tools.isNotEmpty(amount)) {
//					if (amount.contains(".")) { // 输入小数金额
//						if (amount.split("\\.")[0].length() > 9) { // 只能输到9亿
//							JOptionPane.showMessageDialog(null, "输入金额过大！", "提示", JOptionPane.DEFAULT_OPTION);
//							amountJT.requestFocus();
//							return;
//						}
//						if (amount.split("\\.")[1].length() > 2) {
//							JOptionPane.showMessageDialog(null, "输入金额格式错误！", "提示", JOptionPane.DEFAULT_OPTION);
//							amountJT.requestFocus();
//							return;
//						}
//					} else { // 输入纯整数金额
//						if (amount.length() > 9) { // 只能输到9亿
//							JOptionPane.showMessageDialog(null, "输入金额过大！", "提示", JOptionPane.DEFAULT_OPTION);
//							amountJT.requestFocus();
//							return;
//						}
//					}
//					bigAmount = MoneyUtil.amountToChinese(amount);
//				}
//				// 回显大写金额
//				bigAmountJT.setText(bigAmount);
//				// 凭证类型
//				int index = credentialTypeCB.getSelectedIndex();
//				// 1-现金支票，2-转账支票+进账单,3-单位业务委托书
//				if (index == 0 || index == 1 || index == 2) {
//					paymentCodeJT.requestFocus();
//				} else if (index == 3 || index == 5) { // 4-个人业务委托书、6-现金解款单
//					usageJT.requestFocus();
//				} else if (index == 4) { // 5-进账单
//					printButton.requestFocus();
//				} else if (index == 6) { // 7-托收凭证
//					tspjNameJT.requestFocus();
//				}
//			}
//		});
//
//		// 大写金额
//		JLabel bigAmountJL = new JLabel("大写金额：");
//		bigAmountJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		bigAmountJL.setFont(new Font("宋体", Font.BOLD, 17));
//		bigAmountJL.setBounds(lx + 15, ly + 11 * Constants.Y, 90, 30);
//		panel.add(bigAmountJL);
//
//		bigAmountJT = new JTextField();
//		bigAmountJT.setFont(new Font("宋体", Font.BOLD, 17));
//		bigAmountJT.setBounds(jx, jy + 11 * Constants.Y, 405, 30);
//		panel.add(bigAmountJT);
//		bigAmountJT.setColumns(10);
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// 支付密码
//		JLabel paymentCodeJL = new JLabel("支付密码：");
//		paymentCodeJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		paymentCodeJL.setFont(new Font("宋体", Font.BOLD, 17));
//		paymentCodeJL.setBounds(lx + 15, ly + 12 * Constants.Y, 90, 30);
//		panel.add(paymentCodeJL);
//
//		paymentCodeJT = new JTextField();
//		paymentCodeJT.setFont(new Font("宋体", Font.BOLD, 17));
//		paymentCodeJT.setBounds(jx, jy + 12 * Constants.Y, 405, 30);
//		panel.add(paymentCodeJT);
//		paymentCodeJT.setColumns(10);
//		paymentCodeJT.setDocument(new PaymentCodeDocument(16));
//
//		// 逢4位自动补-
//		paymentCodeJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				// enter回车键处理
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-现金支票
//						usageJT.requestFocus();
//					} else if (index == 1) { // 2-转账支票+进账单
//						usageJT.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
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
//		// 焦点事件
//		paymentCodeJT.addFocusListener(new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				String paymentCode = paymentCodeJT.getText().trim();
//				paymentCodeJT.setDocument(new PaymentCodeDocument(19));
//				// 补-
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//				String paymentCode = paymentCodeJT.getText().trim();
//				paymentCodeJT.setDocument(new PaymentCodeDocument(16));
//				paymentCodeJT.setText(paymentCode.replace("-", ""));
//			}
//		});
//
//		// 用途
//		JLabel usageJL = new JLabel("用   途：");
//		usageJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		usageJL.setFont(new Font("宋体", Font.BOLD, 17));
//		usageJL.setBounds(lx + 15, ly + 13 * Constants.Y, 93, 30);
//		panel.add(usageJL);
//
//		usageJT = new JTextField();
//		usageJT.setFont(new Font("宋体", Font.BOLD, 17));
//		usageJT.setBounds(jx, jy + 13 * Constants.Y, 405, 30);
//		panel.add(usageJT);
//		usageJT.setColumns(10);
//		// Enter回车事件处理
//		usageJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 0) { // 1-现金支票
//						printButton.requestFocus();
//					} else if (index == 1) { // 2-转账支票+进账单
//						printButton.requestFocus();
//					} else if (index == 2) { // 3-单位业务委托书
//						printButton.requestFocus();
//					} else if (index == 3) { // 4-个人业务委托书
//						printButton.requestFocus();
//					} else if (index == 5) { // 6-现金解款单
//						printButton.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// 托收凭据名称
//		JLabel tspjNameJL = new JLabel("托收凭据名称：");
//		tspjNameJL.setHorizontalAlignment(SwingConstants.RIGHT);
//		tspjNameJL.setFont(new Font("宋体", Font.BOLD, 17));
//		tspjNameJL.setBounds(lx - 28, ly + 14 * Constants.Y, 135, 30);
//		panel.add(tspjNameJL);
//
//		tspjNameJT = new JTextField();
//		tspjNameJT.setFont(new Font("宋体", Font.BOLD, 17));
//		tspjNameJT.setBounds(jx, jy + 14 * Constants.Y, 405, 30);
//		panel.add(tspjNameJT);
//		tspjNameJT.setColumns(10);
//		// Enter回车事件处理
//		tspjNameJT.addKeyListener(new KeyAdapter() {
//			public void keyPressed(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					int index = credentialTypeCB.getSelectedIndex();
//					if (index == 6) { // 7-托收凭证
//						printButton.requestFocus();
//					}
//				}
//			}
//		});
//		// 焦点事件
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
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					return;
//				}
//			}
//		});
//
//		// 打印
//		printButton = new JButton("打  印");
//		printButton.setFont(new Font("宋体", Font.BOLD, 17));
//		printButton.setBounds(px - 90, py, 93, 30);
//		panel.add(printButton);
//		printButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
//		// 打印事件
//		printButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int ind = 0; // 0-是
//				// 凭证类型
//				int index = credentialTypeCB.getSelectedIndex();
//				// 票据日期
//				String noteDate = noteDateJT.getText().trim();
//				// 付款人账号或卡号
//				String payAct = payActJT.getText().trim();
//				// 付款人名称
//				String payName = payNameJT.getText().trim();
//				// 付款人省
//				String payActProvince = payActProvinceJT.getText().trim();
//				// 付款人市县
//				String payActCity = payActCityJT.getText().trim();
//				// 付款人开户行
//				String payActBank = payActBankJT.getText().trim();
//				// 收款人账号或卡号
//				String recAct = recActJT.getText().trim();
//				// 收款人名称
//				String revName = revNameJT.getText().trim();
//				// 收款人省
//				String revActProvince = revActProvinceJT.getText().trim();
//				// 收款人市县
//				String revActCity = revActCityJT.getText().trim();
//				// 收款人开户行
//				String revActBank = revActBankJT.getText().trim();
//				// 交易金额
//				String amount = amountJT.getText().trim();
//				// 大写金额
//				String bigAmount = bigAmountJT.getText().trim();
//				// 支付密码
//				String paymentCode = paymentCodeJT.getText().trim();
//				// 用途
//				String usage = usageJT.getText().trim();
//				// 托收凭据名称
//				String tspjName = tspjNameJT.getText().trim();
//				// 打印前判断必输值是否必输
//				// 判断凭证类型是否输入
//				if (index == -1) {
//					JOptionPane.showMessageDialog(null, "凭证类型不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//					credentialTypeCB.requestFocus();
//					return;
//				}
//				// 判断票据日期是否输入
//				if (Tools.isEmpty(noteDate)) {
//					if (noteDateJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "票据日期不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						noteDateJT.requestFocus();
//						return;
//					}
//				}
//				// 判断付款人账号/卡号是否输入
//				if (Tools.isEmpty(payAct)) {
//					if (payActJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "付款人账号/卡号不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActJT.requestFocus();
//						return;
//					}
//				}
//				// 判断付款人名称是否输入
//				if (Tools.isEmpty(payName)) {
//					if (payNameJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "付款人名称不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//				}
//				// 判断付款人省是否输入
//				if (Tools.isEmpty(payActProvince)) {
//					if (payActProvinceJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "付款人省不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActProvinceJT.requestFocus();
//						return;
//					}
//				}
//				// 判断付款人市县是否输入
//				if (Tools.isEmpty(payActCity)) {
//					if (payActCityJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "付款人市县不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActCityJT.requestFocus();
//						return;
//					}
//				}
//				// 判断付款人开户行是否输入
//				if (Tools.isEmpty(payActBank)) {
//					if (payActBankJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "付款人开户行不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//				}
//				// 判断收款人账号或卡号是否输入
//				if (Tools.isEmpty(recAct)) {
//					if (recActJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "收款人账号/卡号不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//				}
//				// 判断收款人名称是否输入
//				if (Tools.isEmpty(revName)) {
//					if (revNameJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "收款人名称不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//				}
//				// 判断收款人省是否输入
//				if (Tools.isEmpty(revActProvince)) {
//					if (revActProvinceJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "收款人省不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActProvinceJT.requestFocus();
//						return;
//					}
//				}
//				// 判断收款人市县是否输入
//				if (Tools.isEmpty(revActCity)) {
//					if (revActCityJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "收款人市县不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActCityJT.requestFocus();
//						return;
//					}
//				}
//				// 判断收款人开户行是否输入
//				if (Tools.isEmpty(revActBank)) {
//					if (revActBankJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "收款人开户行不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//				}
//				// 判断交易金额是否输入
//				if (Tools.isEmpty(amount)) {
//					if (amountJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "交易金额不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						amountJT.requestFocus();
//						return;
//					}
//				}
//				// 判断用途是否输入
//				if (Tools.isEmpty(usage)) {
//					if (usageJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "用途不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//				}
//				// 判断托收凭据名称是否输入
//				if (Tools.isEmpty(tspjName)) {
//					if (tspjNameJT.getBackground() == Color.yellow) {
//						JOptionPane.showMessageDialog(null, "托收凭据名称不能为空！", "提示", JOptionPane.DEFAULT_OPTION);
//						tspjNameJT.requestFocus();
//						return;
//					}
//				}
//				if (index == 0) { // 1-现金支票
//					// 收款人名称最多46字
//					if (revName.length() > 46) {
//						JOptionPane.showMessageDialog(null, "收款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					// 用途最多20字
//					if (usage.length() > 20) {
//						JOptionPane.showMessageDialog(null, "用途超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.XJZPTIP, "提示", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-否
//						return;
//					}
//					// 调用打印主体
//					MoneyCashApplication mca = new MoneyCashApplication();
//					// 年
//					mca.year = Tools.converToCapitalDate(noteDate)[0];
//					// 月
//					mca.month = Tools.converToCapitalDate(noteDate)[1];
//					// 日
//					mca.day = Tools.converToCapitalDate(noteDate)[2];
//					// 收款人名称
//					mca.revName = revName;
//					// 大写金额
//					mca.bigAmount = bigAmount;
//					// 支付密码
//					mca.paymentCode = paymentCode;
//					// 用途
//					mca.usage = usage;
//					Tools.printVC(mca);
//				} else if (index == 1) { // 2-转账支票+进账单
//					if (payName.length() > 32) { // 付款人名称32
//						JOptionPane.showMessageDialog(null, "付款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 32) { // 付款人开户行32
//						JOptionPane.showMessageDialog(null, "付款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // 收款人账号28
//						JOptionPane.showMessageDialog(null, "收款人账号超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 32) { // 收款人名称32
//						JOptionPane.showMessageDialog(null, "收款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 32) { // 收款人开户行32
//						JOptionPane.showMessageDialog(null, "收款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					// 用途最多20字
//					if (usage.length() > 20) {
//						JOptionPane.showMessageDialog(null, "用途超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.ZZZPTIP, "提示", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-否
//						return;
//					}
//					// 转账支票调用打印主体
//					ChequeForTransferApplication cft = new ChequeForTransferApplication();
//					// 年
//					cft.year = Tools.converToCapitalDate(noteDate)[0];
//					// 月
//					cft.month = Tools.converToCapitalDate(noteDate)[1];
//					// 日
//					cft.day = Tools.converToCapitalDate(noteDate)[2];
//					// 收款人名称
//					cft.revName = revName;
//					// 大写金额
//					cft.bigAmount = bigAmount;
//					// 支付密码
//					cft.paymentCode = paymentCode;
//					// 用途
//					cft.usage = usage;
//					Tools.printVC(cft);
//					ind = JOptionPane.showConfirmDialog(null, Constants.JZDTIP, "提示", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-否
//						return;
//					}
//					// 进账单调用打印主体
//					IncomeReceiptsApplication ira = new IncomeReceiptsApplication();
//					// 票据日期
//					ira.noteDate = noteDate.replace("-", "    ");
//					// 付款人账号或卡号
//					ira.payAct = payAct;
//					// 付款人名称
//					ira.payName = payName;
//					// 付款人开户行
//					ira.payActBank = payActBank;
//					// 收款人账号或卡号
//					ira.recAct = recAct;
//					// 收款人名称
//					ira.revName = revName;
//					// 收款人开户行
//					ira.revActBank = revActBank;
//					// 大写金额
//					ira.bigAmount = bigAmount;
//					Tools.printVC(ira);
//				} else if (index == 2) { // 3-单位业务委托书
//					if (payName.length() > 38) { // 付款人名称38
//						JOptionPane.showMessageDialog(null, "付款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 38) { // 付款人开户行38
//						JOptionPane.showMessageDialog(null, "付款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // 收款人账号28
//						JOptionPane.showMessageDialog(null, "收款人账号超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 38) { // 收款人名称38
//						JOptionPane.showMessageDialog(null, "收款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 38) { // 收款人开户行38
//						JOptionPane.showMessageDialog(null, "收款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					if (usage.length() > 46) { // 用途46
//						JOptionPane.showMessageDialog(null, "用途超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.DWYWWTSTIP, "提示", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-否
//						return;
//					}
//					// 调用打印主体
//					PublicAttorneyApplication paa = new PublicAttorneyApplication();
//					// 票据日期
//					paa.noteDate = noteDate.replace("-", "   ");
//					// 付款人账号或卡号
//					paa.payAct = payAct;
//					// 付款人名称
//					paa.payName = payName;
//					// 付款人开户行
//					paa.payActBank = payActBank;
//					// 收款人账号或卡号
//					paa.recAct = recAct;
//					// 收款人名称
//					paa.revName = revName;
//					// 收款人开户行
//					paa.revActBank = revActBank;
//					// 大写金额
//					paa.bigAmount = bigAmount;
//					// 支付密码
//					paa.paymentCode = paymentCode;
//					// 用途
//					paa.usage = usage;
//					Tools.printVC(paa);
//				} else if (index == 3) { // 4-个人业务委托书
//					if (payName.length() > 16) { // 付款人名称16
//						JOptionPane.showMessageDialog(null, "付款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 44) { // 付款人开户行44
//						JOptionPane.showMessageDialog(null, "付款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // 收款人账号28
//						JOptionPane.showMessageDialog(null, "收款人账号超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 44) { // 收款人名称44
//						JOptionPane.showMessageDialog(null, "收款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 44) { // 收款人开户行44
//						JOptionPane.showMessageDialog(null, "收款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					if (usage.length() > 26) { // 用途26
//						JOptionPane.showMessageDialog(null, "用途超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.GRYWWTSTIP, "提示", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-否
//						return;
//					}
//					// 调用打印主体
//					PersonAttorneyApplication paa = new PersonAttorneyApplication();
//					// 票据日期
//					paa.noteDate = noteDate.replace("-", "  ");
//					// 付款人账号或卡号
//					paa.payAct = payAct;
//					// 付款人名称
//					paa.payName = payName;
//					// 付款人开户行
//					paa.payActBank = payActBank;
//					// 收款人账号或卡号
//					paa.recAct = recAct;
//					// 收款人名称
//					paa.revName = revName;
//					// 收款人开户行
//					paa.revActBank = revActBank;
//					// 大写金额
//					paa.bigAmount = bigAmount;
//					// 用途
//					paa.usage = usage;
//					Tools.printVC(paa);
//				} else if (index == 4) { // 5-进账单
//					if (payName.length() > 32) { // 付款人名称32
//						JOptionPane.showMessageDialog(null, "付款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 32) { // 付款人开户行32
//						JOptionPane.showMessageDialog(null, "付款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // 收款人账号28
//						JOptionPane.showMessageDialog(null, "收款人账号超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 32) { // 收款人名称32
//						JOptionPane.showMessageDialog(null, "收款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 32) { // 收款人开户行32
//						JOptionPane.showMessageDialog(null, "收款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.JZDTIP, "提示", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-否
//						return;
//					}
//					// 调用打印主体
//					IncomeReceiptsApplication ira = new IncomeReceiptsApplication();
//					// 票据日期
//					ira.noteDate = noteDate.replace("-", "    ");
//					// 付款人账号或卡号
//					ira.payAct = payAct;
//					// 付款人名称
//					ira.payName = payName;
//					// 付款人开户行
//					ira.payActBank = payActBank;
//					// 收款人账号或卡号
//					ira.recAct = recAct;
//					// 收款人名称
//					ira.revName = revName;
//					// 收款人开户行
//					ira.revActBank = revActBank;
//					// 大写金额
//					ira.bigAmount = bigAmount;
//					Tools.printVC(ira);
//				} else if (index == 5) { // 6-现金解款单
//					if (recAct.length() > 28) { // 收款人账号28
//						JOptionPane.showMessageDialog(null, "收款人账号超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 36) { // 收款人名称36
//						JOptionPane.showMessageDialog(null, "收款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 36) { // 收款人开户行36
//						JOptionPane.showMessageDialog(null, "收款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					if (usage.length() > 34) { // 用途34
//						JOptionPane.showMessageDialog(null, "用途超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						usageJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.XJCPTIP, "提示", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-否
//						return;
//					}
//					// 调用打印主体
//					CashRemittanceNoteApplication cna = new CashRemittanceNoteApplication();
//					// 票据日期
//					cna.noteDate = noteDate.replace("-", "    ");
//					// 收款人账号或卡号
//					cna.recAct = recAct;
//					// 收款人名称
//					cna.revName = revName;
//					// 收款人开户行
//					cna.revActBank = revActBank;
//					// 大写金额
//					cna.bigAmount = bigAmount;
//					// 用途
//					cna.usage = usage;
//					Tools.printVC(cna);
//				} else if (index == 6) { // 7-托收凭证
//					if (payName.length() > 32) { // 付款人名称32
//						JOptionPane.showMessageDialog(null, "付款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payNameJT.requestFocus();
//						return;
//					}
//					if (payActProvince.length() > 3) { // 付款人省3
//						JOptionPane.showMessageDialog(null, "付款人省超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActProvinceJT.requestFocus();
//						return;
//					}
//					if (payActCity.length() > 4) { // 付款人市县4
//						JOptionPane.showMessageDialog(null, "付款人市县超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActCityJT.requestFocus();
//						return;
//					}
//					if (payActBank.length() > 8) { // 付款人开户行8
//						JOptionPane.showMessageDialog(null, "付款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						payActBankJT.requestFocus();
//						return;
//					}
//					if (recAct.length() > 28) { // 收款人账号28
//						JOptionPane.showMessageDialog(null, "收款人账号超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						recActJT.requestFocus();
//						return;
//					}
//					if (revName.length() > 32) { // 收款人名称32
//						JOptionPane.showMessageDialog(null, "收款人名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revNameJT.requestFocus();
//						return;
//					}
//					if (revActProvince.length() > 3) { // 收款人省3
//						JOptionPane.showMessageDialog(null, "收款人省超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActProvinceJT.requestFocus();
//						return;
//					}
//					if (revActCity.length() > 4) { // 收款人市县4
//						JOptionPane.showMessageDialog(null, "收款人市县超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActCityJT.requestFocus();
//						return;
//					}
//					if (revActBank.length() > 8) { // 收款人开户行8
//						JOptionPane.showMessageDialog(null, "收款人开户行超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						revActBankJT.requestFocus();
//						return;
//					}
//					if (tspjName.length() > 13) { // 托收凭据名称13
//						JOptionPane.showMessageDialog(null, "托收凭据名称超长！", "提示", JOptionPane.DEFAULT_OPTION);
//						tspjNameJT.requestFocus();
//						return;
//					}
//					ind = JOptionPane.showConfirmDialog(null, Constants.TSPZTIP, "提示", JOptionPane.YES_NO_OPTION);
//					if (ind == 1) { // 1-否
//						return;
//					}
//					// 调用打印主体
//					CollectionCertificateApplication cca = new CollectionCertificateApplication();
//					// 票据日期
//					cca.noteDate = noteDate.replace("-", "   ");
//					// 付款人账号或卡号
//					cca.payAct = payAct;
//					// 付款人名称
//					cca.payName = payName;
//					// 付款人省
//					cca.payActProvince = payActProvince;
//					// 付款人市县
//					cca.payActCity = payActCity;
//					// 付款人开户行
//					cca.payActBank = payActBank;
//					// 收款人账号或卡号
//					cca.recAct = recAct;
//					// 收款人名称
//					cca.revName = revName;
//					// 收款人省
//					cca.revActProvince = revActProvince;
//					// 收款人市县
//					cca.revActCity = revActCity;
//					// 收款人开户行
//					cca.revActBank = revActBank;
//					// 大写金额
//					cca.bigAmount = bigAmount;
//					// 托收凭据名称
//					cca.tspjName = tspjName;
//					Tools.printVC(cca);
//				}
//			}
//		});
//		// 取消
//		JButton cancelButton = new JButton("取  消");
//		cancelButton.setFont(new Font("宋体", Font.BOLD, 17));
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
//		// 版权
//		JLabel copyJL = new JLabel("? 2017-2097 吴江农村商业银行 版权所有");
//		copyJL.setFont(new Font("宋体", Font.BOLD, 13));
//		copyJL.setBounds(cx, cy, 272, 22);
//		panel.add(copyJL);
//
//		// 打印须知
//		JLabel dyxzJL = new JLabel("打印须知：");
//		dyxzJL.setForeground(Color.RED);
//		dyxzJL.setBackground(Color.BLACK);
//		dyxzJL.setFont(new Font("宋体", Font.BOLD, 15));
//		dyxzJL.setBounds(dyx, dyy, 80, 22);
//		panel.add(dyxzJL);
//
//		JLabel firstJL = new JLabel("1、打印现金支票、转账支票请撕去存根后再打印；");
//		firstJL.setFont(new Font("宋体", Font.PLAIN, 13));
//		firstJL.setBounds(dyx, dyy + Constants.DYXZY, 380, 22);
//		panel.add(firstJL);
//
//		JLabel secondJL = new JLabel("2、客户凭证打印类型：现金支票、转账支票+进账单、单位业务");
//		secondJL.setFont(new Font("宋体", Font.PLAIN, 13));
//		secondJL.setBounds(dyx, dyy + 2 * Constants.DYXZY + 5, 380, 22);
//		panel.add(secondJL);
//
//		JLabel second_twoJL = new JLabel("委托书、个人业务委托书、进账单、现金解款单、托收凭证；");
//		second_twoJL.setFont(new Font("宋体", Font.PLAIN, 13));
//		second_twoJL.setBounds(dyx + 20, dyy + 3 * Constants.DYXZY, 380, 22);
//		panel.add(second_twoJL);
//
//		JLabel thirdJL = new JLabel("3、单位业务委托书为新版业务委托书，不支持旧版业务委托书；");
//		thirdJL.setFont(new Font("宋体", Font.PLAIN, 13));
//		thirdJL.setBounds(dyx, dyy + 4 * Constants.DYXZY + 3, 380, 22);
//		panel.add(thirdJL);
//
//		JLabel fourthJL = new JLabel("4、字符数的控制：按凭证实际可打印情况对字符数进行相应控");
//		fourthJL.setFont(new Font("宋体", Font.PLAIN, 13));
//		fourthJL.setBounds(dyx, dyy + 5 * Constants.DYXZY + 5, 380, 22);
//		panel.add(fourthJL);
//
//		JLabel fourth_twoJL = new JLabel("制，超长情况下程序会提示。");
//		fourth_twoJL.setFont(new Font("宋体", Font.PLAIN, 13));
//		fourth_twoJL.setBounds(dyx + 20, dyy + 6 * Constants.DYXZY, 200, 22);
//		panel.add(fourth_twoJL);
//	}
//
//	/**
//	 * 清空所有值
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
