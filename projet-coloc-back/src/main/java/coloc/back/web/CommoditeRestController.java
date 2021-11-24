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

import coloc.back.model.Commodite;
import coloc.back.repository.ICommoditeRepository;

@RestController
@RequestMapping("/commodites")
@CrossOrigin("*")
public class CommoditeRestController {

	@Autowired
	private ICommoditeRepository CommoditeRepo;

	@GetMapping("")
	public List<Commodite> findAll() {
		List<Commodite> commodites = CommoditeRepo.findAll();

		return commodites;
	}

	@GetMapping("{id}")
	public Commodite findById(@PathVariable Long id) {
		Optional<Commodite> optCommodite = CommoditeRepo.findById(id);

		if (optCommodite.isPresent()) {
			return optCommodite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commodite non trouvée");
		}
	}

	@PostMapping("")
	public Commodite create(@RequestBody Commodite commodite) {
		commodite = CommoditeRepo.save(commodite);

		return commodite;
	}

	@PutMapping("/{id}")
	public Commodite update(@PathVariable Long id, @RequestBody Commodite commodite) {
		if (!CommoditeRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commodite non trouvée");
		}

		commodite = CommoditeRepo.save(commodite);

		return commodite;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!CommoditeRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commodite non trouvée");
		}
		
		CommoditeRepo.deleteById(id);
	}

}
