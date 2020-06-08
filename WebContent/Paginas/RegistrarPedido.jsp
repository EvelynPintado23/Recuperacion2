<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1>Ingresar Pedido</h1>
	<form action="/Recuperacion2/IngresarPedido" method="post">
		<label for="id">Fecha: </label>
		<input type="text" fecha="id" placeholder="ingrese el id..."/>
		<br/>
		
		<label for="nombre">Cliente: </label>
		<input type="text" name="cliente" placeholder="ingrese el nombre..."/>			
		<br/>
		
		<label for="apellido">Total: </label>
		<input type="text" name="total" placeholder="ingrese el apellido..."/>
		<br/>
		
		<label for="fecha">Observaciones: </label>
		<input type="date" name="observaciones" placeholder="ingrese la fecha"/>
		<br/>
		
		<h1>Ingresar Persona</h1>
	<form action="/EjemploPersonaWebJPA/CrearPersonaController" method="post">
		<label for="id">Fecha: </label>
		<input type="text" name="fecha" placeholder="ingrese la fecha"/>
		<br/>
		
		<label for="nombre">Cliente: </label>
		<input type="text" name="cliente" placeholder="ingrese el cliente"/>			
		<br/>
		
		<label for="apellido">Total: </label>
		<input type="text" name="total" placeholder="ingrese el apellido..."/>
		<br/>
		
		<label for="fecha">Observaciones: </label>
		<input type="date" name="observaciones" placeholder="ingrese la fecha"/>
		<br/>
		
		<label for="fecha">Tarjeta: </label>
		<input type="text" name="tarjeta" placeholder="ingrese la fecha"/>
		<br/>
		<h3>Datos Comida</h3>
		
		<input type="submit" value="Aceptar"/>
		<input type="reset" value="Cancelar"/>
	</form>
		
		<input type="submit" value="Aceptar"/>
		<input type="reset" value="Cancelar"/>

	</form>
</body>
</html>