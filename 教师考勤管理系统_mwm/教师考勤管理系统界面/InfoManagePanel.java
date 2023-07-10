package 教师考勤管理系统界面;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import 系统后台操作.EditTableModel;
import 系统后台操作.Main;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;

import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Button;

public class InfoManagePanel extends JPanel {
	public static JTable table;
	public static JScrollPane scrollPane;
	private ImageIcon icon_1;
	private ImageIcon icon_2;
	private ImageIcon icon_3;
	private ImageIcon icon_4;
	public java.net.URL imgURL_1 = AffairRecordPanel.class.getResource("/images/admindel.png");
	public java.net.URL imgURL_2 = AffairRecordPanel.class.getResource("/images/adminadd.png");
	public java.net.URL imgURL_3 = AffairRecordPanel.class.getResource("/images/adminchange.png");
	public java.net.URL imgURL_4 = AffairRecordPanel.class.getResource("/images/adminsaveonce.png");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_2_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	public JTable infotable; 
	public static ResultSet rs;
	public static ResultSet rsCount;
	public static TableModel tModel;
	public TableModel tModel_1;	//第一个查询按钮
	public TableModel tModel_2;	//第二个查询按钮
	public static int[] selectedRows;
	private String teacherno, teachername, teacheriden;
	private DeleteDialog deletedialog;
	public static Confirm confirm;
	private EditTableModel edittablemodel = new EditTableModel();
	private ArrayList selectRow = new ArrayList();		//编号
	private ArrayList selectRow_1 = new ArrayList();	//姓名
	private ArrayList selectRow_2 = new ArrayList();	//身份证号
	private ArrayList selectRow_3 = new ArrayList();	//学院
	private ArrayList selectRow_4 = new ArrayList();	//专业
	private ArrayList selectRow_final = new ArrayList();
	public static ArrayList<String> teacher_no = new ArrayList<String>();
	public static ArrayList<String> teacher_name = new ArrayList<String>();
	public static ArrayList<String> teacher_sex = new ArrayList<String>();
	public static ArrayList<String> teacher_picture = new ArrayList<String>();
	public static ArrayList<String> birth_year_month = new ArrayList<String>();
	public static ArrayList<String> register_time = new ArrayList<String>();
	public static ArrayList<String> politic = new ArrayList<String>();
	public static ArrayList<String> hometown = new ArrayList<String>();
	public static ArrayList<String> education_level = new ArrayList<String>();
	public static ArrayList<String> position = new ArrayList<String>();
	public static ArrayList<String> teacher_telephone = new ArrayList<String>();
	public static ArrayList<String> teacher_mailbox = new ArrayList<String>();
	public static ArrayList<String> teacher_app_no = new ArrayList<String>();
	public static ArrayList<String> college_name = new ArrayList<String>();
	public static ArrayList<String> profession_name = new ArrayList<String>();
	public static ArrayList<String> teacher_identity = new ArrayList<String>();
	/**
	 * Create the panel.
	 */
	public InfoManagePanel() {
		icon_1= new ImageIcon(imgURL_1);
		icon_2= new ImageIcon(imgURL_2);
		icon_3= new ImageIcon(imgURL_3);
		icon_4= new ImageIcon(imgURL_4);
		Dimension size1 = new Dimension(24, 24);	//四个按钮的大小
		Dimension size2 = new Dimension(70, 22);	//编号的大小
		Dimension size3 = new Dimension(70, 22);	//查询内空隔的大小
		Dimension size4 = new Dimension(50, 22);	//姓名的大小
		Dimension size5 = new Dimension(180, 22);	//身份证号、学院、专业的大小
		setLayout(new BorderLayout(0, 0));
		Font font = new Font("SimSun", Font.BOLD, 12);		//查询标签字体
		Font font_1 = new Font("微软雅黑", Font.PLAIN, 14);		//表的字体
		setBounds(100,100,1000,563);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InfoManagePanel.table.clearSelection();
			}
		});
		Border etchedBorder = BorderFactory.createEtchedBorder();
		Border titledborder = BorderFactory.createTitledBorder(etchedBorder, "个人信息查找", TitledBorder.CENTER, TitledBorder.CENTER);
		panel.setBorder(titledborder);
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setFont(font);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_4.add(label, gbc_label);
		
		KeyAdapter keyadapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) //判断按下的键是否是回车键
				{ 
					teacherno = textField.getText();
					teachername = textField_1.getText();
					teacheriden = textField_2.getText(); 
					selectRow = new ArrayList();		//编号
					selectRow_1 = new ArrayList();	//姓名
					selectRow_2 = new ArrayList();	//身份证号
					selectRow_3 = new ArrayList();	//学院
					selectRow_4 = new ArrayList();	//专业
					selectRow_final = new ArrayList();
					String sql_1 = null;
					if(teacherno.length() > 0 && !teacherno.equals("请输入教师编号")) {
						for(int i = 0; i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 0).equals(teacherno)) {
								selectRow.add(i);		//把编号要选出来的行数记录下来
							}
						}
					}
					String shiftname = null;
					if(teachername.length() > 0 && !teachername.equals("请输入教师姓名")) {
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(((String) tModel.getValueAt(i, 1)).equals(teachername)) {
								selectRow_1.add(i);		//把姓名要选出来的行数记录下来
							}
						}
					}
					if(teacheriden.length() > 0 && !teacheriden.equals("请输入教师身份证号")) {
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 6).equals(teacheriden)) {
								selectRow_2.add(i);		//把身份证号要选出来的行数记录下来
							}
						}
					}
					if(((String) comboBox.getSelectedItem()).length() > 0 && !((String) comboBox.getSelectedItem()).equals("请选择学院")) {
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 14).equals((String) comboBox.getSelectedItem())) {
								selectRow_3.add(i);		//把学院要选出来的行数记录下来
							}
						}
					}
					if(((String) comboBox_1.getSelectedItem()).length() > 0 && !((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {
						for(int i = 0;i < tModel.getRowCount();i++) {
							if(tModel.getValueAt(i, 15).equals((String) comboBox_1.getSelectedItem())) {
								selectRow_4.add(i);		//把专业要选出来的行数记录下来
							}
						}
					}
					if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号") && ((String) comboBox.getSelectedItem()).equals("请选择学院") && ((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {
						table = new JTable(tModel);
						FitTableColumns(table);
						table.setFont(font_1);
						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
					}else {
						//用set去重特点求交集
						if(!selectRow.isEmpty() && !selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了编号和姓名和身份证号
							selectRow_final = mergeList(selectRow, selectRow_1);
							selectRow_final = mergeList(selectRow_2, selectRow_final);
						}
						else if(!selectRow.isEmpty() && !selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了编号和姓名
							selectRow_final = mergeList(selectRow, selectRow_1);
						}
						else if(!selectRow.isEmpty() && selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了编号和身份证号
							selectRow_final = mergeList(selectRow, selectRow_2);
						}
						else if(selectRow.isEmpty() && !selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了姓名和身份证号
							selectRow_final = mergeList(selectRow_1, selectRow_2);
						}
						else if(!selectRow.isEmpty() && selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了编号
							selectRow_final = selectRow;
						}
						else if(selectRow.isEmpty() && !selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了姓名
							selectRow_final = selectRow_1;
						}
						else if(selectRow.isEmpty() && selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了身份证号
							selectRow_final = selectRow_2;
						}
						else if(selectRow.isEmpty() && selectRow_1.isEmpty() && selectRow_2.isEmpty()) {
							selectRow_final = new ArrayList();
						}
						if(!selectRow_3.isEmpty() && !selectRow_4.isEmpty()) {		//说明选择了学院和专业
							if(selectRow_final != null) {
								selectRow_final = mergeList(selectRow_final, selectRow_3);
								selectRow_final = mergeList(selectRow_final, selectRow_4);
							}else if(selectRow_final == null && teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号")){
								selectRow_final = mergeList(selectRow_3, selectRow_4);
							}else {
								selectRow_final = new ArrayList();
							}
						}
						else if(!selectRow_3.isEmpty() && selectRow_4.isEmpty() && ((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {		//只选择了学院
							if(selectRow_final != null) {
								selectRow_final = mergeList(selectRow_final, selectRow_3);
							}else if(selectRow_final == null && teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号")){
								selectRow_final = selectRow_3;
							}else {
								selectRow_final = new ArrayList();
							}
						}
						else if(!selectRow_3.isEmpty() && selectRow_4.isEmpty() && !((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {
							selectRow_final = new ArrayList();
						}
						else if(selectRow_3.isEmpty() && !selectRow_4.isEmpty() && ((String) comboBox.getSelectedItem()).equals("请选择学院")) {//只选择了专业
							if(selectRow_final != null) {
								selectRow_final = mergeList(selectRow_final, selectRow_4);
							}else if(selectRow_final == null && teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号")){
								selectRow_final = selectRow_4;
							}else {
								selectRow_final = new ArrayList();
							}
						}
						else if(selectRow_3.isEmpty() && !selectRow_4.isEmpty() && !((String) comboBox.getSelectedItem()).equals("请选择学院")) {
							selectRow_final = new ArrayList();
						}
						else if(selectRow_3.isEmpty() && selectRow_4.isEmpty() && !((String) comboBox.getSelectedItem()).equals("请选择学院")){
							selectRow_final = new ArrayList();
						}else if(selectRow_3.isEmpty() && selectRow_4.isEmpty() && !((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {
							selectRow_final = new ArrayList();
						}
						tModel_1 = new AbstractTableModel() {
							//拿到有多少条记录
							public int rowCount() {
								return selectRow_final.size();
							}
							//表格的行数
							public int getRowCount() {return rowCount();}
							//表格的列数
							public int getColumnCount() {return 16;}
							
							public Object getValueAt(int row, int col) {
								switch(col) {
								case 0:
									return teacher_no.get((int) selectRow_final.get(row));
								case 1:
									return teacher_name.get((int) selectRow_final.get(row));
								case 2:
									return teacher_sex.get((int) selectRow_final.get(row));
								case 3:
									return teacher_picture.get((int) selectRow_final.get(row));
								case 4:
									return birth_year_month.get((int) selectRow_final.get(row));
								case 5:
									return register_time.get((int) selectRow_final.get(row));
								case 6:
									return teacher_identity.get((int) selectRow_final.get(row));
								case 7:
									return politic.get((int) selectRow_final.get(row));
								case 8:
									return hometown.get((int) selectRow_final.get(row));
								case 9:
									return education_level.get((int) selectRow_final.get(row));
								case 10:
									return position.get((int) selectRow_final.get(row));
								case 11:
									return teacher_telephone.get((int) selectRow_final.get(row));
								case 12:
									return teacher_mailbox.get((int) selectRow_final.get(row));
								case 13:
									return teacher_app_no.get((int) selectRow_final.get(row));
								case 14:
									return college_name.get((int) selectRow_final.get(row));
								case 15:
									return profession_name.get((int) selectRow_final.get(row));
								}
								return null;
							}
							//设置表格的列名
							public final String[] columnName = {"编号", "姓名","性别","照片路径","出生日期","注册时间","身份证号","政治面貌","籍贯","学历", "职位", "联系电话","联系邮箱","qq或微信","学院", "专业"};
							public String getColumnName(int column) {
								return columnName[column];
							}
							public Class getColumnClass(int column) {
								return java.lang.String.class;	
					    	}
						};
						
						table = new JTable(tModel_1);
						FitTableColumns(table);
						table.setFont(font_1);
						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
					}
				}
			}
		};
		
		textField = new JTextField();
		textField.addKeyListener(keyadapter);
		textField.setForeground(UIManager.getColor("Button.shadow"));
		textField.setText("请输入教师编号");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textField.getText().equals("请输入教师编号")) {
					textField.setText("");
					textField.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().length() == 0) {
					textField.setForeground(UIManager.getColor("Button.shadow"));
					textField.setText("请输入教师编号");
				}
			}
		});
		textField.setFont(font);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_4.add(textField, gbc_textField);
		textField.setColumns(25);
		
		JLabel label_1 = new JLabel("     ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel_4.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("\u59D3\u540D");
		label_2.setFont(font);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 0;
		panel_4.add(label_2, gbc_label_2);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(keyadapter);
		textField_1.setFont(font);
		textField_1.setForeground(UIManager.getColor("Button.shadow"));
		textField_1.setText("请输入教师姓名");
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textField_1.getText().equals("请输入教师姓名")) {
					textField_1.setText("");
					textField_1.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().length() == 0) {
					textField_1.setForeground(UIManager.getColor("Button.shadow"));
					textField_1.setText("请输入教师姓名");
				}
			}
		});
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 0;
		panel_4.add(textField_1, gbc_textField_1);
		textField_1.setColumns(18);
		
		JLabel label_3 = new JLabel("            ");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 6;
		gbc_label_3.gridy = 0;
		panel_4.add(label_3, gbc_label_3);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_4.setFont(font);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 7;
		gbc_label_4.gridy = 0;
		panel_4.add(label_4, gbc_label_4);
		
		textField_2= new JTextField();
		textField_2.addKeyListener(keyadapter);
		textField_2.setFont(font);
		textField_2.setForeground(UIManager.getColor("Button.shadow"));
		textField_2.setText("请输入教师身份证号");
		textField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textField_2.getText().equals("请输入教师身份证号")) {
					textField_2.setText("");
					textField_2.setForeground(Color.black);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_2.getText().length() == 0) {
					textField_2.setForeground(UIManager.getColor("Button.shadow"));
					textField_2.setText("请输入教师身份证号");
				}
			}
		});
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 8;
		gbc_textField_2.gridy = 0;
		panel_4.add(textField_2, gbc_textField_2);
		textField_2.setColumns(30);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		ActionListener Button1Action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				teacherno = textField.getText();
				teachername = textField_1.getText();
				teacheriden = textField_2.getText(); 
				selectRow = new ArrayList();		//编号
				selectRow_1 = new ArrayList();	//姓名
				selectRow_2 = new ArrayList();	//身份证号
				selectRow_3 = new ArrayList();	//学院
				selectRow_4 = new ArrayList();	//专业
				selectRow_final = new ArrayList();
				String sql_1 = null;
				if(teacherno.length() > 0 && !teacherno.equals("请输入教师编号")) {
					for(int i = 0; i < tModel.getRowCount();i++) {
						if(tModel.getValueAt(i, 0).equals(teacherno)) {
							selectRow.add(i);		//把编号要选出来的行数记录下来
						}
					}
				}
				String shiftname = null;
				if(teachername.length() > 0 && !teachername.equals("请输入教师姓名")) {
					for(int i = 0;i < tModel.getRowCount();i++) {
						if(((String) tModel.getValueAt(i, 1)).equals(teachername)) {
							selectRow_1.add(i);		//把姓名要选出来的行数记录下来
						}
					}
				}
				if(teacheriden.length() > 0 && !teacheriden.equals("请输入教师身份证号")) {
					for(int i = 0;i < tModel.getRowCount();i++) {
						if(tModel.getValueAt(i, 6).equals(teacheriden)) {
							selectRow_2.add(i);		//把身份证号要选出来的行数记录下来
						}
					}
				}
				if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号")) {
					table = new JTable(tModel);
					FitTableColumns(table);
					table.setFont(font_1);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
				}else {
					//用set去重特点求交集
					
					if(!selectRow.isEmpty() && !selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了编号和姓名和身份证号
						selectRow_final = mergeList(selectRow, selectRow_1);
						selectRow_final = mergeList(selectRow_2, selectRow_final);
					}
					else if(!selectRow.isEmpty() && !selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了编号和姓名
						selectRow_final = mergeList(selectRow, selectRow_1);
					}
					else if(!selectRow.isEmpty() && selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了编号和身份证号
						selectRow_final = mergeList(selectRow, selectRow_2);
					}
					else if(selectRow.isEmpty() && !selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了姓名和身份证号
						selectRow_final = mergeList(selectRow_1, selectRow_2);
					}
					else if(!selectRow.isEmpty() && selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了编号
						selectRow_final = selectRow;
					}
					else if(selectRow.isEmpty() && !selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了姓名
						selectRow_final = selectRow_1;
					}
					else if(selectRow.isEmpty() && selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了身份证号
						selectRow_final = selectRow_2;
					}
					tModel_1 = new AbstractTableModel() {
						//拿到有多少条记录
						public int rowCount() {
							return selectRow_final.size();
						}
						//表格的行数
						public int getRowCount() {return rowCount();}
						//表格的列数
						public int getColumnCount() {return 16;}
						
						public Object getValueAt(int row, int col) {
							switch(col) {
							case 0:
								return teacher_no.get((int) selectRow_final.get(row));
							case 1:
								return teacher_name.get((int) selectRow_final.get(row));
							case 2:
								return teacher_sex.get((int) selectRow_final.get(row));
							case 3:
								return teacher_picture.get((int) selectRow_final.get(row));
							case 4:
								return birth_year_month.get((int) selectRow_final.get(row));
							case 5:
								return register_time.get((int) selectRow_final.get(row));
							case 6:
								return teacher_identity.get((int) selectRow_final.get(row));
							case 7:
								return politic.get((int) selectRow_final.get(row));
							case 8:
								return hometown.get((int) selectRow_final.get(row));
							case 9:
								return education_level.get((int) selectRow_final.get(row));
							case 10:
								return position.get((int) selectRow_final.get(row));
							case 11:
								return teacher_telephone.get((int) selectRow_final.get(row));
							case 12:
								return teacher_mailbox.get((int) selectRow_final.get(row));
							case 13:
								return teacher_app_no.get((int) selectRow_final.get(row));
							case 14:
								return college_name.get((int) selectRow_final.get(row));
							case 15:
								return profession_name.get((int) selectRow_final.get(row));
							}
							return null;
						}
						//设置表格的列名
						public final String[] columnName = {"编号", "姓名","性别","照片路径","出生日期","注册时间","身份证号","政治面貌","籍贯","学历", "职位", "联系电话","联系邮箱","qq或微信","学院", "专业"};
						public String getColumnName(int column) {
							return columnName[column];
						}
						public Class getColumnClass(int column) {
							return java.lang.String.class;	
				    	}
					};
					
					table = new JTable(tModel_1);
					FitTableColumns(table);
					table.setFont(font_1);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
				}
			}
		};
		button_1.addActionListener(Button1Action);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFont(font);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 9;
		gbc_button_1.gridy = 0;
		panel_4.add(button_1, gbc_button_1);
		
		JLabel label_7 = new JLabel("");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_7.gridx = 10;
		gbc_label_7.gridy = 0;
		panel_4.add(label_7, gbc_label_7);
		
		JLabel label_5 = new JLabel("\u5B66\u9662");
		label_5.setFont(font);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 0, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 1;
		panel_4.add(label_5, gbc_label_5);
		
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
		
		String str[] = new String[collegecount + 1];	//学院
		str[0] = "请选择学院";
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
				str[i] = rs.getString("学院");
				i++;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		
		comboBox = new JComboBox();
		comboBox.setFont(font);
		comboBox.setModel(new DefaultComboBoxModel(str));
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel_4.add(comboBox, gbc_comboBox);
		
		JLabel label_8 = new JLabel("    ");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.gridx = 3;
		gbc_label_8.gridy = 1;
		panel_4.add(label_8, gbc_label_8);
		
		JLabel label_6 = new JLabel("\u4E13\u4E1A");
		label_6.setFont(font);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 0, 5);
		gbc_label_6.gridx = 4;
		gbc_label_6.gridy = 1;
		panel_4.add(label_6, gbc_label_6);
		
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
		
		String str1[] = new String[professioncount + 1];	//学院
		str1[0] = "请选择专业";
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
				str1[i] = rs.getString("专业");
				i++;
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(font);
		comboBox_1.setModel(new DefaultComboBoxModel(str1));
		comboBox_1.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 1;
		panel_4.add(comboBox_1, gbc_comboBox_1);
		
		ActionListener Button2Action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				teacherno = textField.getText();
				teachername = textField_1.getText();
				teacheriden = textField_2.getText(); 
				selectRow = new ArrayList();		//编号
				selectRow_1 = new ArrayList();	//姓名
				selectRow_2 = new ArrayList();	//身份证号
				selectRow_3 = new ArrayList();	//学院
				selectRow_4 = new ArrayList();	//专业
				selectRow_final = new ArrayList();
				String sql_1 = null;
				if(teacherno.length() > 0 && !teacherno.equals("请输入教师编号")) {
					for(int i = 0; i < tModel.getRowCount();i++) {
						if(tModel.getValueAt(i, 0).equals(teacherno)) {
							selectRow.add(i);		//把编号要选出来的行数记录下来
						}
					}
				}
				String shiftname = null;
				if(teachername.length() > 0 && !teachername.equals("请输入教师姓名")) {
					for(int i = 0;i < tModel.getRowCount();i++) {
						if(((String) tModel.getValueAt(i, 1)).equals(teachername)) {
							selectRow_1.add(i);		//把姓名要选出来的行数记录下来
						}
					}
				}
				if(teacheriden.length() > 0 && !teacheriden.equals("请输入教师身份证号")) {
					for(int i = 0;i < tModel.getRowCount();i++) {
						if(tModel.getValueAt(i, 6).equals(teacheriden)) {
							selectRow_2.add(i);		//把身份证号要选出来的行数记录下来
						}
					}
				}
				if(((String) comboBox.getSelectedItem()).length() > 0 && !((String) comboBox.getSelectedItem()).equals("请选择学院")) {
					for(int i = 0;i < tModel.getRowCount();i++) {
						if(tModel.getValueAt(i, 14).equals((String) comboBox.getSelectedItem())) {
							selectRow_3.add(i);		//把学院要选出来的行数记录下来
						}
					}
				}
				if(((String) comboBox_1.getSelectedItem()).length() > 0 && !((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {
					for(int i = 0;i < tModel.getRowCount();i++) {
						if(tModel.getValueAt(i, 15).equals((String) comboBox_1.getSelectedItem())) {
							selectRow_4.add(i);		//把专业要选出来的行数记录下来
						}
					}
				}
				if(teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号") && ((String) comboBox.getSelectedItem()).equals("请选择学院") && ((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {
					table = new JTable(tModel);
					FitTableColumns(table);
					table.setFont(font_1);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
				}else {
					//用set去重特点求交集
					if(!selectRow.isEmpty() && !selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了编号和姓名和身份证号
						selectRow_final = mergeList(selectRow, selectRow_1);
						selectRow_final = mergeList(selectRow_2, selectRow_final);
					}
					else if(!selectRow.isEmpty() && !selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了编号和姓名
						selectRow_final = mergeList(selectRow, selectRow_1);
					}
					else if(!selectRow.isEmpty() && selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了编号和身份证号
						selectRow_final = mergeList(selectRow, selectRow_2);
					}
					else if(selectRow.isEmpty() && !selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了姓名和身份证号
						selectRow_final = mergeList(selectRow_1, selectRow_2);
					}
					else if(!selectRow.isEmpty() && selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了编号
						selectRow_final = selectRow;
					}
					else if(selectRow.isEmpty() && !selectRow_1.isEmpty() && selectRow_2.isEmpty()) {//说明输入了姓名
						selectRow_final = selectRow_1;
					}
					else if(selectRow.isEmpty() && selectRow_1.isEmpty() && !selectRow_2.isEmpty()) {//说明输入了身份证号
						selectRow_final = selectRow_2;
					}
					else if(selectRow.isEmpty() && selectRow_1.isEmpty() && selectRow_2.isEmpty()) {
						selectRow_final = null;
					}
					if(!selectRow_3.isEmpty() && !selectRow_4.isEmpty()) {		//说明选择了学院和专业
						if(selectRow_final != null) {
							selectRow_final = mergeList(selectRow_final, selectRow_3);
							selectRow_final = mergeList(selectRow_final, selectRow_4);
						}else if(selectRow_final == null && teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号")){
							selectRow_final = mergeList(selectRow_3, selectRow_4);
						}else {
							selectRow_final = new ArrayList();
						}
					}
					else if(!selectRow_3.isEmpty() && selectRow_4.isEmpty() && ((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {		//只选择了学院
						if(selectRow_final != null) {
							selectRow_final = mergeList(selectRow_final, selectRow_3);
						}else if(selectRow_final == null && teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号")){
							selectRow_final = selectRow_3;
						}else {
							selectRow_final = new ArrayList();
						}
					}
					else if(!selectRow_3.isEmpty() && selectRow_4.isEmpty() && !((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {
						selectRow_final = new ArrayList();
					}
					else if(selectRow_3.isEmpty() && !selectRow_4.isEmpty() && ((String) comboBox.getSelectedItem()).equals("请选择学院")) {//只选择了专业
						if(selectRow_final != null) {
							selectRow_final = mergeList(selectRow_final, selectRow_4);
						}else if(selectRow_final == null && teacherno.equals("请输入教师编号") && teachername.equals("请输入教师姓名") && teacheriden.equals("请输入教师身份证号")){
							selectRow_final = selectRow_4;
						}else {
							selectRow_final = new ArrayList();
						}
					}
					else if(selectRow_3.isEmpty() && !selectRow_4.isEmpty() && !((String) comboBox.getSelectedItem()).equals("请选择学院")) {
						selectRow_final = new ArrayList();
					}
					else if(selectRow_3.isEmpty() && selectRow_4.isEmpty() && !((String) comboBox.getSelectedItem()).equals("请选择学院")){
						selectRow_final = new ArrayList();
					}else if(selectRow_3.isEmpty() && selectRow_4.isEmpty() && !((String) comboBox_1.getSelectedItem()).equals("请选择专业")) {
						selectRow_final = new ArrayList();
					}
					tModel_1 = new AbstractTableModel() {
						//拿到有多少条记录
						public int rowCount() {
							return selectRow_final.size();
						}
						//表格的行数
						public int getRowCount() {return rowCount();}
						//表格的列数
						public int getColumnCount() {return 16;}
						
						public Object getValueAt(int row, int col) {
							switch(col) {
							case 0:
								return teacher_no.get((int) selectRow_final.get(row));
							case 1:
								return teacher_name.get((int) selectRow_final.get(row));
							case 2:
								return teacher_sex.get((int) selectRow_final.get(row));
							case 3:
								return teacher_picture.get((int) selectRow_final.get(row));
							case 4:
								return birth_year_month.get((int) selectRow_final.get(row));
							case 5:
								return register_time.get((int) selectRow_final.get(row));
							case 6:
								return teacher_identity.get((int) selectRow_final.get(row));
							case 7:
								return politic.get((int) selectRow_final.get(row));
							case 8:
								return hometown.get((int) selectRow_final.get(row));
							case 9:
								return education_level.get((int) selectRow_final.get(row));
							case 10:
								return position.get((int) selectRow_final.get(row));
							case 11:
								return teacher_telephone.get((int) selectRow_final.get(row));
							case 12:
								return teacher_mailbox.get((int) selectRow_final.get(row));
							case 13:
								return teacher_app_no.get((int) selectRow_final.get(row));
							case 14:
								return college_name.get((int) selectRow_final.get(row));
							case 15:
								return profession_name.get((int) selectRow_final.get(row));
							}
							return null;
						}
						//设置表格的列名
						public final String[] columnName = {"编号", "姓名","性别","照片路径","出生日期","注册时间","身份证号","政治面貌","籍贯","学历", "职位", "联系电话","联系邮箱","qq或微信","学院", "专业"};
						public String getColumnName(int column) {
							return columnName[column];
						}
						public Class getColumnClass(int column) {
							return java.lang.String.class;	
				    	}
					};
					
					table = new JTable(tModel_1);
					FitTableColumns(table);
					table.setFont(font_1);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
				}
			}
		};
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(Button2Action);
		button.setFont(font);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.WEST;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 8;
		gbc_button.gridy = 1;
		panel_4.add(button, gbc_button);
		
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
				deletedialog = new DeleteDialog("您确定要删除吗？");
				deletedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				deletedialog.setVisible(true);
			}
		});
		button_13.setPreferredSize(size1);
		button_13.setIcon(icon_1);
		button_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(button_13);
		
		JButton button_14 = new JButton();
		button_14.setPreferredSize(size1);
		button_14.setIcon(icon_2);
		button_14.setEnabled(false);
		panel_3.add(button_14);
		
		JButton button_15 = new JButton();
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = new JTable(edittablemodel);
				FitTableColumns(table);
				table.setFont(font_1);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
			}
		});
		button_15.setPreferredSize(size1);
		button_15.setIcon(icon_3);
		button_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(button_15);
		
		JButton button_16 = new JButton();
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = new JTable(tModel);
				FitTableColumns(table);
				table.setFont(font_1);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
				confirm = new Confirm("已保存！");
				confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				confirm.setVisible(true);
			}
		});
		button_16.setPreferredSize(size1);
		button_16.setIcon(icon_4);
		button_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.add(button_16);
		
		sql = "select A.teacher_no as 编号, teacher_name as 姓名, teacher_sex as 性别, teacher_picture as 照片路径, birth_year_month as 出生日期, register_time as 注册时间, teacher_identity as 身份证号, politic as 政治面貌, hometown as 籍贯, education_level as 学历, position as 职位, teacher_telephone as 联系电话, teacher_mailbox as 联系邮箱, teacher_app_no as qq或微信, college_name as 学院, profession_name as 专业 from teacherMWM as A, collegeMWM as B, teacher_idenMWM as C where A.college_profession = B.college_profession and A.teacher_no = C.teacher_no order by A.id";
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
		try {
			teacher_no = new ArrayList<String>();
			teacher_name = new ArrayList<String>();
			teacher_sex = new ArrayList<String>();
			teacher_picture = new ArrayList<String>();
			birth_year_month = new ArrayList<String>();
			register_time = new ArrayList<String>();
			politic = new ArrayList<String>();
			hometown = new ArrayList<String>();
			education_level = new ArrayList<String>();
			position = new ArrayList<String>();
			teacher_telephone = new ArrayList<String>();
			teacher_mailbox = new ArrayList<String>();
			teacher_app_no = new ArrayList<String>();
			college_name = new ArrayList<String>();
			profession_name = new ArrayList<String>();
			teacher_identity = new ArrayList<String>();
			
			while(rs.next()) {
				teacher_no.add(rs.getString("编号"));
				teacher_name.add(rs.getString("姓名"));
				teacher_sex.add(rs.getString("性别"));
				teacher_picture.add(rs.getString("照片路径"));
				birth_year_month.add(rs.getString("出生日期"));
				register_time.add(rs.getString("注册时间"));
				teacher_identity.add(rs.getString("身份证号"));
				politic.add(rs.getString("政治面貌"));
				hometown.add(rs.getString("籍贯"));
				education_level.add(rs.getString("学历"));
				position.add(rs.getString("职位"));
				teacher_telephone.add(rs.getString("联系电话"));
				teacher_mailbox.add(rs.getString("联系邮箱"));
				teacher_app_no.add(rs.getString("qq或微信"));
				college_name.add(rs.getString("学院"));
				profession_name.add(rs.getString("专业"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
	
		tModel = new AbstractTableModel() {
			//拿到有多少条记录
			public int rowCount() {
	//			Statement stmtCount = DB.createStmt(conn);
				String sqlCount = "select count(*) as 行数 from teacherMWM";
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
			public int getColumnCount() {return 16;}
			
			public Object getValueAt(int row, int col) {
				switch(col) {
				case 0:
					return teacher_no.get(row);
				case 1:
					return teacher_name.get(row);
				case 2:
					return teacher_sex.get(row);
				case 3:
					return teacher_picture.get(row);
				case 4:
					return birth_year_month.get(row);
				case 5:
					return register_time.get(row);
				case 6:
					return teacher_identity.get(row);
				case 7:
					return politic.get(row);
				case 8:
					return hometown.get(row);
				case 9:
					return education_level.get(row);
				case 10:
					return position.get(row);
				case 11:
					return teacher_telephone.get(row);
				case 12:
					return teacher_mailbox.get(row);
				case 13:
					return teacher_app_no.get(row);
				case 14:
					return college_name.get(row);
				case 15:
					return profession_name.get(row);
				}
				return null;
			}
			//设置表格的列名
			public final String[] columnName = {"编号", "姓名","性别","照片路径","出生日期","注册时间","身份证号","政治面貌","籍贯","学历", "职位", "联系电话","联系邮箱","qq或微信","学院", "专业"};
			public String getColumnName(int column) {
				return columnName[column];
			}
			public Class getColumnClass(int column) {
				return java.lang.String.class;	
	    	}
		};
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		table = new JTable(tModel);
		FitTableColumns(table);
		table.setFont(font_1);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
		
		ListSelectionModel selectionModel = table.getSelectionModel();
	}
	
    public static void FitTableColumns(JTable myTable) {
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
}

