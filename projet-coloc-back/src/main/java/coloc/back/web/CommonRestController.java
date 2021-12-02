package coloc.back.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coloc.back.model.Civilite;
import coloc.back.model.Situation;


@RestController
@RequestMapping("/commons")
@CrossOrigin("*")
public class CommonRestController {

	@GetMapping("/situations")
	public Situation[] findSituations() {
		Situation[] situations = Situation.values();
		return situations;
	}

	@GetMapping("/civilites")
	public Civilite[] findCivilites() {
		Civilite[] civilites = Civilite.values();
		return civilites;
	}
}
