<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String date = sdf.format(new Date());
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>.::Modificar Tutorial::.</title>
</head>
<body>
<span>
  <a href="/tutorialCreate.jsp">Registrar Tutorial</a><br>
  <a href="/index.jsp">Ir al indice</a><br>
 </span>
 <span ><h1>Modificar Tutorial</h1></span>
  <form action="/tutorial" method="get">
  <table border="0">
   <tr>
       <td>Id tutorial a modificar:</td>
       <td><input type="text" name="id" /></td>
      </tr>
      <tr>
       <td>Autor Nuevo:</td>
       <td><input type="text" name="autorNuevo" /></td>
      </tr>
      <tr>
       <td>Tutorial Nuevo:</td>
       <td><input type="text" name="tutorialNuevo"/> </td>
      </tr>
      <tr>
      	<td>Fecha Nuevo:</td>
      	<td><input readonly type="text" name="fecha" value="<%=date%>" /> </td>
      </tr>
      <tr>
       <td colspan="2" bgcolor="#ffffff" align="left">
       <input type="hidden" name="action" value="modificarTutorial"/>
       <input type="submit" value="Modificar" >
       </td>
      </tr>
   </table>
   </form>
</body>
</html>