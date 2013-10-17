package com.grima;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
	//variable encargada de controlar las peticiones
	private static final PersistenceManagerFactory instance = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	//Para que no puedan instanciar la clase
	private PMF(){}
	//Retorna la instancia encargada de controlar las peticiones
	public static PersistenceManagerFactory get(){
		return instance;
	}

}
