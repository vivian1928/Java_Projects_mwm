package dao;

import java.util.ArrayList;

import entry.Cinema;

public interface CinemaDao {
	public int insertCinema(Cinema cinema) throws Exception;//添加影院
	
	public int deleteCinema(int cId) throws Exception;//通过id删除影院
	
	public int updateCinema(Cinema cinema) throws Exception;//更新影院信息
	
	public ArrayList<Cinema> getAllCinemas() throws Exception;//得到所有影院信息
	
	public ArrayList<Cinema> findCinemaByName(String cName) throws Exception;//通过名字模糊查找影院
	
	public ArrayList<Cinema> findCinemaById(int cId) throws Exception;//通过id精确查找影院
}
