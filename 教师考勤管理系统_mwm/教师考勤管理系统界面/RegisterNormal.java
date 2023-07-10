package 教师考勤管理系统界面;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import 数据库连接操作.SqlConnect;
import 系统后台操作.Account;
import 系统后台操作.Administrator;
import 系统后台操作.Bissextile;
import 系统后台操作.Main;
import 系统后台操作.Teacher;
import 系统后台操作.TeleorMail;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RegisterNormal extends JFrame {
	private JPanel contentPane;
	public java.net.URL imgURL = Login.class.getResource("/images/wrong.png");
	private ImageIcon icon_1;
	private int yearint;
	private int monthint;
	private int dateint;
	public static RegisterDialog registerdialog;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	/**
	 * Launch the application.
	 */
	
	public void paint(){
		BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
		UIManager.put("RootPane.setupButtonVisible", false);
		BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
		UIManager.put("Button.border", BorderFactory.createEmptyBorder());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					RegisterNormal frame = new RegisterNormal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public static void main(String[] args) {
//		BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
//		UIManager.put("RootPane.setupButtonVisible", false);
//		BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
//		UIManager.put("Button.border", BorderFactory.createEmptyBorder());
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//					RegisterNormal frame = new RegisterNormal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RegisterNormal() {
		Font font = new Font("微软雅黑", Font.BOLD, 14);
		int yearstart;
		String str[] = new String[70];		//年份，从当前到70年前
		
		String str1[] = new String[12];		//月份，12个月
		for(int i = 1; i <= 12; i++) {
			str1[i - 1] = Integer.toString(i);
		}
		
		String str2[] = new String[30];
		for(int i = 1; i <= 30; i++) {		//小月
			str2[i - 1] = Integer.toString(i);
		}
		
		String str3[] = new String[31];		//大月
		for(int i = 1; i <= 31; i++) {
			str3[i - 1] = Integer.toString(i);
		}
		
		String str4[] = new String[28];			//平年二月
		for(int i = 1; i <= 28; i++) {
			str4[i - 1] = Integer.toString(i);
		}
		
		String str5[] = new String[29];			//闰年二月
		for(int i = 1; i <= 29; i++) {
			str5[i - 1] = Integer.toString(i);
		}
		
		icon_1= new ImageIcon(imgURL);
		Color c = new Color(240, 240, 240);
		Color c1 = new Color(0, 102, 204);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(30, 30, 1000, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		BorderLayout BL = new BorderLayout(0, 0);
		panel.setLayout(BL);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		FlowLayout flowLayout_7 = (FlowLayout) panel_5.getLayout();
		flowLayout_7.setVgap(3);
		panel.add(panel_5, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setVgap(10);
		panel.add(panel_6, BorderLayout.SOUTH);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		FlowLayout flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setHgap(10);
		panel.add(panel_7, BorderLayout.WEST);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		FlowLayout flowLayout_5 = (FlowLayout) panel_8.getLayout();
		flowLayout_5.setVgap(10);
		panel.add(panel_8, BorderLayout.EAST);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_9, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u6CE8\u518C");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		panel_9.add(label);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(0);
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setHgap(0);
		flowLayout_3.setVgap(0);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setHgap(0);
		flowLayout_2.setVgap(0);
		contentPane.add(panel_3, BorderLayout.EAST);
		
		Dimension size = getSize();
		JPanel panel_4 = new RegisterPanel(size);
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_10.getLayout();
		panel_10.setBackground(c);
		panel_10.setOpaque(false);
		panel_4.add(panel_10, BorderLayout.NORTH);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(c);
		panel_11.setOpaque(false);
		panel_4.add(panel_11, BorderLayout.WEST);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_12.getLayout();
		flowLayout_9.setVgap(20);
		panel_12.setBackground(c);
		panel_12.setOpaque(false);
		panel_4.add(panel_12, BorderLayout.SOUTH);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(c);
		panel_13.setOpaque(false);
		panel_4.add(panel_13, BorderLayout.EAST);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(c);
		panel_14.setOpaque(false);
		panel_4.add(panel_14, BorderLayout.CENTER);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_14.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		panel_14.setLayout(gbl_panel_14);
		
		String time = null; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		time = sdf.format(new Date());
		String year = time.substring(0, 4);
		String month = time.substring(5, 7);
		String date = time.substring(8, 10);
		System.out.println(time);
		yearint = Integer.valueOf(year);		//当前时间
		monthint = Integer.valueOf(month);		//当前月份
		dateint = Integer.valueOf(date);		//当前日期
		yearstart = yearint - 69;		//起始年份
		
		for(int i = yearstart; i <= yearint; i++) {
			str[i - yearstart] = Integer.toString(i);
		}
		
		JSeparator js = new JSeparator(JSeparator.HORIZONTAL);
		panel.add(js, BL.SOUTH);
		js.setBackground(Color.BLACK);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7");
		label_1.setFont(font);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_14.add(label_1, gbc_label_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(font);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_14.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_18 = new JLabel("     ");
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 0;
		gbc_label_18.gridy = 1;
		panel_14.add(label_18, gbc_label_18);
		
		JLabel label_28 = new JLabel("     ");
		GridBagConstraints gbc_label_28 = new GridBagConstraints();
		gbc_label_28.gridwidth = 2;
		gbc_label_28.insets = new Insets(0, 0, 5, 5);
		gbc_label_28.gridx = 6;
		gbc_label_28.gridy = 1;
		panel_14.add(label_28, gbc_label_28);
		
		JLabel label_2 = new JLabel("\u59D3\u540D*");
		label_2.setFont(font);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel_14.add(label_2, gbc_label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(font);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_14.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel label_19 = new JLabel("     ");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.insets = new Insets(0, 0, 5, 5);
		gbc_label_19.gridx = 0;
		gbc_label_19.gridy = 3;
		panel_14.add(label_19, gbc_label_19);
		
		ButtonGroup bg = new ButtonGroup();
		
		JLabel label_23 = new JLabel("");
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.gridwidth = 2;
		gbc_label_23.insets = new Insets(0, 0, 5, 5);
		gbc_label_23.gridx = 1;
		gbc_label_23.gridy = 3;
		panel_14.add(label_23, gbc_label_23);
		
		JRadioButton radioButton = new JRadioButton("\u7537");
		radioButton.setSelected(true);
		radioButton.setFont(font);
		radioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 0;
		gbc_radioButton.gridy = 4;
		panel_14.add(radioButton, gbc_radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setFont(font);
		radioButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_1.gridx = 2;
		gbc_radioButton_1.gridy = 4;
		panel_14.add(radioButton_1, gbc_radioButton_1);
		
		bg.add(radioButton);
		bg.add(radioButton_1);
		
		JLabel label_20 = new JLabel("     ");
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.insets = new Insets(0, 0, 5, 5);
		gbc_label_20.gridx = 0;
		gbc_label_20.gridy = 5;
		panel_14.add(label_20, gbc_label_20);
		
		JLabel label_3 = new JLabel("\u51FA\u751F\u5E74\u6708");
		label_3.setFont(font);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 6;
		panel_14.add(label_3, gbc_label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(font);
		comboBox.setModel(new DefaultComboBoxModel(str));
		comboBox.setSelectedIndex(yearint - yearstart);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 6;
		panel_14.add(comboBox, gbc_comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(font);
		comboBox_1.setModel(new DefaultComboBoxModel(str1));
		comboBox_1.setSelectedIndex(monthint - 1);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 6;
		panel_14.add(comboBox_1, gbc_comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				int year1 = Integer.valueOf((String) comboBox.getSelectedItem());
				int month1 = Integer.valueOf((String) comboBox_1.getSelectedItem());
				Bissextile bissextile = new Bissextile(year1);
				if(month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
					comboBox_2.setModel(new DefaultComboBoxModel(str3));
					comboBox_2.setSelectedIndex(dateint - 1);
					System.out.println(dateint - 1);
				}else if(month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
					comboBox_2.setModel(new DefaultComboBoxModel(str2));
					comboBox_2.setSelectedIndex(dateint - 1);
				}else if(month1 == 2 && !bissextile.judge()) {
					comboBox_2.setModel(new DefaultComboBoxModel(str4));
					comboBox_2.setSelectedIndex(dateint - 1);
				}else {
					comboBox_2.setModel(new DefaultComboBoxModel(str5));
					comboBox_2.setSelectedIndex(dateint - 1);
				}
			}
		});
		comboBox_2.setFont(font);
		int year1 = Integer.valueOf((String) comboBox.getSelectedItem());
		int month1 = Integer.valueOf((String) comboBox_1.getSelectedItem());
		Bissextile bissextile = new Bissextile(year1);
		if(month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
			comboBox_2.setModel(new DefaultComboBoxModel(str3));
			comboBox_2.setSelectedIndex(dateint - 1);
			System.out.println(dateint - 1);
		}else if(month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
			comboBox_2.setModel(new DefaultComboBoxModel(str2));
			comboBox_2.setSelectedIndex(dateint - 1);
		}else if(month1 == 2 && !bissextile.judge()) {
			comboBox_2.setModel(new DefaultComboBoxModel(str4));
			comboBox_2.setSelectedIndex(dateint - 1);
		}else {
			comboBox_2.setModel(new DefaultComboBoxModel(str5));
			comboBox_2.setSelectedIndex(dateint - 1);
		}
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 6;
		panel_14.add(comboBox_2, gbc_comboBox_2);
		
		JLabel label_21 = new JLabel("     ");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.insets = new Insets(0, 0, 5, 5);
		gbc_label_21.gridx = 0;
		gbc_label_21.gridy = 7;
		panel_14.add(label_21, gbc_label_21);
		
		JLabel label_26 = new JLabel("     ");
		GridBagConstraints gbc_label_26 = new GridBagConstraints();
		gbc_label_26.gridwidth = 2;
		gbc_label_26.insets = new Insets(0, 0, 5, 5);
		gbc_label_26.gridx = 6;
		gbc_label_26.gridy = 7;
		panel_14.add(label_26, gbc_label_26);
		
		JLabel label_24 = new JLabel("     ");
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.gridwidth = 2;
		gbc_label_24.insets = new Insets(0, 0, 5, 0);
		gbc_label_24.gridx = 11;
		gbc_label_24.gridy = 7;
		panel_14.add(label_24, gbc_label_24);
		
		JLabel label_4 = new JLabel("\u7C4D\u8D2F");
		label_4.setFont(font);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 8;
		panel_14.add(label_4, gbc_label_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(font);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 8;
		panel_14.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel label_22 = new JLabel("     ");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.insets = new Insets(0, 0, 5, 5);
		gbc_label_22.gridx = 0;
		gbc_label_22.gridy = 9;
		panel_14.add(label_22, gbc_label_22);
		
		JLabel label_27 = new JLabel("     ");
		GridBagConstraints gbc_label_27 = new GridBagConstraints();
		gbc_label_27.gridwidth = 2;
		gbc_label_27.insets = new Insets(0, 0, 5, 5);
		gbc_label_27.gridx = 6;
		gbc_label_27.gridy = 9;
		panel_14.add(label_27, gbc_label_27);
		
		JLabel label_25 = new JLabel("     ");
		GridBagConstraints gbc_label_25 = new GridBagConstraints();
		gbc_label_25.gridwidth = 2;
		gbc_label_25.insets = new Insets(0, 0, 5, 0);
		gbc_label_25.gridx = 11;
		gbc_label_25.gridy = 9;
		panel_14.add(label_25, gbc_label_25);
		
		JLabel label_5 = new JLabel("政治面貌");
		label_5.setFont(font);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 10;
		panel_14.add(label_5, gbc_label_5);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(font);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\u7FA4\u4F17", "\u515A\u5458"}));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridwidth = 2;
		gbc_comboBox_3.gridx = 1;
		gbc_comboBox_3.gridy = 10;
		panel_14.add(comboBox_3, gbc_comboBox_3);
		
		JLabel label_16 = new JLabel("      ");
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 4;
		gbc_label_16.gridy = 0;
		panel_14.add(label_16, gbc_label_16);
		
		JLabel label_6 = new JLabel("身份证号*");
		label_6.setFont(font);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 5;
		gbc_label_6.gridy = 0;
		panel_14.add(label_6, gbc_label_6);
		
		textField_3 = new JTextField();
		textField_3.setFont(font);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.gridx = 6;
		gbc_textField_3.gridy = 0;
		panel_14.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(font);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.gridx = 6;
		gbc_textField_4.gridy = 2;
		panel_14.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("\u9009\u62E9\u7167\u7247");
		button.setFont(font);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 8;
		gbc_button.gridy = 2;
		panel_14.add(button, gbc_button);
		
		JLabel label_7 = new JLabel("学历");
		label_7.setFont(font);
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 5;
		gbc_label_7.gridy = 4;
		panel_14.add(label_7, gbc_label_7);
		
		textField_5 = new JTextField();
		textField_5.setFont(font);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridwidth = 2;
		gbc_textField_5.gridx = 6;
		gbc_textField_5.gridy = 4;
		panel_14.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel label_8 = new JLabel("学院*");
		label_8.setFont(font);
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 5;
		gbc_label_8.gridy = 6;
		panel_14.add(label_8, gbc_label_8);
		
		textField_6 = new JTextField();
		textField_6.setFont(font);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.gridx = 6;
		gbc_textField_6.gridy = 6;
		panel_14.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel label_9 = new JLabel("专业*");
		label_9.setFont(font);
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 5;
		gbc_label_9.gridy = 8;
		panel_14.add(label_9, gbc_label_9);
		
		textField_7 = new JTextField();
		textField_7.setFont(font);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridwidth = 2;
		gbc_textField_7.gridx = 6;
		gbc_textField_7.gridy = 8;
		panel_14.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel label_10 = new JLabel("职位");
		label_10.setFont(font);
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 0, 5);
		gbc_label_10.gridx = 5;
		gbc_label_10.gridy = 10;
		panel_14.add(label_10, gbc_label_10);
		
		textField_8 = new JTextField();
		textField_8.setFont(font);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 0, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridwidth = 2;
		gbc_textField_8.gridx = 6;
		gbc_textField_8.gridy = 10;
		panel_14.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JLabel label_17 = new JLabel("   ");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 9;
		gbc_label_17.gridy = 0;
		panel_14.add(label_17, gbc_label_17);
		
		JLabel label_11 = new JLabel("通讯地址");
		label_11.setFont(font);
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 10;
		gbc_label_11.gridy = 0;
		panel_14.add(label_11, gbc_label_11);
		
		textField_9 = new JTextField();
		textField_9.setFont(font);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridwidth = 2;
		gbc_textField_9.gridx = 11;
		gbc_textField_9.gridy = 0;
		panel_14.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JLabel label_12 = new JLabel("qq或微信");
		label_12.setFont(font);
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 10;
		gbc_label_12.gridy = 2;
		panel_14.add(label_12, gbc_label_12);
		
		textField_10 = new JTextField();
		textField_10.setFont(font);
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 0);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridwidth = 2;
		gbc_textField_10.gridx = 11;
		gbc_textField_10.gridy = 2;
		panel_14.add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		JLabel label_13 = new JLabel("联系电话或邮箱");
		label_13.setFont(font);
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 10;
		gbc_label_13.gridy = 4;
		panel_14.add(label_13, gbc_label_13);
		
		textField_11 = new JTextField();
		textField_11.setFont(font);
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 0);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridwidth = 2;
		gbc_textField_11.gridx = 11;
		gbc_textField_11.gridy = 4;
		panel_14.add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);
		
		JLabel label_14 = new JLabel("密码设定*");
		label_14.setFont(font);
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 10;
		gbc_label_14.gridy = 6;
		panel_14.add(label_14, gbc_label_14);
		
		passwordField = new JPasswordField();
		passwordField.setFont(font);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.gridx = 11;
		gbc_passwordField.gridy = 6;
		panel_14.add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);
		
		JLabel label_15 = new JLabel("密码确认");
		label_15.setFont(font);
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 10;
		gbc_label_15.gridy = 8;
		panel_14.add(label_15, gbc_label_15);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(font);
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridwidth = 2;
		gbc_passwordField_1.gridx = 11;
		gbc_passwordField_1.gridy = 8;
		panel_14.add(passwordField_1, gbc_passwordField_1);
		passwordField_1.setColumns(10);
		
		JButton button_1 = new JButton("确定");
		button_1.setFont(font);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.teacher = new Teacher();
				Main.adminor = new Administrator();
				Main.account = new Account();
				Main.account.identity = textField_3.getText();		//身份证号3
				String sql_1 = null;
				boolean exist = false;
				boolean exist_c_p = false;
				System.out.println(Main.account.identity);
				if(Main.account.identity.length() != 0) {
					sql_1 = "Select admin_no from admin_idenMWM where admin_identity = \'";
					sql_1 += Main.account.identity;
					sql_1 += "\'";
					try {
						Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
						Main.sqlconnect.rs=Main.sqlconnect.ps.executeQuery();
						while(SqlConnect.rs.next()) {
							Main.account.no = Main.sqlconnect.rs.getString(1);
							exist = true;
						}
						if(exist && Main.account.no == null) {	//如果在管理员表中存在该身份，就先检查姓名、性别、密码是否为空，再检查2次密码是否相同，最后增加一条信息，并且记录进一个管理员身份中
							Main.account.name = textField_1.getText();		//姓名1
							if(Main.account.name.length() == 0) {
								label_23.setFont(new Font("微软雅黑", Font.BOLD, 12));
								label_23.setIcon(icon_1);
								label_23.setText("姓名不能为空！");
							}else {
								if(radioButton.isSelected()) {
									Main.account.sex = "男";
								}else {
									Main.account.sex = "女";
								}
								Main.account.code = new String(passwordField.getPassword());
								if(Main.account.code.length() == 0) {
									label_24.setFont(new Font("微软雅黑", Font.BOLD, 12));
									label_24.setIcon(icon_1);
									label_24.setText("密码不能为空！");
								}else {
									String tmp = new String(passwordField_1.getPassword());
									if(!Main.account.code.equals(tmp)) {
										label_25.setFont(new Font("微软雅黑", Font.BOLD, 12));
										label_25.setIcon(icon_1);
										label_25.setText("两次输入的密码不一致！");
									}else {		//比较成功，可以注册管理员
										Main.adminor.name = Main.account.name;
										Main.adminor.identity = Main.account.identity;
										Main.adminor.code = Main.account.code;
										Main.adminor.position = textField_8.getText();		//职位8
										Main.adminor.picture = textField_4.getText();		//照片路径4
										Main.teleormail = new TeleorMail(textField_11.getText());		//联系电话和邮箱11
										if(Main.teleormail.judge()) {
											Main.adminor.mailbox = textField_11.getText();
										}else {
											Main.adminor.telephone = textField_11.getText();
										}
										Main.adminor.sex = Main.account.sex;
										SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
										Main.adminor.register_time = sdf.format(new Date());
										sql_1 = "Insert into adminMWM values(?,?,?,?,?,?,?,?,?)";
										try {
											Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
											Main.sqlconnect.ps.setString(1, "xxxxx");
											Main.sqlconnect.ps.setString(2, Main.adminor.name);
											Main.sqlconnect.ps.setString(3, Main.adminor.sex);
											Main.sqlconnect.ps.setString(4, Main.adminor.picture);
											Main.sqlconnect.ps.setString(5, Main.adminor.register_time);
											Main.sqlconnect.ps.setString(6, Main.adminor.position);
											Main.sqlconnect.ps.setString(7, Main.adminor.telephone);
											Main.sqlconnect.ps.setString(8, Main.adminor.mailbox);
											Main.sqlconnect.ps.setString(9, Main.adminor.code);
											try {
												Main.count_1 = Main.sqlconnect.ps.executeUpdate();
												System.out.println(Main.count_1);
												Main.sqlconnect.ct.commit();
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
//												if(Main.sqlconnect.ct!=null){
//										               try {
//										            	   SqlConnect.ct.rollback();
//										               } catch (SQLException e11) {
//										                   e11.printStackTrace();
//										               }
//										        }
												e1.printStackTrace();
											}//返回值表示增删改几条数据
											if(Main.count_1 == 1) {
												sql_1 = "select admin_no from adminMWM where id = @@IDENTITY";
												try {
													Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
													Main.sqlconnect.rs=Main.sqlconnect.ps.executeQuery();
													while(SqlConnect.rs.next()) {
														Main.adminor.no=Main.sqlconnect.rs.getString(1);
													}
												}catch(Exception e1) {
													e1.printStackTrace();
												}
												sql_1 = "update dbo.admin_idenMWM set admin_no = \'";
												sql_1 += Main.adminor.no + "\' ";
												sql_1 += "where admin_identity = \'" + Main.account.identity;
												sql_1 += "\'";
												try {
													Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
													Main.sqlconnect.stmt.executeUpdate(sql_1);
													Main.sqlconnect.ct.commit();
												}catch(Exception e1) {
													e1.printStackTrace();
												}
												registerdialog = new RegisterDialog("注册成功", "您的编号为"+Main.adminor.no);
												registerdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
												registerdialog.setVisible(true);
											}else {
												registerdialog = new RegisterDialog("注册失败", "请重新注册");
												registerdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
												registerdialog.setVisible(true);
											}
										}catch(Exception e1) {
											e1.printStackTrace();
										}
									}
								}
							}
					        
						}else if(Main.account.no != null) {
							registerdialog = new RegisterDialog("您的编号已存在！", "编号为" + Main.account.no);
							registerdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							registerdialog.setVisible(true);
						}
						else{		//如果管理员表中不存在，就去检查教师表中
							sql_1 = null;
							sql_1 = "Select * from teacher_idenMWM where teacher_identity = \'";
							sql_1 += Main.account.identity;
							sql_1 += "\'";
							try {
								Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
								Main.sqlconnect.rs=Main.sqlconnect.ps.executeQuery();
								while(SqlConnect.rs.next()) {
									Main.account.no = Main.sqlconnect.rs.getString(1);
									exist = true;
								}
								if(exist && Main.account.no == null) {	//如果在教师表中存在该身份，就先检查姓名、性别、密码、学院、专业是否为空，再检查2次密码是否相同，最后增加一条信息，并且记录进一个管理员身份中
									Main.account.name = textField_1.getText();
									if(Main.account.name.length() == 0) {
										label_23.setFont(new Font("微软雅黑", Font.BOLD, 12));
										label_23.setIcon(icon_1);
										label_23.setText("姓名不能为空！");
									}else {
										if(radioButton.isSelected()) {
											Main.account.sex = "男";
										}else {
											Main.account.sex = "女";
										}
										Main.account.college = textField_6.getText();	//学院6
										if(Main.account.college.length() == 0) {
											label_26.setFont(new Font("微软雅黑", Font.BOLD, 12));
											label_26.setIcon(icon_1);
											label_26.setText("学院不能为空！");
										}else {
											Main.account.profession = textField_7.getText();		//专业7
											if(Main.account.profession.length() == 0) {
												label_27.setFont(new Font("微软雅黑", Font.BOLD, 12));
												label_27.setIcon(icon_1);
												label_27.setText("专业不能为空！");
											}else {
												sql_1 = "Select college_profession from collegeMWM where college_name = \'";
												sql_1 += Main.account.college;
												sql_1 += "\' and profession_name = \'";
												sql_1 += Main.account.profession;
												sql_1 += "\'";
												try {
													Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
													Main.sqlconnect.rs=Main.sqlconnect.ps.executeQuery();
													while(SqlConnect.rs.next()) {
														Main.account.college_profession = Main.sqlconnect.rs.getString(1);
														exist_c_p = true;
													}
												}catch(SQLException e1) {
													e1.printStackTrace();
												}
												if(!exist_c_p) {
													label_27.setFont(new Font("微软雅黑", Font.BOLD, 12));
													label_27.setIcon(icon_1);
													label_27.setText("学院或专业不存在！");
												}else {
													Main.account.code = new String(passwordField.getPassword());
													if(Main.account.code.length() == 0) {
														label_24.setFont(new Font("微软雅黑", Font.BOLD, 12));
														label_24.setIcon(icon_1);
														label_24.setText("密码不能为空！");
													}else {
														String tmp = new String(passwordField_1.getPassword());
														if(!Main.account.code.equals(tmp)) {
															label_25.setFont(new Font("微软雅黑", Font.BOLD, 12));
															label_25.setIcon(icon_1);
															label_25.setText("两次输入的密码不一致！");
														}else {		//比较成功，可以注册管理员
															Main.teacher.no = "xxxxxxxxxx";
															Main.teacher.name = Main.account.name;
															Main.teacher.sex = Main.account.sex;
															Main.teacher.picture = textField_4.getText();
															String ryear = (String)comboBox.getSelectedItem();
															String rmonth = (String)comboBox_1.getSelectedItem();
															if(rmonth.length() == 1) {
																rmonth = '0'+ rmonth;
															}
															String rdate = (String)comboBox_2.getSelectedItem();
															if(rdate.length() == 1) {
																rdate = '0' + rdate;
															}
															Main.teacher.birth_year_month = ryear + "-" + rmonth + "-" + rdate; 
															SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
															Main.teacher.register_time = sdf.format(new Date());
															Main.teacher.politic = (String) comboBox_3.getSelectedItem();
															Main.teacher.hometown = textField_2.getText();
															Main.teacher.education = textField_5.getText();
															Main.teacher.position = textField_8.getText();
															Main.teleormail = new TeleorMail(textField_11.getText());
															if(Main.teleormail.judge()) {
																Main.teacher.mailbox = textField_11.getText();
															}else {
																Main.teacher.telephone = textField_11.getText();
															}
															Main.teacher.qqorwechat = textField_10.getText();
															Main.teacher.college = Main.account.college;
															Main.teacher.profession = Main.account.profession;
															Main.teacher.college_profession = Main.account.college_profession;
															Main.teacher.code = Main.account.code;
															Main.teacher.identity = Main.account.identity;
															
															sql_1 = "Insert into teacherMWM values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
															try {
																Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
																Main.sqlconnect.ps.setString(1, Main.teacher.no);
																Main.sqlconnect.ps.setString(2, Main.teacher.name);
																Main.sqlconnect.ps.setString(3, Main.teacher.sex);
																Main.sqlconnect.ps.setString(4, Main.teacher.picture);
																Main.sqlconnect.ps.setString(5, Main.teacher.birth_year_month);
																Main.sqlconnect.ps.setString(6, Main.teacher.register_time);
																Main.sqlconnect.ps.setString(7, Main.teacher.politic);
																Main.sqlconnect.ps.setString(8, Main.teacher.hometown);
																Main.sqlconnect.ps.setString(9, Main.teacher.education);
																Main.sqlconnect.ps.setString(10, Main.teacher.position);
																Main.sqlconnect.ps.setString(11, Main.teacher.telephone);
																Main.sqlconnect.ps.setString(12, Main.teacher.mailbox);
																Main.sqlconnect.ps.setString(13, Main.teacher.qqorwechat);
																Main.sqlconnect.ps.setString(14, Main.teacher.college_profession);
																Main.sqlconnect.ps.setString(15, Main.teacher.code);
																try {
																	Main.count_1 = Main.sqlconnect.ps.executeUpdate();
																	System.out.println(Main.count_1);
																	Main.sqlconnect.ct.commit();
																} catch (SQLException e1) {
																	// TODO Auto-generated catch block
//																	if(Main.sqlconnect.ct!=null){
//															               try {
//															            	   SqlConnect.ct.rollback();
//															               } catch (SQLException e11) {
//															                   e11.printStackTrace();
//															               }
//															        }
																	e1.printStackTrace();
																}//返回值表示增删改几条数据
																if(Main.count_1 == 1) {
																	sql_1 = "select teacher_no from teacherMWM where id = @@IDENTITY";
																	try {
																		Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
																		Main.sqlconnect.rs=Main.sqlconnect.ps.executeQuery();
																		while(SqlConnect.rs.next()) {
																			Main.teacher.no=Main.sqlconnect.rs.getString(1);
																		}
																	}catch(Exception e1) {
																		e1.printStackTrace();
																	}
																	sql_1 = "update dbo.teacher_idenMWM set teacher_no = \'";
																	sql_1 += Main.teacher.no + "\' ";
																	sql_1 += "where teacher_identity = \'" + Main.teacher.identity;
																	sql_1 += "\'";
																	try {
																		Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
																		Main.sqlconnect.stmt.executeUpdate(sql_1);
																		Main.sqlconnect.ct.commit();
																	}catch(Exception e1) {
																		e1.printStackTrace();
																	}
																	registerdialog = new RegisterDialog("注册成功", "您的编号为"+Main.teacher.no);
																	registerdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
																	registerdialog.setVisible(true);
																}else {
																	registerdialog = new RegisterDialog("注册失败", "请重新注册");
																	registerdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
																	registerdialog.setVisible(true);
																}
															}catch(Exception e1) {
																e1.printStackTrace();
															}
														}
													}
												}
											}
										}
									}
							        
								}else if(Main.account.no != null) {
									registerdialog = new RegisterDialog("您的编号已存在！", "编号为" + Main.account.no);
									registerdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									registerdialog.setVisible(true);
								}
								else {		//如果管理员表和教师表中都不存在，就显示出错
									label_28.setFont(new Font("微软雅黑", Font.BOLD, 12));
									label_28.setIcon(icon_1);
									label_28.setText("系统中无此身份证号！");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					label_28.setFont(new Font("微软雅黑", Font.BOLD, 12));
					label_28.setIcon(icon_1);
					label_28.setText("身份证号不能为空！");
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 10;
		gbc_button_1.gridy = 10;
		panel_14.add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("返回");
		button_2.setFont(font);
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main.login.paint();
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.EAST;
		gbc_button_2.gridx = 12;
		gbc_button_2.gridy = 10;
		panel_14.add(button_2, gbc_button_2);
		
	}
}

