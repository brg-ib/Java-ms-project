package Msproject.Commentaire.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Msproject.Commentaire.models.Commentaire;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Long>{
	
	public Iterable<Commentaire> findByIdArticle(Long idAuteur);
}