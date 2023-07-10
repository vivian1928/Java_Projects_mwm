package 数据库连接操作;

import java.sql.SQLException;

import 系统后台操作.Main;

public class FindCollege {
	
	public void findno() {
		String sql_1 = null;
		sql_1 = "Select college_profession from collegeMWM where college_name = \'";
		sql_1 += Main.teacher.college;
		sql_1 += "\' and profession_name = \'";
		sql_1 += Main.teacher.profession;
		sql_1 += "\'";
		try {
			Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
			Main.sqlconnect.rs=Main.sqlconnect.ps.executeQuery();
			while(SqlConnect.rs.next()) {
				Main.account.college_profession = Main.sqlconnect.rs.getString(1);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void findcollege() {
		String sql_1 = null;
		sql_1 = "Select college_name from collegeMWM where college_profession = \'";
		sql_1 += Main.teacher.college_profession;
		sql_1 += "\'";
		try {
			Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
			Main.sqlconnect.rs=Main.sqlconnect.ps.executeQuery();
			while(SqlConnect.rs.next()) {
				Main.teacher.college = Main.sqlconnect.rs.getString(1);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void findprofession() {
		String sql_1 = null;
		sql_1 = "Select profession_name from collegeMWM where college_profession = \'";
		sql_1 += Main.teacher.college_profession;
		sql_1 += "\'";
		try {
			Main.sqlconnect.ps=Main.sqlconnect.ct.prepareStatement(sql_1);
			Main.sqlconnect.rs=Main.sqlconnect.ps.executeQuery();
			while(SqlConnect.rs.next()) {
				Main.teacher.profession = Main.sqlconnect.rs.getString(1);
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
}
