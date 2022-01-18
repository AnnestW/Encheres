package fr.eni.ecole.encheres.bllCategorie;


import java.util.List;

import fr.eni.ecole.encheres.bllEncheres.BLLException;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dalCategorie.DAOCategorie;
import fr.eni.ecole.encheres.dalCategorie.DAOCategorieFactory;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public class CategorieManagerImpl implements CategorieManager{
	DAOCategorie dao = DAOCategorieFactory.getInstance();

	@Override
	public void insert(Categorie categorie) throws BLLException {
		try {
			dao.getAllCategories().add(categorie);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
		
	}

	@Override
	public List<Categorie> getAllCategories() throws BLLException {
		try {
			return dao.getAllCategories();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}

}
