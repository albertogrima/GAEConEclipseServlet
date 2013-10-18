package com.grima;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


public class TutorialesUtil {
	//Cuantos datos mistrara en la consulta
	private final static int FETCH_MAX_RESULTS = 10;
	
	//Metodo para insertar un dato
	public static void insertar(Autor autorName, String tutorialName){
		//LLamamos a la clase que tendra la persistencia
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		//Creamos nuestra variable del tipo tutorial
		final Tutorial tutorial = new Tutorial(autorName, tutorialName);
		//Y hacemos el dato persistente
		try {
			pm.makePersistent(tutorial);
			}finally{
				pm.close();
			}
		
	}
	//Para consultar los tutoriales por autor
	@SuppressWarnings("unchecked")
	public static List<Tutorial> tutorialesPorAutor(String autor){
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		//List<Tutorial> tutorials = (List<Tutorial>)pm.getObjectById(Tutorial.class, autor);
		String query = " select from " + Tutorial.class.getName() + " where autor == '" + autor + "'";
		List<Tutorial> tutorials = (List<Tutorial>)pm.newQuery(query).execute();
		return(tutorials);
	}
	//Para consultar todos los tutoriales
	@SuppressWarnings("unchecked")
	public static List<Tutorial> todosLosTutoriales(){
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(Tutorial.class);
		query.setRange(0, FETCH_MAX_RESULTS);
		return (List<Tutorial>) query.execute();
	}
	
	//Para los datos de los autores
		@SuppressWarnings("unchecked")
		public static List<Autor> autores(){
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		final Query query = pm.newQuery(Autor.class);
		query.setRange(0, FETCH_MAX_RESULTS);
		return (List<Autor>) query.execute();
		}
	//Para modificar alg�n tutorial
	//public static void modificarTitulo(Long id, String autorNameNuevo, String tutorialNameNuevo,Date fechaNuevo){
		//Llamamos a la clase que tendra la persistencia
		//final PersistenceManager pm = PMF.get().getPersistenceManager();
		//String query = " select from " + Tutorial.class.getName() + " where id == " + id; 
		//String query = " select from " + Tutorial.class.getName() + " where autor == '" + autorName + "'" + " and tutorial == '" + tutorialName + "'";
		//System.out.println(query);
		//Tutorial tutorials = pm.getObjectById(Tutorial.class,id);
		//Tutorial tutorials = (Tutorial)pm.newQuery(query).execute();
		//tutorials.setAutor(autorName);
		//tutorials.setTutorial(tutorialNameNuevo);
		//tutorials.setFicha(fechaNuevo);
		//pm.close();
	//}

}
