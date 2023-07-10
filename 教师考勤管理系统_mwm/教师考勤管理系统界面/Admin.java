package 教师考勤管理系统界面;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.SeparatorUI;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI.NormalColor;

import 系统后台操作.Main;

import javax.swing.JMenuBar;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JSeparator;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class Admin extends JFrame {

	private JPanel contentPane;
	public static JPanel panel_4;
	public static int mainview = 1;
	public static JButton button;
	public static JButton button_6;
	public static JButton button_2;
	public static JButton button_3;
	public static JButton button_4;
	/**
	 * Launch the application.
	 */
	public void paint() {
		BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
		UIManager.put("RootPane.setupButtonVisible", false);
		BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
		UIManager.put("Button.border", BorderFactory.createEmptyBorder());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public static void main(String[] args) {
//		BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//		UIManager.put("RootPane.setupButtonVisible", false);
//		BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
//		UIManager.put("Button.border", BorderFactory.createEmptyBorder());
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
//					Admin frame = new Admin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 */
	public Admin() throws IOException{
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InfoManagePanel.table.clearSelection();
			}
		});
		setResizable(false);
		Color c = new Color(240,240,240);//背影颜色随便设任意值,只起占位作用。
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("管理员");
		setBounds(100, 100, 1000, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
//		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
//		contentPane.setBounds(0, 0, size.width, size.height);
		setContentPane(contentPane);
		Dimension sizex = getSize();
//		System.out.println(sizex.height);
//		System.out.println(sizex.width);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		// 自定义JToolBar UI的border
		
		Dimension size_1 = new Dimension(110, 28);	//按钮的长度
		Dimension size_2 = new Dimension(110, 28);	//按钮和管理员，您好之间的距离
		Dimension size_3 = new Dimension(5, 28);	//最开始到按钮之间的距离
		Dimension size_4 = new Dimension(120, 28);	//还没有使用
		Dimension size_5 = new Dimension(5 ,28);	//管理员，您好和退出之间的距离
		
		HashMap<TextAttribute, Object> hm = new HashMap<TextAttribute, Object>();
		hm.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); // 定义是否有下划线
		hm.put(TextAttribute.SIZE, 16); // 定义字号
		hm.put(TextAttribute.FAMILY, "微软雅黑"); // 定义字体名
		Font font = new Font(hm); // 生成字号为16，字体为宋体，字形带有下划线的字体
		
		Font font_1 = new Font("微软雅黑", Font.PLAIN, 30);		//管理员，您好的字体
		Font font_2 = new Font("微软雅黑", Font.BOLD, 18);			
		Font font_3 = new Font("微软雅黑", Font.PLAIN, 16);		//按钮的字体
		
		JLabel label_2 = new JLabel("");
		label_2.setPreferredSize(size_3);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 0;
		panel.add(label_2, gbc_label_2);
		
		button = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mainview = 6;
				panel_4.removeAll();
        		panel_4.add(new InfoPanel(Main.adminor));
        		panel_4.revalidate();
			}
	    });
		button.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.SOUTH;
		button.setUI(new BEButtonUI().setNormalColor(NormalColor.normal));
		button.setPreferredSize(size_1);
		button.setFont(font_3);
		button.setBackground(c);
		button.setOpaque(false);
		button.setBorder(null);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		button.setFocusPainted(false);
		button.setUI(new BEButtonUI().setNormalColor(NormalColor.normal));
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 0;
		panel.add(button, gbc_button);
		
		GridBagConstraints gbc_separator = new GridBagConstraints();  
		gbc_separator.gridx = 2;  
		gbc_separator.gridy = 0;  
		gbc_separator.fill = GridBagConstraints.VERTICAL;  
		gbc_separator.insets =  new Insets(0, 5, 5, 5);  
        JSeparator separator = new JSeparator();   //创建竖直分隔线
        separator.setOrientation(JSeparator.VERTICAL); 
        panel.add(separator, gbc_separator);
        
        button_2 = new JButton("\u8003\u52E4\u4FE1\u606F\u7BA1\u7406");
        button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mainview = 3;
        		panel_4.removeAll();
        		panel_4.add(new AttendRecordPanel());
        		panel_4.revalidate();
			}
	    });
        button_2.setPreferredSize(size_1);
		button_2.setFont(font_3);
		button_2.setBackground(c);
		button_2.setOpaque(false);
		button_2.setBorder(null);
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		button_2.setFocusPainted(false);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.SOUTH;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 7;
		gbc_button_2.gridy = 0;
		panel.add(button_2, gbc_button_2);
		
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();  
		gbc_separator_2.gridx = 8;  
		gbc_separator_2.gridy = 0;  
		gbc_separator_2.fill = GridBagConstraints.VERTICAL;  
		gbc_separator_2.insets =  new Insets(0, 5, 5, 5);  
        JSeparator separator_2 = new JSeparator();   //创建竖直分隔线  
        separator_2.setOrientation(JSeparator.VERTICAL); 
        panel.add(separator_2, gbc_separator_2);
        
        button_3 = new JButton("请求信息管理");
        button_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mainview = 4;
        		panel_4.removeAll();
        		panel_4.add(new AffairRecordPanel(Main.adminor));
        		panel_4.revalidate();
        	}
        });
        button_3.setPreferredSize(size_1);
		button_3.setFont(font_3);
		button_3.setBackground(c);
		button_3.setOpaque(false);
		button_3.setBorder(null);
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		button_3.setFocusPainted(false);
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.anchor = GridBagConstraints.SOUTH;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 9;
		gbc_button_3.gridy = 0;
		panel.add(button_3, gbc_button_3);
		
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();  
		gbc_separator_3.gridx = 10;  
		gbc_separator_3.gridy = 0;  
		gbc_separator_3.fill = GridBagConstraints.VERTICAL;  
		gbc_separator_3.insets =  new Insets(0, 5, 5, 5);  
        JSeparator separator_3 = new JSeparator();   //创建竖直分隔线  
        separator_3.setOrientation(JSeparator.VERTICAL); 
        panel.add(separator_3, gbc_separator_3);
        
        button_4 = new JButton("申请信息管理");
        button_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mainview = 5;
        		panel_4.removeAll();
        		panel_4.add(new RequestRecordPanel(Main.adminor));
        		panel_4.revalidate();
        	}
        });
        button_4.setPreferredSize(size_1);
		button_4.setFont(font_3);
		button_4.setBackground(c);
		button_4.setOpaque(false);
		button_4.setBorder(null);
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		button_4.setFocusPainted(false);
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.anchor = GridBagConstraints.SOUTH;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 11;
		gbc_button_4.gridy = 0;
		panel.add(button_4, gbc_button_4);
		
