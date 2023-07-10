package ���ݿ����Ӳ���;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import ϵͳ��̨����.Main;

public class InfoTable {
	public JTable infotable; 
	private ResultSet rs;
	private ResultSet rsCount;
	public TableModel tModel;
	
	public void infotable() {
		String sql = "select teacher_no as ���, teacher_name as ����, teacher_sex as �Ա�, teacher_picture as ��Ƭ·��, birth_year_month as ��������, register_time as ע��ʱ��, politic as ������ò, hometown as ����, education_level as ѧ��, position as ְλ, teacher_telephone as ��ϵ�绰, teacher_mailbox as ��ϵ����, teacher_app_no as qq��΢��, college_name as ѧԺ, profession_name as רҵ from teacherMWM as A, collegeMWM as B where A.college_profession = B.college_profession order by A.id";
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
		final ArrayList<String> teacher_no = new ArrayList<String>();
		final ArrayList<String> teacher_name = new ArrayList<String>();
		final ArrayList<String> teacher_sex = new ArrayList<String>();
		final ArrayList<String> teacher_picture = new ArrayList<String>();
		final ArrayList<String> birth_year_month = new ArrayList<String>();
		final ArrayList<String> register_time = new ArrayList<String>();
		final ArrayList<String> politic = new ArrayList<String>();
		final ArrayList<String> hometown = new ArrayList<String>();
		final ArrayList<String> education_level = new ArrayList<String>();
		final ArrayList<String> position = new ArrayList<String>();
		final ArrayList<String> teacher_telephone = new ArrayList<String>();
		final ArrayList<String> teacher_mailbox = new ArrayList<String>();
		final ArrayList<String> teacher_app_no = new ArrayList<String>();
		final ArrayList<String> college_name = new ArrayList<String>();
		final ArrayList<String> profession_name = new ArrayList<String>();
		try {
			while(rs.next()) {
				teacher_no.add(rs.getString("���"));
				teacher_name.add(rs.getString("����"));
				teacher_sex.add(rs.getString("�Ա�"));
				teacher_picture.add(rs.getString("��Ƭ·��"));
				birth_year_month.add(rs.getString("��������"));
				register_time.add(rs.getString("ע��ʱ��"));
				politic.add(rs.getString("������ò"));
				hometown.add(rs.getString("����"));
				education_level.add(rs.getString("ѧ��"));
				position.add(rs.getString("ְλ"));
				teacher_telephone.add(rs.getString("��ϵ�绰"));
				teacher_mailbox.add(rs.getString("��ϵ����"));
				teacher_app_no.add(rs.getString("qq��΢��"));
				college_name.add(rs.getString("ѧԺ"));
				profession_name.add(rs.getString("רҵ"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
	
		TableModel tModel = new AbstractTableModel() {
			//�õ��ж�������¼
			public int rowCount() {
	//			Statement stmtCount = DB.createStmt(conn);
				String sqlCount = "select count(*) as ���� from teacherMWM";
				try {
					rsCount = Main.sqlconnect.stmt.executeQuery(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int count = 0;
				try {
					rsCount.next();
					count = rsCount.getInt("����");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return count;
			}
			//��������
			public int getRowCount() {return rowCount();}
			//��������
			public int getColumnCount() {return 15;}
			
			public Object getValueAt(int row, int col) {
				String[][] s = new String[rowCount() + 1][16];
				for(row=1; row<=rowCount(); row++) {
					for(col=1; col<=15; col++) {
						switch(row) {
						case 1:
							s[row][col] = teacher_no.get(row);
							break;
						case 2:
							s[row][col] = teacher_name.get(row);
							break;
						case 3:
							s[row][col]  = teacher_sex.get(row);
							break;
						case 4:
							s[row][col]  = teacher_picture.get(row);
							break;
						case 5:
							s[row][col]  = birth_year_month.get(row);
							break;
						case 6:
							s[row][col]  = register_time.get(row);
							break;
						case 7:
							s[row][col]  = politic.get(row);
							break;
						case 8:
							s[row][col]  = hometown.get(row);
							break;
						case 9:
							s[row][col]  = education_level.get(row);
							break;
						case 10:
							s[row][col]  = position.get(row);
							break;
						case 11:
							s[row][col]  = teacher_telephone.get(row);
							break;
						case 12:
							s[row][col]  = teacher_mailbox.get(row);
							break;
						case 13:
							s[row][col]  = teacher_app_no.get(row);
							break;
						case 14:
							s[row][col]  = college_name.get(row);
							break;
						case 15:
							s[row][col]  = profession_name.get(row);
							break;
						}
					}
				}
				return s;
			}
			//���ñ�������
			public final String[] columnName = {"���", "����","�Ա�","��Ƭ·��","��������","ע��ʱ��","������ò","����","ѧ��", "ְλ", "��ϵ�绰","��ϵ����","qq��΢��","ѧԺ", "רҵ"};
			public String getColumnName(int column) {
				return columnName[column];
			}
			public Class getColumnClass(int column) {
				return java.lang.String.class;	
	    	}
	
		};
		
		infotable = new JTable(tModel);
	}
}
