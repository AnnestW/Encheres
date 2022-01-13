package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalEncheres.DALException;
import fr.eni.ecole.encheres.dalEncheres.DAOEnchere;
import fr.eni.ecole.encheres.dalEncheres.DAOEnchereFactory;

public class EncheresManagerImpl implements EncheresManager {
	DAOEnchere dao = DAOEnchereFactory.getInstance();

	// M�thode en charge de cr��r une nouvelle ench�re sur un article mis � vendre,
	// suivant les conditions donn�es.
	@Override
	public void encherir(ArticleVendu article, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur) throws BLLException {
		
		BLLException e = new BLLException();
		if (verificationMontant(article, montantEnchere, e)) {
			createOrUpdate(article, dateEnchere,encherisseur, montantEnchere, e);
		}
	}

//	
//
//	public void verificationNow(LocalDate dateEnchere, BLLException e) {
//		if (!dateEnchere.equals(LocalDate.now())) {
//			e.ajouterErreur(new ParameterException("La date de l'ench�re doit �tre aujourd'hui"));
//		}
//	}

	 void createOrUpdate(ArticleVendu article, LocalDate dateEnchere, Utilisateur encherisseur, Integer montantEnchere, BLLException e) throws BLLException{
			Enchere enchereExistante;
			Enchere enchere = new Enchere (article, dateEnchere, montantEnchere, encherisseur);
			try {
				enchereExistante = dao.selectByArticleEncherisseur(article, encherisseur);
			} catch (DALException e1) {
				e1.printStackTrace();
				throw new BLLException(e);
			}
				if (enchereExistante!=null) {
					modifyEnchere(enchereExistante, montantEnchere);
				} else {
						try {
							dao.insert(enchere);
						} catch (DALException e1){
							e1.printStackTrace();
							throw new BLLException(e);
						}
					} 
			}

	public void modifyEnchere(Enchere enchere, Integer montantEnchere) {
		enchere.setMontantEnchere(montantEnchere);
		try {
			dao.updateEnchere(enchere, montantEnchere);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

//	//M�thode en charge d'afficher un message d'erreur si l'utilisateur choisit une date qui est avant/apr�s la p�riode de l'ench�re
//	public void verificationDate(ArticleVendu article, LocalDate dateEnchere, BLLException e) {
//		if (dateEnchere.isBefore(article.getDateDebutEncheres()) || dateEnchere.isAfter(article.getDateFinEncheres())) {
//			e.ajouterErreur(new ParameterException("La date de l'ench�re ne peut pas �tre avant le d�but de l'ench�re ni apr�s la fin de l'ench�re"));
//		}
//		}

	public boolean verificationMontant(ArticleVendu article, Integer montant_enchere, BLLException e) {
		boolean verif = true;
		if (montant_enchere <= article.getMiseAPrix()) {
			e.ajouterErreur(
					new ParameterException("Le montant de l'ench�re doit �tre sup�rieur �" + article.getMiseAPrix()));
			verif = false;
		}
		return verif;
	}

//	public void verificationEtatVente(ArticleVendu article, BLLException e) {
//		if (!"enCours".equals(article.getEtatVente())) {
//			e.ajouterErreur(new ParameterException("Cet article n'est pas � vendre"));
//			
//		}
//		
//	}

	@Override
	public List<Enchere> getAllEncheres() throws BLLException {
		try {
			return dao.getAllEncheres();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public List<Enchere> getEncheresEnCours() throws BLLException {
		try {
		return dao.getEncheresEnCours();
		}catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public List<Enchere> selectByNomArticle(String nomArticle)throws BLLException{
		try {
			return dao.selectByNomArticle(nomArticle);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public List<Enchere> selectByCategorie(String categorie)throws BLLException {
		try {
			return dao.selectByCategorie(categorie);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	

}

