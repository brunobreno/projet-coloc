package coloc.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.back.model.*;

public interface IChambreRepository extends JpaRepository<Chambre,Long>{

	//public List<Chambre> findAllByIdLogement(int idLogement);
}
