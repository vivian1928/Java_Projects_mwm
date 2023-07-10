package 教师考勤管理系统界面;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowStateListener;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import 数据库连接操作.SqlConnect;
import 系统后台操作.Account;
import 系统后台操作.Main;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private static boolean maximize = false;
	private JTextField usernumbertext;
	private JPasswordField codetext;
	private Boolean tBoolean = false;
	private Point fPoint;
	private Point sPoint;
	private Point tPoint;
	private FlowLayout flowLayout_1;
	private FlowLayout flowLayout_3;
	private FlowLayout flowLayout_4;
	private FlowLayout flowLayout_5;
	private FlowLayout flowLayout_2;
	private JLabel lblNewLabel_1;
	private ImageIcon icon_1;
	private ImageIcon icon_2;
	private ImageIcon icon_3;
	private ImageIcon icon_4;
	private ResultSet rs;
	public java.net.URL imgURL = Login.class.getResource("/images/wrong.png");
	public java.net.URL imgURL_1 = Login.class.getResource("/images/minimize.png");
	public java.net.URL imgURL_2 = Login.class.getResource("/images/maximize.png");
	public java.net.URL imgURL_3 = Login.class.getResource("/images/close.png");

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
					Login frame = new Login();
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
//					Login frame = new Login();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	private void move() {
		  Double fx,fy;
		  Double sx,sy;
		  Double tx,ty;
		  fx = fPoint.getX(); fy = fPoint.getY();
		  sx = sPoint.getX(); sy = sPoint.getY();
		  tx = tPoint.getX(); ty = tPoint.getY();
		  fPoint.setLocation(fx+tx-sx, fy+ty-sy);
		  setLocation(fPoint);
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		icon_1= new ImageIcon(imgURL);
		icon_2 = new ImageIcon(imgURL_1);
		icon_3 = new ImageIcon(imgURL_2);
		icon_4 = new ImageIcon(imgURL_3);
		Color c = new Color(240,240,240);//背影颜色随便设任意值,只起占位作用。
		setTitle("\u6559\u5E08\u8003\u52E4\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setBounds(100, 100, 1000, 563);
//		Container contentPane1=this.getContentPane();
		Dimension size = getSize();
		contentPane = new LoginPanel(size);
		contentPane.setBackground(c);
		contentPane.setOpaque(false);
//		LoginPanel loginpanel = new LoginPanel();
//		loginpanel.setSize(size.width, size.height);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		HashMap<TextAttribute, Object> hm = new HashMap<TextAttribute, Object>();
		hm.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); // 定义是否有下划线
		hm.put(TextAttribute.SIZE, 18); // 定义字号
		hm.put(TextAttribute.FAMILY, "微软雅黑"); // 定义字体名
		Font font = new Font(hm); // 生成字号为18，字体为宋体，字形带有下划线的字体
		HashMap<TextAttribute, Object> hm1 = new HashMap<TextAttribute, Object>();
		hm1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); // 定义是否有下划线
		hm1.put(TextAttribute.SIZE, 15); // 定义字号
		hm1.put(TextAttribute.FAMILY, "微软雅黑"); // 定义字体名
		Font font1 = new Font(hm1); // 生成字号为18，字体为宋体，字形带有下划线的字体
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
//				System.out.print(maximize);
				if(!maximize) {
					fPoint = getLocation();
					sPoint = arg0.getPoint();
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(!maximize) {
					tPoint = arg0.getPoint();
					move();
				}
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(c);
		panel.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton minbutton = new JButton(icon_2);
		minbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);//最小化窗体
				minbutton.setFocusPainted(false);
			}
		});
		Border emptyBorder = BorderFactory.createEmptyBorder();
		minbutton.setFocusPainted(false);
		minbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent arg0) {
				Border border = BorderFactory.createEtchedBorder();
				minbutton.setBorder(border);
				minbutton.setBackground(c);
				minbutton.setOpaque(false); //背景透明
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				minbutton.setBackground(c);
				minbutton.setOpaque(false); //背景透明
				minbutton.setBorder(emptyBorder);//除去边框 
			}
		});
		minbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minbutton.setBackground(c);
		minbutton.setOpaque(false); //背景透明
		minbutton.setBorder(emptyBorder);//除去边框 
		Dimension preferredSize = new Dimension(19,19);//设置尺寸
		minbutton.setPreferredSize(preferredSize);
		panel.add(minbutton);
		
		JButton maxbutton = new JButton(icon_3);
		maxbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!maximize) {
					setExtendedState(JFrame.MAXIMIZED_BOTH);//最大化窗体
					Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
					contentPane.setSize(size);
					maxbutton.setFocusPainted(false);
					maximize = true;
//					System.out.print(maximize);
					flowLayout_1.setVgap(100);
					flowLayout_3.setHgap(220);
					flowLayout_4.setHgap(220);
					flowLayout_5.setVgap(70);
				}else {
					setBounds(30, 30, 1000, 563);//缩小窗口
					Dimension size = getSize();
					contentPane.setSize(size);
					maxbutton.setFocusPainted(false);
					maximize = false;
//					System.out.print(maximize);
					flowLayout_1.setVgap(70);
					flowLayout_3.setHgap(130);
					flowLayout_4.setHgap(130);
					flowLayout_5.setVgap(20);
				}
			}
		});
		maxbutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		maxbutton.setFocusPainted(false);
		maxbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				Border border = BorderFactory.createEtchedBorder();
				maxbutton.setBorder(border);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				maxbutton.setBackground(c);
				maxbutton.setOpaque(false); //背景透明
				maxbutton.setBorder(emptyBorder);//除去边框 
			}
		});
		maxbutton.setBackground(c);
		maxbutton.setOpaque(false); 
		maxbutton.setBorder(emptyBorder);//除去边框 
		maxbutton.setPreferredSize(preferredSize);
		panel.add(maxbutton);
		
		JButton closebutton = new JButton(icon_4);
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closebutton.setFocusPainted(false);
				System.exit(0);
			}
		});
		closebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				Border border = BorderFactory.createEtchedBorder();
				closebutton.setBorder(border);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				closebutton.setBackground(c);
				closebutton.setOpaque(false); //背景透明
				closebutton.setBorder(emptyBorder);//除去边框 
			}
		});
		closebutton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closebutton.setFocusPainted(false);
		closebutton.setBackground(c);
		closebutton.setOpaque(false); 
		closebutton.setBorder(emptyBorder);//除去边框 
		closebutton.setPreferredSize(preferredSize);
		panel.add(closebutton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(c);
		panel_1.setOpaque(false);
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(c);
		panel_2.setOpaque(false);
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(c);
		panel_3.setOpaque(false);
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(c);
		panel_4.setOpaque(false);
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(c);
		panel_5.setOpaque(false);
		flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setVgap(70);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JLabel title = new JLabel("\u6559\u5E08\u8003\u52E4\u7BA1\u7406\u7CFB\u7EDF");
		title.setForeground(Color.white);
		title.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		panel_5.add(title);
		
		JPanel panel_6 = new JPanel();
		flowLayout_3 = (FlowLayout) panel_6.getLayout();
		flowLayout_3.setHgap(130);
		panel_6.setBackground(c);
		panel_6.setOpaque(false);
		panel_4.add(panel_6, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		flowLayout_4 = (FlowLayout) panel_7.getLayout();
		flowLayout_4.setHgap(130);
		panel_7.setBackground(c);
		panel_7.setOpaque(false);
		panel_4.add(panel_7, BorderLayout.EAST);
		
		JPanel panel_8 = new JPanel();
		flowLayout_5 = (FlowLayout) panel_8.getLayout();
		flowLayout_5.setVgap(20);
		panel_8.setBackground(c);
		panel_8.setOpaque(false);
		panel_4.add(panel_8, BorderLayout.SOUTH);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(c);
		panel_9.setOpaque(false);
		panel_9.setBorder(BorderFactory.createLineBorder(Color.white, 3));
		flowLayout_2 = (FlowLayout) panel_9.getLayout();
		flowLayout_2.setVgap(70);
		panel_4.add(panel_9, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(c);
		panel_10.setOpaque(false);
		panel_9.add(panel_10);
		panel_10.setLayout(new GridLayout(5, 2, 0, 20));
		
		JButton forgetcode = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		forgetcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Main.findpassword.paint();
			}
		});
		forgetcode.setVerticalAlignment(SwingConstants.BOTTOM);
		forgetcode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				forgetcode.setFont(font1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				forgetcode.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			}
		});
		forgetcode.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		forgetcode.setFocusPainted(false);
		forgetcode.setBackground(c);
		forgetcode.setBorder(emptyBorder);//除去边框
		forgetcode.setHorizontalAlignment(SwingConstants.LEFT);
		forgetcode.setOpaque(false); 
		forgetcode.setForeground(Color.white);
		forgetcode.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		forgetcode.setContentAreaFilled(false);
		panel_10.add(forgetcode);
		
		JButton register = new JButton("\u6CE8\u518C");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main.registernormal.paint();
			}
		});
		register.setVerticalAlignment(SwingConstants.BOTTOM);
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				register.setFont(font1);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				register.setFont(new Font("微软雅黑", Font.PLAIN, 15));
			}
		});
		register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		register.setFocusPainted(false);
		register.setBackground(c);
		register.setBorder(emptyBorder);//除去边框
		register.setHorizontalAlignment(SwingConstants.RIGHT);
		register.setForeground(Color.white);
		register.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		register.setOpaque(false);
		register.setContentAreaFilled(false);
		panel_10.add(register);
		
		JLabel usernumber = new JLabel("用户编号:");
		usernumber.setHorizontalAlignment(SwingConstants.LEFT);
		usernumber.setForeground(Color.white);
		usernumber.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		panel_10.add(usernumber);
		
		usernumbertext = new JTextField();
		panel_10.add(usernumbertext);
		usernumbertext.setForeground(Color.white);
		usernumbertext.setFont(new Font("微软雅黑",Font.PLAIN,16));
		usernumbertext.setOpaque(false);
		Border b = BorderFactory.createEtchedBorder(Color.white, Color.white);//设置边框
        usernumbertext.setBorder(b);
		usernumbertext.setColumns(10);
		
		JLabel code = new JLabel("密码：");
		code.setHorizontalAlignment(SwingConstants.LEFT);
		code.setForeground(Color.white);
		code.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		panel_10.add(code);
		
		codetext = new JPasswordField();
		codetext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) //判断按下的键是否是回车键
				{  
					String usernumber = usernumbertext.getText();
					String sql_1 = null;
					String codein = new String(codetext.getPassword());
					if(usernumber.length() == 5) {
						sql_1 = "Select code from adminMWM where admin_no = \'";
						sql_1 += usernumbertext.getText();
						sql_1 += "\'";
						try {
							SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
							SqlConnect.rs=SqlConnect.ps.executeQuery();
							String codereal = null;
							
							while(SqlConnect.rs.next()) {
								codereal=SqlConnect.rs.getString(1);
							}
							if(codereal != null && codein != null && codereal.equals(codein)) {
								sql_1 = "select admin_no, admin_name, admin_sex, admin_picture, register_time, position, admin_telephone, admin_mailbox from adminMWM where admin_no = \'";
								sql_1 += usernumbertext.getText();
								sql_1 += "\'";
								String admininfo[] = new String[8];
								try {
									SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
									SqlConnect.rs=SqlConnect.ps.executeQuery();
									
									while(SqlConnect.rs.next()) {
										Main.adminor.no = SqlConnect.rs.getString(1);
										Main.adminor.name = SqlConnect.rs.getString(2);
										Main.adminor.sex = SqlConnect.rs.getString(3);
										Main.adminor.picture = SqlConnect.rs.getString(4);
										Main.adminor.register_time = SqlConnect.rs.getString(5);
										Main.adminor.position = SqlConnect.rs.getString(6);
										Main.adminor.telephone = SqlConnect.rs.getString(7);
										Main.adminor.mailbox = SqlConnect.rs.getString(8);
									}
								} catch (SQLException e2) {
									e2.printStackTrace();	
								}
								System.out.println("进入管理员界面");
								setVisible(false);
								try {
									Main.admin = new Admin();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								Main.admin.paint();
							}else {
								lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
								lblNewLabel_1.setIcon(icon_1);
								lblNewLabel_1.setText("账号或密码错误");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else if(usernumber.length() == 10) {
						sql_1 = "Select code from teacherMWM where teacher_no = \'";
						sql_1 += usernumbertext.getText();
						sql_1 += "\'";
						try {
							SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
							SqlConnect.rs=SqlConnect.ps.executeQuery();
							String codereal = null;
							
							while(SqlConnect.rs.next()) {
								codereal=SqlConnect.rs.getString(1);
							}
							if(codereal != null && codein != null && codereal.equals(codein)) {
								sql_1 = "select A.teacher_no, teacher_name, teacher_sex, teacher_picture, birth_year_month, register_time, teacher_identity, politic, hometown, education_level, position, teacher_telephone, teacher_mailbox, teacher_app_no, college_name, profession_name, code from teacherMWM as A, collegeMWM as B,teacher_idenMWM as C where A.college_profession = B.college_profession and A.teacher_no = C.teacher_no and A.teacher_no = \'";
								sql_1 += usernumbertext.getText();
								sql_1 += "\'";
								try {
									SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
									SqlConnect.rs=SqlConnect.ps.executeQuery();
									
									while(SqlConnect.rs.next()) {
										Main.teacher.no = SqlConnect.rs.getString(1);
										Main.teacher.name = SqlConnect.rs.getString(2);
										Main.teacher.sex = SqlConnect.rs.getString(3);
										Main.teacher.picture = SqlConnect.rs.getString(4);
										Main.teacher.birth_year_month = SqlConnect.rs.getString(5);
										Main.teacher.register_time = SqlConnect.rs.getString(6);
										Main.teacher.identity = SqlConnect.rs.getString(7);
										Main.teacher.politic = SqlConnect.rs.getString(8);
										Main.teacher.hometown = SqlConnect.rs.getString(9);
										Main.teacher.education = SqlConnect.rs.getString(10);
										Main.teacher.position = SqlConnect.rs.getString(11);
										Main.teacher.telephone = SqlConnect.rs.getString(12);
										Main.teacher.mailbox = SqlConnect.rs.getString(13);
										Main.teacher.qqorwechat = SqlConnect.rs.getString(14);
										Main.teacher.college = SqlConnect.rs.getString(15);
										Main.teacher.profession = SqlConnect.rs.getString(16);
										Main.teacher.code = SqlConnect.rs.getString(17);
									}
								} catch (SQLException e2) {
									e2.printStackTrace();	
								}
								System.out.println("进入教师界面");
								setVisible(false);
								Main.teacherjf = new TeacherJF();
								Main.teacherjf.setVisible(true);
							}else {
								lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
								lblNewLabel_1.setIcon(icon_1);
								lblNewLabel_1.setText("账号或密码错误");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
						lblNewLabel_1.setIcon(icon_1);
						lblNewLabel_1.setText("账号或密码错误");
					}
					
//					finally {
//						try {
//							if(SqlConnect.rs != null)SqlConnect.rs.close();
//							if(SqlConnect.ps != null)SqlConnect.ps.close();
//							if(SqlConnect.ct != null)SqlConnect.ct.close();
//						}catch(Exception e1) {
//							e1.printStackTrace();
//						}
//					}
				}
			}
		});
		usernumbertext.setForeground(Color.white);
		codetext.setFont(new Font("微软雅黑",Font.PLAIN,18));
		codetext.setOpaque(false);
        codetext.setBorder(b);
		panel_10.add(codetext);
		
		Border border2 = BorderFactory.createLineBorder(Color.white);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usernumber = usernumbertext.getText();
				String sql_1 = null;
				String codein = new String(codetext.getPassword());
				if(usernumber.length() == 5) {
					sql_1 = "Select code from adminMWM where admin_no = \'";
					sql_1 += usernumbertext.getText();
					sql_1 += "\'";
					try {
						SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
						SqlConnect.rs=SqlConnect.ps.executeQuery();
						String codereal = null;
						
						while(SqlConnect.rs.next()) {
							codereal=SqlConnect.rs.getString(1);
						}
						if(codereal != null && codein != null && codereal.equals(codein)) {
							sql_1 = "select admin_no, admin_name, admin_sex, admin_picture, register_time, position, admin_telephone, admin_mailbox from adminMWM where admin_no = \'";
							sql_1 += usernumbertext.getText();
							sql_1 += "\'";
							try {
								SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
								SqlConnect.rs=SqlConnect.ps.executeQuery();
								
								while(SqlConnect.rs.next()) {
									Main.adminor.no = SqlConnect.rs.getString(1);
									Main.adminor.name = SqlConnect.rs.getString(2);
									Main.adminor.sex = SqlConnect.rs.getString(3);
									Main.adminor.picture = SqlConnect.rs.getString(4);
									Main.adminor.register_time = SqlConnect.rs.getString(5);
									Main.adminor.position = SqlConnect.rs.getString(6);
									Main.adminor.telephone = SqlConnect.rs.getString(7);
									Main.adminor.mailbox = SqlConnect.rs.getString(8);
								}
							} catch (SQLException e2) {
								e2.printStackTrace();	
							}
							System.out.println("进入管理员界面");
							setVisible(false);
							try {
								Main.admin = new Admin();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							Main.admin.paint();
						}else {
							lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
							lblNewLabel_1.setIcon(icon_1);
							lblNewLabel_1.setText("账号或密码错误");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(usernumber.length() == 10) {
					sql_1 = "Select code from teacher where teacher_no = \'";
					sql_1 += usernumbertext.getText();
					sql_1 += "\'";
					try {
						SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
						SqlConnect.rs=SqlConnect.ps.executeQuery();
						String codereal = null;
						
						while(SqlConnect.rs.next()) {
							codereal=SqlConnect.rs.getString(1);
						}
						if(codereal != null && codein != null && codereal.equals(codein)) {
							sql_1 = "select A.teacher_no, teacher_name, teacher_sex, teacher_picture, birth_year_month, register_time, teacher_identity, politic, hometown, education_level, position, teacher_telephone, teacher_mailbox, teacher_app_no, college_name, profession_name, code from teacherMWM as A, collegeMWM as B,teacher_idenMWM as C where A.college_profession = B.college_profession and A.teacher_no = C.teacher_no and A.teacher_no = \'";
							sql_1 += usernumbertext.getText();
							sql_1 += "\'";
							try {
								SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
								SqlConnect.rs=SqlConnect.ps.executeQuery();
								
								while(SqlConnect.rs.next()) {
									Main.teacher.no = SqlConnect.rs.getString(1);
									Main.teacher.name = SqlConnect.rs.getString(2);
									Main.teacher.sex = SqlConnect.rs.getString(3);
									Main.teacher.picture = SqlConnect.rs.getString(4);
									Main.teacher.birth_year_month = SqlConnect.rs.getString(5);
									Main.teacher.register_time = SqlConnect.rs.getString(6);
									Main.teacher.identity = SqlConnect.rs.getString(7);
									Main.teacher.politic = SqlConnect.rs.getString(8);
									Main.teacher.hometown = SqlConnect.rs.getString(9);
									Main.teacher.education = SqlConnect.rs.getString(10);
									Main.teacher.position = SqlConnect.rs.getString(11);
									Main.teacher.telephone = SqlConnect.rs.getString(12);
									Main.teacher.mailbox = SqlConnect.rs.getString(13);
									Main.teacher.qqorwechat = SqlConnect.rs.getString(14);
									Main.teacher.college = SqlConnect.rs.getString(15);
									Main.teacher.profession = SqlConnect.rs.getString(16);
									Main.teacher.code = SqlConnect.rs.getString(17);
								}
							} catch (SQLException e2) {
								e2.printStackTrace();	
							}
							System.out.println("进入教师界面");
							setVisible(false);
							Main.teacherjf = new TeacherJF();
							Main.teacherjf.setVisible(true);
						}else {
							lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
							lblNewLabel_1.setIcon(icon_1);
							lblNewLabel_1.setText("账号或密码错误");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
					lblNewLabel_1.setIcon(icon_1);
					lblNewLabel_1.setText("账号或密码错误");
				}
				
//				finally {
//					try {
//						if(SqlConnect.rs != null)SqlConnect.rs.close();
//						if(SqlConnect.ps != null)SqlConnect.ps.close();
//						if(SqlConnect.ct != null)SqlConnect.ct.close();
//					}catch(Exception e1) {
//						e1.printStackTrace();
//					}
//				}
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setFont(font);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setFont(new Font("微软雅黑",Font.PLAIN,18));
			}
		});
		button.setFocusPainted(false);
		button.setBackground(c);
		button.setFont(new Font("微软雅黑",Font.PLAIN,18));
		button.setForeground(Color.white);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorder(border2);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_10.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_1.setFont(font);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_1.setFont(new Font("微软雅黑",Font.PLAIN,18));
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.sqlconnect.close();
				button_1.setFocusPainted(false);
				System.exit(0);
			}
		});
		button_1.setFocusPainted(false);
		button_1.setBackground(c);
		button_1.setFont(new Font("微软雅黑",Font.PLAIN,18));
		button_1.setForeground(Color.white);
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorder(border2);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_10.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		panel_10.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_10.add(lblNewLabel_1);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		addWindowStateListener(new WindowStateListener() {
			@Override
			public void windowStateChanged(java.awt.event.WindowEvent e) {
				// TODO Auto-generated method stub
				if(e.getOldState()==JFrame.ICONIFIED&&!isActive()){
					setExtendedState(Frame.NORMAL);//正常化
					toFront();
				}
			}
		});
	}
}
