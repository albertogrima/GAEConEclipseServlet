<%@page import="com.grima.*" %>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>

<%
String autor = "prueba";
List<Tutorial> tutorials = (List)request.getAttribute("tutorialesPorAutor");
SimpleDateFormat sdf = new SimpleDateFormat();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>.::Tutoriales por autor: <%=autor%> ::.</title>
 </head>
 <body>
  <span>
   <a href="/tutorialCreate.jsp">Registrar Tutorial</a><br>
   <a href="/index.jsp">Ir al indice</a>
  </span>
  <h1>Tutoriales del autor: <%=autor%></h1>
  <table border="1">
   <thead>
    <tr>
     <th>Id</th>
     <th>Autor</th>
     <th>Tutorial</th>
     <th>Fecha</th>
    </tr>
   </thead>
  <tbody>
<%
 for (int idx = 0; idx < tutorials.size(); idx++) {
     Tutorial t = (Tutorial)tutorials.get(idx);
%>
   <tr>
    <td><%= t.getId() %></td>
    <td><%= t.getAutor() %></td>
    <td><%= t.getTutorial() %></td>
    <td><%= sdf.format(t.getFecha()) %></td>
   </tr>

<%}%>
  </tbody>
 </table>
 </body>
</html>