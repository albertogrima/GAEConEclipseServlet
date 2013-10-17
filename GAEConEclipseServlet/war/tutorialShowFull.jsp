<%@page import="com.grima.*" %>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat" %>

<%
List<Tutorial> tutorials =TutorialesUtil.todosLosTutoriales();
SimpleDateFormat sdf = new SimpleDateFormat();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>.:: Todos los Tutoriales ::.</title>
 </head>
 <body>
  <span>
   <a href="/tutorialCreate.jsp">Registrar Tutorial</a><br>
   <a href="/index.jsp">Ir al indice</a>
  </span>
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