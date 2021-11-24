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


import coloc.back.model.Utilisateur;
import coloc.back.repository.IUtilisateurRepository;


@RestController
@RequestMapping("/regles")
@CrossOrigin("*")
public class UtilisateurRestController {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@GetMapping("")
//	@JsonView(Views.ViewPhoto.class)
	public List<Utilisateur> findAll() {
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();

		return utilisateurs;
	}

	@GetMapping("/{id}")
//	@JsonView(Views.ViewPhoto.class)
	public Utilisateur findById(@PathVariable Long id) {
		Optional<Utilisateur> optUtilisateur = utilisateurRepo.findById(id);

		if (optUtilisateur.isPresent()) {
			return optUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
		}
	}
	

	@PostMapping("")
//	@JsonView(Views.ViewPhoto.class)
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurRepo.save(utilisateur);

		return utilisateur;
	}

	@PutMapping("/{id}")
	//@JsonView(Views.ViewPhoto.class)
	public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
		if (!utilisateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
		}

		utilisateur = utilisateurRepo.save(utilisateur);

		return utilisateur;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!utilisateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
		}
		
		utilisateurRepo.deleteById(id);
	}

}