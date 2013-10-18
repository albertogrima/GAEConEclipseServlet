package com.grima;
import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable (identityType=IdentityType.APPLICATION)
public class Autor {
	//Clave primaria clase Autor+
	@PrimaryKey
	//Se pone la primaryKey al DNI del Autor del tutorial
	private String dni;
	@Persistent
	private String nombreAutor;
	@Persistent 
	private String apellidosAutor;
	
	//Constructor de la clase
	public Autor(String autor, String tutorial){
		this.dni = dni;
		this.nombreAutor = nombreAutor;
		this.apellidosAutor = apellidosAutor;
		}
	
	//Metodos get y set
	public String getDni(){
		return dni;
		}
	
	public void setDni(String dni){
		this.dni = dni;
		}
	
	public String getNombreAutor(){
		return nombreAutor;
		}
	
	public void setNombreAutor(String nombreAutor){
		this.nombreAutor = nombreAutor;
	}
	

}
