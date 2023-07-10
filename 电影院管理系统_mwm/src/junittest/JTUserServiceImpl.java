package junittest;

import java.util.List;

import org.junit.Test;

import entry.User;
import service.UserService;
import serviceimpl.UserServiceImpl;

public class JTUserServiceImpl {
	UserService us = new UserServiceImpl();
	User user1 = new User("后来", "123", 1, 50);
	User user2 = new User("晴天", "456", 1, 30);
	User user3 = new User(3,"晴天", "789", 1, 30);
	
	@Test
	public void test() throws Exception {
		us.addUser(user1);
		us.addUser(user2);
	}
	
	@Test
	public void test2() throws Exception {
		us.deleteUser(2);
	}
	
	@Test
	public void test3() throws Exception {
		us.updateUser(user3);
	}
	
	@Test
	public void test4() throws Exception {
		List<User> userList  = us.getAllsUsers();
		for (User user : userList) {
			System.out.println(user.toString());
		}
	}
	
	@Test
	public void test5() throws Exception {
		List<User> userList  = us.findUserById(3);
		for (User user : userList) {
			System.out.println(user.toString());
		}
	}
	
	@Test
	public void test6() throws Exception {
		List<User> userList  = us.findUserByName("晴");
		for (User user : userList) {
			System.out.println(user.toString());
		}
	}

}
