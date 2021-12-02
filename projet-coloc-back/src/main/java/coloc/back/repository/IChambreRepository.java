package coloc.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import coloc.back.model.*;

public interface IChambreRepository extends JpaRepository<Chambre,Long>{

	
	@Query("select c from Chambre c where c.logement.id= :idLogement")
	public List<Chambre> findAllByIdLogement(Long idLogement);
	
	
}
