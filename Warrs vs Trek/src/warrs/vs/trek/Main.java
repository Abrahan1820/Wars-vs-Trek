import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends javax.swing.JFrame {

    
    private Administrador administrador;
    private InteligenciaArtificial ia;
    


    public Main() {
        
        
        this.setVisible(true);
        initComponents();
        
         // Añadir los oyentes de eventos
    btnAumentar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAumentarActionPerformed(evt);
        }
    });

    btnDisminuir.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDisminuirActionPerformed(evt);
        }
    });
    
    

        
        
        administrador = new Administrador();
        ia = new InteligenciaArtificial();
        
        
        inicializarInterfaz(); 
        
        
    }
    
    public void iniciarSimulacion() {
        // Crear personajes manualmente (puedes ajustarlo como prefieras)
        crearPersonajes();
        
        // Simulación de batallas y actualización de colas por 10 rondas
        for (int i = 0; i < 10; i++) {
            
            
            administrador.gestionarSistema(ia, IAT);  // El Administrador gestiona las batallas
            mostrarEstadoColas();  // Imprimir el estado de las colas después de la ronda''
            
        }
        
        
    }
    
    // Método para crear personajes manualmente y agregarlos a las colas
    private void crearPersonajes() {
        // Agregar personajes de Star Wars
        administrador.agregarPersonaje("Star Wars", "Han Solo", 2, 75, 85, 70, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Darth Vader", 3, 100, 80, 60, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Luke Skywalker", 1, 95, 90, 80, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Princess Leia", 2, 70, 75, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Yoda", 3, 85, 60, 95, 100, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Obi-Wan Kenobi", 1, 90, 80, 75, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Chewbacca", 2, 85, 90, 70, 75, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "R2-D2", 3, 60, 70, 95, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "C-3PO", 2, 50, 60, 90, 70, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Boba Fett", 3, 80, 90, 70, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Anakin Skywalker", 1, 95, 90, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Lando Calrissian", 2, 80, 75, 70, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Qui-Gon Jinn", 3, 85, 80, 75, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Jango Fett", 2, 90, 85, 70, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Ahsoka Tano", 1, 80, 90, 85, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Rey", 2, 85, 80, 90, 75, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Kylo Ren", 3, 95, 75, 80, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Emperor Palpatine", 1, 100, 70, 60, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Mace Windu", 2, 90, 80, 85, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Darth Maul", 3, 95, 85, 70, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "General Grievous", 2, 90, 70, 80, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Count Dooku", 3, 85, 60, 75, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Padmé Amidala", 2, 70, 75, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Jar Jar Binks", 3, 60, 65, 50, 60, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Mon Mothma", 1, 80, 70, 75, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Wars", "Wedge Antilles", 2, 80, 75, 85, 90, Math.random() + 0.5);
        
        // Agregar personajes de Star Trek
        administrador.agregarPersonaje("Star Trek", "James T. Kirk", 1, 85, 80, 70, 75, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Spock", 2, 80, 85, 75, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Worf", 3, 90, 70, 80, 60, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Leonard McCoy", 2, 75, 70, 65, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Scotty", 1, 80, 75, 90, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Uhura", 2, 70, 80, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Sulu", 3, 75, 85, 80, 70, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Chekov", 1, 80, 70, 75, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Data", 2, 90, 90, 85, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Geordi La Forge", 3, 85, 80, 90, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Beverly Crusher", 1, 75, 80, 85, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Deanna Troi", 2, 70, 75, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Will Riker", 3, 90, 85, 75, 80, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Jean-Luc Picard", 1, 95, 90, 80, 85, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Q", 2, 100, 75, 60, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Guinan", 3, 70, 80, 85, 75, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Lore", 1, 90, 85, 80, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Borg Queen", 2, 95, 80, 85, 70, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Khan Noonien Singh", 1, 100, 95, 85, 90, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Seven of Nine", 2, 85, 90, 80, 95, Math.random() + 0.5);
        administrador.agregarPersonaje("Star Trek", "Tasha Yar", 3, 70, 75, 65, 80, Math.random() + 0.5);
    }

    // Método para mostrar el estado de las colas
    private void mostrarEstadoColas() {
        System.out.println("\nEstado de las colas:");
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
        Titulo = new javax.swing.JLabel();
        Prioridad1SW = new javax.swing.JLabel();
        ScrollPane1 = new javax.swing.JScrollPane();
        Prioridad1SWT = new javax.swing.JTextArea();
        Prioridad2SW = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Prioridad2SWT = new javax.swing.JTextArea();
        Prioridad3SW = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Prioridad4SWT = new javax.swing.JTextArea();
        Prioridad4SW = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Prioridad3SWT = new javax.swing.JTextArea();
        Prioridad1ST = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Prioridad1STT = new javax.swing.JTextArea();
        Prioridad2ST = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Prioridad2STT = new javax.swing.JTextArea();
        Prioridad3ST = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Prioridad3STT = new javax.swing.JTextArea();
        Prioridad4ST = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Prioridad4STT = new javax.swing.JTextArea();
        Time = new java.awt.Label();
        label1 = new java.awt.Label();
        btnDisminuir = new javax.swing.JButton();
        btnAumentar = new javax.swing.JButton();
        IA = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IAT = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        Titulo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Star Wars         VS     Star Treck");

        Prioridad1SW.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Prioridad1SW.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad1SW.setText("Prioridad 1");

        Prioridad1SWT.setEditable(false);
        Prioridad1SWT.setColumns(20);
        Prioridad1SWT.setRows(5);
        Prioridad1SWT.setAutoscrolls(false);
        Prioridad1SWT.setRequestFocusEnabled(false);
        ScrollPane1.setViewportView(Prioridad1SWT);

        Prioridad2SW.setBackground(new java.awt.Color(51, 51, 51));
        Prioridad2SW.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Prioridad2SW.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad2SW.setText("Prioridad 2");

        Prioridad2SWT.setColumns(20);
        Prioridad2SWT.setRows(5);
        Prioridad2SWT.setAutoscrolls(false);
        jScrollPane2.setViewportView(Prioridad2SWT);

        Prioridad3SW.setBackground(new java.awt.Color(51, 51, 51));
        Prioridad3SW.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Prioridad3SW.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad3SW.setText("Prioridad 3");

        Prioridad4SWT.setColumns(20);
        Prioridad4SWT.setRows(5);
        Prioridad4SWT.setAutoscrolls(false);
        jScrollPane3.setViewportView(Prioridad4SWT);

        Prioridad4SW.setBackground(new java.awt.Color(51, 51, 51));
        Prioridad4SW.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Prioridad4SW.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad4SW.setText("Reserva");

        Prioridad3SWT.setColumns(20);
        Prioridad3SWT.setRows(5);
        Prioridad3SWT.setAutoscrolls(false);
        jScrollPane4.setViewportView(Prioridad3SWT);

        Prioridad1ST.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Prioridad1ST.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad1ST.setText("Prioridad 1");

        Prioridad1STT.setEditable(false);
        Prioridad1STT.setColumns(20);
        Prioridad1STT.setRows(5);
        Prioridad1STT.setAutoscrolls(false);
        jScrollPane5.setViewportView(Prioridad1STT);

        Prioridad2ST.setBackground(new java.awt.Color(51, 51, 51));
        Prioridad2ST.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Prioridad2ST.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad2ST.setText("Prioridad 2");

        Prioridad2STT.setColumns(20);
        Prioridad2STT.setRows(5);
        Prioridad2STT.setAutoscrolls(false);
        jScrollPane6.setViewportView(Prioridad2STT);

        Prioridad3ST.setBackground(new java.awt.Color(51, 51, 51));
        Prioridad3ST.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Prioridad3ST.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad3ST.setText("Prioridad 3");

        Prioridad3STT.setColumns(20);
        Prioridad3STT.setRows(5);
        Prioridad3STT.setAutoscrolls(false);
        jScrollPane7.setViewportView(Prioridad3STT);

        Prioridad4ST.setBackground(new java.awt.Color(51, 51, 51));
        Prioridad4ST.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Prioridad4ST.setForeground(new java.awt.Color(255, 255, 255));
        Prioridad4ST.setText("Reserva");

        Prioridad4STT.setColumns(20);
        Prioridad4STT.setRows(5);
        Prioridad4STT.setAutoscrolls(false);
        jScrollPane8.setViewportView(Prioridad4STT);
        Prioridad4STT.getAccessibleContext().setAccessibleParent(jPanel1);

        Time.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setName(""); // NOI18N
        Time.setText("Tiempo (segs)");

        label1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setName("time"); // NOI18N
        label1.setText("1");

        btnDisminuir.setText("-");

        btnAumentar.setText("+");

        IA.setBackground(new java.awt.Color(51, 51, 51));
        IA.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        IA.setForeground(new java.awt.Color(255, 255, 255));
        IA.setText("IA");

        IAT.setColumns(20);
        IAT.setRows(5);
        jScrollPane1.setViewportView(IAT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Prioridad2SW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Prioridad1SW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Prioridad4SW)
                            .addComponent(Prioridad3SW))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Prioridad2ST)
                            .addComponent(Prioridad3ST)
                            .addComponent(Prioridad4ST))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(Prioridad1ST)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisminuir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(IA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDisminuir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnAumentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Prioridad1ST)
                    .addComponent(Prioridad1SW)
                    .addComponent(ScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Prioridad2SW))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Prioridad2ST))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(Prioridad3SW))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Prioridad3ST))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Prioridad4SW))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Prioridad4ST))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(IA)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void inicializarInterfaz() {
        
         
         
         Timer timer = new Timer(500, new ActionListener(){
             
         
         @Override
        // Establece el texto inicial del JTextField
        public void actionPerformed(ActionEvent e){
        Prioridad1SWT.setText(administrador.mostrarEstadoColaStarWars(0));
        Prioridad2SWT.setText(administrador.mostrarEstadoColaStarWars(1));
        Prioridad3SWT.setText(administrador.mostrarEstadoColaStarWars(2));
        Prioridad4SWT.setText(administrador.mostrarEstadoColaStarWars(3));
        
        Prioridad1STT.setText(administrador.mostrarEstadoColaStarTrek(0));
        Prioridad2STT.setText(administrador.mostrarEstadoColaStarTrek(1));
        Prioridad3STT.setText(administrador.mostrarEstadoColaStarTrek(2));
        Prioridad4STT.setText(administrador.mostrarEstadoColaStarTrek(3));
        
    }}); timer.start();
                 }
    
     

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
         Main simulador = new Main();
        simulador.iniciarSimulacion();
          
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
               
            }
        });
    }
    
        private void btnAumentarActionPerformed(java.awt.event.ActionEvent evt) {
    // Aumentar la velocidad de las rondas
    Administrador.velocidadRondas += 1;  // Aumentar la velocidad, puedes ajustar el valor según lo necesites
}

