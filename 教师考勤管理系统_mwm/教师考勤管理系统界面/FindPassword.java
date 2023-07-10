package 教师考勤管理系统界面;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowStateListener;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import 数据库连接操作.SqlConnect;
import 系统后台操作.Main;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindPassword extends JFrame {

	private JPanel contentPane;
	private boolean maximize = true;
	private JTextField textField;
	private JTextField textField_1;
	private ImageIcon icon_1;
	public java.net.URL imgURL = AffairRecordPanel.class.getResource("/images/wrong.png");
	private CheckCode checkcode = new CheckCode(0, 0);

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
					FindPassword frame = new FindPassword();
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
//					FindPassword frame = new FindPassword();
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
	public FindPassword() {
		setTitle("密码找回");
		icon_1= new ImageIcon(imgURL);
		Color c = new Color(240, 240, 240);
		Color c1 = new Color(0, 102, 204);
		HashMap<TextAttribute, Object> hm = new HashMap<TextAttribute, Object>();
		hm.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); // 定义是否有下划线
		hm.put(TextAttribute.SIZE, 14); // 定义字号
		hm.put(TextAttribute.FAMILY, "微软雅黑"); // 定义字体名
		
		Font font = new Font(hm); // 生成字号为18，字体为宋体，字形带有下划线的字体
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(30, 30, 1000, 563);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		contentPane = new FindcodePanel(size);  //Regi_Fcode
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(c);
		panel.setOpaque(false);
		FlowLayout flowLayout_3 = (FlowLayout) panel.getLayout();
		flowLayout_3.setVgap(50);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(c1);
		panel_1.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(120);
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(c);
		panel_2.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(80);
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(c);
		panel_3.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(120);
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) panel_5.getLayout();
		flowLayout_10.setVgap(0);
		panel_5.setBackground(c);
		panel_5.setOpaque(false);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_6.getLayout();
		flowLayout_12.setHgap(0);
		panel_6.setBackground(c);
		panel_6.setOpaque(false);
		panel_4.add(panel_6, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panel_7.getLayout();
		flowLayout_13.setVgap(0);
		flowLayout_13.setHgap(0);
		panel_7.setBackground(c);
		panel_7.setOpaque(false);
		panel_4.add(panel_7, BorderLayout.SOUTH);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_8.getLayout();
		flowLayout_11.setHgap(0);
		panel_8.setBackground(c);
		panel_8.setOpaque(false);
		panel_4.add(panel_8, BorderLayout.EAST);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(c);
		panel_9.setOpaque(false);
		panel_4.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(c1);
		panel_9.add(panel_10, BorderLayout.NORTH);
		
		Dimension preferredSize = new Dimension(100, 50);
		Dimension preferredSize1 = new Dimension(150, 24);
		
		JLabel label = new JLabel("\u627E\u56DE\u5BC6\u7801");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("微软雅黑", 50, 20));
		label.setPreferredSize(preferredSize);
		panel_10.add(label);
		
		JPanel panel_11 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_11.getLayout();
		flowLayout_6.setHgap(0);
		panel_9.add(panel_11, BorderLayout.WEST);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_12.getLayout();
		flowLayout_7.setHgap(0);
		panel_9.add(panel_12, BorderLayout.EAST);
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) panel_13.getLayout();
		flowLayout_9.setVgap(0);
		panel_13.setBackground(c);
		panel_13.setOpaque(false);
		panel_9.add(panel_13, BorderLayout.SOUTH);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_9.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_14.add(panel_15, BorderLayout.NORTH);
		panel_15.setLayout(new BorderLayout(50, 60));
		
		JLabel label_1 = new JLabel("\u8BF7\u4F7F\u7528\u60A8\u6CE8\u518C/\u7ED1\u5B9A\u7684\u624B\u673A\u53F7\u627E\u56DE\uFF0C\u82E5\u6709\u7591\u95EE\uFF0C\u8BF7\u8054\u7CFB\u7BA1\u7406\u5458");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("微软雅黑", 50, 14));
		panel_15.add(label_1);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(c);
		panel_16.setOpaque(false);
		FlowLayout flowLayout_4 = (FlowLayout) panel_16.getLayout();
		panel_14.add(panel_16, BorderLayout.WEST);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(c);
		panel_17.setOpaque(false);
		FlowLayout flowLayout_8 = (FlowLayout) panel_17.getLayout();
		panel_14.add(panel_17, BorderLayout.SOUTH);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(c);
		panel_18.setOpaque(false);
		FlowLayout flowLayout_5 = (FlowLayout) panel_18.getLayout();
		panel_14.add(panel_18, BorderLayout.EAST);
		
		JPanel panel_19 = new JPanel();
		panel_14.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new GridLayout(3, 3, 0, 30));
		
		JLabel label_2 = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("微软雅黑", 50, 14));
		panel_19.add(label_2);
		
		textField = new JTextField();
		textField.setPreferredSize(preferredSize1);
		panel_19.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(Color.RED);
		panel_19.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u56FE\u5F62\u9A8C\u8BC1\u7801\uFF1A");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("微软雅黑", 50, 14));
		panel_19.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setPreferredSize(preferredSize1);
		panel_19.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		panel_19.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JButton button = new JButton("\u83B7\u53D6\u9A8C\u8BC1\u7801");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0, y = 0;
				panel_20.removeAll();
				panel_20.add(checkcode);
				panel_20.revalidate();
			}
		});
		button.setFocusPainted(false);
		button.setBackground(Color.WHITE);
		button.setBorder(null);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_20.add(button, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = null;
				no = textField.getText();
				String sql_1 = null;
				String code = null;
				String checkcode = textField_1.getText();
				System.out.println(checkcode);
				if(no.length() == 5 && checkcode.equals(CheckCode.coderecord)) {
					sql_1 = "Select code from adminMWM where admin_no = \'";
					sql_1 += no;
					sql_1 += "\'";
					try {
						SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
						SqlConnect.rs=SqlConnect.ps.executeQuery();
						while(SqlConnect.rs.next()) {
							code=SqlConnect.rs.getString(1);
						}
						if(code != null) {
							FindCodeDialog fc = new FindCodeDialog("您的密码是：   " + code);
							fc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							fc.setVisible(true);
					        
						}else {
							lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
							lblNewLabel.setIcon(icon_1);
							lblNewLabel.setText("账号或验证码错误");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(no.length() == 10 && checkcode.equals(CheckCode.coderecord)) {
					sql_1 = "Select code from teacherMWM where teacher_no = \'";
					sql_1 += no;
					sql_1 += "\'";
					try {
						SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
						SqlConnect.rs=SqlConnect.ps.executeQuery();
						while(SqlConnect.rs.next()) {
							code=SqlConnect.rs.getString(1);
						}
						if(code != null) {
							FindCodeDialog fc = new FindCodeDialog("您的密码是：   " + code);
							fc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							fc.setVisible(true);
					        
						}else {
							lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
							lblNewLabel.setIcon(icon_1);
							lblNewLabel.setText("账号或验证码错误");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 12));
					lblNewLabel.setIcon(icon_1);
					lblNewLabel.setText("账号或验证码错误");
				}
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(c1);
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_19.add(btnNewButton);
		
		JLabel label_4 = new JLabel("");
		label_4.setPreferredSize(preferredSize1);
		panel_19.add(label_4);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main.login.paint();
			}
		});
		button_1.setFocusPainted(false);
		button_1.setBackground(c1);
		button_1.setBorder(null);
		button_1.setForeground(Color.BLACK);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_19.add(button_1);
		
		addWindowStateListener(new WindowStateListener() {
			@Override
			public void windowStateChanged(java.awt.event.WindowEvent e) {
				// TODO Auto-generated method stub
				if(e.getOldState()==JFrame.MAXIMIZED_BOTH&&e.getNewState() == JFrame.NORMAL){
					flowLayout_3.setVgap(50);
					flowLayout.setHgap(120);
					flowLayout_1.setHgap(120);
					flowLayout_2.setVgap(80);
					checkcode.setHeight(34);
				}
				if(e.getOldState()==JFrame.NORMAL&&e.getNewState() == JFrame.MAXIMIZED_BOTH) {
					flowLayout_3.setVgap(90);
					flowLayout.setHgap(205);
					flowLayout_1.setHgap(205);
					flowLayout_2.setVgap(135);
					checkcode.setHeight(26);
				}
			}
		});
		
	}
}
