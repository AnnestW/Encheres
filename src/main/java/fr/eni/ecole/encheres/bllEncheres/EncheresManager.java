package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu1;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;

public interface EncheresManager {
	public void nouvelleEnchere(ArticleVendu1 article, Utilisateur encherisseur, Integer montant_enchere, LocalDate dateEnchere);
	public void modifyEnchere(Enchere enchere, Utilisateur encherisseur);
	public List <Enchere> getAllEncheres();
	public Enchere afficherEnchere(Enchere enchere);
	//TODO tri par categories
	//public List <Enchere> triParCategories();
	
	

}
