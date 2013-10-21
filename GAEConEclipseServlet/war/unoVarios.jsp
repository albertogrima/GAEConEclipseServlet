<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.grima.Autor" %>
<%@ page import="com.grima.AutorUtils" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.grima.ContactosAutor" %>
<%@ page import="com.grima.PMF" %>
<%@ page import="javax.jdo.PersistenceManager" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Autor entrada = new Autor();
entrada.setPersonalInfo(new Autor.infoPersonal("variosNumeros", "variosNumeros"));
entrada.setInfoDireccion(new Autor.infoDireccion("variosNumeros", "variosNumeros", "variosNumeros",
		"variosNumeros", "variosNumeros", "variosNumeros"));

ContactosAutor contactosAutor = new ContactosAutor();
contactosAutor.setInfoContacto(new ContactosAutor.infoContacto("124123123"));
entrada.getContactos().add(contactosAutor);
ContactosAutor contactosAutor2 = new ContactosAutor();
contactosAutor2.setInfoContacto(new ContactosAutor.infoContacto("123123123"));
entrada.getContactos().add(contactosAutor2);

PersistenceManager pm = PMF.get().getPersistenceManager();
		
pm.currentTransaction().begin();
try {
    pm.makePersistent(entrada);
    pm.currentTransaction().commit();
} finally {
    if (pm.currentTransaction().isActive()) {
        pm.currentTransaction().rollback();
    }
}

%>

</body>
</html>