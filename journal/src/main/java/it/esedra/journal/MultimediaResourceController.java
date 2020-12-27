package it.esedra.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.esedra.journal.entity.MultimediaResource;
import it.esedra.journal.repository.MultimediaResourceRepository;

@RestController
@RequestMapping(path="/multimediaresource")
public class MultimediaResourceController {
	@Autowired // This means to get the bean called userRepository
	private MultimediaResourceRepository multimediaResourceRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<MultimediaResource> getAllMultimediaResources() {
		return multimediaResourceRepository.findAll();
	}

	
}
