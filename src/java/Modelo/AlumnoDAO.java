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
public class AlumnoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Alumno validar(String estado, String dni){
        Alumno al=new Alumno();
        String sql="select * from alumno where Estado=? and Dni=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()){
                al.setId(rs.getInt("IdAlumno"));
                al.setDni(rs.getString("Dni"));
                al.setNom(rs.getString("Nombres"));
                al.setEstado(rs.getString("Estado"));
            }
            
        } catch (Exception e) {
        }
        return al;
    }
    
    public List listar(){
        String sql="select * from alumno";
        List<Alumno> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Alumno alu=new Alumno();
                alu.setId(rs.getInt(1));
                alu.setDni(rs.getString(2));
                alu.setNom(rs.getString(3));
                alu.setDireccion(rs.getString(4));
                alu.setCorreo(rs.getString(5));
                alu.setEstado(rs.getString(6));
                lista.add(alu);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Alumno al) {
        String sql="insert into alumno(Dni, Nombres, Direccion, Correo, Estado)values(?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,al.getDni());
            ps.setString(2,al.getNom());
            ps.setString(3,al.getDireccion());
            ps.setString(4,al.getCorreo());
            ps.setString(5,al.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Alumno listarId(int id){
        Alumno a=new Alumno();
        String sql="select * from alumno where IdAlumno="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                a.setId(rs.getInt(1));
                a.setDni(rs.getString(2));
                a.setNom(rs.getString(3));
                a.setDireccion(rs.getString(4));
                a.setCorreo(rs.getString(5));
                a.setEstado(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return a;
    }
   
    public int actualizar(Alumno a) {
        String sql="update alumno set Dni=?, Nombres=?, Direccion=?, Correo=?, Estado=? where IdAlumno=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,a.getDni());
            ps.setString(2,a.getNom());
            ps.setString(3,a.getDireccion());
            ps.setString(4,a.getCorreo());
            ps.setString(5,a.getEstado());
            ps.setInt(6,a.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int actualizarSecundario(Alumno a) {
        String sql="update alumno set Direccion=?, Correo=? where IdAlumno=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,a.getDireccion());
            ps.setString(2,a.getCorreo());
            ps.setInt(3,a.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id) {
        String sql="delete from alumno where IdAlumno="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
