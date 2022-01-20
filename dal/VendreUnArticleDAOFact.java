package fr.eni.ecole.encheres.dal;

public class VendreUnArticleDAOFact {
	
	public static VendreUnArticleDAO getInstance() {
		return new VendreUnArticleDAOImpl();   
	}

}
