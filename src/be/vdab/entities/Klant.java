package be.vdab.entities;

import java.io.Serializable;

public class Klant implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String familienaam;
	private String voornaam;
	private Adres adres;
	
	public Klant(long id, String familieNaam, String voorNaam, Adres adres) {
		super();
		this.id = id;
		this.familienaam = familieNaam;
		this.voornaam = voorNaam;
		this.adres = adres;
	}

	public long getId() {
		return id;
	}

	public String getFamilienaam() {
		return familienaam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	public String getNaam(){
		return familienaam+ " " + voornaam ;
	}

	@Override
	public String toString() {
		return "Klant [id=" + id + ", familienaam=" + familienaam
				+ ", voornaam=" + voornaam + ", adres=" + adres + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
		result = prime * result
				+ ((familienaam == null) ? 0 : familienaam.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((voornaam == null) ? 0 : voornaam.hashCode());
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
		Klant other = (Klant) obj;
		if (adres == null) {
			if (other.adres != null)
				return false;
		} else if (!adres.equals(other.adres))
			return false;
		if (familienaam == null) {
			if (other.familienaam != null)
				return false;
		} else if (!familienaam.equals(other.familienaam))
			return false;
		if (id != other.id)
			return false;
		if (voornaam == null) {
			if (other.voornaam != null)
				return false;
		} else if (!voornaam.equals(other.voornaam))
			return false;
		return true;
	}
	
	
	
}
