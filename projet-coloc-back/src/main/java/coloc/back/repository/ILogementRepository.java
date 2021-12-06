package coloc.back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coloc.back.model.*;


public interface ILogementRepository extends JpaRepository<Logement,Long>{

	//public List<Logement> findAllByIdProprio(int idProprio);
	//public List<Logement> findAllByAvailabilityWithProprio();
	
	@Query("select distinct l from Logement l left join fetch l.commodites c")
	public List<Logement> findAllWithCommodite();
	
	@Query("select l from Logement l where l.localisation.ville = :ville")
	public List<Logement> findAllLogementByVille(@Param("ville") String ville);
	
	@Query("select l from Logement l join l.commodites c where c.libelle= :commodite")
	public List<Logement> findAllLogementByCommodite(@Param("commodite") String commodite);
	
	@Query("select l from Logement l  where l.proprietaire.id= :id")
	public List<Logement> findAllLogementByIdProprietaire(@Param("id") Long id);
	
	@Query("select l from Logement l  where l.nChambreOccup<l.nChambre AND l.localisation.ville= :ville")
	public List<Logement> findAllLogementByDispoAndVille(@Param("ville") String ville);
	
	@Query("select distinct l from Logement l left join fetch l.commodites c where l.localisation.ville = :ville")
	public List<Logement> findAllByVilleWithCom(@Param("ville") String ville);
	
	@Query("select distinct l from Logement l left join fetch l.commodites c where l.localisation.ville = :ville order by l.loyer")
	public List<Logement> findAllByVilleWithComOrderByPriceAsc(@Param("ville") String ville);
	
	@Query("select distinct l from Logement l left join fetch l.commodites c where l.localisation.ville = :ville")
	public List<Logement> findAllByVilleWithComOrderByPriceDesc(@Param("ville") String ville);
	
	@Query("select distinct l from Logement l left join fetch l.commodites c where l.id = :id")
	Optional<Logement>  findByIdWithCommodite(@Param("id") Long id);
	
	@Query(value="SELECT * FROM `logement` WHERE (n_chambre - n_chambre_occup) > 0 ORDER BY date_de_mise_en_ligne LIMIT 3", nativeQuery = true)
	public List<Logement> findMostRecentLogement();
	
}





