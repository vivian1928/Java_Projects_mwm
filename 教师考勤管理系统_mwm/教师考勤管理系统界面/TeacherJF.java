package 教师考勤管理系统界面;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import 数据库连接操作.Affair;
import 数据库连接操作.RequestSelect;
import 数据库连接操作.TeacherAttendAffairSql;
import 数据库连接操作.TeacherDao;
import 系统后台操作.AffairRequestTable;
import 系统后台操作.AttendAffairModel;
import 系统后台操作.AttendAffairTable;
import 系统后台操作.AttendSelect_1;
import 系统后台操作.AttendTableModel;
import 系统后台操作.Main;

import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

class Attend{
	public String rstart = "";
	public String rend = "";
	public String teacher_no  ="";
	public String consequence = "";
}
public class TeacherJF extends JFrame {

	private JPanel contentPane;
	public static ResultSet rs;
	public static ResultSet rsCount;
	public static int mainview = 1;
	private boolean attendtype = false;	//false是上班，true是下班
	private Attend attendfirst = new Attend();	//上班打卡记录
	private AttendAffairModel aam;
	private AttendSelect_1 as1 = new AttendSelect_1();
	private AttendTableModel atm;
	private RequestSelect requestselect = new RequestSelect();
	public static ArrayList<String> rstart = new ArrayList<String>();
	public static ArrayList<String> rend = new ArrayList<String>();
	public static ArrayList<String> consequence = new ArrayList<String>();
	public static ArrayList<String> a_type = new ArrayList<String>();
	public static ArrayList<String> a_start = new ArrayList<String>();
	public static ArrayList<String> a_end = new ArrayList<String>();
	public static ArrayList<String> reason = new ArrayList<String>();
	public static ArrayList<String> admin_no = new ArrayList<String>();
	public static ArrayList<String> admin_name = new ArrayList<String>();
	public static ArrayList<String> admin_telephone = new ArrayList<String>();
	public static ArrayList<String> admin_mailbox = new ArrayList<String>();
	public static ArrayList<String> astart = new ArrayList<String>();
	public static ArrayList<String> aend = new ArrayList<String>();
	public static ArrayList<String> atype = new ArrayList<String>();
	private AffairRequestTable art = new AffairRequestTable();
	private TableModel tModel1;
	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherJF frame = new TeacherJF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//组件
	private JLayeredPane layeredPane;
	private JTextField txt_tid;
	private JTextField txt_tna;
	private JTextField txt_tlx;
	private JTable table_Richeng;
	private JTable table_sjgl;
	private JTextField txt_reason;
	private JTable table_kq;
	private DateField panel_13 = new DateField();
	private DateField panel_14 = new DateField();
	private JPanel panel_1 = new JPanel();
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	final JPanel panel = new JPanel();
	private TeacherDao td=new TeacherDao();
	public static ArrayList<String> start_time = new ArrayList<String>();
	public static ArrayList<String> end_time = new ArrayList<String>();
	public static ArrayList<String> conseq = new ArrayList<String>();
	private TeacherAttendAffairSql taas = new TeacherAttendAffairSql();
	private AttendAffairTable aat = new AttendAffairTable();

	@SuppressWarnings("serial")
	
