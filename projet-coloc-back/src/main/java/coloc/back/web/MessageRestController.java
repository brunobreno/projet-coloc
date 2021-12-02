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

import com.fasterxml.jackson.annotation.JsonView;

import coloc.back.model.Message;
import coloc.back.model.Views;
import coloc.back.repository.IMessageRepository;



@RestController
@RequestMapping("/messages")
@CrossOrigin("*")
public class MessageRestController {

	@Autowired
	private IMessageRepository messageRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<Message> findAll() {
		List<Message> messages = messageRepo.findAll();

		return messages;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Message find(@PathVariable Long id) {
		Optional<Message> optMessage = messageRepo.findById(id);

		if (optMessage.isPresent()) {
			return optMessage.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCommon.class)
	public Message create(@RequestBody Message message) {		
		message = messageRepo.save(message);

		return message;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommon.class)
	public Message update(@PathVariable Long id, @RequestBody Message message) {
		if (!messageRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message non trouvé");
		}

		message = messageRepo.save(message);

		return message;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!messageRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message non trouvé");
		}
		
		messageRepo.deleteById(id);
	}
	
}
