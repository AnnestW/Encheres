package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;


public interface EncheresManager {
	public void encherir(ArticleVendu articleAVendre, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur)throws BLLException;
	public void modifyEnchere(Enchere enchere, Integer montantEnchere);
	public List<ArticleVendu> getEncheresEnCours() throws BLLException;
	public List <ArticleVendu> getAllEncheres()throws BLLException ;
//	public List <Enchere> selectByNomArticle(String nomArticle) throws BLLException;
//	public List <Enchere> selectByCategorie(Integer noCategorie)throws BLLException;
//	public List <Enchere> selectByEncherisseur(Integer noUtilisateur)throws BLLException;
//	public List<ArticleVendu> getEncheresRemportees(String etatVente) throws BLLException;
//	public List<Enchere> getEncheresByVendeur(Integer noUtilisateur, String etatVente) throws BLLException;
	public List<ArticleVendu> getEnchereByFilter(String nomArticle, Integer noCategorie, Integer noEncherisseur, String etatVente, Integer noVendeur)throws BLLException;
	}
	
	


