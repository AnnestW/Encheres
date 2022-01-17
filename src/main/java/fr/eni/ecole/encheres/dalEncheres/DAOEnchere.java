package fr.eni.ecole.encheres.dalEncheres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;


public interface DAOEnchere {

	public void insert(Enchere enchere) throws DALException;
	public List<Enchere> getEncheresEnCours() throws DALException;
	public List<Enchere> getAllEncheres() throws DALException;
	public Enchere selectByArticleEncherisseur(ArticleVendu article, Utilisateur encherisseur) throws DALException;
	public void updateEnchere(Enchere enchere, Integer montant) throws DALException;
	public List<Enchere> selectByNomArticle(String nomArticle) throws DALException;
	public List<Enchere> selectByCategorie(Integer noCategorie) throws DALException;
	//public List<Enchere> selectByNomArticleCategorie(String nomArticle) throws DALException;
	Utilisateur mapUtil(ResultSet rs) throws SQLException;
	public List<Enchere> selectByUtilisateur(Integer noUtilisateur)throws DALException;

}
