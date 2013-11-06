package com.grima;

import java.util.ArrayList;
import java.util.List;




import javax.jdo.annotations.Element;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Embedded;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Autor {
	
	private static final int ENTITIES_PER_PAGE = 3;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
		
	@Persistent
	@Embedded
	private infoPersonal infoPersonal;
	
	@Persistent
	@Embedded
	private infoDireccion infoDireccion;
		
	@Persistent(mappedBy = "autor")
	@Element(dependent = "true")
	private List<ContactosAutor> contactosAutor = new ArrayList<ContactosAutor>();
	//private List<ContactosAutor> contactosAutor;
	
	@PersistenceCapable
	@EmbeddedOnly
	public static class infoPersonal {
	    public String apellidos;
	    public String nombre;
	    
	    public infoPersonal(String nombre, String apellidos) {
	      this.apellidos = apellidos;
	      this.nombre = nombre;
	    }
	  }
	
	
	//Constructor clase
	@PersistenceCapable
	@EmbeddedOnly
	public static class infoDireccion {
		public String tipoCalle;
		public String calle;
		public String numeroCasa;
		public String codigoPostal;
		public String provincia;
		public String poblacion;
		public String dni;
				
		public infoDireccion(String tipoCalle, String calle, String numeroCasa, String codigoPostal, String provincia, String poblacion, String dni) {
			this.tipoCalle = tipoCalle;
			this.calle = calle;
			this.numeroCasa = numeroCasa;
			this.codigoPostal = codigoPostal;
			this.provincia = provincia;
			this.poblacion = poblacion;
			this.dni = dni;
		}
		
	}
	
	//Getters y settes
	
	public infoPersonal getinfoPersonal() {
	    return infoPersonal;
	  }

	public void setPersonalInfo(infoPersonal infoPersonal) {
	    this.infoPersonal = infoPersonal;
	  }
	
	
	public infoDireccion getinfoDireccion() {
	    return infoDireccion;
	  }

	public void setInfoDireccion(infoDireccion getinfoDireccion) {
	    this.infoDireccion = getinfoDireccion;
	  }
		  
	//public infoContacto getinfoContacto() {
	//    return infoContacto;
	//  }

	//public void setInfoContacto(infoContacto infoContacto) {
	//    this.infoContacto = infoContacto;
	//  }
	
	public Key getId() {
	    return id;
	  }
			
	public List<ContactosAutor> getContactos(){
		return contactosAutor;
	}
	
}
