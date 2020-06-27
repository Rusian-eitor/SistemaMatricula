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
public class SemestreDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public List listar(){
        String sql="select * from semestre";
        List<Semestre> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Semestre sem=new Semestre();
                sem.setId(rs.getInt(1));
                sem.setNom(rs.getString(2));
                sem.setEstado(rs.getString(3));
                lista.add(sem);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Semestre se) {
        String sql="insert into semestre(Nombre, Estado)values(?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,se.getNom());
            ps.setString(2,se.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Semestre listarId(int id){
        Semestre se=new Semestre();
        String sql="select * from semestre where IdSemestre="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                se.setNom(rs.getString(2));
                se.setEstado(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return se;
    }
    public int actualizar(Semestre se) {
        String sql="update semestre set Nombre=?, Estado=? where IdSemestre=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,se.getNom());
            ps.setString(2,se.getEstado());
            ps.setInt(3,se.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id) {
        String sql="delete from semestre where IdSemestre="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
