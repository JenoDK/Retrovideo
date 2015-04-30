package be.vdab.entities;

import java.io.Serializable;

public class Klant implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String familieNaam;
	private String voorNaam;
	private Adres adres;
	
	public Klant(long id, String familieNaam, String voorNaam, Adres adres) {
		super();
		this.id = id;
		this.familieNaam = familieNaam;
		this.voorNaam = voorNaam;
		this.adres = adres;
	}

	public long getId() {
		return id;
	}

	public String getFamilieNaam() {
		return familieNaam;
	}

	public String getVoorNaam() {
		return voorNaam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
	
	
}
