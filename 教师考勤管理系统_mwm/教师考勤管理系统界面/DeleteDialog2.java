package 教师考勤管理系统界面;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import 数据库连接操作.SqlConnect;
import 系统后台操作.Main;

public class DeleteDialog2 extends JDialog {
	private ImageIcon icon_1;
	private final JPanel contentPanel = new JPanel();
	private JButton button;
	private JButton okButton; 
	public static boolean delete = false;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			String str = "注册成功!";
//			String str1 = "您的编号为19016";
//			RegisterDialog dialog = new RegisterDialog(str, str1);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DeleteDialog2(String consequence) {
		setTitle("提示");
		icon_1= new ImageIcon(".\\src\\images\\register.png");
		setBounds(300, 200, 300, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(15);
			contentPanel.add(panel, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setHgap(24);
			contentPanel.add(panel, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(icon_1);
			label.setText(consequence);
			label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			contentPanel.add(label, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.RIGHT);
			fl_buttonPane.setVgap(13);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton= new JButton("\u786E\u5B9A");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						delete = true;
						dispose();
						AffairRecordPanel.selectedRows = AffairRecordPanel.table.getSelectedRows();
						if(AffairRecordPanel.selectedRows.length == 0) {
							AffairRecordPanel.confirm = new Confirm("您未选中任何数据");
							AffairRecordPanel.confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							AffairRecordPanel.confirm.setVisible(true);
						}else {
							String affair_no[] = new String[AffairRecordPanel.selectedRows.length];
							for(int i = 0;i < AffairRecordPanel.selectedRows.length;i++) {
								affair_no[i] = (String) AffairRecordPanel.table.getValueAt(AffairRecordPanel.selectedRows[i], 0);
								int rowreal = -1;
								for(int j = 0;j < AffairRecordPanel.affair_no.size();j++) {
									if(AffairRecordPanel.affair_no.get(j).equals(affair_no[i])) {
										rowreal = j;
										break;
									}
								}
								AffairRecordPanel.affair_no.remove(rowreal);
								AffairRecordPanel.teacher_no.remove(rowreal);
								AffairRecordPanel.teacher_name.remove(rowreal);
								AffairRecordPanel.college_name.remove(rowreal);
								AffairRecordPanel.admin_no.remove(rowreal);
								AffairRecordPanel.admin_name.remove(rowreal);
								AffairRecordPanel.admin_telephone.remove(rowreal);
								AffairRecordPanel.admin_mailbox.remove(rowreal);
								AffairRecordPanel.profession_name.remove(rowreal);
								AffairRecordPanel.affair_type.remove(rowreal);
								AffairRecordPanel.affair_start.remove(rowreal);
								AffairRecordPanel.affair_end.remove(rowreal);
								AffairRecordPanel.affair_time.remove(rowreal);
								AffairRecordPanel.reason.remove(rowreal);
							}
							for(int i = 0;i < AffairRecordPanel.selectedRows.length;i++) {
								try {
						            Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement("delete from affairMWM where affair_no = ?");
						            Main.sqlconnect.ps.setString(1, affair_no[i]);
						            Main.sqlconnect.ps.executeUpdate();
						        }catch(Exception e1) {
						            e1.printStackTrace();
						        }
								try {
									Main.sqlconnect.ct.commit();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							AffairRecordPanel.confirm = new Confirm("删除成功！");
							AffairRecordPanel.confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							AffairRecordPanel.confirm.setVisible(true);
						}
						AffairRecordPanel.tModel = new AbstractTableModel() {
							//拿到有多少条记录
							public int rowCount() {
								String sqlCount = "select count(*) as 行数 from affairMWM";
								try {
									AffairRecordPanel.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								int count = 0;
								try {
									AffairRecordPanel.rsCount.next();
									count = AffairRecordPanel.rsCount.getInt("行数");
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
									return AffairRecordPanel.affair_no.get(row);
								case 1:
									return AffairRecordPanel.teacher_no.get(row);
								case 2:
									return AffairRecordPanel.teacher_name.get(row);
								case 3:
									return AffairRecordPanel.college_name.get(row);
								case 4:
									return AffairRecordPanel.profession_name.get(row);
								case 5:
									return AffairRecordPanel.admin_no.get(row);
								case 6:
									return AffairRecordPanel.admin_name.get(row);
								case 7:
									return AffairRecordPanel.admin_telephone.get(row);
								case 8:
									return AffairRecordPanel.admin_mailbox.get(row);
								case 9:
									if(Integer.valueOf(AffairRecordPanel.affair_type.get(row)) == 1) {
										return "出差";
									}else if(Integer.valueOf(AffairRecordPanel.affair_type.get(row)) == 2) {
										return "请假";
									}else if(Integer.valueOf(AffairRecordPanel.affair_type.get(row)) == 3) {
										return "加班";
									}
								case 10:
									return AffairRecordPanel.affair_start.get(row);
								case 11:
									return AffairRecordPanel.affair_end.get(row);
								case 12:
									return AffairRecordPanel.affair_time.get(row);
								case 13:
									return AffairRecordPanel.reason.get(row);
								}
								return null;
							}
							//设置表格的列名
							public final String[] columnName = {"请求编号", "编号", "姓名","学院","专业","教师编号","教师姓名","教师联系电话","教师联系邮箱","请求类型", "请求开始时间","请求结束时间","请求时间","请求原因"};
							public String getColumnName(int column) {
								return columnName[column];
							}
							public Class getColumnClass(int column) {
								return java.lang.String.class;	
					    	}
						};
						Font font_1 = new Font("微软雅黑", Font.PLAIN, 14);		//表的字体
						AffairRecordPanel.table = new JTable(AffairRecordPanel.tModel);
						AffairRecordPanel.table.setFont(font_1);
						AffairRecordPanel.table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						AffairRecordPanel.table.addMouseMotionListener(new MouseAdapter(){  
						    public void mouseMoved(MouseEvent e) {  
						        int row=AffairRecordPanel.table.rowAtPoint(e.getPoint());  
						        int col=AffairRecordPanel.table.columnAtPoint(e.getPoint());  
						        if(row>-1 && col>-1){  
						            Object value=AffairRecordPanel.table.getValueAt(row, col);  
						            if(null!=value && !"".equals(value))  
						            	AffairRecordPanel.table.setToolTipText(value.toString());//悬浮显示单元格内容  
						            else  
						            	AffairRecordPanel.table.setToolTipText(null);//关闭提示
						        }
						    }
						});
						AffairRecordPanel.scrollPane.setViewportView(AffairRecordPanel.table);
					}
				});
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
				Dimension size = new Dimension(80, 40);
				okButton.setPreferredSize(size);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				button = new JButton("\u53D6\u6D88");
				buttonPane.add(button);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						delete = false;
						dispose();
					}
				});
				button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
				Dimension size = new Dimension(80, 40);
				button.setPreferredSize(size);
				button.setActionCommand("OK");
				buttonPane.add(button);
			}
		}
	}
}