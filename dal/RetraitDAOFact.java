package fr.eni.ecole.encheres.dal;

public class RetraitDAOFact {

	public static RetraitDAO getInstance() {
		return new RetraitDAOImpl();   
	}
}
