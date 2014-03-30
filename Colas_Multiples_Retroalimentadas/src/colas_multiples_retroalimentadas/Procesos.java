package colas_multiples_retroalimentadas;

class nodo{
    public int proceso;
    public int tiempo;
    public nodo sig; 
    public int QTM;
    public int TSUSP;
    public int TBLOQ;
    public int prioridad;
    public int envejecimiento;
    
}
public class Procesos {
    int t_proceso;
    nodo nuevo,cab,p,aux;
    nodo nuevoSS,cabSS,pSS,auxSS;
    nodo nuevoBS,cabBS,pBS,auxBS;
    nodo nuevoSE,cabSE,pSE,auxSE;
    nodo nuevoBE,cabBE,pBE,auxBE;
    nodo nuevoSU,cabSU,pSU,auxSU;
    nodo nuevoBU,cabBU,pBU,auxBU;
  
    int[][] matProc;
    int promedioCPU = 0;
    
    public void nuevo(){
        p=new nodo();
        p.sig=p;
        cab=p;
    }            
    public void nuevoBloqueadoSistema(){
        pBS=new nodo();
        pBS.sig=pBS;
        cabBS=pBS;
    }    
    public void nuevoSuspendidoSistema(){
        pSS=new nodo();
        pSS.sig=pSS;
        cabSS=pSS;
    } 
    public void nuevoBloqueadoEntradaSalida(){
        pBE=new nodo();
        pBE.sig=pBE;
        cabBE=pBE;
    }    
    public void nuevoSuspendidoEntradaSalida(){
        pSE=new nodo();
        pSE.sig=pSE;
        cabSE=pSE;
    } 
    public void nuevoBloqueadoUsuario(){
        pBU=new nodo();
        pBU.sig=pBU;
        cabBU=pBU;
    }    
    public void nuevoSuspendidoUsuario(){
        pSU=new nodo();
        pSU.sig=pSU;
        cabSU=pSU;
    } 
    public Procesos() {
        int cont=1;
        int a=1;
        while (a<10){
            a =  (int) Math.round((Math.random()*20));
        }
        this.matProc = new int[a][5];          
        for (int i=0; i<a; i++){
                matProc[i][0]=cont;
                matProc[i][1]= (int) Math.round((Math.random()*21));
                if (matProc[i][1]==0){
                    matProc[i][1]=1;
                }
                matProc[i][2]=0;
                matProc[i][3]=0;
                while(matProc[i][3]==0){
                     matProc[i][3]=(int) Math.round((Math.random()*3));                     
                }
                while(matProc[i][4]<30){
                     matProc[i][4]=(int) Math.round((Math.random()*300));                     
                }
                cont=cont + 1;            
        }
    }
    public void Iniciar(){        
        for(int i=0;i<matProc.length;i++){
            this.promedioCPU+= matProc[i][1];            
        }
        this.promedioCPU=this.promedioCPU/matProc.length;
        
        for(int i=0;i<matProc.length;i++){            
            if(matProc[i][3]==1){    
                if(matProc[i][1]<=promedioCPU){
                    matProc[i][2] = matProc[i][1];
                }else{
                    matProc[i][2] = promedioCPU+(matProc[i][1]/promedioCPU);
                }            
            }else{
                        matProc[i][2] = 0;
            }
        }
        for(int k=0;k<matProc.length;k++){
            t_proceso=matProc[k][1];
            nuevo =new nodo();
            nuevo.proceso=(k+1);
            nuevo.tiempo=t_proceso;
            nuevo.QTM=matProc[k][2];
            nuevo.prioridad=matProc[k][3];
            nuevo.envejecimiento=matProc[k][4];
            cab.sig=nuevo;
            nuevo.sig=p; 
            cab=nuevo;
         }        
        imprimirColProc();       
        nuevo=p.sig;
        int cont=1;        
            while(nuevo!=p){                
                String texto = cont + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                Interfaz.agregarTxtArea_Listo(texto);
                cont++;               
                nuevo=nuevo.sig;
            }       
    }    
    public void imprimirColProc(){
        nuevo=p.sig;
        if(nuevo==p){
           System.out.println(nuevo.proceso + "." + "QR: " + nuevo.tiempo + "QTM: " + nuevo.QTM + "PR: " + nuevo.prioridad + "EN: " + nuevo.envejecimiento);           
        }
        while(nuevo!=p){
           System.out.println(nuevo.proceso + "." + "QR: " + nuevo.tiempo + "QTM: " + nuevo.QTM + "PR: " + nuevo.prioridad + "EN: " + nuevo.envejecimiento);
           nuevo=nuevo.sig;
        }
    }    
}
