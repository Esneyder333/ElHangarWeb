
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Consulta de productos - El Hangar</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #1c1c1c;
            color: white;
            text-align: center;
            padding: 30px;
        }

        .caja {
            max-width: 600px;
            margin: auto;
            padding: 25px;
            background: #2b2b2b;
            border-radius: 10px;
        }

        h1 {
            color: #f3af1a;
        }

        input, button {
            padding: 10px;
            margin: 8px;
        }

        button, a {
            background: #f3af1a;
            color: black;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }

        .resultado {
            margin-top: 20px;
            padding: 15px;
            background: #3a3a3a;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="caja">
        <h1>Consultar productos</h1>
        <p>Consulta de prueba utilizando el método GET.</p>

        <form action="consulta.jsp" method="get">
            <label for="nombre">Nombre del producto:</label>
            <input type="text" id="nombre" name="nombre" required>
            <button type="submit">Consultar</button>
        </form>

        <%
            String nombre = request.getParameter("nombre");

            if (nombre != null && !nombre.trim().isEmpty()) {
        %>
            <div class="resultado">
                <h2>Resultado de la consulta</h2>
                <p>Producto consultado: <strong><%= nombre.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;") %></strong></p>
                <p>La solicitud se recibió correctamente mediante GET.</p>
                <p>Esta consulta es una demostración; todavía no busca datos en la base de datos.</p>
            </div>
        <%
            }
        %>

        <p><a href="index.html">Volver al inicio</a></p>
    </div>
</body>
</html>
