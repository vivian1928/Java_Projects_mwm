package serviceimpl;

import java.util.ArrayList;

import dao.SessionDao;
import daoimpl.SessionDaoImpl;
import entry.Session;
import service.SessionService;

public class SessionServiceImpl implements SessionService {
	SessionDao sessionDao = new SessionDaoImpl();

	@Override
	public int addSession(Session session) throws Exception {// 添加场次

		return sessionDao.insertSession(session);
	}

	@Override
	public int deleteSession(int sId) throws Exception {// 通过id删除场次

		return sessionDao.deleteSession(sId);
	}

	@Override
	public int deleteSessionByCId(int cId) throws Exception {// 通过影院id删除场次

		return sessionDao.deleteSessionByCId(cId);
	}

	@Override
	public int deleteSessionByHId(int hId) throws Exception {// 通过场厅id删除场次
		
		return sessionDao.deleteSessionByHId(hId);
	}
	
	@Override
	public int deleteSessionByMId(int mId) throws Exception {//通过电影id删除场次
		
		return sessionDao.deleteSessionByMId(mId);
	}
	
	@Override
	public int updateSession(Session session) throws Exception {// 更新场次信息

		return sessionDao.updateSession(session);
	}
	
	@Override
	public int updateSessionAndSeat(Session session) throws Exception {// 更新场次信息和座位
		
		return sessionDao.updateSessionAndSeat(session);
	}

	@Override
	public ArrayList<Session> getAllSessions() throws Exception {// 获取所有场次信息

		return sessionDao.getAllSessions();
	}
	
	

	@Override
	public ArrayList<Session> findSessionById(int sId) throws Exception {// 通过id查找场次信息

		return sessionDao.findSessionById(sId);
	}

	@Override
	public ArrayList<Session> findSessionByHId(int hId) throws Exception {// 通过场厅id查找场次信息

		return sessionDao.findSessionByHId(hId);
	}

	@Override
	public ArrayList<Session> findSessionByCId(int cId) throws Exception {// 通过影院id查找场次信息

		return sessionDao.findSessionByCId(cId);
	}

	@Override
	public ArrayList<Session> findSessionByMId(int mId) throws Exception {// 通过电影id查找场次信息
		
		return sessionDao.findSessionByMId(mId);
	}

	@Override
	public ArrayList<Session> findSessionByCIdAndMId(int cId, int mId) throws Exception {//通过影院id和电影id查找场次信息
		
		return sessionDao.findSessionByCIdAndMId(cId, mId);
	}

	@Override
	public ArrayList<Session> findSessionByMIdTop() throws Exception {//电影top10
		
		return sessionDao.findSessionByMIdTop();
	}

	

	

	

}
