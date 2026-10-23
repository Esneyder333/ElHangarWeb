
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String nombre = request.getParameter("nombre");
        String marca = request.getParameter("marca");
        String tipo = request.getParameter("tipo");
        String precio = request.getParameter("precio");
        String existencia = request.getParameter("existencia");

        PrintWriter salida = response.getWriter();

        salida.println("<!DOCTYPE html>");
        salida.println("<html lang='es'>");
        salida.println("<head>");
        salida.println("<meta charset='UTF-8'>");
        salida.println("<title>Producto registrado</title>");
        salida.println("<style>");
        salida.println("body{font-family:Arial;background:#1c1c1c;color:white;text-align:center;padding:30px}");
        salida.println(".caja{background:#2b2b2b;padding:25px;max-width:500px;margin:auto;border-radius:10px}");
        salida.println("h1{color:#f3af1a}");
        salida.println("a{display:inline-block;background:#f3af1a;color:black;padding:12px;margin:10px;text-decoration:none;border-radius:5px}");
        salida.println("</style>");
        salida.println("</head><body>");
        salida.println("<div class='caja'>");
        salida.println("<h1>Producto recibido correctamente</h1>");
        salida.println("<p><b>Nombre:</b> " + escapar(nombre) + "</p>");
        salida.println("<p><b>Marca:</b> " + escapar(marca) + "</p>");
        salida.println("<p><b>Tipo:</b> " + escapar(tipo) + "</p>");
        salida.println("<p><b>Precio:</b> $" + escapar(precio) + "</p>");
        salida.println("<p><b>Existencia:</b> " + escapar(existencia) + "</p>");
        salida.println("<a href='registro.html'>Registrar otro</a>");
        salida.println("<a href='index.html'>Inicio</a>");
        salida.println("</div></body></html>");
    }

    private String escapar(String texto) {
        if (texto == null) {
            return "";
        }

        return texto.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
