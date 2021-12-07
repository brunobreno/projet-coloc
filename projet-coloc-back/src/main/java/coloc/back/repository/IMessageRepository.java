package coloc.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


import coloc.back.model.*;

public interface IMessageRepository extends JpaRepository<Message,Long>{

	//public List<Message> findAllByIdDestinataireWithUtilisateur(int idDestinataire);
	//public List<Message> findAllByIdEmetteurWithUtilisateur(int idEmetteur);
	//public Message findByIdWithUtilisateur(int idMessage);

	@Query("select distinct m from Message m left join m.emetteur e where m.emetteur.id = :id")
	public List<Message> findByIdUserIdAsEmmeteur(@Param("id") Long id);

	@Query("select distinct m from Message m left join m.destinataire e where m.destinataire.id = :id")
	public List<Message> findByIdUserIdAsDestinataire(@Param("id") Long id);

	@Query("select m FROM Message m where m in (select distinct m from Message m left join m.emetteur e where m.emetteur.id = :id) or m in (select distinct m from Message m left join m.destinataire e where m.destinataire.id = :id) order by m.date")
	public List<Message> findAllByIdUserId(@Param("id") Long id);
}
