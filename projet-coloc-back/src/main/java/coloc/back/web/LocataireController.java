package coloc.back.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import coloc.back.model.Locataire;
import coloc.back.repository.ILocataireRepository;



@RestController
@RequestMapping("/locataires")
@CrossOrigin("*")
public class LocataireController {

	@Autowired
	private ILocataireRepository locataireRepo;

	@GetMapping("")
	@JsonView(Views.ViewLocataire.class)
	public List<Locataire> findAll() {
		List<Locataire> locataires = locataireRepo.findAll();

		return locataires;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewLocataireDetail.class)
	public Locataire find(@PathVariable Long id) {
		Optional<Locataire> optLocataire = locataireRepo.findById(id);

		if (optLocataire.isPresent()) {
			return optLocataire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Locataire non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewLocataire.class)
	public Locataire create(@Valid @RequestBody Locataire locataire, BindingResult result) {
		if(result.hasErrors()) {
			throw new LocataireValidationException();
		}
		
		locataire = locataireRepo.save(locataire);

		return locataire;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLocataire.class)
	public Locataire update(@PathVariable Long id, @RequestBody Locataire locataire) {
		if (!locataireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Locataire non trouvé");
		}

		locataire = locataireRepo.save(locataire);

		return locataire;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!locataireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Locataire non trouvé");
		}
		
		locataireRepo.deleteById(id);
	}
	
}
