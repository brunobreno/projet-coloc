package coloc.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coloc.back.model.*;

public interface IRegleRepository extends JpaRepository<Regle,Long>{
//	@Query("select r from Regle r  where r.logement.id= :id")
//	public List<Regle> findAllReglesByIdLogement(@Param("id") Long id);

}
