package fr.eni.ecole.encheres.bo;

import java.time.LocalDate;

public class ArticleVendu {
<<<<<<< HEAD
	
=======
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
<<<<<<< HEAD
	private Categorie categorieArticle;
	private Retrait lieuRetrait;
	private Utilisateur encherisseur;
	
	
	public ArticleVendu() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente,
			Categorie categorieArticle, Retrait lieuRetrait, Utilisateur encherisseur) {
		super();
=======
	private Categorie categorie;
	
	public ArticleVendu() {
		
	}
	
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			Integer miseAPrix, String etatVente) {
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
<<<<<<< HEAD
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorieArticle = categorieArticle;
		this.lieuRetrait = lieuRetrait;
		this.encherisseur = encherisseur;
	}


	public Integer getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}


	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

=======
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
	}


	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres, Integer miseAPrix, String etatVente,
			LocalDate dateFinEncheres) {
		this(noArticle, nomArticle, description,dateDebutEncheres, miseAPrix,etatVente);
		this.dateFinEncheres = dateFinEncheres;
		
	}

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			Integer miseAPrix, Integer prixVente, String etatVente, LocalDate dateFinEncheres) {
		this(noArticle, nomArticle, description,dateDebutEncheres, miseAPrix,etatVente);
		this.prixVente = prixVente;
		this.dateFinEncheres = dateFinEncheres;
	}
	

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			Integer miseAPrix, Integer prixVente, String etatVente, LocalDate dateFinEncheres, Categorie categorie) {
		this(noArticle, nomArticle, description,dateDebutEncheres, miseAPrix,prixVente, etatVente,dateFinEncheres);
		this.categorie = categorie;
	}
	
	
	
	
	
	

	public Categorie getCategorie() {
		return categorie;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15

	public String getDescription() {
		return description;
	}

<<<<<<< HEAD

	public void setDescription(String description) {
		this.description = description;
	}


=======
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

<<<<<<< HEAD

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}


=======
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

<<<<<<< HEAD

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}


=======
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
	public Integer getMiseAPrix() {
		return miseAPrix;
	}

<<<<<<< HEAD

	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}


	public Integer getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}


	public String getEtatVente() {
		return etatVente;
	}

=======
	public Integer getPrixVente() {
		return prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

<<<<<<< HEAD

=======
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [noArticle=");
		builder.append(noArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEncheres=");
		builder.append(dateDebutEncheres);
		builder.append(", dateFinEncheres=");
		builder.append(dateFinEncheres);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", etatVente=");
		builder.append(etatVente);
<<<<<<< HEAD
=======
		builder.append(", categorie=");
		builder.append(categorie);
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
		builder.append("]");
		return builder.toString();
	}


<<<<<<< HEAD
	public Categorie getCategorieArticle() {
		return categorieArticle;
	}


	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}


	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}


	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}


	public Utilisateur getEncherisseur() {
		return encherisseur;
	}


	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}
	
	
	

=======

	
	
>>>>>>> fba300d629b2f1a636914088b0d046c38ac1ae15
}
