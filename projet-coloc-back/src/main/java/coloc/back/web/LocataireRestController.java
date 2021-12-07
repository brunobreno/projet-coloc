package coloc.back.web;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonView;

import coloc.back.model.Chambre;
import coloc.back.model.Locataire;
import coloc.back.model.Logement;
import coloc.back.model.Role;
import coloc.back.model.UtilisateurRole;
import coloc.back.model.Views;
import coloc.back.repository.IChambreRepository;
import coloc.back.repository.ILocataireRepository;
import coloc.back.repository.IUtilisateurRoleRepository;



@RestController
@RequestMapping("/locataires")
@CrossOrigin("*")
public class LocataireRestController {

	@Autowired
	private ILocataireRepository locataireRepo;
	@Autowired
	private IChambreRepository chambreRepo;
	@Autowired
	private IUtilisateurRoleRepository utilisateurRoleRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Locataire> findAll() {
		List<Locataire> locataires = locataireRepo.findAll();

		return locataires;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Locataire find(@PathVariable Long id) {
		Optional<Locataire> optLocataire = locataireRepo.findById(id);

		if (optLocataire.isPresent()) {
			return optLocataire.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Locataire non trouvé");
		}
	}
	
	@GetMapping("/by-chambre/{idChambre}")
	@JsonView(Views.ViewCommon.class)
	public Locataire findAllByChambre(@PathVariable("idChambre") Long id) {
		Locataire locataire = locataireRepo.findAllByIdChambre(id);
		return locataire;
	}
	
	@GetMapping("/by-logement/{idLogement}")
	@JsonView(Views.ViewCommon.class)
	public List<Locataire> findAllByLogement(@PathVariable("idLogement") Long id) {
		List<Chambre> chambres = chambreRepo.findAllByIdLogement(id);
		
		List<Locataire> locataires = new ArrayList<Locataire>();
		
		for(Chambre chambre : chambres) {
			locataires.add(locataireRepo.findAllByIdChambre(chambre.getId()));
		}
		
		return locataires;
	}
	
	@GetMapping("/by-logement/{idLogement}/description")
	@JsonView(Views.ViewLocataireDescription.class)
	public List<Locataire> findAllByLogementDescription(@PathVariable("idLogement") Long id) {
		List<Chambre> chambres = chambreRepo.findAllByIdLogement(id);
		
		List<Locataire> locataires = new ArrayList<Locataire>();
		
		for(Chambre chambre : chambres) {
			locataires.add(locataireRepo.findAllByIdChambre(chambre.getId()));
		}
		
		return locataires;
	}

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Locataire create(@RequestBody Locataire locataire) {
		locataire = locataireRepo.save(locataire);
		UtilisateurRole ur = new UtilisateurRole(locataire, Role.LOCATAIRE);
		ur = utilisateurRoleRepo.save(ur);
		return locataire;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
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
