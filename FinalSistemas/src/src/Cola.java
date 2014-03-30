/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Administrador
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Cola {

    public int i, num, t_proceso;
    public Semaforo semaforo;
    ArrayList<Integer> turnos;
    public Nodo nuevo, cab, aux, aux2, aux3, p, ultimo;

    public void Cola() {
    }

    public void nuevo() {
        ArrayList<Integer> tiempo = new ArrayList();
        tiempo.add(0);
        p = new Nodo();
        p.tiempo = tiempo;
        p.proceso = 0;
        p.prioridad = 0;
        p.recursos = null;
        p.semaforo = null;
        p.sig = p;
        cab = p;
    }

    public void addProceso(int id, ArrayList<Integer> tiempo, ArrayList<Recurso> recursos, int prioridad,Semaforo semaforo,ArrayList<Integer> turnos ) {
        nuevo = new Nodo();
        nuevo.tiempo = tiempo;
        nuevo.proceso = id;
        nuevo.prioridad = prioridad;
        nuevo.recursos = recursos;
        nuevo.semaforo= semaforo;
        nuevo.turnos=turnos;
        cab.sig = nuevo;
        nuevo.sig = p;
        cab = nuevo;
        ultimo = nuevo;
    }

    public int getTotalprocesosencola() {
        int total = 0;
        aux = p.sig;
        while (aux != p) {//se repite hasta encontrar el ultimo Nodo
            aux = aux.sig;//ubicar el siguiente Nodo a mostrar
            total++;
        }
        return total;
    }

   
}