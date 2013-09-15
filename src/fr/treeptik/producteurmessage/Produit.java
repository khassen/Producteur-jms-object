package fr.treeptik.producteurmessage;

import java.io.Serializable;

public class Produit implements Serializable{
	
	private final long serialVersionUI = 1L;
	
	private Integer id;
	private String ref;
	private String description;
	
	
	
	
	
	
	public Produit() {
		super();
	}
	
	
	
	public Produit(Integer id, String ref, String description) {
		super();
		this.id = id;
		this.ref = ref;
		this.description = description;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getSerialVersionUI() {
		return serialVersionUI;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