//		Dimension size_1 = button_4.getSize();
//		System.out.println(size_1.height);
//		System.out.println(size_1.width);
		JLabel label = new JLabel("");
		label.setPreferredSize(size_2);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 12;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("\u7BA1\u7406\u5458\uFF0C\u60A8\u597D");
		label_1.setFont(font_1);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 13;
		gbc_label_1.gridy = 0;
		panel.add(label_1, gbc_label_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setPreferredSize(size_5);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 14;
		gbc_label_4.gridy = 0;
		panel.add(label_4, gbc_label_4);
		
		JButton button_5 = new JButton("退出");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainview = 1;
				Main.login.paint();
			}
		});
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_5.setFont(font);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_5.setFont(font_3);
			}
		});
		button_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button_5.setFocusPainted(false);
		button_5.setBackground(c);
		button_5.setOpaque(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorder(null);
		button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.anchor = GridBagConstraints.SOUTHWEST;
		gbc_button_5.insets = new Insets(0, 0, 5, 0);
		gbc_button_5.gridx = 15;
		gbc_button_5.gridy = 0;
		panel.add(button_5, gbc_button_5);
		
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();  
		gbc_separator_4.insets = new Insets(5, 5, 5, 5);
		gbc_separator_4.gridx = 0;  
		gbc_separator_4.gridy = 1;  
		gbc_separator_4.gridwidth = 16;
		gbc_separator_4.fill = GridBagConstraints.HORIZONTAL;  
        JSeparator separator_4 = new JSeparator();   //创建竖直分隔线
        separator_4.setOrientation(JSeparator.HORIZONTAL); 
        panel.add(separator_4, gbc_separator_4);
        
        GridBagConstraints gbc_separator_5 = new GridBagConstraints();  
		gbc_separator_5.gridx = 4;  
		gbc_separator_5.gridy = 0;  
		gbc_separator_5.fill = GridBagConstraints.VERTICAL;  
		gbc_separator_5.insets =  new Insets(0, 5, 5, 5);  
        JSeparator separator_5 = new JSeparator();   //创建竖直分隔线  
        separator_5.setOrientation(JSeparator.VERTICAL); 
        panel.add(separator_5, gbc_separator_5);
        
        button_6 = new JButton("个人信息管理");
        button_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mainview = 2;
        		panel_4.removeAll();
        		panel_4.add(new InfoManagePanel());
        		panel_4.revalidate();
        	}
        });
        button_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button_6.setPreferredSize(size_1);
        button_6.setOpaque(false);
        button_6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        button_6.setBorder(null);
        button_6.setBackground(SystemColor.menu);
        GridBagConstraints gbc_button_6 = new GridBagConstraints();
        gbc_button_6.anchor = GridBagConstraints.SOUTH;
        gbc_button_6.insets = new Insets(0, 0, 5, 5);
        gbc_button_6.gridx = 3;
        gbc_button_6.gridy = 0;
        panel.add(button_6, gbc_button_6);
		
        
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		System.out.println(mainview);
		switch(mainview) {
			case 1:panel_4 = new InfoPanel(Main.adminor);contentPane.add(panel_4, BorderLayout.CENTER);break;
			case 2:panel_4.removeAll();panel_4.add(new InfoManagePanel());panel_4.revalidate();break;
			case 3:panel_4.removeAll();panel_4.add(new AttendRecordPanel());panel_4.revalidate();break;
			case 4:panel_4.removeAll();panel_4.add(new AffairRecordPanel(Main.adminor));panel_4.revalidate();break;
			case 5:panel_4.removeAll();panel_4.add(new RequestRecordPanel(Main.adminor));panel_4.revalidate();break;
			case 6:panel_4.removeAll();panel_4.add(new InfoPanel(Main.adminor));panel_4.revalidate();break;
			default:setVisible(false);Main.login.paint();
		}
	}
}
