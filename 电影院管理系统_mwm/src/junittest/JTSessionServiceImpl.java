package junittest;

import java.util.ArrayList;

import org.junit.Test;

import entry.Session;
import service.SessionService;
import serviceimpl.SessionServiceImpl;

public class JTSessionServiceImpl {
	SessionService ss = new SessionServiceImpl();
	Session session1 = new Session(1,1, 1, "2018-8-10 14:00-16:10", 30, 40);
	Session session2 = new Session(1,1, 2, "2018-8-10 16:30-18:50", 30, 40);
	Session session3 = new Session(1,1, 2, "2018-8-10 16:30-18:50", 49, 40);//供修改用
	
	@Test
	public void test() throws Exception {
		ss.addSession(session1);
		ss.addSession(session2);
	}

	@Test
	public void test2() throws Exception {
		ss.deleteSession(1);
	}
	
	@Test
	public void test3() throws Exception {
		ss.updateSession(session3);
	}
	
	@Test
	public void test4() throws Exception {
		ArrayList<Session> sessionList = ss.getAllSessions();
		for (Session session : sessionList) {
			System.out.println(session.toString());
		}
	}
	
	@Test
	public void test5() throws Exception {
		ArrayList<Session> sessionList = ss.findSessionById(2);
		for (Session session : sessionList) {
			System.out.println(session.toString());
		}
	}
	
	@Test
	public void test6() throws Exception {
		ArrayList<Session> sessionList = ss.findSessionByHId(1);
		for (Session session : sessionList) {
			System.out.println(session);
		}
	}
	@Test
	public void test7() throws Exception {
		ArrayList<Session> sessionList = ss.findSessionByCId(1);
		
		for (Session session : sessionList) {
			System.out.println(session.toString());
		}
	}
	@Test
	public void test8() throws Exception {
		ArrayList<Session> sessionList = ss.findSessionByMIdTop();
		
		for (Session session : sessionList) {
			System.out.println(session.toString());
		}
	}
}
