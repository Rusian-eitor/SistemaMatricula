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

/**
 *
 * @author Usuario
 */
public class DocenteDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public Docente validar(String user, String dni){
        Docente em=new Docente();
        String sql="select * from docente where User=? and Dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdDocente"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNom(rs.getString("Nombres"));
            }
            
        } catch (Exception e) {
        }
        return em;
    }
    
    public Docente buscar(String dni){
        Docente d=new Docente();
        String sql="Select * from docente where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               d.setId(rs.getInt(1));
               d.setDni(rs.getString(2));
               d.setNom(rs.getString(3));
               d.setTel(rs.getString(4));
               d.setEstado(rs.getString(5));
               d.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return d;
    }
    
    public List listar(){
        String sql="select * from docente";
        List<Docente> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Docente doc=new Docente();
                doc.setId(rs.getInt(1));
                doc.setDni(rs.getString(2));
                doc.setNom(rs.getString(3));
                doc.setTel(rs.getString(4));
                doc.setEstado(rs.getString(5));
                doc.setUser(rs.getString(6));
                lista.add(doc);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Docente doc) {
        String sql="insert into docente(Dni, Nombres, Telefono, Estado, User)values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,doc.getDni());
            ps.setString(2,doc.getNom());
            ps.setString(3,doc.getTel());
            ps.setString(4,doc.getEstado());
            ps.setString(5,doc.getUser());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Docente listarId(int id){
        Docente d=new Docente();
        String sql="select * from docente where IdDocente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                d.setId(rs.getInt(1));
                d.setDni(rs.getString(2));
                d.setNom(rs.getString(3));
                d.setTel(rs.getString(4));
                d.setEstado(rs.getString(5));
                d.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return d;
    }
    public int actualizar(Docente d) {
        String sql="update docente set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdDocente=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,d.getDni());
            ps.setString(2,d.getNom());
            ps.setString(3,d.getTel());
            ps.setString(4,d.getEstado());
            ps.setString(5,d.getUser());
            ps.setInt(6,d.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int actualizarSecundario(Docente a) {
        String sql="update docente set Telefono=?, User=? where IdDocente=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,a.getTel());
            ps.setString(2,a.getUser());
            ps.setInt(3,a.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id) {
        String sql="delete from docente where IdDocente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
