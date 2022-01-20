package fr.eni.ecole.encheres.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.Retrait;


public class RetraitModel {

	private Retrait retrait; 
	private String message ="";
	private List<Retrait> listRetrait = new ArrayList<>();
	/**
	 * 
	 */
	public RetraitModel() {
		super();
	}
	/**
	 * @param retrait
	 * @param message
	 * @param listRetrait
	 */
	public RetraitModel(Retrait retrait, String message, List<Retrait> listRetrait) {
		super();
		this.retrait = retrait;
		this.message = message;
		this.listRetrait = listRetrait;
	}
	/**
	 * @return the retrait
	 */
	public Retrait getRetrait() {
		return retrait;
	}
	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the listRetrait
	 */
	public List<Retrait> getListRetrait() {
		return listRetrait;
	}
	/**
	 * @param listRetrait the listRetrait to set
	 */
	public void setListRetrait(List<Retrait> listRetrait) {
		this.listRetrait = listRetrait;
	}
	
	
}
