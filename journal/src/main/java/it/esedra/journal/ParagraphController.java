package it.esedra.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.esedra.journal.entity.Paragraph;
import it.esedra.journal.repository.ParagraphRepository;

@RestController
@RequestMapping(path="/paragraph" )
public class ParagraphController {
	@Autowired
	private ParagraphRepository paragraphRepository;
	
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Paragraph> getAllParagraphs() {
		return paragraphRepository.findAll();
	}

	

}
