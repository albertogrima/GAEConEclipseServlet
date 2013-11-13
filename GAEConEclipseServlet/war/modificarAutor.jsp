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
	<input type="submit" value="Buscar Autor">
  </p>
</form>
<%
if(autores != null && autores.size() > 0)
	{
	//System.out.println(autores.get(0).getinfoDireccion().poblacion);
	%>
<table border="1">
	<thead>
    <tr>
     <th>Nombre</th>
     <th>Apellidos</th>
     <th>Población</th>
     <th>Calle</th>
     <th>Código Postal</th>
     <th>Número Casa</th>
     <th>Provincia</th>
     <th>Tipo Calle</th>
     <th>Teléfonos</th>
    </tr>
   </thead>
	<tr>
    	<td><%= autores.get(0).getinfoPersonal().nombre %></td>
    	<td><%= autores.get(0).getinfoPersonal().apellidos %></td>
    	<td><%= autores.get(0).getinfoDireccion().poblacion %></td>
    	<td><%= autores.get(0).getinfoDireccion().calle %></td>
    	<td><%= autores.get(0).getinfoDireccion().codigoPostal %></td>
    	<td><%= autores.get(0).getinfoDireccion().numeroCasa %></td>
    	<td><%= autores.get(0).getinfoDireccion().provincia %></td>
    	<td><%= autores.get(0).getinfoDireccion().tipoCalle %></td>
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
	DNI: <input name="dni" value="<%= autores.get(0).getinfoDireccion().dni %>" readonly> <br>
	Nombre: <input name="nombre" value="<%=autores.get(0).getinfoPersonal().nombre %>"> <br>
	Apellidos: <input name="apellidos" value="<%=autores.get(0).getinfoPersonal().apellidos %>"> <br>
	Poblacion: <input name="poblacion" value="<%=autores.get(0).getinfoDireccion().poblacion %>"> <br>
	Teléfono: <input name="telefono" value="<%=telefono %>"> <br>
	Calle: <input name="calle" value="<%=autores.get(0).getinfoDireccion().calle %>"> <br>
	Código postal: <input name="codigoPostal" value="<%=autores.get(0).getinfoDireccion().codigoPostal %>"> <br>
	Número casa: <input name="numeroCasa" value="<%=autores.get(0).getinfoDireccion().numeroCasa %>"> <br>
	Provincia: <input name="provincia" value="<%=autores.get(0).getinfoDireccion().provincia %>"> <br>
	Tipo Calle: <input name="tipoCalle" value="<%=autores.get(0).getinfoDireccion().tipoCalle %>"> <br>
	<input type="hidden" name="action" value="modificarAutor">
	<input type="submit" value="Modificar Autor">
	</p>
</form>
<form action="/autor" method="get">
	DNI: <input name="dni" value="<%= dni %>"> <br>
	Teléfono a borrar: <input name="telefonoBorrar" value="<%=telefono %>"> <br>
	<input type="hidden" name="action" value="borrarTelefono">
	<input type="submit" value="Borrar Telefono">
</form>
<%	} %>


</body>
</html>