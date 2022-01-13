package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalEncheres.DALException;
import fr.eni.ecole.encheres.dalUtilisateur.DAOUtilisateur;
import fr.eni.ecole.encheres.dalUtilisateur.DAOUtilisateurFactory;

public class BLLTest {

	public static void main(String[] args) throws DALException, BLLException {
		EncheresManager mgr = EncheresSingl.getInstance();
		DAOUtilisateur daoU = DAOUtilisateurFactory.getInstance();
		
	
		
		
		Utilisateur uti = new Utilisateur(1, "vendredi", "Lebihan", "Morgane",  "jaiune@adresse.com",  "0123456789",
				 "Todo Directo",  "12345", "Madrid", "ooooo", 250, false );
		Utilisateur uti2 = new Utilisateur(2, "melyn", "Lebihan", "Samuel",  "oooo@adresse.com",  "0123456789",
				 "Todo Directo",  "12345", "Madrid", "iiiii", 250, false );
		ArticleVendu art = new ArticleVendu(2, "Skate","bien", LocalDate.parse("12/12/2021",DateTimeFormatter.ofPattern("dd/MM/yyyy")),5, "enCours", LocalDate.parse("02/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		ArticleVendu art2 = new ArticleVendu(3, "Ballon","ballon de foot", LocalDate.parse("12/10/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),1, "enCours", LocalDate.parse("22/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		
		
		mgr.encherir(art,LocalDate.now(),100, uti);
		mgr.encherir(art,LocalDate.now(),50, uti2);
		 System.out.println(daoU.getAllUtilisateurs());
		
		System.out.println(mgr.getEncheresEnCours().toString());

	}

}
