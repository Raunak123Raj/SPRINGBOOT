package in.ashokit.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.repo.TicketRepository;
import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;

@Service
public class BookingServiceImpl implements BookingService {
	public final Integer SEAT_CONST = 3;
	
	@Autowired
	TicketRepository repo;

	public Ticket bookTicket(Passenger passenger) {

		Ticket t = new Ticket();
		// BeanUtils.copyProperties(passenger, t);
		t.setName(passenger.getName());
		t.setDoj(passenger.getDoj());
		t.setFromm(passenger.getFromm());
		t.setTto(passenger.getTto());
		t.setTrainNumber(passenger.getTrainNumber());
		t.setTicketCost(550);
		
		t.setStatus(ticketStatus());
		repo.save(t);

		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		
		return repo.findById(ticketNumber).get();
	}

	private String ticketStatus() {
		long count = repo.count();
		
		if(count>SEAT_CONST) {
			return "Waiting";
		}else {
			return"Confirmed";
		}
	}

}
