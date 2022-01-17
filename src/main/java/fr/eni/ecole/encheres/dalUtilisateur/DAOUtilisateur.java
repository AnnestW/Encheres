package fr.eni.ecole.encheres.dalUtilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public interface DAOUtilisateur {


	public void insert (Utilisateur utilisateur) throws DALException;
	public List<Utilisateur> getAllUtilisateurs()throws DALException;
	public Utilisateur mapUtil(ResultSet rs) throws SQLException;

}
