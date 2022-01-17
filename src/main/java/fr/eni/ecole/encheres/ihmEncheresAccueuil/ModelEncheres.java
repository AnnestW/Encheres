package fr.eni.ecole.encheres.ihmEncheresAccueuil;

import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class ModelEncheres {
	private Enchere enchere;
	private Utilisateur encherisseur;
	private ArticleVendu article;
	private List<Enchere> lstEncheresEnCours;
	private List<Enchere> lstParCategorie;
	private List<Enchere> lstParNomArticle;
	private String message;
	
	
	public ModelEncheres() {
		
	}
	
	
	
	
	
	public ModelEncheres(Enchere enchere, Utilisateur encherisseur, ArticleVendu article,
			List<Enchere> lstEncheresEnCours, List<Enchere> lstParCategorie, List<Enchere> lstParNomArticle,
			String message) {
		this.enchere = enchere;
		this.encherisseur = encherisseur;
		this.article = article;
		this.lstEncheresEnCours = lstEncheresEnCours;
		this.lstParCategorie = lstParCategorie;
		this.lstParNomArticle = lstParNomArticle;
		this.message = message;
	}





	public Enchere getEnchere() {
		return enchere;
	}
	public Utilisateur getEncherisseur() {
		return encherisseur;
	}
	public ArticleVendu getArticle() {
		return article;
	}
	public List<Enchere> getLstEncheresEnCours() {
		return lstEncheresEnCours;
	}
	public List<Enchere> getLstParCategorie() {
		return lstParCategorie;
	}
	public List<Enchere> getLstParNomArticle() {
		return lstParNomArticle;
	}
	public String getMessage() {
		return message;
	}
	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}
	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
	public void setLstEncheresEnCours(List<Enchere> lstEncheresEnCours) {
		this.lstEncheresEnCours = lstEncheresEnCours;
	}
	public void setLstParCategorie(List<Enchere> lstParCategorie) {
		this.lstParCategorie = lstParCategorie;
	}
	public void setLstParNomArticle(List<Enchere> lstParNomArticle) {
		this.lstParNomArticle = lstParNomArticle;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
