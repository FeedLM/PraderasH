/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Animal;
import static domain.Animal.animalSementales;
import domain.SR232;
import static gui.Desktop.rancho;
import static gui.Desktop.manejadorBD;
import static gui.Login.gs_mensaje;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Developer GAGS
 */
public class Sementales extends javax.swing.JFrame {

    /**
     * Creates new form SalidaGanado
     */
    public Sementales(Desktop parent) {
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(null);

        animal = new Animal();

        cargarPuertos();

        stick = new SR232(puertoStick, 1, parent ,8);

        stick.setEID(tf_Eid);

        stick.start();

        cargarAnimales();

        this.setTitle(this.getTitle() + " " + rancho.descripcion);

        Image i = null;
        i = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/logo tru-test.png"));
        setIconImage(i);

        animalSelector.cargarTagsIdsSementales();
        
        fondo1.cargar(getSize());
        
        setResizable(false);
        
        t_animales.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                Integer row = table.rowAtPoint(p);
                if (me.getClickCount() == 1) {

                    seleccionaAnimal(row);
                }
            }
        });
    }
    
     public void seleccionaAnimal(Integer fila) {

        int opcion;

        if (fila >= 0) {
               this.animalSelector.setSelectedItem(this.t_animales.getValueAt(fila, 1).toString());
           
        } 
    }

    public void cargarPuertos() {

        manejadorBD.consulta(
                "SELECT puerto_baston, puerto_bascula "
                + "FROM configuracion ");

        if (manejadorBD.getRowCount() > 0) {

            puertoStick = manejadorBD.getValorString(0, 0);
            puertoBascula = manejadorBD.getValorString(0, 1);
        }
    }

    String puertoStick, puertoBascula;
    private SR232 stick;
    private Integer idClaseMovimiento;
    private Integer id_destino;

    public void cargarAnimales() {

        t_animales = animalSementales(t_animales);

        if (t_animales.getRowCount() > 0) {

            btn_detalles.setEnabled(true);
            btn_emparejar.setEnabled(true);
        } else {

            btn_detalles.setEnabled(false);
            btn_emparejar.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_Eid = new abstractt.TextField();
        animalSelector = new domain.AnimalSelector();
        btn_detalles = new abstractt.Boton();
        btn_emparejar = new abstractt.Boton();
        tf_areteSiniiga = new abstractt.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_animales = new abstractt.Table();
        etiqueta1 = new abstractt.Etiqueta();
        fondo1 = new abstractt.fondo();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sementales");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(95, 84, 88));
        jLabel2.setText("Arete Visual:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 20));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(95, 84, 88));
        jLabel3.setText("Arete Electronico:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 20));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(95, 84, 88));
        jLabel4.setText("Arete Siniiga:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 20));

        tf_Eid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_Eid.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tf_Eid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_EidFocusLost(evt);
            }
        });
        tf_Eid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_EidActionPerformed(evt);
            }
        });
        jPanel4.add(tf_Eid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 200, 20));

        animalSelector.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        animalSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalSelectorActionPerformed(evt);
            }
        });
        jPanel4.add(animalSelector, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 200, 20));

        btn_detalles.setText("Detalles");
        btn_detalles.setFont(new java.awt.Font("Trebuchet", 1, 12)); // NOI18N
        btn_detalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detallesActionPerformed(evt);
            }
        });
        jPanel4.add(btn_detalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 200, 30));

        btn_emparejar.setText("Emparejar");
        btn_emparejar.setFont(new java.awt.Font("Trebuchet", 1, 12)); // NOI18N
        btn_emparejar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_emparejarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_emparejar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 200, 30));

        tf_areteSiniiga.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        tf_areteSiniiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_areteSiniigaActionPerformed(evt);
            }
        });
        jPanel4.add(tf_areteSiniiga, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 200, 20));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1000, 90));

        t_animales.setForeground(new java.awt.Color(230, 225, 195));
        t_animales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        t_animales.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(t_animales);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1000, 300));

        etiqueta1.setBackground(new java.awt.Color(95, 84, 88));
        etiqueta1.setForeground(new java.awt.Color(230, 225, 195));
        etiqueta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta1.setText("Sementales");
        etiqueta1.setFont(new java.awt.Font("Trebuchet", 1, 48)); // NOI18N
        etiqueta1.setOpaque(true);
        jPanel3.add(etiqueta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        fondo1.setText("fondo1");
        jPanel3.add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDatosTag() {

        tf_Eid.setText(animal.arete_electronico);

        tf_areteSiniiga.setText(animal.arete_siniiga);

        this.t_animales.buscar(animal.arete_electronico, 2, jScrollPane2);
    }

    public void setEid(String eid) {

        animal.cargarPorEid(eid);

        this.tf_Eid.setText(animal.arete_electronico);

        animalSelector.setSelectedItem(animal.arete_visual);
        tf_areteSiniiga.setText(animal.arete_siniiga);
    }

    public void cargarDatosEid() {

        animal.cargarPorEid(this.tf_Eid.getText());
        animalSelector.setSelectedItem(animal.arete_visual);
        tf_areteSiniiga.setText(animal.arete_siniiga);
    }

    public void cargarDatosSiniiga() {

        animal.cargarPorAreteSiniiga(this.tf_areteSiniiga.getText());

        tf_Eid.setText(animal.arete_electronico);
        animalSelector.setSelectedItem(animal.arete_visual);
    }

    private void tf_EidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_EidFocusLost

        if (true) {

            return;
        }
        eid = tf_Eid.getText();
        cargarDatosEid();
    }//GEN-LAST:event_tf_EidFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.administracionAnimales.setVisible(true);
        this.stick.setSeguir(false);
    }//GEN-LAST:event_formWindowClosing

    private void tf_EidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_EidActionPerformed

        cargarDatosEid();
    }//GEN-LAST:event_tf_EidActionPerformed

    private void animalSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalSelectorActionPerformed

        animal.cargarPorAreteVisual(animalSelector.getSelectedItem().toString(), "A");
        cargarDatosTag();
    }//GEN-LAST:event_animalSelectorActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

        if (!stick.isSeguir()) {

            stick = new SR232(puertoStick, 1, parent, 8);
            stick.setEID(tf_Eid);
            stick.start();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        //stick.setSeguir(false);
    }//GEN-LAST:event_formWindowLostFocus

    private void btn_detallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detallesActionPerformed

        int fila;

        if (especificacionesAnimal != null) {

            especificacionesAnimal.dispose();
        }

        especificacionesAnimal = new EspecificacionesAnimal(parent);

        fila = t_animales.getSelectedRow();

        if (fila < 0) {

            JOptionPane.showMessageDialog(this, "Seleccione un Animal\n" + manejadorBD.errorSQL, gs_mensaje, JOptionPane.ERROR_MESSAGE);
            return;
        }

        animal.cargarPorId(this.t_animales.getValueAt(fila, 0).toString());

        if (!animal.id_animal.equals("")) {

            especificacionesAnimal.setId_animal(animal.id_animal);
        }

        especificacionesAnimal.setVisible(true);
    }//GEN-LAST:event_btn_detallesActionPerformed

    private void btn_emparejarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_emparejarActionPerformed

         int fila;
        
        fila = t_animales.getSelectedRow();

        if (fila < 0) {

            JOptionPane.showMessageDialog(this, "Seleccione un Animal\n" + manejadorBD.errorSQL, gs_mensaje, JOptionPane.ERROR_MESSAGE);
            return;
        }

        animal.cargarPorId(this.t_animales.getValueAt(fila, 0).toString());
        
        
        stick.setSeguir(false);

        emparejamiento = new Emparejamiento(parent, animal);
        emparejamiento.setVisible(true);

    }//GEN-LAST:event_btn_emparejarActionPerformed

    private void tf_areteSiniigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_areteSiniigaActionPerformed
        cargarDatosSiniiga();
    }//GEN-LAST:event_tf_areteSiniigaActionPerformed

    Desktop parent;
    public Emparejamiento emparejamiento;
    public EspecificacionesAnimal especificacionesAnimal;
    private Integer id_animal;
    private Integer id_corral;
    private String numeroPedido;
    private String corral, eid;
    private String arete_siniiga;
    private Double peso_actual;
    private Animal animal;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private domain.AnimalSelector animalSelector;
    private abstractt.Boton btn_detalles;
    private abstractt.Boton btn_emparejar;
    private abstractt.Etiqueta etiqueta1;
    private abstractt.fondo fondo1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private abstractt.Table t_animales;
    private abstractt.TextField tf_Eid;
    private abstractt.TextField tf_areteSiniiga;
    // End of variables declaration//GEN-END:variables
}
