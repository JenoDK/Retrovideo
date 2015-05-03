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
	
	
	

}
