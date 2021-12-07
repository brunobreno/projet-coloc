package coloc.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coloc.back.model.*;

public interface IPhotoRepository extends JpaRepository<Photo,Long>{
	@Query("select p from Photo p where p.logement.id= :id")
	public List<Photo> findAllPhotoByIdLogement(@Param("id") Long id);

}
