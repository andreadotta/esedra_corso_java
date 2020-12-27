package it.esedra.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.esedra.journal.entity.Journal;
import it.esedra.journal.repository.JournalRepository;

@RestController
@RequestMapping(path="/journal")
public class JournalController {
	@Autowired // This means to get the bean called userRepository
	private JournalRepository journalRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Journal> getAllJournals() {
		return journalRepository.findAll();
	}

	
}