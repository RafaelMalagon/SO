/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import src.*;
import vista.Banderas;
import vista.Principal;
import vista.VistaAlimentadas;

/**
 *
 * @author Administrador
 */
public class Gui implements ActionListener {

    Principal vista;
    VistaAlimentadas vistaali;
    ArrayList<Recurso> recursos;
    ArrayList<Proceso> procesos;
    RetroAlimentadas alimentadas;
    Banderas banderas;
    Cola principal;

    public Gui() {
        vista = new Principal(this);
    }

    private void GenerarRecursosyprocesos() {
        setPrincipal(null);
        setProcesos(null);
        setRecursos(null);
        int nrecursos = Integer.parseInt(vista.getjTextField1());
        int nprocesos = Integer.parseInt(vista.getjTextField2());
        for (int i = 0; i < nrecursos; i++) {
            Recurso recurso = new Recurso(getAlimentadas(), i);
            getRecursos().add(recurso);
        }
        for (int i = 0; i < nprocesos; i++) {
            
            ArrayList<Recurso> recursosproceso = new ArrayList();
            int numerorecursos = (int) Math.floor(Math.random() * (getRecursos().size() - 1 + 1) + 1);
            while (recursosproceso.size() < 3) {
                boolean diferenciarecursos = true;
                for (int j = 0; j < numerorecursos; j++) {

                    int recursoaleatorio = (int) Math.floor(Math.random() * ((getRecursos().size() - 1) - 0 + 1) + 0);
                    if (j != 0 || recursosproceso.size() > 0) {
                        for (int k = 0; k < recursosproceso.size(); k++) {
                            if (recursosproceso.get(k).getId() == recursoaleatorio) {
                                diferenciarecursos = false;
                            }
                        }
                        if (diferenciarecursos) {
                            recursosproceso.add(getRecursos().get(recursoaleatorio));
                        }
                    } else {
                        recursosproceso.add(getRecursos().get(recursoaleatorio));
                    }
                }
            }
            int prioridad = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
            ArrayList<Integer> turnos = new ArrayList();
            ArrayList<Integer> quamtus = new ArrayList();
            for (int j = 0; j < recursosproceso.size(); j++) {
                turnos.add(getRecursos().get(recursosproceso.get(j).getId()).getCantidaddeturnos() + 1);
                getRecursos().get(recursosproceso.get(j).getId()).setCantidaddeturnos(getRecursos().get(recursosproceso.get(j).getId()).getCantidaddeturnos() + 1);
                quamtus.add((int) Math.floor(Math.random() * (400 - 200 + 1) + 200));
            }
            
            Proceso proceso = new Proceso(i, recursosproceso, turnos, null, prioridad, quamtus);
            getProcesos().add(proceso);
        }
        imprimirtablasprincipal();

    }

    private void llenarcola() {
        for (int i = 0; i < getProcesos().size(); i++) {
           
            getPrincipal().addProceso(getProcesos().get(i).getProceso(), getProcesos().get(i).getQuamtum(), getProcesos().get(i).getResursos(), getProcesos().get(i).getPrioridad(),null,getProcesos().get(i).getTurno());
        }
        getAlimentadas().setColatotal(getPrincipal());
        getAlimentadas().setRecursos(getRecursos());
        getAlimentadas().Orden();
    }
    public void imprimirp1() {
        ArrayList arralist1 = new ArrayList();
        if (getAlimentadas().getP1() != null) {
            getAlimentadas().getP1().aux = getAlimentadas().getP1().p.sig;//asignar direccion del primer Nodo que sigue a la cpu
            while (getAlimentadas().getP1().aux != getAlimentadas().getP1().p) {//se repite hasta encontrar el ultimo Nodo
                Object[] cola = {getAlimentadas().getP1().aux.proceso, getAlimentadas().getP1().aux.tiempo};
                arralist1.add(cola);
                getAlimentadas().getP1().aux = getAlimentadas().getP1().aux.sig;//ubicar el siguiente Nodo a mostrar
            }
        }
         getVistaali().llenarprocesos1(arralist1);
         ArrayList arralist2 = new ArrayList();
        if (getAlimentadas().getP2() != null) {
            getAlimentadas().getP2().aux = getAlimentadas().getP2().p.sig;//asignar direccion del primer Nodo que sigue a la cpu
            while (getAlimentadas().getP2().aux != getAlimentadas().getP2().p) {//se repite hasta encontrar el ultimo Nodo
                Object[] cola = {getAlimentadas().getP2().aux.proceso, getAlimentadas().getP2().aux.tiempo};
                arralist2.add(cola);
                getAlimentadas().getP2().aux = getAlimentadas().getP2().aux.sig;//ubicar el siguiente Nodo a mostrar
            }
        }
         ArrayList arralist3 = new ArrayList();
        if (getAlimentadas().getP3() != null) {
            getAlimentadas().getP3().aux = getAlimentadas().getP3().p.sig;//asignar direccion del primer Nodo que sigue a la cpu
            while (getAlimentadas().getP3().aux != getAlimentadas().getP3().p) {//se repite hasta encontrar el ultimo Nodo
                Object[] cola = {getAlimentadas().getP3().aux.proceso, getAlimentadas().getP3().aux.tiempo};
                arralist3.add(cola);
                getAlimentadas().getP3().aux = getAlimentadas().getP3().aux.sig;//ubicar el siguiente Nodo a mostrar
            }
        }
       
        getVistaali().llenarprocesos2(arralist2);
        getVistaali().llenarprocesos3(arralist3);

    }

   

    private void imprimirtablasprincipal() {
        vista.llenarprocesos(getProcesos());
        vista.llenarrecursos(getRecursos());
    }

    public ArrayList<Recurso> getRecursos() {
        if (recursos == null) {
            recursos = new ArrayList();
        }
        return recursos;
    }

    public ArrayList<Proceso> getProcesos() {
        if (procesos == null) {
            procesos = new ArrayList();
        }
        return procesos;
    }

    public RetroAlimentadas getAlimentadas() {
        if (alimentadas == null) {
            alimentadas = new RetroAlimentadas(getPrincipal(), this,getRecursos());
        }
        return alimentadas;
    }

    public Cola getPrincipal() {
        if (principal == null) {
            principal = new Cola();
            principal.nuevo();
        }
        return principal;
    }

    public void setAlimentadas(RetroAlimentadas alimentadas) {
        this.alimentadas = alimentadas;
    }

    private void Iniciar() {
        this.llenarcola();
    }

    public VistaAlimentadas getVistaali() {
        if (vistaali == null) {
            vistaali = new VistaAlimentadas(this);  
            vistaali.setVisible(true);
        }
        return vistaali;
    }
      public Banderas getBanderas() {
        if (banderas == null) {
            banderas = new Banderas(this);  
        }
        return banderas;
    }

    public void setRecursos(ArrayList<Recurso> recursos) {
        this.recursos = recursos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public void setPrincipal(Cola principal) {
        this.principal = principal;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Generar")) {
            GenerarRecursosyprocesos();
        }
        if (e.getActionCommand().equals("Iniciar")) {
            Iniciar();
        }
    }
}
