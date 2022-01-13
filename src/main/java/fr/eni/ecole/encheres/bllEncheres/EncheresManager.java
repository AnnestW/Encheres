package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public interface EncheresManager {
	public void encherir(ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur)throws BLLException;
	public void modifyEnchere(Enchere enchere, Integer montantEnchere);
	public List<Enchere> getEncheresEnCours() throws BLLException;
	public List <Enchere> getAllEncheres()throws DALException, BLLException ;
	public List <Enchere> selectByNomArticle(String nomArticle) throws BLLException;
	public List <Enchere> selectByCategorie(String categorie)throws BLLException;
	
	
	

}
