package in.ashokit.response;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketNum;
	private String status;
	private Integer ticketCost;
	private String name;
	private String fromm;
	private String tto;
	private String doj;
	private String trainNumber;

}
