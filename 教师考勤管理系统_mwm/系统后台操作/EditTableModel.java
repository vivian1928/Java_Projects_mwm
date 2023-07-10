package ϵͳ��̨����;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import ��ʦ���ڹ���ϵͳ����.InfoManagePanel;
import ���ݿ����Ӳ���.SqlConnect;

public class EditTableModel extends AbstractTableModel{

	public int rowCount() {
		//			Statement stmtCount = DB.createStmt(conn);
		String sqlCount = "select count(*) as ���� from teacherMWM";
		try {
			InfoManagePanel.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		try {
			InfoManagePanel.rsCount.next();
			count = InfoManagePanel.rsCount.getInt("����");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return count;
	}
	//��������
	public int getRowCount() {return rowCount();}
	//��������
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
		//���ñ�������
		public final String[] columnName = {"���", "����","�Ա�","��Ƭ·��","��������","ע��ʱ��","���֤��","������ò","����","ѧ��", "ְλ", "��ϵ�绰","��ϵ����","qq��΢��","ѧԺ", "רҵ"};
		public String getColumnName(int column) {
			return columnName[column];
		}
		public Class getColumnClass(int column) {
			return java.lang.String.class;	
		}
		public boolean isCellEditable(int rowIndex, int columnIndex) {
	        return columnIndex != 0 && columnIndex != 4 && columnIndex != 5 && columnIndex != 6 && columnIndex != 11 && columnIndex != 12;
	    }
				
		public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
	                // �����µĵ�Ԫ������ʱ���������ֵ���õ�ԭ������ֵ�У�
	                // ������UI���µ��� getValueAt(...) ��ȡ��Ԫ��ֵʱ���ܻ�ȡ������ֵ
			String teacher_no = InfoManagePanel.teacher_no.get(rowIndex);
			String sql_1 = null;
			String college_profession = null;
			switch(columnIndex) {
			case 1:
				sql_1 = "update teacherMWM set teacher_name = ";
				sql_1 += "\'"+ newValue +"\'";
				sql_1 += "where teacher_no = ";	 
				sql_1 += "\'"+ teacher_no +"\'";
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					Main.sqlconnect.stmt.executeUpdate(sql_1);
				}catch(Exception e1) {
				    e1.printStackTrace();
				}
				try {
					Main.sqlconnect.ct.commit();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				InfoManagePanel.teacher_name.set(rowIndex, (String) newValue);
				break;
					case 2:
						sql_1 = "update teacherMWM set teacher_sex = ";
						sql_1 += "\'"+ newValue +"\'";
						sql_1 += "where teacher_no = ";	 
						sql_1 += "\'"+ teacher_no +"\'";
						try {
							Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							Main.sqlconnect.stmt.executeUpdate(sql_1);
				        }catch(Exception e1) {
				            e1.printStackTrace();
				        }
						try {
							Main.sqlconnect.ct.commit();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						InfoManagePanel.teacher_sex.set(rowIndex, (String) newValue);
						break;
					case 3:
						sql_1 = "update teacherMWM set teacher_picture = ";
						sql_1 += "\'"+ newValue +"\'";
						sql_1 += "where teacher_no = ";	 
						sql_1 += "\'"+ teacher_no +"\'";
						try {
							Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							Main.sqlconnect.stmt.executeUpdate(sql_1);
				        }catch(Exception e1) {
				            e1.printStackTrace();
				        }
						try {
							Main.sqlconnect.ct.commit();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						InfoManagePanel.teacher_picture.set(rowIndex, (String) newValue);
						break;
					case 7:
						sql_1 = "update teacherMWM set politic = ";
						sql_1 += "\'"+ newValue +"\'";
						sql_1 += "where teacher_no = ";	 
						sql_1 += "\'"+ teacher_no +"\'";
						try {
							Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							Main.sqlconnect.stmt.executeUpdate(sql_1);
				        }catch(Exception e1) {
				            e1.printStackTrace();
				        }
						try {
							Main.sqlconnect.ct.commit();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						InfoManagePanel.politic.set(rowIndex, (String) newValue);
						break;
					case 8:
						sql_1 = "update teacherMWM set hometown = ";
						sql_1 += "\'"+ newValue +"\'";
						sql_1 += "where teacher_no = ";	 
						sql_1 += "\'"+ teacher_no +"\'";
						try {
							Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							Main.sqlconnect.stmt.executeUpdate(sql_1);
				        }catch(Exception e1) {
				            e1.printStackTrace();
				        }
						try {
							Main.sqlconnect.ct.commit();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						InfoManagePanel.hometown.set(rowIndex, (String) newValue);
						break;
					case 9:
						sql_1 = "update teacherMWM set education_level = ";
						sql_1 += "\'"+ newValue +"\'";
						sql_1 += "where teacher_no = ";	 
						sql_1 += "\'"+ teacher_no +"\'";
						try {
							Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							Main.sqlconnect.stmt.executeUpdate(sql_1);
				        }catch(Exception e1) {
				            e1.printStackTrace();
				        }
						try {
							Main.sqlconnect.ct.commit();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						InfoManagePanel.education_level.set(rowIndex, (String) newValue);
						break;
					case 10:
						sql_1 = "update teacherMWM set position = ";
						sql_1 += "\'"+ newValue +"\'";
						sql_1 += "where teacher_no = ";	 
						sql_1 += "\'"+ teacher_no +"\'";
						try {
							Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							Main.sqlconnect.stmt.executeUpdate(sql_1);
				        }catch(Exception e1) {
				            e1.printStackTrace();
				        }
						try {
							Main.sqlconnect.ct.commit();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						InfoManagePanel.position.set(rowIndex, (String) newValue);
						break;
					case 13:
						sql_1 = "update teacherMWM set teacher_app_no = ";
						sql_1 += "\'"+ newValue +"\'";
						sql_1 += "where teacher_no = ";	 
						sql_1 += "\'"+ teacher_no +"\'";
						try {
							Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							Main.sqlconnect.stmt.executeUpdate(sql_1);
				        }catch(Exception e1) {
				            e1.printStackTrace();
				        }
						try {
							Main.sqlconnect.ct.commit();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						InfoManagePanel.teacher_app_no.set(rowIndex, (String) newValue);
						break;
					case 14:
						String prof = InfoManagePanel.profession_name.get(rowIndex);
						sql_1 = "select college_profession from collegeMWM where college_name = ";
						sql_1 += "\'"+ newValue +"\' and profession_name = ";
						sql_1 += "\'"+ prof +"\'";
						college_profession = null;
						try {
							SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
							SqlConnect.rs=SqlConnect.ps.executeQuery();
							while(SqlConnect.rs.next()) {
								college_profession=SqlConnect.rs.getString(1);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(college_profession != null) {
							sql_1 = "update teacherMWM set college_profession = ";
							sql_1 += "\'"+ college_profession +"\'";
							sql_1 += "where teacher_no = ";	 
							sql_1 += "\'"+ teacher_no +"\'";
							try {
								Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
								Main.sqlconnect.stmt.executeUpdate(sql_1);
					        }catch(Exception e1) {
					            e1.printStackTrace();
					        }
							try {
								Main.sqlconnect.ct.commit();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							InfoManagePanel.college_name.set(rowIndex, (String) newValue);
						}
						break;
					case 15:
						String coll = InfoManagePanel.college_name.get(rowIndex);
						sql_1 = "select college_profession from collegeMWM where college_name = ";
						sql_1 += "\'"+ coll +"\' and profession_name = ";
						sql_1 += "\'"+ newValue +"\'";
						college_profession = null;
						try {
							SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
							SqlConnect.rs=SqlConnect.ps.executeQuery();
							while(SqlConnect.rs.next()) {
								college_profession=SqlConnect.rs.getString(1);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(college_profession != null) {
							sql_1 = "update teacherMWM set college_profession = ";
							sql_1 += "\'"+ college_profession +"\'";
							sql_1 += "where teacher_no = ";	 
							sql_1 += "\'"+ teacher_no +"\'";
							try {
								Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
								Main.sqlconnect.stmt.executeUpdate(sql_1);
					        }catch(Exception e1) {
					            e1.printStackTrace();
					        }
							try {
								Main.sqlconnect.ct.commit();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							InfoManagePanel.profession_name.set(rowIndex, (String) newValue);
						}
						break;
					}
	                // ���������ݺ󣬱���֪ͨ���ȥ����UI���ػ浥Ԫ�񣩣�������ʾ�����ݲ���ı�
	                fireTableCellUpdated(rowIndex, columnIndex);
	            }
}
