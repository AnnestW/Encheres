package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public interface EncheresManager {
	public void nouvelleEnchere(ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur)throws BLLException;
	public void modifyEnchere(Enchere enchere, Integer montantEnchere);
	public List<Enchere> getEncheresEnCours() throws BLLException;
	public List <Enchere> getAll()throws DALException, BLLException ;
	//public Enchere afficherEnchere(Enchere enchere);
	//TODO tri par categories
	//public List <Enchere> triParCategories();
	
	

}
