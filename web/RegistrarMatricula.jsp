<%-- 
    Document   : RegistrarCurso
    Created on : 17-jun-2020, 12:22:01
    Author     : Usuario
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="d-flex"> 
            <div class="col-sm-5">
                <div class="card">
                    <div class="card-body">
                        <label>CURSOS MATRICULADOS</label>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Codigo Curso</th>
                                    <th>Curso</th>
                                    <th>Salon</th>
                                    <th>Docente</th>
                                    <th>Vacantes</th>
                                    <th>Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${listam}"> 
                                 <tr>
                                    <td align="center">${list.getId()}</td>
                                    <td align="center">${list.getAsigna().getCurso().getId()}</td>
                                    <td align="center">${list.getAsigna().getCurso().getNom()}</td>
                                    <td align="center">${list.getAsigna().getSalon().getNom()}</td>
                                    <td align="center">${list.getAsigna().getDocente().getNom()}</td>
                                    <td align="center">${list.getAsigna().getSalon().getVacante()}</td> 
                                    <td>
                                        <a href="Controlador?menu=RegistrarMatricula&accion=Desmatricular&id=${list.getId()}" class="btn btn-danger">Quitar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            
                            
            <div class="col-sm-5" style="margin-left: 50px">
                <div class="card">
                    <div class="card-body">
                        <label>CURSOS DISPONIBLES</label>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th align="center">ID</th>
                                    <th align="center">Codigo Curso</th>
                                    <th align="center">Curso</th>
                                    <th align="center">Salon</th>
                                    <th align="center">Docente</th>
                                    <th align="center">Vacantes</th>
                                    <th align="center">Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${lista}"> 
                                 <tr>
                                    <td align="center">${list.getId()}</td>
                                    <td align="center">${list.getCurso().getId()}</td>
                                    <td align="center">${list.getCurso().getNom()}</td>
                                    <td align="center">${list.getSalon().getNom()}</td>
                                    <td align="center">${list.getDocente().getNom()}</td>
                                    <td align="center">${list.getSalon().getVacante()}</td> 
                                    <td>
                                        <a href="Controlador?menu=RegistrarMatricula&accion=Matricular&id=${list.getId()}" class="btn btn-danger">Agregar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
