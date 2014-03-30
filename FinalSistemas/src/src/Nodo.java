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
public class Nodo {

    public int proceso;
    public ArrayList<Integer> tiempo;
    public ArrayList<Recurso> recursos;
    public ArrayList<Integer> turnos;
    public Recurso recurso=null;
    public Nodo sig;
    public int prioridad;
    public Semaforo semaforo;
    public boolean banderaUtilizado;
     public Semaforo getSemaforo() {
          return semaforo;
    }
    

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }
    public Recurso getRecurso() {
        return recurso;
    }

  
}
