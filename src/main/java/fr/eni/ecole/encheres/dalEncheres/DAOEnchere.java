package fr.eni.ecole.encheres.dalEncheres;

import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;


public interface DAOEnchere {

	public void insert (Enchere enchere) throws DALException;
	public List<Enchere> getEncheresEnCours();
	public List<Enchere> getAll() throws DALException;
	public Enchere selectByArticleEncherisseur(ArticleVendu article, Utilisateur encherisseur) throws DALException;
	public void updateEnchere(Enchere enchere, Integer montant) throws DALException;

}
