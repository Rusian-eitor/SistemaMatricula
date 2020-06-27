/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Usuario
 */
public class AsignaDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(NumeroSerie) from curso_salon";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        }catch(Exception e){
            
        }
        return numeroserie;
    }
    
    public String IdAsigna(){
        String idasigna="";
        String sql="select max(IdCursoSalon) from curso_salon";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idasigna=rs.getString(1);
            }
        }catch(Exception e){
            
        }
        return idasigna;
    }
    
    public int guardarAsigna(Asigna a){
        String sql="insert into curso_salon(IdCurso, IdSalon, IdDocente, NumeroSerie, Vacantes, Estado) values(?,?,?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, a.getCurso().getId());
            ps.setInt(2,a.getSalon().getId());
            ps.setInt(3,a.getDocente().getId());
            ps.setString(4, a.getNumSerie());
            ps.setString(5, a.getVacante());
            ps.setString(6, a.getEstado());
            ps.executeUpdate();
            while(rs.next()){
                
            }
        }catch(Exception e){
            
        }
        return r;
    }
    
    
    public List listar(){
        String sql="select * from curso_salon";
        List<Asigna> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id;
                id=rs.getInt(1);
                Curso c=new Curso();
                CursoDAO cdao=new CursoDAO();
                c=cdao.listarId(rs.getInt(2));
                
                Salon s=new Salon();
                SalonDAO sdao=new SalonDAO();
                s=sdao.listarId(rs.getInt(3));
                
                Docente d=new Docente();
                DocenteDAO ddao=new DocenteDAO();
                d=ddao.listarId(rs.getInt(4));
                
                Asigna asigna=new Asigna();
                asigna.setId(id);
                asigna.setCurso(c);
                asigna.setSalon(s);
                asigna.setDocente(d);
                asigna.setNumSerie(rs.getString(5));
                asigna.setVacante(rs.getString(6));
                asigna.setEstado(rs.getString(7));
                lista.add(asigna);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List listarDocente(int iddocente){
        String sql="select * from curso_salon where IdDocente="+iddocente;
        List<Asigna> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id;
                id=rs.getInt(1);
                Curso c=new Curso();
                CursoDAO cdao=new CursoDAO();
                c=cdao.listarId(rs.getInt(2));
                
                Salon s=new Salon();
                SalonDAO sdao=new SalonDAO();
                s=sdao.listarId(rs.getInt(3));
                
                Docente d=new Docente();
                DocenteDAO ddao=new DocenteDAO();
                d=ddao.listarId(rs.getInt(4));
                
                Asigna asigna=new Asigna();
                asigna.setId(id);
                asigna.setCurso(c);
                asigna.setSalon(s);
                asigna.setDocente(d);
                asigna.setNumSerie(rs.getString(5));
                asigna.setVacante(rs.getString(6));
                asigna.setEstado(rs.getString(7));
                lista.add(asigna);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    
    
    public Asigna listarId(int idasigna){
        Asigna a=new Asigna();
        String sql="select * from curso_salon where IdCursoSalon="+idasigna;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id;
                id=rs.getInt(1);
                a.setId(id);
                Curso c=new Curso();
                CursoDAO cdao=new CursoDAO();
                c=cdao.listarId(rs.getInt(2));
                
                Salon s=new Salon();
                SalonDAO sdao=new SalonDAO();
                s=sdao.listarId(rs.getInt(3));
                
                Docente d=new Docente();
                DocenteDAO ddao=new DocenteDAO();
                d=ddao.listarId(rs.getInt(4));
                a.setCurso(c);
                a.setSalon(s);
                a.setDocente(d);
                a.setNumSerie(rs.getString(5));
                a.setVacante(rs.getString(6));
                a.setEstado(rs.getString(7));
            }
        } catch (Exception e) {
        }
        return a;
    }
    
    public void delete(int id) {
        String sql="delete from curso_salon where IdCursoSalon="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
