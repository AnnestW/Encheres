package fr.eni.ecole.encheres.bll;

public class VendreUnArticleSing {
	
	private static VendreUnArticleManager instance;
	
	
	public 	static VendreUnArticleManager getInstance() {
		if (instance == null) {
			instance = new VendreUnArticleManagerImpl();
		}
		return instance;
	}

}
