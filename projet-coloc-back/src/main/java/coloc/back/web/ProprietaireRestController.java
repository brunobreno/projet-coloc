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


import coloc.back.model.Proprietaire;
import coloc.back.model.Role;
import coloc.back.model.UtilisateurRole;
import coloc.back.model.Views;
import coloc.back.repository.IProprietaireRepository;
import coloc.back.repository.IUtilisateurRoleRepository;


@RestController
@RequestMapping("/proprietaires")
@CrossOrigin("*")
public class ProprietaireRestController {

	@Autowired
	private IProprietaireRepository proprietaireRepo;
	@Autowired
	private IUtilisateurRoleRepository utilisateurRoleRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Proprietaire> findAll() {
		List<Proprietaire> proprietaires = proprietaireRepo.findAll();

		return proprietaires;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Proprietaire find(@PathVariable Long id) {
		Optional<Proprietaire> optProprietaire = proprietaireRepo.findById(id);

		if (optProprietaire.isPresent()) {
			return optProprietaire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proprietaire non trouvé");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Proprietaire create(@RequestBody Proprietaire proprietaire) {
		proprietaire = proprietaireRepo.save(proprietaire);
		UtilisateurRole ur = new UtilisateurRole(proprietaire, Role.PROPRIETAIRE);
		ur = utilisateurRoleRepo.save(ur);
		return proprietaire;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Proprietaire update(@PathVariable Long id, @RequestBody Proprietaire proprietaire) {
		if (!proprietaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proprietaire non trouvé");
		}

		proprietaire = proprietaireRepo.save(proprietaire);

		return proprietaire;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!proprietaireRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proprietaire non trouvé");
		}
		
		proprietaireRepo.deleteById(id);
	}

}