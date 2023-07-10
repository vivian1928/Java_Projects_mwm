package 数据库连接操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import 系统后台操作.Main;

public class InfoTable {
	public JTable infotable; 
	private ResultSet rs;
	private ResultSet rsCount;
	public TableModel tModel;
	
	public void infotable() {
		String sql = "select teacher_no as 编号, teacher_name as 姓名, teacher_sex as 性别, teacher_picture as 照片路径, birth_year_month as 出生日期, register_time as 注册时间, politic as 政治面貌, hometown as 籍贯, education_level as 学历, position as 职位, teacher_telephone as 联系电话, teacher_mailbox as 联系邮箱, teacher_app_no as qq或微信, college_name as 学院, profession_name as 专业 from teacherMWM as A, collegeMWM as B where A.college_profession = B.college_profession order by A.id";
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
				teacher_no.add(rs.getString("编号"));
				teacher_name.add(rs.getString("姓名"));
				teacher_sex.add(rs.getString("性别"));
				teacher_picture.add(rs.getString("照片路径"));
				birth_year_month.add(rs.getString("出生日期"));
				register_time.add(rs.getString("注册时间"));
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
	
		TableModel tModel = new AbstractTableModel() {
			//拿到有多少条记录
			public int rowCount() {
	//			Statement stmtCount = DB.createStmt(conn);
				String sqlCount = "select count(*) as 行数 from teacherMWM";
				try {
					rsCount = Main.sqlconnect.stmt.executeQuery(sql);
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
			//设置表格的列名
			public final String[] columnName = {"编号", "姓名","性别","照片路径","出生日期","注册时间","政治面貌","籍贯","学历", "职位", "联系电话","联系邮箱","qq或微信","学院", "专业"};
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
