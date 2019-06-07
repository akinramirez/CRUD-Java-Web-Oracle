<%-- 
    Document   : add
    Created on : 06-jun-2019, 18:51:20
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
            <h3>Agregar Personas</h3>
        </div>
        <div>
            <form action="Controlador" method="POST">
                ID:<br>
                <input type="text" name="txtid"><br>
                NOMBRE:<br>
                <input type="text" name="txtnombre"><br>
                CORREO:<br>
                <input type="email" name="txtcorreo"><br>
                TELEFONO:<br>
                <input type="text" name="txttelefono"><br><br>
                <input type="submit" name="accion" value="Guardar">
                                
            </form>
        </div>
    </center>
    </body>
</html>
