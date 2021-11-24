package coloc.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.back.model.*;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur,Long>{

	//public Utilisateur connect(String email, String password);
	//public Utilisateur findByEmail(String email);
}
