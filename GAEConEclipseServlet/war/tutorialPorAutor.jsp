<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>.::Tutoriales por Autor::.</title>
</head>
<body>
<span>
  <a href="/tutorialCreate.jsp">Registrar Tutorial</a><br>
  <a href="/index.jsp">Ir al indice</a><br>
 </span>
 <span ><h1>Busqueda tutoriales</h1></span>
  <form action="/tutorial" method="get">
  <table border="0">
   <tr>
       <td>Autor:</td>
       <td><input type="text" name="autor" /></td>
      </tr>
      <tr>
       <td colspan="2" bgcolor="#ffffff" align="left">
       <input type="hidden" name="action" value="showAutor"/>
       <input type="submit" value="Busqueda" >
       </td>
      </tr>
   </table>
   </form>
</body>
</html>