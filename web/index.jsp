<%-- 
    Document   : index
    Created on : 06-jun-2019, 11:24:19
    Author     : Akin Ramirez
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>CRUD JAVA ORACLE</title>
    </head>
    <body>
    <center>
         <div>
            <h3>Personas</h3>
        </div>
        
        <form method="POST" action="Controlador">
            <input type="submit" name="accion" value="Listar"> 
            <input type="submit" name="accion" value="Nuevo"> 
        </form>
        
        <hr>
        
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRES</th>
                        <th>CORREO</th>
                        <th>TELEFONO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                
                <tbody>
                    
                    <c:forEach var="dato" items="${datos}">
                        <tr>
                            <td>${dato.getId()}</td>
                            <td>${dato.getNombre()}</td>
                            <td>${dato.getCorreo()}</td>
                            <td>${dato.getTelefono()}</td>
                            <td>
                                <form action="Controlador" method="POST">
                                    <input type="hidden" name="id" value="${dato.getId()}">
                                    <input type="submit" name="accion" value="Editar">
                                    <input type="submit" name="accion" value="Eliminar">                                    
                                </form>
                            </td>
                        </tr>
                    </c:forEach>                        
                    
                </tbody>
                
            </table>
        </div>      
        
    </center>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
