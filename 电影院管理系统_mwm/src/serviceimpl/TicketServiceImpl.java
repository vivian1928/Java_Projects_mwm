package serviceimpl;

import java.util.List;

import dao.TicketDao;
import daoimpl.TicketDaoImpl;
import entry.Ticket;
import service.TicketService;

public class TicketServiceImpl implements TicketService{
	TicketDao ticketDao = new TicketDaoImpl();
	@Override
	public int addTicket(Ticket ticket) throws Exception {// 添加电影订单信息
		
		return ticketDao.insertTicket(ticket);
	}

	@Override
	public List<Ticket> getAllTickets() throws Exception {// 获取所有电影订单信息
		
		return ticketDao.getAllTickets();
	}

	@Override
	public List<Ticket> findTicketByTId(int tId) throws Exception {// 通过id查找订单信息
		
		return ticketDao.findTicketByTId(tId);
	}
	
	@Override
	public List<Ticket> findTicketBySId(int sId) throws Exception {// 通过场次id查找订单信息
		
		return ticketDao.findTicketBySId(sId);
	}

	@Override
	public List<Ticket> findTicketByUId(int uId) throws Exception {
		
		return ticketDao.findTicketByUId(uId);
	}
	
	@Override
	public List<Ticket> findTicketByUIdAndSId(int uId, int sId) throws Exception {// 通过uId和sId查找订单信息
		
		return ticketDao.findTicketByUIdAndSId(uId, sId);
	}

	

	

}
