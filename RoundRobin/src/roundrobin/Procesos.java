package roundrobin;

class nodo{
    public int proceso;
    public int tiempo;
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
            this.promedioCPU+= matProc[i][1];            
        }
        this.promedioCPU=this.promedioCPU/matProc.length;        
        for(int i=0;i<matProc.length;i++){            
            if(matProc[i][1]<=promedioCPU){
                matProc[i][2] = matProc[i][1];
            }else{
                matProc[i][2] = promedioCPU+(matProc[i][1]/promedioCPU);
            }            
        }                
        for(int k=0;k<matProc.length;k++){
            t_proceso=matProc[k][1];
            nuevo =new nodo();
            nuevo.proceso=(k+1);
            nuevo.tiempo=t_proceso;
            nuevo.QTM=matProc[k][2];
            cab.sig=nuevo;
            nuevo.sig=p; 
            cab=nuevo;
         }        
        imprimirColProc();        
        nuevo=p.sig;
        int cont=1;        
            while(nuevo!=p){                
                String texto = cont + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " ";
                Interfaz.agregarTxtArea_Listo1(texto);
                cont++;               
                nuevo=nuevo.sig;
            }       
    }    
    public void imprimirColProc(){
        nuevo=p.sig;
        while(nuevo!=p){
           System.out.println(nuevo.proceso + "." + "QR: " + nuevo.tiempo + " QD: " + nuevo.QTM);           
           nuevo=nuevo.sig;
        }
    }    
}
