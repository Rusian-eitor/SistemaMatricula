/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Validar;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class MatriculaDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public int guardarMatricula(Matricula m){
        String sql="insert into detalle(IdCursoSalon, IdAlumno) values(?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, m.getAsigna().getId());
            ps.setInt(2, Validar.idalumno);
            ps.executeUpdate();
            while(rs.next()){
                
            }
        }catch(Exception e){
            
        }
        return r;
    }
    
    public List listar(){
        String sql="select * from detalle";
        List<Matricula> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id;
                id=rs.getInt(1);
                Asigna a=new Asigna();
                AsignaDAO cdao=new AsignaDAO();
                a=cdao.listarId(rs.getInt(2));
                
                Alumno s=new Alumno();
                AlumnoDAO sdao=new AlumnoDAO();
                s=sdao.listarId(rs.getInt(3));
                
                Matricula m=new Matricula();
                m.setId(id);
                m.setAsigna(a);
                m.setAlumno(s);
                lista.add(m);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List listarAlumno(int idalumno){
        String sql="select * from detalle where IdAlumno="+idalumno;
        List<Matricula> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id;
                id=rs.getInt(1);
                Asigna a=new Asigna();
                AsignaDAO cdao=new AsignaDAO();
                a=cdao.listarId(rs.getInt(2));
                
                Alumno s=new Alumno();
                AlumnoDAO sdao=new AlumnoDAO();
                s=sdao.listarId(rs.getInt(3));
                
                Matricula m=new Matricula();
                m.setId(id);
                m.setAsigna(a);
                m.setAlumno(s);
                lista.add(m);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public Matricula listarId(int iddet){
        Matricula m=new Matricula();
        String sql="select * from detalle where IdDetalle="+iddet;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id;
                id=rs.getInt(1);
                m.setId(id);
                
                Asigna c=new Asigna();
                AsignaDAO cdao=new AsignaDAO();
                c=cdao.listarId(rs.getInt(2));
                
                Alumno s=new Alumno();
                AlumnoDAO sdao=new AlumnoDAO();
                s=sdao.listarId(rs.getInt(3));
                
                m.setAsigna(c);
                m.setAlumno(s);
            }
        } catch (Exception e) {
        }
        return m;
    }
     
    public Matricula listarIdAsigna(int iddet){
        Matricula m=new Matricula();
        String sql="select * from detalle where IdCursoSalon="+iddet;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id;
                id=rs.getInt(1);
                m.setId(id);
                
                Asigna c=new Asigna();
                AsignaDAO cdao=new AsignaDAO();
                c=cdao.listarId(rs.getInt(2));
                
                Alumno s=new Alumno();
                AlumnoDAO sdao=new AlumnoDAO();
                s=sdao.listarId(rs.getInt(3));
                
                m.setAsigna(c);
                m.setAlumno(s);
            }
        } catch (Exception e) {
        }
        return m;
    }
    
     public void delete(int id) {
        String sql="delete from detalle where IdDetalle="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
