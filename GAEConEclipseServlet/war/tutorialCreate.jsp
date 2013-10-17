<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String date = sdf.format(new Date());
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>.:: Crear Tutorial::. </title>
 </head>
 <span>
  <a href="/tutorialCreate.jsp">Registrar Tutorial</a><br>
  <a href="/index.jsp">Ir al indice</a><br>
 </span>
 <span ><h1>Crear a Tutorial</h1></span>
  <form action="/tutorial" method="get">
  <table border="0">
   <tr>
       <td>Autor:</td>
       <td><input type="text" name="autor" /></td>
      </tr>
      <tr>
       <td>Tutorial:</td>
       <td><input type="text" name="tutorial" /></td>
      </tr>
      <tr>
       <td>Fecha:</td>
       <td><input readonly type="text" name="fecha" value="<%=date%>" /> </td>
      </tr>
      <tr>
       <td colspan="2" bgcolor="#ffffff" align="left">
       <input type="hidden" name="action" value="create"/>
       <input type="submit" value="Registrar" >
       </td>
      </tr>
   </table>
   </form>
 </body>
</html>