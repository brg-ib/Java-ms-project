package Msproject.Client.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Msproject.Client.Model.User;
import Msproject.Client.Model.Categorie;
import Msproject.Client.Model.Commentaire;
import Msproject.Client.Model.Article;
import Msproject.Client.Proxies.ArticleProxy;
import Msproject.Client.Proxies.UserProxy;
import Msproject.Client.Proxies.CategorieProxy;
import Msproject.Client.Proxies.CommentaireProxy;

@Controller
public class HomeController {
	
	private boolean estConnecte=false;
	
	private String username="";
	
	private String message; 
	
	@Autowired
	private CategorieProxy categorieProxy;
	
	@Autowired
	private UserProxy userProxy;
	
	@Autowired
	private CommentaireProxy commentaireProxy;
		
	@Autowired
	private ArticleProxy articleProxy;
	
	@RequestMapping("/")
	public String home(Model model){
	    return "Accueil";
	}
		
	@PostMapping(value="/login")
	public String login(@RequestBody User u, Model model) {
		if(userProxy.login(u)){
			message="Vous êtes connecté";
			username=u.getUsername();
			estConnecte=true;
		}else {
			message="Erreur. Veuillez reessayer";
		}
		model.addAttribute("message",message);
		return home(model);
	}
	
	@GetMapping(value="/deconnexion")
	public String logout(Model model) {
		estConnecte=false;
		message="Vous êtes déconnecté.";
		model.addAttribute("message", message);
		return home(model);
	}
		
	@PostMapping(value="/newUser")
	public String addUser(@RequestBody User u,Model model) {
			userProxy.addUser(u);
			message="Vous êtes inscrit.";
		model.addAttribute("message", message);
		return home(model);
	}
		
	@GetMapping(value="/categories")
	public String getListCategories(Model model){
		List<Categorie> liste= categorieProxy.getCategories();
		model.addAttribute("categories", liste);
		return home(model);
	}
	
	@PostMapping(value="/articles")
	public String getArticles(Model model, @RequestBody String categorie) {
		List<Article> liste = articleProxy.getArticlesByCategorie(categorie);
		if(liste.size()==0) {
			message="Aucun article pour cette catégorie";
			model.addAttribute("message", message);
		}		
		model.addAttribute("articles", liste);
		return home(model);
	}
	
	@GetMapping(value="/articles/{id}")
	public String getArticle(Model model, @PathVariable Long id) {
		Article article=articleProxy.getArticle(id);
		if(article==null) {
			message= "L'article n'existe pas.";
			model.addAttribute("message", message);
		}else {
			List<Commentaire> liste = commentaireProxy.getCommentaire(id);
			model.addAttribute("article", article);
			model.addAttribute("commentaires", liste);
		}
		return "Article";
	}
	
	
	@PostMapping(value="/categories/add")
	public String addCategorie(Model model,@RequestBody Categorie c) {
		if(!estConnecte) {
			message="Vous devez vous connecter pour ajouter une catégorie.";
		}else {
			categorieProxy.addCategorie(c);
			message="Votre catégorie a été ajouté.";
		}
		model.addAttribute("message", message);
		return getListCategories(model);
	}
		
		
	@PostMapping(value="/articles/{id}/add")
	public String addCommentaire(Model model,@PathVariable Long id ,@RequestBody Commentaire c) {	
		if(!estConnecte) {
			message="Vous devez vous connecter pour ajouter un commentaire.";
		}else {
			c.setArticleId(id);
			c.setUser(username);
			commentaireProxy.addCommentaire(c);
			message="Votre commentaire a été ajouté.";
		}
		model.addAttribute("message", message);
		return getArticle(model, id);
	}

	
	@PostMapping(value="/articles/add")
	public void addArticle(Model model, @RequestBody String categorie,@RequestBody Article a) {
		if(!estConnecte) {
			message="Vous devez vous connecter pour ajouter un article.";
		}else {
			a.setUser(username);
			articleProxy.addArticle(a);
			message="Votre article a été ajouté.";
		}
		model.addAttribute("message", message);
	}
}
