package utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBUtils {
	static Connection conn;
	static PreparedStatement statement;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection("jdbc:mysql:///cinemamanager", "root", "wywwkyasn423");
		}
		return conn;
	}

	public static void closeConn() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}

	public static void closeStatement(PreparedStatement statement2) throws SQLException {
		if (statement2 != null) {
			statement2.close();
			statement2 = null;
		}
	}

	public static void closeResultSet(ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
			resultSet = null;
		}
	}

	public static int execute(String sql, Object... args) throws SQLException {
		int row = 0;
		try {
			getConnection();
			statement = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					statement.setObject(i + 1, args[i]);
				}
			}
			row = statement.executeUpdate();
			return row;
		} finally {
			closeStatement(statement);
			closeConn();
		}
	}
	public static <T> ArrayList<T> querry(Class<T> clazz,String sql,Object...args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException{
		ResultSet resultSet = null;
		try {
			ArrayList<T> list = new ArrayList<>();
			getConnection();
			statement = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					statement.setObject(i + 1, args[i]);
				}
			}
			resultSet = statement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			while(resultSet.next()){
				T obj = clazz.newInstance();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					Field field = clazz.getDeclaredField(rsmd.getColumnName(i+1));
					Object value = resultSet.getObject(i+1);
					field.setAccessible(true);
					field.set(obj, value);
				}
				list.add(obj);
			}
			
			return list;
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConn();
		}
	}
}
