package it.esedra.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.esedra.journal.entity.Author;
import it.esedra.journal.repository.AuthorRepository;

@RestController
//@RequestMapping("author")
public class AuthorController {
	@Autowired // This means to get the bean called userRepository
	private AuthorRepository authorRepository;

	@GetMapping("/authors")
	@CrossOrigin
	public @ResponseBody Iterable<Author> getAllUsers() {
		return authorRepository.findAll();
	}


	
}
