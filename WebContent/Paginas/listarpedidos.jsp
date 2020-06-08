<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Pedidos</title>
</head>
<body>
	<c:set var="lista" scope="request" value="${pedidos}" />
	<h1>Lista de pedidos</h1>

	<table>
		<tr>
			<td><strong>Numero</strong></td>
			<td><strong>Fecha</strong></td>
			<td><strong>Cliente</strong></td>
			<td><strong>Total</strong></td>
			<td><strong>Observaciones</strong></td>
		</tr>
		<c:forEach var="p" items="${lista}">
			<tr>
				<td>${p.numero}</td>				
				<td>${p.fecha}</td>
				<td>${p.cliente}</td>
				<td>${p.total}</td>
				<td>${p.observaciones}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/Recuperacion2/index.html">Regresar al index</a>
</body>
</html>