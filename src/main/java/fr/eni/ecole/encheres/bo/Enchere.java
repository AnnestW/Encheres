package fr.eni.ecole.encheres.bo;

import java.time.LocalDate;

public class Enchere {
	private LocalDate dateEnchere;
	private Double montantEnchere;
	//TOTO ajouter ArticleVendu
	
	
	public Enchere() {
		
	}
	
	
	
	public Enchere(LocalDate dateEnchere, Double montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}






	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	public Double getMontantEnchere() {
		return montantEnchere;
	}
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public void setMontantEnchere(Double montantEnchere) {
		this.montantEnchere = montantEnchere;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montantEnchere=");
		builder.append(montantEnchere);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
