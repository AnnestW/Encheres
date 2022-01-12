package fr.eni.ecole.encheres.bo;

import java.time.LocalDate;

public class Enchere {
	
	
	private ArticleVendu articleAVendre;
	private LocalDate dateEnchere;
	private Integer moutantEnchere;
	private Utilisateur encherisseur;
	
	
	public Enchere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Enchere(ArticleVendu articleAVendre, LocalDate dateEnchere, Integer moutantEnchere,
			Utilisateur encherisseur) {
		super();
		this.dateEnchere = dateEnchere;
		this.moutantEnchere = moutantEnchere;
		this.articleAVendre = articleAVendre;
		this.encherisseur = encherisseur;
		
	}


	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	
	public Integer getMoutantEnchere() {
		return moutantEnchere;
	}

	public void setMoutantEnchere(Integer moutantEnchere) {
		this.moutantEnchere = moutantEnchere;
	}
	
	public ArticleVendu getArticleAVendre() {
		return articleAVendre;
	}


	public void setArticleAVendre(ArticleVendu articleAVendre) {
		this.articleAVendre = articleAVendre;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [articleVendu=");
		builder.append(articleAVendre);
		builder.append(", dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", moutantEnchere=");
		builder.append(moutantEnchere);
		builder.append(", encherisseur=");
		builder.append(encherisseur);
		builder.append("]");
		return builder.toString();
	}


	
	
	
	
	
}
