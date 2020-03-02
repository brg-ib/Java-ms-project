package Msproject.Article.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Msproject.Article.models.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>{
	public Article findById(String Id);
	public Iterable<Article> findByCategorie(String categorie);
}

