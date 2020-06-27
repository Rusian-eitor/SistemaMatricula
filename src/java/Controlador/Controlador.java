/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.AlumnoDAO;
import Modelo.Asigna;
import Modelo.AsignaDAO;
import Modelo.Curso;
import Modelo.CursoDAO;
import Modelo.Docente;
import Modelo.DocenteDAO;
import Modelo.Matricula;
import Modelo.MatriculaDAO;
import Modelo.Salon;
import Modelo.SalonDAO;
import Modelo.Semestre;
import Modelo.SemestreDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Usuario
 */
public class Controlador extends HttpServlet {


    Docente d =new Docente();
    Docente d1 =new Docente();
    DocenteDAO ddao=new DocenteDAO();
    int idd;
    Alumno a=new Alumno();
    Alumno al=new Alumno();
    AlumnoDAO adao= new AlumnoDAO();
    int ida;
    Curso c=new Curso();
    Curso cl=new Curso();
    CursoDAO cdao=new CursoDAO();
    int idc;
    Salon s=new Salon();
    Salon sl=new Salon();
    SalonDAO sdao=new SalonDAO();
    int ids;
    Semestre se=new Semestre();
    Semestre sel=new Semestre();
    SemestreDAO sedao=new SemestreDAO();
    int idse;
    
    Asigna asigna=new Asigna();
    List<Asigna>lista=new ArrayList<>();
    int idasigna;
    
    Matricula m=new Matricula();
    List<Matricula>listam=new ArrayList<>();
    MatriculaDAO mdao=new MatriculaDAO();
    int idm; 
    
    Asigna asigna2=new Asigna();
    List<Asigna>lista2=new ArrayList<>();
    
    int item;
    String curso;
    String salon;
    String docente;
    String vacante;
    String estado;
    
    String numeroSerie;
    AsignaDAO asigdao=new AsignaDAO();
    int idu;
    


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        lista=asigdao.listar();
        listam=mdao.listarAlumno(Validar.idalumno);
        
