<%-- 
    Document   : edit
    Created on : 06-jun-2019, 19:19:36
    Author     : Akin Ramirez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <div>
            <h3>Actualizar Personas</h3>
        </div>
        <div>
            <form action="Controlador" method="POST">
                ID:<br>
                <input type="text" name="txtid" value="${persona.getId()}"><br>
                NOMBRE:<br>
                <input type="text" name="txtnombre" value="${persona.getNombre()}"><br>
                CORREO:<br>
                <input type="email" name="txtcorreo" value="${persona.getCorreo()}"><br>
                TELEFONO:<br>
                <input type="text" name="txttelefono" value="${persona.getTelefono()}"><br><br>
                <input type="submit" name="accion" value="Actualizar">
            </form>
        </div>
    </center>
    </body>
</html>
