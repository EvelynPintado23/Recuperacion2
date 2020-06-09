<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="/Recuperacion/config/styles/stylesCrUser.css">
<script type="text/javascript"
	src="/Recuperacion/config/JS/validaciones.js"></script>
</head>
<body>
	<c:set var="total" value="${requestScope['total']}" />
	<c:set var="pedido" value="${requestScope['pedido']}" />
	<h1>Ingresar Pedido</h1>
	<form action="/Recuperacion2/IngresarPedido" method="post">
		
		<label for="nombre">Cliente: </label>
		<input type="text" name="cliente" value="${pedido.cliente}" placeholder="ingrese el nombre..."/>			
		<br/>
		
		<label for="fecha">Observaciones: </label>
		<input type="date" name="observaciones" value="${pedido.observaciones} " placeholder="ingrese la fecha"/>
		<br/>
		
		<label for="fecha">Tarjeta: </label>
		<input type="text" name="tarjeta" value="${pedido.tarjeta.numero_tarjeta }" placeholder="ingrese la fecha"/>
		<br/>
		<br>
		<label for="apellido">Total: </label>
		<label for="total">${total}</label>
		<br/>
		
		<h1>Agregar Comida</h1>
				
	
		<label for="id">Nombre: </label>
		<input type="text" name="nombre_comida" placeholder="ingrese la fecha"  "/>
		<br/>
		
		<label for="nombre">Precio: </label>
		<input type="text" value="0.0" name="precio" placeholder="ingrese el cliente"/>			
		<br/>
		
	<input type="submit" name="accion" value="Agregar"/>
		
		<h3>Datos Comida</h3>
		
		<input type="submit" name="accion" value="Realizar Pedido"/>

	</form>
</body>
</html>