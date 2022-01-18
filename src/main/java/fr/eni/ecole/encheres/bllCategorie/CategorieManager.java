package fr.eni.ecole.encheres.bllCategorie;


import java.util.List;

import fr.eni.ecole.encheres.bllEncheres.BLLException;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;


public interface CategorieManager {


	public void insert (Categorie categorie) throws BLLException;
	public List<Categorie> getAllCategories() throws BLLException;
	
	

}
