package Msproject.Client.Proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Msproject.Client.Model.Commentaire;

@FeignClient(name="Commentaire")
@RibbonClient(name= "Commentaire")

public interface CommentaireProxy {
	
	@GetMapping(value="/comment/{idArticle}")
	public List<Commentaire> getCommentaire(@PathVariable Long idArticle);
	
	@GetMapping(value="/comments")
	public List<Commentaire> getCommentaires();
	
	@PostMapping(value="/add")
	public void addCommentaire(@RequestBody Commentaire c);
}