        String usera = request.getParameter("idUsuario");
        
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if(menu.equals("Secundario")){
            request.getRequestDispatcher("Secundario.jsp").forward(request, response);
        }
        if(menu.equals("Terciario")){
            request.getRequestDispatcher("Terciario.jsp").forward(request, response);
        }
        if(menu.equals("Docente")){
            switch(accion){
                case "Listar":
                    List lista=ddao.listar();
                    request.setAttribute("docentes", lista);
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtTel");
                    String est=request.getParameter("txtEstado");
                    String user=request.getParameter("txtUser");
                    d.setDni(dni);
                    d.setNom(nom);
                    d.setTel(tel);
                    d.setEstado(est);
                    d.setUser(user);
                    ddao.agregar(d);
                    request.getRequestDispatcher("Controlador?menu=Docente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idd=Integer.parseInt(request.getParameter("id"));
                    Docente d=ddao.listarId(idd);
                    request.setAttribute("docente", d);
                    request.getRequestDispatcher("Controlador?menu=Docente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String tel1=request.getParameter("txtTel");
                    String est1=request.getParameter("txtEstado");
                    String user1=request.getParameter("txtUser");
                    d1.setDni(dni1);
                    d1.setNom(nom1);
                    d1.setTel(tel1);
                    d1.setEstado(est1);
                    d1.setUser(user1);
                    d1.setId(idd);
                    ddao.actualizar(d1);
                    request.getRequestDispatcher("Controlador?menu=Docente&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idd=Integer.parseInt(request.getParameter("id"));
                    ddao.delete(idd);
                    request.getRequestDispatcher("Controlador?menu=Docente&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Docente.jsp").forward(request, response);
        }
        if(menu.equals("DocenteSecundario")){
             switch(accion){
                case "ListarUser":
                    Docente asd=new Docente();
                    asd=ddao.listarId(Validar.iddocente);
                    List lista1=new ArrayList();
                    lista1.add(asd);
                    request.setAttribute("docentes", lista1);
                    break;
                case "Editar":
                    idd=Integer.parseInt(request.getParameter("id"));
                    Docente d=ddao.listarId(idd);
                    request.setAttribute("docente", d);
                    request.getRequestDispatcher("Controlador?menu=DocenteSecundario&accion=ListarUser").forward(request, response);
                    break;
                case "Actualizar":
                    String tel1=request.getParameter("txtTel");
                    String user1=request.getParameter("txtUser");
                    d1.setTel(tel1);
                    d1.setUser(user1);
                    d1.setId(idd);
                    ddao.actualizarSecundario(d1);
                    request.getRequestDispatcher("Controlador?menu=DocenteSecundario&accion=ListarUser").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            } 
            request.getRequestDispatcher("DocenteSecundario.jsp").forward(request, response);
        }
        if(menu.equals("Alumno")){
             switch(accion){
                case "Listar":
                    List lista=adao.listar();
                    request.setAttribute("alumnos", lista);
                    break;
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String dir=request.getParameter("txtDireccion");
                    String cor=request.getParameter("txtCorreo");
                    String est=request.getParameter("txtEstado");
                    a.setDni(dni);
                    a.setNom(nom);
                    a.setDireccion(dir);
                    a.setCorreo(cor);
                    a.setEstado(est);
                    adao.agregar(a);
                    request.getRequestDispatcher("Controlador?menu=Alumno&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ida=Integer.parseInt(request.getParameter("id"));
                    Alumno a=adao.listarId(ida);
                    request.setAttribute("alumno", a);
                    request.getRequestDispatcher("Controlador?menu=Alumno&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String dir1=request.getParameter("txtDireccion");
                    String cor1=request.getParameter("txtCorreo");
                    String est1=request.getParameter("txtEstado");
                    al.setDni(dni1);
                    al.setNom(nom1);
                    al.setDireccion(dir1);
                    al.setCorreo(cor1);
                    al.setEstado(est1);
                    al.setId(ida);
                    adao.actualizar(al);
                    request.getRequestDispatcher("Controlador?menu=Alumno&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ida=Integer.parseInt(request.getParameter("id"));
                    adao.delete(ida);
                    request.getRequestDispatcher("Controlador?menu=Alumno&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            } 
            request.getRequestDispatcher("Alumno.jsp").forward(request, response);
        }
        if(menu.equals("AlumnoSecundario")){
             switch(accion){
                case "ListarUser":      
                    //idu=Integer.parseInt(usera);
                    Alumno asd=new Alumno();
                    asd=adao.listarId(Validar.idalumno);
                    List lista1=new ArrayList();
                    lista1.add(asd);
                    request.setAttribute("alumnos", lista1);
                    break;
                case "Editar":
                    ida=Integer.parseInt(request.getParameter("id"));
                    Alumno a=adao.listarId(ida);
                    request.setAttribute("alumno", a);
                    request.getRequestDispatcher("Controlador?menu=AlumnoSecundario&accion=ListarUser").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String dir1=request.getParameter("txtDireccion");
                    String cor1=request.getParameter("txtCorreo");
                    String est1=request.getParameter("txtEstado");
                    al.setDni(dni1);
                    al.setNom(nom1);
                    al.setDireccion(dir1);
                    al.setCorreo(cor1);
                    al.setEstado(est1);
                    al.setId(ida);
                    adao.actualizarSecundario(al);
                    request.getRequestDispatcher("Controlador?menu=AlumnoSecundario&accion=ListarUser").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            } 
            request.getRequestDispatcher("AlumnoSecundario.jsp").forward(request, response);
        }
        if(menu.equals("Curso")){
             switch(accion){
                case "Listar":
                    List lista=cdao.listar();
                    request.setAttribute("cursos", lista);
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombre");
                    String est=request.getParameter("txtEstado");
                    c.setNom(nom);
                    c.setEstado(est);
                    cdao.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Curso&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc=Integer.parseInt(request.getParameter("id"));
                    Curso c=cdao.listarId(idc);
                    request.setAttribute("curso", c);
                    request.getRequestDispatcher("Controlador?menu=Curso&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1=request.getParameter("txtNombre");
                    String est1=request.getParameter("txtEstado");
                    cl.setNom(nom1);
                    cl.setEstado(est1);
                    cl.setId(idc);
                    cdao.actualizar(cl);
                    request.getRequestDispatcher("Controlador?menu=Curso&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Curso&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Curso.jsp").forward(request, response);
        }
        if(menu.equals("Salon")){
            switch(accion){
                case "Listar":
                    List lista=sdao.listar();
                    request.setAttribute("salones", lista);
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombre");
                    String vac=request.getParameter("txtVacante");
                    s.setNom(nom);
                    s.setVacante(vac);
                    sdao.agregar(s);
                    request.getRequestDispatcher("Controlador?menu=Salon&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ids=Integer.parseInt(request.getParameter("id"));
                    Salon s=sdao.listarId(ids);
                    request.setAttribute("salon", s);
                    request.getRequestDispatcher("Controlador?menu=Salon&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1=request.getParameter("txtNombre");
                    String vac1=request.getParameter("txtVacante");
                    sl.setNom(nom1);
                    sl.setVacante(vac1);
                    sl.setId(ids);
                    sdao.actualizar(sl);
                    request.getRequestDispatcher("Controlador?menu=Salon&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ids=Integer.parseInt(request.getParameter("id"));
                    sdao.delete(ids);
                    request.getRequestDispatcher("Controlador?menu=Salon&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Salon.jsp").forward(request, response);
        }
        if(menu.equals("Semestre")){
             switch(accion){
                case "Listar":
                    List lista=sedao.listar();
                    request.setAttribute("semestres", lista);
                    break;
                case "Agregar":
                    String nom=request.getParameter("txtNombre");
                    String est=request.getParameter("txtEstado");
                    se.setNom(nom);
                    se.setEstado(est);
                    sedao.agregar(se);
                    request.getRequestDispatcher("Controlador?menu=Semestre&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idse=Integer.parseInt(request.getParameter("id"));
                    Semestre se=sedao.listarId(idse);
                    request.setAttribute("semestre", se);
                    request.getRequestDispatcher("Controlador?menu=Semestre&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1=request.getParameter("txtNombre");
                    String est1=request.getParameter("txtEstado");
                    sel.setNom(nom1);
                    sel.setEstado(est1);
                    sel.setId(idse);
                    sedao.actualizar(sel);
                    request.getRequestDispatcher("Controlador?menu=Semestre&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idse=Integer.parseInt(request.getParameter("id"));
                    sedao.delete(idse);
                    request.getRequestDispatcher("Controlador?menu=Semestre&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Semestre.jsp").forward(request, response);
        }
        if(menu.equals("RegistrarMatricula")){
            
            switch(accion){
                case "Matricular":
                    Asigna as=new Asigna();
                    idasigna=Integer.parseInt(request.getParameter("id"));
                    as=asigdao.listarId(idasigna);
                    int vacante=Integer.parseInt(as.getSalon().getVacante())-1;
                    sdao.actualizarVacante(as.getSalon().getId(), vacante);
                    
                    Matricula ma=new Matricula();
                    ma.setAsigna(as);
                    al=adao.listarId(Validar.idalumno);
                    ma.setAlumno(al);
                    mdao.guardarMatricula(ma);
                    ma=mdao.listarIdAsigna(idasigna);
                    
                    lista=asigdao.listar();
                    listam.add(ma);
                    request.setAttribute("lista", lista);
                    request.setAttribute("listam", listam);
                    request.getRequestDispatcher("RegistrarMatricula.jsp").forward(request, response);
                    break;
                case "Desmatricular":
                    Matricula m=new Matricula();
                    idm=Integer.parseInt(request.getParameter("id"));
                    m=mdao.listarId(idm);
                    
                    int vacante1=Integer.parseInt(m.getAsigna().getSalon().getVacante())+1;
                    sdao.actualizarVacante(m.getAsigna().getSalon().getId(), vacante1);
                    
                    mdao.delete(idm);

                    lista=asigdao.listar();
                    listam=mdao.listarAlumno(Validar.idalumno);
                    request.setAttribute("lista", lista);
                    request.setAttribute("listam", listam);
                    break;
                default:
                   request.setAttribute("lista", lista);
                   request.setAttribute("listam", listam);
                   request.getRequestDispatcher("RegistrarMatricula.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarMatricula.jsp").forward(request, response);
        }
        if(menu.equals("RegistrarCurso")){
            switch(accion){
                case "BuscarDocente":
                    String dni=request.getParameter("codigodocente");
                    d.setDni(dni);
                    d=ddao.buscar(dni);
                    request.setAttribute("d", d);
                    request.setAttribute("curso", c);
                    request.setAttribute("salon", s);
                    request.setAttribute("lista", lista);
                   request.setAttribute("nserie", numeroSerie);
                   
                    break;
                case "BuscarCurso":
                    int id=Integer.parseInt(request.getParameter("codigocurso"));
                    c=cdao.listarId(id);
                    request.setAttribute("d", d);
                    request.setAttribute("curso", c);
                    request.setAttribute("salon", s);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroSerie);
                    break;
                case "BuscarSalon":
                    int id1=Integer.parseInt(request.getParameter("codigosalon"));
                    s=sdao.listarId(id1);  
                    request.setAttribute("d", d);
                    request.setAttribute("curso", c);
                    request.setAttribute("salon", s);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroSerie);
                    break;
                case "Agregar":
                    item++;
                    asigna=new Asigna();
                    asigna.setItem(item);
                    asigna.setCurso(c);
                    asigna.setSalon(s);
                    asigna.setDocente(d);
                    asigna.setNumSerie(numeroSerie);
                    asigna.setVacante(s.getVacante());
                    asigna.setEstado("1");
                    asigdao.guardarAsigna(asigna);
                    lista.add(asigna);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroSerie);
                    c=new Curso();
                    d=new Docente();
                    s=new Salon();
                    break;
                default:
                   numeroSerie=asigdao.GenerarSerie();
                   if(numeroSerie==null){
                       numeroSerie="00000001";
                       request.setAttribute("nserie", numeroSerie);
                   }else{
                       int incrementar=Integer.parseInt(numeroSerie);
                       GenerarSerie gs=new GenerarSerie();
                       numeroSerie=gs.NumeroSerie(incrementar);
                       request.setAttribute("nserie", numeroSerie);
                   }
                   request.setAttribute("lista", lista);
                   request.getRequestDispatcher("RegistrarCurso.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarCurso.jsp").forward(request, response);
        }
        
        if(menu.equals("RegistrarCursoSecundario")){
            switch(accion){
                
                case "Agregar":
                    break;
                default:
                   lista=asigdao.listarDocente(Validar.iddocente);
                   request.setAttribute("lista", lista);
                   request.getRequestDispatcher("RegistrarCursoSecundario.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarCursoSecundario.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
