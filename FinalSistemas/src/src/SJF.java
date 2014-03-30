/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import GUI.Gui;

/**
 *
 * @author Administrador
 */
public class SJF extends Thread{
    Cola listos;
    Cola terminados;
    Cola blockeados;
    RetroAlimentadas alimentadas;
    private int blockeado[];
public SJF(Cola listos, int numProc,RetroAlimentadas alimentadas){
    this.listos=listos;
    this.alimentadas=alimentadas;
   
    this.getBlockeados();   
boolean cambio = false;
	    do {
	        cambio = false;
	        for (int a = 1; a < numProc; a++) {
                   if (this.listos.nuevo.tiempo.get(0) > this.listos.nuevo.sig.tiempo.get(0)) {
	                this.listos.aux.proceso = this.listos.nuevo.proceso;
                        this.listos.aux.tiempo = this.listos.nuevo.tiempo;
                        
                        this.listos.nuevo.proceso = this.listos.nuevo.sig.proceso;
                        this.listos.nuevo.tiempo = this.listos.nuevo.sig.tiempo;
                        
                        this.listos.nuevo.sig.proceso = this.listos.aux.proceso;
                        this.listos.nuevo.sig.tiempo = this.listos.aux.tiempo;
                        
                        this.listos.nuevo=this.listos.nuevo.sig;
	                cambio = true;                      
                   
                        
	            }else{
                        listos.nuevo=listos.nuevo.sig;
                    }
	        }
	    } while (cambio);

                start();
//--------borrar de lista

}
    public void run(){
    boolean condicion=true;  
    boolean blockeados=false; 
    while(condicion){
    listos.aux2=listos.p.sig;//asignar direccion del primer Nodo que sigue a la cpu
    int aux=listos.aux2.tiempo.get(0);
    int numlistos=0;
    while(listos.aux2!=listos.p){//se repite hasta encontrar el ultimo Nodo
    if(aux>listos.aux2.tiempo.get(0)){
     aux=listos.aux2.tiempo.get(0);
  }
 numlistos++;
 listos.aux2=listos.aux2.sig;//ubicar el siguiente Nodo a mostrar
}
listos.aux=listos.p.sig;
listos.p.sig=listos.aux.sig;
if(!blockeados){
//getTerminados().addProceso(listos.aux.proceso,listos.aux.tiempo);
 }else{
//    getBlockeados().addProceso(listos.aux.proceso,listos.aux.tiempo);
    blockeados=false;

     
 }
if(numlistos<5){
     int numblo=0;
     getBlockeados().aux2=getBlockeados().p.sig;
     while(getBlockeados().aux2!=getBlockeados().p){//se repite hasta encontrar el ultimo Nodo
        numblo++;
        getBlockeados().aux2=getBlockeados().aux2.sig;//ubicar el siguiente Nodo a mostrar
    
     }
      
    for(int i=0;i<numblo;i++){
     getBlockeados().aux=getBlockeados().p.sig;
     getBlockeados().p.sig=getBlockeados().aux.sig;
     //listos.addProceso(getBlockeados().aux.proceso,getBlockeados().aux.tiempo,getBlockeados().);
    }
     setBlockeados(null);
     getBlockeados();

}

try {
  Thread.sleep(1000);
   } catch (InterruptedException e) {
   e.printStackTrace();
  }
alimentadas.comprobartiempo();
if(listos.aux.proceso==listos.p.sig.proceso){
condicion=false;
this.stop();
}
}
}
public Cola getlistos(){
    
return listos;

}
 
     public void setBlockeados(Cola suspendido){
   blockeados= suspendido; 
}
     public Cola  getBlockeados(){
     if(blockeados==null){
     blockeados = new Cola();
     blockeados.nuevo();     
     }
     return blockeados;
     }
public Cola getTerminados(){
  if(terminados==null){
  terminados= new Cola();
  terminados.nuevo();
  }  
return terminados;

}

}