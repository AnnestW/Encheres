package fr.eni.ecole.encheres.bo;

import java.time.LocalDate;

public class ArticleVendu {
    private String noArticle;
    private String nomArticle;
    private String description;
    private LocalDate dateDebutEncheres;
    private LocalDate dateFinEncheres;
    private Integer miseAPrix;
    private double prixVente;
    private String etatVente;
    /**
     * 
     */
    public ArticleVendu() {
    }
    /**
     * @param noArticle
     * @param nomArticle
     * @param description
     * @param dateDebutEncheres
     * @param dateFinEncheres
     * @param miseAPrix
     * @param prixVente
     * @param etatVente
     */
    public ArticleVendu(String noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
            LocalDate dateFinEncheres, Integer miseAPrix, double prixVente, String etatVente) {
        super();
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.etatVente = etatVente;
    }
    /**
     * @return the noArticle
     */
    public String getNoArticle() {
        return noArticle;
    }
    /**
     * @param noArticle the noArticle to set
     */
    public void setNoArticle(String noArticle) {
        this.noArticle = noArticle;
    }
    /**
     * @return the nomArticle
     */
    public String getNomArticle() {
        return nomArticle;
    }
    /**
     * @param nomArticle the nomArticle to set
     */
    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the dateDebutEncheres
     */
    public LocalDate getDateDebutEncheres() {
        return dateDebutEncheres;
    }
    /**
     * @param dateDebutEncheres the dateDebutEncheres to set
     */
    public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
        this.dateDebutEncheres = dateDebutEncheres;
    }
    /**
     * @return the dateFinEncheres
     */
    public LocalDate getDateFinEncheres() {
        return dateFinEncheres;
    }
    /**
     * @param dateFinEncheres the dateFinEncheres to set
     */
    public void setDateFinEncheres(LocalDate dateFinEncheres) {
        this.dateFinEncheres = dateFinEncheres;
    }
    /**
     * @return the miseAPrix
     */
    public Integer getMiseAPrix() {
        return miseAPrix;
    }
    /**
     * @param miseAPrix the miseAPrix to set
     */
    public void setMiseAPrix(Integer miseAPrix) {
        this.miseAPrix = miseAPrix;
    }
    /**
     * @return the prixVente
     */
    public double getPrixVente() {
        return prixVente;
    }
    /**
     * @param prixVente the prixVente to set
     */
    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }
    /**
     * @return the etatVente
     */
    public String getEtatVente() {
        return etatVente;
    }
    /**
     * @param etatVente the etatVente to set
     */
    public void setEtatVente(String etatVente) {
        this.etatVente = etatVente;
    }
    @Override
    public String toString() {
        return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
                + ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
                + miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + "]";
    }
}





