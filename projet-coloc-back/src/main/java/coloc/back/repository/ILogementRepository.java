package coloc.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coloc.back.model.*;


public interface ILogementRepository extends JpaRepository<Logement,Long>{

	//public List<Logement> findAllByIdProprio(int idProprio);
	//public List<Logement> findAllByAvailabilityWithProprio();
	
	@Query("select l from Logement l where l.localisation.ville = :ville")
	public List<Logement> findAllLogementByVille(@Param("ville") String ville);
	
	@Query("select l from Logement l join l.commodites c where c.libelle= :commodite")
	public List<Logement> findAllLogementByCommodite(@Param("commodite") String commodite);
	
	@Query("select l from Logement l  where l.proprietaire.id= :id")
	public List<Logement> findAllLogementByIdProprietaire(@Param("id") Long id);
	
	@Query("select l from Logement l  where l.nChambreOccup<l.nChambre AND l.localisation.ville= :ville")
	public List<Logement> findAllLogementByDispoAndVille(@Param("ville") String ville);
}
