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
		return voornaam + " " + familienaam;
	}
	
	
	
}
