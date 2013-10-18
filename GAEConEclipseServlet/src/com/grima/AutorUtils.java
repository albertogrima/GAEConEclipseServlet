package com.grima;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;



public class AutorUtils {

	private static final int ENTITIES_PER_PAGE = 3;
	
	public static String insertarNuevo(String apellidos, String nombre, String tipoCalle, 
			String calle, String numeroCasa, String codigoPostal,
			String provincia, String poblacion,
			String numeroTelefono) {
		Autor entrada = new Autor();
		entrada.setPersonalInfo(new Autor.infoPersonal(nombre, apellidos));
		entrada.setInfoContacto(new Autor.infoContacto(numeroTelefono));
		entrada.setInfoDireccion(new Autor.infoDireccion(tipoCalle, calle, numeroCasa,
				codigoPostal, provincia, poblacion));
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(entrada);
		
		System.out.println(
		        "El ID de la nueva entrada es: " + entrada.getId().toString());
		
		return entrada.getId().toString();
		
	}
	
	
	//Para sacar la pagina en la que se esta
	public static List<Autor> getPage(
	        Long keyOffset, int indexOffset, String lastName, String state) {
	    PersistenceManager pm = PMF.get().getPersistenceManager();
	    
	    Query query = pm.newQuery(Autor.class);
	    query.declareParameters(
	        "Long keyOffset, String lastNameSelected, String stateSelected");
	    StringBuilder filter = new StringBuilder();
	    String combine = "";
	    if (keyOffset != null && !keyOffset.equals("")) {
	      if (filter.length() != 0) {
	        filter.append(" && ");
	      }
	      filter.append("id >= keyOffset");
	    }
	    if (lastName != null && !lastName.equals("")) {
	      if (filter.length() != 0) {
	        filter.append(" && ");
	      }
	      filter.append("personalInfo.lastName == lastNameSelected");
	    }
	    if (state != null && !state.equals("")) {
	      if (filter.length() != 0) {
	        filter.append(" && ");
	      }
	      filter.append("addressInfo.state == stateSelected");
	    }
	    System.out.println("Filter is: " + filter.toString());
	    if (filter.length() > 0) {
	      query.setFilter(filter.toString());
	    }
	    query.setRange(indexOffset, indexOffset + ENTITIES_PER_PAGE + 1);
	    return (List<Autor>) query.execute(keyOffset, lastName, state);
	  }
	
}
