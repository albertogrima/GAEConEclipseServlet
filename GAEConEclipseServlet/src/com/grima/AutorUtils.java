package com.grima;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;




public class AutorUtils {

	private static final int ENTITIES_PER_PAGE = 3;
	
	public static String insertarNuevo(String apellidos, String nombre, String tipoCalle, 
			String calle, String numeroCasa, String codigoPostal,
			String provincia, String poblacion,
			String numeroTelefono, String dni) {
		Autor entrada = new Autor();
		entrada.setPersonalInfo(new Autor.infoPersonal(nombre, apellidos));
		entrada.setInfoDireccion(new Autor.infoDireccion(tipoCalle, calle, numeroCasa,
			codigoPostal, provincia, poblacion, dni));
		ContactosAutor contactosAutor = new ContactosAutor();
		contactosAutor.setInfoContacto(new ContactosAutor.infoContacto(numeroTelefono));
		entrada.getContactos().add(contactosAutor);
				
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.currentTransaction().begin();
		try {
		    pm.makePersistent(entrada);
		    pm.currentTransaction().commit();
			} finally 
				{
				if (pm.currentTransaction().isActive()) 
		    		{
					pm.currentTransaction().rollback();
		    		}
				}
		
		System.out.println(
		        "El ID de la nueva entrada es: " + entrada.getId().toString());
		
		return entrada.getId().toString();
		
	}
	
	@SuppressWarnings("unchecked")
	public static void modificarTelefono(Autor autor, String telefonoNuevo) {
		ContactosAutor contactosAutor = new ContactosAutor();
		contactosAutor.setInfoContacto(new ContactosAutor.infoContacto(telefonoNuevo));
		autor.getContactos().add(contactosAutor);
						
		//pm.currentTransaction().begin();
		//try{
		//	pm.makePersistent(autor);
		//	pm.currentTransaction().commit();
		//	}finally{
		//			if(pm.currentTransaction().isActive())
		//				{
		//				pm.currentTransaction().rollback();
		//				}
		//			}
	}
	
	//Para sacar datos Autor por dni
	@SuppressWarnings("unchecked")
	public static List<Autor> busquedaDni (String dni){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Autor.class);
		query.declareParameters("String dni");
		StringBuilder filter = new StringBuilder();
		filter.append("infoDireccion.dni == dni");
		System.out.println("El filtro es: " + filter.toString());
		System.out.println(query);
		
		//Si el filtro tiene algo se convierta a string y se setea para ejecutarlo
		if (filter.length() > 0) 
    		{
			query.setFilter(filter.toString());
    		}
		
		List<Autor> autor = (List<Autor>) query.execute(dni);
		//pm.close();
		return autor;
		
	}
	
	//Pruebas
	public static void pruebas(String dni, String telefonoBorrar){
		List<Autor> autor = busquedaDni(dni);
		String telefonoComprobar;
		for (int x = 0; x < autor.get(0).getContactos().size(); x++)
			{
			telefonoComprobar = autor.get(0).getContactos().get(x).getinfoContacto().numeroTelefono;
			
			if (telefonoComprobar.equals(telefonoBorrar))
				{
				Key idContacto = autor.get(0).getContactos().get(x).getId();
				Key idContactoTelefono = autor.get(0).getContactos().get(x).getinfoContacto().getId();
				PersistenceManager pm = PMF.get().getPersistenceManager();
				
				pm.currentTransaction().begin();
				try{
					//Se saca el id del telefono a borrar
					ContactosAutor.infoContacto contactoBorrarTelefono = (ContactosAutor.infoContacto) pm.getObjectById(ContactosAutor.infoContacto.class,idContactoTelefono);
					//Key prueba = pm.getObjectId(ContactosAutor.infoContacto);
					System.out.println(pm.getObjectId(autor.get(0)));
					//Se saca el id del contacto a borrar
					ContactosAutor contactoBorrar = (ContactosAutor) pm.getObjectById(ContactosAutor.class,idContacto);
					
					pm.currentTransaction().commit();
					}finally{
							if(pm.currentTransaction().isActive())
								{
								pm.currentTransaction().rollback();
								}
							}
				}
			}
		
		Key id = autor.get(0).getId();
						
		
		
		
		
	}
	
	//Para borrar telefonos
	@SuppressWarnings("unchecked")
	public static void borrarTelefono(String dni, String telefonoBorrar){
		List<Autor> autor = busquedaDni(dni);
		String telefonoComprobar;
		for (int x = 0; x < autor.get(0).getContactos().size(); x++)
			{
			telefonoComprobar = autor.get(0).getContactos().get(x).getinfoContacto().numeroTelefono;
			
			if (telefonoComprobar.equals(telefonoBorrar))
				{
				Key idContacto = autor.get(0).getContactos().get(x).getId();
				Key idContactoTelefono = autor.get(0).getContactos().get(x).getinfoContacto().getId();
				PersistenceManager pm = PMF.get().getPersistenceManager();
				
				pm.currentTransaction().begin();
				try{
					//Se saca el id del telefono a borrar
					ContactosAutor.infoContacto contactoBorrarTelefono = (ContactosAutor.infoContacto) pm.getObjectById(ContactosAutor.infoContacto.class,idContactoTelefono);
					pm.deletePersistent(contactoBorrarTelefono);
					
					//Se saca el id del contacto a borrar
					ContactosAutor contactoBorrar = (ContactosAutor) pm.getObjectById(ContactosAutor.class,idContacto);
					pm.deletePersistent(contactoBorrar);
					pm.currentTransaction().commit();
					}finally{
							if(pm.currentTransaction().isActive())
								{
								pm.currentTransaction().rollback();
								}
							}
				}
			}
		
		Key id = autor.get(0).getId();
						
		
		
		
		
	}
	
	//Para sacar la pagina en la que se esta y/o realizar busqueda
	@SuppressWarnings("unchecked")
	public static List<Autor> getPage(Long keyOffset, int indexOffset, String apellidos, String poblacion) {
	    PersistenceManager pm = PMF.get().getPersistenceManager();
	    
	    Query query = pm.newQuery(Autor.class);
	    query.declareParameters(
	    		"Long keyOffset, String ultimoNombreSelecionado, String estadoSelecionado");
	    StringBuilder filter = new StringBuilder();
	    	    
	    if (keyOffset != null && !keyOffset.equals("")) 
	    	{
	    	if (filter.length() != 0) 
	    		{
	    		filter.append(" && ");
	    		}
	    	filter.append("id >= keyOffset");
	    	}
	    
	    if (apellidos != null && !apellidos.equals("")) 
	    	{
	    	if (filter.length() != 0) 
	      		{
	    		filter.append(" && ");
	      		}
	      	filter.append("infoPersonal.apellidos == ultimoNombreSelecionado");
	    	}
	    
	    if (poblacion != null && !poblacion.equals("")) 
	    	{
	    	if (filter.length() != 0) 
	    		{
	    		filter.append(" && ");
	    		}
	    	filter.append("infoDireccion.poblacion == estadoSelecionado");
	    	}
	    
	    System.out.println("Filter is: " + filter.toString());
	    if (filter.length() > 0) 
	    	{
	    	query.setFilter(filter.toString());
	    	}
	    query.setRange(indexOffset, indexOffset + ENTITIES_PER_PAGE + 1);
	    return (List<Autor>) query.execute(keyOffset, apellidos, poblacion);
	  }
	
}
