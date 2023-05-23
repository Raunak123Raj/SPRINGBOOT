package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;
import in.ashokit.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
	@GetMapping("/ticket/{ticketNum}")
	public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketNum) {
		Ticket ticketByNum = service.getTicketByNum(ticketNum);
		
		return new ResponseEntity<>(ticketByNum,HttpStatus.OK);
	}
	
	
	@PostMapping("/book-ticket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody  Passenger passenger) {
		Ticket ticket = service.bookTicket(passenger);
		
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
}
