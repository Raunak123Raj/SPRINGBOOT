package in.ashokit.binding;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonConverter {
	
	public static void main(String[] args) throws Exception {
		
		Customer c = new Customer();
		c.setId(1);
		c.setName("Robert");
		c.setEmail("robert@gmail.com");
		c.setPhno(9905028729l);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("customer.json"), c);
		System.out.println("Json file created");
	}
}
