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
		List<Enchere> all = getAllEncheres();
		for (Enchere enchere : all) {
			if (enchere.getArticleAVendre().getNoArticle() == article.getNoArticle()
					&& enchere.getEncherisseur().getNoUtilisateur() == encherisseur.getNoUtilisateur()) {
				return enchere;
			}
		}	
		//TODO Mettre Exception not found?
	return null;
	}

	@Override
	public List<Enchere> getEncheresEnCours() {
		List<Enchere> enCours = new ArrayList<Enchere>();
		List<Enchere> all;
		try {
			all = getAllEncheres();
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
	public List<Enchere> getAllEncheres() throws DALException {
		return lstAllEncheres;
	}

	@Override
	public  List<Enchere> selectByNomArticle(String nomArticle) throws DALException {
		List<Enchere> all = getAllEncheres();
		List<Enchere> lstByNom = new ArrayList<Enchere>();
		for (Enchere enchere : all) {
			if (enchere.getArticleAVendre().getNomArticle().equalsIgnoreCase(nomArticle)){
				lstByNom.add(enchere);
		}
		}	return lstByNom;
		
	}


	@Override
	public List<Enchere> selectByCategorie(String categorie) throws DALException {
		List<Enchere> all = getAllEncheres();
		List<Enchere> lstByCategorie = new ArrayList<Enchere>();
		for (Enchere enchere : all) {
			if (enchere.getArticleAVendre().getCategorie().getLibelle().equalsIgnoreCase(categorie)){
				lstByCategorie.add(enchere);
			}
		}return lstByCategorie;
	}
}