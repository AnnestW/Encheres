package fr.eni.ecole.encheres.dalCategorie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public interface DAOCategorie {


	public void insert (Categorie categorie) throws DALException;
	public List<Categorie> getAllCategories()throws DALException;
	public Categorie mapCateg(ResultSet rs) throws SQLException;
	

}
