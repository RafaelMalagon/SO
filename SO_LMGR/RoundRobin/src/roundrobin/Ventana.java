/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobin;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

 

/**
 *
 * @author Malagon
 */
public class Ventana extends javax.swing.JFrame {
    private String textolista1;
    private nodo critico, aux, nuevo;
    //private nodo suspendido, nuevoS,cabS,pS,auxS;
    private Procesos Proc;
    private int paso=0;
    private boolean pas=false;
    private String tiempoT;
    private int w=0;
    
    //PasarTabla pasa=null;
    

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        this.critico = null;
        initComponents();
        
    }
    public static void agregarTxtArea_Listo1(String text){
        TxtArea_Listo1.append("\n"+text);
    }
    
    public void insertarValores (JTable ta){
        
        String []columna = {"Proceso","t0"};              
        
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        //dtm.addColumn(tiempoTab);
        for (int i=1;i<11;i++){
            String []fila = {"p "+i , "E"};
            dtm.addRow(fila);            
        }
        
                        
        ta.setModel(dtm);   
        
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtArea_Listo1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtArea_CRITICO = new javax.swing.JTextArea();
        jButtonIniciar = new javax.swing.JButton();
        jButtonQuantum = new javax.swing.JButton();
        jButtonBloquear = new javax.swing.JButton();
        jBDetener = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TxtArea_Bloqueado = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxtArea_Suspendido = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TxtArea_Listo1.setColumns(20);
        TxtArea_Listo1.setEditable(false);
        TxtArea_Listo1.setRows(5);
        jScrollPane2.setViewportView(TxtArea_Listo1);

        TxtArea_CRITICO.setColumns(20);
        TxtArea_CRITICO.setEditable(false);
        TxtArea_CRITICO.setRows(5);
        jScrollPane3.setViewportView(TxtArea_CRITICO);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonIniciar.setText("PROCESOS");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jButtonQuantum.setText("EJECUTAR");
        jButtonQuantum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuantumActionPerformed(evt);
            }
        });

        jButtonBloquear.setText("BLOQUEAR");
        jButtonBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBloquearActionPerformed(evt);
            }
        });

        jBDetener.setText("PUASAR/REANUDAR");
        jBDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetenerActionPerformed(evt);
            }
        });

        TxtArea_Bloqueado.setColumns(20);
        TxtArea_Bloqueado.setEditable(false);
        TxtArea_Bloqueado.setRows(5);
        jScrollPane4.setViewportView(TxtArea_Bloqueado);

        jLabel3.setText("BLOQUEADO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        TxtArea_Suspendido.setColumns(20);
        TxtArea_Suspendido.setEditable(false);
        TxtArea_Suspendido.setRows(5);
        jScrollPane5.setViewportView(TxtArea_Suspendido);

        jLabel4.setText("SUSPENDIDO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Proceso", "t1", "t2", "t3"
            }
        ));
        tabla.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tabla);
        tabla.getAccessibleContext().setAccessibleParent(jScrollPane2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBDetener, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBloquear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonQuantum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButtonIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBloquear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonQuantum)
                        .addGap(6, 6, 6)
                        .addComponent(jBDetener))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setText("ESPERA");

        jLabel2.setText("EN PROCESO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(245, 245, 245))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Timer timer = new Timer (1800, new ActionListener(){
        public void actionPerformed(ActionEvent e){
        w++;
        String tiempoT="t"+w;               
        DefaultTableModel modelo= (DefaultTableModel)tabla.getModel();
        
        modelo.addColumn(tiempoT);
        System.out.print(tiempoT);      
        
        TableColumn columna = tabla.getColumn("Proceso");
        columna.setMinWidth(70);
        TableColumn columnaAdd = tabla.getColumn(tiempoT);
        columnaAdd.setMinWidth(50);
       
        //AQUI INICIA LA PARTE DEL ANALISIS DE QUANTUMS DE SUSPENDIDO
        
        if(Proc.pS != Proc.pS.sig){ 
            Proc.nuevoS=Proc.pS.sig;
            System.out.println("entro1");
            if(Proc.nuevoS.TSUSP != 1){ 
                System.out.println("entro2");
                while(Proc.nuevoS != Proc.pS){
                    Proc.nuevoS.TSUSP = Proc.nuevoS.TSUSP-1;
                    Proc.nuevoS=Proc.nuevoS.sig;
                }
                                                                                                //AHORA REPINTO SUSPENDIDO
                
                TxtArea_Suspendido.setText("");
                Proc.nuevoS=Proc.pS.sig;
                Proc.nuevoS.estado="Su";                                                       
                while(Proc.nuevoS != Proc.pS){
                    TxtArea_Suspendido.append("\n" + Proc.nuevoS.proceso + ".\t[" + Proc.nuevoS.tiempo + "]\t[" + Proc.nuevoS.TSUSP + "]"+" E"+Proc.nuevoS.estado);                
                    //pintando en la tabla °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
                    modelo.setValueAt(Proc.nuevoS.estado, Proc.nuevoS.proceso,   w+1);
                    Proc.nuevoS=Proc.nuevoS.sig;
                }
             
                
            }
            if(Proc.nuevoS.TSUSP == 1){ 
                
               System.out.println("entro a LISTO");
                Proc.nuevo = new nodo();
                Proc.nuevo.proceso=Proc.nuevoS.proceso;
                Proc.nuevo.tiempo=Proc.nuevoS.tiempo;
                Proc.nuevo.estado="E";                                                                            // cambio de estado en proceso
                if(Proc.nuevo.tiempo<=Proc.promedioCPU){
                    Proc.nuevo.QTM = Proc.nuevo.tiempo;
                }else{
                    Proc.nuevo.QTM = Proc.promedioCPU+(Proc.promedioCPU / Proc.promedioCPU);
                }
                
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;
                
                
                TxtArea_Listo1.setText("");
                
                nuevo=Proc.p.sig;
                while(nuevo!=Proc.p){

                    String texto = nuevo.proceso + ".\t [" + nuevo.tiempo + "]\t[" + nuevo.QTM + "]"+" E"+Proc.nuevoS.estado;
                    Ventana.agregarTxtArea_Listo1(texto);
                    
                    modelo.setValueAt(Proc.nuevoS.estado, Proc.nuevo.id,   w+1);
                   
                   nuevo=nuevo.sig;
                }

                
                Proc.auxS=Proc.pS;
                if(Proc.auxS==Proc.auxS.sig){
                    TxtArea_Suspendido.setText("no hay procesos en suspendido");
                }else{
                    Proc.auxS=Proc.pS.sig;
                    Proc.pS.sig=Proc.auxS.sig;
                    if(Proc.pS==Proc.pS.sig){
                        Proc.nuevoSuspendido();
                    }
                }
                
                
                TxtArea_Suspendido.setText("");
                Proc.nuevoS=Proc.pS.sig;
                while(Proc.nuevoS != Proc.pS){
                    TxtArea_Suspendido.append("\n" + Proc.nuevoS.proceso + ".\t[" + Proc.nuevoS.tiempo + "]\t[" + Proc.nuevoS.TSUSP + "]"+" E"+Proc.nuevoS.estado);                
                    //ahora lo pinto en la tabla °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
                    modelo.setValueAt(Proc.nuevoS.estado, Proc.nuevo.id,   w+1);
                    Proc.nuevoS=Proc.nuevoS.sig;
                }    
                    
            
                    
                    
                    
                
            }
            
        }        
       
        //AQUI INICIA LA PARTE DEL ANALISIS DE QUANTUMS DE BLOQUEADO
        
        if(Proc.pB != Proc.pB.sig){ 
            Proc.nuevoB=Proc.pB.sig;
            if(Proc.nuevoB.TBLOQ != 1){ 
                while(Proc.nuevoB != Proc.pB){
                    Proc.nuevoB.TBLOQ = Proc.nuevoB.TBLOQ-1;
                    Proc.nuevoB=Proc.nuevoB.sig;
                }
                
                TxtArea_Bloqueado.setText("");
                //ahora lo pinto en la tabla °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
                modelo.setValueAt(Proc.nuevoS.estado, Proc.nuevo.proceso,   w);
                Proc.nuevoB=Proc.pB.sig;
                while(Proc.nuevoB != Proc.pB){//se repite hasta encontrar el ultimo nodo
                    TxtArea_Bloqueado.append("\n" + Proc.nuevoB.proceso + ".\t[" + Proc.nuevoB.tiempo + "]\t[" + Proc.nuevoB.TBLOQ + "]"+" E"+Proc.nuevoB.estado);                
                    modelo.setValueAt(Proc.nuevoB.estado,Proc.nuevoB.proceso,w+1);
                    Proc.nuevoB=Proc.nuevoB.sig;
                }
             
                
            }
            if(Proc.nuevoB.TBLOQ == 1){ 
                Proc.nuevo = new nodo();
                Proc.nuevo.proceso=Proc.nuevoB.proceso;
                Proc.nuevo.tiempo=Proc.nuevoB.tiempo;
                if(Proc.nuevo.tiempo<=Proc.promedioCPU){
                    Proc.nuevo.QTM = Proc.nuevo.tiempo;
                }else{
                    Proc.nuevo.QTM = Proc.promedioCPU+(Proc.promedioCPU / Proc.promedioCPU);
                }
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;
                
                
                TxtArea_Listo1.setText("");
                nuevo=Proc.p.sig;
                while(nuevo!=Proc.p){

                    String texto = nuevo.proceso + ".\t [" + nuevo.tiempo + "]\t[" + nuevo.QTM + "]"+" E"+Proc.nuevo.estado;
                    Ventana.agregarTxtArea_Listo1(texto);
                   
                   //ahora pinto en la tabla °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
                   modelo.setValueAt(Proc.nuevo.estado, Proc.nuevo.proceso,   w+1); 
                   nuevo=nuevo.sig;//ubicar el siguiente nodo a mostrar
                }

                // lo elimino de la cola de BLOQUEADO
                Proc.auxB=Proc.pB;
                if(Proc.auxB==Proc.auxB.sig){
                    TxtArea_Bloqueado.setText("");
                }else{
                    Proc.auxB=Proc.pB.sig;
                    Proc.pB.sig=Proc.auxB.sig;
                    if(Proc.pB==Proc.pB.sig){
                        Proc.nuevoBloqueado();
                    }
                }
                
                
                
                TxtArea_Bloqueado.setText("");
                Proc.nuevoB=Proc.pB.sig;
                while(Proc.nuevoB != Proc.pB){
                    Proc.nuevoB.TBLOQ = Proc.nuevoB.TBLOQ -1;
                    TxtArea_Bloqueado.append("\n" + Proc.nuevoB.proceso + ".\t[" + Proc.nuevoB.tiempo + "]\t[" + Proc.nuevoB.TBLOQ + "]"+" E"+Proc.nuevoB.estado);  
                    //ahora pintamos en la tabla °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
                    modelo.setValueAt(Proc.nuevoB.estado, Proc.nuevoB.proceso,   w+1);
                    Proc.nuevoB=Proc.nuevoB.sig;
                }    
                              
                    
                    
                    
                
            }
            
        }
        
        //#################################################################
        //AQUI INICIA LA PARTE DEL ANALISIS DE QUANTUMS DE CRITICO
        
        if(critico != null){ //revisa si hay algo en critico
            if(critico.QTM == 1){
                TxtArea_CRITICO.setText("");
                if(critico.tiempo == 1){
                    critico = null;
                }else{
                    Proc.nuevoS =new nodo();
                    Proc.nuevoS.proceso=critico.proceso;
                    Proc.nuevoS.tiempo=critico.tiempo - 1;
                    Proc.nuevoS.QTM=critico.QTM - 1;
                    //aqui va el quantum de Suspendido
                    Proc.nuevoS.TSUSP=Proc.promedioCPU;
                    Proc.cabS.sig=Proc.nuevoS;
                    Proc.nuevoS.estado="Sus";                                                                   // cambio de estado a suspendido
                    Proc.nuevoS.sig=Proc.pS; 
                    Proc.cabS=Proc.nuevoS;
                    critico = null;
                    
                    TxtArea_Suspendido.append("\n" + Proc.nuevoS.proceso + ".\t[" + Proc.nuevoS.tiempo + "]\t[" + Proc.nuevoS.TSUSP + "] "+Proc.nuevoS.estado);                
                    //ahora pintamos en la tabla °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
                    modelo.setValueAt(Proc.nuevoS.estado, Proc.nuevoS.proceso-1,   w+1);

                }
                
                
            }else{ 
                if(aux==aux.sig){
                   TxtArea_CRITICO.setText("");
                }else{
                    critico.tiempo = critico.tiempo - 1;
                    critico.QTM =critico.QTM -1;
                    critico.estado="P";                                                                         // cambio de estado a critico C
                    
                    TxtArea_CRITICO.setText("");
                    //TxtArea_CRITICO.setText("hola");
                    TxtArea_CRITICO.append(critico.proceso + ".\t[" + critico.tiempo + "]\t[" + critico.QTM + "]"+" E "+critico.estado);
                    modelo.setValueAt(critico.estado, critico.proceso-1,   w+1);                                     // pintado en la tabla el cambio de estado a en Proceso P
                }
            }
        }
        
        if(critico == null){
            critico = Proc.p.sig;
            
            aux=Proc.p;//guardar la direccion del primer nodo
            if(aux==aux.sig){
                    critico=null;
                   TxtArea_CRITICO.setText("");
            }else{
                aux=Proc.p.sig;
                Proc.p.sig=aux.sig;
                
                String borrar = "";
                TxtArea_Listo1.setText(borrar);
                nuevo=Proc.p.sig;
                int cont=1;
                    while(nuevo!=Proc.p){

                        String texto = nuevo.proceso + ".\t [" + nuevo.tiempo + "]\t[" + nuevo.QTM + "]"+" E"+nuevo.estado;
                        Ventana.agregarTxtArea_Listo1(texto);
                        cont++;
                       
                       nuevo=nuevo.sig;
                    }
               

               if( critico != Proc.p){
                   
                   TxtArea_CRITICO.setText("");
                   
                   TxtArea_CRITICO.append(critico.proceso + ".\t[" + critico.tiempo + "]\t[" + critico.QTM + "]"+" E"+critico.estado);
               }else{
                   critico=null;
                   TxtArea_CRITICO.setText("");
               }
            
            }
        }
        if(Proc.p==Proc.p.sig){
                        Proc.nuevo();
                    }
        
        //#################################################################
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
           
                
            }
        });
    
    
    private void jButtonQuantumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuantumActionPerformed
               
        timer.start();        
        
    }//GEN-LAST:event_jButtonQuantumActionPerformed

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        // TODO add your handling code here:
        if("".equals(TxtArea_Listo1.getText())){
            Proc = new Procesos();
            Proc.nuevo();
            Proc.nuevoSuspendido();
            Proc.nuevoBloqueado();
            Proc.Iniciar(); 
        }
        insertarValores(tabla);    
        /*
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla().setVisible(true);
            }
        });  
        */
        
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBloquearActionPerformed
        // TODO add your handling code here:
        if(TxtArea_Bloqueado.getText().equals("") && TxtArea_CRITICO.getText().equals("") && TxtArea_Listo1.getText().equals("")){
        
        }else{
            Proc.nuevoB =new nodo();//pedir memoria, generar un nodo
            Proc.nuevoB.proceso=critico.proceso;//asignar numero de proceso
            Proc.nuevoB.tiempo=critico.tiempo;//tiempo de cpu que requiere
            Proc.nuevoB.QTM=critico.QTM - 1;
            //aqui va el quantum de Suspendido
            Proc.nuevoB.TBLOQ=Proc.promedioCPU;
            Proc.cabB.sig=Proc.nuevoB;//Actualiza el enlace para apuntar al siguiente nodo 
            Proc.nuevoB.sig=Proc.pB; //actualiza el ultimo nodo con la direccion del primero
            Proc.cabB=Proc.nuevoB;// actualizar el contenido de la variable para recibir el siguiente nodo
            critico = null;
            //repinto BLOQUEADO
            TxtArea_Bloqueado.append("\n" + Proc.nuevoB.proceso + ".\t[" + Proc.nuevoB.tiempo + "]\t[" + Proc.nuevoB.TBLOQ + "]");                
            jButtonQuantum.doClick();
        }
    }//GEN-LAST:event_jButtonBloquearActionPerformed

    private void jBDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDetenerActionPerformed
        
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
    }//GEN-LAST:event_jBDetenerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
               
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea TxtArea_Bloqueado;
    public static javax.swing.JTextArea TxtArea_CRITICO;
    public static javax.swing.JTextArea TxtArea_Listo1;
    public static javax.swing.JTextArea TxtArea_Suspendido;
    private javax.swing.JButton jBDetener;
    private javax.swing.JButton jButtonBloquear;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonQuantum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
