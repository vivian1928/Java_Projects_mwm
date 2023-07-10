package service;

import java.util.ArrayList;

import entry.Session;

public interface SessionService {
	public int addSession(Session session) throws Exception;//添加场次

	public int deleteSession(int sId) throws Exception;//通过id删除场次
	
	public int deleteSessionByCId(int cId) throws Exception;//通过影院id删除场次
	
	public int deleteSessionByHId(int hId) throws Exception;//通过场厅id删除场次
	
	public int deleteSessionByMId(int mId) throws Exception;//通过电影id删除场次

	public int updateSession(Session session) throws Exception;//更新场次信息
	
	public int updateSessionAndSeat(Session session) throws Exception;//更新场次信息和座位

	public ArrayList<Session> getAllSessions() throws Exception;//获取所有场次信息

	public ArrayList<Session> findSessionById(int sId) throws Exception;//通过id查找场次信息
	
	public ArrayList<Session> findSessionByHId(int hId) throws Exception;//通过场厅id查找场次信息
	
	public ArrayList<Session> findSessionByCId(int cId) throws Exception;//通过影院id查找场次信息
	
	public ArrayList<Session> findSessionByMId(int mId) throws Exception;//通过电影id查找场次信息
	
	public ArrayList<Session> findSessionByCIdAndMId(int cId,int mId) throws Exception;//通过影院id和电影id查找场次信息
	
	public ArrayList<Session> findSessionByMIdTop() throws Exception;//查询电影Top10
}
