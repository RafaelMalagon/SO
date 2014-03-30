/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prioridadDespl;
/**
 *
 * @author ryuuzaki 
 */
class nodo{
    public String proceso;
    public int tiempo;
    public int prior;
    public int QTM;
    public nodo sig;
    public int TSUSP;
    public int TBLOQ;
}

public class Procesos {
    int t_proceso;
    nodo nuevo,cab,p,aux;
    nodo nuevoS,cabS,pS,auxS;
    nodo nuevoB,cabB,pB,auxB;
    public int numProc=0;
  
    int[][] matProc;
    int promedioCPU = 0;
    
    public void nuevo(){
        p=new nodo();
        p.sig=p;
        cab=p;
    }
    
    public void nuevoSuspendido(){
        pS=new nodo();
        pS.sig=pS;
        cabS=pS;
    }
    
    public void nuevoBloqueado(){
        pB=new nodo();
        pB.sig=pB;
        cabB=pB;
    }
    
    public Procesos() {
        aux = new nodo();
        this.matProc = new int[][]{{1,10,0},
                                   {2,5,0},
                                   {3,6,0},
                                   {4,3,0},
                                   {5,1,0},
                                   {6,8,0},
                                   {7,2,0},
                                   {8,7,0},
                                   {9,3,0},
                                   {10,5,0}};
        //System.out.println(matProc[1][1]);
    }
    
    public void Iniciar(){
        
        //PRIMERO SACO EL PROMEDIO DE USO DE LA CPU
        for(int i=0;i<10;i++){
            for(int j=1;j<2;j++){
               this.promedioCPU+= matProc[i][j];
            }
        }
        this.promedioCPU=this.promedioCPU/matProc.length;
        System.out.println("PromedioCPU: "+this.promedioCPU);
        
        //AHORA LE ASIGNO A CADA PROCESO UN QUANTUM
        
        for(int i=0;i<matProc.length;i++){
            for(int j=2;j<3;j++){
                /*SI EL TCPU ES MENOR O IGUAL AL PROMEDIO ENTONCES
                LE ASIGNAMOS EL MISMO, DE LO CONTRARIO LE ASIGNAMOS
                UN VALOR CALCULADO*/
                if(matProc[i][j-1]<=promedioCPU){
                    matProc[i][j] = matProc[i][j-1];
                }else{
                    matProc[i][j] = promedioCPU+(matProc[i][j-1] / promedioCPU);
                }
            }
        }
        
        //AHORA LLENO LA LISTA DE PROCESOS
        for(int k=0;k<matProc.length;k++){
            t_proceso=matProc[k][1];//es el tiempo del proceso que le asignamos
            nuevo =new nodo();//pedir memoria, generar un nodo
            nuevo.proceso=String.valueOf(k+1);//asignar numero de proceso
            nuevo.tiempo=t_proceso;//tiempo de cpu que requiere
            nuevo.QTM=matProc[k][2];
            cab.sig=nuevo;//Actualiza el enlace para apuntar al siguiente nodo 
            nuevo.sig=p; //actualiza el ultimo nodo con la direccion del primero
            cab=nuevo;// actualizar el contenido de la variable para recibir el siguiente nodo

         }
        //IMPRIMO LA COLA DESDE LA CABESA USANDO LISTAS POR CONSOLA
        imprimirColProc();
        
        //AHORA AGREGO LA LISTA A LA GUI
        //aux=cab;
        nuevo=p.sig;//asignar direccion del primer nodo que sigue a la cpu
        int cont=1;
            while(nuevo!=p){
                
                String texto = cont + ".\t [" + nuevo.tiempo + "]\t[" + nuevo.QTM + "]";
                Ventana.agregarTxtArea_Listo1(texto);
                cont++;
               //System.out.print("\n");
               nuevo=nuevo.sig;//ubicar el siguiente nodo a mostrar
            }       
        
        
        
    }//Fin Iniciar()
    
    public void ordenarListo(){
        aux.proceso = "";
        aux.tiempo = 0;
        System.out.println("numProc: " + numProc);
        if(numProc > 1){
            nuevo=p.sig;
            //System.out.println("ordenó");           
            boolean cambio = false;
	    do {
	        cambio = false;
	        for (int a = 1; a < numProc; a++) {
                    System.out.println(nuevo.proceso +"["+nuevo.tiempo+"]"+ " -> " + nuevo.sig.proceso  +"["+nuevo.sig.tiempo+"]");
	            if (nuevo.prior > nuevo.sig.prior) {
	                aux.proceso = nuevo.proceso;
                        aux.tiempo = nuevo.tiempo;
                        aux.prior = nuevo.prior;
                        
                        nuevo.proceso = nuevo.sig.proceso;
                        nuevo.tiempo = nuevo.sig.tiempo;
                        nuevo.prior = nuevo.sig.prior;
                        
                        nuevo.sig.proceso = aux.proceso;
                        nuevo.sig.tiempo = aux.tiempo;
                        nuevo.sig.prior = aux.prior;
                        
                        nuevo=nuevo.sig;
	                cambio = true;
                        System.out.println("cambió");
                        imprimirColProc();
                        
	            }else{
                        nuevo=nuevo.sig;
                    }
	        }
	    } while (cambio);
        }
        
        
    }//FIN ordenarListo()
    
    public boolean desplazar(int tiempoEntra){
        
        return true;
    }//FIN desplazar()
    
    public void imprimirColProc(){
        nuevo=p.sig;//asignar direccion del primer nodo que sigue a la cpu
        while(nuevo!=p){//se repite hasta encontrar el ultimo nodo
           System.out.println("("+nuevo.proceso + ")" + "(" + nuevo.tiempo + ")" + "(" + nuevo.QTM + ")");
           //System.out.print("\n");
           nuevo=nuevo.sig;//ubicar el siguiente nodo a mostrar
        }
    
    }
    public void imprimirColSUSP(){
        nuevo=pS.sig;//asignar direccion del primer nodo que sigue a la cpu
        while(nuevo!=pS){//se repite hasta encontrar el ultimo nodo
           System.out.println("("+nuevo.proceso + ")" + "(" + nuevo.tiempo + ")" + "(" + nuevo.QTM + ")");
           //System.out.print("\n");
           nuevo=nuevo.sig;//ubicar el siguiente nodo a mostrar
        }
    
    }
    
    public void imprimirMatProc(){
        for(int i=0;i<10;i++){
            System.out.println(""); 
            for(int j=0;j<3;j++){
               System.out.print("("+matProc[i][j]+")"); 
            }
        }
    }//FIN imprimirProc
    
}//FIN Class
