/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Proceso {

    int proceso;
    ArrayList<Recurso> resursos;
    ArrayList<Integer> turno;
    ArrayList<Integer> quamtum;
    int prioridad;
    Semaforo semaforo;

    public Proceso(int proceso, ArrayList<Recurso> resursos, ArrayList<Integer> turno, Semaforo semaforo, int prioridad, ArrayList<Integer> quamtum) {
        this.proceso = proceso;
        this.resursos = resursos;
        this.turno = turno;
        this.quamtum = quamtum;
        this.semaforo = semaforo;
        this.prioridad = prioridad;
    }

    public ArrayList<Integer> getTurno() {
        return turno;
    }

    public void setTurno(ArrayList<Integer> turno) {
        this.turno = turno;
    }

    public int getProceso() {
        return proceso;
    }

    public void setQuamtum(ArrayList<Integer> quamtum) {
        this.quamtum = quamtum;
    }

    public ArrayList<Integer> getQuamtum() {
        return quamtum;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public ArrayList<Recurso> getResursos() {
        return resursos;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setProceso(int proceso) {
        this.proceso = proceso;
    }

    public void setResursos(ArrayList<Recurso> resursos) {
        this.resursos = resursos;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }
}
