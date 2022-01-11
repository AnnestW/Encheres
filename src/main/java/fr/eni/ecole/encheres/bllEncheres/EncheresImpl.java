package fr.eni.ecole.encheres.bllEncheres;

import java.time.LocalDate;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu1;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class EncheresImpl implements EncheresManager{

	@Override
	public void nouvelleEnchere(ArticleVendu1 article, Utilisateur encherisseur, Integer montant_enchere,
			LocalDate dateEnchere) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyEnchere(Enchere enchere, Utilisateur encherisseur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> getAllEncheres() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere afficherEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		return null;
	}

}
