package fr.eni.ecole.encheres.ihm.encheres;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class ModelEncheres {
	private Enchere enchere;
	private Utilisateur utilisateur;
	private ArticleVendu articleAVendre;
	private Categorie categorie;
	private List<ArticleVendu> lstEncheres= new ArrayList<ArticleVendu>();
	private List<Categorie> lstCategories= new ArrayList<Categorie>();
	private String message;
	
	
	public ModelEncheres() {
		
	}


	


	public ModelEncheres(Enchere enchere, Utilisateur utilisateur, ArticleVendu articleAVendre, Categorie categorie,
			List<ArticleVendu> lstEncheres,List<Categorie> lstCategories, String message) {
		super();
		this.enchere = enchere;
		this.utilisateur = utilisateur;
		this.articleAVendre = articleAVendre;
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

	public ArticleVendu getArticleAVendre() {
		return articleAVendre;
	}

	public void setArticleAVendre(ArticleVendu articleAVendre) {
		this.articleAVendre = articleAVendre;
	}





	@Override
	public String toString() {
		return "ModelEncheres [enchere=" + enchere + ", encherisseur=" + utilisateur + ", articleAVendre=" + articleAVendre
				+ ", categorie=" + categorie + ", lstEncheresEnCours=" + lstEncheres
				+ ", message=" + message + "]";
	}



}
