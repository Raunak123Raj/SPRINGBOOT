package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.response.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
  
  }
 