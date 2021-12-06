package coloc.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coloc.back.model.*;

public interface ICommoditeRepository extends JpaRepository<Commodite,Long>{
	
	//@Query("select c from Commodite c join c.logement l where l.id= :id")
	//public List<Commodite> findAllCommoditeByIdLogement(@Param("id") Long id);
	
	
	
}
