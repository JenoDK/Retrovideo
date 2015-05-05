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

	@Override
	public String toString() {
		return "Adres [straatNummer=" + straatNummer + ", postcode=" + postcode
				+ ", gemeente=" + gemeente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gemeente == null) ? 0 : gemeente.hashCode());
		result = prime * result
				+ ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result
				+ ((straatNummer == null) ? 0 : straatNummer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adres other = (Adres) obj;
		if (gemeente == null) {
			if (other.gemeente != null)
				return false;
		} else if (!gemeente.equals(other.gemeente))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (straatNummer == null) {
			if (other.straatNummer != null)
				return false;
		} else if (!straatNummer.equals(other.straatNummer))
			return false;
		return true;
	}
	
	
	
	
}
