package roundrobin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Interfaz extends javax.swing.JFrame {
    
    private nodo en_ejecucion, aux, nuevo;
    private Procesos Proc;
    private int a[][];
    private int cont=0;
    private int contaux=1;
    public Interfaz() {
        this.en_ejecucion = null;    
        this.setTitle(".....:::::Algoritmo Round Robin 1.0:::::.....");
        initComponents();
        
    }
    public static void agregarTxtArea_Listo1(String text){
        TxtArea_Listo1.append("\n"+text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gantt = new javax.swing.JFrame();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Tabla_gantt = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonBloquear = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIniciar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtArea_en_ejecucion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtArea_Listo1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TxtArea_Bloqueado = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxtArea_Suspendido = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        PromedioCPU = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        Gantt.setTitle("..::Diagrama de Gantt::..");
        Gantt.setBounds(new java.awt.Rectangle(550, 270, 725, 455));
        Gantt.setResizable(false);
        Gantt.getContentPane().setLayout(null);

        jLabel24.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 24)); // NOI18N
        jLabel24.setText("Diagrama de Gantt");
        Gantt.getContentPane().add(jLabel24);
        jLabel24.setBounds(280, 10, 220, 40);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Procesos");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Gantt.getContentPane().add(jLabel28);
        jLabel28.setBounds(20, 80, 50, 10);

        jLabel27.setText("Quantum en ejecucion");
        Gantt.getContentPane().add(jLabel27);
        jLabel27.setBounds(340, 50, 150, 14);

        Tabla_gantt.setAutoCreateRowSorter(true);
        Tabla_gantt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        Tabla_gantt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"P1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P2", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P3", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P4", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P5", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P6", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P7", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P8", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P9", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P10", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P11", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P12", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P13", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P14", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P15", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P16", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P17", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P18", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P19", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"P20", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(Tabla_gantt);

        Gantt.getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(30, 70, 680, 350);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo_gantt.jpg"))); // NOI18N
        Gantt.getContentPane().add(jLabel25);
        jLabel25.setBounds(0, 0, 720, 440);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(10, 10, 707, 603));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(795, 630));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Proceso");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 140, 50, 10);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Quantum Asignado");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(180, 140, 80, 10);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantum Requerido");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(90, 140, 80, 10);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Proceso");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(290, 140, 50, 10);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Proceso");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(540, 140, 50, 10);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Quantum Requerido");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(590, 140, 80, 10);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Proceso");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(540, 350, 50, 10);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quantum Requerido");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(590, 350, 80, 10);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Quantum Asignado");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(680, 350, 80, 10);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quantum Asignado");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(680, 140, 80, 10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quantum Requerido");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(340, 140, 80, 10);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Quantum Asignado");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(430, 140, 80, 10);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 255));
        jLabel1.setText("LISTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 120, 33, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 255));
        jLabel2.setText("EN EJECUCIÓN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 120, 90, 14);

        jButtonBloquear.setText("BLOQUEAR");
        jButtonBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBloquearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBloquear);
        jButtonBloquear.setBounds(400, 570, 120, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(24, 549, 693, 2);

        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciar);
        jButtonIniciar.setBounds(270, 570, 100, 23);

        jLabel17.setBackground(new java.awt.Color(0, 51, 51));
        jLabel17.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Algoritmo Round Robin");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(275, 11, 241, 46);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(73, 63, 605, 11);

        TxtArea_en_ejecucion.setEditable(false);
        TxtArea_en_ejecucion.setColumns(20);
        TxtArea_en_ejecucion.setRows(5);
        jScrollPane3.setViewportView(TxtArea_en_ejecucion);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(280, 150, 240, 380);

        TxtArea_Listo1.setEditable(false);
        TxtArea_Listo1.setColumns(20);
        TxtArea_Listo1.setRows(5);
        jScrollPane2.setViewportView(TxtArea_Listo1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 150, 240, 380);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3.setText("BLOQUEADO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(610, 330, 67, 14);

        TxtArea_Bloqueado.setEditable(false);
        TxtArea_Bloqueado.setColumns(20);
        TxtArea_Bloqueado.setRows(5);
        jScrollPane4.setViewportView(TxtArea_Bloqueado);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(530, 360, 240, 170);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 255));
        jLabel4.setText("SUSPENDIDO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(610, 120, 71, 14);

        TxtArea_Suspendido.setEditable(false);
        TxtArea_Suspendido.setColumns(20);
        TxtArea_Suspendido.setRows(5);
        jScrollPane5.setViewportView(TxtArea_Suspendido);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(530, 150, 240, 150);

        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText("PromedioCPU:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 20, 90, 30);

        PromedioCPU.setEditable(false);
        PromedioCPU.setText("0");
        PromedioCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PromedioCPUActionPerformed(evt);
            }
        });
        getContentPane().add(PromedioCPU);
        PromedioCPU.setBounds(130, 20, 50, 30);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel26);
        jLabel26.setBounds(30, 20, 100, 30);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel22);
        jLabel22.setBounds(530, 100, 240, 50);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel23);
        jLabel23.setBounds(530, 310, 240, 50);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel20);
        jLabel20.setBounds(280, 100, 240, 50);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel21);
        jLabel21.setBounds(30, 100, 240, 50);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-1, 1, 790, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Timer timer = new Timer (300, new ActionListener (){ 
    public void actionPerformed(ActionEvent e){ 
        if(Proc.pS != Proc.pS.sig){ 
            Proc.nuevoS=Proc.pS.sig;            
            if(Proc.nuevoS.TSUSP != 1){ 
                while(Proc.nuevoS != Proc.pS){
                    Proc.nuevoS.TSUSP = Proc.nuevoS.TSUSP-1;
                    Proc.nuevoS=Proc.nuevoS.sig;
                }
                
                TxtArea_Suspendido.setText("");
                Proc.nuevoS=Proc.pS.sig;
                while(Proc.nuevoS != Proc.pS){
                    TxtArea_Suspendido.append("\n" + Proc.nuevoS.proceso + ".\t " + Proc.nuevoS.tiempo + " \t " + Proc.nuevoS.TSUSP + " ");                
                    Proc.nuevoS=Proc.nuevoS.sig;
                }
            }
            if(Proc.nuevoS.TSUSP == 1){                 
                Proc.nuevo = new nodo();
                Proc.nuevo.proceso=Proc.nuevoS.proceso;
                Proc.nuevo.tiempo=Proc.nuevoS.tiempo;
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
                    String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " ";
                    Interfaz.agregarTxtArea_Listo1(texto);                   
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
                    TxtArea_Suspendido.append("\n" + Proc.nuevoS.proceso + ".\t " + Proc.nuevoS.tiempo + " \t " + Proc.nuevoS.TSUSP + " ");                
                    Proc.nuevoS=Proc.nuevoS.sig;
                }
            }
            
        }        
        if(Proc.pB != Proc.pB.sig){ 
            Proc.nuevoB=Proc.pB.sig;            
            if(Proc.nuevoB.TBLOQ != 1){ 
                while(Proc.nuevoB != Proc.pB){
                    Proc.nuevoB.TBLOQ = Proc.nuevoB.TBLOQ-1;
                    Proc.nuevoB=Proc.nuevoB.sig;
                }
                
                TxtArea_Bloqueado.setText("");
                Proc.nuevoB=Proc.pB.sig;
                while(Proc.nuevoB != Proc.pB){
                    TxtArea_Bloqueado.append("\n" + Proc.nuevoB.proceso + ".\t " + Proc.nuevoB.tiempo + " \t " + Proc.nuevoB.TBLOQ + " ");                
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
                    String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " ";
                    Interfaz.agregarTxtArea_Listo1(texto);                   
                    nuevo=nuevo.sig;
                }
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
                    TxtArea_Bloqueado.append("\n" + Proc.nuevoB.proceso + ".\t " + Proc.nuevoB.tiempo + " \t " + Proc.nuevoB.TBLOQ + " ");                
                    Proc.nuevoB=Proc.nuevoB.sig;
                }    
            }            
        }    
        if(en_ejecucion != null){ 
            if(en_ejecucion.QTM == 1){                
                TxtArea_en_ejecucion.setText("");
                if(en_ejecucion.tiempo == 1){
                    en_ejecucion = null;                    
                }else{
                    Proc.nuevoS =new nodo();
                    Proc.nuevoS.proceso=en_ejecucion.proceso;
                    Proc.nuevoS.tiempo=en_ejecucion.tiempo - 1;
                    Proc.nuevoS.QTM=en_ejecucion.QTM - 1;                    
                    Proc.nuevoS.TSUSP=Proc.promedioCPU;
                    Proc.cabS.sig=Proc.nuevoS;
                    Proc.nuevoS.sig=Proc.pS; 
                    Proc.cabS=Proc.nuevoS;
                    en_ejecucion = null;                    
                    TxtArea_Suspendido.append("\n" + Proc.nuevoS.proceso + ".\t " + Proc.nuevoS.tiempo + " \t " + Proc.nuevoS.TSUSP + " ");                
                }
            }else{
                if(aux==aux.sig){
                   TxtArea_en_ejecucion.setText("");
                }else{
                    en_ejecucion.tiempo = en_ejecucion.tiempo - 1;
                    en_ejecucion.QTM =en_ejecucion.QTM -1;                    
                    TxtArea_en_ejecucion.setText("");                    
                    TxtArea_en_ejecucion.append(en_ejecucion.proceso + ".\t " + en_ejecucion.tiempo + " \t " + en_ejecucion.QTM + " ");                    
                    if(cont==20){                        
                        for (int i=0;i<20;i++){
                            for (int j=1;j<21;j++){                            
                                Tabla_gantt.setValueAt(" ", i, j);
                                
                            }
                        }
                        for (int i=0;i<20;i++){
                            for (int j=0;j<2;j++){                            
                                if(i<19){
                                    a[i][j]=a[i+1][j];                                    
                                    if(j==1){
                                       Tabla_gantt.setValueAt("X", a[i][j-1]-1, i+1);
                                    }
                                }
                                if(i==19){
                                    if(j==0){
                                       a[i][j]=en_ejecucion.proceso;                                       
                                    }
                                    if(j==1){
                                        if(a[i-1][j-1]==en_ejecucion.proceso){
                                           a[i][j]=contaux;
                                           Tabla_gantt.setValueAt("X", a[i][j-1]-1, i+1);
                                           contaux=contaux+1;
                                        }
                                        if(a[i-1][j-1]!=en_ejecucion.proceso){
                                            contaux=1;
                                            a[i][j]=contaux;
                                            Tabla_gantt.setValueAt("X", a[i][j-1]-1, i+1);
                                            contaux=contaux+1;
                                        }                                        
                                    }                                    
                                }
                            }
                        }
                        cont=cont-1;
                    }
                    if(cont<=19){
                       for (int j=0;j<2;j++){                            
                            if(j==0){
                                a[cont][j]=en_ejecucion.proceso;                      
                            }
                            if(j==1 && cont>0){
                               if(a[cont-1][j-1]==en_ejecucion.proceso){
                                  a[cont][j]=contaux;
                                  Tabla_gantt.setValueAt("X", a[cont][j-1]-1, cont+1);
                                  contaux=contaux+1;
                               }
                               if(a[cont-1][j-1]!=en_ejecucion.proceso){
                                  contaux=1;
                                  a[cont][j]=contaux;
                                  Tabla_gantt.setValueAt("X", a[cont][j-1]-1, cont+1);
                                  contaux=contaux+1;
                               } 
                            }
                            if(j==1 && cont==0){                               
                                  a[cont][j]=contaux;    
                                  Tabla_gantt.setValueAt("X", a[cont][j-1]-1, cont+1);
                                  contaux=contaux+1;
                            }
                        }
                    }
                    cont=cont+1;
                }
            }
        }
        
        if(en_ejecucion == null){
            en_ejecucion = Proc.p.sig;            
            aux=Proc.p;
            if(aux==aux.sig){
                    en_ejecucion=null;
                   TxtArea_en_ejecucion.setText("");
            }else{
                aux=Proc.p.sig;
                Proc.p.sig=aux.sig;
                String borrar = "";
                TxtArea_Listo1.setText(borrar);
                nuevo=Proc.p.sig;
                int cont=1;
                    while(nuevo!=Proc.p){
                        String texto = nuevo.proceso + ".\t  " + nuevo.tiempo + " \t " + nuevo.QTM + " ";
                        Interfaz.agregarTxtArea_Listo1(texto);
                        cont++;                       
                        nuevo=nuevo.sig;
                    } 
               if( en_ejecucion != Proc.p){                   
                   TxtArea_en_ejecucion.setText("");                   
                   TxtArea_en_ejecucion.append("\n"+en_ejecucion.proceso + ".\t " + en_ejecucion.tiempo + " \t " + en_ejecucion.QTM + " ");
               }else{
                   en_ejecucion=null;
                   TxtArea_en_ejecucion.setText("");
               }
            
            }
        }
        if(Proc.p==Proc.p.sig){
           Proc.nuevo();
        }
        Tabla_gantt.setValueAt(" ", 0, 1);
    } 
    }); 
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        timer.start();        
        a = new int [20][2];
        for (int i=0;i<20;i++){
            for (int j=0;j<2;j++){
                a[i][j]=0;        
            }
        }
        for (int i=0;i<20;i++){
            for (int j=1;j<21;j++){                                            
                Tabla_gantt.setValueAt(" ", i, j);
            }
        }
        cont=0;
        contaux=1;        
        Gantt.setVisible(true);
        if("".equals(TxtArea_Listo1.getText())){
            Proc = new Procesos();
            Proc.nuevo();
            Proc.nuevoSuspendido();
            Proc.nuevoBloqueado();
            Proc.Iniciar(); 
            int c = Proc.promedioCPU;        
            String text = Integer.toString(c);        
            PromedioCPU.setText(text);
        }        
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBloquearActionPerformed
        if(TxtArea_Bloqueado.getText().equals("") && TxtArea_en_ejecucion.getText().equals("") && TxtArea_Listo1.getText().equals("")){
        }else{
            Proc.nuevoB =new nodo();
            Proc.nuevoB.proceso=en_ejecucion.proceso;
            Proc.nuevoB.tiempo=en_ejecucion.tiempo;
            Proc.nuevoB.QTM=en_ejecucion.QTM - 1;            
            Proc.nuevoB.TBLOQ=Proc.promedioCPU;
            Proc.cabB.sig=Proc.nuevoB;
            Proc.nuevoB.sig=Proc.pB; 
            Proc.cabB=Proc.nuevoB;
            en_ejecucion = null;            
            TxtArea_Bloqueado.append("\n" + Proc.nuevoB.proceso + ".\t " + Proc.nuevoB.tiempo + " \t " + Proc.nuevoB.TBLOQ + " ");                         
        }
    }//GEN-LAST:event_jButtonBloquearActionPerformed

    private void PromedioCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PromedioCPUActionPerformed

    }//GEN-LAST:event_PromedioCPUActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Gantt;
    private javax.swing.JTextField PromedioCPU;
    private javax.swing.JTable Tabla_gantt;
    public static javax.swing.JTextArea TxtArea_Bloqueado;
    public static javax.swing.JTextArea TxtArea_Listo1;
    public static javax.swing.JTextArea TxtArea_Suspendido;
    public static javax.swing.JTextArea TxtArea_en_ejecucion;
    private javax.swing.JButton jButtonBloquear;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
