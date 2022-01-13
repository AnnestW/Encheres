package fr.eni.ecole.encheres.dalCategorie;



public class DAOCategorieFactory {

 public static DAOCategorie getInstance() {
	 return new DAOCategorieImpl();
 }
}



