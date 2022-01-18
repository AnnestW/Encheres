package fr.eni.ecole.encheres.bllCategorie;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Exception> erreurs = new ArrayList<>();

	public BLLException() {
	}

	public BLLException(Exception e) {
		ajouterErreur(e);
	}

	public void ajouterErreur(Exception e) {
		erreurs.add(e);
	}

	public boolean hasErreur() {
		return !erreurs.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Exception exception : erreurs) {
			builder.append(exception.getMessage()).append(System.lineSeparator());
		}

		return builder.toString();
	}

}
