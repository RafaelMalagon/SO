/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import GUI.Gui;
import java.util.ArrayList;
//import javax.swing.JOptionPane;

/**
 *

 */
public class Roundrobin extends Thread {

    private Cola listos;
    private Cola suspendidos;
    private Cola bloqueados;
    private RetroAlimentadas alimentadas;
    ArrayList<Recurso> recursos;
    int quantum;

    public Roundrobin(Cola listos, Cola bloqueados, Cola suspendidos, RetroAlimentadas alimentadas, ArrayList<Recurso> recursos) {
        this.listos = listos;
        this.bloqueados = bloqueados;
        this.suspendidos = suspendidos;
        this.alimentadas = alimentadas;
        this.recursos = recursos;
        start();
    }

    public int getQuantum(int pocision) {
        quantum = 0;
        int contador = 0;
        getListos().aux3 = getListos().p.sig;//asignar direccion del primer Nodo que sigue a la cpu
        while (getListos().aux3 != getListos().p) {//se repite hasta encontrar el ultimo Nodo
            try {
                quantum += getListos().aux3.tiempo.get(pocision);
            } catch (Exception ex) {
                contador--;
            }
            getListos().aux3 = getListos().aux3.sig;//ubicar el siguiente Nodo a mostrar
            contador++;
        }
        
        if (contador != 0) {
            quantum = quantum / contador;
            
        }
        int quatuna=(int) Math.floor(Math.random() * (5 - 1  + 1) +1 );
        if(quatuna==3){
        quantum=500;
        System.out.println("contador: "+quantum);
        }
        return quantum;
    }

    public void run() {
        boolean condicion = true;
        while (condicion) {
            if (getRecursos().get(0) != null) 
                Zonacritica(getRecursos().get(0));
            

            if (getRecursos().get(1) != null) 
                Zonacritica(getRecursos().get(1));
            

            if (getRecursos().get(2) != null) 
                Zonacritica(getRecursos().get(2));
            

            if (getRecursos().get(3) != null) 
                Zonacritica(getRecursos().get(3));
           
            if (getRecursos().get(4) != null) 
                Zonacritica(getRecursos().get(4));
            

            try{ 
                Zonacritica(getRecursos().get(5));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(6));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(7));
            }catch(Exception ex){}
            try{
                Zonacritica(getRecursos().get(8));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(9));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(10));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(11));
            }catch(Exception ex){}
            try{
                Zonacritica(getRecursos().get(12));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(13));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(14));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(15));
            }catch(Exception ex){}
            try{
                Zonacritica(getRecursos().get(16));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(17));
            }catch(Exception ex){}

            try{
                Zonacritica(getRecursos().get(19));
            }catch(Exception ex){} 

            }
        }
    

    public void Zonacritica(Recurso Recurso) {
        
        getListos().aux2 = getListos().p.sig;//asignar direccion del primer Nodo que sigue a la cpu
        int numlistos = 0;
        while (getListos().aux2 != getListos().p) {//se repite hasta encontrar el ultimo Nodo
            numlistos++;
            getListos().aux2 = getListos().aux2.sig;//ubicar el siguiente Nodo a mostrar
        }
        getListos().aux = getListos().p.sig;
        //System.out.println(getListos().aux.recursos.size());
        if (numlistos == 1) {
            System.out.println("casi acaba");
            
            
               getListos().aux = getListos().p.sig;
                try {
                    Semaforo semaforo = new Semaforo(getListos().aux, Recurso);
                    getListos().aux.setSemaforo(semaforo);
                    getListos().aux.getSemaforo().start();
                    getListos().p.sig = getListos().aux.sig;
                            
                        } catch (Exception error) {
                            System.out.println(error);
                            getListos().aux.setSemaforo(null);
                          
                        }
               getListos().p.sig=getListos().aux.sig;
            
            
        } else {
            for (int m = 0; m < getListos().aux.recursos.size(); m++) {
           
                if(getListos().aux.recursos.get(m).equals(Recurso)){
                if (getListos().aux.getSemaforo() == null) {
                    Semaforo semaforo = new Semaforo(getListos().aux, getListos().aux.recursos.get(m));
                    getListos().aux.setSemaforo(semaforo);
                }
                System.out.println(getQuantum(m)+" posicion "+m);
                if (getQuantum(m) >= getListos().aux.tiempo.get(m)) {
                       // getAlimentadas().getGui().getBanderas().llenartitulo("Seccion Ciritica");
                       // getAlimentadas().getGui().getBanderas().llenartexto(getAlimentadas().getGui().getBanderas().texto() + getListos().aux.recursos.get(m).getId() + ":" + getListos().aux.proceso + "\n");
                      //getAlimentadas().getGui().getBanderas().setVisible(true);
                        try {
                            getListos().aux.getSemaforo().start();
                            getListos().aux.tiempo.remove(m);
                            getListos().aux.recursos.remove(m);
                            
                        } catch (Exception error) {
                            System.out.println(error);
                            getListos().aux.setSemaforo(null);
                          
                        }

                    } else {
                        getSuspendidos().addProceso(getListos().aux.proceso, getListos().aux.tiempo, getListos().aux.recursos, getListos().aux.prioridad, getListos().aux.semaforo, getListos().aux.turnos);
                          getListos().p.sig = getListos().aux.sig;
                    }
                
                }
            }
        }

        if (numlistos < 5) {
            int numsuspendidos = 0;
            getSuspendidos().aux2 = getSuspendidos().p.sig;
            while (getSuspendidos().aux2 != getSuspendidos().p) {//se repite hasta encontrar el ultimo Nodo
                numsuspendidos++;
                getSuspendidos().aux2 = getSuspendidos().aux2.sig;//ubicar el siguiente Nodo a mostrar

            }

            for (int i = 0; i < numsuspendidos; i++) {
                getSuspendidos().aux = getSuspendidos().p.sig;
                getSuspendidos().p.sig = getSuspendidos().aux.sig;
                getListos().addProceso(getSuspendidos().aux.proceso, getSuspendidos().aux.tiempo, getSuspendidos().aux.recursos, getSuspendidos().aux.prioridad, getSuspendidos().aux.semaforo, getListos().aux.turnos);
            }
            setSuspendidos(null);
            getSuspendidos();

        }
        if(getListos().aux.tiempo.size()==0){
        getListos().p.sig = getListos().aux.sig;
        }try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alimentadas.comprobartiempo();
        if (numlistos == 1) {
            stop();
        }
        
    }

    public Cola getSuspendidos() {
        if (suspendidos == null) {
            suspendidos = new Cola();
            suspendidos.nuevo();
        }
        return suspendidos;
    }

    public Cola getBlockeados() {

        return bloqueados;
    }

    public Cola getListos() {
        if (listos == null) {
            listos = new Cola();
            listos.nuevo();
        }
        return listos;
    }

    public ArrayList<Recurso> getRecursos() {
        return recursos;
    }

    public RetroAlimentadas getAlimentadas() {
        return alimentadas;
    }

    public void setSuspendidos(Cola suspendido) {
        suspendidos = suspendido;
    }
}
