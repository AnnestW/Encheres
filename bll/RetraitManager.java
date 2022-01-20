package fr.eni.ecole.encheres.bll;

import java.util.List;
import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.DALException;


public interface RetraitManager {
	
	public boolean AddLieauRetrait(Retrait LieauRetrait)throws BLLException, DALException;
	public List<Retrait> getAllLieauRetrait() throws BLLException, DALException;
	

}
