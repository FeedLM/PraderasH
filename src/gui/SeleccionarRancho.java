/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.Desktop.manejadorBD;
import static gui.Desktop.rancho;
import static gui.Login.gs_mensaje;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author angelesygil
 */
public class SeleccionarRancho extends javax.swing.JFrame {

    /**
     * Creates new form SelecionarRancho
     */
    public SeleccionarRancho() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        Image i = null;
        i = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/logo tru-test.png"));
        setIconImage(i);
        // setLocationRelativeTo(null);
        ranchoSelector1.cargar();
        jPanel2.setOpaque(false);
        cargarcomponentes();
    }

    public void cargarcomponentes() {

        Dimension pantallaTamano = jPanel1.getSize();

        jPanel2.setLocation((pantallaTamano.width / 2) - (jPanel2.getWidth() / 2), (pantallaTamano.height / 2) - (jPanel2.getHeight() / 2));

        plecaAdministrarFinca1.setLocation((pantallaTamano.width / 2) - (plecaAdministrarFinca1.getWidth() / 2), 0);

        System.out.println("aqui");
        this.fondo1.cargar(pantallaTamano);
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
        jPanel2 = new javax.swing.JPanel();
        etiqueta1 = new abstractt.Etiqueta();
        btn_aceptar = new abstractt.Boton();
        btn_nueva = new abstractt.Boton();
        ranchoSelector1 = new domain.RanchoSelector();
        plecaAdministrarFinca1 = new abstractt.PlecaAdministrarFinca();
        fondo1 = new abstractt.fondo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccion de Rancho / Finca");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        etiqueta1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta1.setText("Seleccionar Finca:");
        etiqueta1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jPanel2.add(etiqueta1);
        etiqueta1.setBounds(0, 45, 280, 20);

        btn_aceptar.setText("Aceptar");
        btn_aceptar.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_aceptar);
        btn_aceptar.setBounds(150, 105, 150, 30);

        btn_nueva.setText("Nueva Finca");
        btn_nueva.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_nueva);
        btn_nueva.setBounds(350, 105, 150, 30);

        ranchoSelector1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        ranchoSelector1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ranchoSelector1ActionPerformed(evt);
            }
        });
        jPanel2.add(ranchoSelector1);
        ranchoSelector1.setBounds(300, 40, 200, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 270, 600, 180);
        jPanel1.add(plecaAdministrarFinca1);
        plecaAdministrarFinca1.setBounds(0, 0, 1234, 79);

        fondo1.setText("fondo1");
        jPanel1.add(fondo1);
        fondo1.setBounds(0, 90, 210, 110);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void ranchoSelector1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ranchoSelector1ActionPerformed

    }//GEN-LAST:event_ranchoSelector1ActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        seleccionaRancho();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void btn_nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevaActionPerformed
        nuevoRancho();
        //  cargarcomponentes();
        //System.out.println("1");
        ranchoSelector1.cargar();
        //System.out.println("2");
        //cargarcomponentes();

    }//GEN-LAST:event_btn_nuevaActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        cargarcomponentes();

    }//GEN-LAST:event_formComponentResized

    public void cargarRanchos() {
        ranchoSelector1.cargar();
    }

    private void nuevoRancho() {
        administracionRanchos = new AdministracionRanchos(this);
        administracionRanchos.setVisible(true);
        this.dispose();
    }

    private void seleccionaRancho() {

        desktop = new Desktop();

        rancho.cargarPorDescripcion(this.ranchoSelector1.getSelectedItem().toString());

        if (rancho.id_rancho.equals("")) {

            JOptionPane.showMessageDialog(this, "Seleccione un Rancho/Finca para Continuar\n" + manejadorBD.errorSQL, gs_mensaje, JOptionPane.ERROR_MESSAGE);
            return;

        }

        setVisible(false);

        desktop.setVisible(true);
        desktop.cargarTitulo();
    }

    private Desktop desktop;
    private AdministracionRanchos administracionRanchos;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.Boton btn_aceptar;
    private abstractt.Boton btn_nueva;
    private abstractt.Etiqueta etiqueta1;
    private abstractt.fondo fondo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private abstractt.PlecaAdministrarFinca plecaAdministrarFinca1;
    private domain.RanchoSelector ranchoSelector1;
    // End of variables declaration//GEN-END:variables
}
