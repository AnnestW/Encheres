package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Retrait;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.RetraitDAO;
import fr.eni.ecole.encheres.dal.RetraitDAOFact;


public class RetraitManagerImpl implements RetraitManager {

	private static RetraitDAO dao = RetraitDAOFact.getInstance();

	@Override
	public boolean AddLieauRetrait(Retrait retrait) throws BLLException, DALException {
		if (retrait.getArticleVendu().getNoArticle() != null) {
			dao.insert(retrait);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Retrait> getAllLieauRetrait() throws BLLException, DALException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}
	
}
