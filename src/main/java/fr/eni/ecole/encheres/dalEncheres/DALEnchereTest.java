package fr.eni.ecole.encheres.dalEncheres;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu1;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class DALEnchereTest {

	public static void main(String[] args) {
		DAOEnchere dao = DAOEnchereFactory.getInstance(); 
		Utilisateur uti = new Utilisateur();
		ArticleVendu1 art = new ArticleVendu1(1, "Skate","bien", LocalDate.now(),5, "en cours");
		ArticleVendu1 art2 = new ArticleVendu1(2, "Ballon","ballon de foot", LocalDate.now(),1, "en cours");
		
		Enchere e1 = new Enchere (art,LocalDate.now(),100, uti);
		Enchere e2 = new Enchere (art2,LocalDate.now(),5, uti);
		
		try {
			dao.insert(e1);
			dao.insert(e2);
		} catch (DALException e) {
			e.printStackTrace();
		}
	
		
		try {
			System.out.println(dao.getAll().toString());
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		try {
			dao.updateEnchere(e1, 150);
		} catch (DALException e) {
			e.printStackTrace();
		}

try {
	System.out.println(dao.getAll());
} catch (DALException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
