package ��ʦ���ڹ���ϵͳ����;

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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import ���ݿ����Ӳ���.SqlConnect;
import ϵͳ��̨����.Main;

public class DeleteDialog1 extends JDialog {
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
//			String str = "ע��ɹ�!";
//			String str1 = "���ı��Ϊ19016";
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
	public DeleteDialog1(String consequence) {
		setTitle("��ʾ");
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
			label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
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
						AttendRecordPanel.selectedRows = AttendRecordPanel.table.getSelectedRows();
						if(AttendRecordPanel.selectedRows.length == 0) {
							AttendRecordPanel.confirm = new Confirm("��δѡ���κ�����");
							AttendRecordPanel.confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							AttendRecordPanel.confirm.setVisible(true);
						}else {
							String teacherno[] = new String[AttendRecordPanel.selectedRows.length];
							String rstart[] = new String[AttendRecordPanel.selectedRows.length];
							String rend[] = new String[AttendRecordPanel.selectedRows.length];
							for(int i = 0;i < AttendRecordPanel.selectedRows.length;i++) {
								teacherno[i] = (String) AttendRecordPanel.table.getValueAt(AttendRecordPanel.selectedRows[i], 0);
								rstart[i] = (String) AttendRecordPanel.table.getValueAt(AttendRecordPanel.selectedRows[i], 4);
								rend[i] = (String) AttendRecordPanel.table.getValueAt(AttendRecordPanel.selectedRows[i], 5);
								int rowreal = -1;
								for(int j = 0;j < AttendRecordPanel.teacher_no.size();j++) {
									if(AttendRecordPanel.teacher_no.get(j).equals(teacherno[i]) && AttendRecordPanel.rstart.get(j).equals(rstart[i]) && AttendRecordPanel.rend.get(j).equals(rend[i])) {
										rowreal = j;
										break;
									}
								}
								AttendRecordPanel.teacher_no.remove(rowreal);
								AttendRecordPanel.teacher_name.remove(rowreal);
								AttendRecordPanel.college_name.remove(rowreal);
								AttendRecordPanel.profession_name.remove(rowreal);
								AttendRecordPanel.rstart.remove(rowreal);
								AttendRecordPanel.rend.remove(rowreal);
								AttendRecordPanel.consequence.remove(rowreal);
							}
							for(int i = 0;i < AttendRecordPanel.selectedRows.length;i++) {
								try {
						            Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement("delete from attendMWM where teacher_no = ? and rstart = ? and rend = ?");
						            Main.sqlconnect.ps.setString(1, teacherno[i]);
						            Main.sqlconnect.ps.setString(2, rstart[i]);
						            Main.sqlconnect.ps.setString(3, rend[i]);
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
							AttendRecordPanel.confirm = new Confirm("ɾ���ɹ���");
							AttendRecordPanel.confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							AttendRecordPanel.confirm.setVisible(true);
						}
						AttendRecordPanel.tModel = new AbstractTableModel() {
							//�õ��ж�������¼
							public int rowCount() {
								String sqlCount = "select count(*) as ���� from attend";
								try {
									AttendRecordPanel.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								int count = 0;
								try {
									AttendRecordPanel.rsCount.next();
									count = AttendRecordPanel.rsCount.getInt("����");
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								return count;
							}
							//��������
							public int getRowCount() {return rowCount();}
							//��������
							public int getColumnCount() {return 7;}
							
							public Object getValueAt(int row, int col) {
								switch(col) {
								case 0:
									return AttendRecordPanel.teacher_no.get(row);
								case 1:
									return AttendRecordPanel.teacher_name.get(row);
								case 2:
									return AttendRecordPanel.college_name.get(row);
								case 3:
									return AttendRecordPanel.profession_name.get(row);
								case 4:
									return AttendRecordPanel.rstart.get(row);
								case 5:
									return AttendRecordPanel.rend.get(row);
								case 6:
									return AttendRecordPanel.consequence.get(row);
								}
								return null;
							}
							//���ñ�������
							public final String[] columnName = {"���", "����","ѧԺ","רҵ","�ϰ��ʱ��","�°��ʱ��","�������"};
							public String getColumnName(int column) {
								return columnName[column];
							}
							public Class getColumnClass(int column) {
								return java.lang.String.class;	
					    	}
						};
						Font font_1 = new Font("΢���ź�", Font.PLAIN, 14);		//�������
						AttendRecordPanel.table = new JTable(AttendRecordPanel.tModel);
//						FitTableColumns(table);
						AttendRecordPanel.table.setFont(font_1);
//						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						AttendRecordPanel.table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						AttendRecordPanel.table.addMouseMotionListener(new MouseAdapter(){  
						    public void mouseMoved(MouseEvent e) {  
						        int row=AttendRecordPanel.table.rowAtPoint(e.getPoint());  
						        int col=AttendRecordPanel.table.columnAtPoint(e.getPoint());  
						        if(row>-1 && col>-1){  
						            Object value=AttendRecordPanel.table.getValueAt(row, col);  
						            if(null!=value && !"".equals(value))  
						            	AttendRecordPanel.table.setToolTipText(value.toString());//������ʾ��Ԫ������  
						            else  
						            	AttendRecordPanel.table.setToolTipText(null);//�ر���ʾ
						        }
						    }
						});
						AttendRecordPanel.scrollPane.setViewportView(AttendRecordPanel.table);
					}
				});
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
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
				button.setFont(new Font("΢���ź�", Font.PLAIN, 16));
				Dimension size = new Dimension(80, 40);
				button.setPreferredSize(size);
				button.setActionCommand("OK");
				buttonPane.add(button);
			}
		}
	}
}