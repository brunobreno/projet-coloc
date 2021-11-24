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


import coloc.back.model.Commodite;
import coloc.back.model.Views;
import coloc.back.repository.ICommoditeRepository;


@RestController
@RequestMapping("/commodites")
@CrossOrigin("*")
public class CommoditeRestController {

	@Autowired
	private ICommoditeRepository commoditeRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Commodite> findAll() {
		List<Commodite> commodites = commoditeRepo.findAll();

		return commodites;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Commodite findById(@PathVariable Long id) {
		Optional<Commodite> optChambre = commoditeRepo.findById(id);

		if (optChambre.isPresent()) {
			return optChambre.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commodite non trouvée");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Commodite create(@RequestBody Commodite commodite) {
		commodite = commoditeRepo.save(commodite);

		return commodite;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Commodite update(@PathVariable Long id, @RequestBody Commodite commodite) {
		if (!commoditeRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commodite non trouvée");
		}

		commodite = commoditeRepo.save(commodite);

		return commodite;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!commoditeRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commodite non trouvée");
		}
		commoditeRepo.deleteById(id);
	}

}