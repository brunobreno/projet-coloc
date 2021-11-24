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



import coloc.back.model.Notation;
import coloc.back.model.Views;
import coloc.back.repository.INotationRepository;


@RestController
@RequestMapping("/notations")
@CrossOrigin("*")
public class NotationRestController {

	@Autowired
	private INotationRepository notationRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Notation> findAll() {
		List<Notation> notations = notationRepo.findAll();

		return notations;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Notation find(@PathVariable Long id) {
		Optional<Notation> optNotation = notationRepo.findById(id);

		if (optNotation.isPresent()) {
			return optNotation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notation non trouvée");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Notation create(@RequestBody Notation notation) {
		notation = notationRepo.save(notation);

		return notation;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Notation update(@PathVariable Long id, @RequestBody Notation notation) {
		if (!notationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notation non trouvée");
		}

		notation = notationRepo.save(notation);

		return notation;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!notationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notation non trouvée");
		}
		
		notationRepo.deleteById(id);
	}

}
