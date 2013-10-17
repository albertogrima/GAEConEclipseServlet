package com.grima;

import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable (identityType=IdentityType.APPLICATION)
public class Tutorial{
	//Va a ser la clave primaria de la clase Tutorial
	 @PrimaryKey
	 //Para que genere el codigo de forma automatica
	 @Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	 private Long id;
	 //Creamos las variables persistence para insertar los datos
	 @Persistent 
	 private String autor;
	 @Persistent 
	 private String tutorial;
	 @Persistent 
	 private Date fecha;
	 //Constructor de la clase
	 public Tutorial(String autor, String tutorial){
		 this.autor = autor;
		 this.tutorial = tutorial;
		 this.fecha = new Date();
	 }
	 //Metodos get y set
	 public String getAutor(){
		 return autor;
	 }
	 public void setAutor(String autor){
		 this.autor = autor;
     }
	 public String getTutorial(){
		 return tutorial;
	 }
	 public void setTutorial(String tutorial){
		 this.tutorial = tutorial;
	 }
	 public Date getFecha(){
		 return fecha;
	 }
	 public void setFicha(Date fecha){
		 this.fecha = fecha;
	 }
	 public Long getId(){
		 return id;
	 }
	 public void setId(Long id){
		 this.id = id;
	 }
}
