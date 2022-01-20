package fr.eni.ecole.encheres.bll;



public class RetraitSingl {
	private static RetraitManager instance;

	public static RetraitManager getInstance() {
		if (instance == null) {
			instance = new RetraitManagerImpl();

		}
		return instance;
	}
}
