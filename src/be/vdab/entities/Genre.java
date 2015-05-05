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
	@Override
	public String toString() {
		return "Genre [id=" + id + ", naam=" + naam + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
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
		Genre other = (Genre) obj;
		if (id != other.id)
			return false;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}
	
	
}
