package fr.eni.ecole.encheres.dalEncheres;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class DAOEnchereMock implements DAOEnchere {
	private List<Enchere> lstAllEncheres = new ArrayList<Enchere>();
	private Enchere enchere = null;

	@Override
	public void insert(Enchere enchere) throws DALException {
		lstAllEncheres.add(enchere);

	}

	@Override
	public void updateEnchere(Enchere enchere, Integer montant) throws DALException {
		enchere.setMontantEnchere(montant);

	}

	@Override
	public Enchere selectByArticleEncherisseur(ArticleVendu article, Utilisateur encherisseur) throws DALException {
		List<Enchere> all = getAll();
		for (Enchere enchere : all) {
			if (enchere.getArticleAVendre().getNoArticle() == article.getNoArticle()
					&& enchere.getEncherisseur().getNoUtilisateur() == encherisseur.getNoUtilisateur()) {

			}
		}
		return enchere;
	}

	@Override
	public List<Enchere> getEncheresEnCours() {
		List<Enchere> enCours = new ArrayList<Enchere>();
		List<Enchere> all;
		try {
			all = getAll();
			for (Enchere enchere : all) {
				if (enchere.getArticleAVendre().getEtatVente().equalsIgnoreCase("EnCours"))
					enCours.add(enchere);
			}

		} catch (DALException e) {
			e.printStackTrace();
		}
		return enCours;

	}

	@Override
	public List<Enchere> getAll() throws DALException {
		return lstAllEncheres;
	}
}