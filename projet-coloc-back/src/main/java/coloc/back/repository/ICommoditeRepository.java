package coloc.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coloc.back.model.*;

public interface ICommoditeRepository extends JpaRepository<Commodite,Long>{
	


}
