package serviceimpl;

import java.util.ArrayList;

import dao.CinemaDao;
import daoimpl.CinemaDaoImpl;
import entry.Cinema;
import service.CinemaService;

public class CinemaServiceImpl implements CinemaService{
	CinemaDao cinemaDao = new CinemaDaoImpl();

	@Override
	public int addCinema(Cinema cinema) throws Exception {//添加影院
		
		return cinemaDao.insertCinema(cinema);
	}

	@Override
	public int deleteCinema(int cId) throws Exception {// 通过id删除影院
		
		return cinemaDao.deleteCinema(cId);
	}

	@Override
	public int updateCinema(Cinema cinema) throws Exception {// 更新影院信息
		
		return cinemaDao.updateCinema(cinema);
	}

	@Override
	public ArrayList<Cinema> getAllCinemas() throws Exception {// 得到所有影院信息
		
		return cinemaDao.getAllCinemas();
	}

	@Override
	public ArrayList<Cinema> findCinemaByName(String cName) throws Exception {// 通过名字模糊查找影院
		
		return cinemaDao.findCinemaByName(cName);
	}

	@Override
	public ArrayList<Cinema> findCinemaById(int cId) throws Exception {// 通过id精确查找影院
		
		return cinemaDao.findCinemaById(cId);
	}
}
