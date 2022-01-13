package fr.eni.ecole.encheres.bllEncheres;



public class EncheresSingl {
	private static EncheresManager instance;

	public static EncheresManager getInstance() {
		if (instance == null) {
			instance = new EncheresManagerImpl();

		}
		return instance;
	}
}
