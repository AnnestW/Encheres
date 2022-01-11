package fr.eni.ecole.encheres.dalEncheres;

import java.util.ArrayList;
import java.util.List;


import fr.eni.ecole.encheres.bo.Enchere;

public class DAOEnchereMock implements DAOEnchere {
	private List <Enchere> lstEncheres = new ArrayList<Enchere>();
	private Enchere enchere = null;

	@Override
	public void insert(Enchere enchere) throws DALException {
		lstEncheres.add(enchere);
		
	}

	@Override
	public List<Enchere> getAll() throws DALException {
		return lstEncheres;
	}

	@Override
	public void updateEnchere(Enchere enchere, Integer montant) throws DALException {
		enchere.setMontantEnchere(montant);
		
	}



}
