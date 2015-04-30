package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Film implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private long genreid;
	private String titel;
	private int voorraad;
	private int gereserveerd;
	private BigDecimal prijs;

	public Film(long id, long genreid, String titel, int voorraad,
			int gereserveerd, BigDecimal prijs) {
		super();
		this.id = id;
		this.genreid = genreid;
		this.titel = titel;
		this.voorraad = voorraad;
		this.gereserveerd = gereserveerd;
		this.prijs = prijs;
	}

	public long getId() {
		return id;
	}

	public long getGenreid() {
		return genreid;
	}

	public String getTitel() {
		return titel;
	}

	public int getVoorraad() {
		return voorraad;
	}

	public int getGereserveerd() {
		return gereserveerd;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setVoorraad(int voorraad) {
		this.voorraad = voorraad;
	}

	public void setGereserveerd(int gereserveerd) {
		this.gereserveerd = gereserveerd;
	}
	
	

}
