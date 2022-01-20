package fr.eni.ecole.encheres.bll;

public class Test {

	public static void main(String[] args) throws BLLException {
		UtilisateurManager mgr = UtilisateurManagerSingleton.getInstance();
		
		System.out.println(mgr.chercherUtilisateur("pseudo", "xxxx"));

	}

}
