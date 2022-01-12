package fr.eni.ecole.encheres.bll;

public class UtilisateurManagerSingleton {
	
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManagerImpl();
		}
		return instance;
	}
}
