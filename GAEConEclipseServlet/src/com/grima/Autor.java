package com.grima;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Autor {
	
	private static final int ENTITIES_PER_PAGE = 3;
	
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
	
	@PersistenceCapable
	@EmbeddedOnly
	public static class infoDireccion {
		public String tipoCalle;
		public String calle;
		public String numeroCasa;
		public String codigoPostal;
		public String provincia;
		public String poblacion;
				
		public infoDireccion(String tipoCalle, String calle, String numeroCasa, String codigoPostal, String provincia, String poblacion) {
			this.tipoCalle = tipoCalle;
			this.calle = calle;
			this.numeroCasa = numeroCasa;
			this.codigoPostal = codigoPostal;
			this.provincia = provincia;
			this.poblacion = poblacion;
		}
		
	}
	
	@PersistenceCapable
	@EmbeddedOnly
	public static class infoContacto {
		public String numeroTelefono;
		
		public infoContacto(String numeroTelefono){
			this.numeroTelefono = numeroTelefono;
		}
	}

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	@Embedded
	private infoPersonal infoPersonal;
	
	@Persistent
	@Embedded
	private infoDireccion infoDireccion;
	
	@Persistent
	@Embedded
	private infoContacto infoContacto;
	
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
		  
	public infoContacto getinfoContacto() {
	    return infoContacto;
	  }

	public void setInfoContacto(infoContacto infoContacto) {
	    this.infoContacto = infoContacto;
	  }
	
	public Long getId() {
	    return id;
	  }
	
}
