package gui;

import domain.Animal;
import static domain.Animal.registrosEmpadre;
import static domain.Cria.leerCrias;
import domain.Excel;
import static domain.Medicina.cargarCodigoMedicinas;
import static domain.Medicina.cargarMedicinas;
import static domain.Medicina.leerMedicinaAnimal;
import domain.ParametrosSP;
import domain.Tratamiento;
import static gui.Desktop.manejadorBD;
import static gui.Desktop.rancho;
import static gui.Splash.formatoDateTime;
import static gui.Login.gs_mensaje;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Developer GAGS
 */
public class HistorialPartos extends javax.swing.JFrame {

    /**
     * Creates new form MedicinasAnimal
     */
    public HistorialPartos(Animal aAnimal, Desktop parent) {
        
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(null);
        Image i = null;
        i = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/logo tru-test.png"));
        setIconImage(i);
        animal = aAnimal;
        cargarPartos();
        tf_TagID.setText(animal.arete_visual.toString());
        this.setTitle(this.getTitle() + " " + rancho.descripcion);
        cargarComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_Parto = new abstractt.Table();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_TagID = new javax.swing.JTextField();
        fondo1 = new abstractt.fondo();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        btn_DetalleCria = new abstractt.Boton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historial de Partos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(97, 84, 88));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(230, 225, 195));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Historial de Partos");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 80));

        jScrollPane2.setOpaque(false);

        t_Parto.setForeground(new java.awt.Color(230, 225, 195));
        t_Parto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_Parto.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        t_Parto.setOpaque(false);
        jScrollPane2.setViewportView(t_Parto);
        if (t_Parto.getColumnModel().getColumnCount() > 0) {
            t_Parto.getColumnModel().getColumn(0).setResizable(false);
            t_Parto.getColumnModel().getColumn(1).setResizable(false);
            t_Parto.getColumnModel().getColumn(2).setResizable(false);
            t_Parto.getColumnModel().getColumn(3).setResizable(false);
            t_Parto.getColumnModel().getColumn(4).setResizable(false);
            t_Parto.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 148, 640, 360));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 500, -1, 100));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(64, 37, 4));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Animal (ID Visual)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 150, 20));

        tf_TagID.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tf_TagID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TagID.setFocusable(false);
        tf_TagID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TagIDActionPerformed(evt);
            }
        });
        jPanel1.add(tf_TagID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 160, -1));

        fondo1.setText("fondo1");
        jPanel1.add(fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jPanel1.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 575, 20, 75));

        btn_DetalleCria.setText("Ver Detalles Cria");
        btn_DetalleCria.setToolTipText("Estatus de Registro de Empadre Actual");
        btn_DetalleCria.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_DetalleCria.setMaximumSize(new java.awt.Dimension(150, 30));
        btn_DetalleCria.setMinimumSize(new java.awt.Dimension(150, 30));
        btn_DetalleCria.setPreferredSize(new java.awt.Dimension(200, 30));
        btn_DetalleCria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DetalleCriaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_DetalleCria, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 190, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarPartos() {

        leerCrias(t_Parto, animal);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void btn_DetalleCriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DetalleCriaActionPerformed

        
        Animal cria  =new Animal();
        int fila;        
        
        fila = t_Parto.getSelectedRow();

        if (fila < 0) {

            JOptionPane.showMessageDialog(this, "Seleccione una Cria\n" + manejadorBD.errorSQL, gs_mensaje, JOptionPane.ERROR_MESSAGE);
            return;
        }

        cria.cargarPorId(this.t_Parto.getValueAt(fila, 8).toString());

        if (especificacionesAnimal != null) {

            especificacionesAnimal.dispose();
        }

        especificacionesAnimal = new EspecificacionesAnimal(parent);
        
        if (!cria.id_animal.equals("")) {

            especificacionesAnimal.setId_animal(cria.id_animal);
        }

        especificacionesAnimal.setVisible(true);        
    }//GEN-LAST:event_btn_DetalleCriaActionPerformed

    private void tf_TagIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TagIDActionPerformed
        
        cargarParto();
    }//GEN-LAST:event_tf_TagIDActionPerformed

    public void cargarParto() {
        
        leerCrias(t_Parto, animal);
    }

    private void cargarComponentes() {
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension pantallaTamano = tk.getScreenSize();
        fondo1.cargar(pantallaTamano);
        setResizable(false);
    }

    private String id_medicina_animal;
    private Animal animal;
    public EspecificacionesAnimal especificacionesAnimal;
    Desktop parent;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.Boton btn_DetalleCria;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    private abstractt.fondo fondo1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private abstractt.Table t_Parto;
    private javax.swing.JTextField tf_TagID;
    // End of variables declaration//GEN-END:variables
}
