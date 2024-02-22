<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.bean.LibroBean"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Index</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Libri in ordine d'autore e di prezzo</h2>
		<%
		List<LibroBean> libri = (List<LibroBean>) request.getAttribute("libri");
		%>
		<table class="table">
			<tr>
				<th scope="col">Titolo</th>
				<th scope="col">Autore</th>
				<th scope="col">Prezzo</th>
				<th scope="col">Editore</th>
				<th scope="col">Genere</th>
				<th scope="col">Disponibilità</th>
			</tr>
 
			<%
			for (LibroBean libro : libri) {
			%>
			<tr>
				<td><%=libro.getTitoloLibro()%></td>
				<td><%=libro.getAutoreLibro()%></td>
				<td><%=libro.getPrezzoLibro()%></td>
				<td><%=libro.getEditoreLibro()%></td>
				<td><%=libro.getGenereLibro()%></td>
				<td><%=libro.getDisponibilitaLibro()%></td>
			</tr>
			<%
			}
			%>

		</table>



	</div>
</body>
</html>
