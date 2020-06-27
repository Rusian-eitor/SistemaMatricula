/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Matricula {
    Integer id;
    Asigna asigna;
    Alumno alumno;

    public Matricula() {
    }

    public Matricula(Integer id, Asigna asigna, Alumno alumno) {
        this.id = id;
        this.asigna = asigna;
        this.alumno = alumno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Asigna getAsigna() {
        return asigna;
    }

    public void setAsigna(Asigna asigna) {
        this.asigna = asigna;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    
}
