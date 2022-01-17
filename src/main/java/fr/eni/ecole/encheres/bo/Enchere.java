package fr.eni.ecole.encheres.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Enchere {
	private Integer noEnchere;
	private ArticleVendu articleAVendre;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	private Utilisateur encherisseur;


	
	public Enchere() {

	}
	
	

	public Enchere(Integer noEnchere, ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur) {
		this.noEnchere = noEnchere;
		this.articleAVendre = articleAVendre;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
	}



	public Enchere(ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur) {
		this.articleAVendre = articleAVendre;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
	}

	
//
//	public Enchere(Integer noEnchere, ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
//			Utilisateur encherisseur) {
//		this(articleAVendre, dateEnchere, montantEnchere, encherisseur);
//		this.noE
//	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public ArticleVendu getArticleAVendre() {
		return articleAVendre;
	}

	public void setArticleAVendre(ArticleVendu articleAVendre) {
		this.articleAVendre = articleAVendre;
	}
	
	

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}
	
	public Integer getNoArticle() {
		return articleAVendre.getNoArticle();
	}

	public Integer getNoUtil() {
		return encherisseur.getNoUtilisateur();
	}
	
	

	public Integer getNoEnchere() {
		return noEnchere;
	}



	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}


	@Override
	public String toString() {
		return articleAVendre.getNomArticle() + "\n" +" Prix ="
				+ montantEnchere + "\n Vendeur : " + articleAVendre.getUtilisateur().getPseudo() + "\n" ;
	}


}
