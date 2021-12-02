package coloc.back.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import coloc.back.model.Civilite;
import coloc.back.model.Situation;



@RestController
@CrossOrigin("*")
public class CommonRestController {
	
	@GetMapping("/civilites")
    public Civilite[] getCivilites() {
        return Civilite.values();
    }

	@GetMapping("/situations")
    public Situation[] getSituations() {
        return Situation.values();
    }
	
}
