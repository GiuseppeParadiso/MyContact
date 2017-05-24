<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Salva nuovo contatto</title>
</head>
<body>
	<form action="save" method="post">
		<div>
			<label>Nome</label>
			<input type="text" id="nome" name="nome" required>
			
			<label>Cognome</label>
			<input type="text" id="cognome" name="cognome" required>
			
			<label>Telefono</label>
			<input type="text" id="telefono" name="telefono" required>
			
			<label>Email</label>
			<input type="text" id="email" name="email">
		</div>
	
		<input type="submit" value="Salva" id="salva">
	</form>
</body>
</html>