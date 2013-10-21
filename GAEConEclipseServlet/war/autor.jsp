<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.grima.Autor" %>
<%@ page import="com.grima.AutorUtils" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>.::Autores::.</title>
</head>
<body>

<%
//Siguiente pagina mediante keyID
Long keyOffsetId = null;
String keyOffset = request.getParameter("page");
if (keyOffset != null) keyOffsetId = Long.decode(keyOffset);
if (keyOffset == null) keyOffset = "";
//Siguiente pagina mediante index
String indexString = request.getParameter("startIndex");
if (indexString == null) indexString = "0";
int indexOffset = Integer.parseInt(indexString);

//Busqueda
String ultimoNombreSelecionado = request.getParameter("ultimoNombreSelecionado");
if (ultimoNombreSelecionado == null) ultimoNombreSelecionado = "";
String estadoSelecionado = request.getParameter("estadoSelecionado");
if (estadoSelecionado == null) estadoSelecionado = "";
%>

<form action="/autor.jsp" method="get">
  <p>
  <p>Buscar por
  Apellidos: <input name="ultimoNombreSelecionado" value="<%= ultimoNombreSelecionado %>">
  y/o pobalcion <input name="estadoSelecionado" value="<%= estadoSelecionado %>">
  <input type="submit" value="buscar">
  </p>
</form>

<%
List<Autor> entradas = new ArrayList<Autor>(
		AutorUtils.getPage(keyOffsetId, indexOffset, ultimoNombreSelecionado, estadoSelecionado));
Autor ultimaEntrada = null;
if (entradas.size() > 3) {
	ultimaEntrada = entradas.get(3);
	entradas.remove(3);
}

if (entradas.isEmpty()) {%>
There are no entries.
<%} else {
	  for (Autor entrada : entradas) {
		    %>
		    <div>
		      <div><%= entrada.getinfoPersonal().nombre %> <%= entrada.getinfoPersonal().apellidos %></div>
		      <div><%= entrada.getinfoDireccion().poblacion %>, <%= entrada.getinfoDireccion().provincia %></div>
		    </div>
		    <br>
		    <%
		  }
	  
	  if (ultimaEntrada != null) {%>
	  <!--<a href="/autor.jsp?page=<%= ultimaEntrada.getId().toString() %>&startIndex=0">Next page by key offset</a>-->
	  <!--<a href="/autor.jsp?page=<%= keyOffset %>&startIndex=<%= indexOffset + 3 %>">Next page by index offset</a>-->
	  <a href="/autor.jsp?page=<%= ultimaEntrada.getId().toString() %>">Next page by key offset</a>
	  <a href="/autor.jsp?startIndex=<%= indexOffset + 3 %>">Next page by index offset</a>
	    <%
	  } else {
	    %>
	    No more pages of entries.
	    <%
	  }
	}%>

<h2>entrada nueva</h2>
<form action="/autor" method="post">
  <p>First name: <input name="nombre"> Last name: <input name="apellidos"></p>
  <p>City: <input name="poblacion"> State: <input name="estado"></p>
  <p>Phone number: <input name="numeroTelefono"></p>
  <p><input type="submit" value="Submit"></p>
</form>
<br>	  
		

</body>
</html>