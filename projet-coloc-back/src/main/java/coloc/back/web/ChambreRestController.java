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

import coloc.back.model.Chambre;
import coloc.back.repository.IChambreRepository;

@RestController
@RequestMapping("/chambres")
@CrossOrigin("*")
public class ChambreRestController {

	@Autowired
	private IChambreRepository ChambreRepo;

	@GetMapping("")
	public List<Chambre> findAll() {
		List<Chambre> chambres = ChambreRepo.findAll();

		return chambres;
	}

	@GetMapping("{id}")
	public Chambre findById(@PathVariable Long id) {
		Optional<Chambre> optChambre = ChambreRepo.findById(id);

		if (optChambre.isPresent()) {
			return optChambre.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chambre non trouvée");
		}
	}

	@PostMapping("")
	public Chambre create(@RequestBody Chambre chambre) {
		chambre = ChambreRepo.save(chambre);

		return chambre;
	}

	@PutMapping("/{id}")
	public Chambre update(@PathVariable Long id, @RequestBody Chambre chambre) {
		if (!ChambreRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chambre non trouvée");
		}

		chambre = ChambreRepo.save(chambre);

		return chambre;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!ChambreRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chambre non trouvée");
		}
		
		ChambreRepo.deleteById(id);
	}

}
