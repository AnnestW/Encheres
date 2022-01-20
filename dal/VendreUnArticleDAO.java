package fr.eni.ecole.encheres.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;




public interface VendreUnArticleDAO {

	public void insert(ArticleVendu ArticleVendu) throws DALException;
	public void update (ArticleVendu ArticleVendu) throws DALException;
	public List<ArticleVendu> getAll() throws DALException; 
	public ArticleVendu map(ResultSet rs) throws SQLException;	
		
}
