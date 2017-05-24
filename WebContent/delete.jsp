<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elimina Contatto</title>
</head>
<body>
	<form action="delete" method="post">
		
		<div>
			Dati Contatto da eliminare: <br>
			<label>Nome: ${contact.nome}</label><br>
			<label>Cognome: ${contact.cognome}</label><br>
			<label>Telefono: ${contact.telefono}</label><br>
			<label>Email: ${contact.email}</label><br>
		</div>
		<input type="submit" value="Conferma" id="conferma">
	</form>
</body>
</html>