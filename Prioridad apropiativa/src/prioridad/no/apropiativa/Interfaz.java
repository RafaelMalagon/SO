package prioridad.no.apropiativa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Interfaz extends javax.swing.JFrame {
    
    private nodo en_ejecucion, aux, nuevo;
    private Procesos Proc;
    private int a[][];    
    private int m[];
    int conttable=0;
    int contuni=0;
    private int paso=0;
    private int bloq=0;
    private boolean pas=false;
    private boolean primera=true;
    public Interfaz() {
        this.en_ejecucion = null;    
        this.setTitle(".....:::::Prioridad no Apropiativa 1.0:::::.....");
        initComponents();
        
    }
    public static void agregarTxtArea_Listo1(String text){
        TxtArea_Listo1.append("\n"+text);
    }
    public void comparar (){
        if(Proc.p.sig.tiempo!=0&&Proc.p.sig.proceso!=0){
            if(Proc.p.sig.prioridad<en_ejecucion.prioridad){
                    Proc.nuevoS =new nodo();
                    Proc.nuevoS.proceso=en_ejecucion.proceso;
                    Proc.nuevoS.tiempo=en_ejecucion.tiempo;
                    Proc.nuevoS.TSUSP=en_ejecucion.TSUSP - 1;
                    Proc.nuevoS.prioridad=en_ejecucion.prioridad;
                    int x=0;
                    double y=0;
                    while (x<2){
                          y =  (int) Math.round(Math.random()*3);
                          x = (int) y;
                    }
                    Proc.nuevoS.TSUSP=x;
                    Proc.cabS.sig=Proc.nuevoS;
                    Proc.nuevoS.sig=Proc.pS; 
                    Proc.cabS=Proc.nuevoS;
                    en_ejecucion = null;
                    TxtArea_Suspendido.append("\n" + Proc.nuevoS.proceso + ".\t " + Proc.nuevoS.tiempo + " \t " + Proc.nuevoS.TSUSP + " ");                                    
            }        
        }
    }
    public void ordenar (nodo nuevo, nodo cab, nodo p){
        int aux0;
        int aux1;
        int aux2;        
        int b[][];
        int cont2=0;
        nuevo=p.sig;
        while(nuevo!=p){
           cont2=cont2+1;
           nuevo=nuevo.sig;
        }
        b = new int [cont2][3];
        nuevo=p.sig;
        int contor=0;
        while(nuevo!=p){
            b[contor][0]=nuevo.proceso;
            b[contor][1]=nuevo.tiempo;
            b[contor][2]=nuevo.prioridad;
            nuevo=nuevo.sig;
            contor=contor+1;
        }    
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b.length-i-1;j++){
                if(b[j+1][2]<b[j][2]){
                  aux0=b[j+1][0];
                  aux1=b[j+1][1];
                  aux2=b[j+1][2];
                  b[j+1][0]=b[j][0];
                  b[j+1][1]=b[j][1];
                  b[j+1][2]=b[j][2];
                 b[j][0]=aux0;
                 b[j][1]=aux1;
                 b[j][2]=aux2;
                }
           }
        }    
        nuevo=p.sig;
        contor=0;
        while(nuevo!=p){
            nuevo.proceso=b[contor][0];
            nuevo.tiempo=b[contor][1];
            nuevo.prioridad=b[contor][2];
            nuevo=nuevo.sig;
            contor=contor+1;
        }  
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
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxtArea_Suspendido = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Pause = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

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
        setMinimumSize(new java.awt.Dimension(795, 630));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID Proceso");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 140, 50, 10);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Prioridad");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(190, 140, 80, 10);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tiempo de rafaga");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(100, 140, 80, 10);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ID Proceso");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(290, 140, 50, 10);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("ID Proceso");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(540, 360, 50, 10);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tiempo de rafaga");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(600, 360, 80, 10);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tiempo en salir");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(680, 360, 80, 10);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Prioridad");
        getContentPane().add(jLabel39);
        jLabel39.setBounds(280, 480, 80, 10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tiempo de rafaga");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(350, 140, 80, 10);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Prioridad");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(440, 140, 80, 10);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("LISTO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 120, 33, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("EN EJECUCIÓN");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 120, 90, 14);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(24, 549, 693, 2);

        jButtonIniciar.setText("INICIAR");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciar);
        jButtonIniciar.setBounds(250, 570, 100, 23);

        jLabel17.setBackground(new java.awt.Color(0, 51, 51));
        jLabel17.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Prioridad No Apropiativa");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(40, 10, 260, 46);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(28, 63, 650, 11);

        TxtArea_en_ejecucion.setEditable(false);
        TxtArea_en_ejecucion.setColumns(20);
        TxtArea_en_ejecucion.setRows(5);
        jScrollPane3.setViewportView(TxtArea_en_ejecucion);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(280, 150, 240, 290);

        TxtArea_Listo1.setEditable(false);
        TxtArea_Listo1.setColumns(20);
        TxtArea_Listo1.setRows(5);
        jScrollPane2.setViewportView(TxtArea_Listo1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 150, 240, 290);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("AGREGAR UN PROCESO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 460, 140, 14);

        TxtArea_Bloqueado.setEditable(false);
        TxtArea_Bloqueado.setColumns(20);
        TxtArea_Bloqueado.setRows(5);
        jScrollPane4.setViewportView(TxtArea_Bloqueado);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(530, 370, 240, 170);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("BLOQUEADO");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(610, 340, 67, 14);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("ID Proceso");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(70, 480, 50, 10);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(170, 480, 80, 10);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(60, 500, 70, 30);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ID Proceso");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(540, 140, 50, 10);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tiempo de rafaga");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(600, 140, 80, 10);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Tiempo en salir");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(680, 140, 80, 10);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(204, 204, 204));
        jLabel40.setText("SUSPENDIDO");
        getContentPane().add(jLabel40);
        jLabel40.setBounds(610, 120, 80, 14);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel41);
        jLabel41.setBounds(530, 100, 240, 50);

        TxtArea_Suspendido.setEditable(false);
        TxtArea_Suspendido.setColumns(20);
        TxtArea_Suspendido.setRows(5);
        jScrollPane5.setViewportView(TxtArea_Suspendido);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(530, 150, 240, 160);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel23);
        jLabel23.setBounds(40, 450, 240, 50);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel20);
        jLabel20.setBounds(280, 100, 240, 50);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel21);
        jLabel21.setBounds(30, 100, 240, 50);

        Pause.setText("Pause");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });
        getContentPane().add(Pause);
        Pause.setBounds(480, 570, 100, 23);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(150, 500, 110, 30);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(420, 490, 71, 23);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(280, 500, 100, 30);

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel37);
        jLabel37.setBounds(280, 500, 240, 40);

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel38);
        jLabel38.setBounds(40, 500, 240, 40);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel29);
        jLabel29.setBounds(530, 320, 240, 50);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel35);
        jLabel35.setBounds(280, 450, 240, 30);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel36);
        jLabel36.setBounds(40, 450, 240, 30);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/barra.png"))); // NOI18N
        getContentPane().add(jLabel31);
        jLabel31.setBounds(280, 450, 240, 50);

        jButton2.setText("D. GANTT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(370, 570, 90, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-1, 1, 790, 600);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Tiempo de Rafaga");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(170, 480, 80, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Timer timer = new Timer (800, new ActionListener (){ 
    public void actionPerformed(ActionEvent e){ 
        contuni=contuni+1;
        for(int i=0;i<100;i++){
                for(int j=0;j<4;j++){
                    a[i][j]=-1;                
                }
            }
        for(int i=0;i<m.length;i++){
            m[i]=-1;                
        }
        ordenar(Proc.nuevo, Proc.cab, Proc.p);
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
                Proc.nuevo.prioridad=Proc.nuevoS.prioridad;
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;                
                TxtArea_Listo1.setText("");
                ordenar(Proc.nuevo, Proc.cab, Proc.p);
                nuevo=Proc.p.sig;
                while(nuevo!=Proc.p){
                    String texto = "             "+nuevo.proceso + ".\t\t" + nuevo.tiempo;
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
                Proc.nuevo.prioridad=Proc.nuevoB.prioridad;
                Proc.cab.sig=Proc.nuevo;
                Proc.nuevo.sig=Proc.p; 
                Proc.cab=Proc.nuevo;                
                TxtArea_Listo1.setText("");
                nuevo=Proc.p.sig;                
                while(nuevo!=Proc.p){
                    String texto = nuevo.proceso + ".\t"+ nuevo.tiempo+ "\t"+ nuevo.prioridad;
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
        if(en_ejecucion!=null){
            comparar();
            if(en_ejecucion!=null){
                if(en_ejecucion.tiempo == 1){
                    en_ejecucion = null;                    
                }else{ 
                    if(aux==aux.sig){
                        TxtArea_en_ejecucion.setText("");
                    }else{
                        en_ejecucion.tiempo = en_ejecucion.tiempo - 1;
                        TxtArea_en_ejecucion.setText("");
                        TxtArea_en_ejecucion.append(en_ejecucion.proceso + ".\t"+ en_ejecucion.tiempo+ "\t"+ en_ejecucion.prioridad);                                                           
                     }
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
                        String texto = nuevo.proceso + ".\t"+ nuevo.tiempo+ "\t"+ nuevo.prioridad;
                        Interfaz.agregarTxtArea_Listo1(texto);
                        cont++;                       
                        nuevo=nuevo.sig;
                    } 
               if( en_ejecucion != Proc.p){                   
                   TxtArea_en_ejecucion.setText("");
                   TxtArea_en_ejecucion.append("\n"+en_ejecucion.proceso + ".\t"+ en_ejecucion.tiempo+ "\t"+ en_ejecucion.prioridad);                   
               }else{
                   en_ejecucion=null;
                   TxtArea_en_ejecucion.setText("");
               }
            
            }
        }
        if(Proc.p==Proc.p.sig){
           Proc.nuevo();
        }
        bloq =  (int) Math.round((Math.random()*20));
        if (bloq==1&&en_ejecucion!=null){
            if(TxtArea_Bloqueado.getText().equals("") && TxtArea_en_ejecucion.getText().equals("") && TxtArea_Listo1.getText().equals("")){}
            else{
                    Proc.nuevoB =new nodo();
                    Proc.nuevoB.proceso=en_ejecucion.proceso;
                    Proc.nuevoB.tiempo=en_ejecucion.tiempo;
                    Proc.nuevoB.prioridad=en_ejecucion.prioridad;
                    int x=0;
                    double y=0;
                    while (x<2){
                        y =  (((int) Math.round((Math.random()*100)))*(4))/100;
                        x = (int) y;
                    }
                    Proc.nuevoB.TBLOQ=x;
                    Proc.cabB.sig=Proc.nuevoB;
                    Proc.nuevoB.sig=Proc.pB; 
                    Proc.cabB=Proc.nuevoB;
                    en_ejecucion = null;
                    TxtArea_Bloqueado.append("\n"+Proc.nuevoB.proceso + ".\t" + Proc.nuevoB.tiempo + " \t " + Proc.nuevoB.TBLOQ + " ");                
                }
                 JOptionPane.showMessageDialog(null, "se bloqueo el proceso!!!");
            }                        
            TxtArea_Listo1.setText("");
        nuevo=Proc.p.sig;
        while(nuevo!=Proc.p){
            String texto = nuevo.proceso + ".\t"+ nuevo.tiempo+ "\t"+ nuevo.prioridad;
            Interfaz.agregarTxtArea_Listo1(texto);                   
            nuevo=nuevo.sig;
        }

        int contg=0;
        Proc.nuevo=Proc.p.sig;
        while(Proc.nuevo!=Proc.p){
            a[contg][0]=Proc.nuevo.proceso;
            Proc.nuevo=Proc.nuevo.sig;
            contg=contg+1;
        }
        Proc.nuevoB=Proc.pB.sig;
        while(Proc.nuevoB!=Proc.pB){
            a[contg][1]=Proc.nuevoB.proceso;            
            Proc.nuevoB=Proc.nuevoB.sig;
            contg=contg+1;
        }
        if(en_ejecucion!=null){
            a[contg][3]=en_ejecucion.proceso;                    
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
                  dataux = "LL"; 
                  dato[i-1]=dataux;
               }
               if(m[i]==1){
                  dataux = "BB"; 
                  dato[i-1]=dataux;
               }
               if(m[i]==2){
                  dataux = "SS"; 
                  dato[i-1]=dataux;
               }
               if(m[i]==3){
                  dataux = "EE"; 
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
    }); 
    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        if("".equals(TxtArea_Listo1.getText())){
            Proc = new Procesos();
            Proc.nuevo();
            Proc.nuevoBloqueado();
            Proc.nuevoSuspendido();
            Proc.Iniciar(); 
            ordenar(Proc.nuevo, Proc.cab, Proc.p);
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
            if(Integer.parseInt(jTextField4.getText())<=1000000 && 
               Integer.parseInt(jTextField4.getText())>0 &&
               Integer.parseInt(jTextField3.getText())<=1000000 &&
               Integer.parseInt(jTextField3.getText())>0&&
               Integer.parseInt(jTextField5.getText())<=1000000 &&
               Integer.parseInt(jTextField5.getText())>0){
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
                    Proc.nuevo.prioridad=Integer.parseInt(jTextField5.getText());
                    Proc.cab.sig=Proc.nuevo;
                    Proc.nuevo.sig=Proc.p; 
                    Proc.cab=Proc.nuevo;
                    TxtArea_Listo1.setText("");
                    nuevo=Proc.p.sig;
                    while(nuevo!=Proc.p){
                         String texto = nuevo.proceso + ".\t"+ nuevo.tiempo+ "\t"+ nuevo.prioridad;
                         Interfaz.agregarTxtArea_Listo1(texto);                                            
                         nuevo=nuevo.sig;
                     }
                     jTextField4.setText("");
                     jTextField3.setText("");
                     jTextField5.setText("");
               }
        }
        }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "solo se admiten numeros!!!");
                jTextField4.setText("");
                jTextField3.setText("");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Gantt.setVisible(true); 
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Gantt;
    private javax.swing.JButton Pause;
    public static javax.swing.JTextArea TxtArea_Bloqueado;
    public static javax.swing.JTextArea TxtArea_Listo1;
    public static javax.swing.JTextArea TxtArea_Suspendido;
    public static javax.swing.JTextArea TxtArea_en_ejecucion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
