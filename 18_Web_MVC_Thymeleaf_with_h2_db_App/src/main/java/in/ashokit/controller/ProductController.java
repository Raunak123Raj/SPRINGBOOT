package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.ashokit.binding.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductController repo;
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("p", new Product());
		return "data";
	}
}
