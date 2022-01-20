package fr.eni.ecole.encheres.dalEncheres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;


public interface DAOEnchere {

	public void insert(Enchere enchere) throws DALException;
	public List<ArticleVendu> getEncheresEnCours() throws DALException;
	public List<ArticleVendu> getAllEncheres() throws DALException;
	public void updateEnchere(Enchere enchere, Integer montant) throws DALException;
//	public List<Enchere> selectByNomArticle(String nomArticle) throws DALException;
//	public List<Enchere> selectByCategorie(Integer noCategorie) throws DALException;
//	public List<Enchere> selectByEncherisseur(Integer noUtilisateur)throws DALException;
//	public List<Enchere> selectByEtatVente(String etatVente)throws DALException;
//	public List<Enchere> selectByVendeur(Integer noUtilisateur)throws DALException;
	public List <ArticleVendu> selectByFilter(String nomArticle, Integer noCategorie, Integer noEncherisseur, String etatVente, Integer noVendeur)throws DALException;
	Enchere selectByArticleEncherisseur(ArticleVendu article, Utilisateur encherisseur) throws DALException;
	Utilisateur mapUtil(ResultSet rs) throws SQLException;

}
