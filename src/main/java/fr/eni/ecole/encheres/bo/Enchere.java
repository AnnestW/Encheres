package fr.eni.ecole.encheres.bo;

import java.time.LocalDate;

public class Enchere {
<<<<<<< HEAD
	
	
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
=======
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

	
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15

	
	public Integer getMoutantEnchere() {
		return moutantEnchere;
	}

<<<<<<< HEAD
	public void setMoutantEnchere(Integer moutantEnchere) {
		this.moutantEnchere = moutantEnchere;
	}
	
	public ArticleVendu getArticleAVendre() {
		return articleAVendre;
	}


	public void setArticleAVendre(ArticleVendu articleAVendre) {
		this.articleAVendre = articleAVendre;
=======
	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
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
<<<<<<< HEAD
		builder.append("Enchere [articleVendu=");
		builder.append(articleAVendre);
		builder.append(", dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", moutantEnchere=");
		builder.append(moutantEnchere);
		builder.append(", encherisseur=");
=======
		builder.append("Enchere [articleAVendre=");
		builder.append(articleAVendre);
		builder.append(", dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montantEnchere=");
		builder.append(montantEnchere);
		builder.append(", utilisateur=");
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
		builder.append(encherisseur);
		builder.append("]");
		return builder.toString();
	}

<<<<<<< HEAD

	
	
	
	
	
=======
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
}
