package serviceimpl;

import java.util.ArrayList;

import dao.HallDao;
import daoimpl.HallDaoImpl;
import entry.Hall;
import service.HallService;

public class HallServiceImpl implements HallService {
	HallDao hallDao = new HallDaoImpl();

	@Override
	public int addHall(Hall hall) throws Exception {// 添加场厅

		return hallDao.insertHall(hall);
	}

	@Override
	public int deleteHall(int hId) throws Exception {// 通过id删除场厅

		return hallDao.deleteHall(hId);
	}

	@Override
	public int deleteHallByCId(int cId) throws Exception {// 通过影院id删除场厅
		
		return hallDao.deleteHallByCId(cId);
	}
	
	@Override
	public int updateHall(Hall hall) throws Exception {// 更新场厅信息

		return hallDao.updateHall(hall);
	}

	@Override
	public ArrayList<Hall> getAllHalls() throws Exception {// 获取所有场厅信息

		return hallDao.getAllHalls();
	}

	@Override
	public ArrayList<Hall> findHallById(int hId) throws Exception {// 通过id查找场厅信息

		return hallDao.findHallById(hId);
	}

	@Override
	public ArrayList<Hall> findHallByCId(int cId) throws Exception {// 通过影院id查找场厅信息
		
		return hallDao.findHallByCId(cId);
	}

	

}
