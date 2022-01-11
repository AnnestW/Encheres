package fr.eni.ecole.encheres.bo;

public class Categorie {
	private Integer noCategorie;
	private String libelle;
	//TOTO ajouter ArticleVendu
	
	public Categorie() {
		
	}
	
	
	
	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}



	public Integer getNoCategorie() {
		return noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
