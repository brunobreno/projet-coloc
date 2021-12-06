package coloc.back.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
import coloc.back.model.Commodite;
import coloc.back.model.Locataire;
import coloc.back.model.Logement;
import coloc.back.model.Regle;
import coloc.back.model.Views;
import coloc.back.repository.IChambreRepository;
import coloc.back.repository.ILocataireRepository;
import coloc.back.repository.ILogementRepository;



@RestController
@RequestMapping("/logements")
@CrossOrigin("*")
public class LogementRestController {

	@Autowired
	private ILogementRepository logementRepo;
	@Autowired
	private ILocataireRepository locataireRepo;
	@Autowired
	private IChambreRepository chambreRepo;

	@GetMapping("")
	@PreAuthorize("hasAnyRole('ADMIN','PROPRIETAIRE')")
	@JsonView(Views.ViewCommon.class)
	public List<Logement> findAll() {
		List<Logement> logements = logementRepo.findAll();

		return logements;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Logement find(@PathVariable Long id) {
		Optional<Logement> optLogement = logementRepo.findById(id);

		if (optLogement.isPresent()) {
			return optLogement.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Logement non trouvé");
		}
	}
	
	@GetMapping("/by-ville/{ville}/with-commodite")
	@JsonView(Views.ViewLogementCommodite.class)
	public List<Logement> findAllWithCommoditeByVille(@PathVariable String ville) {
		List<Logement> logements = logementRepo.findAllByVilleWithCom(ville);
		return logements;
	}
	
	
	@GetMapping("/with-commodite/{id}")
	@JsonView(Views.ViewLogementCommodite.class)
	public Logement findWithCommodite(@PathVariable Long id) {
		Optional<Logement> optLogement = logementRepo.findByIdWithCommodite(id);

		if (optLogement.isPresent()) {
			return optLogement.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Logement non trouvé");
		}
	}
	
	@GetMapping("/complete/{id}")
	@JsonView(Views.ViewLogementComplete.class)
	public Logement findWithRegle(@PathVariable Long id) {
		Optional<Logement> optLogement = logementRepo.findById(id);

		if (optLogement.isPresent()) {
			return optLogement.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Logement non trouvé");
		}
	}
	
	
	@GetMapping("/with-commodite")
	@JsonView(Views.ViewLogementCommodite.class)
	public List<Logement> findAllWithCommodite() {
		List<Logement> logements = logementRepo.findAllWithCommodite();
		return logements;
	}
	
	@GetMapping("/by-ville/{ville}")
	@JsonView(Views.ViewCommon.class)
	public List<Logement> findByVille(@PathVariable String ville) {
		List<Logement> logements = logementRepo.findAllLogementByVille(ville);

		return logements;
	}
	
	@GetMapping("/by-commodite/{commodite}")
	@JsonView(Views.ViewCommon.class)
	public List<Logement> findByCommodite(@PathVariable String commodite) {
		List<Logement> logements = logementRepo.findAllLogementByCommodite(commodite);

		return logements;
	}

	@GetMapping("/by-proprietaire/{idProprietaire}")
	@JsonView(Views.ViewLogementComplete.class)
	public List<Logement> findByIdProprietaire(@PathVariable("idProprietaire") Long id) {
		List<Logement> logements = logementRepo.findAllLogementByIdProprietaire(id);

		return logements;
	}
	
	@GetMapping("/by-dispo/{ville}")
	@JsonView(Views.ViewCommon.class)
	public List<Logement> findByDispoAndVille(@PathVariable("ville") String ville) {
		List<Logement> logements = logementRepo.findAllLogementByDispoAndVille(ville);

		return logements;
	}
	
	@GetMapping("/with-locataires/{idLogement}")
	@JsonView(Views.ViewCommon.class)
	public List<Locataire> findAllByLogement(@PathVariable("idLogement") Long id) {
		List<Chambre> chambres = chambreRepo.findAllByIdLogement(id);
		List<Locataire> locataires = new ArrayList<Locataire>();
		for(Chambre chambre : chambres) {
			locataires.add(locataireRepo.findAllByIdChambre(chambre.getId()));
		}
		
		return locataires;
	}
	
	
	
	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Logement create(@RequestBody Logement logement) {		
		logement = logementRepo.save(logement);

		return logement;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Logement update(@PathVariable Long id, @RequestBody Logement logement) {
		if (!logementRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Logement non trouvé");
		}

		logement = logementRepo.save(logement);

		return logement;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!logementRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Logement non trouvé");
		}
		
		logementRepo.deleteById(id);
	}
	
}
