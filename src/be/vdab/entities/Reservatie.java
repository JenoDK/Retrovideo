package be.vdab.entities;

import java.io.Serializable;
import java.util.Date;

public class Reservatie implements Serializable{

	private static final long serialVersionUID = 1L;
	private long klantid;
	private long filmid;
	private String klantFamNaam;
	private String klantVoorNaam;
	private String filmNaam;
	private Date reservatieDatum;
	
	public Reservatie(long klantid, long filmid, Date reservatieDatum) {
		super();
		this.klantid = klantid;
		this.filmid = filmid;
		this.reservatieDatum = reservatieDatum;
	}
	
	public Reservatie(long klantid, long filmid, String klantFamNaam, String klantVoorNaam, String filmNaam, Date reservatieDatum){
		super();
		this.klantid = klantid;
		this.filmid = filmid;
		this.klantFamNaam = klantFamNaam;
		this.klantVoorNaam = klantVoorNaam;
		this.filmNaam = filmNaam;
		this.reservatieDatum = reservatieDatum;
	}	

	public String getKlantNaam() {
		return klantFamNaam + " " + klantVoorNaam;
	}

	public String getFilmNaam() {
		return filmNaam;
	}

	public long getKlantid() {
		return klantid;
	}

	public long getFilmid() {
		return filmid;
	}

	public Date getReservatieDatum() {
		return reservatieDatum;
	}

	@Override
	public String toString() {
		return "Reservatie [klantid=" + klantid + ", filmid=" + filmid
				+ ", klantFamNaam=" + klantFamNaam + ", klantVoorNaam="
				+ klantVoorNaam + ", filmNaam=" + filmNaam
				+ ", reservatieDatum=" + reservatieDatum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((filmNaam == null) ? 0 : filmNaam.hashCode());
		result = prime * result + (int) (filmid ^ (filmid >>> 32));
		result = prime * result
				+ ((klantFamNaam == null) ? 0 : klantFamNaam.hashCode());
		result = prime * result
				+ ((klantVoorNaam == null) ? 0 : klantVoorNaam.hashCode());
		result = prime * result + (int) (klantid ^ (klantid >>> 32));
		result = prime * result
				+ ((reservatieDatum == null) ? 0 : reservatieDatum.hashCode());
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
		Reservatie other = (Reservatie) obj;
		if (filmNaam == null) {
			if (other.filmNaam != null)
				return false;
		} else if (!filmNaam.equals(other.filmNaam))
			return false;
		if (filmid != other.filmid)
			return false;
		if (klantFamNaam == null) {
			if (other.klantFamNaam != null)
				return false;
		} else if (!klantFamNaam.equals(other.klantFamNaam))
			return false;
		if (klantVoorNaam == null) {
			if (other.klantVoorNaam != null)
				return false;
		} else if (!klantVoorNaam.equals(other.klantVoorNaam))
			return false;
		if (klantid != other.klantid)
			return false;
		if (reservatieDatum == null) {
			if (other.reservatieDatum != null)
				return false;
		} else if (!reservatieDatum.equals(other.reservatieDatum))
			return false;
		return true;
	}
	
	
	

}
