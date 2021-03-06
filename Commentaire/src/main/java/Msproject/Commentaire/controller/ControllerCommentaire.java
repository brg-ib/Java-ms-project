package Msproject.Commentaire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Msproject.Commentaire.models.Commentaire;
import Msproject.Commentaire.repositories.CommentaireRepository;

@RestController
public class ControllerCommentaire {
	@Autowired
	private CommentaireRepository commentaireRepository;
	
	@GetMapping(value="/comment/{idArticle}")
	public List<Commentaire> getCommentaire(@PathVariable Long idArticle){
		List<Commentaire> commentaires = new ArrayList<Commentaire>(); 
		commentaireRepository.findByIdArticle(idArticle).forEach(commentaires::add);
		return commentaires;
	}
	
	@GetMapping(value="/comments")
	public List<Commentaire> getCommentaires() {
		List<Commentaire> commentaires = new ArrayList<Commentaire>(); 
		commentaireRepository.findAll().forEach(commentaires::add);
		return commentaires;
	}
	
	@PostMapping(value="/add")
	public void addCommentaire(@RequestBody Commentaire c) {
		commentaireRepository.save(c);
	}

}
