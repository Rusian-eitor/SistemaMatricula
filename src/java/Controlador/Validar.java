/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Admi;
import Modelo.AdmiDAO;
import Modelo.Alumno;
import Modelo.AlumnoDAO;
import Modelo.Docente;
import Modelo.DocenteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class Validar extends HttpServlet {

    DocenteDAO edao=new DocenteDAO();
    Docente em=new Docente();
    
    AlumnoDAO adao=new AlumnoDAO();
    Alumno al=new Alumno();
    
    AdmiDAO addao=new AdmiDAO();
    Admi ad=new Admi();
    
    public static int idalumno;
    public static int iddocente;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Ingresar")){
                String user=request.getParameter("txtuser");
                String pass=request.getParameter("txtpass");
                em=edao.validar(user, pass);
                al=adao.validar(user, pass);
                ad=addao.validar(user, pass);
                if(ad.getUser()!=null){
                    request.setAttribute("usuario", ad);
                    request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                    
                }
                else if(em.getUser()!=null){
                    iddocente=em.getId();
                    request.setAttribute("usuario", em);
                    request.getRequestDispatcher("Controlador?menu=Terciario").forward(request, response);
                }
                else if(al.getEstado()!=null){
                    idalumno=al.getId();
                    request.setAttribute("usuario", al);
                    request.getRequestDispatcher("Controlador?menu=Secundario").forward(request, response);
                }
              
                else{
                 request.getRequestDispatcher("index.jsp").forward(request, response);
                }
        }else{
                request.getRequestDispatcher("index.jsp").forward(request, response);   
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
