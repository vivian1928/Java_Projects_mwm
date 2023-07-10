package 教师考勤管理系统界面;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import 数据库连接操作.SqlConnect;
import 系统后台操作.Administrator;
import 系统后台操作.Bissextile;
import 系统后台操作.ComboBoxNoButton;
import 系统后台操作.Main;
import 系统后台操作.TeleorMail;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InfoPanel extends JPanel {
	public static Image image = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private int yearint;
	private int monthint;
	private int dateint;
	private boolean lock = true;
	public static JRadioButton radioButton;
	public static JRadioButton radioButton_1;
	private String teleormail;
	/**
	 * Create the panel.
	 */
	public InfoPanel(Administrator admin) {
//		String filename = ".\\src\\images\\picture1.jpg";
		String filename = "";
		
		String str[] = new String[71];		//年份，从当前到70年前
		
		String str1[] = new String[13];		//月份，12个月
		for(int i = 1; i <= 12; i++) {
			str1[i - 1] = Integer.toString(i);
		}
		str1[12] = "";
		
		String str2[] = new String[31];
		for(int i = 1; i <= 30; i++) {		//小月
			str2[i - 1] = Integer.toString(i);
		}
		str2[30] = "";
		String str3[] = new String[32];		//大月
		for(int i = 1; i <= 31; i++) {
			str3[i - 1] = Integer.toString(i);
		}
		str3[31] = "";
		String str4[] = new String[29];			//平年二月
		for(int i = 1; i <= 28; i++) {
			str4[i - 1] = Integer.toString(i);
		}
		str4[28] = "";
		String str5[] = new String[30];			//闰年二月
		for(int i = 1; i <= 29; i++) {
			str5[i - 1] = Integer.toString(i);
		}
		str5[29] = "";
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
		int yearstart = yearint - 69;		//起始年份
		
		for(int i = yearstart; i <= yearint; i++) {
			str[i - yearstart] = Integer.toString(i);
		}
		str[70] = "";
		Dimension size_2 = new Dimension(580, 30);
		Dimension size_3 = new Dimension(20, 30);
		setBounds(100,100,950,563);
		if(admin.picture != null && admin.picture.length() != 0) {
			filename = admin.picture;
			image = new ImageIcon(filename).getImage();
		}
		Dimension size = new Dimension(24, 24);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(0);
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_3.getLayout();
		flowLayout_8.setVgap(0);
		add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel label_25 = new JLabel("");
		label_25.setPreferredSize(size_3);
		GridBagConstraints gbc_label_25 = new GridBagConstraints();
		gbc_label_25.insets = new Insets(0, 0, 5, 5);
		gbc_label_25.gridx = 0;
		gbc_label_25.gridy = 0;
		panel_5.add(label_25, gbc_label_25);
		
		JLabel label = new JLabel("\u57FA\u672C\u8D44\u6599");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel_5.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("");
		label_1.setPreferredSize(size_2);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel_5.add(label_1, gbc_label_1);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql = "";
				if(lock) {
					System.out.println("xxx");
					lock = false;		//可以修改	
					textField.setEditable(true);	//姓名
					textField.setOpaque(true);	//设置背景透明
					textField.setBorder(BorderFactory.createLineBorder(Color.black));	//设置边框透明
					radioButton.setEnabled(true);	//男
					radioButton_1.setEnabled(true);	//女
					textField_3.setOpaque(true);	//设置背景透明
					textField_3.setBorder(BorderFactory.createLineBorder(Color.black));	//设置边框透明
					textField_3.setEditable(true);	//职位可以
					textField_4.setEditable(true);			//联系电话或邮箱可以
					textField_4.setOpaque(true);	//设置背景透明
					textField_4.setBorder(BorderFactory.createLineBorder(Color.black));	//设置边框透明
				}else {		//修改完成
					lock = true;
					if(!admin.name.equals(textField.getText()) && textField.getText().length()!= 0) {
						admin.name = textField.getText();
						sql += "update adminMWM set admin_name = \'" + admin.name + "\' where admin_no = \'" + admin.no + "\'\n";
					}
					if(radioButton.isSelected() && admin.sex.equals("女")) {
						admin.sex = "男";
						sql += "update adminMWM set admin_sex = \'" + admin.sex + "\' where admin_no = \'" + admin.no + "\'\n";
					}else if(radioButton_1.isSelected() && admin.sex.equals("男")) {
						admin.sex = "女";
						sql += "update adminMWM set admin_sex = \'" + admin.sex + "\' where admin_no = \'" + admin.no + "\'\n";
					}
					if(admin.position == null && textField_3.getText().length()!= 0 ||!admin.position.equals(textField_3.getText()) && textField_3.getText().length()!= 0) {
						admin.position = textField_3.getText();
						sql += "update adminMWM set position = \'" + admin.position + "\' where admin_no = \'" + admin.no + "\'\n";
					}
					if(teleormail.length() == 0 && textField_4.getText().length()!= 0 || teleormail.equals(textField_4.getText())) {
						Main.teleormail = new TeleorMail(textField_4.getText());
						if(Main.teleormail.judge()) {
							admin.mailbox = textField_4.getText();
							admin.telephone = null;
							sql += "update adminMWM set admin_mailbox = \'" + admin.mailbox + "\' where admin_no = \'" + admin.no + "\'\n";
							sql += "update adminMWM set admin_telephone = \'" + admin.telephone + "\' where admin_no = \'" + admin.no + "\'\n";
						}else {
							admin.telephone = textField_4.getText();
							admin.mailbox = null;
							sql += "update adminMWM set admin_mailbox = \'" + admin.mailbox + "\' where admin_no = \'" + admin.no + "\'\n";
						}
					}
					if(sql.length() != 0) {
						try {
							Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql);
							Main.count_1 = Main.sqlconnect.ps.executeUpdate();
							Main.sqlconnect.ct.commit();
						}catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					textField.setOpaque(false);	//设置背景透明
					textField.setBorder(null);	//设置边框透明
					textField.setEditable(false);	//姓名可以
					radioButton.setEnabled(false);	//男可以
					radioButton_1.setEnabled(false);	//女可以
					textField_3.setEditable(false);		//职位可以
					textField_3.setOpaque(false);	//设置背景透明
					textField_3.setBorder(null);	//设置边框透明
					textField_4.setEditable(false);			//联系电话或邮箱可以
					textField_4.setOpaque(false);	//设置背景透明
					textField_4.setBorder(null);	//设置边框透明
				}
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 0;
		panel_5.add(button, gbc_button);
		
		JLabel label_19 = new JLabel("\u60A8\u53EF\u4EE5\u5728\u8FD9\u91CC\u67E5\u770B\u6216\u4FEE\u6539\u81EA\u5DF1\u7684\u4E2A\u4EBA\u4FE1\u606F");
		GridBagConstraints gbc_label_19 = new GridBagConstraints();
		gbc_label_19.insets = new Insets(0, 0, 0, 5);
		gbc_label_19.gridx = 1;
		gbc_label_19.gridy = 1;
		panel_5.add(label_19, gbc_label_19);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setHgap(0);
		panel_4.add(panel_6, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(0);
		panel_4.add(panel_7, BorderLayout.SOUTH);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.EAST);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_16.getLayout();
		flowLayout_2.setVgap(0);
		panel_9.add(panel_16, BorderLayout.NORTH);
		
		JPanel panel_17 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_17.getLayout();
		flowLayout_1.setHgap(0);
		panel_9.add(panel_17, BorderLayout.WEST);
		
		JPanel panel_18 = new JPanel();
		panel_9.add(panel_18, BorderLayout.EAST);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_21 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_21.getLayout();
		flowLayout_4.setVgap(0);
		panel_18.add(panel_21, BorderLayout.NORTH);
		
		JPanel panel_22 = new JPanel();
		panel_18.add(panel_22, BorderLayout.SOUTH);
		
		JPanel panel_23 = new JPanel();
		panel_18.add(panel_23, BorderLayout.WEST);
		
		JPanel panel_24 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_24.getLayout();
		panel_18.add(panel_24, BorderLayout.EAST);
		
		JPanel panel_25 = new JPanel();
		panel_18.add(panel_25, BorderLayout.CENTER);
		
		Dimension size_1 = new Dimension(133, 170);
		JLabel label_2 = new JLabel("");
		label_2.setPreferredSize(size_1);
		label_2.setIcon(SwingUtil.createAutoAdjustIcon(image, false));
		panel_25.add(label_2);
		
		JPanel panel_19 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_19.getLayout();
		flowLayout_3.setVgap(0);
		panel_9.add(panel_19, BorderLayout.SOUTH);
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10, BorderLayout.CENTER);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_10.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		panel_10.setLayout(gbl_panel_10);
		
		JLabel label_3 = new JLabel("\u59D3\u540D");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		panel_10.add(label_3, gbc_label_3);
		
		JLabel label_26 = new JLabel("   ");
		GridBagConstraints gbc_label_26 = new GridBagConstraints();
		gbc_label_26.insets = new Insets(0, 0, 5, 5);
		gbc_label_26.anchor = GridBagConstraints.EAST;
		gbc_label_26.gridx = 1;
		gbc_label_26.gridy = 0;
		panel_10.add(label_26, gbc_label_26);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField.setText(admin.name);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel_10.add(textField, gbc_textField);
		textField.setColumns(10);
		Font font_1 = new Font("微软雅黑", Font.PLAIN, 14);
		
		JLabel label_17 = new JLabel("\u804C\u4F4D");
		label_17.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.anchor = GridBagConstraints.EAST;
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 10;
		gbc_label_17.gridy = 0;
		panel_10.add(label_17, gbc_label_17);
		
		JLabel label_27 = new JLabel("   ");
		GridBagConstraints gbc_label_27 = new GridBagConstraints();
		gbc_label_27.insets = new Insets(0, 0, 5, 5);
		gbc_label_27.anchor = GridBagConstraints.EAST;
		gbc_label_27.gridx = 11;
		gbc_label_27.gridy = 0;
		panel_10.add(label_27, gbc_label_27);
		
		textField_3 = new JTextField();
		if(admin.position != null && admin.position.length()!=0) {
			textField_3.setText(admin.position);
		}else {
			textField_3.setText("");
		}
		textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 12;
		gbc_textField_3.gridy = 0;
		panel_10.add(textField_3, gbc_textField_3);
		
		JLabel label_6 = new JLabel("     ");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 10;
		gbc_label_6.gridy = 0;
		panel_10.add(label_6, gbc_label_6);
		
		JLabel label_8 = new JLabel("     ");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 0);
		gbc_label_8.gridx = 14;
		gbc_label_8.gridy = 0;
		panel_10.add(label_8, gbc_label_8);
		
		JLabel label_4 = new JLabel("     ");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 1;
		panel_10.add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("\u7F16\u53F7");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 2;
		panel_10.add(label_5, gbc_label_5);
		
		textField_1 = new JTextField();
		textField_1.setText(admin.no);
		textField_1.setOpaque(false);	//设置背景透明
		textField_1.setBorder(null);	//设置边框透明
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 5;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		panel_10.add(textField_1, gbc_textField_1);
		
		JLabel label_15 = new JLabel("\u5B66\u9662");
		label_15.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.anchor = GridBagConstraints.EAST;
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 10;
		gbc_label_15.gridy = 2;
		panel_10.add(label_15, gbc_label_15);
		
		JComboBox comboBox_5 = new ComboBoxNoButton();
		comboBox_5.setOpaque(false);	//设置背景透明
		comboBox_5.setBorder(null);	//设置边框透明
		comboBox_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_comboBox_5 = new GridBagConstraints();
		gbc_comboBox_5.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_5.gridx = 12;
		gbc_comboBox_5.gridy = 2;
		panel_10.add(comboBox_5, gbc_comboBox_5);
		
		JLabel label_21 = new JLabel("     ");
		GridBagConstraints gbc_label_21 = new GridBagConstraints();
		gbc_label_21.insets = new Insets(0, 0, 5, 5);
		gbc_label_21.gridx = 0;
		gbc_label_21.gridy = 3;
		panel_10.add(label_21, gbc_label_21);
		
		JLabel label_7 = new JLabel("\u6027\u522B");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 4;
		panel_10.add(label_7, gbc_label_7);
		
		ButtonGroup bg = new ButtonGroup();
		
		radioButton = new JRadioButton("\u7537");
		radioButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		radioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 2;
		gbc_radioButton.gridy = 4;
		panel_10.add(radioButton, gbc_radioButton);
		
		radioButton_1 = new JRadioButton("\u5973");
		radioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		radioButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_radioButton_1 = new GridBagConstraints();
		gbc_radioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton_1.gridx = 5;
		gbc_radioButton_1.gridy = 4;
		panel_10.add(radioButton_1, gbc_radioButton_1);
		
		bg.add(radioButton);
		bg.add(radioButton_1);
		
		if(admin.sex.equals("男")) {
			radioButton.setSelected(true);
		}else {
			radioButton_1.setSelected(true);
		}
		
		JLabel label_16 = new JLabel("\u4E13\u4E1A");
		label_16.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.anchor = GridBagConstraints.EAST;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 10;
		gbc_label_16.gridy = 4;
		panel_10.add(label_16, gbc_label_16);
		
		JComboBox comboBox_3 = new ComboBoxNoButton();
		comboBox_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_3.setOpaque(false);	//设置背景透明
		comboBox_3.setBorder(null);	//设置边框透明
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 12;
		gbc_comboBox_3.gridy = 4;
		panel_10.add(comboBox_3, gbc_comboBox_3);
		
		JLabel label_22 = new JLabel("     ");
		GridBagConstraints gbc_label_22 = new GridBagConstraints();
		gbc_label_22.insets = new Insets(0, 0, 5, 5);
		gbc_label_22.gridx = 0;
		gbc_label_22.gridy = 5;
		panel_10.add(label_22, gbc_label_22);
		
		JLabel label_9 = new JLabel("\u51FA\u751F\u5E74\u6708\u65E5");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 6;
		panel_10.add(label_9, gbc_label_9);
		
		JComboBox comboBox = new ComboBoxNoButton();
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(str));
		comboBox.setOpaque(false);	//设置背景透明
		comboBox.setBorder(null);	//设置边框透明
