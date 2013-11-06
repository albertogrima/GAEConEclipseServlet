package com.grima;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Embedded;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")

public class ContactosAutor {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Key id;
	
	@Persistent
	private Autor autor;
	@Persistent
	private infoContacto infoContacto;
		
	//Getters y setters
	public infoContacto getinfoContacto() {
	    return infoContacto;
	  }

	public void setInfoContacto(infoContacto infoContacto) {
	    this.infoContacto = infoContacto;
	  }
	
	public Key getId() {
	    return id;
	  }
	
	//Clase infoContacto
	@PersistenceCapable
	public static class infoContacto {
		public String numeroTelefono;
		
		@PrimaryKey
		@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
		public Key id;
		
		public infoContacto(String numeroTelefono){
			super();
			this.numeroTelefono = numeroTelefono;
		}
		
		public Key getId(){
			return id;
		}
	}
	
}
