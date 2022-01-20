package fr.eni.ecole.encheres.bll;

import java.util.List;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.dal.DALException;


public interface VendreUnArticleManager {
	
	public boolean AddArticle(ArticleVendu articleVendu)throws BLLException, DALException;
	public List<ArticleVendu> getAllArticleVendu() throws BLLException, DALException;
}
