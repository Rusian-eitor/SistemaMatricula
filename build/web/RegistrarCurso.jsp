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
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador?menu=RegistrarCurso" method="POST">
                    <div class="card-body">
                        <div class="form-group">
                            <label>Datos del docente</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-7 d-flex">
                                <input type="text" name="codigodocente" value="${d.getDni()}" class="form-control" placeholder="Codigo">
                                <input type="submit" name="accion" value="BuscarDocente" class="btn btn-outline-info">
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombresdocente" value="${d.getNom()}" class="form-control">
                            </div> 
                        </div>
                        
                        <div class="form-group">
                            <label>Datos del curso</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-7 d-flex">
                                <input type="text" name="codigocurso" value="${curso.getId()}" class="form-control" placeholder="Codigo">
                                <button type="submit" name="accion" value="BuscarCurso" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombrecurso" value="${curso.getNom()}" class="form-control">
                            </div> 
                        </div>
                        
                        <div class="form-group">
                            <label>Datos del salón</label>
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-7 d-flex">
                                <input type="text" name="codigosalon" value="${salon.getId()}" class="form-control" placeholder="Codigo">
                                <button type="submit" name="accion" value="BuscarSalon" class="btn btn-outline-info">Buscar</button>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" name="nombresalon" value="${salon.getNom()}" class="form-control">
                            </div> 
                        </div>
                        <div class="form-group d-flex">
                            <div class="col-sm-3 d-flex">
                                <input type="number" name="vacante" value="${salon.getVacante()}" class="form-control" placeholder="Vacantes">
                            </div>
                        </div> 
                        <div class="form-group">
                            <div>
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-body">
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Curso</th>
                                    <th>Salon</th>
                                    <th>Docente</th>
                                    <th>Vacantes</th>
                                    <th>Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="list" items="${lista}"> 
                                 <tr>
                                    <td>${list.getId()}</td>
                                    <td>${list.getCurso().getNom()}</td>
                                    <td>${list.getSalon().getNom()}</td>
                                    <td>${list.getDocente().getNom()}</td>
                                    <td>${list.getSalon().getVacante()}</td>
                                   
                                    <td>
                                        <a href="#" class="btn btn-warning">Editar</a>
                                        <a href="#" class="btn btn-danger">Eliminar</a>
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
