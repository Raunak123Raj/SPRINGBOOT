package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.ashokit.feign.GreetFeignClient;

@RestController
public class WelcomeRestController {

	@Autowired
	private GreetFeignClient greetClient;
	
	@GetMapping("/welcome")
	public String getWelcome() {
		
		String greetResp = greetClient.invokeGreetApi();
		
		return greetResp + ", Welcome To Ashok IT";
	}
}
