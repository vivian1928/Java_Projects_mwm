package service;

import java.util.List;

import entry.Ticket;

public interface TicketService {
	public int addTicket(Ticket ticket) throws Exception;// 添加电影订单信息

	public List<Ticket> getAllTickets() throws Exception;// 获取所有电影订单信息

	public List<Ticket> findTicketByTId(int tId) throws Exception;// 通过id查找订单信息
	
	public List<Ticket> findTicketBySId(int sId) throws Exception;// 通过场次id查找订单信息
	
	public List<Ticket> findTicketByUId(int uId) throws Exception;// 通过用户id查找订单信息

	public List<Ticket> findTicketByUIdAndSId(int uId, int sId) throws Exception;// 通过uId和sId查找订单信息
}
