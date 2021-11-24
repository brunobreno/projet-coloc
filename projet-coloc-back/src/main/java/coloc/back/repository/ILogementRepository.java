package coloc.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.back.model.*;

public interface ILogementRepository extends JpaRepository<Logement,Long>{

	//public List<Logement> findAllByIdProprio(int idProprio);
	//public List<Logement> findAllByAvailabilityWithProprio();
}