	public TeacherJF() {
		
		Dimension size5 = new Dimension(20, 22);	//设置年份和月份空隔的大小
		
		setTitle("\u6559\u5E08\u8003\u52E4\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 563);
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(1, 1));//将面板设置成网格布局，只定义一行一列，使图片充满整个面板，并可以随着面板的放大和缩小改变
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		Font font_1 = new Font("微软雅黑", Font.PLAIN, 14);		//表的字体
		
		JToolBar toolBar = new JToolBar();
		toolBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.setToolTipText("\u51FA\u5DEE\r\n");
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	
		toolBar.addSeparator(new Dimension(50,0));
		JButton btnNewButton_1 = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		toolBar.add(btnNewButton_1);
		toolBar.addSeparator(new Dimension(2,25));
		
		JButton btnNewButton = new JButton("\u8003\u52E4\u7EDF\u8BA1");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		toolBar.add(btnNewButton);
		
		JLabel label_23 = new JLabel("                                                                                                          ");
		toolBar.add(label_23);
		
		JButton button_3 = new JButton("\u6253\u5361");
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(button_3);
		
		JLabel label_21 = new JLabel("\u60A8\u597D");
		toolBar.add(label_21);
		
		JButton button_1 = new JButton("\u6CE8\u9500");
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toolBar.add(button_1);
		//toolBar.add();
		

		contentPane.add(panel, BorderLayout.CENTER);
		final CardLayout card =new CardLayout();
		panel.setLayout(card);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.first(panel);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taas.sqlaction();
				table_kq = new JTable(tModel1);
				card.next(panel);
			}
		});
		
		tabbedPane.setToolTipText("");
		panel.add(tabbedPane, "name_8551727893600");
		
		tabbedPane.addTab("个人信息", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3    \u540D\uFF1A");
		lblNewLabel.setBounds(53, 28, 60, 15);
		panel_1.add(lblNewLabel);
		
		JLabel label_8 = new JLabel("\u7F16    \u53F7\uFF1A");
		label_8.setBounds(53, 58, 60, 15);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("\u6027    \u522B\uFF1A");
		label_9.setBounds(53, 88, 69, 15);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		label_10.setBounds(53, 118, 69, 15);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		label_11.setBounds(217, 148, 60, 15);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("\u7C4D    \u8D2F\uFF1A");
		label_12.setBounds(53, 148, 60, 15);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("\u5B66    \u5386\uFF1A");
		label_13.setBounds(217, 28, 60, 15);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("\u804C    \u4F4D\uFF1A");
		label_14.setBounds(217, 118, 60, 15);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("\u5B66    \u9662\uFF1A");
		label_15.setBounds(217, 58, 60, 15);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("\u4E13    \u4E1A\uFF1A");
		label_16.setBounds(217, 88, 60, 15);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("\u901A\u8BAF\u5730\u5740\uFF1A");
		label_17.setBounds(463, 118, 60, 15);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_18.setBounds(463, 28, 60, 15);
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel("\u8054\u7CFB\u90AE\u7BB1\uFF1A");
		label_19.setBounds(463, 58, 60, 15);
		panel_1.add(label_19);
		
		JLabel lblQq = new JLabel("qq\u6216\u5FAE\u4FE1\uFF1A");
		lblQq.setBounds(463, 88, 60, 15);
		panel_1.add(lblQq);
		
		JLabel label_20 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_20.setBounds(463, 148, 69, 15);
		panel_1.add(label_20);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 173, 900, 242);
		panel_1.add(scrollPane);
		
	//	table_Richeng = new JTable();	日程表
		requestselect.sqlaction();
	
		TableModel tModel = new AbstractTableModel() {
			//拿到有多少条记录
			public int count = 0;
			public int count1 = 0;
			public int rowCount() {
	//			Statement stmtCount = DB.createStmt(conn);
				String sqlCount = "select count(*) as 行数  from affairMWM where teacher_no = " + Main.teacher.getNo();
				try {
					rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rsCount.next();
					count = rsCount.getInt("行数");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				sqlCount = "select count(*) as 行数  from requestMWM where teacher_no = " + Main.teacher.getNo();
				try {
					rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rsCount.next();
					count1 = rsCount.getInt("行数");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return count + count1;
			}
			//表格的行数
			public int getRowCount() {return rowCount();}
			//表格的列数
			public int getColumnCount() {return 9;}
			
			public Object getValueAt(int row, int col) {
				switch(col) {
				case 0:
					if(row < count) {
						if(Integer.valueOf(a_type.get(row)) == 1) {
							return "出差";
						}else if(Integer.valueOf(a_type.get(row)) == 2) {
							return "请假";
						}else if(Integer.valueOf(a_type.get(row)) == 3) {
							return "加班";
						}
					}else {
						if(Integer.valueOf(a_type.get(row)) == 1) {
							return "修改个人信息";
						}else if(Integer.valueOf(a_type.get(row)) == 2) {
							return "修改考勤信息";
						}else if(Integer.valueOf(a_type.get(row)) == 3) {
							return "修改请求信息";
						}
					}
				case 1:
					return a_start.get(row);
				case 2:
					return a_end.get(row);
				case 3:
					return reason.get(row);
				case 4:
					return admin_no.get(row);
				case 5:
					return admin_name.get(row);
				case 6:
					return admin_telephone.get(row);
				case 7:
					return admin_mailbox.get(row);
				case 8:
					if(admin_no.get(row) == null || admin_no.get(row).length() == 0) {
						return "未审核";
					}else {
						return "已通过";
					}
				}
				return null;
			}
			//设置表格的列名
			public final String[] columnName = {"事件类型","开始时间", "结束时间","原因","管理员编号","管理员姓名","管理员联系电话","管理员联系邮箱","审核状态"};
			public String getColumnName(int column) {
				return columnName[column];
			}
			public Class getColumnClass(int column) {
				return java.lang.String.class;	
	    	}
	
		};
//		add(scrollPane, BorderLayout.CENTER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		final JTable table = new JTable(tModel);
//		FitTableColumns(table);
		table.setFont(font_1);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		
		JLabel label_tname = new JLabel(Main.teacher.getName());
		label_tname.setBounds(117, 28, 90, 15);
		panel_1.add(label_tname);
		
		JLabel label_tno = new JLabel(Main.teacher.getNo());
		label_tno.setBounds(117, 58, 90, 15);
		panel_1.add(label_tno);
		
		JLabel label_tsex = new JLabel(Main.teacher.getSex());
		label_tsex.setBounds(117, 88, 90, 15);
		panel_1.add(label_tsex);
		
		JLabel label_tbir = new JLabel(Main.teacher.getBirth_year_month());
		label_tbir.setBounds(117, 118, 90, 15);
		panel_1.add(label_tbir);
		
		JLabel label_txl = new JLabel(Main.teacher.getEducation());
		label_txl.setBounds(287, 28, 140, 15);
		panel_1.add(label_txl);
		
		JLabel label_txy = new JLabel(Main.teacher.getCollege());
		label_txy.setBounds(287, 58, 140, 15);
		panel_1.add(label_txy);
		
		JLabel label_tzy = new JLabel(Main.teacher.getProfession());
		label_tzy.setBounds(287, 88, 140, 15);
		panel_1.add(label_tzy);
		
		JLabel label_tzw = new JLabel(Main.teacher.getProfession());
		label_tzw.setBounds(287, 118, 140, 15);
		panel_1.add(label_tzw);
		
		JLabel label_tph = new JLabel(Main.teacher.getTelephone());
		label_tph.setBounds(533, 28, 240, 15);
		panel_1.add(label_tph);
		
		JLabel label_temil = new JLabel(Main.teacher.getMailbox());
		label_temil.setBounds(533, 58, 240, 15);
		panel_1.add(label_temil);
		
		JLabel label_tqw = new JLabel(Main.teacher.getQqorwechat());
		label_tqw.setBounds(533, 88, 240, 15);
		panel_1.add(label_tqw);
		
		JLabel label_tadr = new JLabel(Main.teacher.getAddress());
		label_tadr.setBounds(533, 118, 240, 15);
		panel_1.add(label_tadr);
		
		JLabel label_tht = new JLabel(Main.teacher.getHometown());
		label_tht.setBounds(117, 148, 90, 15);
		panel_1.add(label_tht);
		
		JLabel label_tzz = new JLabel(Main.teacher.getPolitic());
		label_tzz.setBounds(287, 148, 140, 15);
		panel_1.add(label_tzz);
		
		JLabel label_tjg = new JLabel(Main.teacher.getIdentity());
		label_tjg.setBounds(533, 148, 240, 15);
		panel_1.add(label_tjg);
		
		final JPanel panel_6 = new JPanel();
		panel_6.setBounds(801, 10, 121, 142);
		panel_1.add(panel_6);
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("事件申请", null, panel_2, null);
		panel_2.setLayout(new GridLayout(1, 1));
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		
		JLabel label = new JLabel("\u6559\u5E08\u7F16\u53F7\uFF1A");
		label.setBounds(290, 26, 66, 15);
		panel_4.add(label);
		
		txt_tid = new JTextField();
		txt_tid.setEditable(false);
		txt_tid.setColumns(10);
		txt_tid.setBounds(365, 23, 153, 21);
		panel_4.add(txt_tid);
		txt_tid.setText(Main.teacher.getNo());
		
		JLabel label_2 = new JLabel("\u59D3    \u540D\uFF1A");
		label_2.setBounds(290, 63, 66, 15);
		panel_4.add(label_2);
		
		txt_tna = new JTextField();
		txt_tna.setEditable(false);
		txt_tna.setColumns(10);
		txt_tna.setBounds(365, 60, 153, 21);
		panel_4.add(txt_tna);
		txt_tna.setText(Main.teacher.getName());
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_3.setBounds(290, 103, 66, 15);
		panel_4.add(label_3);
		
		txt_tlx = new JTextField();
		txt_tlx.setEditable(false);
		txt_tlx.setColumns(10);
		txt_tlx.setBounds(365, 100, 153, 21);
		panel_4.add(txt_tlx);
		txt_tlx.setText(Main.teacher.getTelephone());
		
		JLabel label_4 = new JLabel("\u8BF7\u5047\u7C7B\u578B\uFF1A");
		label_4.setBounds(290, 138, 66, 15);
		panel_4.add(label_4);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBounds(365, 134, 153, 23);
		panel_4.add(comboBox);
		comboBox.addItem("出差");
		comboBox.addItem("加班");
		comboBox.addItem("请假");
		comboBox.addItem("修改个人信息");
		comboBox.addItem("修改考勤信息");
		comboBox.addItem("修改请求信息");
		
		JLabel label_5 = new JLabel("------------\u8BF7\u9009\u62E9\u8BF7\u5047\u65F6\u95F4------------");
		label_5.setBounds(290, 266, 228, 15);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("\u5F00\u59CB\u65F6\u95F4\uFF1A");
		label_6.setBounds(290, 295, 66, 15);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("\u7ED3\u675F\u65F6\u95F4\uFF1A");
		label_7.setBounds(290, 332, 66, 15);
		panel_4.add(label_7);
		
		JButton btn_ok = new JButton("\u63D0\u4EA4");
		btn_ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_ok.setBounds(364, 393, 93, 23);
		panel_4.add(btn_ok);
		
		txt_reason = new JTextField();
		txt_reason.setHorizontalAlignment(SwingConstants.LEFT);
		txt_reason.setBounds(365, 163, 153, 97);
		panel_4.add(txt_reason);
		txt_reason.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u539F    \u56E0\uFF1A");
		lblNewLabel_1.setBounds(290, 163, 66, 15);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(358, 284, 160, 35);
		panel_4.add(panel_7);
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, "name_8972912052384");
		panel_3.setLayout(null);
		
		Dimension size4 = new Dimension(160, 22);	//设置DateField的大小
		final DateField panel_8 = new DateField();
		panel_8.setPreferredSize(size4);
		panel_7.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(358, 320, 160, 28);
		panel_4.add(panel_9);
		
		final DateField panel_10 = new DateField();
		panel_10.setPreferredSize(size4);
		panel_9.add(panel_10);
		
		JLabel label_41 = new JLabel("\u4ECE");
		label_41.setBounds(136, 34, 66, 15);
		panel_3.add(label_41);
		
		JLabel label_42 = new JLabel("\u81F3");
		label_42.setBounds(340, 34, 30, 15);
		panel_3.add(label_42);
		
		JButton button_5 = new JButton("\u67E5\u8BE2");
		button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_5.setBounds(772, 20, 120, 23);
		panel_3.add(button_5);
		
		JLabel label_43 = new JLabel("\u65F6    \u95F4\uFF1A");
		label_43.setBounds(62, 34, 64, 15);
		panel_3.add(label_43);
		
		JLabel label_44 = new JLabel("\u4E8B\u4EF6\u7C7B\u578B\uFF1A");
		label_44.setBounds(62, 63, 66, 15);
		panel_3.add(label_44);
		
		JButton button_6 = new JButton("\u672C\u6708\u8003\u52E4\u60C5\u51B5");
		button_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_6.setBounds(772, 54, 120, 23);
		panel_3.add(button_6);
		
		JRadioButton checkBox_5 = new JRadioButton("\u6B63\u5E38");
		checkBox_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox_5.setBounds(136, 58, 100, 23);
		panel_3.add(checkBox_5);
		
		JRadioButton checkBox_6 = new JRadioButton("\u8FDF\u5230");
		checkBox_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox_6.setBounds(268, 59, 100, 23);
		panel_3.add(checkBox_6);
		
		JRadioButton checkBox_7 = new JRadioButton("\u65E9\u9000");
		checkBox_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox_7.setBounds(400, 59, 100, 23);
		panel_3.add(checkBox_7);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(checkBox_5);
		bg2.add(checkBox_6);
		bg2.add(checkBox_7);
		
		
		String sql = "select * from attendMWM where teacher_no = " + Main.teacher.getNo();
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		rstart = new ArrayList<String>();
		rend = new ArrayList<String>();
		consequence = new ArrayList<String>();
		try {
			while(rs.next()) {
				rstart.add(rs.getString("rstart"));
				rend.add(rs.getString("rend"));
				consequence.add(rs.getString("consequence"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		sql = "select * from affairMWM where teacher_no = " + Main.teacher.getNo();
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		astart = new ArrayList<String>();
		aend = new ArrayList<String>();
		atype = new ArrayList<String>();
		try {
			while(rs.next()) {
				astart.add(rs.getString("affair_start"));
				aend.add(rs.getString("affair_end"));
				atype.add(rs.getString("affair_type"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(60, 120, 869, 334);
		panel_3.add(scrollPane_2);
		
		tModel1 = new AbstractTableModel() {
			//拿到有多少条记录
			public int count = 0;
			public int count1 = 0;
			public int rowCount() {
	//			Statement stmtCount = DB.createStmt(conn);
				String sqlCount = "select count(*) as 行数  from attendMWM where teacher_no = " + Main.teacher.getNo();
				try {
					rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rsCount.next();
					count = rsCount.getInt("行数");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				sqlCount = "select count(*) as 行数  from affairMWM where teacher_no = " + Main.teacher.getNo();
				try {
					rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					rsCount.next();
					count1 = rsCount.getInt("行数");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return count + count1;
			}
			//表格的行数
			public int getRowCount() {return rowCount();}
			//表格的列数
			public int getColumnCount() {return 3;}
			
			public Object getValueAt(int row, int col) {
				System.out.println("考勤行数为" + count);
				if(row < count) {
					switch(col) {
					case 0:
						return rstart.get(row);
					case 1:
						return rend.get(row);
					case 2:
						return consequence.get(row);
					}
				}else {
					switch(col) {
					case 0:
						return astart.get(row - count);
					case 1:
						return aend.get(row - count);
					case 2:
						if(Integer.valueOf(atype.get(row - count)) == 1) {
							return "出差";
						}else if(Integer.valueOf(atype.get(row - count)) == 2) {
							return "请假";
						}else if(Integer.valueOf(atype.get(row - count)) == 3) {
							return "加班";
						}
					}
				}
				return null;
			}
			//设置表格的列名
			public final String[] columnName = {"开始时间", "结束时间","情况"};
			public String getColumnName(int column) {
				return columnName[column];
			}
			public Class getColumnClass(int column) {
				return java.lang.String.class;	
	    	}
	
		};
//		taas.sqlaction();
		
		table_kq = new JTable(tModel1);
//		FitTableColumns(table_kq);
		table_kq.setFont(font_1);
//		table_kq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_kq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_kq.addMouseMotionListener(new MouseAdapter(){  
		    public void mouseMoved(MouseEvent e) {  
		        int row=table_kq.rowAtPoint(e.getPoint());  
		        int col=table_kq.columnAtPoint(e.getPoint());  
		        if(row>-1 && col>-1){  
		            Object value=table_kq.getValueAt(row, col);  
		            if(null!=value && !"".equals(value))  
		            	table_kq.setToolTipText(value.toString());//悬浮显示单元格内容  
		            else  
		            	table_kq.setToolTipText(null);//关闭提示
		        }
		    }
		});
		scrollPane_2.setViewportView(table_kq);
		
		JPanel panel_15 = new JPanel();
		panel_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_15.setBounds(160, 24, 162, 30);
		panel_3.add(panel_15);
		
		
		DateField dateField =  new DateField();
		dateField.setPreferredSize(size4);
		panel_15.add(dateField);
		
		JPanel panel_16 = new JPanel();
		panel_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_16.setBounds(367, 24, 162, 30);
		panel_3.add(panel_16);
		
		DateField dateField_1 = new DateField();
		dateField_1.setPreferredSize(size4);		
		panel_16.add(dateField_1);
		
		JButton button_2 = new JButton("\u6062\u590D");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from attendMWM where teacher_no = " + Main.teacher.getNo();
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					rs = Main.sqlconnect.stmt.executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Main.sqlconnect.ct.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rstart = new ArrayList<String>();
				rend = new ArrayList<String>();
				consequence = new ArrayList<String>();
				try {
					while(rs.next()) {
						rstart.add(rs.getString("rstart"));
						rend.add(rs.getString("rend"));
						consequence.add(rs.getString("consequence"));
					}
				} catch (SQLException e2) {
					e2.printStackTrace();	
				}
				sql = "select * from affairMWM where teacher_no = " + Main.teacher.getNo();
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					rs = Main.sqlconnect.stmt.executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Main.sqlconnect.ct.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				final ArrayList<String> astart = new ArrayList<String>();
				final ArrayList<String> aend = new ArrayList<String>();
				final ArrayList<String> atype = new ArrayList<String>();
				try {
					while(rs.next()) {
						astart.add(rs.getString("affair_start"));
						aend.add(rs.getString("affair_end"));
						atype.add(rs.getString("affair_type"));
					}
				} catch (SQLException e2) {
					e2.printStackTrace();	
				}
				table_kq = new JTable(tModel1);
//				FitTableColumns(table_kq);
				table_kq.setFont(font_1);
//				table_kq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_kq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_kq.addMouseMotionListener(new MouseAdapter(){  
				    public void mouseMoved(MouseEvent e) {  
				        int row=table_kq.rowAtPoint(e.getPoint());  
				        int col=table_kq.columnAtPoint(e.getPoint());  
				        if(row>-1 && col>-1){  
				            Object value=table_kq.getValueAt(row, col);  
				            if(null!=value && !"".equals(value))  
				            	table_kq.setToolTipText(value.toString());//悬浮显示单元格内容  
				            else  
				            	table_kq.setToolTipText(null);//关闭提示
				        }
				    }
				});
				scrollPane_2.setViewportView(table_kq);
			}
		});
		button_2.setBounds(772, 87, 120, 23);
		panel_3.add(button_2);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("事件管理", null, panel_5, null);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(43, 121, 901, 306);
		panel_5.add(scrollPane_1);
		
		
		//事件管理表
		table_sjgl = new JTable(tModel);
		FitTableColumns(table_sjgl);
		table_sjgl.setFont(font_1);
		table_sjgl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_sjgl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table_sjgl.addMouseMotionListener(new MouseAdapter(){  
		    public void mouseMoved(MouseEvent e) {  
		        int row=table_sjgl.rowAtPoint(e.getPoint());  
		        int col=table_sjgl.columnAtPoint(e.getPoint());  
		        if(row>-1 && col>-1){  
		            Object value=table_sjgl.getValueAt(row, col);  
		            if(null!=value && !"".equals(value))  
		            	table_sjgl.setToolTipText(value.toString());//悬浮显示单元格内容  
		            else  
		            	table_sjgl.setToolTipText(null);//关闭提示
		        }
		    }
		});
		scrollPane_1.setViewportView(table_sjgl);
		
		JLabel label_1 = new JLabel("\u4ECE");
		label_1.setBounds(117, 27, 66, 15);
		panel_5.add(label_1);
		
		JLabel label_22 = new JLabel("\u81F3");
		label_22.setBounds(313, 27, 66, 15);
		panel_5.add(label_22);
		
		JButton btn_rq = new JButton("\u67E5\u8BE2");
		btn_rq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_rq.setBounds(800, 24, 120, 23);
		panel_5.add(btn_rq);
		
		JLabel label_38 = new JLabel("\u65F6    \u95F4\uFF1A");
		label_38.setBounds(43, 27, 64, 15);
		panel_5.add(label_38);
		
		JLabel label_39 = new JLabel("\u4E8B\u4EF6\u7C7B\u578B\uFF1A");
		label_39.setBounds(43, 56, 66, 15);
		panel_5.add(label_39);
		
		JButton btn_rqmon = new JButton("\u67E5\u770B\u672C\u6708\u7533\u8BF7");
		btn_rqmon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_rqmon.setBounds(800, 57, 120, 23);
		panel_5.add(btn_rqmon);
		
		final JRadioButton checkBox_1 = new JRadioButton("\u51FA\u5DEE");
		checkBox_1.setBounds(117, 51, 100, 23);
		panel_5.add(checkBox_1);
		
		final JRadioButton checkBox_2 = new JRadioButton("\u8BF7\u5047");
		checkBox_2.setBounds(259, 52, 100, 23);
		panel_5.add(checkBox_2);
		
		final JRadioButton checkBox_3 = new JRadioButton("\u52A0\u73ED");
		checkBox_3.setBounds(400, 52, 100, 23);
		panel_5.add(checkBox_3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(checkBox_1);
		bg.add(checkBox_2);
		bg.add(checkBox_3);
		
		JLabel label_40 = new JLabel("\u4E8B\u4EF6\u72B6\u6001\uFF1A");
		label_40.setBounds(41, 86, 66, 15);
		panel_5.add(label_40);
		
		final JRadioButton checkBox = new JRadioButton("\u5DF2\u901A\u8FC7");
		checkBox.setBounds(117, 82, 100, 23);
		panel_5.add(checkBox);
		
		final JRadioButton checkBox_4 = new JRadioButton("\u5F85\u5BA1\u6838");
		checkBox_4.setBounds(259, 82, 100, 23);
		panel_5.add(checkBox_4);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(checkBox);
		bg1.add(checkBox_4);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(141, 17, 162, 30);
		panel_5.add(panel_11);
		
		panel_13.setPreferredSize(size4);
		panel_11.add(panel_13);
		
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(339, 17, 162, 30);
		panel_5.add(panel_12);
		
		panel_14.setPreferredSize(size4);
		panel_12.add(panel_14);
		
		JButton button = new JButton("\u6062\u590D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				requestselect.sqlaction();
				table_sjgl = new JTable(tModel);
				FitTableColumns(table_sjgl);
				table_sjgl.setFont(font_1);
//				table_sjgl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_sjgl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_sjgl.addMouseMotionListener(new MouseAdapter(){  
				    public void mouseMoved(MouseEvent e) {  
				        int row=table_sjgl.rowAtPoint(e.getPoint());  
				        int col=table_sjgl.columnAtPoint(e.getPoint());  
				        if(row>-1 && col>-1){  
				            Object value=table_sjgl.getValueAt(row, col);  
				            if(null!=value && !"".equals(value))  
				            	table_sjgl.setToolTipText(value.toString());//悬浮显示单元格内容  
				            else  
				            	table_sjgl.setToolTipText(null);//关闭提示
				        }
				    }
				});
				scrollPane_1.setViewportView(table_sjgl);
			}
		});
		button.setBounds(800, 90, 120, 23);
		panel_5.add(button);

		//提交申请按钮
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean affair_or_request = false;
				Affair a = new Affair();
				a.setTno(Main.teacher.getNo());				
				a.setAffair_type((String) comboBox.getSelectedItem());
				a.setReason(txt_reason.getText());
				a.setAffair_start(panel_8.getTfDate());
				a.setAffair_end(panel_10.getTfDate());
				//需要增加一个将a放入数据库表的方法，还需要对相应数据进行处理
				if(a.getAffair_type()=="出差") {
					a.setAffair_type("1");
					affair_or_request = false;
				}
				else if(a.getAffair_type()=="请假") {
					a.setAffair_type("2");
					affair_or_request = false;
				}
				else if(a.getAffair_type()=="加班") {
					a.setAffair_type("3");
					affair_or_request = false;
				}
				else if(a.getAffair_type()=="修改个人信息") {
					a.setAffair_type("1");
					affair_or_request = true;
				}
				else if(a.getAffair_type()=="修改考勤信息") {
					a.setAffair_type("2");
					affair_or_request = true;
				}
				else if(a.getAffair_type()=="修改请求信息") {
					a.setAffair_type("3");
					affair_or_request = true;	
				}
				//往affair表中增加一项数据----考虑用触发器阻止相同的申请
				if(judgeday(a.getAffair_start(), a.getAffair_end())) {
					if(!affair_or_request) {
						td.add_Affair(a);
						requestselect.sqlaction();
					}else {
						td.add_request(a);
						requestselect.sqlaction();
					}
				}else {
					JOptionPane.showMessageDialog(null, "日期不正确，请重新选择！");
				}
			}
		});

		//查询申请
		btn_rq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affair af=new Affair();
				//时间查询
				af.affair_start=panel_13.getTfDate();
				af.affair_end=panel_14.getTfDate();
				String sql = "select * from affairMWM where teacher_no = \'"+ Main.teacher.getNo() +"\' and  affair_start > '"+ af.affair_start + "'";  
				String sql1 = "select count(*) as 行数 from affairMWM where teacher_no = \'"+ Main.teacher.getNo() +"\' and  affair_start > '"+ af.affair_start + "'";  
				
				//类型查询
				//若无其他条件或全选,不做操作
				if((!checkBox_1.isSelected()&&!checkBox_2.isSelected()&&!checkBox_3.isSelected())||(checkBox_1.isSelected()&&checkBox_2.isSelected()&&checkBox_3.isSelected())) {
					
				}else {
					//选择出差
					if(checkBox_1.isSelected())
					{
						sql+=" and affair_type = 1 ";
						sql1+=" and affair_type = 1 ";
					}
					if(checkBox_2.isSelected())
					{
						sql+=" and affair_type = 2 ";
						sql1+=" and affair_type = 2 ";
					}
					if(checkBox_3.isSelected())
					{
						sql+=" and affair_type = 3 ";
						sql1+=" and affair_type = 3 ";
					}
					//状态查询--------表中未存在
					if(!checkBox.isSelected()&&!checkBox_4.isSelected());
					else if(checkBox.isSelected())		//已通过
					{
						sql += " and admin_no is not null and datalength(admin_no)!=0 ";
						sql1 += " and admin_no is not null and datalength(admin_no)!=0 ";
					}
					else if(checkBox_4.isSelected())		//待审核
					{
						sql += " and (admin_no is null or datalength(admin_no) = 0)";
						sql1 += " and (admin_no is null or datalength(admin_no) = 0) ";
					}
					sql+= " order by affair_no ASC ";
					
					//执行查询
					art.arSql(sql);
					//放入表中
					aam = new AttendAffairModel(sql1);
					
					table_sjgl = new JTable(aam);
//					FitTableColumns(table_sjgl);
					table_sjgl.setFont(font_1);
//					table_sjgl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table_sjgl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					table_sjgl.addMouseMotionListener(new MouseAdapter(){  
					    public void mouseMoved(MouseEvent e) {  
					        int row=table_sjgl.rowAtPoint(e.getPoint());  
					        int col=table_sjgl.columnAtPoint(e.getPoint());  
					        if(row>-1 && col>-1){  
					            Object value=table_sjgl.getValueAt(row, col);  
					            if(null!=value && !"".equals(value))  
					            	table_sjgl.setToolTipText(value.toString());//悬浮显示单元格内容  
					            else  
					            	table_sjgl.setToolTipText(null);//关闭提示
					        }
					    }
					});
					scrollPane_1.setViewportView(table_sjgl);
				}
			}

			
		});
		
		
		//查询本月申请
		btn_rqmon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取当前月份，筛选本月的申请
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				String date = year + "-" + ( month<10 ? "0" + month : month);
				String sqlmonth = "select * from affairMWM where teacher_no = '"+ Main.teacher.getNo() +"' and  affair_start >= '"+ date + "-01' and affair_end <= '"+ date + "-31' order by affair_no ASC";
				String sqlmonth1 = "select count(*) as 行数 from affairMWM where teacher_no = '"+ Main.teacher.getNo() +"' and  affair_start >= '"+ date + "-01' and affair_end <= '"+ date + "-31'";
				//执行查询	
				art.arSql(sqlmonth);
				//放入表中
				aam = new AttendAffairModel(sqlmonth1);
				
				table_sjgl = new JTable(aam);
				FitTableColumns(table_sjgl);
				table_sjgl.setFont(font_1);
				table_sjgl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_sjgl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_sjgl.addMouseMotionListener(new MouseAdapter(){  
				    public void mouseMoved(MouseEvent e) {  
				        int row=table_sjgl.rowAtPoint(e.getPoint());  
				        int col=table_sjgl.columnAtPoint(e.getPoint());  
				        if(row>-1 && col>-1){  
				            Object value=table_sjgl.getValueAt(row, col);  
				            if(null!=value && !"".equals(value))  
				            	table_sjgl.setToolTipText(value.toString());//悬浮显示单元格内容  
				            else  
				            	table_sjgl.setToolTipText(null);//关闭提示
				        }
				    }
				});
				scrollPane_1.setViewportView(table_sjgl);
				//放入表格中
			}
		});
		
		//考勤的条件查询
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Affair af=new Affair();
				//时间查询
				af.affair_start=dateField.getTfDate();
				af.affair_end=dateField_1.getTfDate();
				//需改正
				String sql = "select * from attendMWM where teacher_no = '"+ Main.teacher.getNo() +"' and  rstart >='"+ af.affair_start + "' and rend <= '"+ af.affair_end + "'";  
				String sql1 = "select count(*) as 行数 from attendMWM where teacher_no = '"+ Main.teacher.getNo() +"' and  rstart >='"+ af.affair_start + "' and rend <= '"+ af.affair_end + "'";  
				//类型查询
				//若无其他条件或全选,不做操作
				if((!checkBox_5.isSelected()&&!checkBox_6.isSelected()&&!checkBox_7.isSelected())||(checkBox_5.isSelected()&&checkBox_6.isSelected()&&checkBox_7.isSelected())) {
					
				}else {
					//选择出差
					if(checkBox_5.isSelected())
					{
						sql+=" and consequence = '正常' ";
						sql1+=" and consequence = '正常' ";
					}
					else if(checkBox_6.isSelected())
					{
						sql+=" and consequence = '迟到' ";
						sql1+=" and consequence = '迟到' ";
					}
					else if(checkBox_7.isSelected())
					{
						sql+=" and consequence = '早退' ";
						sql1+=" and consequence = '早退' ";
					}
					sql+= " order by rstart ASC ";
					as1.arSql(sql);
					//放入表中
					atm = new AttendTableModel(sql1);
					
					table_kq = new JTable(atm);
//					FitTableColumns(table_kq);
					table_kq.setFont(font_1);
//					table_kq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table_kq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					table_kq.addMouseMotionListener(new MouseAdapter(){  
					    public void mouseMoved(MouseEvent e) {  
					        int row=table_kq.rowAtPoint(e.getPoint());  
					        int col=table_kq.columnAtPoint(e.getPoint());  
					        if(row>-1 && col>-1){  
					            Object value=table_kq.getValueAt(row, col);  
					            if(null!=value && !"".equals(value))  
					            	table_kq.setToolTipText(value.toString());//悬浮显示单元格内容  
					            else  
					            	table_kq.setToolTipText(null);//关闭提示
					        }
					    }
					});
					scrollPane_2.setViewportView(table_kq);
				}
			}
		});
		
		//本月考勤情况
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//获取当前月份，筛选本月的申请
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				String date = year + "-" + ( month<10 ? "0" + month : month);
				String sqlmonth = "select * from attendMWM where teacher_no = '"+ Main.teacher.getNo() +"' and   rstart >= '"+ date + "-01' and rend <= '"+ date + "-31' order by rstart ASC";
				String sqlmonth1 = "select count(*) as 行数 from attendMWM where teacher_no = '"+ Main.teacher.getNo() +"' and   rstart >= '"+ date + "-01' and rend <= '"+ date + "-31'";
				as1.arSql(sqlmonth);
				//放入表中
				atm = new AttendTableModel(sqlmonth1);
				
				table_kq = new JTable(atm);
