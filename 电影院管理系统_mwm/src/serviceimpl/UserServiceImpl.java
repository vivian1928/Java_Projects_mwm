package serviceimpl;

import java.util.List;

import dao.UserDao;
import daoimpl.UserDaoImpl;
import entry.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	@Override
	public int addUser(User user) throws Exception {// 添加用户
		
		return userDao.insertUser(user);
	}

	@Override
	public int deleteUser(int uId) throws Exception {// 通过id删除用户
		
		return userDao.deleteUser(uId);
	}

	@Override
	public int updateUser(User user) throws Exception {// 更新用户信息
		
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAllsUsers() throws Exception {// 获取所有用户信息
		
		return userDao.getAllsUsers();
	}

	@Override
	public List<User> findUserById(int uId) throws Exception {// 通过id查找用户
		
		return userDao.findUserById(uId);
	}

	@Override
	public List<User> findUserByName(String uName) throws Exception {// 通过用户名模糊查找用户
		
		return userDao.findUserByName(uName);
	}

	@Override
	public List<User> findUserByUserName(String userName) throws Exception {// 通过用户名精确查找用户
		
		return userDao.findUserByUserName(userName);
	}

}
