<%//Pagina para modificar autor %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.grima.Autor" %>
<%@ page import="com.grima.AutorUtils" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.::Modificar Autor::.</title>
</head>
<body>
<%
String dni = request.getParameter("dni");
String telefono = request.getParameter("telefono");
List<Autor> autores = (List)request.getAttribute("autoresDNI");

%>
<form action="/autor" method="get">
	<p>
	<p> Buscar por DNI
	DNI: <input name="dni" value="<%= dni %>">
	<input type="hidden" name="action" value="buscarAutorDni">
	<input type="submit" value="Modificar Autor">
  </p>
</form>
<%
if(autores != null && autores.size() > 0)
	{
	System.out.println(autores.get(0).getinfoDireccion().poblacion);
	%>
<table border="1">
	<thead>
    <tr>
     <th>Nombre</th>
     <th>Apellidos</th>
     <th>Población</th>
     <th>Teléfonos</th>
    </tr>
   </thead>
	<tr>
    	<td><%= autores.get(0).getinfoPersonal().nombre %></td>
    	<td><%= autores.get(0).getinfoPersonal().apellidos %></td>
    	<td><%= autores.get(0).getinfoDireccion().poblacion %></td>
    	<%for (int x = 0; x < autores.get(0).getContactos().size(); x++)
    		{%>
		<td><%= autores.get(0).getContactos().get(x).getinfoContacto().numeroTelefono %></td>
		<%	} %>
	</tr>
<%	}else
		{%>
		No hay resultados.
	<%	} %>

<%if(autores != null && autores.size() > 0)
	{%>

<form action="/autor" method="get">
	<p>
	<p> Modificar Autor <br>
	DNI: <input name="dni" value="<%= dni %>"> <br>
	Nombre: <input name="nombre" value="<%=autores.get(0).getinfoPersonal().nombre %>"> <br>
	Apellidos: <input name="apellidos" value="<%=autores.get(0).getinfoPersonal().apellidos %>"> <br>
	Poblacion: <input name="poblacion" value="<%=autores.get(0).getinfoDireccion().poblacion %>"> <br>
	Teléfono: <input name="telefono" value="<%=telefono %>"> <br>
	<input type="hidden" name="action" value="modificarAutor">
	<input type="submit" value="Modificar Autor">
  </p>
</form>
<%	} %>


</body>
</html>