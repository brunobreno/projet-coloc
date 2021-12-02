package coloc.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coloc.back.model.*;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur,Long>{

	@Query("select distinct u from Utilisateur u left join fetch u.roles where u.username = :username")
	Optional<Utilisateur> findByUsernameWithRoles(@Param("username") String username);
	
	@Query("select distinct u from Utilisateur u left join fetch u.roles where u.username = :username and u.password = :password")
	Optional<Utilisateur> findByUsernameAndPasswordWithRoles(@Param("username") String username, @Param("password") String password);
}
