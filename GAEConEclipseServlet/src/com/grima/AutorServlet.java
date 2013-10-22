package com.grima;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    AutorUtils.insertarNuevo(req.getParameter("apellidos"), req.getParameter("nombre"), 
		    		req.getParameter("tipoCalle"), req.getParameter("calle"), 
		    		req.getParameter("numeroCasa"), req.getParameter("codigoPostal"), 
		    		req.getParameter("provincia"), req.getParameter("poblacion"), 
		    		req.getParameter("numeroTelefono"), req.getParameter("dni"));
		    resp.sendRedirect("/autor.jsp");
		    }
	
	

}
