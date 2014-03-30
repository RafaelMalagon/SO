package colas_multiples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class Interfaz extends javax.swing.JFrame {
    
    private nodo aux, nuevo;
    private nodo en_ejecucionS;
    private nodo en_ejecucionE;
    private nodo en_ejecucionU;
    private Procesos Proc;
    private int a[][];    
    private int m[];
    int conttable=0;
    int contuni=0;
    int cont=0;
    private int paso=0;
    private int bloq=0;
    private boolean pas=false;
    private boolean primera=true;
    public Interfaz() {
        this.en_ejecucionS = null;    
        this.en_ejecucionE = null;    
        this.en_ejecucionU = null;    
        this.setTitle(".....:::::Algoritmo Colas Multiples 1.0:::::.....");
        initComponents();
        
    }
    public static void agregarTxtArea_Listo(String text){
        TxtArea_Listo.append("\n"+text);
    }
    public void compararE (){
        if(Proc.p.sig.tiempo!=0&&Proc.p.sig.proceso!=0){
            if(Proc.p.sig.tiempo<en_ejecucionE.tiempo){
                    Proc.nuevoSE =new nodo();
                    Proc.nuevoSE.proceso=en_ejecucionE.proceso;
                    Proc.nuevoSE.tiempo=en_ejecucionE.tiempo;
                    Proc.nuevoSE.prioridad=en_ejecucionE.prioridad;
                    Proc.nuevoSE.TSUSP=en_ejecucionE.TSUSP - 1;
                    int x=0;
                    double y=0;
                    while (x<2){
                          y =  (int) Math.round(Math.random()*3);
                          x = (int) y;
                    }
                    Proc.nuevoSE.TSUSP=x;
                    Proc.cabSE.sig=Proc.nuevoSE;
                    Proc.nuevoSE.sig=Proc.pSE; 
                    Proc.cabSE=Proc.nuevoSE;
                    en_ejecucionE = null;
                    TxtArea_SuspendidoEntradaSalida.append("\n" + Proc.nuevoSE.proceso + ".\t " + Proc.nuevoSE.tiempo + " \t " + Proc.nuevoSE.TSUSP + " ");                                    
            }        
        }
    }
    public void ordenar (nodo nuevo, nodo cab, nodo p){
        int aux0;
        int aux1;
        int aux2; 
        int aux3;
        int b[][];
        int cont2=0;
        nuevo=p.sig;
        while(nuevo!=p){
           cont2=cont2+1;
           nuevo=nuevo.sig;
        }
        b = new int [cont2][4];
        nuevo=p.sig;
        int contor=0;
        while(nuevo!=p){
            b[contor][0]=nuevo.proceso;
            b[contor][1]=nuevo.tiempo;
            b[contor][2]=nuevo.QTM;
            b[contor][3]=nuevo.prioridad;            
            nuevo=nuevo.sig;
            contor=contor+1;
        }            
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b.length-i-1;j++){
                if(b[j+1][3]<b[j][3]){
                  aux0=b[j+1][0];
                  aux1=b[j+1][1];            
                  aux2=b[j+1][2];
                  aux3=b[j+1][3];            
                  b[j+1][0]=b[j][0];
                  b[j+1][1]=b[j][1];
                  b[j+1][2]=b[j][2];
                  b[j+1][3]=b[j][3];
                  b[j][0]=aux0;
                  b[j][1]=aux1;
                  b[j][2]=aux2;
                  b[j][3]=aux3;
               }
           }
        }
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b.length-i-1;j++){
                if(b[j+1][3]==2&&b[j][3]==2){
                    if(b[j+1][1]<b[j][1]){
                      aux0=b[j+1][0];
                      aux1=b[j+1][1];            
                      aux2=b[j+1][2];
                      aux3=b[j+1][3];            
                      b[j+1][0]=b[j][0];
                      b[j+1][1]=b[j][1];
                      b[j+1][2]=b[j][2];
                      b[j+1][3]=b[j][3];
                      b[j][0]=aux0;
                      b[j][1]=aux1;
                      b[j][2]=aux2;
                      b[j][3]=aux3;
                   }
               } 
           }
        }
        nuevo=p.sig;
        contor=0;
        while(nuevo!=p){
            nuevo.proceso=b[contor][0];
            nuevo.tiempo=b[contor][1];            
            nuevo.QTM=b[contor][2];            
            nuevo.prioridad=b[contor][3];                        
            nuevo=nuevo.sig;
            contor=contor+1;
        }    
    }
    public void mensajebloqueo(int p){
        String texto = "";
        if(p==1){texto="en Sistema";}  
        if(p==2){texto="en Entrada/Salida";}
        if(p==3){texto="en Usuario";}
        int pro=0;
        while(pro==0){pro =  (int) Math.round((Math.random()*5));}
        if(pro==1){JOptionPane.showMessageDialog(null, "Se bloqueó el proceso "+texto+"\n no hay tinta en la impresora!!!");}
        if(pro==2){JOptionPane.showMessageDialog(null, "Se bloqueó el proceso "+texto+"\n el papel en la impresora es insuficiente!!!");}
        if(pro==3){JOptionPane.showMessageDialog(null, "Se bloqueó el proceso "+texto+"\n el CD que intenta grabar no está en blanco!!!");}
        if(pro==4){JOptionPane.showMessageDialog(null, "Se bloqueó el proceso "+texto+"\n no tiene los permisos suficientes!!!");}
        if(pro==5){JOptionPane.showMessageDialog(null, "Se bloqueó el proceso e"+texto+"\n el disco está lleno!!!");}                
    }
    public void Sistema(){//roundrobin
        ordenar(Proc.nuevo, Proc.cab, Proc.p);
        contuni=contuni+1;
        for(int i=0;i<100;i++){
                for(int j=0;j<4;j++){
                    a[i][j]=-1;                
                }
            }
        for(int i=0;i<m.length;i++){
            m[i]=-1;                
        }
        if(Proc.pSS != Proc.pSS.sig){ 
            Proc.nuevoSS=Proc.pSS.sig;            
            if(Proc.nuevoSS.TSUSP != 1){ 
                while(Proc.nuevoSS != Proc.pSS){
                    Proc.nuevoSS.TSUSP = Proc.nuevoSS.TSUSP-1;
                    Proc.nuevoSS=Proc.nuevoSS.sig;
                }                
                TxtArea_SuspendidoSistema.setText("");
                Proc.nuevoSS=Proc.pSS.sig;
                while(Proc.nuevoSS != Proc.pSS){
                    TxtArea_SuspendidoSistema.append("\n" + Proc.nuevoSS.proceso + ".\t " + Proc.nuevoSS.tiempo + " \t " + Proc.nuevoSS.TSUSP + " ");                
                    Proc.nuevoSS=Proc.nuevoSS.sig;
                }
            }
            if(Proc.nuevoSS.TSUSP == 1){                
                Proc.nuevo = new nodo();
                Proc.nuevo.proceso=Proc.nuevoSS.proceso;
                Proc.nuevo.tiempo=Proc.nuevoSS.tiempo;
                Proc.nuevo.prioridad=Proc.nuevoSS.prioridad;
                if(Proc.nuevo.tiempo<=Proc.promedioCPU){
                    Proc.nuevo.QTM = Proc.nuevo.tiempo;
                }else{
                    Proc.nuevo.QTM = Proc.promedioCPU+(Proc.promedioCPU / Proc.promedioCPU);
                }                
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;
                TxtArea_Listo.setText("");
                nuevo=Proc.p.sig;
                while(nuevo!=Proc.p){
                    String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                    Interfaz.agregarTxtArea_Listo(texto);                   
                   nuevo=nuevo.sig;
                }                
                Proc.auxSS=Proc.pSS;
                if(Proc.auxSS==Proc.auxSS.sig){
                    TxtArea_SuspendidoSistema.setText("no hay procesos en suspendido");
                }else{
                    Proc.auxSS=Proc.pSS.sig;
                    Proc.pSS.sig=Proc.auxSS.sig;
                    if(Proc.pSS==Proc.pSS.sig){
                        Proc.nuevoSuspendidoSistema();
                    }                   
                }                
                TxtArea_SuspendidoSistema.setText("");
                Proc.nuevoSS=Proc.pSS.sig;
                while(Proc.nuevoSS != Proc.pSS){
                    TxtArea_SuspendidoSistema.append("\n" + Proc.nuevoSS.proceso + ".\t " + Proc.nuevoSS.tiempo + " \t " + Proc.nuevoSS.TSUSP + " ");                
                    Proc.nuevoSS=Proc.nuevoSS.sig;
                }
            }
        }
        if(Proc.pBS != Proc.pBS.sig){
            Proc.nuevoBS=Proc.pBS.sig;            
            if(Proc.nuevoBS.TBLOQ != 1){
                while(Proc.nuevoBS != Proc.pBS){
                    Proc.nuevoBS.TBLOQ = Proc.nuevoBS.TBLOQ-1;
                    Proc.nuevoBS=Proc.nuevoBS.sig;
                }                
                TxtArea_BloqueadoSistema.setText("");
                Proc.nuevoBS=Proc.pBS.sig;
                while(Proc.nuevoBS != Proc.pBS){
                    TxtArea_BloqueadoSistema.append("\n" + Proc.nuevoBS.proceso + ".\t " + Proc.nuevoBS.tiempo + " \t " + Proc.nuevoBS.TBLOQ + " ");                
                    Proc.nuevoBS=Proc.nuevoBS.sig;
                }
            }
            if(Proc.nuevoBS.TBLOQ == 1){                 
                Proc.nuevo = new nodo();
                Proc.nuevo.proceso=Proc.nuevoBS.proceso;
                Proc.nuevo.tiempo=Proc.nuevoBS.tiempo;
                Proc.nuevo.prioridad=Proc.nuevoBS.prioridad;
                if(Proc.nuevo.tiempo<=Proc.promedioCPU){
                    Proc.nuevo.QTM = Proc.nuevo.tiempo;
                }else{
                    Proc.nuevo.QTM = Proc.promedioCPU+(Proc.promedioCPU / Proc.promedioCPU);
                }                
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;                
                TxtArea_Listo.setText("");
                nuevo=Proc.p.sig;
                while(nuevo!=Proc.p){
                    String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                    Interfaz.agregarTxtArea_Listo(texto);                   
                   nuevo=nuevo.sig;
                }
                Proc.auxBS=Proc.pBS;
                if(Proc.auxBS==Proc.auxBS.sig){
                    TxtArea_BloqueadoSistema.setText("");
                }else{
                    Proc.auxBS=Proc.pBS.sig;
                    Proc.pBS.sig=Proc.auxBS.sig;
                    if(Proc.pBS==Proc.pBS.sig){
                        Proc.nuevoBloqueadoSistema();
                    }                    
                }                
                TxtArea_BloqueadoSistema.setText("");
                Proc.nuevoBS=Proc.pBS.sig;
                while(Proc.nuevoBS != Proc.pBS){
                    Proc.nuevoBS.TBLOQ = Proc.nuevoBS.TBLOQ -1;
                    TxtArea_BloqueadoSistema.append("\n" + Proc.nuevoBS.proceso + ".\t " + Proc.nuevoBS.tiempo + " \t " + Proc.nuevoBS.TBLOQ + " ");                
                    Proc.nuevoBS=Proc.nuevoBS.sig;
                }    
            }            
        }
        if(en_ejecucionS != null){ 
            if(en_ejecucionS.QTM == 1){                
                TxtArea_en_ejecucionSistema.setText("");
                if(en_ejecucionS.tiempo == 1){
                    en_ejecucionS = null;                    
                }else{
                    Proc.nuevoSS =new nodo();
                    Proc.nuevoSS.proceso=en_ejecucionS.proceso;
                    Proc.nuevoSS.tiempo=en_ejecucionS.tiempo - 1;
                    Proc.nuevoSS.QTM=en_ejecucionS.QTM - 1;
                    Proc.nuevoSS.prioridad=en_ejecucionS.prioridad;
                    int x=0;
                    double y=0;
                    while (x<2){
                        y =  (((int) Math.round((Math.random()*100)))*(4))/100;
                        x = (int) y;
                    }
                    Proc.nuevoSS.TSUSP=x;                    
                    Proc.cabSS.sig=Proc.nuevoSS;
                    Proc.nuevoSS.sig=Proc.pSS; 
                    Proc.cabSS=Proc.nuevoSS;
                    en_ejecucionS = null;                    
                    TxtArea_SuspendidoSistema.append("\n" + Proc.nuevoSS.proceso + ".\t " + Proc.nuevoSS.tiempo + " \t " + Proc.nuevoSS.TSUSP + " ");                
                }                
            }else{ 
                if(aux==aux.sig){
                   TxtArea_en_ejecucionSistema.setText("");
                }else{
                    en_ejecucionS.tiempo = en_ejecucionS.tiempo - 1;
                    en_ejecucionS.QTM =en_ejecucionS.QTM -1;                    
                    TxtArea_en_ejecucionSistema.setText("");                    
                    TxtArea_en_ejecucionSistema.append(en_ejecucionS.proceso + ".\t " + en_ejecucionS.tiempo + " \t " + en_ejecucionS.QTM + " ");                                        
                }
            }
        }
        if(en_ejecucionS== null){
            if(Proc.p.sig.prioridad==1&&en_ejecucionE==null&&en_ejecucionU==null){
                TxtArea_en_ejecucionSistema.setText("");
                en_ejecucionS = Proc.p.sig;                
                aux=Proc.p;
                if(aux==aux.sig){
                        en_ejecucionS=null;
                       TxtArea_en_ejecucionSistema.setText("");
                }else{
                    aux=Proc.p.sig;
                    Proc.p.sig=aux.sig;
                    String borrar = "";
                    TxtArea_Listo.setText(borrar);
                    nuevo=Proc.p.sig;
                    int cont=1;
                        while(nuevo!=Proc.p){
                            String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                            Interfaz.agregarTxtArea_Listo(texto);
                            cont++;                       
                            nuevo=nuevo.sig;
                        } 
                   if( en_ejecucionS != Proc.p){                       
                       TxtArea_en_ejecucionSistema.setText("");                       
                       TxtArea_en_ejecucionSistema.append("\n"+en_ejecucionS.proceso + ".\t " + en_ejecucionS.tiempo + " \t " + en_ejecucionS.QTM + " ");
                   }else{
                       en_ejecucionS=null;
                       TxtArea_en_ejecucionSistema.setText("");
                   }
                }                
                int contg=0;
                Proc.nuevo=Proc.p.sig;
                while(Proc.nuevo!=Proc.p){
                    a[contg][0]=Proc.nuevo.proceso;
                    Proc.nuevo=Proc.nuevo.sig;
                    contg=contg+1;
                }
                Proc.nuevoBS=Proc.pBS.sig;
                while(Proc.nuevoBS!=Proc.pBS){
                    a[contg][1]=Proc.nuevoBS.proceso;            
                    Proc.nuevoBS=Proc.nuevoBS.sig;
                    contg=contg+1;
                }
                if(en_ejecucionS!=null){
                    a[contg][3]=en_ejecucionS.proceso;                    
                    contg=contg+1;
                }
                for(int i=0;i<a.length;i++){
                    for(int j=0;j<4;j++){
                        if(a[i][j]!=-1){
                           m[a[i][j]]=j;                   
                        }
                    }        
                }
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                if(primera==true){
                    for(int i=0;i<m.length;i++){ 
                        if(m[i]!=-1){
                            String[] datoscolumna1 = {""+i}; 
                            modelo.insertRow(modelo.getRowCount() - 1,datoscolumna1);
                            conttable=conttable+1;
                        }                
                    }
                    primera=false;
                }
                String dataux = null;
                String[] dato;
                dato = new String [conttable];
                for(int i=1;i<conttable+1;i++){ 
                       if(m[i]==0){
                          dataux = "LLL"; 
                          dato[i-1]=dataux;
                       }
                       if(m[i]==1){
                          dataux = "BBS"; 
                          dato[i-1]=dataux;
                       }
                       if(m[i]==2){
                          dataux = "SSS"; 
                          dato[i-1]=dataux;
                       }
                       if(m[i]==3){
                          dataux = "EEE"; 
                          dato[i-1]=dataux;
                       }
                       if(m[i]==-1){
                          dataux = "-"; 
                          dato[i-1]=dataux; 
                       }
                  }
                 modelo.addColumn(contuni,dato);
                 jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }
            if(Proc.p==Proc.p.sig){
               Proc.nuevo();
            }
            bloq =  (int) Math.round((Math.random()*20));
            if (bloq==1&&en_ejecucionS!=null){
                if(TxtArea_BloqueadoSistema.getText().equals("") && TxtArea_en_ejecucionSistema.getText().equals("") && TxtArea_Listo.getText().equals("")){}
                else{
                        Proc.nuevoBS =new nodo();
                        Proc.nuevoBS.proceso=en_ejecucionS.proceso;
                        Proc.nuevoBS.tiempo=en_ejecucionS.tiempo;   
                        Proc.nuevoBS.prioridad=en_ejecucionS.prioridad;   
                        int x=0;
                        double y=0;
                        while (x<2){
                            y =  (((int) Math.round((Math.random()*100)))*(4))/100;
                            x = (int) y;
                        }
                        Proc.nuevoBS.TBLOQ=x;
                        Proc.cabBS.sig=Proc.nuevoBS;
                        Proc.nuevoBS.sig=Proc.pBS; 
                        Proc.cabBS=Proc.nuevoBS;
                        en_ejecucionS = null;
                        TxtArea_BloqueadoSistema.append("\n"+Proc.nuevoBS.proceso + ".\t" + Proc.nuevoBS.tiempo + " \t " + Proc.nuevoBS.TBLOQ + " ");                
                    }
                    TxtArea_en_ejecucionSistema.setText("");
                    mensajebloqueo(1);                                    
                }
        }
        ordenar(Proc.nuevo, Proc.cab, Proc.p);        
    } 
    public void EntradaSalida(){//srtf
        ordenar(Proc.nuevo, Proc.cab, Proc.p);        
        contuni=contuni+1;
        for(int i=0;i<100;i++){
                for(int j=0;j<4;j++){
                    a[i][j]=-1;                
                }
            }
        for(int i=0;i<m.length;i++){
            m[i]=-1;                
        }
        if(Proc.pSE != Proc.pSE.sig){
            Proc.nuevoSE=Proc.pSE.sig;            
            if(Proc.nuevoSE.TSUSP != 1){ 
                while(Proc.nuevoSE != Proc.pSE){
                    Proc.nuevoSE.TSUSP = Proc.nuevoSE.TSUSP-1;
                    Proc.nuevoSE=Proc.nuevoSE.sig;
                }                
                TxtArea_SuspendidoEntradaSalida.setText("");
                Proc.nuevoSE=Proc.pSE.sig;
                while(Proc.nuevoSE != Proc.pSE){
                    TxtArea_SuspendidoEntradaSalida.append("\n" + Proc.nuevoSE.proceso + ".\t " + Proc.nuevoSE.tiempo + " \t " + Proc.nuevoSE.TSUSP + " ");                
                    Proc.nuevoSE=Proc.nuevoSE.sig;
                }                
            }
            if(Proc.nuevoSE.TSUSP == 1){ 
                Proc.nuevo = new nodo();
                Proc.nuevo.proceso=Proc.nuevoSE.proceso;
                Proc.nuevo.tiempo=Proc.nuevoSE.tiempo;
                Proc.nuevo.prioridad=Proc.nuevoSE.prioridad;
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;                
                TxtArea_Listo.setText("");                
                nuevo=Proc.p.sig;
                while(nuevo!=Proc.p){
                    String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                    Interfaz.agregarTxtArea_Listo(texto);                   
                    nuevo=nuevo.sig;
                }                             
                Proc.auxSE=Proc.pSE;
                if(Proc.auxSE==Proc.auxSE.sig){
                    TxtArea_SuspendidoEntradaSalida.setText("no hay procesos en suspendido");
                }else{
                    Proc.auxSE=Proc.pSE.sig;
                    Proc.pSE.sig=Proc.auxSE.sig;
                    if(Proc.pSE==Proc.pSE.sig){
                        Proc.nuevoSuspendidoEntradaSalida();
                    }                    
                }                
                TxtArea_SuspendidoEntradaSalida.setText("");
                Proc.nuevoSE=Proc.pSE.sig;
                while(Proc.nuevoSE != Proc.pSE){
                    TxtArea_SuspendidoEntradaSalida.append("\n" + Proc.nuevoSE.proceso + ".\t " + Proc.nuevoSE.tiempo + " \t " + Proc.nuevoSE.TSUSP + " ");                
                    Proc.nuevoSE=Proc.nuevoSE.sig;
                }
            }            
        }        
        if(Proc.pBE != Proc.pBE.sig){ 
            Proc.nuevoBE=Proc.pBE.sig;            
            if(Proc.nuevoBE.TBLOQ != 1){ 
                while(Proc.nuevoBE != Proc.pBE){
                    Proc.nuevoBE.TBLOQ = Proc.nuevoBE.TBLOQ-1;
                    Proc.nuevoBE=Proc.nuevoBE.sig;
                }                
                TxtArea_BloqueadoEntradaSalida.setText("");
                Proc.nuevoBE=Proc.pBE.sig;
                while(Proc.nuevoBE != Proc.pBE){
                    TxtArea_BloqueadoEntradaSalida.append("\n" + Proc.nuevoBE.proceso + ".\t " + Proc.nuevoBE.tiempo + " \t " + Proc.nuevoBE.TBLOQ + " ");                
                    Proc.nuevoBE=Proc.nuevoBE.sig;
                }
            }
            if(Proc.nuevoBE.TBLOQ == 1){ 
                Proc.nuevo = new nodo();
                Proc.nuevo.proceso=Proc.nuevoBE.proceso;
                Proc.nuevo.tiempo=Proc.nuevoBE.tiempo;
                Proc.nuevo.prioridad=Proc.nuevoBE.prioridad;
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;                
                TxtArea_Listo.setText("");                
                nuevo=Proc.p.sig;                
                while(nuevo!=Proc.p){
                    String texto =nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                    Interfaz.agregarTxtArea_Listo(texto);                   
                    nuevo=nuevo.sig;                
                }                               
                Proc.auxBE=Proc.pBE;
                if(Proc.auxBE==Proc.auxBE.sig){
                    TxtArea_BloqueadoEntradaSalida.setText("");
                }else{
                    Proc.auxBE=Proc.pBE.sig;
                    Proc.pBE.sig=Proc.auxBE.sig;
                    if(Proc.pBE==Proc.pBE.sig){
                        Proc.nuevoBloqueadoEntradaSalida();
                    }
                }
                TxtArea_BloqueadoEntradaSalida.setText("");
                Proc.nuevoBE=Proc.pBE.sig;
                while(Proc.nuevoBE != Proc.pBE){
                    Proc.nuevoBE.TBLOQ = Proc.nuevoBE.TBLOQ -1;
                    TxtArea_BloqueadoEntradaSalida.append("\n" + Proc.nuevoBE.proceso + ".\t " + Proc.nuevoBE.tiempo + " \t " + Proc.nuevoBE.TBLOQ + " ");                
                    Proc.nuevoBE=Proc.nuevoBE.sig;
                }    
            }
            
        }
        if(en_ejecucionE!=null){
            compararE();
            if(en_ejecucionE!=null){
                if(en_ejecucionE.tiempo == 1){
                    en_ejecucionE= null;                    
                }else{ 
                    if(aux==aux.sig){
                        TxtArea_en_ejecucionEntradaSalida.setText("");
                    }else{
                        en_ejecucionE.tiempo = en_ejecucionE.tiempo - 1;
                        en_ejecucionE.prioridad = en_ejecucionE.prioridad;
                        TxtArea_en_ejecucionEntradaSalida.setText("");
                        TxtArea_en_ejecucionEntradaSalida.append("             "+en_ejecucionE.proceso + ".\t\t"+ en_ejecucionE.tiempo);                                                           
                     }
                }
            }
        }
        if(en_ejecucionE == null){
            TxtArea_en_ejecucionEntradaSalida.setText("");
            if(Proc.p.sig.prioridad==2&&en_ejecucionS==null&&en_ejecucionU==null){
                en_ejecucionE = Proc.p.sig;            
                aux=Proc.p;
                if(aux==aux.sig){
                        en_ejecucionE=null;
                        TxtArea_en_ejecucionEntradaSalida.setText("");
                 }else{
                     aux=Proc.p.sig;
                     Proc.p.sig=aux.sig;
                     String borrar = "";
                     TxtArea_Listo.setText(borrar);                     
                     nuevo=Proc.p.sig;
                     int cont=1;
                     while(nuevo!=Proc.p){
                           String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                           Interfaz.agregarTxtArea_Listo(texto);
                           cont++;                       
                           nuevo=nuevo.sig;
                    }
                    if( en_ejecucionE != Proc.p){                   
                        TxtArea_en_ejecucionEntradaSalida.setText("");
                        TxtArea_en_ejecucionEntradaSalida.append("             "+en_ejecucionE.proceso + ".\t\t"+ en_ejecucionE.tiempo);                   
                    }else{
                        en_ejecucionE=null;
                        TxtArea_en_ejecucionEntradaSalida.setText("");
                    }
                 }                
                 int contg=0;
                    Proc.nuevo=Proc.p.sig;
                    while(Proc.nuevo!=Proc.p){
                        a[contg][0]=Proc.nuevo.proceso;
                        Proc.nuevo=Proc.nuevo.sig;
                        contg=contg+1;
                    }
                    Proc.nuevoBE=Proc.pBE.sig;
                    while(Proc.nuevoBE!=Proc.pBE){
                        a[contg][1]=Proc.nuevoBE.proceso;            
                        Proc.nuevoBE=Proc.nuevoBE.sig;
                        contg=contg+1;
                    }
                    if(en_ejecucionE!=null){
                        a[contg][3]=en_ejecucionE.proceso;                    
                        contg=contg+1;
                    }
                    for(int i=0;i<a.length;i++){
                        for(int j=0;j<4;j++){
                            if(a[i][j]!=-1){
                               m[a[i][j]]=j;                   
                            }
                        }        
                    }
                    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                    if(primera==true){
                        for(int i=0;i<m.length;i++){ 
                            if(m[i]!=-1){
                                String[] datoscolumna1 = {""+i}; 
                                modelo.insertRow(modelo.getRowCount() - 1,datoscolumna1);
                                conttable=conttable+1;
                            }                
                        }
                        primera=false;
                    }
                    String dataux = null;
                    String[] dato;
                    dato = new String [conttable];
                    for(int i=1;i<conttable+1;i++){ 
                           if(m[i]==0){
                              dataux = "LLL"; 
                              dato[i-1]=dataux;
                           }
                           if(m[i]==1){
                              dataux = "BBE"; 
                              dato[i-1]=dataux;
                           }
                           if(m[i]==2){
                              dataux = "SSE"; 
                              dato[i-1]=dataux;
                           }
                           if(m[i]==3){
                              dataux = "EEE"; 
                              dato[i-1]=dataux;
                           }
                           if(m[i]==-1){
                              dataux = "-"; 
                              dato[i-1]=dataux; 
                           }
                      }
                     modelo.addColumn(contuni,dato);
                     jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }
        }
        if(Proc.p==Proc.p.sig){
           Proc.nuevo();
        }
        bloq =  (int) Math.round((Math.random()*20));
        if (bloq==1&&en_ejecucionE!=null){
            if(TxtArea_BloqueadoEntradaSalida.getText().equals("") && TxtArea_en_ejecucionEntradaSalida.getText().equals("") && TxtArea_Listo.getText().equals("")){}
            else{
                    Proc.nuevoBE =new nodo();
                    Proc.nuevoBE.proceso=en_ejecucionE.proceso;
                    Proc.nuevoBE.tiempo=en_ejecucionE.tiempo;                    
                    Proc.nuevoBE.prioridad=en_ejecucionE.prioridad;                    
                    int x=0;
                    double y=0;
                    while (x<2){
                        y =  (((int) Math.round((Math.random()*100)))*(4))/100;
                        x = (int) y;
                    }
                    Proc.nuevoBE.TBLOQ=x;
                    Proc.cabBE.sig=Proc.nuevoBE;
                    Proc.nuevoBE.sig=Proc.pBE; 
                    Proc.cabBE=Proc.nuevoBE;
                    en_ejecucionE = null;
                    TxtArea_BloqueadoEntradaSalida.append("\n"+Proc.nuevoBE.proceso + ".\t" + Proc.nuevoBE.tiempo + " \t " + Proc.nuevoBE.TBLOQ + " ");                
                }
                TxtArea_en_ejecucionEntradaSalida.setText("");
                mensajebloqueo(2);
            }                        
            TxtArea_Listo.setText("");            
        nuevo=Proc.p.sig;
        while(nuevo!=Proc.p){
            String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
            Interfaz.agregarTxtArea_Listo(texto);                   
            nuevo=nuevo.sig;
        }
        ordenar(Proc.nuevo, Proc.cab, Proc.p);
    }
    public void Usuario(){//FIFO
        ordenar(Proc.nuevo, Proc.cab, Proc.p);
        contuni=contuni+1;
        for(int i=0;i<100;i++){
                for(int j=0;j<4;j++){
                    a[i][j]=-1;                
                }
            }
        for(int i=0;i<m.length;i++){
            m[i]=-1;                
        }
        if(Proc.pBU != Proc.pBU.sig){ 
            Proc.nuevoBU=Proc.pBU.sig;            
            if(Proc.nuevoBU.TBLOQ != 1){ 
                while(Proc.nuevoBU != Proc.pBU){
                    Proc.nuevoBU.TBLOQ = Proc.nuevoBU.TBLOQ-1;
                    Proc.nuevoBU=Proc.nuevoBU.sig;
                }                
                TxtArea_BloqueadoUsuario.setText("");
                Proc.nuevoBU=Proc.pBU.sig;
                while(Proc.nuevoBU != Proc.pBU){
                    TxtArea_BloqueadoUsuario.append("\n" + Proc.nuevoBU.proceso + ".\t " + Proc.nuevoBU.tiempo + " \t " + Proc.nuevoBU.TBLOQ + " ");                
                    Proc.nuevoBU=Proc.nuevoBU.sig;
                }
            }
            if(Proc.nuevoBU.TBLOQ == 1){ 
                Proc.nuevo = new nodo();
                Proc.nuevo.proceso=Proc.nuevoBU.proceso;
                Proc.nuevo.tiempo=Proc.nuevoBU.tiempo;
                Proc.nuevo.prioridad=Proc.nuevoBU.prioridad;
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;                
                TxtArea_Listo.setText("");                
                nuevo=Proc.p.sig;                
                while(nuevo!=Proc.p){
                    String texto =nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                    Interfaz.agregarTxtArea_Listo(texto);                   
                    nuevo=nuevo.sig;                
                }                               
                Proc.auxBU=Proc.pBU;
                if(Proc.auxBU==Proc.auxBU.sig){
                    TxtArea_BloqueadoUsuario.setText("");
                }else{
                    Proc.auxBU=Proc.pBU.sig;
                    Proc.pBU.sig=Proc.auxBU.sig;
                    if(Proc.pBU==Proc.pBU.sig){
                        Proc.nuevoBloqueadoUsuario();
                    }
                }
                TxtArea_BloqueadoUsuario.setText("");
                Proc.nuevoBU=Proc.pBU.sig;
                while(Proc.nuevoBU != Proc.pBU){
                    Proc.nuevoBU.TBLOQ = Proc.nuevoBU.TBLOQ -1;
                    TxtArea_BloqueadoUsuario.append("\n" + Proc.nuevoBU.proceso + ".\t " + Proc.nuevoBU.tiempo + " \t " + Proc.nuevoBU.TBLOQ + " ");                
                    Proc.nuevoBU=Proc.nuevoBU.sig;
                }    
            }
            
        }
        if(en_ejecucionU!=null){
            if(en_ejecucionU!=null){
                if(en_ejecucionU.tiempo == 1){
                    en_ejecucionU= null;                    
                }else{ 
                    if(aux==aux.sig){
                        TxtArea_en_ejecucionUsuario.setText("");
                    }else{
                        en_ejecucionU.tiempo = en_ejecucionU.tiempo - 1;
                        en_ejecucionU.prioridad = en_ejecucionU.prioridad;
                        TxtArea_en_ejecucionUsuario.setText("");
                        TxtArea_en_ejecucionUsuario.append("             "+en_ejecucionU.proceso + ".\t\t"+ en_ejecucionU.tiempo);                                                           
                     }
                }
            }
        }
        if(en_ejecucionU == null){
            TxtArea_en_ejecucionUsuario.setText("");
            if(Proc.p.sig.prioridad==3&&en_ejecucionS==null&&en_ejecucionE==null){
                en_ejecucionU = Proc.p.sig;            
                aux=Proc.p;
                if(aux==aux.sig){
                        en_ejecucionU=null;
                        TxtArea_en_ejecucionUsuario.setText("");
                 }else{
                     aux=Proc.p.sig;
                     Proc.p.sig=aux.sig;
                     String borrar = "";
                     TxtArea_Listo.setText(borrar);                     
                     nuevo=Proc.p.sig;
                     int cont=1;
                     while(nuevo!=Proc.p){
                           String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                           Interfaz.agregarTxtArea_Listo(texto);
                           cont++;                       
                           nuevo=nuevo.sig;
                    }
                    if( en_ejecucionU != Proc.p){                   
                        TxtArea_en_ejecucionUsuario.setText("");
                        TxtArea_en_ejecucionUsuario.append("             "+en_ejecucionU.proceso + ".\t\t"+ en_ejecucionU.tiempo);                   
                    }else{
                        en_ejecucionU=null;
                        TxtArea_en_ejecucionUsuario.setText("");
                    }
                 }
                 int contg=0;
                Proc.nuevo=Proc.p.sig;
                while(Proc.nuevo!=Proc.p){
                    a[contg][0]=Proc.nuevo.proceso;
                    Proc.nuevo=Proc.nuevo.sig;
                    contg=contg+1;
                }
                Proc.nuevoBU=Proc.pBU.sig;
                while(Proc.nuevoBU!=Proc.pBU){
                    a[contg][1]=Proc.nuevoBU.proceso;            
                    Proc.nuevoBU=Proc.nuevoBU.sig;
                    contg=contg+1;
                }
                if(en_ejecucionU!=null){
                    a[contg][3]=en_ejecucionU.proceso;                    
                    contg=contg+1;
                }
                for(int i=0;i<a.length;i++){
                    for(int j=0;j<4;j++){
                        if(a[i][j]!=-1){
                           m[a[i][j]]=j;                   
                        }
                    }        
                }
                DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                if(primera==true){
                    for(int i=0;i<m.length;i++){ 
                        if(m[i]!=-1){
                            String[] datoscolumna1 = {""+i}; 
                            modelo.insertRow(modelo.getRowCount() - 1,datoscolumna1);
                            conttable=conttable+1;
                        }                
                    }
                    primera=false;
                }
                String dataux = null;
                String[] dato;
                dato = new String [conttable];
                for(int i=1;i<conttable+1;i++){ 
                       if(m[i]==0){
                          dataux = "LLL"; 
                          dato[i-1]=dataux;
                       }
                       if(m[i]==1){
                          dataux = "BBU"; 
                          dato[i-1]=dataux;
                       }
                       if(m[i]==2){
                          dataux = "SSU"; 
                          dato[i-1]=dataux;
                       }
                       if(m[i]==3){
                          dataux = "EEU"; 
                          dato[i-1]=dataux;
                       }
                       if(m[i]==-1){
                          dataux = "-"; 
                          dato[i-1]=dataux; 
                       }
                  }
                 modelo.addColumn(contuni,dato);
                 jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            }
        }
        if(Proc.p==Proc.p.sig){
           Proc.nuevo();
        }
        bloq =  (int) Math.round((Math.random()*20));
        if (bloq==1&&en_ejecucionU!=null){
            if(TxtArea_BloqueadoUsuario.getText().equals("") && TxtArea_en_ejecucionUsuario.getText().equals("") && TxtArea_Listo.getText().equals("")){}
            else{
                    Proc.nuevoBU =new nodo();
                    Proc.nuevoBU.proceso=en_ejecucionU.proceso;
                    Proc.nuevoBU.tiempo=en_ejecucionU.tiempo;                    
                    Proc.nuevoBU.prioridad=en_ejecucionU.prioridad;                    
                    int x=0;
                    double y=0;
                    while (x<2){
                        y =  (((int) Math.round((Math.random()*100)))*(4))/100;
                        x = (int) y;
                    }
                    Proc.nuevoBU.TBLOQ=x;
                    Proc.cabBU.sig=Proc.nuevoBU;
                    Proc.nuevoBU.sig=Proc.pBU; 
                    Proc.cabBU=Proc.nuevoBU;
                    en_ejecucionU = null;
                    TxtArea_BloqueadoUsuario.append("\n"+Proc.nuevoBU.proceso + ".\t" + Proc.nuevoBU.tiempo + " \t " + Proc.nuevoBU.TBLOQ + " ");                
                }
                TxtArea_en_ejecucionUsuario.setText("");
                mensajebloqueo(3);
            }                        
            TxtArea_Listo.setText("");            
            nuevo=Proc.p.sig;
        while(nuevo!=Proc.p){
            String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
            Interfaz.agregarTxtArea_Listo(texto);                   
            nuevo=nuevo.sig;
        }        
        ordenar(Proc.nuevo, Proc.cab, Proc.p);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gantt = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonIniciar = new javax.swing.JButton();
        Pause = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TxtArea_Listo = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TxtArea_en_ejecucionSistema = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        TxtArea_SuspendidoSistema = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TxtArea_BloqueadoSistema = new javax.swing.JTextArea();
        jLabel56 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        TxtArea_SuspendidoEntradaSalida = new javax.swing.JTextArea();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        TxtArea_BloqueadoEntradaSalida = new javax.swing.JTextArea();
        jLabel82 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        TxtArea_en_ejecucionEntradaSalida = new javax.swing.JTextArea();
        jLabel63 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        TxtArea_en_ejecucionUsuario = new javax.swing.JTextArea();
        jLabel94 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        TxtArea_BloqueadoUsuario = new javax.swing.JTextArea();
        jLabel97 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PromedioCPU = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        Gantt.setTitle("..::Diagrama de Gantt::..");
        Gantt.setBounds(new java.awt.Rectangle(550, 270, 725, 455));
        Gantt.setResizable(false);
        Gantt.getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Proceso"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        Gantt.getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 660, 290);

        jLabel24.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 24)); // NOI18N
        jLabel24.setText("Diagrama de Gantt");
        Gantt.getContentPane().add(jLabel24);
        jLabel24.setBounds(280, 10, 220, 40);

        jLabel27.setText("Quantum en ejecucion");
        Gantt.getContentPane().add(jLabel27);
        jLabel27.setBounds(340, 50, 150, 14);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo_gantt.jpg"))); // NOI18N
        Gantt.getContentPane().add(jLabel25);
        jLabel25.setBounds(0, 0, 720, 440);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(10, 10, 707, 603));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1181, 725));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel17.setBackground(new java.awt.Color(0, 51, 51));
        jLabel17.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel17.setText("Colas Multiples");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(30, 20, 170, 46);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(30, 60, 605, 11);

        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciar);
        jButtonIniciar.setBounds(40, 640, 100, 23);

        Pause.setText("Pause");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });
        getContentPane().add(Pause);
        Pause.setBounds(160, 640, 100, 23);

        jButton2.setText("D. GANTT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(280, 640, 90, 23);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Prioridad");
        getContentPane().add(jLabel39);
        jLabel39.setBounds(910, 620, 40, 10);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(900, 640, 70, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("AGREGAR UN PROCESO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(730, 600, 140, 14);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("ID Proceso");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(740, 620, 50, 10);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(810, 620, 80, 10);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(720, 640, 80, 30);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel23);
        jLabel23.setBounds(700, 590, 240, 50);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(810, 640, 80, 30);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(990, 640, 71, 23);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel37);
        jLabel37.setBounds(940, 640, 140, 40);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel38);
        jLabel38.setBounds(700, 640, 240, 40);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel35);
        jLabel35.setBounds(940, 590, 140, 30);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel36);
        jLabel36.setBounds(700, 590, 240, 30);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel31);
        jLabel31.setBounds(940, 590, 140, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Prioridad");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(300, 130, 50, 10);

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("ID Proceso");
        getContentPane().add(jLabel76);
        jLabel76.setBounds(40, 130, 50, 10);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(110, 130, 80, 10);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 51));
        jLabel4.setText("Listo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 100, 60, 17);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Q. Asignado");
        getContentPane().add(jLabel50);
        jLabel50.setBounds(210, 130, 50, 10);

        TxtArea_Listo.setEditable(false);
        TxtArea_Listo.setColumns(20);
        TxtArea_Listo.setRows(5);
        jScrollPane10.setViewportView(TxtArea_Listo);

        getContentPane().add(jScrollPane10);
        jScrollPane10.setBounds(30, 140, 330, 470);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel22);
        jLabel22.setBounds(30, 90, 330, 50);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID Proceso");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(390, 130, 50, 10);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(460, 130, 80, 10);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Sistema");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(480, 100, 60, 17);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Q. Asignado");
        getContentPane().add(jLabel51);
        jLabel51.setBounds(560, 130, 50, 10);

        TxtArea_en_ejecucionSistema.setEditable(false);
        TxtArea_en_ejecucionSistema.setColumns(20);
        TxtArea_en_ejecucionSistema.setRows(5);
        jScrollPane11.setViewportView(TxtArea_en_ejecucionSistema);

        getContentPane().add(jScrollPane11);
        jScrollPane11.setBounds(380, 140, 240, 100);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel26);
        jLabel26.setBounds(380, 90, 240, 50);

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(204, 255, 255));
        jLabel75.setText("Suspendido");
        getContentPane().add(jLabel75);
        jLabel75.setBounds(470, 270, 80, 14);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ID Proceso");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(390, 300, 50, 10);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(460, 300, 80, 10);

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Q. Asignado");
        getContentPane().add(jLabel52);
        jLabel52.setBounds(560, 300, 50, 10);

        TxtArea_SuspendidoSistema.setEditable(false);
        TxtArea_SuspendidoSistema.setColumns(20);
        TxtArea_SuspendidoSistema.setRows(5);
        jScrollPane13.setViewportView(TxtArea_SuspendidoSistema);

        getContentPane().add(jScrollPane13);
        jScrollPane13.setBounds(380, 310, 240, 100);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel34);
        jLabel34.setBounds(380, 260, 240, 50);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(204, 255, 255));
        jLabel80.setText("Bloqueado");
        getContentPane().add(jLabel80);
        jLabel80.setBounds(480, 440, 60, 14);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("ID Proceso");
        getContentPane().add(jLabel46);
        jLabel46.setBounds(390, 470, 50, 10);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel47);
        jLabel47.setBounds(460, 470, 80, 10);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Q. Asignado");
        getContentPane().add(jLabel54);
        jLabel54.setBounds(560, 470, 50, 10);

        TxtArea_BloqueadoSistema.setEditable(false);
        TxtArea_BloqueadoSistema.setColumns(20);
        TxtArea_BloqueadoSistema.setRows(5);
        jScrollPane14.setViewportView(TxtArea_BloqueadoSistema);

        getContentPane().add(jScrollPane14);
        jScrollPane14.setBounds(380, 480, 240, 100);

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel56);
        jLabel56.setBounds(380, 430, 240, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Suspendido");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(750, 270, 80, 14);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Bloqueado");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(750, 440, 60, 14);

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("ID Proceso");
        getContentPane().add(jLabel73);
        jLabel73.setBounds(670, 300, 50, 10);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel74);
        jLabel74.setBounds(740, 300, 80, 10);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Tiempo para salir");
        getContentPane().add(jLabel44);
        jLabel44.setBounds(1090, 380, 80, 10);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Tiempo para salir");
        getContentPane().add(jLabel43);
        jLabel43.setBounds(830, 470, 80, 10);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Tiempo para salir");
        getContentPane().add(jLabel42);
        jLabel42.setBounds(830, 300, 80, 10);

        TxtArea_SuspendidoEntradaSalida.setEditable(false);
        TxtArea_SuspendidoEntradaSalida.setColumns(20);
        TxtArea_SuspendidoEntradaSalida.setRows(5);
        jScrollPane19.setViewportView(TxtArea_SuspendidoEntradaSalida);

        getContentPane().add(jScrollPane19);
        jScrollPane19.setBounds(660, 310, 240, 100);

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel77);
        jLabel77.setBounds(660, 260, 240, 50);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("ID Proceso");
        getContentPane().add(jLabel78);
        jLabel78.setBounds(670, 470, 50, 10);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel79);
        jLabel79.setBounds(740, 470, 80, 10);

        TxtArea_BloqueadoEntradaSalida.setEditable(false);
        TxtArea_BloqueadoEntradaSalida.setColumns(20);
        TxtArea_BloqueadoEntradaSalida.setRows(5);
        jScrollPane20.setViewportView(TxtArea_BloqueadoEntradaSalida);

        getContentPane().add(jScrollPane20);
        jScrollPane20.setBounds(660, 480, 240, 100);

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel82);
        jLabel82.setBounds(660, 430, 240, 50);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("ID Proceso");
        getContentPane().add(jLabel58);
        jLabel58.setBounds(710, 130, 50, 10);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel59);
        jLabel59.setBounds(800, 130, 80, 10);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 0));
        jLabel60.setText("Entrada/Salida");
        getContentPane().add(jLabel60);
        jLabel60.setBounds(730, 100, 120, 17);

        TxtArea_en_ejecucionEntradaSalida.setEditable(false);
        TxtArea_en_ejecucionEntradaSalida.setColumns(20);
        TxtArea_en_ejecucionEntradaSalida.setRows(5);
        jScrollPane17.setViewportView(TxtArea_en_ejecucionEntradaSalida);

        getContentPane().add(jScrollPane17);
        jScrollPane17.setBounds(660, 140, 240, 100);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel63);
        jLabel63.setBounds(660, 90, 240, 50);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel84);
        jLabel84.setBounds(1050, 130, 80, 10);

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 0));
        jLabel87.setText("Usuario");
        getContentPane().add(jLabel87);
        jLabel87.setBounds(1020, 100, 60, 17);

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("ID Proceso");
        getContentPane().add(jLabel88);
        jLabel88.setBounds(950, 130, 50, 10);

        TxtArea_en_ejecucionUsuario.setEditable(false);
        TxtArea_en_ejecucionUsuario.setColumns(20);
        TxtArea_en_ejecucionUsuario.setRows(5);
        jScrollPane25.setViewportView(TxtArea_en_ejecucionUsuario);

        getContentPane().add(jScrollPane25);
        jScrollPane25.setBounds(920, 140, 240, 190);

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel94);
        jLabel94.setBounds(920, 90, 240, 50);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(204, 255, 255));
        jLabel85.setText("Bloqueado");
        getContentPane().add(jLabel85);
        jLabel85.setBounds(1010, 350, 60, 14);

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("ID Proceso");
        getContentPane().add(jLabel93);
        jLabel93.setBounds(930, 380, 50, 10);

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel95);
        jLabel95.setBounds(1000, 380, 80, 10);

        TxtArea_BloqueadoUsuario.setEditable(false);
        TxtArea_BloqueadoUsuario.setColumns(20);
        TxtArea_BloqueadoUsuario.setRows(5);
        jScrollPane26.setViewportView(TxtArea_BloqueadoUsuario);

        getContentPane().add(jScrollPane26);
        jScrollPane26.setBounds(920, 390, 240, 190);

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel97);
        jLabel97.setBounds(920, 340, 240, 50);

        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel61);
        jLabel61.setBounds(270, 90, 90, 50);

        jLabel12.setForeground(new java.awt.Color(255, 153, 51));
        jLabel12.setText("PromedioCPU:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(450, 600, 90, 30);

        PromedioCPU.setEditable(false);
        PromedioCPU.setText("0");
        PromedioCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PromedioCPUActionPerformed(evt);
            }
        });
        getContentPane().add(PromedioCPU);
        PromedioCPU.setBounds(540, 600, 50, 30);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel28);
        jLabel28.setBounds(440, 600, 100, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1180, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents
Timer timer = new Timer (400, new ActionListener (){ 
    public void actionPerformed(ActionEvent e){ 
        Sistema();
        EntradaSalida();
        Usuario();
    }       
    }); 
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        
        if("".equals(TxtArea_Listo.getText())){
            Proc = new Procesos();
            Proc.nuevo();
            Proc.nuevoBloqueadoSistema();
            Proc.nuevoSuspendidoSistema();
            Proc.nuevoBloqueadoEntradaSalida();
            Proc.nuevoSuspendidoEntradaSalida();
            Proc.nuevoBloqueadoUsuario();
            Proc.nuevoSuspendidoUsuario();            
            Proc.Iniciar();             
            int pCPU = Proc.promedioCPU;        
            String text = Integer.toString(pCPU);        
            PromedioCPU.setText(text);
            a = new int [100][4];
            m = new int [1000];
            for(int i=0;i<m.length;i++){
                    m[i]=-1;                
            }
            for(int i=0;i<100;i++){
                for(int j=0;j<4;j++){
                    a[i][j]=-1;                
                }
            }
        }        
        timer.start();
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        if(paso==0){
            timer.stop();
            pas=true;
        }
        if(paso==1){
            timer.start();
            pas=false;
        }
        if(pas==false){
            paso=0;
        }
        if(pas==true){            
            paso=1;
        }
    }//GEN-LAST:event_PauseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            if(Integer.parseInt(jTextField3.getText())<=1000000 && 
               Integer.parseInt(jTextField3.getText())>0 &&
               Integer.parseInt(jTextField4.getText())<=1000000 &&
               Integer.parseInt(jTextField4.getText())>0 &&               
               Integer.parseInt(jTextField6.getText())<=1000000 &&
               Integer.parseInt(jTextField6.getText())>0){
               primera=true;               
               Proc.nuevo=Proc.p.sig;               
               int h=0;
               boolean c = false;
               while(Proc.nuevo!=Proc.p||Integer.parseInt(jTextField4.getText())==h){
                     h=Proc.nuevo.proceso;
                     Proc.nuevo=Proc.nuevo.sig;          
                     if(Integer.parseInt(jTextField4.getText())==h){
                         JOptionPane.showMessageDialog(null, "el proceso con el id: "+Integer.parseInt(jTextField4.getText())+" ya existe!!!");
                         int g = Integer.parseInt(jTextField4.getText())+1;
                         String text = String.valueOf(g);
                         jTextField4.setText(text);
                         c = true;
                         Proc.nuevo=Proc.p;
                     }                     
               }
               if(c==false){
                    Proc.nuevo = new nodo();
                    Proc.nuevo.proceso= Integer.parseInt(jTextField4.getText());
                    Proc.nuevo.tiempo=Integer.parseInt(jTextField3.getText());
                    Proc.nuevo.prioridad=Integer.parseInt(jTextField6.getText());
                    if(Proc.nuevo.prioridad==1){
                        if(Proc.nuevo.tiempo<=Proc.promedioCPU){
                            Proc.nuevo.QTM = Proc.nuevo.tiempo;
                        }else{
                            Proc.nuevo.QTM = Proc.promedioCPU+(Proc.nuevo.tiempo/Proc.promedioCPU);
                        }
                    }else{
                        Proc.nuevo.QTM = 0;
                    }                    
                    Proc.cab.sig=Proc.nuevo;
                    Proc.nuevo.sig=Proc.p; 
                    Proc.cab=Proc.nuevo;
                    TxtArea_Listo.setText("");
                    nuevo=Proc.p.sig;                    
                    ordenar(Proc.nuevo, Proc.cab, Proc.p);
                    while(nuevo!=Proc.p){
                         String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " \t " + nuevo.prioridad + " ";
                         Interfaz.agregarTxtArea_Listo(texto);                                            
                         nuevo=nuevo.sig;
                     }                     
                     jTextField3.setText("");
                     jTextField4.setText("");                     
                     jTextField6.setText("");
               }
        }
        }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "solo se admiten numeros!!!");
                jTextField3.setText("");
                jTextField4.setText("");                
                jTextField6.setText("");
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            Gantt.setVisible(true); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void PromedioCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PromedioCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PromedioCPUActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Gantt;
    private javax.swing.JButton Pause;
    private javax.swing.JTextField PromedioCPU;
    public static javax.swing.JTextArea TxtArea_BloqueadoEntradaSalida;
    public static javax.swing.JTextArea TxtArea_BloqueadoSistema;
    public static javax.swing.JTextArea TxtArea_BloqueadoUsuario;
    public static javax.swing.JTextArea TxtArea_Listo;
    public static javax.swing.JTextArea TxtArea_SuspendidoEntradaSalida;
    public static javax.swing.JTextArea TxtArea_SuspendidoSistema;
    public static javax.swing.JTextArea TxtArea_en_ejecucionEntradaSalida;
    public static javax.swing.JTextArea TxtArea_en_ejecucionSistema;
    public static javax.swing.JTextArea TxtArea_en_ejecucionUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
