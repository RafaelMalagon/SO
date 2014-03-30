/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import GUI.Gui;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class RetroAlimentadas {

    Cola colatotal, p1, p2, p3, bloqueado, suspendido;
    Roundrobin rr1, rr2;
    ArrayList<Recurso> recursos;
    SJF sjf;
    Gui gui;

    public RetroAlimentadas(Cola colatotal, Gui gui, ArrayList<Recurso> recursos) {
        this.colatotal = colatotal;
        this.gui = gui;
        this.recursos = recursos;

    }

    public void Orden() {
        llenarColas();
        getRr1();
    }

    public void comprobartiempo() {

        System.out.println("Desde comprobartiempo " + getRr1().getListos().p.sig.prioridad);
        if (getRr1().getListos().p.sig == getRr1().getListos().p) {
            System.out.println("Desde comprobartiempo entro");
            getRr2();
            if (getRr2().getListos().p.sig == getRr2().getListos().p) {
                System.out.println("Desde comprobartiempo rr2 entro");
                getSjf();
            }
        }

        getGui().imprimirp1();
    }

    private void llenarColas() {
        getColatotal().aux = getColatotal().p.sig;
        while (getColatotal().aux != getColatotal().p) {

            getColatotal().aux = getColatotal().aux.sig;//ubicar el siguiente Nodo a mostrar
            if (getColatotal().aux.prioridad == 1) {
                this.getP1().addProceso(getColatotal().aux.proceso, getColatotal().aux.tiempo, getColatotal().aux.recursos, getColatotal().aux.prioridad, getColatotal().aux.semaforo,getColatotal().aux.turnos);
            } else if (getColatotal().aux.prioridad == 2) {
                this.getP2().addProceso(getColatotal().aux.proceso, getColatotal().aux.tiempo, getColatotal().aux.recursos, getColatotal().aux.prioridad, getColatotal().aux.semaforo,getColatotal().aux.turnos);
            } else if (getColatotal().aux.prioridad == 3) {
                this.getP3().addProceso(getColatotal().aux.proceso, getColatotal().aux.tiempo, getColatotal().aux.recursos, getColatotal().aux.prioridad, getColatotal().aux.semaforo,getColatotal().aux.turnos);
            }
        }
    }

    public Roundrobin getRr1() {
        if (rr1 == null) {
            rr1 = new Roundrobin(getP1(), getBloqueado(), getSuspendido(), this, getRecursos());
        }
        return rr1;
    }

    public Gui getGui() {
        return gui;
    }

    public void setRr1(Roundrobin rr1) {
        this.rr1 = rr1;
    }

    public void setRr2(Roundrobin rr2) {
        this.rr2 = rr2;
    }

    public void setSjf(SJF sjf) {
        this.sjf = sjf;
    }

    public Roundrobin getRr2() {
        if (rr2 == null) {
            rr2 = new Roundrobin(getP2(), getBloqueado(), getSuspendido(), this, getRecursos());
        }
        return rr2;
    }

    public SJF getSjf() {
        if (sjf == null) {
            sjf = new SJF(getP3(), getP3().getTotalprocesosencola(), this);
        }
        return sjf;
    }

    public Cola getColatotal() {
        return colatotal;
    }

    public Cola getP1() {
        if (p1 == null) {
            p1 = new Cola();
            p1.nuevo();
        }
        return p1;
    }

    public Cola getP2() {
        if (p2 == null) {
            p2 = new Cola();
            p2.nuevo();
        }
        return p2;
    }

    public Cola getP3() {
        if (p3 == null) {
            p3 = new Cola();
            p3.nuevo();
        }
        return p3;
    }

    public Cola getBloqueado() {
        return bloqueado;
    }

    public Cola getSuspendido() {
        return suspendido;
    }

    public void setColatotal(Cola colatotal) {
        this.colatotal = colatotal;
    }

    public void setP1(Cola p1) {
        this.p1 = p1;
    }

    public void setP2(Cola p2) {
        this.p2 = p2;
    }

    public void setP3(Cola p3) {
        this.p3 = p3;
    }

    public void setBloqueado(Cola bloqueado) {
        this.bloqueado = bloqueado;
    }

    public void setRecursos(ArrayList<Recurso> recursos) {
        this.recursos = recursos;
    }

    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }

    public void setSuspendido(Cola suspendido) {
        this.suspendido = suspendido;
    }
}
