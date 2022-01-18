package fr.eni.ecole.encheres.bllCategorie;


public class CategorieManagerSingl {

	private static CategorieManager instance;

	public static CategorieManager getInstance() {
		if (instance == null) {
			instance = new CategorieManagerImpl();

		}
		return instance;
	}

}
