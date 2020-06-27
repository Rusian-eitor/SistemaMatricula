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
public class CursoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Curso buscar(int id){
        Curso c=new Curso();
        String sql="Select * from curso where IdCurso="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               c.setId(rs.getInt(1));
               c.setNom(rs.getString(2));
               c.setEstado(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    public List listar(){
        String sql="select * from curso";
        List<Curso> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Curso cur=new Curso();
                cur.setId(rs.getInt(1));
                cur.setNom(rs.getString(2));
                cur.setEstado(rs.getString(3));
                lista.add(cur);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Curso cu) {
        String sql="insert into curso(Nombre, Estado)values(?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,cu.getNom());
            ps.setString(2,cu.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Curso listarId(int id){
        Curso c=new Curso();
        String sql="select * from curso where IdCurso="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setEstado(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return c;
    }
    public int actualizar(Curso c) {
        String sql="update curso set Nombre=?, Estado=? where IdCurso=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,c.getNom());
            ps.setString(2,c.getEstado());
            ps.setInt(3,c.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id) {
        String sql="delete from curso where IdCurso="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
