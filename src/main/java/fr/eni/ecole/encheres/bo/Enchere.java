package fr.eni.ecole.encheres.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Enchere {
<<<<<<< HEAD
	private Integer noEnchere;
=======
	
	
>>>>>>> Binh
	private ArticleVendu articleAVendre;
	private LocalDate dateEnchere;
	private Integer moutantEnchere;
	private Utilisateur encherisseur;
<<<<<<< HEAD


=======
	
>>>>>>> Binh
	
	public Enchere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
<<<<<<< HEAD

	public Enchere(Integer noEnchere, ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur) {
		this.noEnchere = noEnchere;
		this.articleAVendre = articleAVendre;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
	}


	public Enchere(ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
=======
	public Enchere(ArticleVendu articleAVendre, LocalDate dateEnchere, Integer moutantEnchere,
>>>>>>> Binh
			Utilisateur encherisseur) {
		super();
		this.dateEnchere = dateEnchere;
		this.moutantEnchere = moutantEnchere;
		this.articleAVendre = articleAVendre;
		this.encherisseur = encherisseur;
		
	}

<<<<<<< HEAD
	
//
//	public Enchere(Integer noEnchere, ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
//			Utilisateur encherisseur) {
//		this(articleAVendre, dateEnchere, montantEnchere, encherisseur);
//		this.noE
//	}
=======
>>>>>>> Binh

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


<<<<<<< HEAD
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
=======
>>>>>>> Binh


	@Override
	public String toString() {
<<<<<<< HEAD
		return articleAVendre.getNomArticle() + "\n" +" Prix ="
				+ montantEnchere + "\n Vendeur : " + articleAVendre.getUtilisateur().getPseudo() + "\n" ;
	}


=======
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


	
	
	
	
	
>>>>>>> Binh
}
