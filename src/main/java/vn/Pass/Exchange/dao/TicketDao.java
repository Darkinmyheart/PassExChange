package vn.Pass.Exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.Pass.Exchange.entity.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Long> {
    // Các phương thức tùy chỉnh nếu cần
}
