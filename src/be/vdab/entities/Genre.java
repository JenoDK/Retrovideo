package be.vdab.entities;

import java.io.Serializable;

public class Genre implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String naam;
	public Genre(long id, String naam) {
		super();
		this.id = id;
		this.naam = naam;
	}
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	
	
}