//				FitTableColumns(table_kq);
				table_kq.setFont(font_1);
//				table_kq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_kq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_kq.addMouseMotionListener(new MouseAdapter(){  
				    public void mouseMoved(MouseEvent e) {  
				        int row=table_kq.rowAtPoint(e.getPoint());  
				        int col=table_kq.columnAtPoint(e.getPoint());  
				        if(row>-1 && col>-1){  
				            Object value=table_kq.getValueAt(row, col);  
				            if(null!=value && !"".equals(value))  
				            	table_kq.setToolTipText(value.toString());//悬浮显示单元格内容  
				            else  
				            	table_kq.setToolTipText(null);//关闭提示
				        }
				    }
				});
				scrollPane_2.setViewportView(table_kq);
				
			}
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance();
				int second = cal.get(Calendar.SECOND);
				int minute = cal.get(Calendar.MINUTE);
				int hour = cal.get(Calendar.HOUR_OF_DAY);
				int year =cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				int day =cal.get(Calendar.DATE);
				String sql_1 = null;
				hour = 8;
				if(!attendtype && hour < 7 || hour > 20)	//如果在7点之前或者20点之后打卡
				{
					JOptionPane.showMessageDialog(null, "未到规定打卡时间");
				}
				if(!attendtype && hour >= 7 && hour < 8)	//如果此时是上班打卡并且在7-8点
				{
					//正常上班打卡------
					attendfirst.rstart = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
					attendfirst.teacher_no = Main.teacher.getNo();
					attendfirst.rend = "";
					attendfirst.consequence = "正常";
					attendtype = true;
					
					JOptionPane.showMessageDialog(null, "打卡成功");
				}
				if(!attendtype && hour >= 8 && hour < 18)	//如果此时是上班打卡并且在8点之后，18点之前
				{
					//记录迟到
					attendfirst.rstart = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
					attendfirst.teacher_no = Main.teacher.getNo();
					attendfirst.rend = "";
					attendfirst.consequence = "迟到";
					attendtype = true;
					
					JOptionPane.showMessageDialog(null, "打卡成功");
				}
				hour = 17;
				if(attendtype && hour < 7 || hour > 20)	//如果在7点之前或者20点之后打卡
				{
					JOptionPane.showMessageDialog(null, "未到规定打卡时间");
				}
				if(attendtype && hour > 8 && hour < 18) {		//如果此时是下班打卡并且在18点之前
					attendfirst.rend = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
					if(!attendfirst.consequence.equals("迟到")) {
						attendfirst.consequence = "早退";
					}
					attendtype = false;
					sql_1 = "insert into attendMWM values(";
					sql_1 += "\'"+ attendfirst.rstart +"\'," + "\'"+ attendfirst.rend +"\'," + "\'"+ Main.teacher.getNo() +"\'," + "\'"+ attendfirst.consequence +"\')";
					try {
						Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						Main.sqlconnect.stmt.executeUpdate(sql_1);
						Main.sqlconnect.ct.commit();
			        }catch(Exception e1) {
			            e1.printStackTrace();
			        }
					taas.sqlaction();
					table_kq = new JTable(aat);
				}
				if(attendtype && hour >= 18 && hour < 20) {		//如果此事是下班打卡并且在18点以后，20点以前
					attendfirst.rend = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
					sql_1 = "insert into attendMWM values(";
					sql_1 += "\'"+ attendfirst.rstart +"\'," + "\'"+ attendfirst.rend +"\'," + "\'"+ Main.teacher.getNo() +"\'," + "\'"+ attendfirst.consequence +"\')";
					try {
						Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						Main.sqlconnect.stmt.executeUpdate(sql_1);
						Main.sqlconnect.ct.commit();
			        }catch(Exception e1) {
			            e1.printStackTrace();
			        }
					JOptionPane.showMessageDialog(null, "打卡成功");
				}
				String sql = "select * from attendMWM where teacher_no = " + Main.teacher.getNo();
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					rs = Main.sqlconnect.stmt.executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Main.sqlconnect.ct.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				rstart = new ArrayList<String>();
				rend = new ArrayList<String>();
				consequence = new ArrayList<String>();
				try {
					while(rs.next()) {
						rstart.add(rs.getString("rstart"));
						rend.add(rs.getString("rend"));
						consequence.add(rs.getString("consequence"));
					}
				} catch (SQLException e2) {
					e2.printStackTrace();	
				}
				sql = "select * from affairMWM where teacher_no = " + Main.teacher.getNo();
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					rs = Main.sqlconnect.stmt.executeQuery(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Main.sqlconnect.ct.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				final ArrayList<String> astart = new ArrayList<String>();
				final ArrayList<String> aend = new ArrayList<String>();
				final ArrayList<String> atype = new ArrayList<String>();
				try {
					while(rs.next()) {
						astart.add(rs.getString("affair_start"));
						aend.add(rs.getString("affair_end"));
						atype.add(rs.getString("affair_type"));
					}
				} catch (SQLException e2) {
					e2.printStackTrace();	
				}
				table_kq = new JTable(tModel1);
//				FitTableColumns(table_kq);
				table_kq.setFont(font_1);
//				table_kq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_kq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table_kq.addMouseMotionListener(new MouseAdapter(){  
				    public void mouseMoved(MouseEvent e) {  
				        int row=table_kq.rowAtPoint(e.getPoint());  
				        int col=table_kq.columnAtPoint(e.getPoint());  
				        if(row>-1 && col>-1){  
				            Object value=table_kq.getValueAt(row, col);  
				            if(null!=value && !"".equals(value))  
				            	table_kq.setToolTipText(value.toString());//悬浮显示单元格内容  
				            else  
				            	table_kq.setToolTipText(null);//关闭提示
				        }
				    }
				});
				scrollPane_2.setViewportView(table_kq);
			}
		});
		
		//退出关闭窗口
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainview = 1;
				Main.login.paint();
			}			
		});
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private boolean judgeday(String start, String end) {
		if(Integer.valueOf(start.substring(0, 4)) < Integer.valueOf(end.substring(0, 4))) {
			return true;
		}else if(start.substring(0, 4).equals(end.substring(0, 4)) && Integer.valueOf(start.substring(5, 7)) < Integer.valueOf(end.substring(5, 7))) {
			return true;
		}else if(start.substring(5, 7).equals(end.substring(5, 7))&& Integer.valueOf(start.substring(8, 10)) < Integer.valueOf(end.substring(8, 10))) {
			return true;
		}else {
			return false;
		}
	}
}
