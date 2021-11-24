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


import coloc.back.model.Regle;
import coloc.back.model.Views;
import coloc.back.repository.IRegleRepository;


@RestController
@RequestMapping("/regles")
@CrossOrigin("*")
public class RegleRestController {

	@Autowired
	private IRegleRepository regleRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Regle> findAll() {
		List<Regle> regles = regleRepo.findAll();

		return regles;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Regle findById(@PathVariable Long id) {
		Optional<Regle> optRegle = regleRepo.findById(id);

		if (optRegle.isPresent()) {
			return optRegle.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Regle non trouvée");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Regle create(@RequestBody Regle regle) {
		regle = regleRepo.save(regle);

		return regle;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Regle update(@PathVariable Long id, @RequestBody Regle regle) {
		if (!regleRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Regle non trouvée");
		}

		regle = regleRepo.save(regle);

		return regle;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!regleRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Regle non trouvée");
		}
		
		regleRepo.deleteById(id);
	}

}