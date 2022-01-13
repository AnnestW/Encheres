package fr.eni.ecole.encheres.dalCategorie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public interface DAOCategorie {


	public void insert (Categorie categorie) throws DALException, SQLException;
	public List<Categorie> getAllCategories()throws DALException, SQLException;
	public Categorie mapCateg(ResultSet rs) throws SQLException;
	

}
