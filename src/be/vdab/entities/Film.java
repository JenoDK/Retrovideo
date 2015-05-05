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

	@Override
	public String toString() {
		return "Film [id=" + id + ", genreid=" + genreid + ", titel=" + titel
				+ ", voorraad=" + voorraad + ", gereserveerd=" + gereserveerd
				+ ", prijs=" + prijs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (genreid ^ (genreid >>> 32));
		result = prime * result + gereserveerd;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((prijs == null) ? 0 : prijs.hashCode());
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
		result = prime * result + voorraad;
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
		Film other = (Film) obj;
		if (genreid != other.genreid)
			return false;
		if (gereserveerd != other.gereserveerd)
			return false;
		if (id != other.id)
			return false;
		if (prijs == null) {
			if (other.prijs != null)
				return false;
		} else if (!prijs.equals(other.prijs))
			return false;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		if (voorraad != other.voorraad)
			return false;
		return true;
	}
	
	

}
