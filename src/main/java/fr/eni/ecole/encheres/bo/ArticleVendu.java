package fr.eni.ecole.encheres.bo;

import java.time.LocalDate;

public class ArticleVendu {
	
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	private Categorie categorie;
	private Retrait lieuRetrait;
	private Utilisateur utilisateur;
	
	public ArticleVendu() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente,
			Categorie categorieArticle, Retrait lieuRetrait, Utilisateur encherisseur) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorieArticle = categorieArticle;
		this.lieuRetrait = lieuRetrait;
		this.encherisseur = encherisseur;
	}

	

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente, Categorie categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
	}

	public Integer getNoArticle() {
		return noArticle;
	}
	


	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente, Categorie categorie,
			Utilisateur utilisateur) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}


	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}


	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}


	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}


	public Integer getMiseAPrix() {
		return miseAPrix;
	}


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


	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n Nom =");
		builder.append(nomArticle);
		builder.append("\n description=");
		builder.append(description);
		builder.append("\n dateDebutEncheres=");
		builder.append(dateDebutEncheres);
		builder.append("\n dateFinEncheres=");
		builder.append(dateFinEncheres);
		builder.append("\n miseAPrix=");
		builder.append(miseAPrix);
		builder.append("prixVente=");
		builder.append(prixVente);
		builder.append("etatVente=");
		builder.append(etatVente);
		builder.append(", categorie=");
		builder.append(categorie.getLibelle());
		return builder.toString();
	}


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
	
	
	

}
