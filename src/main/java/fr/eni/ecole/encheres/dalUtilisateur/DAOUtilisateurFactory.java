package fr.eni.ecole.encheres.dalUtilisateur;

public class DAOUtilisateurFactory {
	public static DAOUtilisateur getInstance() {
		return new DAOUtilisateurImpl();
	}
	

}
