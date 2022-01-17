package fr.eni.ecole.encheres.dal;

public class UtilisateurDAOFactory {
	
	public static UtilisateurDAO getInstance() {
		
		return new UtilisateurDAOImpl();
		
		
	}

}
