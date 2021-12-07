package coloc.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import coloc.back.model.*;

public interface ILocataireRepository extends JpaRepository<Locataire,Long>{

	//public Locataire findByIdChambre(int idChambre);
	
	@Query("select l from Locataire l where l.chambre.id= :idChambre")
	public Locataire findAllByIdChambre(Long idChambre);
	
	//@Query("select disctinct l from Locataire l left join fetch l.hobbies where l.chambre.id= :idChambre")
	//public Locataire findAllByIdChambreWithHobbies(Long idChambre);
}
