package dao;

import java.util.List;

import entry.User;

public interface UserDao {
	public int insertUser(User user) throws Exception;// 添加用户

	public int deleteUser(int uId) throws Exception;// 通过id删除用户

	public int updateUser(User user) throws Exception;// 更新用户信息

	public List<User> getAllsUsers() throws Exception;// 获取所有用户信息

	public List<User> findUserById(int uId) throws Exception;// 通过id查找用户

	public List<User> findUserByName(String uName) throws Exception;// 通过用户名模糊查找用户
	
	public List<User> findUserByUserName(String userName) throws Exception;// 通过用户名精确查找用户
}
