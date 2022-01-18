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
	private Utilisateur utilisateur;
	
	public ArticleVendu() {
		
	}
	
	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			Integer miseAPrix, String etatVente) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
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

	public String getDescription() {
		return description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public Integer getMiseAPrix() {
		return miseAPrix;
	}

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



	
	
}
