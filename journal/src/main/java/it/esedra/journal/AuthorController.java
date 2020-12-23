package it.esedra.journal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	
	@RequestMapping("/")
	public String index() {
		return "Hello!";
	}
}
