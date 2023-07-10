package 教师考勤管理系统界面;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import 数据库连接操作.SqlConnect;
import 系统后台操作.AddTableModel;
import 系统后台操作.AddTableModel1;
import 系统后台操作.Administrator;
import 系统后台操作.AffairSelect;
import 系统后台操作.AttendSelect;
import 系统后台操作.EditTableModel1;
import 系统后台操作.EditTableModel2;
import 系统后台操作.JudgeTime;
import 系统后台操作.Main;
import 系统后台操作.MyTableCellRenderer1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class AffairRecordPanel extends JPanel {
	public static JTable table;
	public static JScrollPane scrollPane;
	public java.net.URL imgURL_1 = AffairRecordPanel.class.getResource("/images/admindel.png");
	public java.net.URL imgURL_2 = AffairRecordPanel.class.getResource("/images/adminadd.png");
	public java.net.URL imgURL_3 = AffairRecordPanel.class.getResource("/images/adminchange.png");
	public java.net.URL imgURL_4 = AffairRecordPanel.class.getResource("/images/adminsaveonce.png");
	public java.net.URL imgURL_5 = AffairRecordPanel.class.getResource("/images/pass.png");
	private ImageIcon icon_1;
	private ImageIcon icon_2;
	private ImageIcon icon_3;
	private ImageIcon icon_4;
	private ImageIcon icon_5;
	public TableModel tModel_1;	//第一个查询按钮
	public TableModel tModel_2;	//第二个查询按钮
	public static JTextField textField;
	public static JTextField textField_1;
	public static ResultSet rs;
	public static ResultSet rsCount;
	public static TableModel tModel;
	public static Confirm confirm;
	private DeleteDialog2 deletedialog2;
	public static int[] selectedRows;
	private AddTableModel1 addtablemodel1;
	private EditTableModel2 edittablemodel2;
	public JButton button_15;
//	private MyTableCellRenderer1 mytablecellrenderer;
	private JudgeTime judgetime = new JudgeTime();
	private ArrayList selectRow = new ArrayList();		//编号
	private ArrayList selectRow_1 = new ArrayList();	//姓名
	private ArrayList selectRow_2 = new ArrayList();	//年份
	private ArrayList selectRow_3 = new ArrayList();	//月份
	private ArrayList selectRow_4 = new ArrayList();	//学院
	private ArrayList selectRow_5 = new ArrayList();	//专业
	private ArrayList selectRow_6 = new ArrayList();	//范围
	private ArrayList selectRow_final = new ArrayList();
	private AffairSelect affairselect = new AffairSelect();
	public static String teacherno, teachername, year, month, college, profession;
	public static ArrayList<String> affair_no = new ArrayList<String>();
	public static ArrayList<String> teacher_no = new ArrayList<String>();
	public static ArrayList<String> teacher_name = new ArrayList<String>();
	public static ArrayList<String> college_name = new ArrayList<String>();
	public static ArrayList<String> profession_name = new ArrayList<String>();
	public static ArrayList<String> admin_no = new ArrayList<String>();
	public static ArrayList<String> admin_name = new ArrayList<String>();
	public static ArrayList<String> admin_telephone = new ArrayList<String>();
	public static ArrayList<String> admin_mailbox = new ArrayList<String>();
	public static ArrayList<String> affair_type = new ArrayList<String>();
	public static ArrayList<String> affair_start = new ArrayList<String>();
	public static ArrayList<String> affair_end = new ArrayList<String>();
	public static ArrayList<String> affair_time = new ArrayList<String>();
	public static ArrayList<String> reason = new ArrayList<String>();
	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBox_1 = new JComboBox();
	private JComboBox comboBox_2 = new JComboBox();
	private JComboBox comboBox_3 = new JComboBox();

	/**
	 * Create the panel.
	 */
	public AffairRecordPanel(Administrator admin){
		icon_1= new ImageIcon(imgURL_1);
		icon_2= new ImageIcon(imgURL_2);
		icon_3= new ImageIcon(imgURL_3);
		icon_4= new ImageIcon(imgURL_4);
		icon_5= new ImageIcon(imgURL_5);
		Dimension size1 = new Dimension(24, 24);	//四个按钮的大小
		Dimension size2 = new Dimension(50, 22);	//教师编号的大小
		Dimension size3 = new Dimension(40, 22);	//查询内空隔的大小
		Dimension size4 = new Dimension(156, 22);	//设置DateField的大小
		Dimension size5 = new Dimension(20, 22);	//设置年份和月份空隔的大小
		Dimension size6 = new Dimension(90, 22);	//设置范围查询和前面的查询之间的空隔的大小
		setLayout(new BorderLayout(0, 0));
		Font font = new Font("SimSun", Font.BOLD, 12);
		Font font_1 = new Font("微软雅黑", Font.PLAIN, 14);		//表的字体
		setBounds(100,100,950,563);
		
		JPanel panel = new JPanel();
		Border etchedBorder = BorderFactory.createEtchedBorder();
		Border titledborder = BorderFactory.createTitledBorder(etchedBorder, "请求记录查找", TitledBorder.CENTER, TitledBorder.CENTER);
		panel.setBorder(titledborder);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		String str[] = new String[101];
		String time = null; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		time = sdf.format(new Date());
		String yearnow = time.substring(0, 4);
		String monthnow = time.substring(5, 7);
		String datenow = time.substring(8, 10);
		System.out.println(time);
		Integer yearint = Integer.valueOf(yearnow);		//当前时间
		Integer monthint = Integer.valueOf(monthnow);		//当前月份
		Integer dateint = Integer.valueOf(datenow);		//当前日期
		int yearstart = yearint - 49;		//起始年份
		
		for(int i = yearstart; i <= yearint + 50; i++) {
			if(i == yearint) {
				str[i - yearstart] = Integer.toString(i);
				i++;
				str[i - yearstart] = "";
			}else if(i > yearint){
				str[i - yearstart] = Integer.toString(i - 1);
			}else {
				str[i - yearstart] = Integer.toString(i);
			}
		}
		
		String str1[] = new String[13];
		for(int i = 1; i <= 12; i++) {
			if(i == monthint) {
				str1[i - 1] = Integer.toString(i);
				i++;
				str1[i - 1] = "";
			}else if(i > monthint) {
				str1[i - 1] = Integer.toString(i - 1);
			}else {
				str1[i - 1] = Integer.toString(i);
			}
		}
		
		String sqlCount = "select count(DISTINCT college_name) as 行数 from collegeMWM";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int collegecount = 0;		//学院行数
		try {
			rsCount.next();
			collegecount = rsCount.getInt("行数");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String str2[] = new String[collegecount + 1];	//学院
		str2[0] = "请选择学院";
		int i = 1;
		
		String sql = "select DISTINCT college_name as 学院 from collegeMWM";
		try {
			rs = Main.sqlconnect.stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Main.sqlconnect.ct.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				str2[i] = rs.getString("学院");
				i++;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		
		sqlCount = "select count(DISTINCT profession_name) as 行数 from collegeMWM";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int professioncount = 0;		//专业行数
		try {
			rsCount.next();
			professioncount = rsCount.getInt("行数");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String str3[] = new String[professioncount + 1];	//学院
		str3[0] = "请选择专业";
		i = 1;
		
		sql = "select DISTINCT profession_name as 专业 from collegeMWM";
		try {
			rs = Main.sqlconnect.stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Main.sqlconnect.ct.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()) {
				str3[i] = rs.getString("专业");
				i++;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_4.requestFocus();
			}
		});
		panel.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel label = new JLabel("   ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_4.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u7F16\u53F7  ");
		label_1.setFont(font);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 0;
		panel_4.add(label_1, gbc_label_1);
		
		textField = new JTextField();
		textField.setColumns(40);
		textField.setForeground(UIManager.getColor("Button.shadow"));
		textField.setText("请输入教师编号");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textField.getText().equals("请输入教师编号")) {
					textField.setText("");
					textField.setForeground(Color.black);
					textField_1.setEditable(false);
					textField_1.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().length() == 0) {
					textField.setForeground(UIManager.getColor("Button.shadow"));
					textField.setText("请输入教师编号");
					textField_1.setEditable(true);
					textField_1.setEnabled(true);
					comboBox_2.setEnabled(true);
					comboBox_3.setEnabled(true);
				}
			}
		});
		textField.setFont(font);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("     ");
		label_2.setPreferredSize(size3);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 0;
		panel_4.add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("\u59D3\u540D");
		label_3.setFont(font);
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 6;
		gbc_label_3.gridy = 0;
		panel_4.add(label_3, gbc_label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(25);
		textField_1.setFont(font);
		textField_1.setForeground(UIManager.getColor("Button.shadow"));
		textField_1.setText("请输入教师姓名");
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textField_1.getText().equals("请输入教师姓名")) {
					textField_1.setText("");
					textField_1.setForeground(Color.black);
					textField.setEnabled(false);
					textField.setEditable(false);
					comboBox_2.setEnabled(false);
					comboBox_3.setEnabled(false);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().length() == 0) {
					textField_1.setForeground(UIManager.getColor("Button.shadow"));
					textField_1.setText("请输入教师姓名");
					textField.setEnabled(true);
					textField.setEditable(true);
					comboBox_2.setEnabled(true);
					comboBox_3.setEnabled(true);
				}
			}
		});
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 7;
		gbc_textField_1.gridy = 0;
		panel_4.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel label_14 = new JLabel("  ");
		GridBagConstraints gbc_label_14 = new GridBagConstraints();
		gbc_label_14.insets = new Insets(0, 0, 5, 5);
		gbc_label_14.gridx = 9;
		gbc_label_14.gridy = 0;
		panel_4.add(label_14, gbc_label_14);
		
		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 10;
		gbc_label_4.gridy = 0;
		panel_4.add(label_4, gbc_label_4);
		
		JLabel label_17 = new JLabel("    ");
		GridBagConstraints gbc_label_17 = new GridBagConstraints();
		gbc_label_17.insets = new Insets(0, 0, 5, 5);
		gbc_label_17.gridx = 13;
		gbc_label_17.gridy = 0;
		panel_4.add(label_17, gbc_label_17);
		
		JLabel label_5 = new JLabel("\u5E74\u5EA6");
		label_5.setFont(font);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 14;
		gbc_label_5.gridy = 0;
		panel_4.add(label_5, gbc_label_5);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBox.getSelectedItem().equals("")) {
					comboBox_1.setEnabled(true);
				}else {
					comboBox_1.setEnabled(false);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(str));
		comboBox.setSelectedIndex(yearint - yearstart + 1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridx = 15;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridy = 0;
		panel_4.add(comboBox, gbc_comboBox);
		
		JLabel label_6 = new JLabel("   ");
		label_6.setPreferredSize(size5);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 16;
		gbc_label_6.gridy = 0;
		panel_4.add(label_6, gbc_label_6);
		
		JLabel label_7 = new JLabel("\u6708\u4EFD");
		label_7.setFont(font);
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.EAST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 17;
		gbc_label_7.gridy = 0;
		panel_4.add(label_7, gbc_label_7);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(str1));
		comboBox_1.setSelectedIndex(monthint);
		comboBox_1.setEnabled(false);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 18;
		gbc_comboBox_1.gridy = 0;
		panel_4.add(comboBox_1, gbc_comboBox_1);
		
		JLabel label_8 = new JLabel("");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 18;
		gbc_label_8.gridy = 0;
		panel_4.add(label_8, gbc_label_8);
		
		JLabel label_13 = new JLabel("   ");
		GridBagConstraints gbc_label_13 = new GridBagConstraints();
		gbc_label_13.insets = new Insets(0, 0, 5, 0);
		gbc_label_13.gridx = 19;
		gbc_label_13.gridy = 0;
		panel_4.add(label_13, gbc_label_13);
		
		JLabel label_15 = new JLabel("\u5B66\u9662");
		label_15.setFont(font);
		GridBagConstraints gbc_label_15 = new GridBagConstraints();
		gbc_label_15.anchor = GridBagConstraints.WEST;
		gbc_label_15.insets = new Insets(0, 0, 5, 5);
		gbc_label_15.gridx = 1;
		gbc_label_15.gridy = 1;
		panel_4.add(label_15, gbc_label_15);
		
		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBox_2.getSelectedItem().equals("请选择学院")) {
					comboBox_3.setEnabled(true);
					textField.setEditable(false);
					textField_1.setEditable(false);
					textField.setEnabled(false);
					textField_1.setEnabled(false);
				}else {
					comboBox_3.setEnabled(false);
					textField.setEditable(true);
					textField_1.setEditable(true);
					textField.setEnabled(true);
					textField_1.setEnabled(true);
				}
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(str2));
		comboBox_2.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 1;
		panel_4.add(comboBox_2, gbc_comboBox_2);
		
		JLabel label_16 = new JLabel("\u4E13\u4E1A");
		label_16.setFont(font);
		GridBagConstraints gbc_label_16 = new GridBagConstraints();
		gbc_label_16.anchor = GridBagConstraints.EAST;
		gbc_label_16.insets = new Insets(0, 0, 5, 5);
		gbc_label_16.gridx = 6;
		gbc_label_16.gridy = 1;
		panel_4.add(label_16, gbc_label_16);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setEnabled(false);
		comboBox_3.setModel(new DefaultComboBoxModel(str3));
		comboBox_3.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.gridwidth = 5;
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 7;
		gbc_comboBox_3.gridy = 1;
		panel_4.add(comboBox_3, gbc_comboBox_3);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherno = textField.getText();
				teachername = textField_1.getText();
				year = (String) comboBox.getSelectedItem();
				month = (String) comboBox_1.getSelectedItem();
				college = (String) comboBox_2.getSelectedItem();
				profession = (String) comboBox_3.getSelectedItem();
				selectRow = new ArrayList();		//编号
				selectRow_1 = new ArrayList();	//姓名
				selectRow_2 = new ArrayList();	//年份
				selectRow_3 = new ArrayList();	//月份
				selectRow_4 = new ArrayList();	//学院
				selectRow_5 = new ArrayList();	//专业
				selectRow_6 = new ArrayList();	//范围
				selectRow_final = new ArrayList();
				String sql_1 = null;
				String shiftname = null;
				/*
				 * 	输入编号，就不能输入姓名、学院、专业
				 *	输入姓名，就不能输入学院、专业
				 *	选择学院或者专业，就不能输入编号、姓名
				 *	只有选择了学院才能选择专业
				 *	只有选择了年份才能选择月份
				 */
				if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && year.equals("") && month.equals("")) {		//没有输入，只显示出来年份
				
				}else {
					System.out.println(teacherno + " " + teachername + " " + college  + " " + profession + " " + year + " " + month + " " +tModel.getRowCount());
					if(!teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && year.equals("") && month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 1).equals(teacherno)) {
								selectRow.add(i);		//把编号要选出来的行数记录下来
							}
						}
						selectRow_final = selectRow;
					}
					else if(!teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && !year.equals("") && month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 1).equals(teacherno)) {
								selectRow.add(i);		//把编号要选出来的行数记录下来
							}
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow, selectRow_4);
					}
					else if(!teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && !year.equals("") && !month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 1).equals(teacherno)) {
								selectRow.add(i);		//把编号要选出来的行数记录下来
							}
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
							if(Integer.valueOf(((String)tModel.getValueAt(i, 6)).substring(5,7)) == Integer.valueOf(month)) {
								selectRow_5.add(i);		//把月份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow, selectRow_4);
						selectRow_final = mergeList(selectRow_final, selectRow_5);
					}
					else if(teacherno.equals("请输入教师编号") && !teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && year.equals("") && month.equals("")) {			//输入了教师姓名
						for(int i = 0;i < tModel.getRowCount();i++) {
							try {
								shiftname = shift((String) tModel.getValueAt(i, 2));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(shiftname.equals(teachername)) {
								selectRow_1.add(i);		//把姓名要选出来的行数记录下来
							}
						}
						selectRow_final = selectRow_1;
					}
					else if(teacherno.equals("请输入教师编号") && !teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && !year.equals("") && month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							try {
								shiftname = shift((String) tModel.getValueAt(i, 2));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(shiftname.equals(teachername)) {
								selectRow_1.add(i);		//把姓名要选出来的行数记录下来
							}
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow_1, selectRow_4);
					}
					else if(teacherno.equals("请输入教师编号") && !teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && !year.equals("") && !month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							try {
								shiftname = shift((String) tModel.getValueAt(i, 2));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							if(shiftname.equals(teachername)) {
								selectRow_1.add(i);		//把姓名要选出来的行数记录下来
							}
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
							if(Integer.valueOf(((String)tModel.getValueAt(i, 5)).substring(5,7)) == Integer.valueOf(month)) {
								selectRow_5.add(i);		//把月份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow_1, selectRow_4);
						selectRow_final = mergeList(selectRow_final, selectRow_5);
					}
					else if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && !college.equals("请选择学院") && profession.equals("请选择专业") && year.equals("") && month.equals("")) {			//输入了学院
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 3).equals(college)) {
								selectRow_2.add(i);		//把学院要选出来的行数记录下来
							}
						}
						selectRow_final = selectRow_2;
					}
					else if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && !college.equals("请选择学院") && !profession.equals("请选择专业") && year.equals("") && month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 3).equals(college)) {
								selectRow_2.add(i);		//把学院要选出来的行数记录下来
							}
							if(tModel.getValueAt(i, 4).equals(profession)) {
								selectRow_3.add(i);		//把专业要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow_2, selectRow_3);
					}
					else if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && !college.equals("请选择学院") && profession.equals("请选择专业") && !year.equals("") && month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 3).equals(college)) {
								selectRow_2.add(i);		//把学院要选出来的行数记录下来
							}
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow_2, selectRow_4);
					}
					else if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && !college.equals("请选择学院") && !profession.equals("请选择专业") && !year.equals("") && month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 3).equals(college)) {
								selectRow_2.add(i);		//把学院要选出来的行数记录下来
							}
							if(tModel.getValueAt(i, 4).equals(profession)) {
								selectRow_3.add(i);		//把专业要选出来的行数记录下来
							}
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow_2, selectRow_3);
						selectRow_final = mergeList(selectRow_final, selectRow_4);
					}
					else if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && !college.equals("请选择学院") && profession.equals("请选择专业") && !year.equals("") && !month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 3).equals(college)) {
								selectRow_2.add(i);		//把学院要选出来的行数记录下来
							}
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
							if(Integer.valueOf(((String)tModel.getValueAt(i, 6)).substring(5,7)) == Integer.valueOf(month)) {
								selectRow_5.add(i);		//把月份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow_2, selectRow_4);
						selectRow_final = mergeList(selectRow_final, selectRow_5);
					}
					else if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && !college.equals("请选择学院") && !profession.equals("请选择专业") && !year.equals("") && !month.equals("")) {		//输入了教师编号
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 3).equals(college)) {
								selectRow_2.add(i);		//把学院要选出来的行数记录下来
							}
							if(tModel.getValueAt(i, 4).equals(profession)) {
								selectRow_3.add(i);		//把专业要选出来的行数记录下来
							}
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
							if(Integer.valueOf(((String)tModel.getValueAt(i, 5)).substring(5,7)) == Integer.valueOf(month)) {
								selectRow_5.add(i);		//把月份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow_2, selectRow_3);
						selectRow_final = mergeList(selectRow_final, selectRow_4);
						selectRow_final = mergeList(selectRow_final, selectRow_5);
					}
					else if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && !year.equals("") && month.equals("")) {			//输入了专业
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
						}
						selectRow_final = selectRow_4;
					}
					else if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && college.equals("请选择学院") && profession.equals("请选择专业") && !year.equals("") && !month.equals("")) {			//输入了专业
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(((String)tModel.getValueAt(i, 10)).substring(0,4).equals(year)) {
								selectRow_4.add(i);		//把年份要选出来的行数记录下来
							}
							if(Integer.valueOf(((String)tModel.getValueAt(i, 6)).substring(5,7)) == Integer.valueOf(month)) {
								selectRow_5.add(i);		//把月份要选出来的行数记录下来
							}
						}
						selectRow_final = mergeList(selectRow_4, selectRow_5);
					}
					tModel_1 = new AbstractTableModel() {
						//拿到有多少条记录
						public int rowCount() {
							return selectRow_final.size();
						}
						//表格的行数
						public int getRowCount() {return rowCount();}
						//表格的列数
						public int getColumnCount() {return 14;}
						
						public Object getValueAt(int row, int col) {
							switch(col) {
							case 0:
								return affair_no.get((int) selectRow_final.get(row));
							case 1:
								return teacher_no.get((int) selectRow_final.get(row));
							case 2:
								return teacher_name.get((int) selectRow_final.get(row));
							case 3:
								return college_name.get((int) selectRow_final.get(row));
							case 4:
								return profession_name.get((int) selectRow_final.get(row));
							case 5:
								return admin_no.get((int) selectRow_final.get(row));
							case 6:
								return admin_name.get((int) selectRow_final.get(row));
							case 7:
								return admin_telephone.get((int) selectRow_final.get(row));
							case 8:
								return admin_mailbox.get((int) selectRow_final.get(row));
							case 9:
								if(Integer.valueOf(affair_type.get((int) selectRow_final.get(row))) == 1) {
									return "出差";
								}else if(Integer.valueOf(affair_type.get((int) selectRow_final.get(row))) == 2) {
									return "请假";
								}else if(Integer.valueOf(affair_type.get((int) selectRow_final.get(row))) == 3) {
									return "加班";
								}
							case 10:
								return affair_start.get((int) selectRow_final.get(row));
							case 11:
								return affair_end.get((int) selectRow_final.get(row));
							case 12:
								return affair_time.get((int) selectRow_final.get(row));
							case 13:
								return reason.get((int) selectRow_final.get(row));
							}
							return null;
						}
						//设置表格的列名
						public final String[] columnName = {"请求编号", "编号", "姓名","学院","管理员编号","管理员姓名","管理员联系电话","管理员联系邮箱","专业","请求类型", "请求开始时间","请求结束时间","请求时间","请求原因"};
						public String getColumnName(int column) {
							return columnName[column];
						}
						public Class getColumnClass(int column) {
							return java.lang.String.class;	
						}
					};
					table = new JTable(tModel_1);
