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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import 数据库连接操作.SqlConnect;
import 系统后台操作.Main;

public class DeleteDialog extends JDialog {
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
	public DeleteDialog(String consequence) {
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
						InfoManagePanel.selectedRows = InfoManagePanel.table.getSelectedRows();
						if(InfoManagePanel.selectedRows.length == 0) {
							InfoManagePanel.confirm = new Confirm("您未选中任何数据");
							InfoManagePanel.confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							InfoManagePanel.confirm.setVisible(true);
						}else {
							String teacherno[] = new String[InfoManagePanel.selectedRows.length];
							for(int i = 0;i < InfoManagePanel.selectedRows.length;i++) {
								teacherno[i] = (String) InfoManagePanel.table.getValueAt(InfoManagePanel.selectedRows[i], 0);
								int rowreal = -1;
								for(int j = 0;j < InfoManagePanel.teacher_no.size();j++) {
									if(InfoManagePanel.teacher_no.get(j).equals(teacherno[i])) {
										rowreal = j;
										break;
									}
								}
								teacherno[i] = InfoManagePanel.teacher_no.remove(rowreal);
								InfoManagePanel.teacher_name.remove(rowreal);
								InfoManagePanel.teacher_sex.remove(rowreal);
								InfoManagePanel.teacher_picture.remove(rowreal);
								InfoManagePanel.birth_year_month.remove(rowreal);
								InfoManagePanel.register_time.remove(rowreal);
								InfoManagePanel.teacher_identity.remove(rowreal);
								InfoManagePanel.politic.remove(rowreal);
								InfoManagePanel.hometown.remove(rowreal);
								InfoManagePanel.education_level.remove(rowreal);
								InfoManagePanel.position.remove(rowreal);
								InfoManagePanel.teacher_telephone.remove(rowreal);
								InfoManagePanel.teacher_mailbox.remove(rowreal);
								InfoManagePanel.teacher_app_no.remove(rowreal);
								InfoManagePanel.college_name.remove(rowreal);
								InfoManagePanel.profession_name.remove(rowreal);
							}
							for(int i = 0;i < InfoManagePanel.selectedRows.length;i++) {
								try {
						            Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement("delete from teacher_idenMWM where teacher_no = ?");
						            Main.sqlconnect.ps.setString(1, teacherno[i]);
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
								try {
						            Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement("delete from attendMWM where teacher_no = ?");
						            SqlConnect.ps.setString(1, teacherno[i]);
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
								try {
						            Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement("delete from teacherMWM where teacher_no = ?");
						            SqlConnect.ps.setString(1, teacherno[i]);
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
							InfoManagePanel.confirm = new Confirm("删除成功！");
							InfoManagePanel.confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							InfoManagePanel.confirm.setVisible(true);
						}
						InfoManagePanel.tModel = new AbstractTableModel() {
							//拿到有多少条记录
							public int rowCount() {
					//			Statement stmtCount = DB.createStmt(conn);
								String sqlCount = "select count(*) as 行数 from teacherMWM";
								try {
									InfoManagePanel.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								int count = 0;
								try {
									InfoManagePanel.rsCount.next();
									count = InfoManagePanel.rsCount.getInt("行数");
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								System.out.println("减少后" + count);
								return count;
							}
							//表格的行数
							public int getRowCount() {return rowCount();}
							//表格的列数
							public int getColumnCount() {return 16;}
							
							public Object getValueAt(int row, int col) {
								switch(col) {
								case 0:
									return InfoManagePanel.teacher_no.get(row);
								case 1:
									return InfoManagePanel.teacher_name.get(row);
								case 2:
									return InfoManagePanel.teacher_sex.get(row);
								case 3:
									return InfoManagePanel.teacher_picture.get(row);
								case 4:
									return InfoManagePanel.birth_year_month.get(row);
								case 5:
									return InfoManagePanel.register_time.get(row);
								case 6:
									return InfoManagePanel.teacher_identity.get(row);
								case 7:
									return InfoManagePanel.politic.get(row);
								case 8:
									return InfoManagePanel.hometown.get(row);
								case 9:
									return InfoManagePanel.education_level.get(row);
								case 10:
									return InfoManagePanel.position.get(row);
								case 11:
									return InfoManagePanel.teacher_telephone.get(row);
								case 12:
									return InfoManagePanel.teacher_mailbox.get(row);
								case 13:
									return InfoManagePanel.teacher_app_no.get(row);
								case 14:
									return InfoManagePanel.college_name.get(row);
								case 15:
									return InfoManagePanel.profession_name.get(row);
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
						Font font_1 = new Font("微软雅黑", Font.PLAIN, 14);		//表的字体
						InfoManagePanel.table = new JTable(InfoManagePanel.tModel);
						InfoManagePanel.FitTableColumns(InfoManagePanel.table);
						InfoManagePanel.table.setFont(font_1);
						InfoManagePanel.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						InfoManagePanel.table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						InfoManagePanel.table.addMouseMotionListener(new MouseAdapter(){  
						    public void mouseMoved(MouseEvent e) {  
						        int row=InfoManagePanel.table.rowAtPoint(e.getPoint());  
						        int col=InfoManagePanel.table.columnAtPoint(e.getPoint());  
						        if(row>-1 && col>-1){  
						            Object value=InfoManagePanel.table.getValueAt(row, col);  
						            if(null!=value && !"".equals(value))  
						            	InfoManagePanel.table.setToolTipText(value.toString());//悬浮显示单元格内容  
						            else  
						            	InfoManagePanel.table.setToolTipText(null);//关闭提示
						        }
						    }
						});
						InfoManagePanel.scrollPane.setViewportView(InfoManagePanel.table);
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
