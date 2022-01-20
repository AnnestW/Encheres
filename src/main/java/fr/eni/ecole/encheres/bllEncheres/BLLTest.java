package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.UtilisateurDAO;
import fr.eni.ecole.encheres.dal.UtilisateurDAOFactory;
import fr.eni.ecole.encheres.dalEncheres.DALException;


public class BLLTest {

	public static void main(String[] args) throws DALException, BLLException {
		EncheresManager mgr = EncheresSingl.getInstance();
		UtilisateurDAO daoU = UtilisateurDAOFactory.getInstance();
		
	
		
		
		Utilisateur uti = new Utilisateur(1, "vendredi", "Lebihan", "Morgane",  "jaiune@adresse.com",  "0123456789",
				 "Todo Directo",  "12345", "Madrid", "ooooo", 250, false );
		Utilisateur uti2 = new Utilisateur(2, "melyn", "Lebihan", "Samuel",  "oooo@adresse.com",  "0123456789",
				 "Todo Directo",  "12345", "Madrid", "iiiii", 250, false );
		ArticleVendu art = new ArticleVendu(4, "Diablo","bien", LocalDate.parse("12/12/2021",DateTimeFormatter.ofPattern("dd/MM/yyyy")),5, "enCours", LocalDate.parse("02/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		ArticleVendu art2 = new ArticleVendu(4, "balle","balle de billard", LocalDate.parse("12/10/2021", DateTimeFormatter.ofPattern("dd/MM/yyyy")),1, "enCours", LocalDate.parse("22/02/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		
		//test creation ou modification d'une enchère en fonction de si elle existe déjà ou pas
		mgr.encherir(art,LocalDate.now(),100, uti);
		mgr.encherir(art2,LocalDate.now(),50, uti2);
		 //System.out.println(daoU.getAllUtilisateurs());
		
		// System.out.println(mgr.selectByCategorie(3));
		 
		//System.out.println(mgr.selectByNomArticle("skate"));
		
		//System.out.println(mgr.getEnchereByFilter(null, null));
		System.out.println(mgr.getEnchereByFilter(null, null, null, "Termine", 1));
	}

}
