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
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import 数据库连接操作.SqlConnect;
import 系统后台操作.Main;

public class DeleteDialog3 extends JDialog {
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
	public DeleteDialog3(String consequence) {
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
						RequestRecordPanel.selectedRows = RequestRecordPanel.table.getSelectedRows();
						if(RequestRecordPanel.selectedRows.length == 0) {
							RequestRecordPanel.confirm = new Confirm("您未选中任何数据");
							RequestRecordPanel.confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							RequestRecordPanel.confirm.setVisible(true);
						}else {
							String request_no[] = new String[RequestRecordPanel.selectedRows.length];
							for(int i = 0;i < RequestRecordPanel.selectedRows.length;i++) {
								request_no[i] = (String) RequestRecordPanel.table.getValueAt(RequestRecordPanel.selectedRows[i], 0);
								int rowreal = -1;
								for(int j = 0;j < RequestRecordPanel.request_no.size();j++) {
									if(RequestRecordPanel.request_no.get(j).equals(request_no[i])) {
										rowreal = j;
										break;
									}
								}
								RequestRecordPanel.request_no.remove(rowreal);
								RequestRecordPanel.teacher_no.remove(rowreal);
								RequestRecordPanel.teacher_name.remove(rowreal);
								RequestRecordPanel.college_name.remove(rowreal);
								RequestRecordPanel.profession_name.remove(rowreal);
								RequestRecordPanel.admin_no.remove(rowreal);
								RequestRecordPanel.admin_name.remove(rowreal);
								RequestRecordPanel.admin_telephone.remove(rowreal);
								RequestRecordPanel.admin_mailbox.remove(rowreal);
								RequestRecordPanel.request_type.remove(rowreal);
								RequestRecordPanel.request_contend.remove(rowreal);
								RequestRecordPanel.request_time.remove(rowreal);
							}
							for(int i = 0;i < RequestRecordPanel.selectedRows.length;i++) {
								try {
						            Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement("delete from requestMWM where request_no = ?");
						            Main.sqlconnect.ps.setString(1, request_no[i]);
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
							RequestRecordPanel.confirm = new Confirm("删除成功！");
							RequestRecordPanel.confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							RequestRecordPanel.confirm.setVisible(true);
						}
						RequestRecordPanel.tModel = new AbstractTableModel() {
							//拿到有多少条记录
							public int rowCount() {
								String sqlCount = "select count(*) as 行数 from requestMWM";
								try {
									RequestRecordPanel.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								int count = 0;
								try {
									RequestRecordPanel.rsCount.next();
									count = RequestRecordPanel.rsCount.getInt("行数");
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								return count;
							}
							//表格的行数
							public int getRowCount() {return rowCount();}
							//表格的列数
							public int getColumnCount() {return 12;}
							
							public Object getValueAt(int row, int col) {
								switch(col) {
								case 0:
									return RequestRecordPanel.request_no.get(row);
								case 1:
									return RequestRecordPanel.teacher_no.get(row);
								case 2:
									return RequestRecordPanel.teacher_name.get(row);
								case 3:
									return RequestRecordPanel.college_name.get(row);
								case 4:
									return RequestRecordPanel.profession_name.get(row);
								case 5:
									return RequestRecordPanel.admin_no.get(row);
								case 6:
									return RequestRecordPanel.admin_name.get(row);
								case 7:
									return RequestRecordPanel.admin_telephone.get(row);
								case 8:
									return RequestRecordPanel.admin_mailbox.get(row);
								case 9:
									return RequestRecordPanel.request_type.get(row);
								case 10:
									return RequestRecordPanel.request_contend.get(row);
								case 11:
									return RequestRecordPanel.request_time.get(row);
								}
								return null;
							}
							//设置表格的列名
							public final String[] columnName = {"申请编号","教师编号", "教师姓名","学院","专业","管理员编号","管理员姓名", "管理员联系电话", "管理员联系邮箱", "申请类型","申请内容","申请时间"};
							public String getColumnName(int column) {
								return columnName[column];
							}
							public Class getColumnClass(int column) {
								return java.lang.String.class;	
					    	}
						};
						Font font_1 = new Font("微软雅黑", Font.PLAIN, 14);		//表的字体
						RequestRecordPanel.table = new JTable(RequestRecordPanel.tModel);
						RequestRecordPanel.table.setFont(font_1);
						FitTableColumns(RequestRecordPanel.table);
						RequestRecordPanel.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						RequestRecordPanel.table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						RequestRecordPanel.table.addMouseMotionListener(new MouseAdapter(){  
						    public void mouseMoved(MouseEvent e) {  
						        int row=RequestRecordPanel.table.rowAtPoint(e.getPoint());  
						        int col=RequestRecordPanel.table.columnAtPoint(e.getPoint());  
						        if(row>-1 && col>-1){  
						            Object value=RequestRecordPanel.table.getValueAt(row, col);  
						            if(null!=value && !"".equals(value))  
						            	RequestRecordPanel.table.setToolTipText(value.toString());//悬浮显示单元格内容  
						            else  
						            	RequestRecordPanel.table.setToolTipText(null);//关闭提示
						        }
						    }
						});
						RequestRecordPanel.scrollPane.setViewportView(RequestRecordPanel.table);
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
}