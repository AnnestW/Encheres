package fr.eni.ecole.encheres.dalEncheres;

import java.util.List;

import fr.eni.ecole.encheres.bo.Enchere;


public interface DAOEnchere {

	public void insert (Enchere enchere) throws DALException;
	public List<Enchere> getAll() throws DALException;
	//public Enchere selectByIdArticle(Integer noArticle) throws DALException;
	public void updateEnchere(Enchere enchere, Integer montant) throws DALException;

}
