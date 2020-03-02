package Msproject.Categorie.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Msproject.Categorie.models.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long>{
	
public Categorie findByName(String Name);

public Categorie findById(int Id);

}
