package fr.eni.ecole.encheres.ihmEncheresAccueuil;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class ModelEncheres {
	private Enchere enchere;
	private Utilisateur utilisateur;
	private ArticleVendu article;
	private Categorie categorie;
	private List<ArticleVendu> lstEncheres= new ArrayList<ArticleVendu>();
	private List<Categorie> lstCategories= new ArrayList<Categorie>();;
	private String message;
	
	
	public ModelEncheres() {
		
	}


	


	public ModelEncheres(Enchere enchere, Utilisateur utilisateur, ArticleVendu article, Categorie categorie,
			List<ArticleVendu> lstEncheres,List<Categorie> lstCategories, String message) {
		super();
		this.enchere = enchere;
		this.utilisateur = utilisateur;
		this.article = article;
		this.categorie = categorie;
		this.lstEncheres = lstEncheres;
		this.lstCategories = lstCategories;
		this.message = message;
	}



	

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Enchere getEnchere() {
		return enchere;
	}
	public Utilisateur getUtilisateurur() {
		return utilisateur;
	}
	public ArticleVendu getArticle() {
		return article;
	}
	public List<ArticleVendu> getLstEncheres() {
		return lstEncheres;

	}
	public String getMessage() {
		return message;
	}
	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
	public void setLstEncheres(List<ArticleVendu> lstEncheresEnCours) {
		this.lstEncheres = lstEncheresEnCours;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public List<Categorie> getLstCategories() {
		return lstCategories;
	}


	public void setLstCategories(List<Categorie> lstCategories) {
		this.lstCategories = lstCategories;
	}







	@Override
	public String toString() {
		return "ModelEncheres [enchere=" + enchere + ", encherisseur=" + utilisateur + ", article=" + article
				+ ", categorie=" + categorie + ", lstEncheresEnCours=" + lstEncheres
				+ ", message=" + message + "]";
	}



}
