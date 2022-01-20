package fr.eni.ecole.encheres.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;



public class VendreUnArticleModel {

	private ArticleVendu articleVendu; 
	private Utilisateur utilisateur;
	private Categorie categorie;
	private String message ="";
	private List<ArticleVendu> listArticlesVendus = new ArrayList<>();
	private List<Categorie> lstCategories= new ArrayList<Categorie>();
	/**
	 * 
	 */
	public VendreUnArticleModel() {
	}
	/**
	 * @param articleVendu
	 * @param utilisateur
	 * @param categorie
	 * @param message
	 * @param listArticlesVendus
	 * @param lstCategories
	 */
	public VendreUnArticleModel(ArticleVendu articleVendu, Utilisateur utilisateur, Categorie categorie, String message,
			List<ArticleVendu> listArticlesVendus, List<Categorie> lstCategories) {
		super();
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.message = message;
		this.listArticlesVendus = listArticlesVendus;
		this.lstCategories = lstCategories;
	}
	/**
	 * @return the articleVendu
	 */
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	/**
	 * @param articleVendu the articleVendu to set
	 */
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the listArticlesVendus
	 */
	public List<ArticleVendu> getListArticlesVendus() {
		return listArticlesVendus;
	}
	/**
	 * @param listArticlesVendus the listArticlesVendus to set
	 */
	public void setListArticlesVendus(List<ArticleVendu> listArticlesVendus) {
		this.listArticlesVendus = listArticlesVendus;
	}
	/**
	 * @return the lstCategories
	 */
	public List<Categorie> getLstCategories() {
		return lstCategories;
	}
	/**
	 * @param lstCategories the lstCategories to set
	 */
	public void setLstCategories(List<Categorie> lstCategories) {
		this.lstCategories = lstCategories;
	}
	@Override
	public String toString() {
		return "VendreUnArticleModel [articleVendu=" + articleVendu + ", utilisateur=" + utilisateur + ", categorie="
				+ categorie + ", message=" + message + ", listArticlesVendus=" + listArticlesVendus + ", lstCategories="
				+ lstCategories + "]";
	}
	
	
	
}
