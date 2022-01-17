package fr.eni.ecole.encheres.dalEncheres;

public class DAOEnchereFactory {
 public static DAOEnchere getInstance() {
	 return new DAOEncheresImpl();
 }
}
