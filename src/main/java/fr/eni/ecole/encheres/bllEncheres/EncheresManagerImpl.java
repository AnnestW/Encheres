package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalEncheres.DALException;
import fr.eni.ecole.encheres.dalEncheres.DAOEnchere;
import fr.eni.ecole.encheres.dalEncheres.DAOEnchereFactory;

public class EncheresManagerImpl implements EncheresManager {
	DAOEnchere dao = DAOEnchereFactory.getInstance();

	// Méthode en charge de créér une nouvelle enchère sur un article mis à vendre,
	// suivant les conditions données.
	@Override
	public void encherir(ArticleVendu article, LocalDate dateEnchere, Integer montantEnchere, Utilisateur encherisseur)
			throws BLLException {

		BLLException e = new BLLException();
		if (verificationMontant(article, montantEnchere, e)) {
			createOrUpdate(article, dateEnchere, encherisseur, montantEnchere, e);
		}
	}

	void createOrUpdate(ArticleVendu article, LocalDate dateEnchere, Utilisateur encherisseur, Integer montantEnchere,
			BLLException e) throws BLLException {
		Enchere enchereExistante;
		Enchere enchere = new Enchere(article, dateEnchere, montantEnchere, encherisseur);
		try {
			enchereExistante = dao.selectByArticleEncherisseur(article, encherisseur);
		} catch (DALException e1) {
			e1.printStackTrace();
			throw new BLLException(e);
		}
		if (enchereExistante != null) {
			modifyEnchere(enchereExistante, montantEnchere);
		} else {
			try {
				dao.insert(enchere);
			} catch (DALException e1) {
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

	public boolean verificationMontant(ArticleVendu article, Integer montant_enchere, BLLException e) {
		boolean verif = true;
		if (montant_enchere <= article.getMiseAPrix()) {
			e.ajouterErreur(
					new ParameterException("Le montant de l'enchère doit être supérieur à" + article.getMiseAPrix()));
			verif = false;
		}
		return verif;
	}

	@Override
	public List<ArticleVendu> getAllEncheres() throws BLLException {
		try {
			return dao.getAllEncheres();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

	@Override
	public List<ArticleVendu> getEncheresEnCours() throws BLLException {
		try {
			return dao.getEncheresEnCours();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}


	@Override
	public List<ArticleVendu> getEnchereByFilter(String nomArticle, Integer noCategorie, Integer noEncherisseur,
			String etatVente, Integer noVendeur) throws BLLException {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try {
			liste = dao.selectByFilter(nomArticle != null ? nomArticle.toLowerCase().trim() : nomArticle, noCategorie,
					noEncherisseur, etatVente, noVendeur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
		return liste = liste.stream().distinct().collect(Collectors.toList());
	}
}
