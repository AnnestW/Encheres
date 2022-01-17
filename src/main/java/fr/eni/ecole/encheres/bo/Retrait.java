package fr.eni.ecole.encheres.bo;

public class Retrait {
	
	private String rue;
	private String code_postal;
	
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	
	
	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Retrait(String rue, String code_postal) {
		super();
		this.rue = rue;
		this.code_postal = code_postal;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [rue=");
		builder.append(rue);
		builder.append(", code_postal=");
		builder.append(code_postal);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
