package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;

public interface UtilisateurManager {

	
	public void chercherUtilisateur(String login, String motDePasse);
	
		
	
	public void selectByPseudo(String pseudo) throws DALException, BLLException;
	
	public void updatePassword(String password, String pseudo) throws DALException, BLLException ;
	
	public void insert(Utilisateur nouvelUtilisateur) throws DALException, BLLException;
	
	
}
