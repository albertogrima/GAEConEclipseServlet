package com.grima;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;

@SuppressWarnings("serial")
public class GAEConEclipseServletServlet extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try{
		
			if(request.getParameter("action").equals("create"))
			{
				String autor = request.getParameter("autor");
				String tutorial = request.getParameter("tutorial");
				TutorialesUtil.insertar(autorName, tutorialName);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");	
				rd.forward(request, response);
			}
			else if(request.getParameter("action").equals("showTodos"))
				{
				List<Tutorial> tutorials = TutorialesUtil.todosLosTutoriales();
				request.setAttribute("showFullTutorials", tutorials);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/tutorialShowFull.jsp");
				rd.forward(request, response);
				}
			else if(request.getParameter("action").equals("showAutor"))
				{
				String autor = request.getParameter("autor");
				List<Tutorial> tutorials = TutorialesUtil.tutorialesPorAutor(autor);
				request.setAttribute("tutorialesPorAutor",tutorials);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/tutorialShow.jsp");
				rd.forward(request, response);
				}
			else if(request.getParameter("action").equals("modificarTutorial"))
				{
				String autorNuevo = request.getParameter("autorNuevo");
				String tutorialNuevo = request.getParameter("tutorialNuevo");
				Long id = Long.parseLong(request.getParameter("id"));
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date fechaNuevo = null;
				
					try {
						fechaNuevo = sdf.parse(request.getParameter("fecha"));
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
											
				TutorialesUtil.modificarTitulo(id, autorNuevo, tutorialNuevo, fechaNuevo);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");	
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
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}
	
}
