package it.esedra.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.esedra.journal.entity.Chapter;
import it.esedra.journal.repository.ChapterRepository;



@RestController
@RequestMapping(path= "/chapter")
public class ChapterController {
	@Autowired
	private ChapterRepository chapterRepository;
	
	
	public @ResponseBody Iterable<Chapter> getAllChapters(){
		
		return chapterRepository.findAll();
		
	}
	
	
}
