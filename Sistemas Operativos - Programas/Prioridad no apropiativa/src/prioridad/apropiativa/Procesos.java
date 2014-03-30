package prioridad.apropiativa;

class nodo{
    public int proceso;
    public int tiempo;
    public nodo sig;  
    public int TBLOQ;
    public int prioridad;
}
public class Procesos {
    int t_proceso;
    nodo nuevo,cab,p,aux;
    nodo nuevoB,cabB,pB,auxB;
    int[][] matProc;
    
    public void nuevo(){
        p=new nodo();
        p.sig=p;
        cab=p;
    }            
    public void nuevoBloqueado(){
        pB=new nodo();
        pB.sig=pB;
        cabB=pB;
    }    
    public Procesos() {
        int cont=1;
        int a=1;
        while (a<5){
            a =  (int) Math.round((Math.random()*20));
        }
        this.matProc = new int[a][3];          
        for (int i=0; i<a; i++){
                matProc[i][0]=cont;
                matProc[i][1]= (int) Math.round((Math.random()*21));
                if (matProc[i][1]==0){
                    matProc[i][1]=1;
                }
                matProc[i][2]=0;
                cont=cont + 1;            
        }
    }
    public void Iniciar(){     
        for(int i=0;i<matProc.length;i++){  
            matProc[i][2] =0;
            while(matProc[i][2]==0){
                matProc[i][2] = (int) Math.round((Math.random()*11));
            }
        }
        for(int k=0;k<matProc.length;k++){
            t_proceso=matProc[k][1];
            nuevo =new nodo();
            nuevo.proceso=(k+1);
            nuevo.tiempo=t_proceso;
            nuevo.prioridad=matProc[k][2];
            cab.sig=nuevo;
            nuevo.sig=p; 
            cab=nuevo;
         }        
        imprimirColProc();       
        nuevo=p.sig;
        int cont=1;        
            while(nuevo!=p){                
                String texto = cont + ".\t  " + nuevo.tiempo + " \t " + nuevo.prioridad + " ";
                Interfaz.agregarTxtArea_Listo1(texto);
                cont++;               
                nuevo=nuevo.sig;
            }       
    }    
    public void imprimirColProc(){
        nuevo=p.sig;
        while(nuevo!=p){
           System.out.println(nuevo.proceso + "." + "TR: " + nuevo.tiempo + " Pr: " + nuevo.prioridad);             
           nuevo=nuevo.sig;
        }
    }    
}
