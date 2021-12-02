package coloc.back.web;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonView;

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

import coloc.back.model.Candidature;
import coloc.back.model.Views;
import coloc.back.repository.ICandidatureRepository;

@RestController
@RequestMapping("/candidatures")
@CrossOrigin("*")
public class CandidatureRestController {

	@Autowired
	private ICandidatureRepository candidatureRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Candidature> findAll() {
		List<Candidature> candidatures = candidatureRepo.findAll();

		return candidatures;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Candidature findById(@PathVariable Long id) {
		Optional<Candidature> optCandidature = candidatureRepo.findById(id);

		if (optCandidature.isPresent()) {
			return optCandidature.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidature non trouvée");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Candidature create(@RequestBody Candidature candidature) {
		candidature = candidatureRepo.save(candidature);

		return candidature;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Candidature update(@PathVariable Long id, @RequestBody Candidature candidature) {
		if (!candidatureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidature non trouvée");
		}

		candidature = candidatureRepo.save(candidature);

		return candidature;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!candidatureRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidature non trouvée");
		}
		
		candidatureRepo.deleteById(id);
	}

}
