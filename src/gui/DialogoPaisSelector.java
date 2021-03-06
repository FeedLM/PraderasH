/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Pais;
import domain.Pais;
import static gui.Desktop.rancho;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author sperez
 */
public class DialogoPaisSelector extends javax.swing.JFrame {

    Pais pais;

    /**
     * Creates new form DialogoProveedorSelector
     */
    public DialogoPaisSelector(java.awt.Frame parent, Pais aPais) {
//        super(parent, modal);
        initComponents();
        
        this.paisSelector1.cargar();
        pais = new Pais();
        paisSelector1.setSelectedItem(aPais.descripcion);
        setPais = false;
        
        Image i = null;
        i = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/logo tru-test.png"));
        setIconImage(i);

        this.setTitle(this.getTitle() + " " + rancho.descripcion);
        setLocationRelativeTo(null);
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
        paisSelector1 = new domain.PaisSelector();

        setTitle("Selecciona Pais");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        paisSelector1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisSelector1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(paisSelector1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(paisSelector1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPais(Pais pais) {
        setPais = true;
        this.paisSelector1.setSelectedItem(pais.descripcion);
        setPais = false;
    }

    
    public Pais getPais(){
        
        return paisSelector1.getPais();
    }

    private void paisSelector1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisSelector1ActionPerformed
        if (!setPais) {
            
            this.setVisible(false);
        }
    }//GEN-LAST:event_paisSelector1ActionPerformed

    boolean setPais;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private domain.PaisSelector paisSelector1;
    // End of variables declaration//GEN-END:variables
}