private void btnDisminuirActionPerformed(java.awt.event.ActionEvent evt) {
    // Disminuir la velocidad de las rondas (no permitir valores negativos si es necesario)
    if (Administrador.velocidadRondas > 0) {
        Administrador.velocidadRondas -= 1;  // Disminuir la velocidad
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IA;
    private javax.swing.JTextArea IAT;
    private javax.swing.JLabel Prioridad1ST;
    private javax.swing.JTextArea Prioridad1STT;
    private javax.swing.JLabel Prioridad1SW;
    private javax.swing.JTextArea Prioridad1SWT;
    private javax.swing.JLabel Prioridad2ST;
    private javax.swing.JTextArea Prioridad2STT;
    private javax.swing.JLabel Prioridad2SW;
    private javax.swing.JTextArea Prioridad2SWT;
    private javax.swing.JLabel Prioridad3ST;
    private javax.swing.JTextArea Prioridad3STT;
    private javax.swing.JLabel Prioridad3SW;
    private javax.swing.JTextArea Prioridad3SWT;
    private javax.swing.JLabel Prioridad4ST;
    private javax.swing.JTextArea Prioridad4STT;
    private javax.swing.JLabel Prioridad4SW;
    private javax.swing.JTextArea Prioridad4SWT;
    private javax.swing.JScrollPane ScrollPane1;
    private java.awt.Label Time;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnAumentar;
    private javax.swing.JButton btnDisminuir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
