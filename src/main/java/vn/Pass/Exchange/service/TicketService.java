package vn.Pass.Exchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.Pass.Exchange.dao.TicketDao;
import vn.Pass.Exchange.entity.Ticket;

import java.util.List;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;

	// Lấy tất cả các vé từ cơ sở dữ liệu
	public List<Ticket> getAllTickets() {
		return ticketDao.findAll();
	}

	// Lấy vé theo ID
	public Ticket getTicketById(Long id) {
		return ticketDao.findById(id).orElse(null);
	}

}
