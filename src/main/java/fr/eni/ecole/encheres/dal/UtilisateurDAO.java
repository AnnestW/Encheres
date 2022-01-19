package fr.eni.ecole.encheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	
	public Utilisateur chercherUtilisateur(String login, String motDePasse) throws DALException;
		
	
	public Utilisateur selectByPseudo(String pseudo) throws DALException;
	
	public void updatePassword(String password, String pseudo) throws DALException;
	
	public void insert(Utilisateur nouvelUtilisateur) throws DALException;
	
}