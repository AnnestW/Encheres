package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.VendreUnArticleDAO;
import fr.eni.ecole.encheres.dal.VendreUnArticleDAOFact;

public class VendreUnArticleManagerImpl implements VendreUnArticleManager {

	private static VendreUnArticleDAO dao = VendreUnArticleDAOFact.getInstance();

	@Override
	public boolean AddArticle(ArticleVendu articleVendu) throws BLLException, DALException {
		if (articleVendu.getNomArticle() != null) {
			dao.insert(articleVendu);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ArticleVendu> getAllArticleVendu() throws BLLException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e);
		}
	}
	
	
	
}

