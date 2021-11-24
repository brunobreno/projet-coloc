package coloc.back.web;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import coloc.back.model.Logement;
import coloc.back.repository.ILogementRepository;



@RestController
@RequestMapping("/logements")
@CrossOrigin("*")
public class LogementRestController {

	@Autowired
	private ILogementRepository logementRepo;

	@GetMapping("")
	//@JsonView(Views.ViewLogement.class)
	public List<Logement> findAll() {
		List<Logement> logements = logementRepo.findAll();

		return logements;
	}

	@GetMapping("/{id}")
	//@JsonView(Views.ViewLogementDetail.class)
	public Logement find(@PathVariable Long id) {
		Optional<Logement> optLogement = logementRepo.findById(id);

		if (optLogement.isPresent()) {
			return optLogement.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Logement non trouvé");
		}
	}

	@PostMapping("")
	//@JsonView(Views.ViewLogement.class)
	public Logement create(@RequestBody Logement logement) {		
		logement = logementRepo.save(logement);

		return logement;
	}

	@PutMapping("/{id}")
	//@JsonView(Views.ViewLogement.class)
	public Logement update(@PathVariable Long id, @RequestBody Logement logement) {
		if (!logementRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Logement non trouvé");
		}

		logement = logementRepo.save(logement);

		return logement;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!logementRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Logement non trouvé");
		}
		
		logementRepo.deleteById(id);
	}
	
}
