package fr.eni.ecole.encheres.bo;

import java.time.LocalDate;

public class Enchere {
	private ArticleVendu articleAVendre;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	private Utilisateur encherisseur;

	public Enchere() {

	}

	public Enchere(ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur) {
		this.articleAVendre = articleAVendre;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
	}

	

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [articleAVendre=");
		builder.append(articleAVendre);
		builder.append(", dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montantEnchere=");
		builder.append(montantEnchere);
		builder.append(", utilisateur=");
		builder.append(encherisseur);
		builder.append("]");
		return builder.toString();
	}

}