//					FitTableColumns(table);
					table.setFont(font_1);
//					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					scrollPane.setViewportView(table);
					table.addMouseMotionListener(new MouseAdapter(){  
					    public void mouseMoved(MouseEvent e) {  
					        int row=table.rowAtPoint(e.getPoint());  
					        int col=table.columnAtPoint(e.getPoint());  
					        if(row>-1 && col>-1){  
					            Object value=table.getValueAt(row, col);  
					            if(null!=value && !"".equals(value))  
					                table.setToolTipText(value.toString());//悬浮显示单元格内容  
					            else  
					                table.setToolTipText(null);//关闭提示
					        }
					    }
					});
					scrollPane.setViewportView(table);
				}
			}
		});
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 12;
		gbc_button.gridy = 1;
		panel_4.add(button, gbc_button);
		
		JLabel label_9 = new JLabel("\u8303\u56F4\u67E5\u8BE2\uFF1A");
		label_9.setFont(font);
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.EAST;
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 1;
		gbc_label_9.gridy = 2;
		panel_4.add(label_9, gbc_label_9);
		
		JLabel label_10 = new JLabel("\u4ECE");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 0, 5);
		gbc_label_10.gridx = 2;
		gbc_label_10.gridy = 2;
		panel_4.add(label_10, gbc_label_10);
		
		JPanel panel_5 = new DateField();
		panel_5.setPreferredSize(size4);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 3;
		gbc_panel_5.gridy = 2;
		panel_4.add(panel_5, gbc_panel_5);
		
		JLabel label_11 = new JLabel("");
		label_11.setPreferredSize(size3);
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 8;
		gbc_label_11.gridy = 1;
		panel_4.add(label_11, gbc_label_11);
		
		JLabel label_12 = new JLabel("\u5230");
		label_12.setFont(font);
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.insets = new Insets(0, 0, 0, 5);
		gbc_label_12.gridx = 6;
		gbc_label_12.gridy = 2;
		panel_4.add(label_12, gbc_label_12);
		
		JPanel panel_6 = new DateField();
		panel_6.setPreferredSize(size4);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 4;
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 7;
		gbc_panel_6.gridy = 2;
		panel_4.add(panel_6, gbc_panel_6);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date1 = ((DateField) panel_5).gainDateString();
				String date2 = ((DateField) panel_6).gainDateString();
				System.out.println(date1 + " " + date2);
				selectRow_6 = new ArrayList();
				if(Integer.valueOf(date1.substring(0, 4)) > Integer.valueOf(date2.substring(0, 4)) || Integer.valueOf(date1.substring(0, 4)) == Integer.valueOf(date2.substring(0, 4)) && Integer.valueOf(date1.substring(5, 7)) > Integer.valueOf(date2.substring(5, 7)) || Integer.valueOf(date1.substring(5, 7)) == Integer.valueOf(date2.substring(5, 7)) && Integer.valueOf(date1.substring(8, 10)) > Integer.valueOf(date2.substring(8, 10))) {
					confirm = new Confirm("查询失败！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					String yearrange1 = date1.substring(0, 4);
					String yearrange2 = date2.substring(0, 4);
					String monthrange1 = date1.substring(5, 7);
					String monthrange2 = date2.substring(5, 7);
					String dayrange1 = date1.substring(8, 10);
					String dayrange2 = date2.substring(8, 10);
					String rangeall1 = yearrange1+monthrange1+dayrange1;
					String rangeall2 = yearrange2+monthrange2+dayrange2;
					
					String yearstart = "";
					String monthstart = "";
					String daystart = "";
					String yearend = "";
					String monthend = "";
					String dayend = "";
					String start = "";
					String end = "";
					for(int i = 0;i < tModel.getRowCount();i++) {
						yearstart = ((String)tModel.getValueAt(i, 10)).substring(0,4);
						yearend = ((String)tModel.getValueAt(i, 11)).substring(0,4);
						monthstart = ((String)tModel.getValueAt(i, 10)).substring(5,7);
						monthend = ((String)tModel.getValueAt(i, 11)).substring(5,7);
						daystart = ((String)tModel.getValueAt(i, 10)).substring(8,10);
						dayend = ((String)tModel.getValueAt(i, 11)).substring(8,10);
						start = yearstart+monthstart+daystart;
						end = yearend+monthend+dayend;
						if((start.equals(end) && rangeall1.equals(rangeall2) && start.equals(rangeall1))||(start.equals(end) && Integer.valueOf(end) <= Integer.valueOf(rangeall2) && Integer.valueOf(start) >= Integer.valueOf(rangeall2))|| (Integer.valueOf(start) >= Integer.valueOf(rangeall1) && Integer.valueOf(end) <= Integer.valueOf(rangeall2))) {
							selectRow_6.add(i);
						}
					}
					selectRow_final = selectRow_6;
					tModel_1 = new AbstractTableModel() {
						//拿到有多少条记录
						public int rowCount() {
							return selectRow_final.size();
						}
						//表格的行数
						public int getRowCount() {return rowCount();}
						//表格的列数
						public int getColumnCount() {return 10;}
						
						public Object getValueAt(int row, int col) {
							switch(col) {
							case 0:
								return affair_no.get(row);
							case 1:
								return teacher_no.get(row);
							case 2:
								return teacher_name.get(row);
							case 3:
								return college_name.get(row);
							case 4:
								return profession_name.get(row);
							case 5:
								if(Integer.valueOf(affair_type.get(row)) == 1) {
									return "出差";
								}else if(Integer.valueOf(affair_type.get(row)) == 2) {
									return "请假";
								}else if(Integer.valueOf(affair_type.get(row)) == 3) {
									return "加班";
								}
							case 6:
								return affair_start.get(row);
							case 7:
								return affair_end.get(row);
							case 8:
								return affair_time.get(row);
							case 9:
								return reason.get(row);
							}
							return null;
						}
						//设置表格的列名
						public final String[] columnName = {"请求编号", "编号", "姓名","学院","专业","请求类型", "请求开始时间","请求结束时间","请求时间","请求原因"};
						public String getColumnName(int column) {
							return columnName[column];
						}
						public Class getColumnClass(int column) {
							return java.lang.String.class;	
				    	}
					};
					
					table = new JTable(tModel_1);
//					FitTableColumns(table);
					table.setFont(font_1);
//					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					scrollPane.setViewportView(table);
					table.addMouseMotionListener(new MouseAdapter(){  
					    public void mouseMoved(MouseEvent e) {  
					        int row=table.rowAtPoint(e.getPoint());  
					        int col=table.columnAtPoint(e.getPoint());  
					        if(row>-1 && col>-1){  
					            Object value=table.getValueAt(row, col);  
					            if(null!=value && !"".equals(value))  
					                table.setToolTipText(value.toString());//悬浮显示单元格内容  
					            else  
					                table.setToolTipText(null);//关闭提示
					        }
					    }
					});
					scrollPane.setViewportView(table);
				}
			}
		});
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 11;
		gbc_button_1.gridy = 2;
		panel_4.add(button_1, gbc_button_1);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setHgap(0);
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setHgap(0);
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_3, BorderLayout.SOUTH);
		
		JButton button_13 = new JButton();
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletedialog2 = new DeleteDialog2("您确定要删除吗？");
				deletedialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				deletedialog2.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedRows = table.getSelectedRows();
				String sql_1 = "";
				if(selectedRows.length == 0) {
					confirm = new Confirm("您未选中任何数据");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					String affairno[] = new String[selectedRows.length];
					for(int i = 0;i < selectedRows.length;i++) {
						affairno[i] = (String) table.getValueAt(selectedRows[i], 0);
						int rowreal = -1;
						for(int j = 0;j < affair_no.size();j++) {
							if(affair_no.get(j).equals(affairno[i])) {
								rowreal = j;
								break;
							}
						}
						admin_no.set(rowreal, admin.no);
						admin_name.set(rowreal,admin.name);
						admin_telephone.set(rowreal, admin.telephone);
						admin_mailbox.set(rowreal, admin.mailbox);
						
						sql_1 += "update affairMWM set admin_no = " + "\'"+ admin.no +"\' where affair_no = " + "\'"+ affairno[i] +"\'\n";
					}
					try {
						Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						Main.sqlconnect.stmt.executeUpdate(sql_1);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					try {
						Main.sqlconnect.ct.commit();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table = new JTable(tModel);
					FitTableColumns(table);
					table.setFont(font_1);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					scrollPane.setViewportView(table);
					table.addMouseMotionListener(new MouseAdapter(){  
					    public void mouseMoved(MouseEvent e) {  
					        int row=table.rowAtPoint(e.getPoint());  
					        int col=table.columnAtPoint(e.getPoint());  
					        if(row>-1 && col>-1){  
					            Object value=table.getValueAt(row, col);  
					            if(null!=value && !"".equals(value))  
					                table.setToolTipText(value.toString());//悬浮显示单元格内容  
					            else  
					                table.setToolTipText(null);//关闭提示
					        }
					    }
					});
					scrollPane.setViewportView(table);
				}
			}
		});
		button_2.setPreferredSize(size1);
		button_2.setContentAreaFilled(false);
		button_2.setBorder(null);
		button_2.setIcon(icon_5);
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(button_2);
		
		
		
		button_13.setPreferredSize(size1);
		button_13.setIcon(icon_1);
		button_13.setContentAreaFilled(false);
		button_13.setBorder(null);
		button_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(button_13);
		
		JButton button_14 = new JButton();
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addtablemodel1 = new AddTableModel1();
				Admin.button.setEnabled(false);
				Admin.button_2.setEnabled(false);
				Admin.button_3.setEnabled(false);
				Admin.button_4.setEnabled(false);
				Admin.button_6.setEnabled(false);
				button.setEnabled(false);
				button_1.setEnabled(false);
				button_2.setEnabled(false);
				button_13.setEnabled(false);
				button_15.setEnabled(false);
				AddTableModel1.insert = true;
				table = new JTable(addtablemodel1);
