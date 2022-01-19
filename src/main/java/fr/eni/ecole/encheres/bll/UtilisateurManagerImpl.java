package fr.eni.ecole.encheres.bll;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.UtilisateurDAO;
import fr.eni.ecole.encheres.dal.UtilisateurDAOFactory;

public class UtilisateurManagerImpl implements UtilisateurManager {
	
	private UtilisateurDAO dao = UtilisateurDAOFactory.getInstance();

	@Override
	public void chercherUtilisateur(String login, String motDePasse) {
		
		dao.chercherUtilisateur(login, motDePasse);
		
	
	}

	@Override
	public void selectByPseudo(String pseudo) throws DALException, BLLException {
		
		dao.selectByPseudo(pseudo);
		
	}

	@Override
	public void updatePassword(String password, String pseudo) throws DALException, BLLException {
		dao.updatePassword(password, pseudo);
		
	}

	@Override
	public void insert(Utilisateur nouvelUtilisateur) throws DALException, BLLException {
		dao.insert(nouvelUtilisateur);
		
	}
	
	
	


}
