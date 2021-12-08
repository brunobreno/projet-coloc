package coloc.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coloc.back.model.Locataire;

public interface ILocataireRepository extends JpaRepository<Locataire,Long>{

	//public Locataire findByIdChambre(int idChambre);
	
	@Query("select l from Locataire l where l.chambre.id= :idChambre")
	public Locataire findAllByIdChambre(@Param("idChambre") Long idChambre);
	
	@Query("select distinct l from Locataire l join l.chambre c join c.logement lo left join fetch l.hobbies h where lo.id= :idLogement")
	public List<Locataire> findAllByIdLogement(@Param("idLogement") Long idLogement);
	
	//@Query("select disctinct l from Locataire l left join fetch l.hobbies where l.chambre.id= :idChambre")
	//public Locataire findAllByIdChambreWithHobbies(Long idChambre);
}
