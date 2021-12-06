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

import coloc.back.model.Logement;
import coloc.back.model.Photo;
import coloc.back.model.Views;
import coloc.back.repository.IPhotoRepository;


@RestController
@RequestMapping("/photos")
@CrossOrigin("*")
public class PhotoRestController {

	@Autowired
	private IPhotoRepository photoRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Photo> findAll() {
		List<Photo> photos = photoRepo.findAll();

		return photos;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Photo find(@PathVariable Long id) {
		Optional<Photo> optPhoto = photoRepo.findById(id);

		if (optPhoto.isPresent()) {
			return optPhoto.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo non trouvée");
		}
	}
	

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Photo create(@RequestBody Photo photo) {
		photo = photoRepo.save(photo);

		return photo;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Photo update(@PathVariable Long id, @RequestBody Photo photo) {
		if (!photoRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo non trouvée");
		}

		photo = photoRepo.save(photo);

		return photo;
	}
	
	@GetMapping("/by-logement/{idLogement}")
	@JsonView(Views.ViewCommon.class)
	public List<Photo> findByIdLogement(@PathVariable("idLogement") Long id) {
		List<Photo> album = photoRepo.findAllPhotoByIdLogement(id);

		return album;
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!photoRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Photo non trouvée");
		}
		
		photoRepo.deleteById(id);
	}

}