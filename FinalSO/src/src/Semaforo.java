/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import vista.SCritica;

/**
 *
 * @author Administrador
 */
public class Semaforo extends Thread {

    Nodo nodo;
    Recurso recurso;

    public Semaforo(Nodo nodo, Recurso recurso) {
        this.nodo = nodo;
        this.recurso = recurso;
    }

    public void run() {
        while (true) {

            try {
                nodo.setRecurso(recurso);
                SCritica critica = new SCritica();
                System.out.println();
                critica.activar();
                critica.setjTextArea1("esta en uso el recurso: " + recurso.getId()+"\npor el proceso: "+nodo.proceso);
                critica.setVisible(true);
                Thread.sleep(5000);
                nodo.setRecurso(null);
                critica.setVisible(false);
                critica = null;
                nodo.setSemaforo(null);
                stop();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
