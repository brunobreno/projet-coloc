package coloc.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coloc.back.model.*;

public interface IMessageRepository extends JpaRepository<Message,Long>{

	//public List<Message> findAllByIdDestinataireWithUtilisateur(int idDestinataire);
	//public List<Message> findAllByIdEmetteurWithUtilisateur(int idEmetteur);
	//public Message findByIdWithUtilisateur(int idMessage);
}
