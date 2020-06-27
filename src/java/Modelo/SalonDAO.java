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
public class SalonDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    public List listar(){
        String sql="select * from salon";
        List<Salon> lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Salon sal=new Salon();
                sal.setId(rs.getInt(1));
                sal.setNom(rs.getString(2));
                sal.setVacante(rs.getString(3));
                lista.add(sal);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Salon s) {
        String sql="insert into salon(Nombre, Vacante)values(?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,s.getNom());
            ps.setString(2,s.getVacante());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Salon listarId(int id){
        Salon s=new Salon();
        String sql="select * from salon where IdSalon="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                s.setId(rs.getInt(1));
                s.setNom(rs.getString(2));
                s.setVacante(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return s;
    }
    
    public int actualizarVacante(int id, int vacante){
        String sql="update salon set Vacante=? where IdSalon=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, vacante);
            ps.setInt(2, id);
            ps.executeUpdate();
            while(rs.next()){
                
            }
        } catch (Exception e) {
        }
        return r;
    }
    
    public int actualizar(Salon s) {
        String sql="update salon set Nombre=?, Vacante=? where IdSalon=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,s.getNom());
            ps.setString(2,s.getVacante());
            ps.setInt(3,s.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id) {
        String sql="delete from salon where IdSalon="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
