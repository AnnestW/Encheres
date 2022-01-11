package fr.eni.ecole.encheres.bo;

import java.time.LocalDate;

public class Enchere {
	private ArticleVendu1 articleAVendre;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	private Utilisateur encherisseur;

	public Enchere() {

	}

	public Enchere(ArticleVendu1 articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
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

	public ArticleVendu1 getArticleAVendre() {
		return articleAVendre;
	}

	public void setArticleAVendre(ArticleVendu1 articleAVendre) {
		this.articleAVendre = articleAVendre;
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
