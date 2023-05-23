package in.ashokit.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {

	private String BOOK_TICKET_URL = "http://13.232.253.164:8080/ticket";

	private String GET_TICKET_URL = "http://13.232.253.164:8080/ticket/{ticketNum}";
	
	private String BOOK_TICKET_URL_LOCAL = "http://localhost:9090/ticket";

	private String GET_TICKET_URL_LOCAL = "http://localhost:9090/ticket/{ticketNum}";


	@Override
	public Ticket bookTicket(Passenger passenger) {
		// get the instance of webclient(impl class)
				WebClient webClient = WebClient.create();

				// send get request and map response to Ticket obj

				Ticket ticket = webClient.post()
						.uri(BOOK_TICKET_URL_LOCAL)
						.body(BodyInserters.fromValue(passenger))
						.header("Content-Type","application/json")
						.accept(MediaType.APPLICATION_JSON)
						.retrieve()
						.bodyToMono(Ticket.class)
						.block();																	// call
	return ticket;

	}

	@Override
	public Ticket getTicketByNum(Integer ticketNum) {

		// get the instance of webclient(impl class)
		WebClient webClient = WebClient.create();

		// send get request and map response to Ticket obj

		Ticket ticket = webClient.get()
				.uri(GET_TICKET_URL_LOCAL,ticketNum)
				.accept(MediaType.ALL)
				.retrieve()
				.bodyToMono(Ticket.class)
				.block();																		// call

		return ticket;

		/*
		 * RestTemplate rt = new RestTemplate();
		 * 
		 * ResponseEntity<Ticket> respEntity = rt.getForEntity(GET_TICKET_URL,
		 * Ticket.class, ticketNumber);
		 * 
		 * Ticket ticket = respEntity.getBody();
		 * 
		 * return ticket;
		 */
	}

}
