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

import coloc.back.model.Hobby;
import coloc.back.model.Views;
import coloc.back.repository.IHobbyRepository;



@RestController
@RequestMapping("/hobbies")
@CrossOrigin("*")
public class HobbyRestController {

	@Autowired
	private IHobbyRepository hobbyRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Hobby> findAll() {
		List<Hobby> hobbies = hobbyRepo.findAll();

		return hobbies;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Hobby findById(@PathVariable Long id) {
		Optional<Hobby> optHobby = hobbyRepo.findById(id);

		if (optHobby.isPresent()) {
			return optHobby.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hobby non trouvé");
		}
	}
	
	/*@GetMapping("/by-logement/{idLogement}")
	@JsonView(Views.ViewCommon.class)
	public List<Hobby> findByIdLogement(@PathVariable("idLogement") Long id) {
		List<Hobby> logements = commoditeRepo.findAllHobbyByIdLogement(id);

		return logements;
	}*/
	

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Hobby create(@RequestBody Hobby hobby) {
		hobby = hobbyRepo.save(hobby);

		return hobby;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Hobby update(@PathVariable Long id, @RequestBody Hobby hobby) {
		if (!hobbyRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hobby non trouvée");
		}

		hobby = hobbyRepo.save(hobby);

		return hobby;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!hobbyRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hobby non trouvée");
		}
		hobbyRepo.deleteById(id);
	}

}