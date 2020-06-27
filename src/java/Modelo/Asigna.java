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
public class Asigna {
    Integer id;
    Integer item;
    //Integer iddocente;
    //Integer idcurso;
    //Integer idsalon;
    Integer idalumno;
    Docente docente;
    Curso curso;
    Salon salon;
    String NumSerie;
    String vacante;
    String estado;

    public Asigna() {
    }

    public Asigna(Integer id, Integer item, Integer idalumno, Docente docente, Curso curso, Salon salon, String NumSerie, String vacante, String estado) {
        this.id = id;
        this.item = item;
        this.idalumno = idalumno;
        this.docente = docente;
        this.curso = curso;
        this.salon = salon;
        this.NumSerie = NumSerie;
        this.vacante = vacante;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String NumSerie) {
        this.NumSerie = NumSerie;
    }

    public String getVacante() {
        return vacante;
    }

    public void setVacante(String vacante) {
        this.vacante = vacante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