//				mytablecellrenderer = new MyTableCellRenderer1();
//				for (int i = 0; i < addtablemodel1.getColumnCount(); i++) {
//			            // 根据 列名 获取 表格列
//					TableColumn tableColumn = table.getColumn(addtablemodel1.columnName[i]);
//			            // 设置 表格列 的 单元格渲染器
//			    	tableColumn.setCellRenderer(mytablecellrenderer);
//			    }
//				FitTableColumns(table);
				table.setFont(font_1);
//				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				scrollPane.setViewportView(table);
				table.addMouseMotionListener(new MouseAdapter(){  
				    public void mouseMoved(MouseEvent e) {  
				        int row=table.rowAtPoint(e.getPoint());  
				        int col=table.columnAtPoint(e.getPoint());  
				        if(row>-1 && col>-1){  
				            Object value=table.getValueAt(row, col);  
				            if(null!=value && !"".equals(value))  
				                table.setToolTipText(value.toString());//悬浮显示单元格内容  
				            else  
				                table.setToolTipText(null);//关闭提示
				        }
				    }
				});
				scrollPane.setViewportView(table);
			}
		});
		button_14.setPreferredSize(size1);
		button_14.setIcon(icon_2);
		button_14.setContentAreaFilled(false);
		button_14.setBorder(null);
		button_14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(button_14);
		
		button_15 = new JButton();
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edittablemodel2 = new EditTableModel2();
				table = new JTable(edittablemodel2);
				table.setFont(font_1);
				table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				scrollPane.setViewportView(table);
				table.addMouseMotionListener(new MouseAdapter(){  
				    public void mouseMoved(MouseEvent e) {  
				        int row=table.rowAtPoint(e.getPoint());  
				        int col=table.columnAtPoint(e.getPoint());  
				        if(row>-1 && col>-1){  
				            Object value=table.getValueAt(row, col);  
				            if(null!=value && !"".equals(value))  
				                table.setToolTipText(value.toString());//悬浮显示单元格内容  
				            else  
				                table.setToolTipText(null);//关闭提示
				        }
				    }
				});
				scrollPane.setViewportView(table);
			}
		});
		button_15.setPreferredSize(size1);
		button_15.setIcon(icon_3);
		button_15.setContentAreaFilled(false);
		button_15.setBorder(null);
		button_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(button_15);
		
		String sql1 = "select C.affair_no as 请求编号, C.teacher_no as 编号, A.teacher_name as 姓名,B.college_name as 学院, B.profession_name as 专业, C.admin_no as 管理员编号, C.affair_type as 请求类型, C.affair_start as 请求开始时间, C.affair_end as 请求结束时间, C.affair_end - C.affair_start as 请求时间, C.reason as 请求原因 from teacherMWM as A, collegeMWM as B, affairMWM as C where A.teacher_no = C.teacher_no and A.college_profession = B.college_profession order by C.teacher_no";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = Main.sqlconnect.stmt.executeQuery(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Main.sqlconnect.ct.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		affair_no = new ArrayList<String>();
		teacher_no = new ArrayList<String>();
		teacher_name = new ArrayList<String>();
		college_name = new ArrayList<String>();
		profession_name = new ArrayList<String>();
		admin_no = new ArrayList<String>();
		admin_name = new ArrayList<String>();
		admin_telephone = new ArrayList<String>();
		admin_mailbox = new ArrayList<String>();
		affair_type = new ArrayList<String>();
		affair_start = new ArrayList<String>();
		affair_end = new ArrayList<String>();
		affair_time = new ArrayList<String>();
		reason = new ArrayList<String>();
		try {
			while(rs.next()) {
				affair_no.add(rs.getString("请求编号"));
				teacher_no.add(rs.getString("编号"));
				teacher_name.add(rs.getString("姓名"));
				college_name.add(rs.getString("学院"));
				profession_name.add(rs.getString("专业"));
				admin_no.add(rs.getString("管理员编号"));
				affair_type.add(rs.getString("请求类型"));
				affair_start.add(rs.getString("请求开始时间"));
				affair_end.add(rs.getString("请求结束时间"));
				affair_time.add(rs.getString("请求时间"));
				reason.add(rs.getString("请求原因"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		Iterator<String> no = admin_no.iterator();
		String adminno;
		while(no.hasNext()) {
			adminno = no.next();
			if(adminno == null) {
				admin_name.add("");
				admin_telephone.add("");
				admin_mailbox.add("");
			}else {
				sql1 = "select admin_name as 管理员姓名, admin_telephone as 管理员联系电话, admin_mailbox as 管理员联系邮箱 from adminMWM where admin_no = \'";
				sql1 += adminno;
				sql1 += "\'";
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rs = Main.sqlconnect.stmt.executeQuery(sql1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Main.sqlconnect.ct.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while(rs.next()) {
						admin_name.add(rs.getString("管理员姓名"));
						admin_telephone.add(rs.getString("管理员联系电话"));
						admin_mailbox.add(rs.getString("管理员联系邮箱"));
					}
				} catch (SQLException e2) {
					e2.printStackTrace();	
				}
			}
		}
		
		tModel = new AbstractTableModel() {
			//拿到有多少条记录
			public int rowCount() {
	//			Statement stmtCount = DB.createStmt(conn);
				String sqlCount = "select count(*) as 行数 from affairMWM";
				try {
					rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int count = 0;
				try {
					rsCount.next();
					count = rsCount.getInt("行数");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return count;
			}
			//表格的行数
			public int getRowCount() {return rowCount();}
			//表格的列数
			public int getColumnCount() {return 14;}
			
			public Object getValueAt(int row, int col) {
				switch(col) {
				case 0:
					return affair_no.get(row);
				case 1:
					return teacher_no.get(row);
				case 2:
					return teacher_name.get(row);
				case 3:
					return college_name.get(row);
				case 4:
					return profession_name.get(row);
				case 5:
					return admin_no.get(row);
				case 6:
					return admin_name.get(row);
				case 7:
					return admin_telephone.get(row);
				case 8:
					return admin_mailbox.get(row);
				case 9:
					if(Integer.valueOf(affair_type.get(row)) == 1) {
						return "出差";
					}else if(Integer.valueOf(affair_type.get(row)) == 2) {
						return "请假";
					}else if(Integer.valueOf(affair_type.get(row)) == 3) {
						return "加班";
					}
				case 10:
					return affair_start.get(row);
				case 11:
					return affair_end.get(row);
				case 12:
					return affair_time.get(row);
				case 13:
					return reason.get(row);
				}
				return null;
			}
			//设置表格的列名
			public final String[] columnName = {"请求编号", "编号", "姓名","学院","专业","管理员编号","管理员姓名","管理员联系电话","管理员联系邮箱","请求类型", "请求开始时间","请求结束时间","请求时间","请求原因"};
			public String getColumnName(int column) {
				return columnName[column];
			}
			public Class getColumnClass(int column) {
				return java.lang.String.class;	
	    	}
	
		};
		
		JButton button_16 = new JButton();
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AddTableModel1.insert) {
					String sql_1 = null;
					int count = 0;
					String teacher_no = AddTableModel1.teacher_no;
					String affair_type = AddTableModel1.affair_type;
					String affair_start = AddTableModel1.affair_start;
					String affair_end = AddTableModel1.affair_end;
					String reason = AddTableModel1.reason;
					if(teacher_no == "" || teacher_no == "请输入教师编号" || affair_type == "" || affair_start == "" || affair_end == ""|| reason == "" || affair_type == "请输入请求类型" ||affair_start == "请输入请求开始时间" ||affair_end == "请输入请求结束时间" || reason == "请输入请求原因") {
						confirm = new Confirm("您的插入无效，请重新插入！");
						confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						confirm.setVisible(true);
						AddTableModel1.insert = false;
						Admin.button.setEnabled(true);
						Admin.button_2.setEnabled(true);
						Admin.button_3.setEnabled(true);
						Admin.button_4.setEnabled(true);
						Admin.button_6.setEnabled(true);
						button.setEnabled(true);
						button_1.setEnabled(true);
						button_13.setEnabled(true);
						button_15.setEnabled(true);
						table = new JTable(tModel);
						table.setFont(font_1);
						table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						scrollPane.setViewportView(table);
						table.addMouseMotionListener(new MouseAdapter(){  
						    public void mouseMoved(MouseEvent e) {  
						        int row=table.rowAtPoint(e.getPoint());  
						        int col=table.columnAtPoint(e.getPoint());  
						        if(row>-1 && col>-1){  
						            Object value=table.getValueAt(row, col);  
						            if(null!=value && !"".equals(value))  
						                table.setToolTipText(value.toString());//悬浮显示单元格内容  
						            else  
						                table.setToolTipText(null);//关闭提示
						        }
						    }
						});
						scrollPane.setViewportView(table);
					}else {
						sql_1 = "select count(*) from teacherMWM where teacher_no = ";
						sql_1 += "\'"+ teacher_no +"\'";
						try {
							SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
							SqlConnect.rs=SqlConnect.ps.executeQuery();
							
							while(SqlConnect.rs.next()) {
								count = Integer.valueOf(SqlConnect.rs.getString(1));
							}
						} catch (SQLException e2) {
							e2.printStackTrace();	
						}
						if(count == 0) {
							confirm = new Confirm("您的插入无效，请重新插入！");
							confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							confirm.setVisible(true);
							AddTableModel1.insert = false;
							Admin.button.setEnabled(true);
							Admin.button_2.setEnabled(true);
							Admin.button_3.setEnabled(true);
							Admin.button_4.setEnabled(true);
							Admin.button_6.setEnabled(true);
							button.setEnabled(true);
							button_1.setEnabled(true);
							button_13.setEnabled(true);
							button_15.setEnabled(true);
							table = new JTable(tModel);
//							FitTableColumns(table);
							table.setFont(font_1);
//							table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							scrollPane.setViewportView(table);
							table.addMouseMotionListener(new MouseAdapter(){  
							    public void mouseMoved(MouseEvent e) {  
							        int row=table.rowAtPoint(e.getPoint());  
							        int col=table.columnAtPoint(e.getPoint());  
							        if(row>-1 && col>-1){  
							            Object value=table.getValueAt(row, col);  
							            if(null!=value && !"".equals(value))  
							                table.setToolTipText(value.toString());//悬浮显示单元格内容  
							            else  
							                table.setToolTipText(null);//关闭提示
							        }
							    }
							});
							scrollPane.setViewportView(table);
						}else {
							if(judgetime.judge(affair_start, affair_end) && (affair_type.equals("1") || affair_type.equals("2") || affair_type.equals("3"))) {
								sql_1 = "insert into affair values(";
								sql_1 += "\'"+ teacher_no +"\'," + "\'"+ affair_type +"\'," + "\'"+ affair_start +"\'," + "\'"+ affair_end +"\'," + "\'"+ reason +"\')";
								try {
									Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
									Main.sqlconnect.stmt.executeUpdate(sql_1);
						        }catch(Exception e1) {
						            e1.printStackTrace();
						        }
								affairselect.affairselect();
								table = new JTable(tModel);
								table.setFont(font_1);
								table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								scrollPane.setViewportView(table);
								table.addMouseMotionListener(new MouseAdapter(){  
								    public void mouseMoved(MouseEvent e) {  
								        int row=table.rowAtPoint(e.getPoint());  
								        int col=table.columnAtPoint(e.getPoint());  
								        if(row>-1 && col>-1){  
								            Object value=table.getValueAt(row, col);  
								            if(null!=value && !"".equals(value))  
								                table.setToolTipText(value.toString());//悬浮显示单元格内容  
								            else  
								                table.setToolTipText(null);//关闭提示
								        }
								    }
								});
								scrollPane.setViewportView(table);
								confirm = new Confirm("插入成功！");
								confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								confirm.setVisible(true);
								AddTableModel1.insert = false;
								Admin.button.setEnabled(true);
								Admin.button_2.setEnabled(true);
								Admin.button_3.setEnabled(true);
								Admin.button_4.setEnabled(true);
								Admin.button_6.setEnabled(true);
								button.setEnabled(true);
								button_2.setEnabled(true);
								button_1.setEnabled(true);
								button_13.setEnabled(true);
								button_15.setEnabled(true);
							}else {
								confirm = new Confirm("您的插入无效，请重新插入！");
								confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								confirm.setVisible(true);
								AddTableModel1.insert = false;
								Admin.button.setEnabled(true);
								Admin.button_2.setEnabled(true);
								Admin.button_3.setEnabled(true);
								Admin.button_4.setEnabled(true);
								Admin.button_6.setEnabled(true);
								button.setEnabled(true);
								button_1.setEnabled(true);
								button_2.setEnabled(true);
								button_13.setEnabled(true);
								button_15.setEnabled(true);
								table = new JTable(tModel);
								table.setFont(font_1);
								table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								scrollPane.setViewportView(table);
								table.addMouseMotionListener(new MouseAdapter(){  
								    public void mouseMoved(MouseEvent e) {  
								        int row=table.rowAtPoint(e.getPoint());  
								        int col=table.columnAtPoint(e.getPoint());  
								        if(row>-1 && col>-1){  
								            Object value=table.getValueAt(row, col);  
								            if(null!=value && !"".equals(value))  
								                table.setToolTipText(value.toString());//悬浮显示单元格内容  
								            else  
								                table.setToolTipText(null);//关闭提示
								        }
								    }
								});
								scrollPane.setViewportView(table);
							}
						}
					}
				}else {
					table = new JTable(tModel);
					table.setFont(font_1);
					table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					scrollPane.setViewportView(table);
					table.addMouseMotionListener(new MouseAdapter(){  
					    public void mouseMoved(MouseEvent e) {  
					        int row=table.rowAtPoint(e.getPoint());  
					        int col=table.columnAtPoint(e.getPoint());  
					        if(row>-1 && col>-1){  
					            Object value=table.getValueAt(row, col);  
					            if(null!=value && !"".equals(value))  
					                table.setToolTipText(value.toString());//悬浮显示单元格内容  
					            else  
					                table.setToolTipText(null);//关闭提示
					        }
					    }
					});
					scrollPane.setViewportView(table);
					confirm = new Confirm("已刷新！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}
			}
		});
		button_16.setPreferredSize(size1);
		button_16.setIcon(icon_4);
		button_16.setContentAreaFilled(false);
		button_16.setBorder(null);
		button_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(button_16);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		table = new JTable(tModel);
		table.setFont(font_1);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setViewportView(table);
		table.addMouseMotionListener(new MouseAdapter(){  
		    public void mouseMoved(MouseEvent e) {  
		        int row=table.rowAtPoint(e.getPoint());  
		        int col=table.columnAtPoint(e.getPoint());  
		        if(row>-1 && col>-1){  
		            Object value=table.getValueAt(row, col);  
		            if(null!=value && !"".equals(value))  
		                table.setToolTipText(value.toString());//悬浮显示单元格内容  
		            else  
		                table.setToolTipText(null);//关闭提示
		        }
		    }
		});
		scrollPane.setViewportView(table);
	}
	
	private ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2) {		//求交集方法
    	HashSet<Integer> hashSet=new HashSet<Integer>();
        //list3储存交集
    	ArrayList<Integer> list3 = new ArrayList<Integer>();
    	for (Integer i:list1) {
            hashSet.add(i);
        }
        for (Integer i:list2) {
            if(hashSet.add(i)==false){//add失败则认为有相同元素，存放到list3
                list3.add(i);
            }
        }
        return list3;
    }
	
	private void FitTableColumns(JTable myTable) {
        JTableHeader header = myTable.getTableHeader();
        int rowCount = myTable.getRowCount();
 
        Enumeration columns = myTable.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) myTable.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(myTable, column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) myTable.getCellRenderer(row, col)
                        .getTableCellRendererComponent(myTable, myTable.getValueAt(row, col), false, false, row, col)
                        .getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column);
            column.setWidth(width + myTable.getIntercellSpacing().width + 10);
            myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        }
    }
	private String shift(String stri) throws IOException{		//繁简字体转换
    	String result="";
    	try{
      		File file_d = new File(".\\dictionary.txt");
      		BufferedReader word = new BufferedReader(new InputStreamReader(new FileInputStream(file_d)));
      		String tradition="";
      		for (int i =0;i<stri.length() ;i++) {
        		boolean flag= false;
        		String temp=stri.substring(i, (i+1));
        		word.mark( ( int )file_d.length() + 1 );
        		while((tradition = word.readLine()) != null) {
          			/* 返回数组下标从indexOf("<")+1到indexOf(">")的内容，也就是尖括号“<>”里面的内容*/
          			String tra_word = tradition.substring((int)tradition.indexOf("<")+1,(int) tradition.indexOf(">"));
          			//读取繁体部分，方法和上一条语句一样
          			String sam_word = tradition.substring(tradition.lastIndexOf("<")+1,tradition.lastIndexOf(">"));
          			if(temp.equals(tra_word)) {//输入词语存在文本则执行
            			result+=sam_word;
            			flag = true;
            			break;
          			}
        		} 
        		if(!flag){
          			result+=temp;
        		}
        		word.reset();
      		}
    	}catch(FileNotFoundException e){
      		e.printStackTrace();
    	}
    	return result;
  	}
}

