package com.grima;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorServlet extends HttpServlet{
	
	//@Override
	//protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	//		throws ServletException, IOException {
		    //AutorUtils.insertarNuevo(req.getParameter("apellidos"), req.getParameter("nombre"), 
		    //		req.getParameter("tipoCalle"), req.getParameter("calle"), 
		    //		req.getParameter("numeroCasa"), req.getParameter("codigoPostal"), 
		    //		req.getParameter("provincia"), req.getParameter("poblacion"), 
		    //		req.getParameter("numeroTelefono"), req.getParameter("dni"));
		    //resp.sendRedirect("/autor.jsp");
		    //}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try{
				
			if(request.getParameter("action").equals("buscarAutorDni"))
				{
				
				String dni = request.getParameter("dni");
				List<Autor> autores = AutorUtils.busquedaDni(dni);
				if (autores != null)
					{
					request.setAttribute("autoresDNI", autores);
					}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarAutor.jsp");	
				rd.forward(request, response);
				
				}
			else if(request.getParameter("action").equals("anadirAutor"))
					{
					AutorUtils.insertarNuevo(request.getParameter("apellidos"), request.getParameter("nombre"), 
							request.getParameter("tipoCalle"), request.getParameter("calle"), 
							request.getParameter("numeroCasa"), request.getParameter("codigoPostal"), 
							request.getParameter("provincia"), request.getParameter("poblacion"), 
							request.getParameter("numeroTelefono"), request.getParameter("dni"));
					response.sendRedirect("/autor.jsp");
						
					}
			else if(request.getParameter("action").equals("modificarAutor"))
					{
					String dni = request.getParameter("dni");
					String telefonoNuevo = request.getParameter("telefono");
					String nombreNuevo = request.getParameter("nombre");
					String apellidoNuevo = request.getParameter("apellidos");
					String poblacionNuevo = request.getParameter("poblacion");
					String calleNuevo = request.getParameter("calle");
					String codigoPostalNuevo = request.getParameter("codigoPostal");
					String numeroCasaNuevo = request.getParameter("numeroCasa");
					String provinciaNuevo = request.getParameter("provincia");
					String tipoCalleNuevo = request.getParameter("tipoCalle");
					List<Autor> autores = AutorUtils.busquedaDni(dni);
					if (autores != null)
						{
						AutorUtils.modificarAutor(autores.get(0), telefonoNuevo, nombreNuevo, apellidoNuevo, poblacionNuevo,
								calleNuevo, codigoPostalNuevo, numeroCasaNuevo, provinciaNuevo, tipoCalleNuevo);
						AutorUtils.modificarTelefono(autores.get(0),telefonoNuevo);
						request.setAttribute("dni", dni);
						request.setAttribute("autoresDNI", autores);
						}
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarAutor.jsp");	
					rd.forward(request, response);
					}
			else if(request.getParameter("action").equals("borrarTelefono"))
					{
					String dni = request.getParameter("dni");
					String telefonoBorrar = request.getParameter("telefonoBorrar");
					List<Autor> autores = AutorUtils.busquedaDni(dni);
					AutorUtils.borrarTelefono(dni, telefonoBorrar);
					request.setAttribute("dni", dni);
					request.setAttribute("autoresDNI", autores);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarAutor.jsp");	
					rd.forward(request, response);
					}
			else if(request.getParameter("action").equals("pruebas"))
					{
					String dni = request.getParameter("dni");
					String telefonoBorrar = request.getParameter("telefonoBorrar");
					AutorUtils.pruebas(dni, telefonoBorrar);
					request.setAttribute("dni", dni);
					
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarAutor.jsp");	
					rd.forward(request, response);
					}
			else
				{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
				}
							
		}finally {
			      out.close();
				 }
	}
}

