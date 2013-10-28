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
<%String dni = request.getParameter("dni"); %>
<form action="/autor" method="get">
	<p>
	<p> Buscar por DNI
	DNI: <input name="dni" value="<%= dni %>">
	<input type="submit" value="modificarAutor">
  </p>
	
</form>


</body>
</html>