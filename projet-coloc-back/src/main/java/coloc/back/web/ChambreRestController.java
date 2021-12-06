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


import coloc.back.model.Chambre;
import coloc.back.model.Views;
import coloc.back.repository.IChambreRepository;


@RestController
@RequestMapping("/chambres")
@CrossOrigin("*")
public class ChambreRestController {

	@Autowired
	private IChambreRepository chambreRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Chambre> findAll() {
		List<Chambre> chambres = chambreRepo.findAll();

		return chambres;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Chambre findById(@PathVariable Long id) {
		Optional<Chambre> optChambre = chambreRepo.findById(id);

		if (optChambre.isPresent()) {
			return optChambre.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chambre non trouvée");
		}
	}

	@GetMapping("/by-logement/{idLogement}")
	@JsonView(Views.ViewChambre.class)
	public List<Chambre> findByIdLogement(@PathVariable("idLogement") Long id) {
		List<Chambre> chambres = chambreRepo.findAllByIdLogement(id);
		return chambres;
	}
	

	@GetMapping("/by-logement/with-commodite/{idLogement}")
	@JsonView(Views.ViewChambreDetailDescription.class)
	public List<Chambre> findByIdLogementWithCommodite(@PathVariable("idLogement") Long id) {
		List<Chambre> chambres = chambreRepo.findAllByIdLogement(id);
		return chambres;
	}
	
	
	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Chambre create(@RequestBody Chambre chambre) {
		chambre = chambreRepo.save(chambre);

		return chambre;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Chambre update(@PathVariable Long id, @RequestBody Chambre chambre) {
		if (!chambreRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chambre non trouvée");
		}

		chambre = chambreRepo.save(chambre);

		return chambre;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!chambreRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chambre non trouvée");
		}
		chambreRepo.deleteById(id);
	}

}