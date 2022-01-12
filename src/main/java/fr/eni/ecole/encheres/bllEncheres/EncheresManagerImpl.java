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

public class EncheresManagerImpl implements EncheresManager{
	DAOEnchere dao = DAOEnchereFactory.getInstance();

	//Méthode en charge de créér une nouvelle enchère sur un article mis à vendre, suivant les conditions données.
	@Override
	public void nouvelleEnchere(ArticleVendu article, LocalDate dateEnchere, Integer montantEnchere,
			Utilisateur encherisseur) throws BLLException {
		Enchere enchere = new Enchere (article, dateEnchere, montantEnchere, encherisseur);
		
		BLLException e = new BLLException();
		
		verificationEtatVente(article, e);
		verificationPremiereEnchere(article, encherisseur, montantEnchere, e);
		verificationMontant(article, montantEnchere, e);
		verificationDate(article, dateEnchere, e);
		verificationNow(dateEnchere, e);
	
		if (e.hasErreur()) {
			throw e;
		}
		try {
			dao.insert(enchere);
		} catch (DALException e1) {
			e1.printStackTrace();
			throw new BLLException(e);
		}
	}

	public void verificationNow(LocalDate dateEnchere, BLLException e) {
		if (!dateEnchere.equals(LocalDate.now())) {
			e.ajouterErreur(new ParameterException("La date de l'enchère doit être aujourd'hui"));
		}
	}

	public void verificationPremiereEnchere(ArticleVendu article, Utilisateur encherisseur, Integer montantEnchere, BLLException e) throws BLLException{
			Enchere enchereExistante;
			try {
				enchereExistante = dao.selectByArticleEncherisseur(article, encherisseur);
			} catch (DALException e1) {
				e1.printStackTrace();
				throw new BLLException(e);
			}
				if (enchereExistante.getArticleAVendre().getNoArticle()==article.getNoArticle()&& enchereExistante.getEncherisseur().getNoUtilisateur() == encherisseur.getNoUtilisateur()) {
					modifyEnchere(enchereExistante, montantEnchere);
				}
			}
		

	public void modifyEnchere(Enchere enchere, Integer montantEnchere) {
		enchere.setMontantEnchere(montantEnchere);
		
	}

	

	//Méthode en charge d'afficher un message d'erreur si l'utilisateur choisit une date qui est avant/après la période de l'enchère
	public void verificationDate(ArticleVendu article, LocalDate dateEnchere, BLLException e) {
		if (dateEnchere.isBefore(article.getDateDebutEncheres()) || dateEnchere.isAfter(article.getDateFinEncheres())) {
			e.ajouterErreur(new ParameterException("La date de l'enchère ne peut pas être avant le début de l'enchère ni après la fin de l'enchère"));
		}
		}
		
	

	public void verificationMontant(ArticleVendu article, Integer montant_enchere, BLLException e) {
		if (montant_enchere <= article.getMiseAPrix()) {
			e.ajouterErreur(new ParameterException("Le montant de l'enchère doit être supérieur à" + article.getMiseAPrix()));
		}
	}

	public void verificationEtatVente(ArticleVendu article, BLLException e) {
		if (!"enCours".equals(article.getEtatVente())) {
			e.ajouterErreur(new ParameterException("Cet article n'est pas à vendre"));
			
		}
		
	}


	

	@Override
	public List<Enchere> getAll() throws DALException, BLLException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public List<Enchere> getEncheresEnCours() throws BLLException {
		return dao.getEncheresEnCours();
	}


//	@Override
//	public Enchere afficherEnchere(Enchere enchere) {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
