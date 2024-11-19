import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends javax.swing.JFrame {

    
    private Administrador administrador;
    private InteligenciaArtificial ia;
    


    public Main() {
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        initComponents();
        
        administrador = new Administrador();
        ia = new InteligenciaArtificial();
        
        
        inicializarInterfaz(); 
        
        
    }
    
    public void iniciarSimulacion() {
        // Crear personajes manualmente (puedes ajustarlo como prefieras)
        crearPersonajes();
        
        // Simulación de batallas y actualización de colas por 10 rondas
        for (int i = 0; i < 10; i++) {
            
            
            administrador.gestionarSistema(ia);  // El Administrador gestiona las batallas
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
        administrador.mostrarEstadoColas();  // Llamamos al método para mostrar las colas
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IATextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AITextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Star Wars         VS     Star Treck");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inteligencia artificial:");

        IATextField.setBackground(new java.awt.Color(51, 51, 51));
        IATextField.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 12)); // NOI18N
        IATextField.setForeground(new java.awt.Color(255, 255, 255));
        IATextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IATextFieldActionPerformed(evt);
            }
        });

        AITextArea.setColumns(20);
        AITextArea.setRows(5);
        jScrollPane1.setViewportView(AITextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 225, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(IATextField)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void inicializarInterfaz() {
         Timer timer = new Timer(500, new ActionListener(){
         @Override
        // Establece el texto inicial del JTextField
        public void actionPerformed(ActionEvent e){
        IATextField.setText(administrador.mostrarEstadoColas());
        AITextArea.setText(administrador.mostrarEstadoColas());
    }}); timer.start();
                 }
    
    private void IATextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IATextFieldActionPerformed
        IATextField.setText(administrador.mostrarEstadoColas());
         AITextArea.setText(administrador.mostrarEstadoColas());
    }//GEN-LAST:event_IATextFieldActionPerformed

     

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AITextArea;
    private javax.swing.JTextField IATextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