//		comboBox.setSelectedIndex(yearint - yearstart);
		comboBox.setSelectedIndex(70);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 6;
		panel_10.add(comboBox, gbc_comboBox);
		
		JLabel label_10 = new JLabel("-");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.EAST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 4;
		gbc_label_10.gridy = 6;
		panel_10.add(label_10, gbc_label_10);
		
		JComboBox comboBox_1 = new ComboBoxNoButton();
		comboBox_1.setModel(new DefaultComboBoxModel(str1));
//		comboBox_1.setSelectedIndex(monthint - 1);
		comboBox_1.setSelectedIndex(12);
		comboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_1.setOpaque(false);	//设置背景透明
		comboBox_1.setBorder(null);	//设置边框透明
		comboBox_1.setPreferredSize(new Dimension(40, 30));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 6;
		panel_10.add(comboBox_1, gbc_comboBox_1);
		
		JLabel label_11 = new JLabel("-");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.EAST;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 6;
		gbc_label_11.gridy = 6;
		panel_10.add(label_11, gbc_label_11);
		
		JComboBox comboBox_2 = new ComboBoxNoButton();
		int year1,month1;
		if(!comboBox.getSelectedItem().equals("")) {
			year1 = Integer.valueOf((String) comboBox.getSelectedItem());
		}else {
			year1 = 2019;
		}
		if(!comboBox_1.getSelectedItem().equals("")) {
			month1 = Integer.valueOf((String) comboBox_1.getSelectedItem());
		}else {
			month1 = 12;
		}
		Bissextile bissextile = new Bissextile(year1);
		if(month1 == 1 || month1 == 3 || month1 == 5 || month1 == 7 || month1 == 8 || month1 == 10 || month1 == 12) {
			comboBox_2.setModel(new DefaultComboBoxModel(str3));
//			comboBox_2.setSelectedIndex(dateint - 1);
			comboBox_2.setSelectedIndex(31);
			System.out.println(dateint - 1);
		}else if(month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
			comboBox_2.setModel(new DefaultComboBoxModel(str2));
//			comboBox_2.setSelectedIndex(dateint - 1);
			comboBox_2.setSelectedIndex(30);
		}else if(month1 == 2 && !bissextile.judge()) {
			comboBox_2.setModel(new DefaultComboBoxModel(str4));
//			comboBox_2.setSelectedIndex(dateint - 1);
			comboBox_2.setSelectedIndex(28);
		}else {
			comboBox_2.setModel(new DefaultComboBoxModel(str5));
//			comboBox_2.setSelectedIndex(dateint - 1);
			comboBox_2.setSelectedIndex(29);
		}
		comboBox_2.setOpaque(false);	//设置背景透明
		comboBox_2.setBorder(null);	//设置边框透明
		comboBox_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_2.setPreferredSize(new Dimension(40, 30));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 7;
		gbc_comboBox_2.gridy = 6;
		panel_10.add(comboBox_2, gbc_comboBox_2);
		
		JLabel label_13 = new JLabel("\u653F\u6CBB\u9762\u8C8C");
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.anchor = GridBagConstraints.EAST;
		gbc_label_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_13.gridx = 10;
		gbc_label_13.gridy = 6;
		panel_10.add(label_13, gbc_label_13);
		
		JComboBox comboBox_6 = new ComboBoxNoButton();
		comboBox_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_6.setOpaque(false);	//设置背景透明
		comboBox_6.setBorder(null);	//设置边框透明
		GridBagConstraints gbc_comboBox_6 = new GridBagConstraints();
		gbc_comboBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_6.gridx = 12;
		gbc_comboBox_6.gridy = 6;
		panel_10.add(comboBox_6, gbc_comboBox_6);
		
		JLabel label_23 = new JLabel("     ");
		GridBagConstraints gbc_label_23 = new GridBagConstraints();
		gbc_label_23.insets = new Insets(0, 0, 5, 5);
		gbc_label_23.gridx = 0;
		gbc_label_23.gridy = 7;
		panel_10.add(label_23, gbc_label_23);
		
		JLabel label_12 = new JLabel("\u7C4D\u8D2F");
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.anchor = GridBagConstraints.EAST;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 0;
		gbc_label_12.gridy = 8;
		panel_10.add(label_12, gbc_label_12);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setOpaque(false);	//设置背景透明
		textField_2.setBorder(null);	//设置边框透明
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 5;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 8;
		panel_10.add(textField_2, gbc_textField_2);
		
		JLabel label_18 = new JLabel("\u8054\u7CFB\u7535\u8BDD\u6216\u90AE\u7BB1");
		label_18.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_18 = new GridBagConstraints();
		gbc_label_18.anchor = GridBagConstraints.EAST;
		gbc_label_18.insets = new Insets(0, 0, 5, 5);
		gbc_label_18.gridx = 10;
		gbc_label_18.gridy = 8;
		panel_10.add(label_18, gbc_label_18);
		
		textField_4 = new JTextField();
		if(admin.mailbox != null && !admin.mailbox.equals("null")) {
			textField_4.setText(admin.mailbox);
		}else if(admin.telephone != null && !admin.telephone.equals("null")) {
			textField_4.setText(admin.telephone);
		}else {
			textField_4.setText("");
		}
		teleormail = textField_4.getText();
		textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 12;
		gbc_textField_4.gridy = 8;
		panel_10.add(textField_4, gbc_textField_4);
		
		JLabel label_24 = new JLabel("     ");
		GridBagConstraints gbc_label_24 = new GridBagConstraints();
		gbc_label_24.insets = new Insets(0, 0, 5, 5);
		gbc_label_24.gridx = 0;
		gbc_label_24.gridy = 9;
		panel_10.add(label_24, gbc_label_24);
		
		JLabel label_14 = new JLabel("\u5B66\u5386");
		label_14.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.anchor = GridBagConstraints.EAST;
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 0;
		gbc_label_14.gridy = 10;
		panel_10.add(label_14, gbc_label_14);
		
		String []str6 = new String[] {"本科", "硕士", "博士",""};
		JComboBox comboBox_4 = new ComboBoxNoButton();
		comboBox_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBox_4.setOpaque(false);	//设置背景透明
		comboBox_4.setBorder(null);	//设置边框透明
		comboBox_4.setModel(new DefaultComboBoxModel(str6));
		comboBox_4.setSelectedIndex(3);
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.gridwidth = 5;
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_4.gridx = 2;
		gbc_comboBox_4.gridy = 10;
		panel_10.add(comboBox_4, gbc_comboBox_4);
		
		JLabel label_20 = new JLabel("qq\u6216\u5FAE\u4FE1");
		label_20.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		GridBagConstraints gbc_label_20 = new GridBagConstraints();
		gbc_label_20.anchor = GridBagConstraints.EAST;
		gbc_label_20.insets = new Insets(0, 0, 5, 5);
		gbc_label_20.gridx = 10;
		gbc_label_20.gridy = 10;
		panel_10.add(label_20, gbc_label_20);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setOpaque(false);	//设置背景透明
		textField_5.setBorder(null);	//设置边框透明
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 12;
		gbc_textField_5.gridy = 10;
		panel_10.add(textField_5, gbc_textField_5);
		
		if(lock) {
			textField.setOpaque(false);	//设置背景透明
			textField.setBorder(null);	//设置边框透明
			textField.setEditable(false);	//姓名可以
			textField_1.setEditable(false);	//编号可以
			radioButton.setEnabled(false);	//男可以
			radioButton_1.setEnabled(false);	//女可以
			comboBox.setEnabled(false);	//年
			comboBox_1.setEnabled(false);	//月
			comboBox_2.setEnabled(false);	//日
			textField_2.setEditable(false);		//籍贯
			comboBox_4.setEnabled(false);	//学历
			textField_3.setEditable(false);		//职位可以
			textField_3.setOpaque(false);	//设置背景透明
			textField_3.setBorder(null);	//设置边框透明
			comboBox_5.setEnabled(false);		//学院
			comboBox_3.setEnabled(false);		//专业
			comboBox_6.setEnabled(false);		//政治面貌
			textField_4.setEditable(false);			//联系电话或邮箱可以
			textField_4.setOpaque(false);	//设置背景透明
			textField_4.setBorder(null);	//设置边框透明
			textField_5.setEditable(false);			//qq或微信
		}else {
			textField.setEditable(true);	//姓名
			textField.setOpaque(true);	//设置背景透明
			textField.setBorder(BorderFactory.createLineBorder(Color.black));	//设置边框透明
			radioButton.setEnabled(true);	//男
			radioButton_1.setEnabled(true);	//女
			textField_3.setOpaque(true);	//设置背景透明
			textField_3.setBorder(BorderFactory.createLineBorder(Color.black));	//设置边框透明
			textField_3.setEditable(true);	//职位可以
			textField_4.setEditable(true);			//联系电话或邮箱可以
			textField_4.setOpaque(true);	//设置背景透明
			textField_4.setBorder(BorderFactory.createLineBorder(Color.black));	//设置边框透明
		}
	}

}
