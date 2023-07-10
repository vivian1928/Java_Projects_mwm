package dao;

import java.util.ArrayList;

import entry.Hall;

public interface HallDao {
	public int insertHall(Hall hall) throws Exception;//添加场厅

	public int deleteHall(int hId) throws Exception;//通过id删除场厅
	
	public int deleteHallByCId(int cId) throws Exception;//通过影院id删除场厅

	public int updateHall(Hall hall) throws Exception;//更新场厅信息

	public ArrayList<Hall> getAllHalls() throws Exception;//获取所有场厅信息

	public ArrayList<Hall> findHallById(int hId) throws Exception;//通过id查找场厅信息
	
	public ArrayList<Hall> findHallByCId(int cId) throws Exception;//通过影院ID查找场厅信息
}
