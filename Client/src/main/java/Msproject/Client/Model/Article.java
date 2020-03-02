package Msproject.Client.Model;

public class Article {
	private Long id;	
	private String categorie;
	private String auteur;
	private String date;
	private String contenu;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getUser() {
		return auteur;
	}
	public void setUser(String auteur) {
		this.auteur = auteur;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
