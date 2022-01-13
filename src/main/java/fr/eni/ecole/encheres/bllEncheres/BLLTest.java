package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public class BLLTest {

	public static void main(String[] args) throws DALException, BLLException {
		EncheresManager mgr = EncheresSingl.getInstance();
		
		
		Utilisateur uti = new Utilisateur();
		Utilisateur uti2 = new Utilisateur();
		ArticleVendu art = new ArticleVendu(1, "Skate","bien", LocalDate.parse("12/12/2021",DateTimeFormatter.ofPattern("dd/MM/yyyy")),5, "enCours", LocalDate.parse("02/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		ArticleVendu art2 = new ArticleVendu(2, "Ballon","ballon de foot", LocalDate.parse("12/10/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),1, "enCours", LocalDate.parse("22/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		
		
		mgr.encherir(art,LocalDate.now(),100, uti);
		mgr.encherir(art,LocalDate.now(),50, uti);
		
		
		System.out.println(mgr.getEncheresEnCours().toString());

	}

}
