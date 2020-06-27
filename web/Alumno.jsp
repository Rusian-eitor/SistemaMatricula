<%-- 
    Document   : Docente
    Created on : 09-jun-2020, 11:35:57
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
    <div class="d-flex">
        <div class="card col-sm-4">
            <div class="card-body">
                <form action="Controlador?menu=Alumno" method="POST">
                    <div class="form-group">
                        <label>Dni</label>
                        <input type="text" value="${alumno.getDni()}" name="txtDni" class="form-control">
                    </div>
                    <div class="form-group">
                       <label>Nombres</label>
                        <input type="text" value="${alumno.getNom()}" name="txtNombres" class="form-control"> 
                    </div>
                    <div class="form-group">
                        <label>Dirección</label>
                        <input type="text" value="${alumno.getDireccion()}" name="txtDireccion" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Correo</label>
                        <input type="text" value="${alumno.getCorreo()}" name="txtCorreo" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="text" value="${alumno.getEstado()}" name="txtEstado" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
            </div>
        </div>
        <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>DNI</th>
                                    <th>NOMBRES</th>
                                    <th>DIRECCION</th>
                                    <th>CORREO</th>
                                    <th>USUARIO</th>
                                    <th>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody> 
                                <c:forEach var="alu" items="${alumnos}">
                                    <tr>
                                        <td>${alu.getId()}</td>
                                        <td>${alu.getDni()}</td>
                                        <td>${alu.getNom()}</td>
                                        <td>${alu.getDireccion()}</td>
                                        <td>${alu.getCorreo()}</td>
                                        <td>${alu.getEstado()}</td>
                                        <td>
                                            <a class="btn btn-warning" href="Controlador?menu=Alumno&accion=Editar&id=${alu.getId()}">Editar</a>
                                            <a class="btn btn-danger" href="Controlador?menu=Alumno&accion=Delete&id=${alu.getId()}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>
