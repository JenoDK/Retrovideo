package be.vdab.entities;

import java.io.Serializable;

public class Adres implements Serializable{

	private static final long serialVersionUID = 1L;
	private String straatNummer;
	private String postcode;
	private String gemeente;
	
	public Adres(String straatNummer, String postcode, String gemeente) {
		super();
		this.straatNummer = straatNummer;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraatNummer() {
		return straatNummer;
	}

	public void setStraatNummer(String straatNummer) {
		this.straatNummer = straatNummer;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	
	
	
}
